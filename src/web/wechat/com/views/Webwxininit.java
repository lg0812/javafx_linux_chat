package web.wechat.com.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import web.wechat.com.service.WxinService;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class Webwxininit implements Initializable {

    @FXML
    private SplitPane mainInner;


    //    @FXML
//    private Button first;
    private Map<String, String> map;
    @FXML
    private ImageView avatarIV;
    private WxinService wxinService = new WxinService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        avatarIV.setImage(new Image("https://www.baidu.com/img/baidu_jgylogo3.gif"));
    }


    public void showData(ActionEvent actionEvent) {
        System.out.println(map);
    }

    public void initPage(Map<String, String> map) {
        this.map = map;
        System.out.println(this.map);
        wxinService.redictUrl(map.get("window.redirect_uri"));
    }

}
