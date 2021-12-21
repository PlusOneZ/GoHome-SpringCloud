package cn.edu.tongji.gohome.admin.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post_report", schema = "GoHome", catalog = "")
@IdClass(PostReportEntityPK.class)
public class PostReportEntity {
    private Long reportCustomerId;
    private Long beReportedCustomerId;
    private String reportReason;
    private Timestamp reportTime;
    private Byte isDealt;
    private Integer adminId;
    private Timestamp dealTime;
    private String reply;
    private Integer replyFlag;

    @Id
    @Column(name = "report_customer_id")
    public Long getReportCustomerId() {
        return reportCustomerId;
    }

    public void setReportCustomerId(Long reportCustomerId) {
        this.reportCustomerId = reportCustomerId;
    }

    @Id
    @Column(name = "be_reported_customer_id")
    public Long getBeReportedCustomerId() {
        return beReportedCustomerId;
    }

    public void setBeReportedCustomerId(Long beReportedCustomerId) {
        this.beReportedCustomerId = beReportedCustomerId;
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
    @Column(name = "report_time")
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "is_dealt")
    public Byte getIsDealt() {
        return isDealt;
    }

    public void setIsDealt(Byte isDealt) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostReportEntity that = (PostReportEntity) o;
        return Objects.equals(reportCustomerId, that.reportCustomerId) && Objects.equals(beReportedCustomerId, that.beReportedCustomerId) && Objects.equals(reportReason, that.reportReason) && Objects.equals(reportTime, that.reportTime) && Objects.equals(isDealt, that.isDealt) && Objects.equals(adminId, that.adminId) && Objects.equals(dealTime, that.dealTime) && Objects.equals(reply, that.reply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportCustomerId, beReportedCustomerId, reportReason, reportTime, isDealt, adminId, dealTime, reply);
    }

    @Basic
    @Column(name = "reply_flag")
    public Integer getReplyFlag() {
        return replyFlag;
    }

    public void setReplyFlag(Integer replyFlag) {
        this.replyFlag = replyFlag;
    }
}
