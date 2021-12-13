package cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.impl;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.mapper.FavoriteStayInfoDtoMapper;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.mapper.HostCommentDtoMapper;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.CustomerInfoService;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.ImageService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;
import java.util.concurrent.ExecutionException;

/**
 * 实现顾客信息服务接口，处理有关顾客信息的后端业务逻辑，由 controller最终调用
 * @author 梁乔
 * @since 2021/11/23 11:36
 */
@Service
public class CustomerServiceImpl implements CustomerInfoService {

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private HostCommentRepository hostCommentRepository;

    @Resource
    private HostRepository hostRepository;

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private StayRepository stayRepository;

    @Resource
    private OrderStayRepository orderStayRepository;

    @Resource
    private FavoriteDirectoryRepository favoriteDirectoryRepository;

    @Resource
    private ImageService imageService;

    @Resource
    private FavoriteDirectoryStayRepository favoriteDirectoryStayRepository;

    @Resource
    private RoomPhotoRepository roomPhotoRepository;

    @Resource
    private ViewStayRoomPriceRepository viewStayRoomPriceRepository;

    @Resource
    private HostGroupRepository hostGroupRepository;

    @Resource
    private ViewHostStayCommentRepository viewHostStayCommentRepository;

    @Resource
    private RoomRepository roomRepository;

    @Resource
    private RoomBedRepository roomBedRepository;

    @Resource
    private StayLabelRepository stayLabelRepository;

    @Resource
    private CustomerGroupRepository customerGroupRepository;

    @Resource
    private CustomerCouponRepository customerCouponRepository;

    @Resource
    private CouponTypeRepository couponTypeRepository;

    /**
    * 通过SA-Token获取到的用户id去获取用户的基本信息
     * @param customerId : 顾客id
     * @return : java.util.HashMap<java.lang.String,java.lang.Object>
    * @author 梁乔
    * @since 21:38 2021-11-23
    */
    @Override
    public HashMap<String, Object> searchCustomerInfoByCustomerId(Long customerId) {

        HashMap<String,Object> results = new HashMap<>();

        List<HostCommentDto> hostCommentDtoList = new ArrayList<>();

        //get the customerEntity by given customer id...
        CustomerEntity customerEntity = customerRepository.findFirstByCustomerId(customerId);

        results.put("userNickName",customerEntity.getCustomerName());
        results.put("userAvatar",customerEntity.getCustomerAvatarLink());

        //get the number of evaluation and the comment itself...
        //first get all the orders of the customer
        int evalNum = 0;
        List<OrderEntity> orderEntityList = new ArrayList<>();
        orderEntityList = orderRepository.findAllByCustomerId(customerId);
        for(OrderEntity order:orderEntityList){
            HostCommentEntity hostCommentEntity = hostCommentRepository.findByOrderId((int)order.getOrderId());
            if(hostCommentEntity != null){
                evalNum++;
                OrderStayEntity orderStayEntity = orderStayRepository.findByOrderId(order.getOrderId());
                StayEntity stayEntity = stayRepository.findByStayId(orderStayEntity.getStayId());
                HostEntity hostEntity = hostRepository.findByHostId(stayEntity.getHostId());
                CustomerEntity customer = customerRepository.findFirstByCustomerId(hostEntity.getCustomerId());
                //transfer into CommentInfoDto
                hostCommentDtoList.add(HostCommentDtoMapper.getInstance().toDto(hostCommentEntity, hostEntity, customer));

            }
        }

        results.put("evalNum",evalNum);
        results.put("userGroupLevel",customerEntity.getCustomerLevel());
        results.put("emailTag", customerEntity.getCustomerEmail() != null);
        results.put("userScore", customerEntity.getCustomerDegree());
        results.put("registerDate",dateToString(customerEntity.getCustomerCreateTime()));
        results.put("hostCommentList",hostCommentDtoList);
        results.put("mood",customerEntity.getCustomerMood());
        results.put("userBirthDate", Objects.equals(dateToString(customerEntity.getCustomerBirthday()), "") ?"暂无生日哦":dateToString(customerEntity.getCustomerBirthday()));
        String customerGender = customerEntity.getCustomerGender();
        if(customerGender != null) {
            results.put("usrSex", (customerEntity.getCustomerGender().equals("m")) ? "男" : "女");
        }
        else{
            results.put("usrSex", "");
        }

        return results;


    }

