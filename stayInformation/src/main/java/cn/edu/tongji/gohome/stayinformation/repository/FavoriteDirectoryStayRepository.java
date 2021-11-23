package cn.edu.tongji.gohome.stayinformation.repository;

import cn.edu.tongji.gohome.stayinformation.model.FavoriteDirectoryStayEntity;
import cn.edu.tongji.gohome.stayinformation.model.FavoriteDirectoryStayEntityPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FavoriteDirectoryStayRepository
        extends JpaRepository<FavoriteDirectoryStayEntity, FavoriteDirectoryStayEntityPK>,
        JpaSpecificationExecutor<FavoriteDirectoryStayEntity>{
    List<FavoriteDirectoryStayEntity> findAllByFavoriteDirectoryId(int favoriteDirectoryId);
}

