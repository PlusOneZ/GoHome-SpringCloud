package cn.edu.tongji.gohome.admin.repository;

import cn.edu.tongji.gohome.admin.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PostEntityRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {
    @Transactional
    @Query("delete from PostEntity p where p.customerId = ?1")
    @Modifying
    void deleteByCustomerId(Long customerId);
}