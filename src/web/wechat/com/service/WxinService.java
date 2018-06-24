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
import web.wechat.com.beans.*;

import javax.rmi.CORBA.Util;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class WxinService {


    public static Log log = LogFactory.getLog(ScanService.class);
    CookieStore cookieStore = new BasicCookieStore();
    Ticket ticket = new Ticket();
    public BaseResp baseRespInit = new BaseResp();

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
            RequestPayload rp = new RequestPayload(
                    new BaseRequest(
                            "e" + String.format("%.15f", Math.random()).substring(2, 17),
                            ticket.getWxsid(),
                            ticket.getSkey(),
                            ticket.getWxuin()
                    )
            );
            httpPost.setEntity(new StringEntity(JSON.toJSONString(rp)));
            baseRespInit = httpUtils(httpPost, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("webwxininit: " + JSON.toJSONString(baseRespInit));
        return baseRespInit;
    }


    public BaseResp wxStatusNotify() {
        BaseResp baseResp = new BaseResp();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxstatusnotify");

        try {
            JSONObject json = new JSONObject();
            json.put("DeviceID", "e" + ("" + String.format("%.15f", Math.random()).substring(2, 17)));
            json.put("Sid", ticket.getWxsid());
            json.put("Skey", ticket.getSkey());
            json.put("Uin", ticket.getWxuin());
            httpPost.setEntity(new StringEntity("{\"BaseRequest\":" + JSON.toJSONString(json) +
                    ",\"ClientMsgId\":" + System.currentTimeMillis() +
                    ",\"Code\":" + 3 +
                    ",\"FromUserName\":" + baseRespInit.getUser().getUserName() +
                    ",\"ToUserName\":" + baseRespInit.getUser().getUserName() +
                    "}"));
            baseResp = httpUtils(httpPost, null);
        } catch (IOException e) {
            e.printStackTrace();
        }


        log.info("wxStatusNotify: " + JSON.toJSONString(baseResp));
        return baseResp;
    }

    public BaseResp webwxgetcontact() {
        BaseResp baseResp = new BaseResp();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet httpGet = new HttpGet("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxgetcontact?r=" + ~System.currentTimeMillis() + "&seq=0&skey=" + ticket.getSkey());
        baseResp = httpUtils(null, httpGet);
        log.info("webwxgetcontact: " + JSON.toJSONString(baseResp));
        return baseResp;
    }


    public BaseResp webwxbatchgetcontact() {
        BaseResp baseResp = new BaseResp();
        HttpPost httpPost = new HttpPost("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxbatchgetcontact?type=ex&r=" + System.currentTimeMillis() + "&lang=en_US");
        baseResp = httpUtils(httpPost, null);
        log.info("webwxbatchgetcontact: " + JSON.toJSONString(baseResp));
        return baseResp;
    }


    public BaseResp httpUtils(HttpPost httpPost, HttpGet httpGet) {
        BaseResp baseResp = new BaseResp();
        try {
            CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpPost == null ? httpGet : httpPost));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();


            baseResp = JSON.parseObject(EntityUtils.toString(httpEntity), BaseResp.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return baseResp;
    }


    public Map<String, String> synccheck() {
        Map<String, String> map = new HashMap<>();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet httpGet = new HttpGet("https://webpush.wx2.qq.com/cgi-bin/mmwebwx-bin/synccheck?r=" + System.currentTimeMillis()
                + "&skey=" + ticket.getSkey()
                + "&sid=" + ticket.getWxsid()
                + "&uin=" + ticket.getWxuin()
                + "&deviceid=" + "e" + ("" + String.format("%.15f", Math.random()).substring(2, 17))
                + "&synckey=" + getSynckeyFromResp(baseRespSync == null ? baseRespInit : baseRespSync)
        );
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            map = getFromJS(EntityUtils.toString(httpEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("synccheck: " + JSON.toJSONString(map));
        return map;
    }


    public Map<String, String> getFromJS(String str) {
        Map<String, String> map = new HashMap<>();
        str = str.replaceAll(".*\\{|}", "");
        String[] keyValue = str.split(",");

        for (String s : keyValue) {
            String[] temp = s.split(":");
            map.put(temp[0].trim().replaceAll("\'|\"", ""), temp[1].trim().replaceAll("\'|\"", ""));
        }
        return map;
    }

    @Test
    public void getFromJS() {
        String str = "window.synccheck={retcode:\"0\",selector:\"2\"}";
        Map<String, String> map = new HashMap<>();
        str = str.replaceAll(".*\\{|\\}", "");
        String[] keyValue = str.split(",");

        for (String s : keyValue) {
            String[] temp = s.split(":");
            map.put(temp[0].trim().replaceAll("\'|\"", ""), temp[1].trim().replaceAll("\'|\"", ""));
        }
        log.info(JSON.toJSONString(map));
    }

    public String getSynckeyFromResp(BaseResp... br) {
        List<SyncKeyValue> list = new ArrayList<>();
        for (BaseResp b : br)
            list.addAll(Arrays.asList(b.getSyncKey().getList()));
        String str = list.stream().map(s -> s.getKey() + "_" + s.getVal()).reduce((a, b) -> (a + "|" + b)).get();
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    private BaseResp baseRespSync = null;

    public BaseResp webwxsync() {

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxsync?sid=" + ticket.getWxsid() + "&skey=" + ticket.getSkey());
        try {
            RequestPayload rp = new RequestPayload(
                    new BaseRequest(
                            String.format("%.15f", Math.random()).substring(2, 17),
                            ticket.getWxsid(),
                            ticket.getSkey(),
                            ticket.getWxuin()
                    ),
                    (baseRespSync == null ? baseRespInit.getSyncKey() : baseRespSync.getSyncKey()),
                    ~System.currentTimeMillis() + ""
            );
            httpPost.setEntity(new StringEntity(JSON.toJSONString(rp)));
            baseRespSync = httpUtils(httpPost, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("webwxsync: " + JSON.toJSONString(baseRespSync));
        return baseRespSync;
    }


    public InputStream webwxgeticon(String imageUrl) {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpGet httpGet = new HttpGet("https://wx2.qq.com" + imageUrl);
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            return httpEntity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public BaseResp webwxsendmsg(Msg msg) {
        BaseResp baseResp = new BaseResp();

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        HttpPost httpPost = new HttpPost("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxsendmsg");
        try {
            RequestPayload rp = new RequestPayload(
                    new BaseRequest(
                            String.format("%.15f", Math.random()).substring(2, 17),
                            ticket.getWxsid(),
                            ticket.getSkey(),
                            ticket.getWxuin()
                    ),
                    msg,
                    "0"
            );
            httpPost.setEntity(new StringEntity(JSON.toJSONString(rp)));
            baseResp = httpUtils(httpPost, null);
            log.info("send result:" + JSON.toJSONString(baseResp));
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("webwxsendmsg: " + JSON.toJSONString(baseResp));
        return baseResp;
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

    // @Test
    public static String textCode(String str) {
        //String str = "Linuxçˆ±å¥½è€…";
        //str = "Linuxç\u0088±å¥½è\u0080\u0085";
        //String str = "微信团队";
        final String US_ASCII = "US-ASCII";
        final String ISO_8859_1 = "ISO-8859-1";
        final String UTF8 = "UTF-8";
        final String UTF_16BE = "UTF-16BE";
        final String UTF_16LE = "UTF-16LE";
        final String UTF_16 = "UTF-16";
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
