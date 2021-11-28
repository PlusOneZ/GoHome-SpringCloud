package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/28
 **/

import javax.persistence.*;
import java.util.Objects;

/**
 * 此处写FavoriteDirectoryEntity类的描述
 * @author 梁乔
 * @since 2021/11/28 14:01 
 */
@Entity
@Table(name = "favorite_directory", schema = "GoHome", catalog = "")
public class FavoriteDirectoryEntity {
    private int favoriteDirectoryId;
    private long customerId;
    private String name;

    @Id
    @Column(name = "favorite_directory_id")
    public int getFavoriteDirectoryId() {
        return favoriteDirectoryId;
    }

    public void setFavoriteDirectoryId(int favoriteDirectoryId) {
        this.favoriteDirectoryId = favoriteDirectoryId;
    }

    @Basic
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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
        return favoriteDirectoryId == that.favoriteDirectoryId && customerId == that.customerId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteDirectoryId, customerId, name);
    }
}