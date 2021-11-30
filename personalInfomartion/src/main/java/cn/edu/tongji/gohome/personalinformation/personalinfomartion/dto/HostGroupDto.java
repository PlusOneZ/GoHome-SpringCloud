package
        cn.edu.tongji.gohome.personalinformation.personalinfomartion.dto;/**
 * @author 梁乔 2021/11/30
 **/

/**
 * 此处写HostGroupDto类的描述
 * @author 梁乔
 * @since 2021/11/30 21:23 
 */
public class HostGroupDto {
    private int hostLevel;
    private String hostLevelName;
    private long hostLevelDegree;

    public int getHostLevel() {
        return hostLevel;
    }

    public long getHostLevelDegree() {
        return hostLevelDegree;
    }

    public void setHostLevelDegree(long hostLevelDegree) {
        this.hostLevelDegree = hostLevelDegree;
    }

    public String getHostLevelName() {
        return hostLevelName;
    }

    public void setHostLevelName(String hostLevelName) {
        this.hostLevelName = hostLevelName;
    }

    public void setHostLevel(int hostLevel) {
        this.hostLevel = hostLevel;
    }
}