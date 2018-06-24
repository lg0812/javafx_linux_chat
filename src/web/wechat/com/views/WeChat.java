package web.wechat.com.views;

import com.alibaba.fastjson.JSON;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import web.wechat.com.beans.*;
import web.wechat.com.service.WxinService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class WeChat implements Initializable {

    @FXML
    private HBox mainInner;
    public static Log log = LogFactory.getLog(WeChat.class);
    private Map<String, String> map;
    @FXML
    private ImageView avatarIV;
    @FXML
    private Label nickName;
    private WxinService wxinService = new WxinService();
    @FXML
    private ListView<ObservableMember> contactList;
    @FXML
    private Label contactName;
    @FXML
    private TextArea msgContent;
    @FXML
    private VBox tempMsgList;
    @FXML
    private ScrollPane scrollMsg;
    private Msg msg = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollMsg.vvalueProperty().bind(tempMsgList.heightProperty());
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
                toChat(null);
                syncCheckAndGet();
            }
        };

        new Thread(t).start();
    }


    public void syncCheckAndGet() {
        ScheduledService ss = new ScheduledService() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        Map<String, String> map = wxinService.synccheck();
                        if (!"0".equals(map.get("selector"))) {
                            Platform.runLater(() -> {
                                checkMsg();
                            });
                        } else if ("1101".equals(map.get("retcode"))) {
                            Thread.sleep(1);
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

    private BaseResp contact = new BaseResp();
    private BaseResp batchContact = new BaseResp();

    public void initPage() {
        System.out.println(this.map);
        wxinService.redictUrl(map.get("window.redirect_uri"));
        wxinService.webwxininit();
        wxinService.wxStatusNotify();
        contact = wxinService.webwxgetcontact();
        batchContact = wxinService.webwxbatchgetcontact();

    }

    public void checkMsg() {
        BaseResp baseResp = wxinService.webwxsync();
        for (AddMsg msg : baseResp.getAddMsgList()) {
            for (Integer i = new Integer(0); i < ob.size() && !"".equals(msg.getContent()); i++) {
                if (msg.getFromUserName().equals(ob.get(i).getUserName())) {
                    saveToHistoryFile(new Msg(msg.getContent(), msg.getFromUserName(), msg.getToUserName()), false);
                    ob.get(i).setLatestMsgContent(WxinService.textCode(msg.getContent()));
                    if (contactList.getSelectionModel().getSelectedItem() != null
                            && contactList.getSelectionModel().getSelectedItem().userName.get().equals(msg.getFromUserName())) {
                        receiveText(msg.getContent());
                    }
                } else if (msg.getFromUserName().equals(wxinService.baseRespInit.getUser().getUserName()) &&
                        msg.getToUserName().equals(ob.get(i).getUserName())) {
                    saveToHistoryFile(new Msg(msg.getContent(), msg.getFromUserName(), msg.getToUserName()), false);
                    ob.get(i).setLatestMsgContent(msg.getContent());
                    System.out.println(JSON.toJSONString(ob.get(i)));
                    if (contactList.getSelectionModel().getSelectedItem() != null
                            && "filehelper".equals(contactList.getSelectionModel().getSelectedItem().userName.get())) {
                        System.out.println("--->refresh");
                        receiveText(msg.getContent());
                    }
                }
            }
        }

    }

    public void initSelf(User user) {
        nickName.setText(user.getNickName());
        avatarIV.setImage(new Image(wxinService.webwxgeticon(user.getHeadImgUrl())));
    }

    ObservableList<ObservableMember> ob = null;
    List<Member> obMember = null;

    public void initChat(List<Member> member) {
        obMember = member;
        ob = FXCollections.observableArrayList(param -> new Observable[]{
                        param.headImgUrl,
                        param.nickName,
                        param.latestMsgContent
                }
        );


        for (Member m : member) {
            ob.add(new ObservableMember(m));
        }
        contactList.setItems(ob);
        contactList.setCellFactory(lv -> new ListCell<ObservableMember>() {

            @Override
            protected void updateItem(ObservableMember item, boolean empty) {
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
                    headHbox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
                    Label count = new Label();
                    count.setText("10");
                    count.setFont(new Font(12));
                    count.setPrefHeight(14);
                    count.setTextFill(Color.ORANGERED);
                    count.setLayoutX(48);
                    count.setLayoutY(8);
                    Pane pane = new Pane(count);
                    pane.setPrefHeight(64);
                    pane.setPrefWidth(64);
                    gp.add(headHbox, 0, 0);
                    gp.add(pane, 0, 0);

                    Label nickname = new Label();
                    nickname.setTextFill(Color.web("#ffffff"));
                    nickname.setText(wxinService.textCode(item.getNickName()));
                    nickname.setPrefHeight(32);

                    Label msg = new Label();
                    msg.setTextFill(Color.web("#ffffff"));
                    msg.setText(item.getLatestMsgContent());
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
                (ObservableValue<? extends ObservableMember> m, ObservableMember oldValue, ObservableMember newValue) -> {
                    contactName.setText(WxinService.textCode(newValue.nickName.get()));
                    curMember = newValue;
                    tempMsgList.getChildren().removeAll(tempMsgList.getChildren());
                    showHistoryMsgs(readLastSeveralLines(newValue.userName.get(), 20));
                });

        contactList.setPrefSize(200, 200);
    }

    private ObservableMember curMember;


    public void showHistoryMsgs(Stack<Msg> latest) {
        while (!latest.empty())
            receiveText(latest.pop().getContent());
    }

    private void saveToHistoryFile(Msg msg, boolean iSend) {
        String path = System.getProperty("user.dir") + File.separator + (iSend ? ("filehelper".equals(msg.getToUserName()) ? msg.getFromUserName() : msg.getToUserName()) : msg.getFromUserName());
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append(JSON.toJSONString(msg));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveText(String str) {

        Label tempMsg = new Label(str);
        tempMsg.setWrapText(true);
        tempMsg.setMaxWidth(500);
        tempMsg.setStyle(" -fx-border-width: 1; -fx-border-color: #dddddd; -fx-border-radius: 3; -fx-padding: 10px 15px;");
        Pane p = new Pane();
        p.setPrefSize(40, 40);
        p.setBackground(new Background(new BackgroundImage(
                new Image("sources/temp.png", true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false)
        )));

        HBox tempHb = new HBox(p, tempMsg);
        tempHb.setSpacing(10);
        tempHb.setAlignment(Pos.CENTER_LEFT);
        tempHb.setPadding(new Insets(10, 10, 10, 10));
        Platform.runLater(() -> {
            tempMsgList.getChildren().add(tempHb);
        });
    }

    private void sendText(String str) {
        Label tempMsg = new Label(str);
        tempMsg.setWrapText(true);
        tempMsg.setMaxWidth(500);
        tempMsg.setStyle(" -fx-border-width: 1; -fx-border-color: #dddddd; -fx-border-radius: 3; -fx-padding: 10px 15px;");
        Pane p = new Pane();
        p.setPrefSize(40, 40);
        p.setBackground(new Background(new BackgroundImage(
                new Image("sources/temp.png", true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1, 1, true, true, false, false)
        )));

        HBox tempHb = new HBox(tempMsg, p);
        tempHb.setSpacing(10);
        tempHb.setAlignment(Pos.CENTER_RIGHT);
        tempHb.setPadding(new Insets(10, 10, 10, 0));
        tempMsgList.getChildren().add(tempHb);
    }

    public void sendMsg(ActionEvent actionEvent) {
        String str = msgContent.getText();
        if (!"".equals(str)) {
            sendText(str);
            msgContent.setText("");
            String currentTimeStr = System.currentTimeMillis() + (String.format("%.3f", Math.random()));
            msg = new Msg(currentTimeStr,
                    str,
                    wxinService.baseRespInit.getUser().getUserName(),
                    currentTimeStr,
                    curMember.getUserName(),
                    1
            );

            // 将消息保存到本地消息记录中
            saveToHistoryFile(msg, true);
            wxinService.webwxsendmsg(msg);
        }
    }

    public void toChat(MouseEvent mouseEvent) {
        List<Member> m = Arrays.asList(wxinService.baseRespInit.getContactList());
        List<Member> n = Arrays.asList(batchContact.getContactList());
        m.addAll(n);
        initChat(m);
    }

    public void toRead(MouseEvent mouseEvent) {
        System.out.println("toRead");
    }

    public void toContact(MouseEvent mouseEvent) {
        initChat(Arrays.asList(contact.getMemberList()));
    }

    public Stack<Msg> readLastSeveralLines(String uid, int count) {

        if ("filehelper".equals(uid))
            uid = wxinService.baseRespInit.getUser().getUserName();
        String path = System.getProperty("user.dir") + File.separator + uid;
        Stack<Msg> list = new Stack<>();

        try {
            File f = new File(path);
            if (!f.exists())
                f.createNewFile();
            ReversedLinesFileReader file = new ReversedLinesFileReader(new File(path), 4096, "UTF-8");
            String s;
            while ((s = file.readLine()) != null && count > 0) {
                list.push(JSON.parseObject(s, Msg.class));
                count--;
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Msg msg : list)
            System.out.println(msg);
        return list;
    }

    @Test
    public void tR() {
        readLastSeveralLines("@adaab8e5b746125a256c61dfb6ca24463ba7f48ff56c064968a88fd20765ab50", 5);
    }
}
