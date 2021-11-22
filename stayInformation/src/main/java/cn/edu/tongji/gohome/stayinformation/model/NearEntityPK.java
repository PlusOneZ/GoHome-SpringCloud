package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO:此处写NearEntityPK类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
public class NearEntityPK implements Serializable {
    private int peripheralId;
    private long stayId;

    @Column(name = "peripheral_id")
    @Id
    public int getPeripheralId() {
        return peripheralId;
    }

    public void setPeripheralId(int peripheralId) {
        this.peripheralId = peripheralId;
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

        NearEntityPK that = (NearEntityPK) o;

        if (peripheralId != that.peripheralId) return false;
        if (stayId != that.stayId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = peripheralId;
        result = 31 * result + (int) (stayId ^ (stayId >>> 32));
        return result;
    }
}
