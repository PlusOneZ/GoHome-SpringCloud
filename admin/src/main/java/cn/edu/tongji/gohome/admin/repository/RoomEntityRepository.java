package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface RoomEntityRepository extends JpaRepository<RoomEntity, Long>, JpaSpecificationExecutor<RoomEntity> {
    @Query("select r from RoomEntity r where r.stayId = ?1")
    ArrayList<RoomEntity> findAllByStayId(Long stayId);
}