package cn.edu.tongji.gohome.admin.dto;

import java.sql.Timestamp;

public class ReturnDetailStayReport {

    private Timestamp reportTime;
    private String reportReason;
    private Integer hostId;
    private Long stayId;
    private Integer hostCredit;


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

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    public Integer getHostCredit() {
        return hostCredit;
    }

    public void setHostCredit(Integer hostCredit) {
        this.hostCredit = hostCredit;
    }
}
