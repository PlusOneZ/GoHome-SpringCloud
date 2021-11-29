package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.ViewStayRoomPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 梁乔 2021/11/29
 **/
public interface ViewStayRoomPriceRepository extends JpaRepository<ViewStayRoomPriceEntity,Long> {
    ViewStayRoomPriceEntity findByStayId(Long stayId);

}
