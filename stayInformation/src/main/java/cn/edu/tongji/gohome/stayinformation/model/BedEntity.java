package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * TODO:此处写BedEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "bed", schema = "GoHome", catalog = "")
public class BedEntity {
    private String bedType;
    private BigDecimal bedWidth;
    private byte personAmount;

    @Id
    @Column(name = "bed_type")
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Basic
    @Column(name = "bed_width")
    public BigDecimal getBedWidth() {
        return bedWidth;
    }

    public void setBedWidth(BigDecimal bedWidth) {
        this.bedWidth = bedWidth;
    }

    @Basic
    @Column(name = "person_amount")
    public byte getPersonAmount() {
        return personAmount;
    }

    public void setPersonAmount(byte personAmount) {
        this.personAmount = personAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BedEntity bedEntity = (BedEntity) o;

        if (personAmount != bedEntity.personAmount) return false;
        if (bedType != null ? !bedType.equals(bedEntity.bedType) : bedEntity.bedType != null) return false;
        if (bedWidth != null ? !bedWidth.equals(bedEntity.bedWidth) : bedEntity.bedWidth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bedType != null ? bedType.hashCode() : 0;
        result = 31 * result + (bedWidth != null ? bedWidth.hashCode() : 0);
        result = 31 * result + (int) personAmount;
        return result;
    }
}
