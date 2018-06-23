package web.wechat.com.views;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import web.wechat.com.service.ScanService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scan implements Initializable {

    public static Log log = LogFactory.getLog(Scan.class);
    public ScanService scanService = new ScanService();

    public Map<String, String> map = new HashMap<>();

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
    @FXML
    public ImageView qrCode;
    @FXML
    public HBox refreshHbox;
    @FXML
    public GridPane root;
    public String qrCodePostfix = "";


    public void loadQrCode() {
        qrCodePostfix = scanService.jsLogin().toString();
        qrCode.setImage(new Image("https://login.weixin.qq.com/qrcode/" + qrCodePostfix, true));
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
            map = scanService.login(qrCodePostfix);

            if ("201".equals(map.get("window.code"))) {
                System.out.println(map.get("window.userAvatar").split(",")[1]);
                qrCode.setImage(new Image(new ByteArrayInputStream(Base64.getDecoder().
                        decode(map.get("window.userAvatar").split(",")[1]))));
                resizeHeadImg("201");
            } else if ("200".equals(map.get("window.code"))) {
                Platform.runLater(() -> {
                    try {
                        Stage stage = (Stage) root.getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("WeChat.fxml"));
                        Scene scene = new Scene((Region) loader.load());
                        scene.getStylesheets().add(Scan.class.getResource("main.css").toExternalForm());
                        stage.setTitle("wechat");
                        stage.setScene(scene);
                        stage.setResizable(true);
                        WeChat weChat = loader.<WeChat>getController();
                        weChat.startTask(map);
                        stage.show();
//                        root.getScene().getWindow().hide();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                scheduledExecutorService.shutdown();
            } else {
                log.info("waiting..." + map);
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public void resizeHeadImg(String code) {
        if (code.equals("201")) {
            qrCode.setFitHeight(160);
            qrCode.setFitWidth(160);
        } else {
            qrCode.setFitHeight(270);
            qrCode.setFitWidth(270);
        }
    }

    public void refresh(ActionEvent actionEvent) {
        qrCode.setFitHeight(270);
        qrCode.setFitWidth(270);
        loadQrCode();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadQrCode();
    }

    @Test
    public void tdddd() {
        System.out.println("window.QRLogin.code = 200; window.QRLogin.uuid = \"wY4E_OFWQg==\"".replace("\"", ">"));
    }
}
