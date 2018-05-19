package web.wechat.com.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ScanService {
    StringBuilder jsLoginUrl = new StringBuilder("https://login.web.wechat.com/jslogin");

    public String jsLogin() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String str = "";
        HttpGet httpGet = new HttpGet(jsLoginUrl.append("?appid=wx782c26e4c19acffb").
                append("&redirect_uri=https://web.wechat.com/cgi-bin/mmwebwx-bin/webwxnewloginpage")
                .append("&fun=new")
                .append("&lang=en_US")
                .append("_=" + System.currentTimeMillis())
                .toString());
        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            HttpEntity httpEntity = httpResponse.get().getEntity();
            str = EntityUtils.toString(httpEntity);

            Pattern p = Pattern.compile("\".*\"");
            Matcher m = p.matcher(str);
            if (m.find()) {
                str = m.group(0).replace("\"", "");
            } else {
                str = "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
