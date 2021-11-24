package cn.edu.tongji.gohome.stayinformation.dto;

import java.util.List;

/**
 * 关于某一个房源全部评价的Dto
 *
 * @author 汪明杰
 * @date 2021/11/22 16:47
 */
public class StayCommentInfoDto {
    private Double ratings;
    private long commentNum;
    private List<CommentDto> comments;

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}


