package
        cn.edu.tongji.gohome.order.service.impl;

import cn.edu.tongji.gohome.order.dto.*;
import cn.edu.tongji.gohome.order.dto.mapper.OrderDetailedInfoMapper;
import cn.edu.tongji.gohome.order.dto.mapper.OrderInfoMapper;
import cn.edu.tongji.gohome.order.model.*;
import cn.edu.tongji.gohome.order.repository.*;
import cn.edu.tongji.gohome.order.service.OrderService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
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

    @Resource
    private VOrderStayRepository vOrderStayRepository;

    @Resource
    private StayRepository stayRepository;

    @Resource
    private ViewCouponInformationRepository viewCouponInformationRepository;

    @Resource
    private CouponRepository couponRepository;


    /**
    * @description: A private function for searching order information list... to reduce the same code...
    * @param order: orderEntity to get orderId and other information...
    * @return: cn.edu.tongji.gohome.order.dto.OrderInfoDto
    * @author: leoy
    * @date: 2021/11/22 19:31
    **/
    private OrderInfoDto getInfoFromOrderEntity(OrderEntity order){
        long orderId = order.getOrderId();
        CustomerCommentEntity customerComment = customerCommentRepository.findFirstByOrderId(orderId);
        OrderStayEntity orderStay = orderStayRepository.findFirstByOrderId(orderId);
        RoomPhotoEntity roomPhoto = null;
        if (orderStay != null) {
            roomPhoto = roomPhotoRepository.findFirstByStayIdAndRoomId(orderStay.getStayId(), orderStay.getRoomId());
        }
        return OrderInfoMapper.getInstance().toDto(order, customerComment, roomPhoto);
    }

    /**
     * @param customerId : customer's id.
     * @description: the implements for searching the order information by customer id...
     * @return: java.util.List<cn.edu.tongji.gohome.order.dto.OrderInfoDto>
     * @author: leoy
     * @date: 2021/11/21 17:07
     **/
    @Override
    public HashMap<String, Object> searchOrderInfoForCustomerId(long customerId, Integer currentPage, Integer pageSize) {

        Pageable pageable = PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();

        List<OrderInfoDto> orderInfoDtoList = new ArrayList<>();
        Page<OrderEntity> orderEntityList = orderRepository.findAllByCustomerId(customerId, pageable);

        // there is no order for customer whose id = ...
        if (orderEntityList == null) {
            results.put("totalPage", 0);
            results.put("orderInfo", orderInfoDtoList);
            return results;
        }

        results.put("totalPage", orderEntityList.getTotalPages());

        for (OrderEntity order : orderEntityList) {
            orderInfoDtoList.add(getInfoFromOrderEntity(order));
        }

        results.put("orderInfo", orderInfoDtoList);
        return results;

    }

    /**
     * @param stayId: stay id for searching the order.
     * @param currentPage: current page for info.
     * @param pageSize: the count of data every page.
     * @description: search the order info for the host when he clicks one stay...
     * @return: java.util.HashMap<java.lang.String, java.lang.Object>
     * @author: leoy
     * @date: 2021/11/22 10:59
     **/
    @Override
    public HashMap<String, Object> searchOrderInfoForStayId(long stayId, Integer currentPage, Integer pageSize) {

        // get all the order info
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        HashMap<String, Object> results = new HashMap<>();
        List<OrderInfoDto> orderInfoDtoList = new ArrayList<>();

        Page<VOrderStayEntity> vOrderStayEntityPageable = vOrderStayRepository.findAllByStayId(stayId, pageable);

        // there is no order for customer whose id = ...
        if (vOrderStayEntityPageable == null) {
            results.put("totalPage", 0);
            results.put("orderInfo", orderInfoDtoList);
            return results;
        }
        results.put("totalPage", vOrderStayEntityPageable.getTotalPages());
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for(VOrderStayEntity vOrderStayEntity:vOrderStayEntityPageable){
            orderEntityList.add(orderRepository.findFirstByOrderId(vOrderStayEntity.getOrderId()));
        }

        for(OrderEntity order : orderEntityList){
            orderInfoDtoList.add(getInfoFromOrderEntity(order));
        }
        results.put("orderInfo", orderInfoDtoList);
        return results;
    }


    /**
    * @description: When the customer or host clicks the order, the back-end should return the detailed information for order and stay-room...
    * @param orderId: the id for order...
    * @param currentPage the current page of all...
    * @param pageSize: number for the record every page...
    * @return: java.util.HashMap<java.lang.String,java.lang.Object>
    * @author: leoy
    * @date: 2021/11/22 19:33
    **/
    @Override
    public HashMap<String, Object> searchOrderDetailedInfoForOrderId(long orderId, Integer currentPage, Integer pageSize){

        // get all room info by order id...
        HashMap<String, Object> results = new HashMap<>();
        List<OrderDetailedInfoDto> orderDetailedInfoDtoList = new ArrayList<>();

        Pageable pageable = PageRequest.of(currentPage,pageSize);
        Page<OrderStayEntity> orderStayEntityPage = orderStayRepository.findAllByOrderId(orderId, pageable);

        if (orderStayEntityPage == null){
            results.put("totalPage",0);
            return results;
        }

        results.put("totalPage",orderStayEntityPage.getTotalPages());

        long stayId = vOrderStayRepository.findFirstByOrderId(orderId).getStayId();
        String stayName = stayRepository.findFirstByStayId(stayId).getStayName();
        results.put("stayName",stayName);

        for (OrderStayEntity stayInfo : orderStayEntityPage){

            int roomId = stayInfo.getRoomId();
            RoomPhotoEntity roomPhoto = roomPhotoRepository.findFirstByStayIdAndRoomId(stayId,roomId);
            orderDetailedInfoDtoList.add(OrderDetailedInfoMapper.getInstance().toDto(stayInfo,roomPhoto));
        }
        results.put("orderDetailedInfo",orderDetailedInfoDtoList);

        return results;
    }


    private OrderEntity getInformationFromOrderContent(OrderContent orderContent){

        OrderEntity order = new OrderEntity();

        order.setOrderId(YitIdHelper.nextId());
        order.setOrderTime(orderContent.getOrderTime());
        order.setCustomerId(orderContent.getCustomerId());
        order.setMemberAmount(orderContent.getMemberAmount());
        order.setTotalCost(orderContent.getTotalCost());
        order.setOrderStatus(orderContent.getOrderStatus());

        return order;
    }

    private List<OrderStayEntity> getRoomInfoFromOrderContent(long orderId, List<OrderStayInfoDto> orderStayInfoDtoList){
        List<OrderStayEntity> orderStayEntityList = new ArrayList<>();

        for(OrderStayInfoDto orderStayInfoDto : orderStayInfoDtoList){
            OrderStayEntity orderStayEntity = new OrderStayEntity();
            orderStayEntity.setOrderId(orderId);
            orderStayEntity.setStayId(orderStayInfoDto.getStayId());
            orderStayEntity.setRoomId(orderStayInfoDto.getRoomId());
            orderStayEntity.setStartTime(orderStayInfoDto.getStartTime());
            orderStayEntity.setEndTime(orderStayInfoDto.getEndTime());
            orderStayEntity.setMoneyAmount(orderStayInfoDto.getMoneyAmount());
            orderStayEntityList.add(orderStayEntity);
        }
        return orderStayEntityList;
    }


    /**
    * add one order in db...
    * @param orderContent: the detailed information for order.
    * @return : void
    * @author : leoy
    * @since : 2021/11/23 22:28
    **/
    @Override
    public Long addOrderAndDetailedInformation(OrderContent orderContent){

        OrderEntity order = getInformationFromOrderContent(orderContent);
        List<OrderStayEntity> orderStayEntityList = getRoomInfoFromOrderContent(order.getOrderId(),orderContent.getOrderStayEntityList());
        orderRepository.save(order);
        orderStayRepository.saveAll(orderStayEntityList);

        return order.getOrderId();
    }

    @Override
    public void updateOrderStatus(long orderId, int orderStatus){

        OrderEntity order = orderRepository.getById(orderId);
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
    }

    public List<ViewCouponInformationEntity> searchUsableCouponForCustomerId(long customerId, BigDecimal couponLimit, Integer currentPage, Integer pageSize){
        Pageable pageable = PageRequest.of(currentPage,pageSize);


        Specification specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            //customer_id
            predicateList.add(criteriaBuilder.equal(root.get("customerId").as(Long.class),customerId));
            //status
            predicateList.add(criteriaBuilder.equal(root.get("couponStatus").as(Integer.class), CouponStatus.COUPON_UNUSED));
            //couponLimit
            predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("couponLimit").as(BigDecimal.class),couponLimit));

            Predicate[] pre = new Predicate[predicateList.size()];
            pre = predicateList.toArray(pre);
            return query.where(pre).getRestriction();
        };
        return viewCouponInformationRepository.findAll(specification, pageable).toList();
    }

    public void updateOCouponStatus(long couponId, int couponStatus){

        CouponEntity coupon = couponRepository.getById(couponId);
        coupon.setCouponStatus(couponStatus);
        couponRepository.save(coupon);
    }
}