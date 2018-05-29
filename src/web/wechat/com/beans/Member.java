package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class Member {
    @JSONField(name = "Uin")
    private int uin;
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "NickName")
    private String nickName;
    @JSONField(name = "HeadImgUrl")
    private String headImgUrl;
    @JSONField(name = "ContactFlag")
    private int CcontactFlag;
    @JSONField(name = "MemberCount")
    private int memberCount;
    @JSONField(name = "MemberList")
    private Member[] memberList;
    @JSONField(name = "RemarkName")
    private String remarkName;
    @JSONField(name = "HideInputBarFlag")
    private int hideInputBarFlag;
    @JSONField(name = "Sex")
    private int sex;
    @JSONField(name = "Signature")
    private String signature;
    @JSONField(name = "VerifyFlag")
    private int verifyFlag;
    @JSONField(name = "OwnerUin")
    private int ownerUin;
    @JSONField(name = "PYInitial")
    private String pYInitial;
    @JSONField(name = "PYQuanPin")
    private String pYQuanPin;
    @JSONField(name = "RemarkPYInitial")
    private String remarkPYInitial;
    @JSONField(name = "StarFriend")
    private int starFriend;
    @JSONField(name = "AppAccountFlag")
    private int appAccountFlag;
    @JSONField(name = "Statues")
    private int statues;
    @JSONField(name = "AttrStatus")
    private String attrStatus;
    @JSONField(name = "Province")
    private String province;
    @JSONField(name = "City")
    private String city;
    @JSONField(name = "Alias")
    private String alias;
    @JSONField(name = "SnsFlag")
    private int snsFlag;
    @JSONField(name = "UniFriend")
    private int uniFriend;
    @JSONField(name = "DisplayName")
    private String displayName;
    @JSONField(name = "ChatRoomId")
    private int chatRoomId;
    @JSONField(name = "KeyWord")
    private String keyWord;
    @JSONField(name = "EncryChatRoomId")
    private String encryChatRoomId;
    @JSONField(name = "IsOwner")
    private int isOwner;

    public int getUin() {
        return uin;
    }

    public void setUin(int uin) {
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

    public int getCcontactFlag() {
        return CcontactFlag;
    }

    public void setCcontactFlag(int ccontactFlag) {
        CcontactFlag = ccontactFlag;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public Member[] getMemberList() {
        return memberList;
    }

    public void setMemberList(Member[] memberList) {
        this.memberList = memberList;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public int getHideInputBarFlag() {
        return hideInputBarFlag;
    }

    public void setHideInputBarFlag(int hideInputBarFlag) {
        this.hideInputBarFlag = hideInputBarFlag;
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

    public int getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(int verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public int getOwnerUin() {
        return ownerUin;
    }

    public void setOwnerUin(int ownerUin) {
        this.ownerUin = ownerUin;
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

    public int getStarFriend() {
        return starFriend;
    }

    public void setStarFriend(int starFriend) {
        this.starFriend = starFriend;
    }

    public int getAppAccountFlag() {
        return appAccountFlag;
    }

    public void setAppAccountFlag(int appAccountFlag) {
        this.appAccountFlag = appAccountFlag;
    }

    public int getStatues() {
        return statues;
    }

    public void setStatues(int statues) {
        this.statues = statues;
    }

    public String getAttrStatus() {
        return attrStatus;
    }

    public void setAttrStatus(String attrStatus) {
        this.attrStatus = attrStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getSnsFlag() {
        return snsFlag;
    }

    public void setSnsFlag(int snsFlag) {
        this.snsFlag = snsFlag;
    }

    public int getUniFriend() {
        return uniFriend;
    }

    public void setUniFriend(int uniFriend) {
        this.uniFriend = uniFriend;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(int chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getEncryChatRoomId() {
        return encryChatRoomId;
    }

    public void setEncryChatRoomId(String encryChatRoomId) {
        this.encryChatRoomId = encryChatRoomId;
    }

    public int getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(int isOwner) {
        this.isOwner = isOwner;
    }
}
