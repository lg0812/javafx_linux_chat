package web.wechat.com.views;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import web.wechat.com.service.ScanService;

public class Scan {
    public ScanService scanService = new ScanService();

    @FXML
    public ImageView qrCode;

    public void initialize() {
        loadQrCode();
    }

    public void loadQrCode() {
        qrCode.setImage(new Image("https://login.weixin.qq.com/qrcode/" + scanService.jsLogin().toString()));
    }
}