    /**
    * 更改某位顾客的头像Url
     * @param customerId : 顾客Id
     * @param base64File : 图片的base64格式字符串
     * @return : void
    * @author 梁乔
    * @since 23:27 2021-11-25
    */
    @Override
    public void updateAvatar(Long customerId, String base64File) {
        CustomerEntity customer = customerRepository.findFirstByCustomerId(customerId);

        customer.setCustomerAvatarLink(imageService.base64UploadFile(base64File,
                "avatar/"+customerId.toString()+".png"));
        customerRepository.save(customer);

    }



    /**
    * 更改用户的基本信息
     * @param customerInfoDto : 传入的Dto
     * @param customerId : 要更改的用户的用户id
     * @return : void
    * @author 梁乔
    * @since 13:28 2021-11-28
    */
    @Override
    public void updateUserInfo(CustomerInfoDto customerInfoDto, Long customerId) throws ParseException {
        CustomerEntity customer = customerRepository.findFirstByCustomerId(customerId);

        customer.setCustomerName(customerInfoDto.getUserNickName());
        if(customerInfoDto.getUserSex() != null){
            customer.setCustomerGender(customerInfoDto.getUserSex());
        }
        if(customerInfoDto.getUserBirthDate() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = sdf.parse(customerInfoDto.getUserBirthDate());
            java.sql.Date date = new java.sql.Date(d.getTime());
            customer.setCustomerBirthday(date);
        }
        if(customerInfoDto.getMood() != null){
            customer.setCustomerMood(customerInfoDto.getMood());
        }
        customerRepository.save(customer);

    }

    @Override
    public HashMap<String,Object> insertNewFavorite(String favoriteName, Long customerId) {
        FavoriteDirectoryEntity favoriteDirectoryEntity = new FavoriteDirectoryEntity();
        favoriteDirectoryEntity.setName(favoriteName);
        favoriteDirectoryEntity.setCustomerId(customerId);
        favoriteDirectoryRepository.save(favoriteDirectoryEntity);
        List<FavoriteDirectoryEntity> resultEntity = favoriteDirectoryRepository.findAllByName(favoriteName);
        int size = resultEntity.size();
        HashMap<String,Object> result = new HashMap<>();
        result.put("favoriteId",resultEntity.get(size-1).getFavoriteDirectoryId());
        return result;
    }

    /**
    * 根据收藏夹id获取对应收藏夹内第一个房源的第一个房间的第一张照片的URL
     * @param favoriteId : 收藏夹id
     * @return : java.util.HashMap<java.lang.String,java.lang.Object>
    * @author 梁乔
    * @since 10:24 2021-11-29
    */
    @Override
    public HashMap<String, Object> getFavoriteImage(Integer favoriteId) {
        HashMap<String,Object> result = new HashMap<>();
        FavoriteDirectoryStayEntity favoriteDirectoryStayEntity = favoriteDirectoryStayRepository.findFirstByFavoriteDirectoryId(favoriteId);
        if(favoriteDirectoryStayEntity == null){
            result.put("imageURL",null);
        }
        else {
            Long stayId = favoriteDirectoryStayEntity.getStayId();
            RoomPhotoEntity roomPhotoEntity = roomPhotoRepository.findFirstByStayId(stayId);
            result.put("imageURL",roomPhotoEntity.getRoomPhotoLink());
        }
        return result;
    }

