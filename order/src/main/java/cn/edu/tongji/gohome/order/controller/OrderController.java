package
        cn.edu.tongji.gohome.order.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.order.dto.*;
import cn.edu.tongji.gohome.order.model.CustomerCommentEntity;
import cn.edu.tongji.gohome.order.model.HostCommentEntity;
import cn.edu.tongji.gohome.order.model.OrderReportEntity;
import cn.edu.tongji.gohome.order.repository.CustomerCommentRepository;
import cn.edu.tongji.gohome.order.repository.HostCommentRepository;
import cn.edu.tongji.gohome.order.repository.OrderReportRepository;
import cn.edu.tongji.gohome.order.repository.OrderRepository;
import cn.edu.tongji.gohome.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CustomerCommentRepository customerCommentRepository;

    @Resource
    private HostCommentRepository hostCommentRepository;

    @Resource
    private OrderReportRepository orderReportRepository;


    /**
     * <b>example: /api/v1/orders/customer?currentPage=1&pageSize=5 </b><br>
     * return all the order information for the customer.
     *
     * @return : org.springframework.http.ResponseEntity<cn.edu.tongji.gohome.order.entity.OrderEntity>
     * @author : leoy
     * @since : 2021/11/19 20:07
     **/


    @RequestMapping("orders/customer")
    public ResponseEntity<HashMap<String, Object>> getCustomerOrderList(
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
            @RequestParam(value = "orderStatus", required = false) Integer orderStatus) {

        Long customerId = Long.parseLong((String) StpUtil.getLoginId());
        System.out.println("print customerId");
        System.out.println(customerId);

        if(orderStatus == null){
            return new ResponseEntity<>(orderService.searchOrderInfoForCustomerId(customerId, currentPage, pageSize), HttpStatus.OK);
        }
        return new ResponseEntity<>(orderService.searchOrderInfoForCustomerIdAndOrderStatus(customerId, orderStatus, currentPage, pageSize), HttpStatus.OK);
    }


    @RequestMapping("orders/host")
    public ResponseEntity<HashMap<String, Object>> getHostOrderList(
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
            @RequestParam(value = "orderStatus", required = false) Integer orderStatus) {
        if(orderStatus == null){
            return new ResponseEntity<>
                    (orderService.searchOrderInfoForHost(Long.parseLong((String) StpUtil.getLoginId()), currentPage, pageSize), HttpStatus.OK);
        }
        return new ResponseEntity<>(orderService.searchOrderInfoForHostAndOrderStatus(Long.parseLong((String) StpUtil.getLoginId()), orderStatus,currentPage, pageSize), HttpStatus.OK);
        
    }

    @RequestMapping("order")
    public ResponseEntity<HashMap<String, Object>> getOrderDetailedList(
            @RequestParam(value = "orderId") long orderId,
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
        return new ResponseEntity<>(orderService.searchOrderDetailedInfoForOrderId(orderId, currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping(value = "order/comment/customer", method = RequestMethod.POST)
    public HttpStatus addOrderCustomerComment(@RequestBody Comment comment) {
        CustomerCommentEntity customerCommentEntity = new CustomerCommentEntity();

        customerCommentEntity.setOrderId(comment.getOrderId());
        customerCommentEntity.setCustomerCommentContent(comment.getCommentContent());
        customerCommentEntity.setCustomerCommentTime(new Timestamp(System.currentTimeMillis()));
        customerCommentEntity.setStayScore(comment.getCommentScore());

        customerCommentRepository.save(customerCommentEntity);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "order/comment/host", method = RequestMethod.POST)
    public HttpStatus addOrderHostComment(@RequestBody Comment comment) {
        HostCommentEntity hostCommentEntity = new HostCommentEntity();

        hostCommentEntity.setOrderId(comment.getOrderId());
        hostCommentEntity.setHostCommentContent(comment.getCommentContent());
        hostCommentEntity.setHostCommentTime(new Timestamp(System.currentTimeMillis()));
        hostCommentEntity.setCustomerScore(comment.getCommentScore());

        hostCommentRepository.save(hostCommentEntity);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "order/report", method = RequestMethod.POST)
    public HttpStatus addOrderReport(@RequestBody Report report) {
        OrderReportEntity orderReportEntity = new OrderReportEntity();

        orderReportEntity.setOrderId(report.getOrderId());
        orderReportEntity.setReportReason(report.getReportReason());
        orderReportEntity.setReportTime(new Timestamp(System.currentTimeMillis()));

        orderService.updateOrderStatus(report.getOrderId(), OrderStatus.ORDER_BUSINESS_REPORTED);

        orderReportRepository.save(orderReportEntity);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public Long addOrder(@RequestBody OrderContent orderContent) {

        return orderService.addOrderAndDetailedInformation(orderContent);
    }

    @RequestMapping(value = "order", method = RequestMethod.DELETE)
    public HttpStatus deleteOrder(@RequestParam long orderId) {

        orderRepository.deleteAllByOrderId(orderId);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "order/status", method = RequestMethod.PUT)
    public HttpStatus modifyOrderStatus(@RequestParam long orderId, @RequestParam int orderStatus) {

        orderService.updateOrderStatus(orderId, orderStatus);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "order/coupons", method = RequestMethod.GET)
    public ResponseEntity<Map<String,Object>> getUsableCouponList(
            @RequestParam BigDecimal couponLimit,
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
        return new ResponseEntity<>(
                orderService.searchUsableCouponForCustomerId(Long.parseLong((String) StpUtil.getLoginId()), couponLimit, currentPage, pageSize), HttpStatus.OK
        );
    }

    @RequestMapping(value = "order/coupon", method = RequestMethod.PUT)
    public HttpStatus modifyCouponStatus(@RequestParam long couponId, @RequestParam int couponStatus){

        orderService.updateOCouponStatus(couponId,couponStatus);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "order/footMap", method = RequestMethod.GET)
    public ResponseEntity<List<FootMapInfoDto>> getFootMapInformation(){

        return new ResponseEntity<>
                (orderService.getFootMapInformation(Long.parseLong((String) StpUtil.getLoginId())),HttpStatus.OK);
    }

}