package
        cn.edu.tongji.gohome.sale.sale.dto;/**
 * @author 梁乔 2021/11/30
 **/

import java.sql.Date;

/**
 * 此处写CouponInfoDto类的描述
 * @author 梁乔
 * @since 2021/11/30 15:41 
 */
public class CouponInfoDto {
    String couponName;
    float couponAmount;
    float couponLimit;
    Date couponStartDate;
    Date couponEndDate;
    Long couponId;

    public String getCouponName() {
        return couponName;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Date getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(Date couponEndDate) {
        this.couponEndDate = couponEndDate;
    }

    public Date getCouponStartDate() {
        return couponStartDate;
    }

    public void setCouponStartDate(Date couponStartDate) {
        this.couponStartDate = couponStartDate;
    }

    public float getCouponLimit() {
        return couponLimit;
    }

    public void setCouponLimit(float couponLimit) {
        this.couponLimit = couponLimit;
    }

    public float getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(float couponAmount) {
        this.couponAmount = couponAmount;
    }
}