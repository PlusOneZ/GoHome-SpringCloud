package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写StayLabelEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "stay_label", schema = "GoHome", catalog = "")
@IdClass(StayLabelEntityPK.class)
public class StayLabelEntity {
    private long stayId;
    private String labelName;

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "label_name")
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

        StayLabelEntity that = (StayLabelEntity) o;

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
