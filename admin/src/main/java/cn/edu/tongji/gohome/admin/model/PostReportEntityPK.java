package cn.edu.tongji.gohome.admin.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostReportEntityPK implements Serializable {
    private Long reportCustomerId;
    private Long beReportedCustomerId;

    @Column(name = "report_customer_id")
    @Id
    public Long getReportCustomerId() {
        return reportCustomerId;
    }

    public void setReportCustomerId(Long reportCustomerId) {
        this.reportCustomerId = reportCustomerId;
    }

    @Column(name = "be_reported_customer_id")
    @Id
    public Long getBeReportedCustomerId() {
        return beReportedCustomerId;
    }

    public void setBeReportedCustomerId(Long beReportedCustomerId) {
        this.beReportedCustomerId = beReportedCustomerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostReportEntityPK that = (PostReportEntityPK) o;
        return Objects.equals(reportCustomerId, that.reportCustomerId) && Objects.equals(beReportedCustomerId, that.beReportedCustomerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportCustomerId, beReportedCustomerId);
    }
}
