package web.wechat.com.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class Ticket {
    private String ret;
    private String message;
    private String skey;
    private String wxsid;
    private String wxuin;
    private String pass_ticket;
    private String isgrayscale;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getWxsid() {
        return wxsid;
    }

    public void setWxsid(String wxsid) {
        this.wxsid = wxsid;
    }

    public String getWxuin() {
        return wxuin;
    }

    public void setWxuin(String wxuin) {
        this.wxuin = wxuin;
    }

    public String getPass_ticket() {
        return pass_ticket;
    }

    public void setPass_ticket(String pass_ticket) {
        this.pass_ticket = pass_ticket;
    }

    public String getIsgrayscale() {
        return isgrayscale;
    }

    public void setIsgrayscale(String isgrayscale) {
        this.isgrayscale = isgrayscale;
    }

    public Ticket() {
    }

    public Ticket(String ret, String message) {
        this.ret = ret;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ret='" + ret + '\'' +
                ", message='" + message + '\'' +
                ", skey='" + skey + '\'' +
                ", wxsid='" + wxsid + '\'' +
                ", wxuin='" + wxuin + '\'' +
                ", pass_ticket='" + pass_ticket + '\'' +
                ", isgrayscale='" + isgrayscale + '\'' +
                '}';
    }
}