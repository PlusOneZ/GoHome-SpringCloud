package cn.edu.tongji.gohome.statistics.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * ViewStayMonthOrderCommentScoreEntityPK类
 *
 * @author 汪明杰
 * @date 2021/12/6 9:53
 */
public class ViewStayMonthOrderCommentScoreEntityPK implements Serializable {
    private long stayId;
    private Integer orderYear;
    private Integer orderMonth;

    @Column(name = "stay_id")
    @Id
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }



    @Column(name = "order_year")
    @Id
    public Integer getOrderYear() {
        return orderYear;
    }

    public void setOrderYear(Integer orderYear) {
        this.orderYear = orderYear;
    }


    @Column(name = "order_month")
    @Id
    public Integer getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(Integer orderMonth) {
        this.orderMonth = orderMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewStayMonthOrderCommentScoreEntityPK that =
                (ViewStayMonthOrderCommentScoreEntityPK) o;

        if (orderMonth != that.orderMonth) return false;
        if (stayId != that.stayId) return false;
        if (orderYear != that.orderYear) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + orderYear;
        result = 31 * result + orderMonth;
        return result;
    }

}
