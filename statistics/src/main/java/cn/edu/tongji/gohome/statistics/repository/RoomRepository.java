package cn.edu.tongji.gohome.statistics.repository;


import cn.edu.tongji.gohome.statistics.model.RoomEntity;
import cn.edu.tongji.gohome.statistics.model.RoomEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, RoomEntityPK>,
        JpaSpecificationExecutor<RoomEntity> {

    List<RoomEntity> getAllByStayId(long stayId);

    void deleteAllByStayId(long stayId);
}
