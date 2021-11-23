package cn.edu.tongji.gohome.stayinformation.dto.mapper;

import cn.edu.tongji.gohome.stayinformation.dto.CommentDto;
import cn.edu.tongji.gohome.stayinformation.model.CustomerCommentEntity;
import cn.edu.tongji.gohome.stayinformation.model.CustomerEntity;

/**
 * CommentMapper类
 *
 * @author 汪明杰
 * @date 2021/11/22 19:14
 */
public class CommentMapper {
    private static final CommentMapper mapper = new CommentMapper();

    private CommentMapper(){}

    public static CommentMapper getInstance(){
        return mapper;
    }

    public CommentDto toDto(CustomerEntity customerEntity,
                               CustomerCommentEntity customerCommentEntity){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(customerCommentEntity.getCustomerCommentId());
        commentDto.setCommentScore(customerCommentEntity.getStayScore());
        // 用户是否已注销
        if (customerEntity == null){
            commentDto.setNickName("已注销");
            commentDto.setAvatar("");
        }
        else{
            commentDto.setNickName(customerEntity.getCustomerName());
            commentDto.setAvatar(customerEntity.getCustomerAvatarLink());
        }
        commentDto.setDate(customerCommentEntity.getCustomerCommentTime());
        commentDto.setCommentContent(customerCommentEntity.getCustomerCommentContent());

        return commentDto;
    }
}
