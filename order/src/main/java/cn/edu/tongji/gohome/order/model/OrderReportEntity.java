package
        cn.edu.tongji.gohome.order.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * TODO
 *
 * @className: OrderReportEntity
 * @author: loey
 * @date: 2021-11-19 21:18
 **/
@Entity
@Table(name = "order_report", schema = "GoHome", catalog = "")
public class OrderReportEntity {
    private int reportId;
    private long orderId;
    private Timestamp reportTime;
    private String reportReason;
    private byte isDealt;
    private Integer adminId;
    private Timestamp dealTime;
    private String reply;

    @Id
    @Column(name = "report_id", nullable = false)
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "report_time", nullable = false)
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "report_reason", nullable = false, length = 400)
    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    @Basic
    @Column(name = "is_dealt", nullable = false)
    public byte getIsDealt() {
        return isDealt;
    }

    public void setIsDealt(byte isDealt) {
        this.isDealt = isDealt;
    }

    @Basic
    @Column(name = "admin_id", nullable = true)
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "deal_time", nullable = true)
    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    @Basic
    @Column(name = "reply", nullable = true, length = 400)
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

        OrderReportEntity that = (OrderReportEntity) o;

        if (reportId != that.reportId) return false;
        if (orderId != that.orderId) return false;
        if (isDealt != that.isDealt) return false;
        if (reportTime != null ? !reportTime.equals(that.reportTime) : that.reportTime != null) return false;
        if (reportReason != null ? !reportReason.equals(that.reportReason) : that.reportReason != null) return false;
        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null) return false;
        if (dealTime != null ? !dealTime.equals(that.dealTime) : that.dealTime != null) return false;
        if (reply != null ? !reply.equals(that.reply) : that.reply != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reportId;
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
        result = 31 * result + (reportReason != null ? reportReason.hashCode() : 0);
        result = 31 * result + (int) isDealt;
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (dealTime != null ? dealTime.hashCode() : 0);
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        return result;
    }
}