package cn.edu.tongji.gohome.stayinformation.repository;


import cn.edu.tongji.gohome.stayinformation.model.RoomEntity;
import cn.edu.tongji.gohome.stayinformation.model.RoomEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, RoomEntityPK>,
        JpaSpecificationExecutor<RoomEntity> {

    List<RoomEntity> getAllByStayId(long stayId);
}
