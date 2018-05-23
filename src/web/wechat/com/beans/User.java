package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
    @JSONField(name = "Uin")
    private long uin;
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "NickName")
    private String nickName;
    @JSONField(name = "HeadImgUrl")
    private String headImgUrl;
    @JSONField(name = "RemarkName")
    private String remarkName;
    @JSONField(name = "PYInitial")
    private String pYInitial;
    @JSONField(name = "PYQuanPin")
    private String pYQuanPin;
    @JSONField(name = "RemarkPYInitial")
    private String remarkPYInitial;
    @JSONField(name = "RemarkPYQuanPin")
    private String remarkPYQuanPin;
    @JSONField(name = "HideInputBarFlag")
    private int hideInputBarFlag;
    @JSONField(name = "StarFriend")
    private int starFriend;
    @JSONField(name = "Sex")
    private int sex;
    @JSONField(name = "Signature")
    private String signature;
    @JSONField(name = "AppAccountFlag")
    private int appAccountFlag;
    @JSONField(name = "ContactFlag")
    private int contactFlag;
    @JSONField(name = "WebWxPluginSwitch")
    private int webWxPluginSwitch;
    @JSONField(name = "HeadImgFlag")
    private int headImgFlag;
    @JSONField(name = "SnsFlag")
    private int snsFlag;

    public long getUin() {
        return uin;
    }

    public void setUin(long uin) {
        this.uin = uin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getpYInitial() {
        return pYInitial;
    }

    public void setpYInitial(String pYInitial) {
        this.pYInitial = pYInitial;
    }

    public String getpYQuanPin() {
        return pYQuanPin;
    }

    public void setpYQuanPin(String pYQuanPin) {
        this.pYQuanPin = pYQuanPin;
    }

    public String getRemarkPYInitial() {
        return remarkPYInitial;
    }

    public void setRemarkPYInitial(String remarkPYInitial) {
        this.remarkPYInitial = remarkPYInitial;
    }

    public String getRemarkPYQuanPin() {
        return remarkPYQuanPin;
    }

    public void setRemarkPYQuanPin(String remarkPYQuanPin) {
        this.remarkPYQuanPin = remarkPYQuanPin;
    }

    public int getHideInputBarFlag() {
        return hideInputBarFlag;
    }

    public void setHideInputBarFlag(int hideInputBarFlag) {
        this.hideInputBarFlag = hideInputBarFlag;
    }

    public int getStarFriend() {
        return starFriend;
    }

    public void setStarFriend(int starFriend) {
        this.starFriend = starFriend;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAppAccountFlag() {
        return appAccountFlag;
    }

    public void setAppAccountFlag(int appAccountFlag) {
        this.appAccountFlag = appAccountFlag;
    }

    public int getContactFlag() {
        return contactFlag;
    }

    public void setContactFlag(int contactFlag) {
        this.contactFlag = contactFlag;
    }

    public int getWebWxPluginSwitch() {
        return webWxPluginSwitch;
    }

    public void setWebWxPluginSwitch(int webWxPluginSwitch) {
        this.webWxPluginSwitch = webWxPluginSwitch;
    }

    public int getHeadImgFlag() {
        return headImgFlag;
    }

    public void setHeadImgFlag(int headImgFlag) {
        this.headImgFlag = headImgFlag;
    }

    public int getSnsFlag() {
        return snsFlag;
    }

    public void setSnsFlag(int snsFlag) {
        this.snsFlag = snsFlag;
    }
}