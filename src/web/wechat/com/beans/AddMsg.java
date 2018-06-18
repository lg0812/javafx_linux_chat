package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class AddMsg {
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
    private String newMsgId;
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

    public String getNewMsgId() {
        return newMsgId;
    }

    public void setNewMsgId(String newMsgId) {
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
