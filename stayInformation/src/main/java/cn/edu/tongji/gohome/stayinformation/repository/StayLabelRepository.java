package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.StayLabelEntity;
import cn.edu.tongji.gohome.stayinformation.model.StayLabelEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StayLabelRepository
        extends JpaRepository<StayLabelEntity, StayLabelEntityPK>,
        JpaSpecificationExecutor<StayLabelEntity> {
    List<StayLabelEntity> findAllByStayId(Long stayId);

    void deleteAllByStayId(long stayId);


}