    /**
    * 删除特定的收藏夹
     * @param favoriteId : 给出的收藏夹id
     * @return : void
    * @author 梁乔
    * @since 14:09 2021-11-29
    */
    @Override
    public void deleteFavoriteById(Integer favoriteId) {
        FavoriteDirectoryEntity favoriteDirectoryEntity = favoriteDirectoryRepository.findByFavoriteDirectoryId(favoriteId);
        favoriteDirectoryRepository.delete(favoriteDirectoryEntity);
    }


    /**
    * 获取某一收藏夹内所有房源信息
     * @param favoriteId : 收藏夹id
     * @return : java.util.HashMap<java.lang.String,java.lang.Object>
    * @author 梁乔
    * @since 15:29 2021-11-29
    */
    @Override
    public HashMap<String, Object> getFavoriteStayInfo(Integer favoriteId) {
        HashMap<String,Object> result = new HashMap<>();
        List<FavoriteDirectoryStayEntity> favoriteDirectoryStayEntities = favoriteDirectoryStayRepository.findAllByFavoriteDirectoryId(favoriteId);
        List<FavoriteStayInfoDto> favoriteStayInfoDtoList = new ArrayList<>();
        for(FavoriteDirectoryStayEntity favoriteDirectoryStayEntity:favoriteDirectoryStayEntities){
            Long stayId = favoriteDirectoryStayEntity.getStayId();
            StayEntity stayEntity = stayRepository.findByStayId(stayId);
            List<RoomPhotoEntity> roomPhotoEntityList= roomPhotoRepository.findAllByStayId(stayId);
            Integer hostId = stayEntity.getHostId();
            HostEntity hostEntity = hostRepository.findByHostId(hostId);
            CustomerEntity customer = customerRepository.findFirstByCustomerId(hostEntity.getCustomerId());
            ViewStayRoomPriceEntity viewStayRoomPriceEntity = viewStayRoomPriceRepository.findByStayId(stayId);
            favoriteStayInfoDtoList.add(FavoriteStayInfoDtoMapper.getInstance().toDto(stayEntity,roomPhotoEntityList,viewStayRoomPriceEntity,customer));
        }
        result.put("stayList",favoriteStayInfoDtoList);
        return result;
    }

    /**
     * 向特定的收藏夹加入一个房源
     * @param favoriteId 收藏夹id
     * @param stayId 房源id
     */
    @Override
    public void addStayToFavorite(Integer favoriteId, Long stayId) {
        FavoriteDirectoryStayEntity favoriteDirectoryStayEntity = new FavoriteDirectoryStayEntity();
        favoriteDirectoryStayEntity.setFavoriteDirectoryId(favoriteId);
        favoriteDirectoryStayEntity.setStayId(stayId);
        favoriteDirectoryStayRepository.save(favoriteDirectoryStayEntity);
    }


    /**
    * 向特定的收藏夹删除一个房源
     * @param favoriteId : 收藏夹id
     * @param stayId : 房源id
     * @return : void
    * @author 梁乔
    * @since 15:49 2021-11-29
    */
    @Override
    public void deleteStayFromFavorite(Integer favoriteId, Long stayId) {
        FavoriteDirectoryStayEntity favoriteDirectoryStayEntity = new FavoriteDirectoryStayEntity();
        favoriteDirectoryStayEntity.setFavoriteDirectoryId(favoriteId);
        favoriteDirectoryStayEntity.setStayId(stayId);
        favoriteDirectoryStayRepository.delete(favoriteDirectoryStayEntity);
    }

