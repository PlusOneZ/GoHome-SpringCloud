package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.mapper;/**
 * @author 梁乔 2021/11/23
 **/

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto.HostCommentDto;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.CustomerEntity;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.HostCommentEntity;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.HostEntity;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
* 将多表映射未用户评论DTO
* @author 梁乔
* @since 2021-11-23 21:31
*/
public class HostCommentDtoMapper {
    private static final HostCommentDtoMapper mapper = new HostCommentDtoMapper();

    private HostCommentDtoMapper(){}

    public static HostCommentDtoMapper getInstance(){return mapper;}

    public HostCommentDto toDto(HostCommentEntity hostCommentEntity, HostEntity hostEntity, CustomerEntity customerEntity){
        HostCommentDto hostCommentDto;
        if(hostCommentEntity == null && hostEntity == null && customerEntity == null){
            return null;
        }
        else
        {
            return convert(hostCommentEntity, hostEntity, customerEntity);
        }
    }

    private HostCommentDto convert(HostCommentEntity hostCommentEntity, HostEntity hostEntity, CustomerEntity customerEntity){
        HostCommentDto hostCommentDto;
        hostCommentDto = convert(hostCommentEntity, hostEntity);
        hostCommentDto.setHostAvatar(customerEntity.getCustomerAvatarLink());
        hostCommentDto.setHostNickName(customerEntity.getCustomerName());
        return hostCommentDto;
    }

    private HostCommentDto convert(HostCommentEntity hostCommentEntity, HostEntity hostEntity){
        HostCommentDto hostCommentDto;
        hostCommentDto = convert(hostCommentEntity);
        hostCommentDto.setHostId(hostEntity.getHostId());
        hostCommentDto.setHostRegisterDate(timeStampToString(hostEntity.getHostCreateTime()));
        return hostCommentDto;
    }

    private HostCommentDto convert(HostCommentEntity hostCommentEntity){

        HostCommentDto hostCommentDto = new HostCommentDto();
        hostCommentDto.setComment(hostCommentEntity.getHostCommentContent());
        hostCommentDto.setCommentStar(hostCommentEntity.getCustomerScore());
        hostCommentDto.setCommentTime(timeStampToString(hostCommentEntity.getHostCommentTime()));

        return hostCommentDto;

    }

    private String timeStampToString(Timestamp timestamp){
        String dateStr = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            dateStr = sdf.format(timestamp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dateStr;
    }

}