package web.wechat.com.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class WxinService {

    public static Log log = LogFactory.getLog(ScanService.class);

    public String redictUrl(String url) {
        String str = "";
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpGet httpGet = new HttpGet(url);

        try {
            Optional<CloseableHttpResponse> httpResponse = Optional.of(httpClient.execute(httpGet));
            CloseableHttpResponse resp = httpResponse.get();
            HttpEntity httpEntity = resp.getEntity();
            System.out.println(cookieStore.getCookies());
            log.info(EntityUtils.toString(httpEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

}
