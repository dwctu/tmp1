package com.wear.bean;

/* loaded from: classes3.dex */
public class SetLanInfoEvent {
    private String httpPort;
    private String localIp;
    private String sslPort;

    public SetLanInfoEvent(String str, String str2, String str3) {
        this.localIp = str;
        this.httpPort = str2;
        this.sslPort = str3;
    }

    public String getHttpPort() {
        return this.httpPort;
    }

    public String getLocalIp() {
        return this.localIp;
    }

    public String getSslPort() {
        return this.sslPort;
    }

    public void setHttpPort(String str) {
        this.httpPort = str;
    }

    public void setLocalIp(String str) {
        this.localIp = str;
    }

    public void setSslPort(String str) {
        this.sslPort = str;
    }
}
