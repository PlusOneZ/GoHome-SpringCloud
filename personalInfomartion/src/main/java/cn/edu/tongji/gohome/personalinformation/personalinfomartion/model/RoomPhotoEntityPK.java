package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/29
 **/

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * 此处写RoomPhotoEntityPK类的描述
 * @author 梁乔
 * @since 2021/11/29 10:19 
 */
public class RoomPhotoEntityPK implements Serializable {
    private long stayId;
    private int roomId;
    private String roomPhotoLink;

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

    @Column(name = "room_photo_link")
    @Id
    public String getRoomPhotoLink() {
        return roomPhotoLink;
    }

    public void setRoomPhotoLink(String roomPhotoLink) {
        this.roomPhotoLink = roomPhotoLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomPhotoEntityPK that = (RoomPhotoEntityPK) o;
        return stayId == that.stayId && roomId == that.roomId && Objects.equals(roomPhotoLink, that.roomPhotoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, roomPhotoLink);
    }
}