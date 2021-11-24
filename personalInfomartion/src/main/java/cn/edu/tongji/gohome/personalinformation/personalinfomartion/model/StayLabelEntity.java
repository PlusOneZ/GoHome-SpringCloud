package cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;
import javax.persistence.*;
import java.util.Objects;

/**
 * StayLabelEntity类
 * @author 梁乔
 * @date 2021/11/23 16:59 
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
        return stayId == that.stayId && Objects.equals(labelName, that.labelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, labelName);
    }
}