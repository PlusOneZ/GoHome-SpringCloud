package cn.edu.tongji.gohome.stayinformation.service.impl;

import cn.edu.tongji.gohome.stayinformation.dto.CommentDto;
import cn.edu.tongji.gohome.stayinformation.dto.StayCommentInfoDto;
import cn.edu.tongji.gohome.stayinformation.dto.mapper.CommentMapper;
import cn.edu.tongji.gohome.stayinformation.model.CustomerCommentEntity;
import cn.edu.tongji.gohome.stayinformation.model.CustomerEntity;
import cn.edu.tongji.gohome.stayinformation.model.OrderStayEntity;
import cn.edu.tongji.gohome.stayinformation.repository.CustomerCommentRepository;
import cn.edu.tongji.gohome.stayinformation.repository.CustomerRepository;
import cn.edu.tongji.gohome.stayinformation.repository.OrderStayRepository;
import cn.edu.tongji.gohome.stayinformation.repository.StayRepository;
import cn.edu.tongji.gohome.stayinformation.service.StayCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.List;

/**
 * StayCommentServiceImpl类
 *
 * @author 汪明杰
 * @date 2021/11/22 18:47
 */
@Service
public class StayCommentServiceImpl implements StayCommentService {

    @Resource
    private StayRepository stayRepository;

    @Resource
    private OrderStayRepository orderStayRepository;

    @Resource
    private CustomerCommentRepository customerCommentRepository;

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public StayCommentInfoDto searchCommentInfoForStayId(long stayId){

        // 评论集合
        List<CommentDto> commentDtoList = new ArrayList<>();

        List<OrderStayEntity> orderStayEntityList =
                orderStayRepository.findAllByStayId(stayId);

        double aveRatings = 0;
        int sumComment = 0;

        for(int i = 0; i<orderStayEntityList.size(); ++i){
            long orderId = orderStayEntityList.get(i).getOrderId();

            // 根据orderId找到对应的评论实体
            CustomerCommentEntity customerCommentEntity =
                    customerCommentRepository.findFirstByOrderId(orderId);

            // 用户无评论
            if (customerCommentEntity == null){
                continue;
            }
            // 根据customerId获取其昵称和头像
            CustomerEntity customerEntity =
                    customerRepository.findCustomerEntityByCustomerId(customerCommentEntity.getCustomerCommentId());

            // 新增CommentDto
            CommentDto commentDto = CommentMapper.getInstance().toDto(customerEntity, customerCommentEntity);

            commentDtoList.add(commentDto);
            aveRatings += customerCommentEntity.getStayScore();
            sumComment += 1;
        }

        StayCommentInfoDto stayCommentInfoDto = new StayCommentInfoDto();

        if (sumComment == 0){
            stayCommentInfoDto.setRatings(0.0);
            stayCommentInfoDto.setCommentNum(0);
        }
        else{
            stayCommentInfoDto.setRatings(aveRatings / sumComment);
            stayCommentInfoDto.setCommentNum(commentDtoList.size());
        }
        stayCommentInfoDto.setComments(commentDtoList);

        return stayCommentInfoDto;

    }
}
