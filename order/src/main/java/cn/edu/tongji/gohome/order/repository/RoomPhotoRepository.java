package cn.edu.tongji.gohome.order.repository;

import cn.edu.tongji.gohome.order.model.RoomPhotoEntity;
import cn.edu.tongji.gohome.order.model.RoomPhotoEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoomPhotoRepository extends JpaRepository<RoomPhotoEntity, RoomPhotoEntityPK>,
        JpaSpecificationExecutor<RoomPhotoEntity> {
    RoomPhotoEntity findFirstByStayIdAndRoomId(long stayId, int roomId);
}
