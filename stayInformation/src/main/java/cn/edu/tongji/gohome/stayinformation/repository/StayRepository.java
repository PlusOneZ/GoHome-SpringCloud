package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 汪明杰
 */

public interface StayRepository extends JpaRepository<StayEntity, Long> {

    StayEntity findFirstByStayId(long stayId);
}
