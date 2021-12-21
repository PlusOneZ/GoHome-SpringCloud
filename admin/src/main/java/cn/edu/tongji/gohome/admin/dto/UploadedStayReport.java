package cn.edu.tongji.gohome.admin.dto;

public class UploadedStayReport {
    private long orderId;
    private boolean isBan;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isBan() {
        return isBan;
    }

    public void setBan(boolean ban) {
        isBan = ban;
    }
}
