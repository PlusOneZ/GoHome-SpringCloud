package cn.edu.tongji.gohome.post.repository;

import cn.edu.tongji.gohome.post.model.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {
    Page<PostEntity> findAllByCustomerId(Long customerId, Pageable pageable);
}