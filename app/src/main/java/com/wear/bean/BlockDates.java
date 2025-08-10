package com.wear.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BlockDates {
    private List<String> blockedFriends;
    private List<String> byMessageMuteList;
    private List<String> friendBlack;
    private int logAccept = -1;
    private List<String> rejectedRequests;
    private String uid;
    private List<UserSettingsBean> userSettings;

    public void addUserSettings(UserSettingsBean userSettingsBean) {
        if (this.userSettings == null) {
            this.userSettings = new ArrayList();
        }
        this.userSettings.add(userSettingsBean);
    }

    public List<String> getBlockedFriends() {
        return this.blockedFriends;
    }

    public List<String> getByMessageMuteList() {
        return this.byMessageMuteList;
    }

    public List<String> getFriendBlack() {
        return this.friendBlack;
    }

    public int getLogAccept() {
        return this.logAccept;
    }

    public List<String> getRejectedRequests() {
        return this.rejectedRequests;
    }

    public String getUid() {
        return this.uid;
    }

    public List<UserSettingsBean> getUserSettings() {
        return this.userSettings;
    }

    public void setBlockedFriends(List<String> list) {
        this.blockedFriends = list;
    }

    public void setByMessageMuteList(List<String> list) {
        this.byMessageMuteList = list;
    }

    public void setFriendBlack(List<String> list) {
        this.friendBlack = list;
    }

    public void setRejectedRequests(List<String> list) {
        this.rejectedRequests = list;
    }

    public void setUserSettings(List<UserSettingsBean> list) {
        this.userSettings = list;
    }
}
