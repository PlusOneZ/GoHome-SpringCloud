package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.RoomBedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface RoomBedEntityRepository extends JpaRepository<RoomBedEntity, Long>, JpaSpecificationExecutor<RoomBedEntity> {
    @Query("select count(r) from RoomBedEntity r where r.roomId = ?1")
    Integer countAllByRoomId(int roomId);
}