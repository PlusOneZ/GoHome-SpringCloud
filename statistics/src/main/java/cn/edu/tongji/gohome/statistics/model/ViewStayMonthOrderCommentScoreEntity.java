package cn.edu.tongji.gohome.statistics.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * ViewStayMonthOrderCommentScoreEntity类
 *
 * @author 汪明杰
 * @date 2021/12/6 9:53
 */
@Entity
@Table(name = "view_stay_month_order_comment_score", schema = "GoHome", catalog = "")
@IdClass(ViewStayMonthOrderCommentScoreEntityPK.class)
public class ViewStayMonthOrderCommentScoreEntity {
    private long stayId;
    private Integer orderYear;
    private Integer orderMonth;
    private long orderNumber;
    private long commentNumber;
    private BigDecimal avgScore;

    @Id
    @Basic
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Basic
    @Column(name = "order_year")
    public Integer getOrderYear() {
        return orderYear;
    }

    public void setOrderYear(Integer orderYear) {
        this.orderYear = orderYear;
    }

    @Id
    @Basic
    @Column(name = "order_month")
    public Integer getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(Integer orderMonth) {
        this.orderMonth = orderMonth;
    }

    @Basic
    @Column(name = "order_number")
    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "comment_number")
    public long getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(long commentNumber) {
        this.commentNumber = commentNumber;
    }

    @Basic
    @Column(name = "avg_score")
    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewStayMonthOrderCommentScoreEntity that = (ViewStayMonthOrderCommentScoreEntity) o;

        if (stayId != that.stayId) return false;
        if (orderNumber != that.orderNumber) return false;
        if (commentNumber != that.commentNumber) return false;
        if (orderYear != null ? !orderYear.equals(that.orderYear) : that.orderYear != null) return false;
        if (orderMonth != null ? !orderMonth.equals(that.orderMonth) : that.orderMonth != null) return false;
        if (avgScore != null ? !avgScore.equals(that.avgScore) : that.avgScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (orderYear != null ? orderYear.hashCode() : 0);
        result = 31 * result + (orderMonth != null ? orderMonth.hashCode() : 0);
        result = 31 * result + (int) (orderNumber ^ (orderNumber >>> 32));
        result = 31 * result + (int) (commentNumber ^ (commentNumber >>> 32));
        result = 31 * result + (avgScore != null ? avgScore.hashCode() : 0);
        return result;
    }
}
