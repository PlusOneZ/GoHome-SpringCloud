package
        cn.edu.tongji.gohome.sale.sale.model;/**
 * @author 梁乔 2021/11/24
 **/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 此处写RoomEntityPK类的描述
 * @author 梁乔
 * @since 2021/11/24 21:30 
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

        if (stayId != that.stayId) return false;
        if (roomId != that.roomId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (stayId ^ (stayId >>> 32));
        result = 31 * result + roomId;
        return result;
    }
}