package cn.edu.tongji.gohome.admin.dto;

import java.sql.Timestamp;

public class ReturnDetailReportPost {

    private Timestamp reportTime;
    private String reportReason;
    private Long reportCustomerId;
    private Long beReportedCustomerId;


    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public Long getReportCustomerId() {
        return reportCustomerId;
    }

    public void setReportCustomerId(Long reportCustomerId) {
        this.reportCustomerId = reportCustomerId;
    }

    public Long getBeReportedCustomerId() {
        return beReportedCustomerId;
    }

    public void setBeReportedCustomerId(Long beReportedCustomerId) {
        this.beReportedCustomerId = beReportedCustomerId;
    }
}
