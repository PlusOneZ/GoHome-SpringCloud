package cn.edu.tongji.gohome.stayinformation.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.gohome.stayinformation.dto.HostStay;
import cn.edu.tongji.gohome.stayinformation.dto.HostStayRoom;
import cn.edu.tongji.gohome.stayinformation.dto.RoomInfoDto;
import cn.edu.tongji.gohome.stayinformation.dto.StayInfoDto;
import cn.edu.tongji.gohome.stayinformation.dto.mapper.RoomInfoMapper;
import cn.edu.tongji.gohome.stayinformation.model.*;
import cn.edu.tongji.gohome.stayinformation.repository.*;
import cn.edu.tongji.gohome.stayinformation.service.ImageService;
import cn.edu.tongji.gohome.stayinformation.service.StayCommentService;
import cn.edu.tongji.gohome.stayinformation.service.StayService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Resource
    StayCommentService stayCommentService;

    @Resource
    FavoriteDirectoryRepository favoriteDirectoryRepository;

    @Resource
    FavoriteDirectoryStayRepository favoriteDirectoryStayRepository;

    @Resource
    StayLabelRepository stayLabelRepository;

    @Resource
    ImageService imageService;

    @Resource
    ViewStayOrderNumberRepository viewStayOrderNumberRepository;

    @Resource
    ViewStayRoomPriceRepository viewStayRoomPriceRepository;


    @Override
    public StayInfoDto searchStayDetailedInfoForStayId(long stayId,
                                                       int stayStatus) {
        StayInfoDto stayInfoDto = new StayInfoDto();
        stayInfoDto.setStayId(stayId);

        // 根据stayId 寻找到对应的StayEntity
        StayEntity stayEntity = stayRepository.findFirstByStayId(stayId);
        if (stayEntity == null){
            return null;
        }
        else if (stayEntity.getStayStatus() != BigInteger.valueOf(stayStatus)){
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
                    roomPhotoRepository.findFirstByRoomIdAndStayId(
                            room.getRoomId(),
                            stayEntity.getStayId()
                            );
            // 获取bedList
            List<BedEntity> bedEntityList = new ArrayList<>();

            List<RoomBedEntity> roomBedList =
                    roomBedRepository.findAllByRoomIdAndStayId(
                            room.getRoomId(),
                            stayId
                    );

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

        // 根据房东id获取其名下所有房源对应订单的评价总数
        stayInfoDto.setHostCommentNum(
                stayCommentService.getCommentNumberForHostId(host.getHostId())
        );


        return stayInfoDto;
    }

    @Override
    public HashMap<String, Object>  getStayPositionsWithinArea(double westLng, double southLat, double eastLng, double northLat) {
        List<HashMap<String, Object>> stayPositionInfo = new ArrayList<>();

        List<StayEntity> stayEntityList = stayRepository.findAllByLongitudeBetweenAndLatitudeBetween(
                BigDecimal.valueOf(westLng), BigDecimal.valueOf(eastLng),
                BigDecimal.valueOf(southLat), BigDecimal.valueOf(northLat)
        );


        // 最多只返回10个民宿
        int sumNumber = 0;
        for(StayEntity stayEntity: stayEntityList){
            // 只展示状态为2的房源
            if(stayEntity.getStayStatus() != BigInteger.valueOf(2)){
                continue;
            }
            if(sumNumber<=10){
                sumNumber+=1;
            }
            else{
                break;
            }
            HashMap<String, Object> objectHashMap = new HashMap<>();
            objectHashMap.put("stayID", stayEntity.getStayId());
            objectHashMap.put("stayPrice", getLowestRoomForStayId(
                    stayEntity.getStayId()
            ));

            List<BigDecimal> position = new ArrayList<>();
            position.add(stayEntity.getLongitude());
            position.add(stayEntity.getLatitude());
            objectHashMap.put("stayPosition",position);

            stayPositionInfo.add(objectHashMap);
        }

        HashMap<String, Object> res= new HashMap<>();
        res.put("stayPositionNum", stayEntityList.size());
        res.put("stayPositionInfo", stayPositionInfo);

        return res;
    }

    /**
     * 获取一个房源中价格最低的房间
     * @param stayId
     * @return
     */
    @Override
    public BigDecimal getLowestRoomForStayId(long stayId){
        List<RoomEntity> roomEntityList = roomRepository.getAllByStayId(stayId);
        if(roomEntityList.size() == 0){
            return BigDecimal.valueOf(0);
        }
        BigDecimal lowestMoney = roomEntityList.get(0).getPrice();
        for(int i = 1; i < roomEntityList.size(); ++i){
            if (lowestMoney.compareTo(roomEntityList.get(i).getPrice()) > 0){
                lowestMoney = roomEntityList.get(i).getPrice();
            }
        }
        return lowestMoney;
    }



    @Override
    public List<Long> getAllStayIdByHostIdAndStatus(int hostId,
                                                    BigInteger stayStatus){
        List<StayEntity> stayEntityList = stayRepository.
                findAllByHostIdAndStayStatus(hostId, stayStatus);
        List<Long> result=new ArrayList<>();
        for (StayEntity stayEntity: stayEntityList){
            result.add(stayEntity.getStayId());
        }
        return result;
    }

    /**
     * 根据房东id和房源状态获取所有的房源
     * @param hostId
     * @param stayStatus
     * @return
     */
    @Override
    public List<HashMap<String, Object>> getAllStayByHostIdAndStatus
            (int hostId, BigInteger stayStatus){
        List<HashMap<String, Object>> res = new ArrayList<>();

        List<StayEntity> stayEntityList = stayRepository.
                findAllByHostIdAndStayStatus(hostId, stayStatus);
        for(StayEntity stayEntity: stayEntityList){
            HashMap<String, Object> hashMap = new HashMap<>();
            StayInfoDto stayInfoDto =
                    searchStayDetailedInfoForStayId(stayEntity.getStayId(),
                            stayStatus.intValue());
            hashMap.put("stayId", stayEntity.getStayId());
            hashMap.put("imgListNum", stayInfoDto.getStayImages().size());
            hashMap.put("stayType", stayEntity.getStayTypeName());
            hashMap.put("stayNickName", stayInfoDto.getStayName());
            hashMap.put("stayPlace", stayEntity.getDetailedAddress());
            hashMap.put("stayPrice", getLowestRoomForStayId(stayEntity.getStayId()));
            hashMap.put("stayImgList", stayInfoDto.getStayImages());

            res.add(hashMap);
        }

        return res;
    }

    /**
     * 根据stayId获取该房源的全部图片
     * @param stayId
     * @return
     */
    @Override
    public List<String> getAllPhotoByStayId(Long stayId){
        List<RoomEntity> roomList = roomRepository.getAllByStayId(stayId);
        List<String> photoList = new ArrayList<>();
        for(RoomEntity room: roomList) {
            // 获取到该房间对应的roomPhoto
            RoomPhotoEntity roomPhoto =
                    roomPhotoRepository.findFirstByRoomIdAndStayId(
                            room.getRoomId(),
                            stayId
                    );
            if (roomPhoto != null){
                photoList.add(roomPhoto.getRoomPhotoLink());
            }
        }
        return photoList;
    }

    /**
     * 根据stayId获取房东信息
     * @param stayId
     * @return
     */
    @Override
    public HashMap<String, Object> getHostInfoByStayId(Long stayId){
        StayEntity stayEntity = stayRepository.findFirstByStayId(stayId);

        if(stayEntity == null){
            return null;
        }

        HostEntity hostEntity = hostRepository.getById(stayEntity.getHostId());
        CustomerEntity customerEntity = customerRepository.getById(hostEntity.getCustomerId());

        HashMap<String, Object> res = new HashMap<>();
        res.put("avatar", customerEntity.getCustomerAvatarLink());

        return res;
    }

    /**
     * 判断指定房源是否被指定顾客收藏
     * @param stayId
     * @param customerId
     * @return
     */
    @Override
    public boolean isHostFavoriteByCustomerId(Long stayId, long customerId){
        List<FavoriteDirectoryEntity> favoriteDirectoryEntityList
                = favoriteDirectoryRepository.findAllByCustomerId(customerId);

        for(FavoriteDirectoryEntity favoriteDirectoryEntity:
        favoriteDirectoryEntityList){
            List<FavoriteDirectoryStayEntity> favoriteDirectoryStayEntityList
                    = favoriteDirectoryStayRepository
                    .findAllByFavoriteDirectoryId(
                            favoriteDirectoryEntity.getFavoriteDirectoryId()
                    );
            // 在favoriteDirectoryStayEntityList中查找是否有该stayId
            for (int i = 0;i <favoriteDirectoryStayEntityList.size(); ++i){
                if(favoriteDirectoryStayEntityList.get(i).getStayId() == stayId){
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * 获取房源粗略信息
     * @param stayId
     * @param customerId
     * @return
     */
    @Override
    public HashMap<String, Object> getStayBriefInfoByStayId(Long stayId, long customerId){
        HashMap<String, Object> res = getStayMapInfoByStayId(stayId, customerId);

        if (res == null){
            return null;
        }

        // stayLabel
        res.put("stayLabel", getAllLabelByStayId(stayId));

        // stayPrice
        res.put("stayPrice", getLowestRoomForStayId(stayId));

        StayEntity stayEntity = stayRepository.getById(stayId);
        // stayCommentNum
        res.put("stayCommentNum", stayEntity.getCommentAmount());

        // stayScore
        res.put("stayScore", stayEntity.getCommentScore());

        // hostId
        res.put("hostId", stayEntity.getHostId());

        // stayPosition
        List<BigDecimal> stayPosition = new ArrayList<>();
        stayPosition.add(stayEntity.getLongitude());
        stayPosition.add(stayEntity.getLatitude());
        res.put("stayPosition", stayPosition);

        return res;
    }

    @Override
    public HashMap<String, Object> getStayMapInfoByStayId(Long stayId, long customerId){
        HashMap<String, Object> res = new HashMap<>();
        StayEntity stayEntity = stayRepository.findFirstByStayId(stayId);

        if (stayEntity == null){
            return null;
        }

        res.put("stayName", stayEntity.getStayName());
        res.put("stayDescribe",
                stayEntity.getRoomAmount()+"室"+
                stayEntity.getPublicBathroom()+"卫"
                );

        // 图片
        res.put("stayPhoto", getAllPhotoByStayId(stayId));

        // 房东头像
        res.put("hostAvatar", getHostInfoByStayId(stayId).get("avatar"));

        // 房源评分
        res.put("stayScore", stayEntity.getCommentScore());

        // 是否收藏
        res.put("isLike", isHostFavoriteByCustomerId(stayId, customerId));

        return res;
    }

    /**
     * 获取房东个人界面的房源简略信息
     * @param stayId
     * @return
     */
    @Override
    public HashMap<String,Object> getHostStayBriefInfoByStayId(long stayId){
        HashMap<String, Object> hashMap = new HashMap<>();
        StayEntity stay = stayRepository.findFirstByStayId(stayId);
        ViewStayRoomPriceEntity viewStayRoomPrice
                =viewStayRoomPriceRepository.findFirstByStayId(stayId);
        ViewStayOrderNumberEntity viewStayOrderNumber
                = viewStayOrderNumberRepository.findFirstByStayId(stayId);

        hashMap.put("stayId",stayId);
        List<String> stayPhotos=getAllPhotoByStayId(stayId);
        hashMap.put("imgListNum",stayPhotos.size());
        hashMap.put("stayType",stay.getStayTypeName());
        hashMap.put("stayNickName",stay.getStayName());
        hashMap.put("stayPlace",stay.getDetailedAddress());
        if (viewStayRoomPrice == null){
            hashMap.put("stayPrice",0);
        }
        else{
            hashMap.put("stayPrice",viewStayRoomPrice.getMinPrice());
        }
        hashMap.put("stayImgList",stayPhotos);

        // 根据状态来确定是否返回
        if (stay.getStayStatus() == BigInteger.TWO){
            if (viewStayOrderNumber == null){
                hashMap.put("orderNum",0);
            }
            else{
                hashMap.put("orderNum",viewStayOrderNumber.getOrderNumber());
            }

            hashMap.put("reviewNum", stay.getCommentAmount());
            hashMap.put("reviewScore", stay.getCommentScore());
        }



        hashMap.put("stayImgList",stayPhotos);

        return hashMap;
    }

    /**
     * 根据stayId查到其全部label
     * @param stayId
     * @return
     */
    @Override
    public List<String> getAllLabelByStayId(Long stayId){
        List<StayLabelEntity> stayLabelEntityList = stayLabelRepository.findAllByStayId(stayId);
        List<String> res = new ArrayList<>();
        for(StayLabelEntity stayLabelEntity: stayLabelEntityList){
            res.add(stayLabelEntity.getLabelName());
        }
        return res;
    }

    @Override
    public void insertIntoStay(HostStay hostStay, int hostId){

        Long stayId = YitIdHelper.nextId();

        // 添加一个新的stay
        StayEntity newStay = new StayEntity();
        System.out.println(stayId);
        newStay.setStayId(stayId);
        newStay.setHostId(hostId);
        newStay.setStayName(hostStay.getStayName());
        newStay.setStayTypeName(hostStay.getStayType());
        newStay.setDetailedAddress(hostStay.getStruPos());
        newStay.setLongitude(hostStay.getLongitude());
        newStay.setLatitude(hostStay.getLatitude());

        newStay.setRoomAmount(hostStay.getRoomNum());
        newStay.setBedAmount(hostStay.getBedNum());
        newStay.setPublicBathroom(hostStay.getPubBathNum());
        newStay.setPublicToilet(hostStay.getPubRestNum());
        newStay.setNonBarrierFacility(hostStay.getBarrierFree());
        newStay.setCharacteristic(hostStay.getStayChars());

        // 入住时间和离房时间
        try{
            Time checkInTime = Time.valueOf(
                    hostStay.getStartTime()+":00"
            );
            newStay.setCheckInTime(checkInTime);
        }
        catch (Exception err){
            newStay.setCheckInTime(Time.valueOf("08:00:00"));
        }
        try{
            Time checkOutTime = Time.valueOf(
                    hostStay.getEndTime()+":00"
            );
            newStay.setCheckOutTime(checkOutTime);
        }
        catch (Exception err){
            newStay.setCheckOutTime(Time.valueOf("15:00:00"));
        }

        newStay.setDurationMin(hostStay.getMinDay());
        newStay.setDurationMax(hostStay.getMaxDay());
        newStay.setStayStatus(BigInteger.valueOf(hostStay.getStayStatus()));

        newStay.setCommentAmount(0);
        newStay.setCommentScore(BigDecimal.valueOf(0));
        stayRepository.save(newStay);


        List<HostStayRoom> stayRooms = hostStay.getRoomInfo();


        int sumRoomArea=0;
        // 房间号从1开始编号
        for(int i = 1; i<=stayRooms.size(); ++i){
            RoomEntity newRoom = new RoomEntity();
            HostStayRoom hostStayRoom = stayRooms.get(i-1);

            newRoom.setStayId(stayId);
            newRoom.setRoomId(i);
            newRoom.setPrice(BigDecimal.valueOf(hostStayRoom.getPrice()));
            newRoom.setRoomArea(BigDecimal.valueOf(hostStayRoom.getRoomArea()));
            sumRoomArea += hostStayRoom.getRoomArea();
            newRoom.setBathroomAmount(hostStayRoom.getBathNum());

            roomRepository.save(newRoom);

            // 图片表
            List<String> roomImages = stayRooms.get(i-1).getImages();
            for(int j = 0; j < roomImages.size(); ++j){
                RoomPhotoEntity roomPhoto = new RoomPhotoEntity();
                roomPhoto.setRoomId(i);
                roomPhoto.setStayId(stayId);

                roomPhoto.setRoomPhotoLink(
                        imageService.base64UploadFile(roomImages.get(j),
                                "roomPhoto/"+stayId+"-"+i + ".png"
                                )
                );

                roomPhotoRepository.save(roomPhoto);
            }

            // 床表
            List<String> bedTypes = stayRooms.get(i-1).getBedTypes();
            List<Integer> bedNums = stayRooms.get(i-1).getBedNums();
            for(int j = 0; j < bedTypes.size(); ++j){
                if(bedNums.get(j) <= 0){
                    continue;
                }
                RoomBedEntity roomBed = new RoomBedEntity();
                roomBed.setRoomId(i);
                roomBed.setStayId(stayId);
                roomBed.setBedAmount(bedNums.get(j));
                roomBed.setBedType(bedTypes.get(j));
                roomBedRepository.save(roomBed);
            }


        }
        // 房间面积
        newStay.setStayCapacity(sumRoomArea);

        // label表
        List<String> labels = hostStay.getStayTags();
        for(int i = 0; i < labels.size(); ++i){
            StayLabelEntity stayLabel = new StayLabelEntity();
            stayLabel.setStayId(stayId);
            stayLabel.setLabelName(labels.get(i));

            stayLabelRepository.save(stayLabel);
        }

    }

    @Override
    public void updateAStay(HostStay hostStay, long stayId, int hostId){
        StayEntity originStay = stayRepository.findFirstByStayId(stayId);
        // 将原来的房源设为4 状态，并创建一个新的房源
        originStay.setStayStatus(BigInteger.valueOf(4));
        insertIntoStay(hostStay,hostId);
    }

    @Override
    public void deleteFromStayId(long stayId){
        stayRepository.getById(stayId).setStayStatus(BigInteger.valueOf(4));
    }
}