    @Override
    public HashMap<String, Object> getHostInfoByCustomerId(Long customerId) {
        HashMap<String, Object> result = new HashMap<>();
        CustomerEntity customer = customerRepository.findFirstByCustomerId(customerId);
        result.put("hostAvatar",customer.getCustomerAvatarLink());
        result.put("hostNickName",customer.getCustomerName());
        HostEntity hostEntity = hostRepository.findByCustomerId(customerId);
        result.put("hostRealName",hostEntity.getHostRealName());
        result.put("hostSex",customer.getCustomerGender().equals("m")?"男":"女");
        result.put("hostLevel",hostEntity.getHostLevel());
        HostGroupEntity hostGroupEntity = hostGroupRepository.getByHostLevel(hostEntity.getHostLevel());
        result.put("hostLevelName",hostGroupEntity.getHostLevelName());
        result.put("hostScore",hostEntity.getHostScore());
        //获取获得的评价总数
        List<ViewHostStayCommentEntity> viewHostStayCommentEntityList = viewHostStayCommentRepository.findAllByHostId(hostEntity.getHostId());
        if(viewHostStayCommentEntityList != null){
            result.put("reviewNum",viewHostStayCommentEntityList.size());
        }
        else {
            result.put("reviewNum",0);
        }
        result.put("emailTag",customer.getCustomerEmail() != null);
        result.put("phoneTag",customer.getCustomerPhone() != null);
        result.put("authenticationTag",true);
        result.put("hostCreateTime",dateToString(hostEntity.getHostCreateTime()));
        //获取房东平均评分
        if(viewHostStayCommentEntityList !=null) {
            float averageScore = 0;
            for (ViewHostStayCommentEntity viewHostStayCommentEntity:viewHostStayCommentEntityList) {
                averageScore += viewHostStayCommentEntity.getStayScore();
            }
            averageScore = averageScore / viewHostStayCommentEntityList.size();
            result.put("averageRate",averageScore);
        }
        else {
            result.put("averageRate",0);
        }
        return result;

    }

    /**
    * 根据房源id获取详细的房源信息
     * @param stayId :
     * @return : java.util.HashMap<java.lang.String,java.lang.Object>
    * @author 梁乔
    * @since 11:30 2021-11-30
    */
    @Override
    public HashMap<String, Object> getStayInfoByStayId(long stayId) {
        HashMap<String,Object> result = new HashMap<>();
        StayEntity stayEntity = stayRepository.findByStayId(stayId);
        //房源类型
        result.put("stayType",stayEntity.getStayTypeName());
        //最大容纳房客数
        result.put("maxTenantNum",stayEntity.getStayCapacity());
        //卧室数量
        result.put("roomNum",stayEntity.getRoomAmount());
        //床总数
        result.put("bedNum",stayEntity.getBedAmount());
        //公共卫生间数量
        result.put("pubRestNum",stayEntity.getPublicToilet());
        //公共浴室数量
        result.put("pubBathNum",stayEntity.getPublicBathroom());
        //是否有无障碍设施
        result.put("barrierFree",stayEntity.getNonBarrierFacility() != 0);
        //经纬度列表
        List<BigDecimal> positionList = new ArrayList<>();
        positionList.add(stayEntity.getLongitude());
        positionList.add(stayEntity.getLatitude());
        result.put("position",positionList);
        //房源昵称
        result.put("stayName",stayEntity.getStayName());
        //房源描述
        result.put("stayChars",stayEntity.getCharacteristic());
        //开始入住时间点
        result.put("startTime",timeToString(stayEntity.getCheckInTime()));
        //结束入住时间点
        result.put("endTime",timeToString(stayEntity.getCheckOutTime()));
        //最大居住天数
        result.put("maxDay",stayEntity.getDurationMax());
        //最小居住天数
        result.put("minDay",stayEntity.getDurationMin());
        //各卧室信息

        List<String> imgList = new ArrayList<>();

        List<RoomInfoDto> roomInfoDtoList = new ArrayList<>();
        List<RoomEntity> roomEntityList = roomRepository.findAllByStayId(stayId);
        for(RoomEntity room:roomEntityList) {
            RoomInfoDto roomInfoDto = new RoomInfoDto();
            HashMap<String, Integer> bedTypes = new HashMap<>();
            List<RoomBedEntity> roomBedEntityList = roomBedRepository.findAllByStayIdAndRoomId(stayId,room.getRoomId());
            for(RoomBedEntity roomBedEntity:roomBedEntityList){
                bedTypes.put(roomBedEntity.getBedType(),roomBedEntity.getBedAmount());
            }
            roomInfoDto.setBedTypes(bedTypes);
            roomInfoDto.setRoomArea(room.getRoomArea().floatValue());
            roomInfoDto.setPrice(room.getPrice().floatValue());
            roomInfoDto.setBathNum(room.getBathroomAmount());
            roomInfoDtoList.add(roomInfoDto);
            RoomPhotoEntity roomPhotoEntity = roomPhotoRepository.findByStayIdAndRoomId(stayId,room.getRoomId());
            if(roomPhotoEntity != null) {
                imgList.add(roomPhotoEntity.getRoomPhotoLink());
            }
        }
        result.put("roomInfo",roomInfoDtoList);
        //各卧室照片
        result.put("imgList",imgList);
        result.put("stayStatus",stayEntity.getStayStatus());
        List<StayLabelEntity> stayLabelEntityList = stayLabelRepository.findAllByStayId(stayId);
        List<String> stayTags = new ArrayList<>();
        for(StayLabelEntity stayLabelEntity:stayLabelEntityList){
            stayTags.add(stayLabelEntity.getLabelName());
        }
        result.put("stayTags",stayTags);
        return result;
    }

