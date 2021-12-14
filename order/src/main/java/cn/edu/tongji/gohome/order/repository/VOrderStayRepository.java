package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.VOrderStayEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VOrderStayRepository extends JpaRepository<VOrderStayEntity, Long> {

        Page<VOrderStayEntity> findAllByStayId(long stayId, Pageable pageable);

        Page<VOrderStayEntity> findAllByStayIdIn(List<Long> stayList, Pageable pageable);

        VOrderStayEntity findFirstByOrderId(long orderId);
}
