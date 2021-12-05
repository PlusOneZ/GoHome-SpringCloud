package cn.edu.tongji.gohome.statistics.repository;

import cn.edu.tongji.gohome.statistics.model.ViewStayRoomPriceEntity;
import cn.edu.tongji.gohome.statistics.model.ViewStayRoomPriceStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewStayRoomPriceStatusRepository
extends JpaRepository<ViewStayRoomPriceStatusEntity,Long> {
}

