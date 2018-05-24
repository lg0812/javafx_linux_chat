package web.wechat.com.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import web.wechat.com.beans.BaseResp;
import web.wechat.com.beans.Ticket;

import javax.rmi.CORBA.Util;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.util.Optional;

public class WxinService {


    public static Log log = LogFactory.getLog(ScanService.class);
    CookieStore cookieStore = new BasicCookieStore();
    Ticket ticket = new Ticket();
    BaseResp baseRespInit = new BaseResp();

    public void redictUrl(String url) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpGet httpGet = new HttpGet(url + "&fun=new&version=v2&lang=en_US");
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            String xml = EntityUtils.toString(httpEntity);

            ticket = xmlToBean(xml);
            log.info("redictUrl:" + ticket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public BaseResp webwxininit() {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxinit?r=" + ~System.currentTimeMillis() + "&lang=en_US&pass_ticket=" + ticket.getPass_ticket());
        try {
            JSONObject json = new JSONObject();
            json.put("DeviceID", "e" + ("" + String.format("%.15f", Math.random()).substring(2, 17)));
            json.put("Sid", ticket.getWxsid());
            json.put("Skey", ticket.getSkey());
            json.put("Uin", ticket.getWxuin());
            httpPost.setEntity(new StringEntity("{\"BaseRequest\":" + JSON.toJSONString(json) + "}"));
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpPost));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            String str = EntityUtils.toString(httpEntity);
            log.info("webwxininit:" + str);
            baseRespInit = JSON.parseObject(str, BaseResp.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseRespInit;
    }

    public BaseResp webwxgetcontact() {
        BaseResp baseResp = new BaseResp();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet httpGet = new HttpGet("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxgetcontact?r=" + ~System.currentTimeMillis() + "&seq=0&skey=" + ticket.getSkey());
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            String str = EntityUtils.toString(httpEntity);
            baseResp = JSON.parseObject(str, BaseResp.class);
            log.info("webwxgetcontact:" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseResp;
    }

    public BaseResp webwxsync() {

        BaseResp baseResp = new BaseResp();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxsync?sid=" + ticket.getWxsid() + "&skey=" + ticket.getSkey());
        try {
            JSONObject json = new JSONObject();
            json.put("DeviceID", "e" + ("" + String.format("%.15f", Math.random()).substring(2, 17)));
            json.put("Sid", ticket.getWxsid());
            json.put("Skey", ticket.getSkey());
            json.put("Uin", ticket.getWxuin());
            httpPost.setEntity(new StringEntity("{\"BaseRequest\":" + JSON.toJSONString(json) + ",\"SyncKey\":" + JSON.toJSONString(baseRespInit.getSyncKey()) + ",\"rr\":" + ~System.currentTimeMillis() + "}"));
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpPost));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            String str = EntityUtils.toString(httpEntity);
            baseResp = JSON.parseObject(str, BaseResp.class);
            log.info("webwxgetcontact:" + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseResp;
    }


    public InputStream webwxgeticon(String imageUrl) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet httpGet = new HttpGet("https://wx2.qq.com" + imageUrl);
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            log.info("webwxgetiocon--->");
            return httpEntity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Ticket xmlToBean(String xml) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Ticket.class);
            System.out.println(xml);
            return (Ticket) jc.createUnmarshaller().unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test
    public void ttttt() {
        System.out.println("e" + ("" + String.format("%.15f", Math.random()).substring(2, 17)));
    }

    //    @Test
    public String textCode(String str) {
        //        String str = "Linuxçˆ±å¥½è€…";
        //str = "Linuxç\u0088±å¥½è\u0080\u0085";
        //String str = "微信团队";
        /** 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块      */
        final String US_ASCII = "US-ASCII";
        /** ISO拉丁字母表 No.1，也叫做ISO-LATIN-1     */
        final String ISO_8859_1 = "ISO-8859-1";
        final String UTF8 = "UTF-8";
        /** 8 位 UCS 转换格式     */
        final String UTF_8 = "UTF-8";
        /** 16 位 UCS 转换格式，Big Endian(最低地址存放高位字节）字节顺序     */
        final String UTF_16BE = "UTF-16BE";
        /** 16 位 UCS 转换格式，Litter Endian（最高地址存放地位字节）字节顺序     */
        final String UTF_16LE = "UTF-16LE";
        /** 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识     */
        final String UTF_16 = "UTF-16";
        /** 中文超大字符集     **/
        final String GBK = "GBK";
        final String GB2312 = "GB2312";
        final String Unicode = "Unicode";

        try {
            return new String(str.getBytes(ISO_8859_1), UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
