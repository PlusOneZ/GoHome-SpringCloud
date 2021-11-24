package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostTagRepository extends JpaRepository<PostTagEntity, Long>, JpaSpecificationExecutor<PostTagEntity> {
}