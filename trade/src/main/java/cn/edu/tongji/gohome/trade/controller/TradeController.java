package
        cn.edu.tongji.gohome.trade.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.trade.dto.OrderInfoDto;
import cn.edu.tongji.gohome.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
    public HttpStatus tradeForOrder(@RequestBody OrderInfoDto orderInfoDto){

        // "order-service" add an order and get the orderId.
        ResponseEntity<Long> orderId = restTemplate.postForEntity("http://order-service/api/v1/order",orderInfoDto,Long.class);

        System.out.println("accept the orderId: "+orderId.getBody());

        //redis to store the key.
        tradeService.insertOrderInRedis(orderId.getBody(),orderInfoDto);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "trade/order", method = RequestMethod.DELETE)
    public HttpStatus cancelOrder(@RequestParam long orderId){
        tradeService.cancelOrder(orderId);
        return HttpStatus.OK;
    }

    @RequestMapping("trade/customer/id")
    public String demoGetCustomerLoginId() {
        return (String) StpUtil.getLoginId();
    }

}