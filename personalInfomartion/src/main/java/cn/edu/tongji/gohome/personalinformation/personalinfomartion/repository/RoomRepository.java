package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.RoomEntity;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 梁乔 2021/11/29
 **/
public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
    List<RoomEntity> findAllByStayId(long stayId);
    List<RoomEntity> getAllByStayId(long stayId);
}
