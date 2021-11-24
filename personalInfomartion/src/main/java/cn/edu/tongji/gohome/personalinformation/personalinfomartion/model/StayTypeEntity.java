package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/23
 **/

import javax.persistence.*;
import java.util.Objects;

/**
 * StayTypeEntity类
 * @author 梁乔
 * @since 2021/11/23 16:59
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
        return Objects.equals(stayTypeName, that.stayTypeName) && Objects.equals(characteristic, that.characteristic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayTypeName, characteristic);
    }
}