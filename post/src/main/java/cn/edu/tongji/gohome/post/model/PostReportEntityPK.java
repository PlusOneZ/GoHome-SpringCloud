package cn.edu.tongji.gohome.post.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO:此处写PostReportEntityPK类的描述
 *
 * @author 汪明杰
 * @date 2021/12/15 15:50
 */
public class PostReportEntityPK implements Serializable {
    private long reportCustomerId;
    private long beReportedCustomerId;

    @Id
    @Column(name = "report_customer_id")
    public long getReportCustomerId() {
        return reportCustomerId;
    }

    public void setReportCustomerId(long reportCustomerId) {
        this.reportCustomerId = reportCustomerId;
    }

    @Id
    @Column(name = "be_reported_customer_id")
    public long getBeReportedCustomerId() {
        return beReportedCustomerId;
    }

    public void setBeReportedCustomerId(long beReportedCustomerId) {
        this.beReportedCustomerId = beReportedCustomerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostReportEntityPK that = (PostReportEntityPK) o;

        if (reportCustomerId != that.reportCustomerId) return false;
        if (beReportedCustomerId != that.beReportedCustomerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (reportCustomerId ^ (reportCustomerId >>> 32));
        result = 31 * result + (int) (beReportedCustomerId ^ (beReportedCustomerId >>> 32));

        return result;
    }
}
