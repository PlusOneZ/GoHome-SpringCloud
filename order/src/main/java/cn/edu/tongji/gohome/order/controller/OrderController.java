package
        cn.edu.tongji.gohome.order.controller;

import cn.edu.tongji.gohome.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

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
     * <b>example: /api/v1/orders/customer?currentPage=1&pageSize=5 </b><br>
     * return all the order information for the customer.
     * @return : org.springframework.http.ResponseEntity<cn.edu.tongji.gohome.order.entity.OrderEntity>
     * @author : leoy
     * @since  : 2021/11/19 20:07
     **/
    @RequestMapping("orders/customer")
    public ResponseEntity<HashMap<String, Object>> getCustomerOrderList(
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(orderService.searchOrderInfoForCustomerId(1L, currentPage, pageSize), HttpStatus.OK);
    }

}