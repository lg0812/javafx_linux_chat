package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class Msg {
    @JSONField(name = "ClientMsgId")
    private long clientMsgId;
    @JSONField(name = "Content")
    private String content;
    @JSONField(name = "FromUserName")
    private String rromUserName;
    @JSONField(name = "ClienLocalIdtMsgId")
    private String localId;
    @JSONField(name = "ClieToUserNamentMsgId")
    private String toUserName;
    @JSONField(name = "Type")
    private int type;

    public Msg(long clientMsgId, String content, String rromUserName, String localId, String toUserName, int type) {
        this.clientMsgId = clientMsgId;
        this.content = content;
        this.rromUserName = rromUserName;
        this.localId = localId;
        this.toUserName = toUserName;
        this.type = type;
    }

    public long getClientMsgId() {
        return clientMsgId;
    }

    public void setClientMsgId(long clientMsgId) {
        this.clientMsgId = clientMsgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRromUserName() {
        return rromUserName;
    }

    public void setRromUserName(String rromUserName) {
        this.rromUserName = rromUserName;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
