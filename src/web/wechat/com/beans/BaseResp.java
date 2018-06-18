package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class BaseResp {
    @JSONField(name = "BaseResponse")
    private BaseResponse baseResponse;
    @JSONField(name = "Count")
    private int count;
    @JSONField(name = "AddMsgCount")
    private int AddMsgCount;
    @JSONField(name = "AddMsgList")
    private AddMsg[] addMsgList;
    @JSONField(name = "ContactList")
    private Member[] contactList;
    @JSONField(name = "MemberCount")
    private int memberCount;
    @JSONField(name = "MemberList")
    private Member[] memberList;
    @JSONField(name = "SyncKey")
    private SyncKey syncKey;
    @JSONField(name = "User")
    private User user;
    @JSONField(name = "ChatSet")
    private String chatSet;
    @JSONField(name = "SKey")
    private String sKey;
    @JSONField(name = "ClientVersion")
    private long clientVersion;
    @JSONField(name = "SystemTime")
    private long systemTime;
    @JSONField(name = "GrayScale")
    private int grayScale;
    @JSONField(name = "InviteStartCount")
    private int inviteStartCount;
    @JSONField(name = "MPSubscribeMsgCount")
    private int mPSubscribeMsgCount;
    @JSONField(name = "MPSubscribeMsgList")
    private MPSubscribeMsg[] mPSubscribeMsgList;
    @JSONField(name = "ClickReportInterval")
    private long clickReportInterval;
    @JSONField(name = "MsgID")
    private String msgID;
    @JSONField(name = "LocalID")
    private String localID;

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

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAddMsgCount() {
        return AddMsgCount;
    }

    public void setAddMsgCount(int addMsgCount) {
        AddMsgCount = addMsgCount;
    }

    public AddMsg[] getAddMsgList() {
        return addMsgList;
    }

    public void setAddMsgList(AddMsg[] addMsgList) {
        this.addMsgList = addMsgList;
    }

    public Member[] getContactList() {
        return contactList;
    }

    public void setContactList(Member[] contactList) {
        this.contactList = contactList;
    }

    public SyncKey getSyncKey() {
        return syncKey;
    }

    public void setSyncKey(SyncKey syncKey) {
        this.syncKey = syncKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getChatSet() {
        return chatSet;
    }

    public void setChatSet(String chatSet) {
        this.chatSet = chatSet;
    }

    public String getsKey() {
        return sKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }

    public long getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(long clientVersion) {
        this.clientVersion = clientVersion;
    }

    public long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(long systemTime) {
        this.systemTime = systemTime;
    }

    public int getGrayScale() {
        return grayScale;
    }

    public void setGrayScale(int grayScale) {
        this.grayScale = grayScale;
    }

    public int getInviteStartCount() {
        return inviteStartCount;
    }

    public void setInviteStartCount(int inviteStartCount) {
        this.inviteStartCount = inviteStartCount;
    }

    public int getmPSubscribeMsgCount() {
        return mPSubscribeMsgCount;
    }

    public void setmPSubscribeMsgCount(int mPSubscribeMsgCount) {
        this.mPSubscribeMsgCount = mPSubscribeMsgCount;
    }

    public MPSubscribeMsg[] getmPSubscribeMsgList() {
        return mPSubscribeMsgList;
    }

    public void setmPSubscribeMsgList(MPSubscribeMsg[] mPSubscribeMsgList) {
        this.mPSubscribeMsgList = mPSubscribeMsgList;
    }

    public long getClickReportInterval() {
        return clickReportInterval;
    }

    public void setClickReportInterval(long clickReportInterval) {
        this.clickReportInterval = clickReportInterval;
    }
}

class RecommendInfos {
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "NickName")
    private String nickName;
    @JSONField(name = "QQNum")
    private int qQNum;
    @JSONField(name = "Province")
    private String province;
    @JSONField(name = "City")
    private String city;
    @JSONField(name = "Content")
    private String content;
    @JSONField(name = "Signature")
    private String signature;
    @JSONField(name = "Alias")
    private String alias;
    @JSONField(name = "Scene")
    private int scene;
    @JSONField(name = "VerifyFlag")
    private int verifyFlag;
    @JSONField(name = "AttrStatus")
    private String attrStatus;
    @JSONField(name = "Sex;")
    private int sex;
    @JSONField(name = "Ticket")
    private String ticket;
    @JSONField(name = "OpCode")
    private int opCode;

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

    public int getqQNum() {
        return qQNum;
    }

    public void setqQNum(int qQNum) {
        this.qQNum = qQNum;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public int getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(int verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public String getAttrStatus() {
        return attrStatus;
    }

    public void setAttrStatus(String attrStatus) {
        this.attrStatus = attrStatus;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }
}


class AppInfos {
    @JSONField(name = "AppId")
    private String appId;
    @JSONField(name = "Type")
    private int type;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

class MPSubscribeMsg {
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "MPArticleCount")
    private int mPArticleCount;
    @JSONField(name = "MPArticleList")
    private MPArticle[] mPArticleList;
    @JSONField(name = "Time")
    private Date time;
    @JSONField(name = "NickName")
    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getmPArticleCount() {
        return mPArticleCount;
    }

    public void setmPArticleCount(int mPArticleCount) {
        this.mPArticleCount = mPArticleCount;
    }

    public MPArticle[] getmPArticleList() {
        return mPArticleList;
    }

    public void setmPArticleList(MPArticle[] mPArticleList) {
        this.mPArticleList = mPArticleList;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

class MPArticle {
    @JSONField(name = "Title")
    private String title;
    @JSONField(name = "Digest")
    private String digest;
    @JSONField(name = "Cover")
    private String cover;
    @JSONField(name = "Url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class BaseResponse {
    @JSONField(name = "Ret")
    private int ret;
    @JSONField(name = "ErrMsg")
    private String errMsg;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}