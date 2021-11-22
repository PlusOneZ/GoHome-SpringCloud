package cn.edu.tongji.gohome.stayinformation.dto;

import java.util.List;

/**
 * 有关房间信息的Dto
 *
 * @author 汪明杰
 * @date 2021/11/22 15:58
 */

public class roomInfoDto {
    private long id;
    private double area;
    private long bathroom;
    private double price;
    private int roomCapacity;
    private String roomImage;
    private List<Bed> beds;
    private List<UnavailableTime> unavailable;
}

class Bed{
    private String bedType;
    private int num;
}

class UnavailableTime{
    private String startDate;
    private String endDate;
}