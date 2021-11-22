package cn.edu.tongji.gohome.stayinformation.dto;

import java.util.List;

/**
 * 民宿详细信息的Dto
 *
 * @author 汪明杰
 * @date 2021/11/22 15:48
 */
public class StayInfoDto {
    private long stayId;
    private List<String> stayImages;
    private String stayName;
    private String stayDescription;
    private String characteristic;
    private String hostAvatar;
    private String hostLevel;
    private long hostCommentNum;
    private List<Double> stayPosition;
    private String hostName;
    private long roomNum;
    private long bedNum;
    private long stayCapacity;
    private long publicBathroom;
    private long publicToilet;
    private boolean nonBarrierFacility;
    private String startTime;
    private String endTime;
    private int stayStatus;
    private List<roomInfoDto> rooms;
}
