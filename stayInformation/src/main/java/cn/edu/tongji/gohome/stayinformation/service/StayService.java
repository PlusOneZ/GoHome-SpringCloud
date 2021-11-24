package cn.edu.tongji.gohome.stayinformation.service;

import cn.edu.tongji.gohome.stayinformation.dto.HostStay;
import cn.edu.tongji.gohome.stayinformation.dto.StayInfoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/**
 * StayService类
 *
 * @author 汪明杰
 * @date 2021/11/22 21:42
 */
@Service
public interface StayService {
    StayInfoDto searchStayDetailedInfoForStayId(long stayId);

    BigDecimal getLowestRoomForStayId(long stayId);

    HashMap<String, Object> getStayPositionsWithinArea(double westLng, double southLat,
                                             double eastLng, double northLat);

    List<HashMap<String, Object>> getAllStayByHostIdAndStatus
            (int hostId, BigInteger stayStatus);

    List<String> getAllPhotoByStayId(Long stayId);

    HashMap<String, Object> getHostInfoByStayId(Long stayId);

    boolean isHostFavoriteByCustomerId(Long stayId, long customerId);

    HashMap<String, Object> getStayMapInfoByStayId(Long stayId, long customerId);

    HashMap<String, Object> getStayBriefInfoByStayId(Long stayId, long customerId);

    List<String> getAllLabelByStayId(Long stayId);

    void insertIntoStay(HostStay hostStay, int hostId);
}
