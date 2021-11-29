package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/29
 **/

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 此处写ViewStayRoomPriceEntity类的描述
 * @author 梁乔
 * @since 2021/11/29 14:52 
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
        return stayId == that.stayId && Objects.equals(minPrice, that.minPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, minPrice);
    }
}