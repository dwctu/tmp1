package com.wear.bean.socketio.controlLink.response;

/* loaded from: classes3.dex */
public class QueryUserOnlineResponse {
    private String ackId;
    private String app;
    private String appExStr;
    private String appPage;
    private String appVersion;
    private boolean onAndroid;
    private boolean onConnectCreatorH5;
    private boolean onIos;
    private boolean onLine;
    private boolean onWeb;
    private String webPage;

    public String getAckId() {
        return this.ackId;
    }

    public String getApp() {
        return this.app;
    }

    public String getAppExStr() {
        return this.appExStr;
    }

    public String getAppPage() {
        return this.appPage;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getWebPage() {
        return this.webPage;
    }

    public boolean isOnAndroid() {
        return this.onAndroid;
    }

    public boolean isOnConnectCreatorH5() {
        return this.onConnectCreatorH5;
    }

    public boolean isOnIos() {
        return this.onIos;
    }

    public boolean isOnLine() {
        return this.onLine;
    }

    public boolean isOnWeb() {
        return this.onWeb;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setApp(String str) {
        this.app = str;
    }

    public void setAppExStr(String str) {
        this.appExStr = str;
    }

    public void setAppPage(String str) {
        this.appPage = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setOnAndroid(boolean z) {
        this.onAndroid = z;
    }

    public void setOnConnectCreatorH5(boolean z) {
        this.onConnectCreatorH5 = z;
    }

    public void setOnIos(boolean z) {
        this.onIos = z;
    }

    public void setOnLine(boolean z) {
        this.onLine = z;
    }

    public void setOnWeb(boolean z) {
        this.onWeb = z;
    }

    public void setWebPage(String str) {
        this.webPage = str;
    }
}
