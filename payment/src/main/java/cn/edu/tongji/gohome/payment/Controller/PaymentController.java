package
        cn.edu.tongji.gohome.payment.Controller;

import cn.edu.tongji.gohome.payment.Dto.OrderPaymentInfo;
import cn.edu.tongji.gohome.payment.Service.PaymentService;
import cn.edu.tongji.gohome.payment.config.AlipayConfig;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "payment", method = RequestMethod.POST)
    public String alipayForOrder(@RequestBody OrderPaymentInfo orderPaymentInfo) throws AlipayApiException {

        AlipayTradePagePayResponse response = paymentService.payForOrderService(orderPaymentInfo);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response.getBody();
    }

    @RequestMapping(value = "refund", method = RequestMethod.POST)
    public String refundOrder(@RequestBody OrderPaymentInfo orderPaymentInfo) throws AlipayApiException {

        AlipayTradeRefundResponse response = paymentService.refundForOrderService(orderPaymentInfo);

        if (response.isSuccess()) {
            System.out.println("退款成功");
        } else {
            System.out.println("退款失败");
        }
        return response.getBody();
    }

}