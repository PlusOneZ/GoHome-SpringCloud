package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostLikeRepository extends JpaRepository<PostLikeEntity, Long>, JpaSpecificationExecutor<PostLikeEntity> {
}