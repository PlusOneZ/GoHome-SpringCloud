package cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.FavoriteDirectoryStayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 梁乔 2021/11/29
 **/
public interface FavoriteDirectoryStayRepository extends JpaRepository<FavoriteDirectoryStayEntity,Integer> {
    FavoriteDirectoryStayEntity findFirstByFavoriteDirectoryId(Integer favoriteDirectoryId);
    List<FavoriteDirectoryStayEntity> findAllByFavoriteDirectoryId(Integer favoriteDirectoryId);
    FavoriteDirectoryStayEntity findFirstByFavoriteDirectoryIdAndStayId(Integer favoriteDirectoryId, long stayId);
}
