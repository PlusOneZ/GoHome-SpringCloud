package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostImgRepository extends JpaRepository<PostImgEntity, Long>, JpaSpecificationExecutor<PostImgEntity> {
}