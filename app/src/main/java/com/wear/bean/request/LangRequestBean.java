package com.wear.bean.request;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class LangRequestBean {
    private String device;
    private HashMap<String, String> lang;
    private String pf;

    public String getDevice() {
        return this.device;
    }

    public HashMap<String, String> getLang() {
        return this.lang;
    }

    public String getPf() {
        return this.pf;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setLang(HashMap<String, String> map) {
        this.lang = map;
    }

    public void setPf(String str) {
        this.pf = str;
    }
}
