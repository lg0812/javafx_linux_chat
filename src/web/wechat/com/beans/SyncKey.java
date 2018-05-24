package web.wechat.com.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class SyncKey {
    @JSONField(name = "Count")
    private int count;
    @JSONField(name = "List")
    private SyncKeyValue[] list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SyncKeyValue[] getList() {
        return list;
    }

    public void setList(SyncKeyValue[] list) {
        this.list = list;
    }
}