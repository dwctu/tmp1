package com.wear.network.presenter.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class BackupXmppUrlsBean implements Serializable {
    private int port;
    private String url;

    public int getPort() {
        return this.port;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
