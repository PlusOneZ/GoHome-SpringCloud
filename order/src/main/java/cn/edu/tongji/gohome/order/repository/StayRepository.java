package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<StayEntity, Long> {

    StayEntity findFirstByStayId(long stayId);
}
