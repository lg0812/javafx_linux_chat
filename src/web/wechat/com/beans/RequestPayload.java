package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class RequestPayload {
    @JSONField(name = "BaseRequset")
    private BaseRequset baseRequset;
    @JSONField(name = "Msg")
    private Msg msg;
    @JSONField(name = "Scene")
    private int scene;
    @JSONField(name = "SyncKey")
    private SyncKey syncKey;
    @JSONField(name = "rr")
    private String rr;

    public RequestPayload(BaseRequset baseRequset, SyncKey syncKey, String rr) {
        this.baseRequset = baseRequset;
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

    public RequestPayload(BaseRequset baseRequset) {
        this.baseRequset = baseRequset;
    }


    public RequestPayload(BaseRequset baseRequset, Msg msg) {
        this.baseRequset = baseRequset;
        this.msg = msg;
    }

    public RequestPayload(BaseRequset baseRequset, Msg msg, int scene) {
        this.baseRequset = baseRequset;
        this.msg = msg;
        this.scene = scene;
    }

    public BaseRequset getBaseRequset() {
        return baseRequset;
    }

    public void setBaseRequset(BaseRequset baseRequset) {
        this.baseRequset = baseRequset;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }
}
