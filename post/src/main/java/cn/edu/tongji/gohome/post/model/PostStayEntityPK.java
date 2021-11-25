package cn.edu.tongji.gohome.post.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostStayEntityPK implements Serializable {
    private long postId;
    private long stayId;

    @Column(name = "post_id")
    @Id
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Column(name = "stay_id")
    @Id
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostStayEntityPK that = (PostStayEntityPK) o;
        return postId == that.postId && stayId == that.stayId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, stayId);
    }
}
