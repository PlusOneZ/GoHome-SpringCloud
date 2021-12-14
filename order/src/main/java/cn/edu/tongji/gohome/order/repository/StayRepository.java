package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StayRepository extends JpaRepository<StayEntity, Long> {

    StayEntity findFirstByStayId(long stayId);

    List<StayEntity> findAllByHostId(int hostId);
}
