package cn.edu.tongji.gohome.sale.sale.dto;

/**
 * <b>礼券使用情况的Dto</b>
 * @author 梁乔
 * @since 2021/11/24 21:37 
 */
public class CouponUsageDto {
    private boolean couponAvailable;
    private String couponId;
    private String couponName;
    private float couponValue;

    public boolean isCouponAvailable() {
        return couponAvailable;
    }

    public void setCouponAvailable(boolean couponAvailable) {
        this.couponAvailable = couponAvailable;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public float getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(float couponValue) {
        this.couponValue = couponValue;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
}