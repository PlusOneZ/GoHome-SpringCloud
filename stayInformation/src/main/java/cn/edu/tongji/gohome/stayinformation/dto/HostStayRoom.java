package cn.edu.tongji.gohome.stayinformation.dto;

import java.util.List;

/**
 * HostStayRoom类
 *
 * @author 汪明杰
 * @date 2021/11/23 22:42
 */
public class HostStayRoom {
    private List<String> bedTypes;
    private List<Integer> bedNums;
    private int roomArea;
    private int bathNum;
    private int price;
    private int roomId;
    private List<String> images;

    public List<String> getBedTypes() {
        return bedTypes;
    }

    public void setBedTypes(List<String> bedTypes) {
        this.bedTypes = bedTypes;
    }

    public List<Integer> getBedNums() {
        return bedNums;
    }

    public void setBedNums(List<Integer> bedNums) {
        this.bedNums = bedNums;
    }

    public int getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(int roomArea) {
        this.roomArea = roomArea;
    }

    public int getBathNum() {
        return bathNum;
    }

    public void setBathNum(int bathNum) {
        this.bathNum = bathNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
