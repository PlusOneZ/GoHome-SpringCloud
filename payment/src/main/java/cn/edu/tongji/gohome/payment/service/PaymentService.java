package
        cn.edu.tongji.gohome.payment.service;

import cn.edu.tongji.gohome.payment.dto.AlipyNotifyParam;
import cn.edu.tongji.gohome.payment.dto.OrderPaymentInfo;
import cn.edu.tongji.gohome.payment.config.AlipayConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * class description
 *
 * @author : loey
 * @className : PaymentService
 * @since : 2021-11-24 22:12
 **/
@Service
public class PaymentService {

    @Resource
    private RestTemplate restTemplate;

    public AlipayTradePagePayResponse payForOrderService(OrderPaymentInfo orderPaymentInfo) throws AlipayApiException {
        // create a default alipay client...
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY,
                "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayTradePagePayRequest.setNotifyUrl(AlipayConfig.notify_url);

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", String.valueOf(orderPaymentInfo.getOrderId()));
        bizContent.put("total_amount", String.valueOf(orderPaymentInfo.getTotalCost()));
        bizContent.put("subject", orderPaymentInfo.getOrderName());
        //bizContent.put("body", orderPaymentInfo.getOrderInfo());
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        //bizContent.put("timeout_express", "1c");

        alipayTradePagePayRequest.setBizContent(bizContent.toString());

        System.out.println(alipayTradePagePayRequest.getBizContent());

        return alipayClient.pageExecute(alipayTradePagePayRequest);
    }

    public AlipayTradeRefundResponse refundForOrderService(OrderPaymentInfo orderPaymentInfo) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.APP_ID,
                AlipayConfig.APP_PRIVATE_KEY,
                "json",
                AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY,
                AlipayConfig.sign_type
        );

        AlipayTradeRefundRequest alipayTradeRefundRequest = new AlipayTradeRefundRequest();

        JSONObject bizContent = new JSONObject();

        bizContent.put("out_trade_no", String.valueOf(orderPaymentInfo.getOrderId()));
        bizContent.put("refund_amount", String.valueOf(orderPaymentInfo.getTotalCost()));
        bizContent.put("refund_reason", orderPaymentInfo.getOrderName());
        bizContent.put("trade_no","");
        //bizContent.put("body", orderPaymentInfo.getOrderInfo());
        System.out.println(bizContent.toString());
        alipayTradeRefundRequest.setBizContent(bizContent.toString());

        return alipayClient.pageExecute(alipayTradeRefundRequest);
    }

    public String orderNotify(Map<String, String[]> requestParams) throws AlipayApiException {

        Map<String, String> map = new HashMap<>();
        if (requestParams.isEmpty()) {
            return "failure";
        }
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            map.put(name, valueStr);
        }
        // ??????
        boolean signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET,
                AlipayConfig.sign_type);

        if (signVerified) {
            System.out.println("?????????????????????????????????");
            // ??????????????????response?????????success?????????????????????failure
            String mapJson = JSON.toJSONString(map);
            AlipyNotifyParam param = JSON.parseObject(mapJson,AlipyNotifyParam.class);
            String trade_status = param.getTradeStatus();
            // ????????????
            if (trade_status.equals("TRADE_SUCCESS")
                    || trade_status.equals("TRADE_FINISHED")) {
                // ????????????????????????
                try {
                    //??????????????????????????????
                    String outTradeNo = param.getOutTradeNo();
                    System.out.println("?????????outTradeNo???: "+outTradeNo);
                    restTemplate.postForEntity("http://trade-service/api/v1/trade/payment/callback",Long.parseLong(outTradeNo),String.class);
                    System.out.println("?????????????????????????????????????????????");
                } catch (Exception e) {
                    System.out.println("?????????????????????????????????,params:" + param);
                }
            } else {
                System.out.println("????????????????????????????????????????????????????????????" + trade_status + "params:" + param);
            }
            return "success";
        }
        return "failure";
    }
}