    /**
    * 更新房东的昵称
     * @param customerId : 房东的顾客id
     * @return : void
    * @author 梁乔
    * @since 11:35 2021-11-30
    */
    @Override
    public void updateHostNickName(long customerId,String hostNickName) {
        CustomerEntity customer = customerRepository.findFirstByCustomerId(customerId);
        customer.setCustomerName(hostNickName);
        customerRepository.save(customer);
    }

    /**
    * 获取所有的用户组信息
     * @return : java.util.HashMap<java.lang.String,java.lang.Object>
    * @author 梁乔
    * @since 18:35 2021-11-30
    */
    @Override
    public HashMap<String, Object> getCustomerGroupInfo() {
        HashMap<String,Object> result = new HashMap<>();
        List<CustomerGroupEntity> customerGroupEntityList = customerGroupRepository.findAllBy();
        List<CustomerGroupDto> customerGroupDtoList = new ArrayList<>();
        for(CustomerGroupEntity customerGroupEntity:customerGroupEntityList){
            CustomerGroupDto customerGroupDto = new CustomerGroupDto();
            customerGroupDto.setCustomerGroupLevel(customerGroupEntity.getCustomerLevel());
            customerGroupDto.setCustomerLevelName(customerGroupEntity.getCustomerLevelName());
            customerGroupDto.setCustomerNextLevelDegree(customerGroupEntity.getCustomerLevelDegree());

            //获取详细的礼券信息
            List<CustomerCouponInfoDto> customerCouponInfoDtoList = new ArrayList<>();
            List<CustomerGroupCouponEntity> customerGroupCouponEntityList =  customerCouponRepository.findAllByCustomerLevel(customerGroupEntity.getCustomerLevel());
            for(CustomerGroupCouponEntity customerGroupCouponEntity:customerGroupCouponEntityList){
                int couponTypeId = customerGroupCouponEntity.getCouponTypeId();
                CustomerCouponInfoDto couponInfoDto = new CustomerCouponInfoDto();
                couponInfoDto.setCustomerLevelCouponNum(customerGroupCouponEntity.getCouponAmount());
                CouponTypeEntity couponTypeEntity = couponTypeRepository.findByCouponTypeId(couponTypeId);
                couponInfoDto.setCustomerLevelCouponAmount(couponTypeEntity.getCouponAmount().floatValue());

                customerCouponInfoDtoList.add(couponInfoDto);
            }
            customerGroupDto.setCouponInfoDtoList(customerCouponInfoDtoList);
            customerGroupDtoList.add(customerGroupDto);
        }
        result.put("customerGroup",customerGroupDtoList);
        return result;
    }

