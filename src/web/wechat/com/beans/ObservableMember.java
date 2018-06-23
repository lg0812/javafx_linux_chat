package web.wechat.com.beans;

import javafx.beans.property.*;

public class ObservableMember {
    public IntegerProperty uin = new SimpleIntegerProperty();
    public StringProperty userName = new SimpleStringProperty();
    public StringProperty nickName = new SimpleStringProperty();
    public StringProperty headImgUrl = new SimpleStringProperty();
    public IntegerProperty CcontactFlag = new SimpleIntegerProperty();
    public IntegerProperty memberCount = new SimpleIntegerProperty();
    public StringProperty remarkName = new SimpleStringProperty();
    public IntegerProperty hideInputBarFlag = new SimpleIntegerProperty();
    public IntegerProperty sex = new SimpleIntegerProperty();
    public StringProperty signature = new SimpleStringProperty();
    public IntegerProperty verifyFlag = new SimpleIntegerProperty();
    public IntegerProperty ownerUin = new SimpleIntegerProperty();
    public StringProperty pYInitial = new SimpleStringProperty();
    public StringProperty pYQuanPin = new SimpleStringProperty();
    public StringProperty remarkPYInitial = new SimpleStringProperty();
    public IntegerProperty starFriend = new SimpleIntegerProperty();
    public IntegerProperty appAccountFlag = new SimpleIntegerProperty();
    public IntegerProperty statues = new SimpleIntegerProperty();
    public StringProperty attrStatus = new SimpleStringProperty();
    public StringProperty province = new SimpleStringProperty();
    public StringProperty city = new SimpleStringProperty();
    public StringProperty alias = new SimpleStringProperty();
    public IntegerProperty snsFlag = new SimpleIntegerProperty();
    public IntegerProperty uniFriend = new SimpleIntegerProperty();
    public StringProperty displayName = new SimpleStringProperty();
    public IntegerProperty chatRoomId = new SimpleIntegerProperty();
    public StringProperty keyWord = new SimpleStringProperty();
    public StringProperty encryChatRoomId = new SimpleStringProperty();
    public IntegerProperty isOwner = new SimpleIntegerProperty();
    public StringProperty latestMsgContent = new SimpleStringProperty();


    public ObservableMember(Member member) {
        this.userName.set(member.getUserName());
        this.nickName.set(member.getNickName());
        this.headImgUrl.set(member.getHeadImgUrl());
        this.latestMsgContent.set(member.getLatestMsgContent());
    }

    public String getNickName() {
        return nickName.get();
    }

    public StringProperty nickNameProperty() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName.set(nickName);
    }

    public String getHeadImgUrl() {
        return headImgUrl.get();
    }

    public StringProperty headImgUrlProperty() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl.set(headImgUrl);
    }

    public String getLatestMsgContent() {
        return latestMsgContent.get();
    }

    public StringProperty latestMsgContentProperty() {
        return latestMsgContent;
    }

    public void setLatestMsgContent(String latestMsgContent) {
        this.latestMsgContent.set(latestMsgContent);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }
}
