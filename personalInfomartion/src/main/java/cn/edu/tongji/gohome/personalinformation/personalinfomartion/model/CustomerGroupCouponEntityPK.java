package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/30
 **/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 此处写CustomerGroupCouponEntityPK类的描述
 * @author 梁乔
 * @since 2021/11/30 18:38 
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
        return customerLevel == that.customerLevel && couponTypeId == that.couponTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerLevel, couponTypeId);
    }
}