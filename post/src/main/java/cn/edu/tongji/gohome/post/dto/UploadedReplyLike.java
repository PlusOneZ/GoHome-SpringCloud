package cn.edu.tongji.gohome.post.dto;

public class UploadedReplyLike {
    private Long replyId;
    private Long customerId;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
