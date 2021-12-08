package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostStayEntity;
import cn.edu.tongji.gohome.post.model.PostTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PostStayRepository extends JpaRepository<PostStayEntity, Long>, JpaSpecificationExecutor<PostStayEntity> {
    List<PostStayEntity> findAllByPostId(long postId);
}