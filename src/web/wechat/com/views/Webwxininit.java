package web.wechat.com.views;

import com.alibaba.fastjson.JSON;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import web.wechat.com.beans.BaseResp;
import web.wechat.com.beans.Member;
import web.wechat.com.beans.Msg;
import web.wechat.com.beans.User;
import web.wechat.com.service.WxinService;

import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class Webwxininit implements Initializable {

    @FXML
    private SplitPane mainInner;
    public static Log log = LogFactory.getLog(Webwxininit.class);

    //    @FXML
//    private Button first;
    private Map<String, String> map;
    @FXML
    private ImageView avatarIV;
    @FXML
    private Label nickName;
    private WxinService wxinService = new WxinService();
    @FXML
    private ListView<Member> contactList;
    @FXML
    private Label contactName;
    @FXML
    private TextArea msgContent;

    private Msg msg = null;

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void showData(ActionEvent actionEvent) {
        System.out.println(map);
    }


    public void startTask(Map<String, String> map) {
        this.map = map;
        Task<Void> t = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                initPage();
                return null;
            }

            @Override
            protected void succeeded() {
                super.succeeded();
                initSelf(wxinService.baseRespInit.getUser());
                initChat(wxinService.baseRespInit.getContactList());
                syncCheckAndGet();
            }
        };

        new Thread(t).start();

//        Service s = new Service() {
//            @Override
//            protected Task createTask() {
//                return new Task() {
//                    @Override
//                    protected Object call() throws Exception {
//                        initPage();
//                        return null;
//                    }
//                };
//            }
//        };
//
//        s.start();
    }


    public void syncCheckAndGet() {
        ScheduledService ss = new ScheduledService() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        Map<String, String> map = wxinService.synccheck();
                        log.info(map.get("selector") + "=====" + map.get("selector").equals("0"));
                        if (!"0".equals(map.get("selector"))) {
                            log.info(JSON.toJSONString("=====>nmd"));
                            BaseResp baseResp = wxinService.webwxsync();
                        } else {
                            Thread.sleep(5);
                        }
                        return null;
                    }
                };
            }
        };

        ss.setPeriod(Duration.seconds(5));
        ss.start();
    }

    public void initPage() {
        System.out.println(this.map);
        wxinService.redictUrl(map.get("window.redirect_uri"));
        wxinService.webwxininit();


        wxinService.wxStatusNotify();
        wxinService.webwxgetcontact();
        wxinService.webwxbatchgetcontact();


//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            Map<String, String> syncMap = wxinService.synccheck();
//            log.info(syncMap.get("selector") + "=====" + syncMap.get("selector").equals("0"));
//            if (!"0".equals(syncMap.get("selector"))) {
//                log.info(JSON.toJSONString("=====>nmd"));
//                BaseResp baseResp = wxinService.webwxsync();
//                log.info(JSON.toJSONString(baseResp));
//            }
//
//        }, 1, 5, TimeUnit.SECONDS);

//        wxinService.webwxsync();
//        checkMsg();
    }

    public void checkMsg() {
        Map<String, String> syncMap = wxinService.synccheck();
        log.info(syncMap.get("selector") + "=====" + syncMap.get("selector").equals("0"));
        if (!"0".equals(syncMap.get("selector"))) {
            log.info(JSON.toJSONString("=====>nmd"));
            BaseResp baseResp = wxinService.webwxsync();
            log.info(JSON.toJSONString(baseResp));
        }
        checkMsg();
    }

    public void initSelf(User user) {
//        dropMenu
        nickName.setText(user.getNickName());
        avatarIV.setImage(new Image(wxinService.webwxgeticon(user.getHeadImgUrl())));
    }

    public void initChat(Member[] member) {
        ObservableList<Member> ob = FXCollections.observableList(Arrays.asList(member));
        contactList.setItems(ob);
        contactList.setCellFactory(lv -> new ListCell<Member>() {

            @Override
            protected void updateItem(Member item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    GridPane gp = new GridPane();
                    ColumnConstraints c1 = new ColumnConstraints(64);
                    ColumnConstraints c2 = new ColumnConstraints(216);
                    gp.getColumnConstraints().addAll(c1, c2);
                    gp.setPrefSize(280, 64);
                    ImageView head = new ImageView();
                    head.setImage(new Image("sources/temp.png", true));

                    Task task = new Task() {
                        @Override
                        protected Object call() throws Exception {
                            head.setImage(new Image(wxinService.webwxgeticon(item.getHeadImgUrl())));
                            return null;
                        }

                    };
                    new Thread(task).start();
                    head.setFitWidth(40);
                    head.setFitHeight(40);
                    HBox headHbox = new HBox(head);
                    headHbox.setAlignment(Pos.CENTER);

                    Label count = new Label();
                    count.setText("10");
                    count.setTextFill(Color.ORANGERED);
                    count.setLayoutX(48);
                    count.setLayoutY(8);
                    Pane pane = new Pane(count);
                    pane.setPrefHeight(64);
                    pane.setPrefWidth(64);
                    gp.add(headHbox, 0, 0);
                    gp.add(pane, 0, 0);


                    Label nickname = new Label();
                    nickname.setText(wxinService.textCode(item.getNickName()));
                    nickname.setPrefHeight(32);

                    Label msg = new Label();
                    msg.setText("none");
                    msg.setPrefHeight(32);
                    VBox info = new VBox(nickname, msg);

                    gp.add(info, 1, 0);
                    setGraphic(gp);
                } else {
                    setGraphic(null);
                }
            }

            @Override
            public void updateSelected(boolean selected) {
                super.updateSelected(selected);
            }
        });

        contactList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactList.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Member> m, Member oldValue, Member newValue) -> {
                    contactName.setText(WxinService.textCode(newValue.getNickName()));
                    curMember = newValue;
                });

        contactList.setPrefSize(200, 200);

    }

    private Member curMember;

    public void sendMsg(ActionEvent actionEvent) {
        String str = msgContent.getText();
        if (str != "") {
            String currentTimeStr = System.currentTimeMillis() + (String.format("%.3f", Math.random()));
            msg = new Msg(currentTimeStr,
                    str,
                    wxinService.baseRespInit.getUser().getUserName(),
                    currentTimeStr,
                    curMember.getUserName(),
                    1
            );
            log.info(JSON.toJSONString(msg));
            wxinService.webwxsendmsg(msg);
        }
    }

    public void toChat(MouseEvent mouseEvent) {
        System.out.println("toChat");
    }

    public void toRead(MouseEvent mouseEvent) {
        System.out.println("toRead");
    }

    public void toContact(MouseEvent mouseEvent) {
        System.out.println("toContact");
    }
}
