package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO:此处写CustomerGroupCouponEntityPK类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
public class CustomerGroupCouponEntityPK implements Serializable {
    private int customerLevel;
    private int couponTypeId;

    @Column(name = "customer_level")
    @Id
    public int getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(int customerLevel) {
        this.customerLevel = customerLevel;
    }

    @Column(name = "coupon_type_id")
    @Id
    public int getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(int couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerGroupCouponEntityPK that = (CustomerGroupCouponEntityPK) o;

        if (customerLevel != that.customerLevel) return false;
        if (couponTypeId != that.couponTypeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerLevel;
        result = 31 * result + couponTypeId;
        return result;
    }
}
