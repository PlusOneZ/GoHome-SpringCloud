package cn.edu.tongji.gohome.post.dto;

public class UploadedReply {
    private Long postId;

    private Long customerId;

    private String replyContent;

    private Long preReplyId;


    public Long getPreReplyId() {
        return preReplyId;
    }

    public void setPreReplyId(Long preReplyId) {
        this.preReplyId = preReplyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
