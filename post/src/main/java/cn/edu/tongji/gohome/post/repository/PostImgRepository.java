package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostImgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostImgRepository extends JpaRepository<PostImgEntity, Long>, JpaSpecificationExecutor<PostImgEntity> {
    List<PostImgEntity> findAllByPostId(long postId);

    @Query("select distinct p.postImgLink from PostImgEntity p where p.postId = ?1")
    List<String> findDistinctByPostId(long postId);
}