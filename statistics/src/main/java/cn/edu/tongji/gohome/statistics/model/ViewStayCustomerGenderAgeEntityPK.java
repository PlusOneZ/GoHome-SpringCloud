package cn.edu.tongji.gohome.statistics.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * ViewStayCustomerGenderAgeEntityPK类
 *
 * @author 汪明杰
 * @date 2021/12/6 1:34
 */
public class ViewStayCustomerGenderAgeEntityPK implements Serializable {
    private long stayId;
    private long customerId;

    @Column(name = "stay_id")
    @Id
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Column(name = "customer_id")
    @Id
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewStayCustomerGenderAgeEntityPK that = (ViewStayCustomerGenderAgeEntityPK) o;

        if (stayId != that.stayId) return false;
        if (customerId != that.customerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + (int) (stayId ^ (stayId >>> 32));
        return result;
    }
}