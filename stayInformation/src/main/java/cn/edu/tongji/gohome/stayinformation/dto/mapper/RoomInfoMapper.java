package cn.edu.tongji.gohome.stayinformation.dto.mapper;

import cn.edu.tongji.gohome.stayinformation.dto.BedDto;
import cn.edu.tongji.gohome.stayinformation.dto.RoomInfoDto;
import cn.edu.tongji.gohome.stayinformation.model.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * RoomInfoMapper类
 *
 * @author 汪明杰
 * @date 2021/11/22 21:03
 */
public class RoomInfoMapper {
    private static final RoomInfoMapper mapper = new RoomInfoMapper();

    private RoomInfoMapper(){}

    public static RoomInfoMapper getInstance(){
        return mapper;
    }

    public RoomInfoDto toDto(RoomEntity room,
                             RoomPhotoEntity roomPhoto,
                             List<BedEntity> bedList,
                             List<OrderStayEntity> orderList){
        RoomInfoDto roomInfo = new RoomInfoDto();
        roomInfo.setId(room.getRoomId());
        roomInfo.setArea(room.getRoomArea());
        roomInfo.setBathroom(room.getBathroomAmount());
        roomInfo.setPrice(room.getPrice());
        //

        if(roomPhoto == null){
            roomInfo.setRoomImage("");
        }
        else{
            roomInfo.setRoomImage(roomPhoto.getRoomPhotoLink());
        }

        // bed 系列
        List<BedDto> bedDtos = new ArrayList<>();
        int roomCapacity = 0;
        for(int i = 0; i < bedList.size(); ++i){
            BedDto bedDto = new BedDto();
            bedDto.setBedType(bedList.get(i).getBedType());
            bedDto.setNum(bedList.get(i).getPersonAmount());

            bedDtos.add(bedDto);

            roomCapacity += bedList.get(i).getPersonAmount();

        }
        roomInfo.setBeds(bedDtos);
        roomInfo.setRoomCapacity(roomCapacity);

        // unavailable 列表， 也即订单的全部时间
        List<HashMap<String, String>> unavailable = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


        for(int i = 0;i<orderList.size(); ++i){
            String startTime =
                    format.format(orderList.get(i).getStartTime());
            String endTime =
                    format.format(orderList.get(i).getEndTime());
            HashMap<String, String> unavailableTime = new HashMap<>();
            unavailableTime.put("startDate", startTime);
            unavailableTime.put("endDate", endTime);

            unavailable.add(unavailableTime);
        }
        roomInfo.setUnavailable(unavailable);

        return roomInfo;
    }
}