    /**
    * 获取房东用户组信息
     * @return : java.util.HashMap<java.lang.String,java.lang.Object>
    * @author 梁乔
    * @since 21:29 2021-11-30
    */
    @Override
    public HashMap<String, Object> getHostGroupInfo() {
        HashMap<String, Object> result = new HashMap<>();
        List<HostGroupEntity> hostGroupEntityList = hostGroupRepository.findAllBy();
        List<HostGroupDto> hostGroupDtoList = new ArrayList<>();
        for(HostGroupEntity hostGroupEntity:hostGroupEntityList){
            HostGroupDto hostGroupDto = new HostGroupDto();
            hostGroupDto.setHostLevel(hostGroupEntity.getHostLevel());
            hostGroupDto.setHostLevelName(hostGroupEntity.getHostLevelName());
            hostGroupDto.setHostLevelDegree(hostGroupEntity.getHostLevelDegree());
            hostGroupDtoList.add(hostGroupDto);
        }
        result.put("customerGroup",hostGroupDtoList);
        return result;
    }

    /**
     * 删除某一顾客收藏的某一房源
     * @param customerId
     * @param stayId
     * @return
     */
    @Override
    public Boolean deleteSpecificStayInFavorite(long customerId, long stayId){
        //
        List<FavoriteDirectoryEntity> favoriteDirectoryList =
                favoriteDirectoryRepository.findAllByCustomerId(customerId);
        for(FavoriteDirectoryEntity favoriteDirectory: favoriteDirectoryList){
            FavoriteDirectoryStayEntity favoriteStay=
            favoriteDirectoryStayRepository.
                    findFirstByFavoriteDirectoryIdAndStayId((favoriteDirectory.getFavoriteDirectoryId()),stayId);
            if (favoriteStay!=null){
                favoriteDirectoryStayRepository.delete(favoriteStay);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean getSpecificStayLikeState(long customerId, long stayId){
        List<FavoriteDirectoryEntity> favoriteDirectoryList =
                favoriteDirectoryRepository.findAllByCustomerId(customerId);
        for(FavoriteDirectoryEntity favoriteDirectory: favoriteDirectoryList){
            FavoriteDirectoryStayEntity favoriteStay=
                    favoriteDirectoryStayRepository.
                            findFirstByFavoriteDirectoryIdAndStayId((favoriteDirectory.getFavoriteDirectoryId()),stayId);
            if (favoriteStay!=null){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<HashMap<String, Object>> getFavoriteDirectory(long customerId){
        List<FavoriteDirectoryEntity> favoriteDirectoryList
                = favoriteDirectoryRepository.findAllByCustomerId(customerId);
        List<HashMap<String, Object>> res = new ArrayList<>();
        for(FavoriteDirectoryEntity favoriteDirectory: favoriteDirectoryList){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("favoriteId", favoriteDirectory.getFavoriteDirectoryId());
            hashMap.put("name", favoriteDirectory.getName());

            List<FavoriteDirectoryStayEntity> directoryStayList=
                    favoriteDirectoryStayRepository
                            .findAllByFavoriteDirectoryId(favoriteDirectory.getFavoriteDirectoryId());

            // 获取该收藏下内房源的数量
            hashMap.put("totalStay",directoryStayList.size());

            // 图片
            for(FavoriteDirectoryStayEntity favoriteStay:directoryStayList){
                List<String> photos=getAllPhotoByStayId(favoriteStay.getStayId());
                if (photos.size()!=0){
                    hashMap.put("imgUrl",photos.get(0));
                    break;
                }
            }

            res.add(hashMap);
        }
        return res;
    }

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

    private String timeToString(Time time){
        String timeStr = "";
        if(time != null){
        DateFormat sdf = new SimpleDateFormat("hh:mm");
        try{
            timeStr = sdf.format(time);
        }catch (Exception e){
            e.printStackTrace();
        }}
        return timeStr;
    }

    private String dateToString(Timestamp timestamp){
        String dateStr = "";
        if(timestamp != null){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            dateStr = sdf.format(timestamp);
        }catch (Exception e){
            e.printStackTrace();
        }
        }
        return dateStr;
    }

    private String dateToString(Date date){
        String dateStr = "";
        if(date != null) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dateStr = sdf.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dateStr;
    }



}