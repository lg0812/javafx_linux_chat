package web.wechat.com.beans;

public class QRLogin {
    public int code;
    public String uuid;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "QRLogin{" +
                "code=" + code +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
