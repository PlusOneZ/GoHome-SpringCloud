package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.ViewStayOrderNumberEntity;
import cn.edu.tongji.gohome.stayinformation.model.ViewStayRoomPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewStayOrderNumberRepository
extends JpaRepository<ViewStayOrderNumberEntity,Long> {
    ViewStayOrderNumberEntity findFirstByStayId(Long stayId);
}
