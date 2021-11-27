package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.RoomBedEntity;
import cn.edu.tongji.gohome.stayinformation.model.RoomBedEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * RoomBedRepository接口
 *
 * @author 汪明杰
 * @date 2021/11/22 22:16
 */
public interface RoomBedRepository extends JpaRepository<RoomBedEntity, RoomBedEntityPK>,
        JpaSpecificationExecutor<RoomBedEntity> {
    List<RoomBedEntity> findAllByRoomIdAndStayId(int roomId, long stayId);

    void deleteAllByStayId(long stayId);
}
