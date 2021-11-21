package
        cn.edu.tongji.gohome.order.controller;

import cn.edu.tongji.gohome.order.dto.OrderInfoDto;
import cn.edu.tongji.gohome.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller that handles order filtering and creation.
 *
 * @className: OrderController
 * @author: loey
 * @date: 2021-11-19 19:15
 **/

@RestController
@RequestMapping("api/v1/")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * @description: return all the order information for the customer.
     * @return: org.springframework.http.ResponseEntity<cn.edu.tongji.gohome.order.entity.OrderEntity>
     * @author: leoy
     * @date: 2021/11/19 20:07
     **/
    @RequestMapping("orders/customer")
    public ResponseEntity<List<OrderInfoDto>> getCustomerOrderList() {

        return new ResponseEntity<>(orderService.searchOrderInfoForCustomerId(1L), HttpStatus.OK);
    }

}