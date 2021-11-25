package cn.edu.tongji.gohome.stayinformation.dto;

import org.apache.catalina.Host;

/**
 * HostStayUpdate类
 *
 * @author 汪明杰
 * @date 2021/11/24 22:09
 */
public class HostStayUpdate {
    private HostStay updateInfo;
    private long stayId;

    public void setUpdateInfo(HostStay updateInfo){
        this.updateInfo = updateInfo;
    }

    public HostStay getUpdateInfo(){
        return this.updateInfo;
    }


    public long getStayId() {
        return stayId;
    }

    public void setStayId(long stayId) {
        this.stayId = stayId;
    }
}
