package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/30
 **/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 此处写RoomBedEntityPK类的描述
 * @author 梁乔
 * @since 2021/11/30 10:58 
 */
public class RoomBedEntityPK implements Serializable {
    private long stayId;
    private int roomId;
    private String bedType;

    @Column(name = "stay_id")
    @Id
    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }

    @Column(name = "room_id")
    @Id
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Column(name = "bed_type")
    @Id
    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomBedEntityPK that = (RoomBedEntityPK) o;
        return stayId == that.stayId && roomId == that.roomId && Objects.equals(bedType, that.bedType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, bedType);
    }
}