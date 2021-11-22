package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.RoomPhotoEntity;
import cn.edu.tongji.gohome.stayinformation.model.RoomPhotoEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * RoomPhotoRepository类
 *
 * @author 汪明杰
 * @date 2021/11/22 22:13
 */
public interface RoomPhotoRepository extends JpaRepository<RoomPhotoEntity, RoomPhotoEntityPK>,
        JpaSpecificationExecutor<RoomPhotoEntity> {
    RoomPhotoEntity findFirstByRoomId(int roomId);
}
