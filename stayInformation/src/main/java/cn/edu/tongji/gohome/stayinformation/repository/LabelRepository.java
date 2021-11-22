package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.LabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LabelRepository类
 *
 * @author 汪明杰
 * @date 2021/11/22 20:48
 */
public interface LabelRepository extends JpaRepository<LabelEntity, Long> {

}