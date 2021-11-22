package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写PeripheralEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "peripheral", schema = "GoHome", catalog = "")
public class PeripheralEntity {
    private int peripheralId;
    private String peripheralName;
    private String peripheralClass;
    private Integer peripheralPopularity;
    private String detailedAddress;

    @Id
    @Column(name = "peripheral_id")
    public int getPeripheralId() {
        return peripheralId;
    }

    public void setPeripheralId(int peripheralId) {
        this.peripheralId = peripheralId;
    }

    @Basic
    @Column(name = "peripheral_name")
    public String getPeripheralName() {
        return peripheralName;
    }

    public void setPeripheralName(String peripheralName) {
        this.peripheralName = peripheralName;
    }

    @Basic
    @Column(name = "peripheral_class")
    public String getPeripheralClass() {
        return peripheralClass;
    }

    public void setPeripheralClass(String peripheralClass) {
        this.peripheralClass = peripheralClass;
    }

    @Basic
    @Column(name = "peripheral_popularity")
    public Integer getPeripheralPopularity() {
        return peripheralPopularity;
    }

    public void setPeripheralPopularity(Integer peripheralPopularity) {
        this.peripheralPopularity = peripheralPopularity;
    }

    @Basic
    @Column(name = "detailed_address")
    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeripheralEntity that = (PeripheralEntity) o;

        if (peripheralId != that.peripheralId) return false;
        if (peripheralName != null ? !peripheralName.equals(that.peripheralName) : that.peripheralName != null)
            return false;
        if (peripheralClass != null ? !peripheralClass.equals(that.peripheralClass) : that.peripheralClass != null)
            return false;
        if (peripheralPopularity != null ? !peripheralPopularity.equals(that.peripheralPopularity) : that.peripheralPopularity != null)
            return false;
        if (detailedAddress != null ? !detailedAddress.equals(that.detailedAddress) : that.detailedAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = peripheralId;
        result = 31 * result + (peripheralName != null ? peripheralName.hashCode() : 0);
        result = 31 * result + (peripheralClass != null ? peripheralClass.hashCode() : 0);
        result = 31 * result + (peripheralPopularity != null ? peripheralPopularity.hashCode() : 0);
        result = 31 * result + (detailedAddress != null ? detailedAddress.hashCode() : 0);
        return result;
    }
}
