package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写StayTypeEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "stay_type", schema = "GoHome", catalog = "")
public class StayTypeEntity {
    private String stayTypeName;
    private String characteristic;

    @Id
    @Column(name = "stay_type_name")
    public String getStayTypeName() {
        return stayTypeName;
    }

    public void setStayTypeName(String stayTypeName) {
        this.stayTypeName = stayTypeName;
    }

    @Basic
    @Column(name = "characteristic")
    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StayTypeEntity that = (StayTypeEntity) o;

        if (stayTypeName != null ? !stayTypeName.equals(that.stayTypeName) : that.stayTypeName != null) return false;
        if (characteristic != null ? !characteristic.equals(that.characteristic) : that.characteristic != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stayTypeName != null ? stayTypeName.hashCode() : 0;
        result = 31 * result + (characteristic != null ? characteristic.hashCode() : 0);
        return result;
    }
}
