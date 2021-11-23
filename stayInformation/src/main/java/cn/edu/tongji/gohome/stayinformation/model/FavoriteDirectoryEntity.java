package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写FavoriteDirectoryEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "favorite_directory", schema = "GoHome", catalog = "")
public class FavoriteDirectoryEntity {
    private int favoriteDirectoryId;
    private String name;
    private long customerId;

    @Id
    @Column(name = "favorite_directory_id")
    public int getFavoriteDirectoryId() {
        return favoriteDirectoryId;
    }

    public void setFavoriteDirectoryId(int favoriteDirectoryId) {
        this.favoriteDirectoryId = favoriteDirectoryId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoriteDirectoryEntity that = (FavoriteDirectoryEntity) o;

        if (favoriteDirectoryId != that.favoriteDirectoryId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = favoriteDirectoryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
