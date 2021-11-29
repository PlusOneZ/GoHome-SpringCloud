package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * StayRepository类的DAO
 * @author 梁乔
 * @since 2021/11/23 16:52
 */
public interface StayRepository extends JpaRepository<StayEntity, Long> {
    StayEntity findByStayId(Long stayId);

}