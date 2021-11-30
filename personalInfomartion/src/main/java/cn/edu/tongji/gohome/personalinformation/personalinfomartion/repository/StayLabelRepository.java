package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.StayLabelEntity;
import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.StayLabelEntityPK;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 梁乔 2021/11/30
 **/
public interface StayLabelRepository extends JpaRepository<StayLabelEntity, StayLabelEntityPK>
{
    List<StayLabelEntity> findAllByStayId(long stayId);
}
