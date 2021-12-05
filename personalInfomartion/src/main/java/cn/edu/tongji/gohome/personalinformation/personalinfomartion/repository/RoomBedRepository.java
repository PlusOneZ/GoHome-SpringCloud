package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;/**
 * @author 梁乔 2021/11/30
 **/

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.RoomBedEntity;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.RoomBedEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 此处写RoomBedRepository类的描述
 * @author 梁乔
 * @since 2021/11/30 10:59 
 */
public interface RoomBedRepository extends JpaRepository<RoomBedEntity, RoomBedEntityPK> {
    List<RoomBedEntity> findAllByStayIdAndRoomId(long stayId, int roomId);
}