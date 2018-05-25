package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class SyncKeyValue {
    @JSONField(name = "Key")
    private int key;
    @JSONField(name = "Val")
    private int val;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
