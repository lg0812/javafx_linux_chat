package web.wechat.com.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class ScanService {
    public static Log log = LogFactory.getLog(ScanService.class);

    public String jsLogin() {
        StringBuilder jsLoginUrl = new StringBuilder("https://login.web.wechat.com/jslogin");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String str = "";
        HttpGet httpGet = new HttpGet(jsLoginUrl.append("?appid=wx782c26e4c19acffb")
                .append("&redirect_uri=https://web.wechat.com/cgi-bin/mmwebwx-bin/webwxnewloginpage")
                .append("&fun=new")
                .append("&lang=en_US")
                .append("_=" + System.currentTimeMillis())
                .toString());
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            HttpEntity httpEntity = httpResponse.get().getEntity();
            Map<String, String> map = getResponseData(EntityUtils.toString(httpEntity));

            str = map.get("window.QRLogin.uuid");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public Map<String, String> login(String qrCodePostfix) {
        StringBuilder loginUrl = new StringBuilder("https://login.web.wechat.com/cgi-bin/mmwebwx-bin/login");
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(loginUrl.append("?loginicon=true")
                .append("&uuid=" + qrCodePostfix)
                .append("&tip=0")
                .append("&r=" + ~System.currentTimeMillis())
                .append("&_" + System.currentTimeMillis())
                .toString());
        Map<String, String> map = new HashMap<>();
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            HttpEntity httpEntity = httpResponse.get().getEntity();
            map = getResponseData(EntityUtils.toString(httpEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----->");
        return map;
    }


    public Map<String, String> getResponseData(String response) {
        log.info("response:" + response);
        Map<String, String> map = new HashMap<>();
        //不匹配  ;base64
        String[] list = response.split(";(?!base64)");
        for (String str : list) {
            //split by first = symbol
            String[] s = str.split("=", 2);
            map.put(s[0].trim(), s[1].trim().replaceAll("\"|\'", ""));
        }
        log.info("result:" + map);
        return map;
    }
}
