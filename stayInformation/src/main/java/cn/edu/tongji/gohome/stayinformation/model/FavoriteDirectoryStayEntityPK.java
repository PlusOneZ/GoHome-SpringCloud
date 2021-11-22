package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO:此处写FavoriteDirectoryStayEntityPK类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
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

        if (favoriteDirectoryId != that.favoriteDirectoryId) return false;
        if (stayId != that.stayId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = favoriteDirectoryId;
        result = 31 * result + (int) (stayId ^ (stayId >>> 32));
        return result;
    }
}
