package cn.edu.tongji.gohome.statistics.repository;

import cn.edu.tongji.gohome.statistics.model.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @author: 汪明杰
 */

public interface StayRepository extends JpaRepository<StayEntity, Long> {

    StayEntity findFirstByStayId(long stayId);

    List<StayEntity> findAllByHostId(int hostId);

    List<StayEntity> findAllByHostIdAndStayStatus(int hostId, BigInteger stayStatus);

    List<StayEntity> findAllByLongitudeBetweenAndLatitudeBetween(
            BigDecimal westLng, BigDecimal eastLng, BigDecimal southLat, BigDecimal northLat
    );

    List<StayEntity> findByStayStatusOrderByCommentScoreDesc(BigInteger stayStatus, Pageable pageable);
}
