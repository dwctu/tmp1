package com.wear.bean;

/* loaded from: classes3.dex */
public class ToyLogBean {
    private int fVersion;
    private String mac;

    public ToyLogBean(String str, int i) {
        this.mac = str;
        this.fVersion = i;
    }

    public String getMac() {
        return this.mac;
    }

    public int getfVersion() {
        return this.fVersion;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setfVersion(int i) {
        this.fVersion = i;
    }
}
