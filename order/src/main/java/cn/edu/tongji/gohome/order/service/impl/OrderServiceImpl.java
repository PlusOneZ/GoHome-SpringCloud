package
        cn.edu.tongji.gohome.order.service.impl;

import cn.edu.tongji.gohome.order.dto.OrderInfoDto;
import cn.edu.tongji.gohome.order.dto.mapper.OrderInfoMapper;
import cn.edu.tongji.gohome.order.model.CustomerCommentEntity;
import cn.edu.tongji.gohome.order.model.OrderEntity;
import cn.edu.tongji.gohome.order.model.OrderStayEntity;
import cn.edu.tongji.gohome.order.model.RoomPhotoEntity;
import cn.edu.tongji.gohome.order.repository.CustomerCommentRepository;
import cn.edu.tongji.gohome.order.repository.OrderRepository;
import cn.edu.tongji.gohome.order.repository.OrderStayRepository;
import cn.edu.tongji.gohome.order.repository.RoomPhotoRepository;
import cn.edu.tongji.gohome.order.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * implements the service for order mainly.
 *
 * @className: OrderServiceImpl
 * @author: loey
 * @date: 2021-11-21 17:04
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CustomerCommentRepository customerCommentRepository;

    @Resource
    private OrderStayRepository orderStayRepository;

    @Resource
    private RoomPhotoRepository roomPhotoRepository;

    /**
     * @param customerId : customer's id.
     * @description: the implements for searching the order information by customer id...
     * @return: java.util.List<cn.edu.tongji.gohome.order.dto.OrderInfoDto>
     * @author: leoy
     * @date: 2021/11/21 17:07
     **/
    @Override
    public HashMap<String, Object> searchOrderInfoForCustomerId(long customerId, Integer currentPage, Integer pageSize) {

        Pageable pageable = PageRequest.of(currentPage,pageSize);

        HashMap<String,Object> results = new HashMap<>();

        List<OrderInfoDto> orderInfoDtoList = new ArrayList<>();
        Page<OrderEntity> orderEntityList = orderRepository.findAllByCustomerId(customerId, pageable);

        // there is no order for customer whose id = ...
        if (orderEntityList == null) {
            results.put("totalPage",0);
            results.put("orderInfo",orderInfoDtoList);
            return results;
        }

        results.put("totalPage",orderEntityList.getTotalPages());

        for (OrderEntity order : orderEntityList) {
            long orderId = order.getOrderId();
            CustomerCommentEntity customerComment = customerCommentRepository.findFirstByOrderId(orderId);
            OrderStayEntity orderStay = orderStayRepository.findFirstByOrderId(orderId);
            RoomPhotoEntity roomPhoto = null;
            if (orderStay != null){
                roomPhoto = roomPhotoRepository.findFirstByStayIdAndRoomId(orderStay.getStayId(),orderStay.getRoomId());
            }
            orderInfoDtoList.add(OrderInfoMapper.getInstance().toDto(order,customerComment,roomPhoto));
        }

        results.put("orderInfo",orderInfoDtoList);
        return results;

    }
}