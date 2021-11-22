package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * TODO:此处写StayLabelEntityPK类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
public class StayLabelEntityPK implements Serializable {
    private long stayId;
    private String labelName;

    @Column(name = "stay_id")
    @Id
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Column(name = "label_name")
    @Id
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StayLabelEntityPK that = (StayLabelEntityPK) o;

        if (stayId != that.stayId) return false;
        if (labelName != null ? !labelName.equals(that.labelName) : that.labelName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + (labelName != null ? labelName.hashCode() : 0);
        return result;
    }
}
