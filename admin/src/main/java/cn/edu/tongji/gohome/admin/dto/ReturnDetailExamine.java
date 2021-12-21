package cn.edu.tongji.gohome.admin.dto;

import java.util.ArrayList;

public class ReturnDetailExamine {
    private String detailedAddress;

    private String stayType;

    private int stayCapability;

    private ArrayList<ReturnDetailRoom> roomList;

    private int publicToliet;

    private int publicBath;

    private boolean hasBarrierFree;

    private ArrayList<String> stayPicList;

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }

    public int getStayCapability() {
        return stayCapability;
    }

    public void setStayCapability(int stayCapability) {
        this.stayCapability = stayCapability;
    }

    public ArrayList<ReturnDetailRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<ReturnDetailRoom> roomList) {
        this.roomList = roomList;
    }

    public int getPublicToliet() {
        return publicToliet;
    }

    public void setPublicToliet(int publicToliet) {
        this.publicToliet = publicToliet;
    }

    public int getPublicBath() {
        return publicBath;
    }

    public void setPublicBath(int publicBath) {
        this.publicBath = publicBath;
    }

    public boolean isHasBarrierFree() {
        return hasBarrierFree;
    }

    public void setHasBarrierFree(boolean hasBarrierFree) {
        this.hasBarrierFree = hasBarrierFree;
    }

    public ArrayList<String> getStayPicList() {
        return stayPicList;
    }

    public void setStayPicList(ArrayList<String> stayPicList) {
        this.stayPicList = stayPicList;
    }
}
