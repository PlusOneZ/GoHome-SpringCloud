package cn.edu.tongji.gohome.stayinformation.service;

import cn.edu.tongji.gohome.stayinformation.dto.StayInfoDto;
import org.springframework.stereotype.Service;

/**
 * StayService类
 *
 * @author 汪明杰
 * @date 2021/11/22 21:42
 */
@Service
public interface StayService {
    StayInfoDto searchStayDetailedInfoForStayId(long stayId);
}
