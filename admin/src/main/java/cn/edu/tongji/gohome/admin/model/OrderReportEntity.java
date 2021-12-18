package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_report", schema = "GoHome", catalog = "")
public class OrderReportEntity {
    private Long reportId;
    private Long orderId;
    private Timestamp reportTime;
    private String reportReason;
    private Integer isDealt;
    private Integer adminId;
    private Timestamp dealTime;
    private String reply;
    private Integer replyFlag;

    @Id
    @Column(name = "report_id")
    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "report_time")
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "report_reason")
    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    @Basic
    @Column(name = "is_dealt")
    public Integer getIsDealt() {
        return isDealt;
    }

    public void setIsDealt(Integer isDealt) {
        this.isDealt = isDealt;
    }

    @Basic
    @Column(name = "admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "deal_time")
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    @Basic
    @Column(name = "reply")
    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Basic
    @Column(name = "reply_flag")
    public Integer getReplyFlag() {
        return replyFlag;
    }

    public void setReplyFlag(Integer replyFlag) {
        this.replyFlag = replyFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderReportEntity that = (OrderReportEntity) o;
        return Objects.equals(reportId, that.reportId) && Objects.equals(orderId, that.orderId) && Objects.equals(reportTime, that.reportTime) && Objects.equals(reportReason, that.reportReason) && Objects.equals(isDealt, that.isDealt) && Objects.equals(adminId, that.adminId) && Objects.equals(dealTime, that.dealTime) && Objects.equals(reply, that.reply) && Objects.equals(replyFlag, that.replyFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, orderId, reportTime, reportReason, isDealt, adminId, dealTime, reply, replyFlag);
    }
}
