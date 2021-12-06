package cn.edu.tongji.gohome.statistics.repository;

import cn.edu.tongji.gohome.statistics.model.ViewStayMonthOrderCommentScoreEntity;
import cn.edu.tongji.gohome.statistics.model.ViewStayMonthOrderCommentScoreEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ViewStayMonthOrderCommentScoreRepository
extends JpaRepository<ViewStayMonthOrderCommentScoreEntity,
        ViewStayMonthOrderCommentScoreEntityPK>,
        JpaSpecificationExecutor<ViewStayMonthOrderCommentScoreEntity> {
    List<ViewStayMonthOrderCommentScoreEntity>
        findAllByStayId(long stayId);
}
