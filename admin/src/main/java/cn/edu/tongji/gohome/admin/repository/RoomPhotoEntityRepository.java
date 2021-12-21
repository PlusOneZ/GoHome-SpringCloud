package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.RoomPhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface RoomPhotoEntityRepository extends JpaRepository<RoomPhotoEntity, Long>, JpaSpecificationExecutor<RoomPhotoEntity> {
    @Query("select r.roomPhotoLink from RoomPhotoEntity r where r.stayId = ?1")
    ArrayList<String> findAllByStayId(Long stayId);
}