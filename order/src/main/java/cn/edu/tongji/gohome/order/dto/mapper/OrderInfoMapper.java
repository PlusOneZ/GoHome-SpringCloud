package
        cn.edu.tongji.gohome.order.dto.mapper;

import cn.edu.tongji.gohome.order.dto.OrderInfoDto;
import cn.edu.tongji.gohome.order.model.CustomerCommentEntity;
import cn.edu.tongji.gohome.order.model.OrderEntity;
import cn.edu.tongji.gohome.order.model.RoomPhotoEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * It's a class to map the orderInfoDto with the information of order, comment and so on...
 *
 * @className: OrderInfoMapper
 * @author: loey
 * @date: 2021-11-21 15:24
 **/

@Component
public class OrderInfoMapper {

    private static final OrderInfoMapper mapper = new OrderInfoMapper();

    private OrderInfoMapper(){}

    public static OrderInfoMapper getInstance(){
        return mapper;
    }

    /**
    * @description: function that converts the Entity to OrderInfoDto.
    * @param orderEntity: order information. We can get the id, status, amount and time from it.
    * @param customerCommentEntity: get the customer score from it.
    * @param roomPhotoEntity: get the room photo link to display the order.
    * @return: cn.edu.tongji.gohome.order.dto.OrderInfoDto
    * @author: leoy
    * @date: 2021/11/21 15:36
    **/
    public OrderInfoDto toDto(OrderEntity orderEntity, CustomerCommentEntity customerCommentEntity, RoomPhotoEntity roomPhotoEntity){

        OrderInfoDto orderInfoDto;
        int defaultScore = -1;
        String defaultPhotoLink = "";

        if(customerCommentEntity == null && roomPhotoEntity == null){
            orderInfoDto = convert(orderEntity);
            orderInfoDto.setStayScore(defaultScore);
            orderInfoDto.setRoomPhotoLink(defaultPhotoLink);
        }
        else if ( customerCommentEntity == null ){
            orderInfoDto = convert(orderEntity, roomPhotoEntity);
            orderInfoDto.setStayScore(defaultScore);
        }
        else if(roomPhotoEntity == null){
            orderInfoDto = convert(orderEntity, customerCommentEntity);
            orderInfoDto.setRoomPhotoLink(defaultPhotoLink);
        }
        else{
            orderInfoDto = convert(orderEntity,customerCommentEntity,roomPhotoEntity);
        }
        return orderInfoDto;
    }

    private OrderInfoDto convert(OrderEntity orderEntity, CustomerCommentEntity customerCommentEntity, RoomPhotoEntity roomPhotoEntity){
        OrderInfoDto orderInfoDto;

        orderInfoDto = convert(orderEntity,customerCommentEntity);

        orderInfoDto.setRoomPhotoLink(roomPhotoEntity.getRoomPhotoLink());

        return orderInfoDto;
    }

    private OrderInfoDto convert(OrderEntity orderEntity, RoomPhotoEntity roomPhotoEntity){
        OrderInfoDto orderInfoDto;

        orderInfoDto = convert(orderEntity);

        orderInfoDto.setRoomPhotoLink(roomPhotoEntity.getRoomPhotoLink());

        return orderInfoDto;
    }

    private OrderInfoDto convert(OrderEntity orderEntity, CustomerCommentEntity customerCommentEntity){
        OrderInfoDto orderInfoDto;

        orderInfoDto = convert(orderEntity);

        orderInfoDto.setStayScore(customerCommentEntity.getStayScore());

        return orderInfoDto;
    }

    private OrderInfoDto convert(OrderEntity orderEntity){
        OrderInfoDto orderInfoDto;
        orderInfoDto = new OrderInfoDto();

        orderInfoDto.setOrderId(orderEntity.getOrderId());
        orderInfoDto.setOrderStatus(orderEntity.getOrderStatus());
        orderInfoDto.setOrderTime(orderEntity.getOrderTime());
        orderInfoDto.setTotalCost(orderEntity.getTotalCost());

        return orderInfoDto;
    }
}