package cn.edu.tongji.gohome.stayinformation.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 有关房间信息的Dto
 *
 * @author 汪明杰
 * @date 2021/11/22 15:58
 */

public class RoomInfoDto {
    private long id;
    private BigDecimal area;
    private long bathroom;
    private BigDecimal price;
    private int roomCapacity;
    private String roomImage;
    private List<BedDto> beds;
    private List<HashMap<String, String>> unavailable;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public long getBathroom() {
        return bathroom;
    }

    public void setBathroom(long bathroom) {
        this.bathroom = bathroom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public List<BedDto> getBeds() {
        return beds;
    }

    public void setBeds(List<BedDto> beds) {
        this.beds = beds;
    }

    public List<HashMap<String, String>> getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(List<HashMap<String, String>> unavailable) {
        this.unavailable = unavailable;
    }
}



