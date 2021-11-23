package cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.impl;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.HostCommentDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.mapper.HostCommentDtoMapper;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository.*;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.service.CustomerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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