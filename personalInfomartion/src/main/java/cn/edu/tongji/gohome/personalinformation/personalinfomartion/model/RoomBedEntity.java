package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/30
 **/

import javax.persistence.*;
import java.util.Objects;

/**
 * 此处写RoomBedEntity类的描述
 * @author 梁乔
 * @since 2021/11/30 10:58 
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
        return stayId == that.stayId && roomId == that.roomId && bedAmount == that.bedAmount && Objects.equals(bedType, that.bedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, bedType, bedAmount);
    }
}