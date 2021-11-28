package
        cn.edu.tongji.gohome.order.dto;

/**
 * class description
 *
 * @author : loey
 * @className : OrderStatus
 * @since : 2021-11-27 19:12
 **/
public class OrderStatus {

    private static final OrderStatus status = new OrderStatus();

    public static OrderStatus getInstance(){
        return status;
    }

    private OrderStatus(){ }

    public static final int ORDER_CONFIRMATION_COMPLETED = 1;
    public static final int ORDER_PAYMENT_COMPLETED = 2;
    public static final int ORDER_BUSINESS_COMPLETING = 3;
    public static final int ORDER_BUSINESS_COMPLETED = 4;
    public static final int ORDER_TRANSACTION_COMPLETED = 5;
    public static final int ORDER_BUSINESS_REPORTED = 6;
}