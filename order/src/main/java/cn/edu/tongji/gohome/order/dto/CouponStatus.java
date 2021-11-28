package
        cn.edu.tongji.gohome.order.dto;

/**
 * class description
 *
 * @author : loey
 * @className : CouponStatus
 * @since : 2021-11-27 22:13
 **/
public class CouponStatus {

    private CouponStatus(){ }

    private static final CouponStatus status = new CouponStatus();

    public static CouponStatus getInstance(){
        return status;
    }

    public static int COUPON_UNUSED = 0;
    public static int COUPON_USED = 1;
    public static int COUPON_EXPIRED = 2;
}