package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_like", schema = "GoHome", catalog = "")
@IdClass(PostLikeEntityPK.class)
public class PostLikeEntity {
    private long postId;
    private long customerId;

    @Id
    @Column(name = "post_id")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Id
    @Column(name = "customer_id")
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
        PostLikeEntity that = (PostLikeEntity) o;
        return postId == that.postId && customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, customerId);
    }
}
