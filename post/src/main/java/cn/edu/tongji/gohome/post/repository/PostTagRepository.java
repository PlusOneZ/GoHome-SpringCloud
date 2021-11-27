package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostEntity;
import cn.edu.tongji.gohome.post.model.PostTagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface PostTagRepository extends JpaRepository<PostTagEntity, Long>, JpaSpecificationExecutor<PostTagEntity> {


    List<PostTagEntity> findAllByPostId(long postId);

    @Query("select p.postTag from PostTagEntity p")
    Page<String> findAllBy(Pageable pageable);

    @Query("select distinct p.postTag from PostTagEntity p where p.postId = ?1")
    List<String> findDistinctByPostId(long postId);
}