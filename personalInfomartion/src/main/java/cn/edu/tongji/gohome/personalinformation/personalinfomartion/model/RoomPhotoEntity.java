package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.model;/**
 * @author 梁乔 2021/11/29
 **/

import javax.persistence.*;
import java.util.Objects;

/**
 * 此处写RoomPhotoEntity类的描述
 * @author 梁乔
 * @since 2021/11/29 10:19 
 */
@Entity
@Table(name = "room_photo", schema = "GoHome", catalog = "")
@IdClass(RoomPhotoEntityPK.class)
public class RoomPhotoEntity {
    private long stayId;
    private int roomId;
    private String roomPhotoLink;

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
    @Column(name = "room_photo_link")
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
        RoomPhotoEntity that = (RoomPhotoEntity) o;
        return stayId == that.stayId && roomId == that.roomId && Objects.equals(roomPhotoLink, that.roomPhotoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stayId, roomId, roomPhotoLink);
    }
}