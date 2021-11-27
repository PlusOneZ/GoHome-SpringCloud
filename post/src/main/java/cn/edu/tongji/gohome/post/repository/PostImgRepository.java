package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PostImgRepository extends JpaRepository<PostImgEntity, Long>, JpaSpecificationExecutor<PostImgEntity> {
    List<PostImgEntity> findAllByPostId(long postId);
}