package cn.edu.tongji.gohome.post.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostTagEntityPK implements Serializable {
    private long postId;
    private String postTag;

    @Column(name = "post_id")
    @Id
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Column(name = "post_tag")
    @Id
    public String getPostTag() {
        return postTag;
    }

    public void setPostTag(String postTag) {
        this.postTag = postTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTagEntityPK that = (PostTagEntityPK) o;
        return postId == that.postId && Objects.equals(postTag, that.postTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postTag);
    }
}
