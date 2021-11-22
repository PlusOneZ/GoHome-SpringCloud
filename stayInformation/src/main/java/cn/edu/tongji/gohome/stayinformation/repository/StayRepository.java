package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: 汪明杰
 */

public interface StayRepository extends JpaRepository<StayEntity, Long> {

    StayEntity findFirstByStayId(long stayId);

    List<StayEntity> findAllByHostId(int hostId);
}
