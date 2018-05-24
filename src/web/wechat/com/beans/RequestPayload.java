package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class RequestPayload {
    @JSONField(name = "BaseRequest")
    private BaseRequest baseRequest;
    @JSONField(name = "Msg")
    private Msg msg;
    @JSONField(name = "Scene")
    private String scene;
    @JSONField(name = "SyncKey")
    private SyncKey syncKey;
    @JSONField(name = "rr")
    private String rr;

    public RequestPayload(BaseRequest baseRequest, SyncKey syncKey, String rr) {
        this.baseRequest = baseRequest;
        this.syncKey = syncKey;
        this.rr = rr;
    }

    public SyncKey getSyncKey() {
        return syncKey;
    }

    public void setSyncKey(SyncKey syncKey) {
        this.syncKey = syncKey;
    }

    public String getRr() {
        return rr;
    }

    public void setRr(String rr) {
        this.rr = rr;
    }

    public RequestPayload(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }


    public RequestPayload(BaseRequest baseRequest, Msg msg) {
        this.baseRequest = baseRequest;
        this.msg = msg;
    }

    public RequestPayload(BaseRequest baseRequest, Msg msg, String scene) {
        this.baseRequest = baseRequest;
        this.msg = msg;
        this.scene = scene;
    }

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }
}
