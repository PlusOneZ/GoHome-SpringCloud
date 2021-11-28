package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/28
 **/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 此处写FavoriteDirectoryStayEntityPK类的描述
 * @author 梁乔
 * @since 2021/11/28 14:01 
 */
public class FavoriteDirectoryStayEntityPK implements Serializable {
    private int favoriteDirectoryId;
    private long stayId;

    @Column(name = "favorite_directory_id")
    @Id
    public int getFavoriteDirectoryId() {
        return favoriteDirectoryId;
    }

    public void setFavoriteDirectoryId(int favoriteDirectoryId) {
        this.favoriteDirectoryId = favoriteDirectoryId;
    }

    @Column(name = "stay_id")
    @Id
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
        FavoriteDirectoryStayEntityPK that = (FavoriteDirectoryStayEntityPK) o;
        return favoriteDirectoryId == that.favoriteDirectoryId && stayId == that.stayId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteDirectoryId, stayId);
    }
}