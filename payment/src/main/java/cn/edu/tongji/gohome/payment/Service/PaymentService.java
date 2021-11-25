package
        cn.edu.tongji.gohome.payment.Service;

import cn.edu.tongji.gohome.payment.Dto.OrderPaymentInfo;
import cn.edu.tongji.gohome.payment.config.AlipayConfig;
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

import java.util.HashMap;
import java.util.Iterator;
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

    public AlipayTradePagePayResponse payForOrderService(OrderPaymentInfo orderPaymentInfo) throws AlipayApiException {
        // create a default alipay client...
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY,
                "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayTradePagePayRequest.setNotifyUrl(AlipayConfig.notify_url);

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", String.valueOf(orderPaymentInfo.getOrderId()));
        bizContent.put("refund_amount", String.valueOf(orderPaymentInfo.getTotalCost()));
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
        bizContent.put("subject", orderPaymentInfo.getOrderName());
        //bizContent.put("body", orderPaymentInfo.getOrderInfo());
        bizContent.put("trade_no", String.valueOf(YitIdHelper.nextId()));

        alipayTradeRefundRequest.setBizContent(bizContent.toString());

        return alipayClient.pageExecute(alipayTradeRefundRequest);
    }

    public boolean orderNotify(Map<String,String[]> requestParams) throws AlipayApiException {

        Map<String,String> map = new HashMap<>();
        if(requestParams.isEmpty()){
            return false;
        }
        for (String name : requestParams.keySet()) {
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            map.put(name, valueStr);
        }
        // 验签
        return AlipaySignature.rsaCheckV1(map, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET,
                AlipayConfig.sign_type);
    }
}