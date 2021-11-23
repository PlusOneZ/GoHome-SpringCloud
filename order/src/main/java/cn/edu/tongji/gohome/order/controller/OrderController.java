package
        cn.edu.tongji.gohome.order.controller;

import cn.edu.tongji.gohome.order.dto.Comment;
import cn.edu.tongji.gohome.order.dto.Report;
import cn.edu.tongji.gohome.order.model.CustomerCommentEntity;
import cn.edu.tongji.gohome.order.model.HostCommentEntity;
import cn.edu.tongji.gohome.order.model.OrderReportEntity;
import cn.edu.tongji.gohome.order.repository.CustomerCommentRepository;
import cn.edu.tongji.gohome.order.repository.HostCommentRepository;
import cn.edu.tongji.gohome.order.repository.OrderReportRepository;
import cn.edu.tongji.gohome.order.service.OrderService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private CustomerCommentRepository customerCommentRepository;

    @Resource
    private HostCommentRepository hostCommentRepository;

    @Resource
    private OrderReportRepository orderReportRepository;


    /**
     * @description: return all the order information for the customer.
     * @return: org.springframework.http.ResponseEntity<cn.edu.tongji.gohome.order.entity.OrderEntity>
     * @author: leoy
     * @date: 2021/11/19 20:07
     **/
    @RequestMapping("orders/customer")
    public ResponseEntity<HashMap<String, Object>> getCustomerOrderList(
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(orderService.searchOrderInfoForCustomerId(1L, currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping("orders/host")
    public ResponseEntity<HashMap<String, Object>> getHostOrderList(
            @RequestParam(value = "stayId", required = false) long stayId,
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {

        return new ResponseEntity<>(orderService.searchOrderInfoForStayId(stayId, currentPage, pageSize), HttpStatus.OK);

    }

    @RequestMapping("order")
    public ResponseEntity<HashMap<String, Object>> getOrderDetailedList(
            @RequestParam(value = "orderId") long orderId,
            @RequestParam(value = "currentPage") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
        return new ResponseEntity<>(orderService.searchOrderDetailedInfoForOrderId(orderId, currentPage, pageSize), HttpStatus.OK);
    }

    @RequestMapping(value = "order/comment/customer", method = RequestMethod.POST)
    public HttpStatus addOrderCustomerComment(@RequestBody Comment comment){
        CustomerCommentEntity customerCommentEntity = new CustomerCommentEntity();

        customerCommentEntity.setOrderId(comment.getOrderId());
        customerCommentEntity.setCustomerCommentContent(comment.getCommentContent());
        customerCommentEntity.setCustomerCommentTime(comment.getCommentTime());
        customerCommentEntity.setStayScore(comment.getCommentScore());

        customerCommentRepository.save(customerCommentEntity);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "order/comment/host", method = RequestMethod.POST)
    public HttpStatus addOrderHostComment(@RequestBody Comment comment){
        HostCommentEntity hostCommentEntity = new HostCommentEntity();

        hostCommentEntity.setOrderId(comment.getOrderId());
        hostCommentEntity.setHostCommentContent(comment.getCommentContent());
        hostCommentEntity.setHostCommentTime(comment.getCommentTime());
        hostCommentEntity.setCustomerScore(comment.getCommentScore());

        hostCommentRepository.save(hostCommentEntity);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "order/report",method = RequestMethod.POST)
    public HttpStatus addOrderReport(@RequestBody Report report){
        OrderReportEntity orderReportEntity = new OrderReportEntity();

        orderReportEntity.setOrderId(report.getOrderId());
        orderReportEntity.setReportReason(report.getReportReason());
        orderReportEntity.setReportTime(report.getReportTime());

        orderReportRepository.save(orderReportEntity);

        return HttpStatus.OK;
    }

}