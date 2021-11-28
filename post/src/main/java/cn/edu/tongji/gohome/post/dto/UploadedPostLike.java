package cn.edu.tongji.gohome.post.dto;

public class UploadedPostLike {
    private Long postId;

    private Long customerId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
