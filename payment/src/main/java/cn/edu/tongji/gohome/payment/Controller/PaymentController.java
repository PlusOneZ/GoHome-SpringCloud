package
        cn.edu.tongji.gohome.payment.Controller;

import cn.edu.tongji.gohome.payment.Dto.OrderPaymentInfo;
import cn.edu.tongji.gohome.payment.config.AlipayConfig;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import org.springframework.web.bind.annotation.*;

/**
 * The controller contains payment APIs...
 *
 * @author : loey
 * @className : PaymentController
 * @since : 2021-11-24 18:21
 **/
@RestController
@RequestMapping("api/v1")
public class PaymentController {

    @RequestMapping(value = "payment", method = RequestMethod.GET)
    public String alipayForOrder(
            @RequestParam String outTradeNo,
            @RequestParam String totalAmount,
            @RequestParam String subject,
            @RequestParam String body) throws AlipayApiException {

        // create a default alipay client...
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY,
                "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);

        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayTradePagePayRequest.setNotifyUrl(AlipayConfig.notify_url);

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no",outTradeNo);
        bizContent.put("total_amount",totalAmount);
        bizContent.put("subject",subject);
        bizContent.put("body",body);
        bizContent.put("product_code","FAST_INSTANT_TRADE_PAY");
        bizContent.put("timeout_express","1c");

        alipayTradePagePayRequest.setBizContent(bizContent.toString());

        System.out.println(alipayTradePagePayRequest.getBizContent());

        AlipayTradePagePayResponse response =  alipayClient.pageExecute(alipayTradePagePayRequest);
        if(response.isSuccess()){
            System.out.println("调用成功");
        }
        else{
            System.out.println("调用失败");
        }
        return response.getBody();
    }

    
}