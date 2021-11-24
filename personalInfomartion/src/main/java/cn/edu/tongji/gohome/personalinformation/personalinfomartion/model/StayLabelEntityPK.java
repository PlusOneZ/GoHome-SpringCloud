package cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * tayLabelEntityPK类
 * @author 梁乔
 * @since 2021/11/23 16:59
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
        return stayId == that.stayId && Objects.equals(labelName, that.labelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, labelName);
    }
}