package cn.edu.tongji.gohome.post.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostLikeEntityPK implements Serializable {
    private long postId;
    private long customerId;

    @Column(name = "post_id")
    @Id
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Column(name = "customer_id")
    @Id
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostLikeEntityPK that = (PostLikeEntityPK) o;
        return postId == that.postId && customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, customerId);
    }
}
