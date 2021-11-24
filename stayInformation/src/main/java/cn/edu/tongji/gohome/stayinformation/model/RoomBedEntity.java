package cn.edu.tongji.gohome.stayinformation.model;

import javax.persistence.*;

/**
 * TODO:此处写RoomBedEntity类的描述
 *
 * @author 汪明杰
 * @date 2021/11/19 17:17
 */
@Entity
@Table(name = "room_bed", schema = "GoHome", catalog = "")
@IdClass(RoomBedEntityPK.class)
public class RoomBedEntity {
    private long stayId;
    private int roomId;
    private String bedType;
    private int bedAmount;

    @Id
    @Column(name = "stay_id")
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Id
    @Column(name = "bed_type")
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Basic
    @Column(name = "bed_amount")
    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomBedEntity that = (RoomBedEntity) o;

        if (stayId != that.stayId) return false;
        if (roomId != that.roomId) return false;
        if (bedAmount != that.bedAmount) return false;
        if (bedType != null ? !bedType.equals(that.bedType) : that.bedType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + roomId;
        result = 31 * result + (bedType != null ? bedType.hashCode() : 0);
        result = 31 * result + bedAmount;
        return result;
    }
}
