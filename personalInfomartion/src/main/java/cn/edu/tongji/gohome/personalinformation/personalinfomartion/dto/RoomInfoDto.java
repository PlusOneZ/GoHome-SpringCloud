package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;/**
 * @author 梁乔 2021/11/30
 **/

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 此处写RoomInfoDto类的描述
 * @author 梁乔
 * @since 2021/11/30 10:46 
 */
public class RoomInfoDto {
    private HashMap<String,Integer> bedTypes;
    private float roomArea;
    private  float Price;
    private int bathNum;

    public HashMap<String, Integer> getBedTypes() {
        return bedTypes;
    }

    public void setBedTypes(HashMap<String, Integer> bedTypes) {
        this.bedTypes = bedTypes;
    }

    public float getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(float roomArea) {
        this.roomArea = roomArea;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getBathNum() {
        return bathNum;
    }

    public void setBathNum(int bathNum) {
        this.bathNum = bathNum;
    }
}