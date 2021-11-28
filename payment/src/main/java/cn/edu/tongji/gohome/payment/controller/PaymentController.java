package
        cn.edu.tongji.gohome.payment.controller;

import cn.edu.tongji.gohome.payment.dto.AlipyNotifyParam;
import cn.edu.tongji.gohome.payment.dto.OrderPaymentInfo;
import cn.edu.tongji.gohome.payment.service.PaymentService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @Resource
    private RestTemplate restTemplate;

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