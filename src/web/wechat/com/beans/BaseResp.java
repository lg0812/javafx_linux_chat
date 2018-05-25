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
    private int attrStatus;
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

    public int getAttrStatus() {
        return attrStatus;
    }

    public void setAttrStatus(int attrStatus) {
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

class AddMsg {
    @JSONField(name = "MsgId")
    private long msgId;
    @JSONField(name = "FromUserName")
    private String fromUserName;
    @JSONField(name = "ToUserName")
    private String toUserName;
    @JSONField(name = "MsgType")
    private int msgType;
    @JSONField(name = "Content")
    private String content;
    @JSONField(name = "Status")
    private int status;
    @JSONField(name = "ImgStatus")

    private int imgStatus;
    @JSONField(name = "CreateTime")
    private int createTime;
    @JSONField(name = "VoiceLength")
    private int voiceLength;
    @JSONField(name = "PlayLength")
    private int playLength;
    @JSONField(name = "FileName")

    private String fileName;
    @JSONField(name = "FileSize")
    private String fileSize;
    @JSONField(name = "MediaId")
    private String mediaId;
    @JSONField(name = "Url")
    private String url;
    @JSONField(name = "AppMsgType")

    private int appMsgType;
    @JSONField(name = "StatusNotifyCode")
    private int statusNotifyCode;
    @JSONField(name = "StatusNotifyUserName")

    private String statusNotifyUserName;
    @JSONField(name = "RecommendInfo")
    private RecommendInfos recommendInfo;
    @JSONField(name = "ForwardFlag")
    private int forwardFlag;
    @JSONField(name = "AppInfo")
    private AppInfos appInfo;
    @JSONField(name = "HasProductId")
    private int hasProductId;
    @JSONField(name = "Ticket")
    private String ticket;
    @JSONField(name = "ImgHeight")
    private int imgHeight;
    @JSONField(name = "ImgWidth")
    private int imgWidth;
    @JSONField(name = "SubMsgType")
    private int subMsgType;
    @JSONField(name = "NewMsgId")
    private int newMsgId;
    @JSONField(name = "OriContent")
    private String oriContent;
    @JSONField(name = "EncryFileName")
    private String encryFileName;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(int imgStatus) {
        this.imgStatus = imgStatus;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getVoiceLength() {
        return voiceLength;
    }

    public void setVoiceLength(int voiceLength) {
        this.voiceLength = voiceLength;
    }

    public int getPlayLength() {
        return playLength;
    }

    public void setPlayLength(int playLength) {
        this.playLength = playLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAppMsgType() {
        return appMsgType;
    }

    public void setAppMsgType(int appMsgType) {
        this.appMsgType = appMsgType;
    }

    public int getStatusNotifyCode() {
        return statusNotifyCode;
    }

    public void setStatusNotifyCode(int statusNotifyCode) {
        this.statusNotifyCode = statusNotifyCode;
    }

    public String getStatusNotifyUserName() {
        return statusNotifyUserName;
    }

    public void setStatusNotifyUserName(String statusNotifyUserName) {
        this.statusNotifyUserName = statusNotifyUserName;
    }

    public RecommendInfos getRecommendInfo() {
        return recommendInfo;
    }

    public void setRecommendInfo(RecommendInfos recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

    public int getForwardFlag() {
        return forwardFlag;
    }

    public void setForwardFlag(int forwardFlag) {
        this.forwardFlag = forwardFlag;
    }

    public AppInfos getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfos appInfo) {
        this.appInfo = appInfo;
    }

    public int getHasProductId() {
        return hasProductId;
    }

    public void setHasProductId(int hasProductId) {
        this.hasProductId = hasProductId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getSubMsgType() {
        return subMsgType;
    }

    public void setSubMsgType(int subMsgType) {
        this.subMsgType = subMsgType;
    }

    public int getNewMsgId() {
        return newMsgId;
    }

    public void setNewMsgId(int newMsgId) {
        this.newMsgId = newMsgId;
    }

    public String getOriContent() {
        return oriContent;
    }

    public void setOriContent(String oriContent) {
        this.oriContent = oriContent;
    }

    public String getEncryFileName() {
        return encryFileName;
    }

    public void setEncryFileName(String encryFileName) {
        this.encryFileName = encryFileName;
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