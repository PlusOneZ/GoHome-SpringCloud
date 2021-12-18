package cn.edu.tongji.gohome.post.dto;

/**
 * TODO:此处写PostReport类的描述
 *
 * @author 汪明杰
 * @date 2021/12/15 15:57
 */
public class PostReport {
    private Long reportedCustomerId;
    private String reportReason;

    public Long getReportedCustomerId() {
        return reportedCustomerId;
    }

    public void setReportedCustomerId(Long reportedCustomerId) {
        this.reportedCustomerId = reportedCustomerId;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }
}
