package cn.edu.tongji.gohome.stayinformation.service.impl;


import cn.edu.tongji.gohome.stayinformation.dto.RoomInfoDto;
import cn.edu.tongji.gohome.stayinformation.dto.StayInfoDto;
import cn.edu.tongji.gohome.stayinformation.dto.mapper.RoomInfoMapper;
import cn.edu.tongji.gohome.stayinformation.model.*;
import cn.edu.tongji.gohome.stayinformation.repository.*;
import cn.edu.tongji.gohome.stayinformation.service.StayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * StayServiceImpl类
 *
 * @author 汪明杰
 * @date 2021/11/22 21:47
 */
@Service
public class StayServiceImpl implements StayService {
    @Resource
    private StayRepository stayRepository;

    @Resource
    private RoomRepository roomRepository;

    @Resource
    private RoomPhotoRepository roomPhotoRepository;

    @Resource
    private RoomBedRepository roomBedRepository;

    @Resource
    private BedRepository bedRepository;

    @Resource
    private OrderStayRepository orderStayRepository;

    @Resource
    private HostRepository hostRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private HostGroupRepository hostGroupRepository;

    @Override
    public StayInfoDto searchStayDetailedInfoForStayId(long stayId) {
        StayInfoDto stayInfoDto = new StayInfoDto();
        stayInfoDto.setStayId(stayId);

        // 根据stayId 寻找到对应的StayEntity
        StayEntity stayEntity = stayRepository.findFirstByStayId(stayId);
        if (stayEntity == null){
            return null;
        }

        stayInfoDto.setStayName(stayEntity.getStayName());
        // description
        stayInfoDto.setStayDescription(stayEntity.getCharacteristic());
        stayInfoDto.setCharacteristic(stayEntity.getCharacteristic());

        // stayPosition
        List<BigDecimal> stayPosition = new ArrayList<>();
        stayPosition.add(stayEntity.getLongitude());
        stayPosition.add(stayEntity.getLatitude());
        stayInfoDto.setStayPosition(stayPosition);

        // public Bathroom
        stayInfoDto.setPublicBathroom(stayEntity.getPublicBathroom());
        stayInfoDto.setPublicToilet(stayEntity.getPublicToilet());
        stayInfoDto.setNonBarrierFacility(stayEntity.getNonBarrierFacility() >= 0);
        stayInfoDto.setStartTime(
                String.format("%02d:%02d",stayEntity.getCheckInTime().getHours(),
                        stayEntity.getCheckInTime().getMinutes())
        );
        stayInfoDto.setEndTime(
                String.format("%02d:%02d",stayEntity.getCheckOutTime().getHours(),
                        stayEntity.getCheckOutTime().getMinutes())
        );
        stayInfoDto.setStayStatus(stayEntity.getStayStatus());

        // 根据stayId查询所有与其相关的房间信息
        List<RoomEntity> roomList = roomRepository.getAllByStayId(stayId);
        List<RoomInfoDto> roomInfoDtoList = new ArrayList<>();
        int roomNum = 0;
        int bedNum = 0;
        int stayCapacity = 0;
        List<String> photoList = new ArrayList<>();
        for(RoomEntity room: roomList){
            // 获取到该房间对应的roomPhoto
            RoomPhotoEntity roomPhoto =
                    roomPhotoRepository.findFirstByRoomId(room.getRoomId());
            // 获取bedList
            List<BedEntity> bedEntityList = new ArrayList<>();

            List<RoomBedEntity> roomBedList =
                    roomBedRepository.findAllByRoomId(room.getRoomId());

            for(RoomBedEntity roomBed: roomBedList){
                bedEntityList.add(bedRepository.getById(roomBed.getBedType()));
            }

            // 获取orderList
            List<OrderStayEntity> orderStayEntityList =
                    orderStayRepository.findAllByRoomId(room.getRoomId());

            RoomInfoDto roomInfoDto = RoomInfoMapper.getInstance().toDto(room,roomPhoto,bedEntityList,orderStayEntityList);
            roomInfoDtoList.add(roomInfoDto);
            roomNum += 1;
            bedNum += roomBedList.size();
            stayCapacity += roomInfoDto.getRoomCapacity();
            if (roomPhoto!=null){
                photoList.add(roomPhoto.getRoomPhotoLink());
            }
        }
        stayInfoDto.setRooms(roomInfoDtoList);
        stayInfoDto.setRoomNum(roomNum);
        stayInfoDto.setBedNum(bedNum);
        stayInfoDto.setStayCapacity(stayCapacity);

        // 图片集
        stayInfoDto.setStayImages(photoList);

        // 房东相关信息, 根据host_id查询host的信息
        HostEntity host = hostRepository.getById(stayEntity.getHostId());

        long customerId = host.getCustomerId();
        // 根据customer_id找到customer
        CustomerEntity customer = customerRepository.getById(customerId);

        stayInfoDto.setHostAvatar(customer.getCustomerAvatarLink());

        // 根据host_level找到对应的host_level_name
        stayInfoDto.setHostLevel(
                hostGroupRepository.getById(host.getHostLevel()).getHostLevelName()
        );

        stayInfoDto.setHostName(host.getHostRealName());

        // TODO:根据房东id获取其名下所有房源对应订单的评价总数
        stayInfoDto.setHostCommentNum(0);

        return stayInfoDto;
    }
}
