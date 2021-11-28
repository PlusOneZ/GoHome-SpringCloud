package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/28
 **/

import javax.persistence.*;
import java.util.Objects;

/**
 * 此处写FavoriteDirectoryStayEntity类的描述
 * @author 梁乔
 * @since 2021/11/28 14:01 
 */
@Entity
@Table(name = "favorite_directory_stay", schema = "GoHome", catalog = "")
@IdClass(FavoriteDirectoryStayEntityPK.class)
public class FavoriteDirectoryStayEntity {
    private int favoriteDirectoryId;
    private long stayId;

    @Id
    @Column(name = "favorite_directory_id")
    public int getFavoriteDirectoryId() {
        return favoriteDirectoryId;
    }

    public void setFavoriteDirectoryId(int favoriteDirectoryId) {
        this.favoriteDirectoryId = favoriteDirectoryId;
    }

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteDirectoryStayEntity that = (FavoriteDirectoryStayEntity) o;
        return favoriteDirectoryId == that.favoriteDirectoryId && stayId == that.stayId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteDirectoryId, stayId);
    }
}