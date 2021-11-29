package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.repository;/**
 * @author 梁乔 2021/11/28
 **/

import cn.edu.tongji.gohome.personalinformation.personalinfomartion.model.FavoriteDirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 此处写FavoriteDirectoryRepository类的描述
 * @author 梁乔
 * @since 2021/11/28 14:11 
 */
public interface FavoriteDirectoryRepository extends JpaRepository<FavoriteDirectoryEntity,Integer> {
    FavoriteDirectoryEntity findByFavoriteDirectoryId(int favoriteDirectoryId);
    FavoriteDirectoryEntity findTopByName(String favoriteDirectoryName);
    List<FavoriteDirectoryEntity> findAllByName(String favoriteDiretoryName);
}