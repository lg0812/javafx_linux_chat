package web.wechat.com.views;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import web.wechat.com.service.ScanService;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scan {

    public static Log log = LogFactory.getLog(Scan.class);
    public ScanService scanService = new ScanService();


    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
    @FXML
    public ImageView qrCode;

    public String qrCodePostfix = "";

    public void initialize() {
        loadQrCode();
    }

    public void loadQrCode() {
        qrCodePostfix = scanService.jsLogin().toString();
        qrCode.setImage(new Image("https://login.weixin.qq.com/qrcode/" + qrCodePostfix));
//        qrCode.setImage(new Image("https://www.baidu.com/img/baidu_jgylogo3.gif"));
//        qrCode.setImage(new Image("https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/static/protocol/https/soutu/img/camera_new_5606e8f.png"));
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Map<String, String> map = scanService.login(qrCodePostfix);
//                System.out.println(map.toString());
//                if ("201".equals(map.get("window.code"))) {
//                    System.out.println("equal");
//                    qrCode.setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().decode(map.get("window.userAvatar").split(",")[1]))));
////                    qrCode.setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().decode(map.get("window.userAvatar")))));
//                    timer.cancel();
//                } else {
//                    System.out.println("not equal");
//                }
//            }
//
//        }, 1000L);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            Map<String, String> map = scanService.login(qrCodePostfix);
            if ("201".equals(map.get("window.code"))) {
                System.out.println(map.get("window.userAvatar").split(",")[1]);
                qrCode.setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().decode(map.get("window.userAvatar").split(",")[1]))));
//                    qrCode.setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().decode(map.get("window.userAvatar")))));
//                scheduledExecutorService.shutdown();
            } else if ("201".equals(map.get("window.code"))) {

                scheduledExecutorService.shutdown();
            } else {
                log.info(map);
                System.out.println("not equal");
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    @Test
    public void tdddd() {
        System.out.println("window.QRLogin.code = 200; window.QRLogin.uuid = \"wY4E_OFWQg==\"".replace("\"", ">"));
    }
}
