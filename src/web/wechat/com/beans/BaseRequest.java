package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class BaseRequest {
    @JSONField(name = "DeviceID")
    private String deviceID;
    @JSONField(name = "Sid")
    private String sid;
    @JSONField(name = "Skey")
    private String skey;
    @JSONField(name = "Uin")
    private String uin;

    public BaseRequest(String deviceID, String sid, String skey, String uin) {
        this.deviceID = deviceID;
        this.sid = sid;
        this.skey = skey;
        this.uin = uin;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }
}
