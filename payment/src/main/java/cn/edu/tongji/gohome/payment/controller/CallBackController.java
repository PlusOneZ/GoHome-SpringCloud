package
        cn.edu.tongji.gohome.payment.controller;

import cn.edu.tongji.gohome.payment.service.PaymentService;
import com.alipay.api.AlipayApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * class description
 *
 * @author : loey
 * @className : CallBackController
 * @since : 2021-11-27 21:04
 **/
@Controller
public class CallBackController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "notify",method = RequestMethod.POST)
    public ResponseEntity<String> notifyOrder(HttpServletRequest httpServletRequest) throws AlipayApiException {

        Map<String,String[]> requestParams = httpServletRequest.getParameterMap();
        String result = paymentService.orderNotify(requestParams);
        // 验签通过
        return new ResponseEntity<String>(result, HttpStatus.OK);

    }
}