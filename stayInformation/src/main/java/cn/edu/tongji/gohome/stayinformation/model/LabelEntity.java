package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写LabelEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "label", schema = "GoHome", catalog = "")
public class LabelEntity {
    private String labelName;
    private byte labelType;

    @Id
    @Column(name = "label_name")
    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Basic
    @Column(name = "label_type")
    public byte getLabelType() {
        return labelType;
    }

    public void setLabelType(byte labelType) {
        this.labelType = labelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabelEntity that = (LabelEntity) o;

        if (labelType != that.labelType) return false;
        if (labelName != null ? !labelName.equals(that.labelName) : that.labelName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labelName != null ? labelName.hashCode() : 0;
        result = 31 * result + (int) labelType;
        return result;
    }
}
