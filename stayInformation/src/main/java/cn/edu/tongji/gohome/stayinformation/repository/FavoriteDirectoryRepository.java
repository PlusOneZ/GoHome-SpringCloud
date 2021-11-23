package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.FavoriteDirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FavoriteDirectoryRepository
        extends JpaRepository<FavoriteDirectoryEntity, Integer>,
        JpaSpecificationExecutor<FavoriteDirectoryEntity> {
    List<FavoriteDirectoryEntity> findAllByCustomerId(long customerId);
}
