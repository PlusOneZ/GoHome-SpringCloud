package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO:此处写PostReportEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/12/15 15:50
 */
@Entity
@Table(name = "post_report", schema = "GoHome", catalog = "")
@IdClass(PostReportEntityPK.class)
public class PostReportEntity {
    private long reportCustomerId;
    private long beReportedCustomerId;
    private String reportReason;
    private Timestamp reportTime;
    private byte isDealt;
    private Integer adminId;
    private Timestamp dealTime;
    private String reply;

    @Id
    @Basic
    @Column(name = "report_customer_id")
    public long getReportCustomerId() {
        return reportCustomerId;
    }

    public void setReportCustomerId(long reportCustomerId) {
        this.reportCustomerId = reportCustomerId;
    }

    @Id
    @Basic
    @Column(name = "be_reported_customer_id")
    public long getBeReportedCustomerId() {
        return beReportedCustomerId;
    }

    public void setBeReportedCustomerId(long beReportedCustomerId) {
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
    public byte getIsDealt() {
        return isDealt;
    }

    public void setIsDealt(byte isDealt) {
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

        if (reportCustomerId != that.reportCustomerId) return false;
        if (beReportedCustomerId != that.beReportedCustomerId) return false;
        if (isDealt != that.isDealt) return false;
        if (reportReason != null ? !reportReason.equals(that.reportReason) : that.reportReason != null) return false;
        if (reportTime != null ? !reportTime.equals(that.reportTime) : that.reportTime != null) return false;
        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null) return false;
        if (dealTime != null ? !dealTime.equals(that.dealTime) : that.dealTime != null) return false;
        if (reply != null ? !reply.equals(that.reply) : that.reply != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (reportCustomerId ^ (reportCustomerId >>> 32));
        result = 31 * result + (int) (beReportedCustomerId ^ (beReportedCustomerId >>> 32));
        result = 31 * result + (reportReason != null ? reportReason.hashCode() : 0);
        result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
        result = 31 * result + (int) isDealt;
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (dealTime != null ? dealTime.hashCode() : 0);
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        return result;
    }
}
