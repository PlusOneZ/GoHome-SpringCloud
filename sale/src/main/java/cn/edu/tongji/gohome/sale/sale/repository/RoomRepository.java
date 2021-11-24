package cn.edu.tongji.gohome.sale.sale.repository;

import cn.edu.tongji.gohome.sale.sale.model.RoomEntity;
import cn.edu.tongji.gohome.sale.sale.model.RoomEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author 梁乔 2021/11/24
 **/
public interface RoomRepository extends JpaRepository<RoomEntity, RoomEntityPK> , JpaSpecificationExecutor<RoomEntity> {

    RoomEntity findAllByStayIdAndRoomId(long stayId, int roomId);

}
