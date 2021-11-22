package
        cn.edu.tongji.gohome.order.dto.mapper;

import cn.edu.tongji.gohome.order.dto.OrderDetailedInfoDto;
import cn.edu.tongji.gohome.order.model.OrderStayEntity;
import cn.edu.tongji.gohome.order.model.RoomPhotoEntity;

/**
 * TODO
 *
 * @className: Mapper for order, roomPhoto and orderDetailedDto...
 * @author: loey
 * @date: 2021-11-22 20:01
 **/
public class OrderDetailedInfoMapper {

    private static final OrderDetailedInfoMapper mapper = new OrderDetailedInfoMapper();

    private OrderDetailedInfoMapper(){}

    public static OrderDetailedInfoMapper getInstance(){
        return mapper;
    }

    public OrderDetailedInfoDto toDto(OrderStayEntity orderStayEntity, RoomPhotoEntity roomPhoto){
        OrderDetailedInfoDto orderDetailedInfoDto = new OrderDetailedInfoDto();
        orderDetailedInfoDto.setStayId(orderStayEntity.getStayId());
        orderDetailedInfoDto.setRoomId(orderStayEntity.getRoomId());
        orderDetailedInfoDto.setStartTime(orderStayEntity.getStartTime());
        orderDetailedInfoDto.setEndTime(orderStayEntity.getEndTime());
        orderDetailedInfoDto.setMoneyAmount(orderStayEntity.getMoneyAmount());
        if(roomPhoto == null){
            orderDetailedInfoDto.setRoomPhotoLink("");
        }
        else {
            orderDetailedInfoDto.setRoomPhotoLink(roomPhoto.getRoomPhotoLink());
        }
        return orderDetailedInfoDto;
    }


}