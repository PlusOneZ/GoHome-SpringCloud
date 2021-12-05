package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * TODO:此处写ViewStayRoomPriceEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/5 20:54
 */
@Entity
@Table(name = "view_stay_room_price", schema = "GoHome", catalog = "")
public class ViewStayRoomPriceEntity {
    private long stayId;
    private BigDecimal minPrice;

    @Id
    @Basic
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Basic
    @Column(name = "min_price")
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewStayRoomPriceEntity that = (ViewStayRoomPriceEntity) o;

        if (stayId != that.stayId) return false;
        if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        return result;
    }
}
