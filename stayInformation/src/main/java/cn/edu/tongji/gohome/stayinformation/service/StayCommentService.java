package cn.edu.tongji.gohome.stayinformation.service;

import cn.edu.tongji.gohome.stayinformation.dto.StayCommentInfoDto;
import org.springframework.stereotype.Service;


/**
 * StayCommentService类
 *
 * @author 汪明杰
 * @date 2021/11/22 18:43
 */
@Service
public interface StayCommentService {
    StayCommentInfoDto searchCommentInfoForStayId(long stayId);

    int getCommentNumberForHostId(int hostId);
}