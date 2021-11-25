package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostStayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostStayRepository extends JpaRepository<PostStayEntity, Long>, JpaSpecificationExecutor<PostStayEntity> {
}