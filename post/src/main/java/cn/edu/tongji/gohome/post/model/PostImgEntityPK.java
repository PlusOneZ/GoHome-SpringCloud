package cn.edu.tongji.gohome.post.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostImgEntityPK implements Serializable {
    private long postId;
    private String postImgLink;

    @Column(name = "post_id")
    @Id
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Column(name = "post_img_link")
    @Id
    public String getPostImgLink() {
        return postImgLink;
    }

    public void setPostImgLink(String postImgLink) {
        this.postImgLink = postImgLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostImgEntityPK that = (PostImgEntityPK) o;
        return postId == that.postId && Objects.equals(postImgLink, that.postImgLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postImgLink);
    }
}
