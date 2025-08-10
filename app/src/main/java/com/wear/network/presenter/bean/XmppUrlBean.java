package com.wear.network.presenter.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class XmppUrlBean implements Serializable {
    private int failCount;
    private boolean isBlock;
    private int port;
    private int type;
    private String url;

    public XmppUrlBean() {
    }

    public int getFailCount() {
        return this.failCount;
    }

    public int getPort() {
        return this.port;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public void setBlock(boolean z) {
        this.isBlock = z;
    }

    public void setFailCount(int i) {
        this.failCount = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public XmppUrlBean(String str, int i, int i2) {
        this.url = str;
        this.port = i;
        this.type = i2;
    }

    public XmppUrlBean(String str, int i, boolean z) {
        this.url = str;
        this.port = i;
        this.isBlock = z;
    }

    public XmppUrlBean(String str, int i, boolean z, int i2) {
        this.url = str;
        this.port = i;
        this.isBlock = z;
        this.failCount = i2;
    }
}
