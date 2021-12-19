package
        cn.edu.tongji.gohome.trade.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.trade.dto.OrderInfoDto;
import cn.edu.tongji.gohome.trade.dto.OrderPaymentInfo;
import cn.edu.tongji.gohome.trade.dto.ReOrderInfoDto;
import cn.edu.tongji.gohome.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * Integrate basic order and payment microservices to achieve a complete transaction process...
 *
 * @author : loey
 * @className : TradeController
 * @since : 2021-11-25 23:04
 **/
@RestController
@RequestMapping("api/v1")
public class TradeController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private TradeService tradeService;

    @RequestMapping(value = "trade/order",method = RequestMethod.POST)
    public ResponseEntity<String> tradeForOrder(@RequestBody OrderInfoDto orderInfoDto){

        // "order-service" add an order and get the orderId.
        orderInfoDto.setCustomerId(Long.parseLong((String) StpUtil.getLoginId()));
        orderInfoDto.setOrderTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(orderInfoDto);
        ResponseEntity<Long> orderId = restTemplate.postForEntity("http://order-service/api/v1/order",orderInfoDto,Long.class);

        System.out.println("accept the orderId: "+orderId.getBody());

        //redis to store the key.
        tradeService.insertOrderInRedis(orderId.getBody(),orderInfoDto);

        //call the payment API.
        OrderPaymentInfo orderPaymentInfo = new OrderPaymentInfo();
        orderPaymentInfo.setOrderId(orderId.getBody());
        orderPaymentInfo.setOrderName("orderId: "+orderId.getBody().toString()+" orderTime: "+orderInfoDto.getOrderTime().toString());
        orderPaymentInfo.setOrderInfo("归宿平台支付服务");
        orderPaymentInfo.setTotalCost(orderInfoDto.getTotalCost());

        return restTemplate.postForEntity("http://payment-service/api/v1/payment",orderPaymentInfo,String.class);
    }

    @RequestMapping(value = "trade/refund", method = RequestMethod.POST)
    public ResponseEntity<String> refundForOrder(@RequestBody ReOrderInfoDto refundInfoDto){
        OrderPaymentInfo orderPaymentInfo = new OrderPaymentInfo();
        orderPaymentInfo.setOrderId(refundInfoDto.getOrderId());
        orderPaymentInfo.setOrderName("orderId: "+refundInfoDto.getOrderId()+" orderTime: "+refundInfoDto.getOrderTime());
        orderPaymentInfo.setOrderInfo("归宿平台退款服务");
        orderPaymentInfo.setTotalCost(refundInfoDto.getTotalCost());

        ResponseEntity<String> result = restTemplate.postForEntity("http://payment-service/api/v1/refund",orderPaymentInfo,String.class);
        restTemplate.delete("http://order-service/api/v1/order?orderId={1}", refundInfoDto.getOrderId());

        return result;
    }

    @RequestMapping(value = "trade/repayment", method = RequestMethod.POST)
    public ResponseEntity<String> rePaymentForOrder(@RequestBody ReOrderInfoDto repaymentDto){
        OrderPaymentInfo orderPaymentInfo = new OrderPaymentInfo();
        orderPaymentInfo.setOrderId(repaymentDto.getOrderId());
        orderPaymentInfo.setOrderName("orderId: "+repaymentDto.getOrderId()+" orderTime: "+repaymentDto.getOrderTime());
        orderPaymentInfo.setOrderInfo("归宿平台支付服务");
        orderPaymentInfo.setTotalCost(repaymentDto.getTotalCost());

        return restTemplate.postForEntity("http://payment-service/api/v1/payment",orderPaymentInfo,String.class);
    }

    @RequestMapping(value = "trade/order", method = RequestMethod.DELETE)
    public HttpStatus cancelOrder(@RequestParam long orderId){
        tradeService.cancelOrder(orderId);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "trade/payment/callback", method = RequestMethod.POST)
    public HttpStatus completeThePaymentForOrder(@RequestBody long orderId) {
        tradeService.completePaymentForOrder(orderId);
        return HttpStatus.OK;
    }

}