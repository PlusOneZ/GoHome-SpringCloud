package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * TODO:此处写NearEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "near", schema = "GoHome", catalog = "")
@IdClass(NearEntityPK.class)
public class NearEntity {
    private int peripheralId;
    private long stayId;
    private BigDecimal distance;

    @Id
    @Column(name = "peripheral_id")
    public int getPeripheralId() {
        return peripheralId;
    }

    public void setPeripheralId(int peripheralId) {
        this.peripheralId = peripheralId;
    }

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Basic
    @Column(name = "distance")
    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NearEntity that = (NearEntity) o;

        if (peripheralId != that.peripheralId) return false;
        if (stayId != that.stayId) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = peripheralId;
        result = 31 * result + (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }
}
