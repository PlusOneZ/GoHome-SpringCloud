package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/29
 **/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 此处写RoomEntityPK类的描述
 * @author 梁乔
 * @since 2021/11/29 13:05 
 */
public class RoomEntityPK implements Serializable {
    private long stayId;
    private int roomId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntityPK that = (RoomEntityPK) o;
        return stayId == that.stayId && roomId == that.roomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId);
    }
}