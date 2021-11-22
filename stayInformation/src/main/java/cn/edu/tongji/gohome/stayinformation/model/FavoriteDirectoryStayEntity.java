package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写FavoriteDirectoryStayEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
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
