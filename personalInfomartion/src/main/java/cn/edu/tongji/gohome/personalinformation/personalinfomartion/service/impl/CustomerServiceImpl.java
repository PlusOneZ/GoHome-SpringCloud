package cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.impl;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.CustomerInfoDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.FavoriteStayInfoDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.HostCommentDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.mapper.FavoriteStayInfoDtoMapper;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.mapper.HostCommentDtoMapper;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.CustomerInfoService;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.ImageService;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;

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
        results.put("userBirthDate",dateToString(customerEntity.getCustomerBirthday()));
        results.put("usrSex",(customerEntity.getCustomerGender().equals("m"))?"男":"女");

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


    private String dateToString(Timestamp timestamp){
        String dateStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            dateStr = sdf.format(timestamp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dateStr;
    }

    private String dateToString(Date date){
        String dateStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            dateStr = sdf.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dateStr;
    }



}