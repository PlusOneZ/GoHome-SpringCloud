package
        cn.edu.tongji.gohome.order.dto;

import java.sql.Timestamp;

/**
 * the report for order.
 *
 * @className: Report
 * @author: loey
 * @date: 2021-11-23 18:12
 **/
public class Report {
    private long orderId;
    private String reportReason;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }
}