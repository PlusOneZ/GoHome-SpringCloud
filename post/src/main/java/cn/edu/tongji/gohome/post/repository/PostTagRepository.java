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


    @Query("select distinct p.postTag from PostTagEntity p")
    Page<String> findAllDistinctTag(Pageable pageable);

    @Query("select count(p.postId) from PostTagEntity p where p.postTag = ?1")
    int findCountPostIdByTag(String tag);

    @Query("select distinct p.postTag from PostTagEntity p where p.postId = ?1")
    List<String> findAllDistinctTagByPostId(long postId);



    List<PostTagEntity> findAllByPostId(long postId);

    @Query("select distinct p.postId from PostTagEntity p where p.postTag = ?1")
    Page<Long> findAllDistinctPostIdByPostTag(String tag, Pageable pageable);
}