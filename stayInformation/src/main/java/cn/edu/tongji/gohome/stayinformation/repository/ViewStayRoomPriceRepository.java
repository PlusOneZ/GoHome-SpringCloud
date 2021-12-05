package cn.edu.tongji.gohome.stayinformation.repository;


import cn.edu.tongji.gohome.stayinformation.model.ViewStayRoomPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewStayRoomPriceRepository extends
        JpaRepository<ViewStayRoomPriceEntity, Long> {
    ViewStayRoomPriceEntity findFirstByStayId(Long stayId);
}
