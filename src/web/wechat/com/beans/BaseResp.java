package web.wechat.com.beans;

import java.util.Date;

public class BaseResp {
    private BaseResponse baseResponse;
    private int Count;
    private int AddMsgCount;
    private AddMsg[] AddMsgList;
    private ContactList contactList;
    private SyncKey syncKey;
    private User user;
    private String ChatSet;
    private String SKey;
    private long ClientVersion;
    private long SystemTime;
    private int GrayScale;
    private int InviteStartCount;
    private int MPSubscribeMsgCount;
    private MPSubscribeMsg[] MPSubscribeMsgList;
    private long ClickReportInterval;

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
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
        return ChatSet;
    }

    public void setChatSet(String chatSet) {
        ChatSet = chatSet;
    }

    public String getSKey() {
        return SKey;
    }

    public void setSKey(String SKey) {
        this.SKey = SKey;
    }

    public long getClientVersion() {
        return ClientVersion;
    }

    public void setClientVersion(long clientVersion) {
        ClientVersion = clientVersion;
    }

    public long getSystemTime() {
        return SystemTime;
    }

    public void setSystemTime(long systemTime) {
        SystemTime = systemTime;
    }

    public int getGrayScale() {
        return GrayScale;
    }

    public void setGrayScale(int grayScale) {
        GrayScale = grayScale;
    }

    public int getInviteStartCount() {
        return InviteStartCount;
    }

    public void setInviteStartCount(int inviteStartCount) {
        InviteStartCount = inviteStartCount;
    }

    public int getMPSubscribeMsgCount() {
        return MPSubscribeMsgCount;
    }

    public void setMPSubscribeMsgCount(int MPSubscribeMsgCount) {
        this.MPSubscribeMsgCount = MPSubscribeMsgCount;
    }

    public MPSubscribeMsg[] getMPSubscribeMsgList() {
        return MPSubscribeMsgList;
    }

    public void setMPSubscribeMsgList(MPSubscribeMsg[] MPSubscribeMsgList) {
        this.MPSubscribeMsgList = MPSubscribeMsgList;
    }

    public long getClickReportInterval() {
        return ClickReportInterval;
    }

    public void setClickReportInterval(long clickReportInterval) {
        ClickReportInterval = clickReportInterval;
    }
}

class RecommendInfos {
    private String UserName;
    private String NickName;
    private int QQNum;
    private String Province;
    private String City;
    private String Content;
    private String Signature;
    private String Alias;
    private int Scene;
    private int VerifyFlag;
    private int AttrStatus;
    private int Sex;
    private String Ticket;
    private int OpCode;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public int getQQNum() {
        return QQNum;
    }

