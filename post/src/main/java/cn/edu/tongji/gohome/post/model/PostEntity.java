package cn.edu.tongji.gohome.post.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post", schema = "GoHome", catalog = "")
public class PostEntity {
    private long postId;
    private Timestamp postTime;
    private String postContent;
    private String postTheme;
    private int replyCount;
    private int likeCount;
    private long customerId;

    @Id
    @Column(name = "post_id")
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "post_time")
    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Basic
    @Column(name = "post_content")
    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Basic
    @Column(name = "post_theme")
    public String getPostTheme() {
        return postTheme;
    }

    public void setPostTheme(String postTheme) {
        this.postTheme = postTheme;
    }

    @Basic
    @Column(name = "reply_count")
    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    @Basic
    @Column(name = "like_count")
    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return postId == that.postId && replyCount == that.replyCount && likeCount == that.likeCount && Objects.equals(postTime, that.postTime) && Objects.equals(postContent, that.postContent) && Objects.equals(postTheme, that.postTheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postTime, postContent, postTheme, replyCount, likeCount);
    }

    @Basic
    @Column(name = "customer_id")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
