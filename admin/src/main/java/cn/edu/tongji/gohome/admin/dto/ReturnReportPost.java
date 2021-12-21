package cn.edu.tongji.gohome.admin.dto;

import java.sql.Timestamp;

public class ReturnReportPost {

    private Long customerId;

    private Long reporterId;

    private Timestamp reportTime;


    public Long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
        this.reporterId = reporterId;
    }

    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