    public void setQQNum(int QQNum) {
        this.QQNum = QQNum;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public int getScene() {
        return Scene;
    }

    public void setScene(int scene) {
        Scene = scene;
    }

    public int getVerifyFlag() {
        return VerifyFlag;
    }

    public void setVerifyFlag(int verifyFlag) {
        VerifyFlag = verifyFlag;
    }

    public int getAttrStatus() {
        return AttrStatus;
    }

    public void setAttrStatus(int attrStatus) {
        AttrStatus = attrStatus;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public int getOpCode() {
        return OpCode;
    }

    public void setOpCode(int opCode) {
        OpCode = opCode;
    }
}

class AddMsg {
    private long MsgId;
    private String FromUserName;
    private String ToUserName;
    private int MsgType;
    private String Content;
    private int Status;

    private int ImgStatus;
    private int CreateTime;
    private int VoiceLength;
    private int PlayLength;

    private String FileName;
    private String FileSize;
    private String MediaId;
    private String Url;

    private int AppMsgType;
    private int StatusNotifyCode;

    private String StatusNotifyUserName;
    private RecommendInfos RecommendInfo;
    private int ForwardFlag;
    private AppInfos AppInfo;
    private int HasProductId;
    private String Ticket;
    private int ImgHeight;
    private int ImgWidth;
    private int SubMsgType;
    private int NewMsgId;
    private String OriContent;
    private String EncryFileName;

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public int getMsgType() {
        return MsgType;
    }

    public void setMsgType(int msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getImgStatus() {
        return ImgStatus;
    }

    public void setImgStatus(int imgStatus) {
        ImgStatus = imgStatus;
    }

    public int getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(int createTime) {
        CreateTime = createTime;
    }

    public int getVoiceLength() {
        return VoiceLength;
    }

    public void setVoiceLength(int voiceLength) {
        VoiceLength = voiceLength;
    }

    public int getPlayLength() {
        return PlayLength;
    }

    public void setPlayLength(int playLength) {
        PlayLength = playLength;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getFileSize() {
        return FileSize;
    }

    public void setFileSize(String fileSize) {
        FileSize = fileSize;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public int getAppMsgType() {
        return AppMsgType;
    }

    public void setAppMsgType(int appMsgType) {
        AppMsgType = appMsgType;
    }

    public int getStatusNotifyCode() {
        return StatusNotifyCode;
    }

    public void setStatusNotifyCode(int statusNotifyCode) {
        StatusNotifyCode = statusNotifyCode;
    }

    public String getStatusNotifyUserName() {
        return StatusNotifyUserName;
    }

    public void setStatusNotifyUserName(String statusNotifyUserName) {
        StatusNotifyUserName = statusNotifyUserName;
    }

    public RecommendInfos getRecommendInfo() {
        return RecommendInfo;
    }

    public void setRecommendInfo(RecommendInfos recommendInfo) {
        RecommendInfo = recommendInfo;
    }

    public int getForwardFlag() {
        return ForwardFlag;
    }

    public void setForwardFlag(int forwardFlag) {
        ForwardFlag = forwardFlag;
    }

    public AppInfos getAppInfo() {
        return AppInfo;
    }

    public void setAppInfo(AppInfos appInfo) {
        AppInfo = appInfo;
    }

    public int getHasProductId() {
        return HasProductId;
    }

    public void setHasProductId(int hasProductId) {
        HasProductId = hasProductId;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public int getImgHeight() {
        return ImgHeight;
    }

    public void setImgHeight(int imgHeight) {
        ImgHeight = imgHeight;
    }

    public int getImgWidth() {
        return ImgWidth;
    }

    public void setImgWidth(int imgWidth) {
        ImgWidth = imgWidth;
    }

    public int getSubMsgType() {
        return SubMsgType;
    }

    public void setSubMsgType(int subMsgType) {
        SubMsgType = subMsgType;
    }

    public int getNewMsgId() {
        return NewMsgId;
    }

    public void setNewMsgId(int newMsgId) {
        NewMsgId = newMsgId;
    }

    public String getOriContent() {
        return OriContent;
    }

    public void setOriContent(String oriContent) {
        OriContent = oriContent;
    }

    public String getEncryFileName() {
        return EncryFileName;
    }

    public void setEncryFileName(String encryFileName) {
        EncryFileName = encryFileName;
    }
}

class AppInfos {
    private String AppId;
    private int Type;

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }
}

class MPSubscribeMsg {
    private String UserName;
    private int MPArticleCount;
    private MPArticle[] MPArticleList;
    private Date Time;
    private String NickName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getMPArticleCount() {
        return MPArticleCount;
    }

    public void setMPArticleCount(int MPArticleCount) {
        this.MPArticleCount = MPArticleCount;
    }

    public MPArticle[] getMPArticleList() {
        return MPArticleList;
    }

    public void setMPArticleList(MPArticle[] MPArticleList) {
        this.MPArticleList = MPArticleList;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }
}

class MPArticle {
    private String Title;
    private String Digest;
    private String Cover;
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDigest() {
        return Digest;
    }

    public void setDigest(String digest) {
        Digest = digest;
    }

    public String getCover() {
        return Cover;
    }

    public void setCover(String cover) {
        Cover = cover;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}

class BaseResponse {
    private int Ret;
    private String ErrMsg;

    public int getRet() {
        return Ret;
    }

    public void setRet(int ret) {
        Ret = ret;
    }

    public String getErrMsg() {
        return ErrMsg;
    }

    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "Ret=" + Ret +
                ", ErrMsg='" + ErrMsg + '\'' +
                '}';
    }
}


class Member {
    private int Uin;
    private String UserName;
    private String NickName;
    private int AttrStatus;
    private String PYInitial;
    private String PYQuanPin;
    private String RemarkPYInitial;
    private String RemarkPYQuanPin;
    private int MemberStatus;
    private String DisplayName;
    private String KeyWord;

    public int getUin() {
        return Uin;
    }

    public void setUin(int uin) {
        Uin = uin;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public int getAttrStatus() {
        return AttrStatus;
    }

    public void setAttrStatus(int attrStatus) {
        AttrStatus = attrStatus;
    }

    public String getPYInitial() {
        return PYInitial;
    }

    public void setPYInitial(String PYInitial) {
        this.PYInitial = PYInitial;
    }

    public String getPYQuanPin() {
        return PYQuanPin;
    }

    public void setPYQuanPin(String PYQuanPin) {
        this.PYQuanPin = PYQuanPin;
    }

    public String getRemarkPYInitial() {
        return RemarkPYInitial;
    }

    public void setRemarkPYInitial(String remarkPYInitial) {
        RemarkPYInitial = remarkPYInitial;
    }

    public String getRemarkPYQuanPin() {
        return RemarkPYQuanPin;
    }

    public void setRemarkPYQuanPin(String remarkPYQuanPin) {
        RemarkPYQuanPin = remarkPYQuanPin;
    }

    public int getMemberStatus() {
        return MemberStatus;
    }

    public void setMemberStatus(int memberStatus) {
        MemberStatus = memberStatus;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String keyWord) {
        KeyWord = keyWord;
    }
}

class ContactList {
    private int Uin;
    private String UserName;
    private String NickName;
    private String HeadImgUrl;
    private int ContactFlag;
    private int MemberCount;
    private Member[] MemberList;
    private String RemarkName;
    private int HideInputBarFlag;
    private int Sex;
    private String Signature;
    private int VerifyFlag;
    private int OwnerUin;
    private String PYInitial;
    private String PYQuanPin;
    private String RemarkPYInitial;
    private int StarFriend;
    private int AppAccountFlag;
    private int Statues;
    private int AttrStatus;
    private String Province;
    private String City;
    private String Alias;
    private int SnsFlag;
    private int UniFriend;
    private String DisplayName;
    private int ChatRoomId;
    private String KeyWord;
    private String EncryChatRoomId;
    private int IsOwner;

    public int getUin() {
        return Uin;
    }

    public void setUin(int uin) {
        Uin = uin;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getHeadImgUrl() {
        return HeadImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        HeadImgUrl = headImgUrl;
    }

    public int getContactFlag() {
        return ContactFlag;
    }

    public void setContactFlag(int contactFlag) {
        ContactFlag = contactFlag;
    }

    public int getMemberCount() {
        return MemberCount;
    }

    public void setMemberCount(int memberCount) {
        MemberCount = memberCount;
    }

    public Member[] getMemberList() {
        return MemberList;
    }

    public void setMemberList(Member[] memberList) {
        MemberList = memberList;
    }

    public String getRemarkName() {
        return RemarkName;
    }

    public void setRemarkName(String remarkName) {
        RemarkName = remarkName;
    }

    public int getHideInputBarFlag() {
        return HideInputBarFlag;
    }

    public void setHideInputBarFlag(int hideInputBarFlag) {
        HideInputBarFlag = hideInputBarFlag;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public int getVerifyFlag() {
        return VerifyFlag;
    }

    public void setVerifyFlag(int verifyFlag) {
        VerifyFlag = verifyFlag;
    }

    public int getOwnerUin() {
        return OwnerUin;
    }

    public void setOwnerUin(int ownerUin) {
        OwnerUin = ownerUin;
    }

    public String getPYInitial() {
        return PYInitial;
    }

    public void setPYInitial(String PYInitial) {
        this.PYInitial = PYInitial;
    }

    public String getPYQuanPin() {
        return PYQuanPin;
    }

    public void setPYQuanPin(String PYQuanPin) {
        this.PYQuanPin = PYQuanPin;
    }

    public String getRemarkPYInitial() {
        return RemarkPYInitial;
    }

    public void setRemarkPYInitial(String remarkPYInitial) {
        RemarkPYInitial = remarkPYInitial;
    }

    public int getStarFriend() {
        return StarFriend;
    }

    public void setStarFriend(int starFriend) {
        StarFriend = starFriend;
    }

    public int getAppAccountFlag() {
        return AppAccountFlag;
    }

    public void setAppAccountFlag(int appAccountFlag) {
        AppAccountFlag = appAccountFlag;
    }

    public int getStatues() {
        return Statues;
    }

    public void setStatues(int statues) {
        Statues = statues;
    }

    public int getAttrStatus() {
        return AttrStatus;
    }

    public void setAttrStatus(int attrStatus) {
        AttrStatus = attrStatus;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public int getSnsFlag() {
        return SnsFlag;
    }

    public void setSnsFlag(int snsFlag) {
        SnsFlag = snsFlag;
    }

    public int getUniFriend() {
        return UniFriend;
    }

    public void setUniFriend(int uniFriend) {
        UniFriend = uniFriend;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public int getChatRoomId() {
        return ChatRoomId;
    }

    public void setChatRoomId(int chatRoomId) {
        ChatRoomId = chatRoomId;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String keyWord) {
        KeyWord = keyWord;
    }

    public String getEncryChatRoomId() {
        return EncryChatRoomId;
    }

    public void setEncryChatRoomId(String encryChatRoomId) {
        EncryChatRoomId = encryChatRoomId;
    }

    public int getIsOwner() {
        return IsOwner;
    }

    public void setIsOwner(int isOwner) {
        IsOwner = isOwner;
    }
}

class SyncKey {
    private int Count;
    private SyncKeyValue[] List;

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public SyncKeyValue[] getList() {
        return List;
    }

    public void setList(SyncKeyValue[] list) {
        List = list;
    }
}

class SyncKeyValue {
    private int Key;
    private int Val;

    public int getKey() {
        return Key;
    }

    public void setKey(int key) {
        Key = key;
    }

    public int getVal() {
        return Val;
    }

    public void setVal(int val) {
        Val = val;
    }
}

class User {
    private long Uin;
    private String UserName;
    private String NickName;
    private String HeadImgUrl;
    private String RemarkName;
    private String PYInitial;
    private String PYQuanPin;
    private String RemarkPYInitial;
    private String RemarkPYQuanPin;
    private int HideInputBarFlag;
    private int StarFriend;
    private int Sex;
    private String Signature;
    private int AppAccountFlag;
    private int ContactFlag;
    private int WebWxPluginSwitch;
    private int HeadImgFlag;
    private int SnsFlag;

    public long getUin() {
        return Uin;
    }

    public void setUin(long uin) {
        Uin = uin;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getHeadImgUrl() {
        return HeadImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        HeadImgUrl = headImgUrl;
    }

    public String getRemarkName() {
        return RemarkName;
    }

    public void setRemarkName(String remarkName) {
        RemarkName = remarkName;
    }

    public String getPYInitial() {
        return PYInitial;
    }

    public void setPYInitial(String PYInitial) {
        this.PYInitial = PYInitial;
    }

    public String getPYQuanPin() {
        return PYQuanPin;
    }

    public void setPYQuanPin(String PYQuanPin) {
        this.PYQuanPin = PYQuanPin;
    }

    public String getRemarkPYInitial() {
        return RemarkPYInitial;
    }

    public void setRemarkPYInitial(String remarkPYInitial) {
        RemarkPYInitial = remarkPYInitial;
    }

    public String getRemarkPYQuanPin() {
        return RemarkPYQuanPin;
    }

    public void setRemarkPYQuanPin(String remarkPYQuanPin) {
        RemarkPYQuanPin = remarkPYQuanPin;
    }

    public int getHideInputBarFlag() {
        return HideInputBarFlag;
    }

    public void setHideInputBarFlag(int hideInputBarFlag) {
        HideInputBarFlag = hideInputBarFlag;
    }

    public int getStarFriend() {
        return StarFriend;
    }

    public void setStarFriend(int starFriend) {
        StarFriend = starFriend;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public int getAppAccountFlag() {
        return AppAccountFlag;
    }

    public void setAppAccountFlag(int appAccountFlag) {
        AppAccountFlag = appAccountFlag;
    }

    public int getContactFlag() {
        return ContactFlag;
    }

    public void setContactFlag(int contactFlag) {
        ContactFlag = contactFlag;
    }

    public int getWebWxPluginSwitch() {
        return WebWxPluginSwitch;
    }

    public void setWebWxPluginSwitch(int webWxPluginSwitch) {
        WebWxPluginSwitch = webWxPluginSwitch;
    }

    public int getHeadImgFlag() {
        return HeadImgFlag;
    }

    public void setHeadImgFlag(int headImgFlag) {
        HeadImgFlag = headImgFlag;
    }

    public int getSnsFlag() {
        return SnsFlag;
    }

    public void setSnsFlag(int snsFlag) {
        SnsFlag = snsFlag;
    }
}