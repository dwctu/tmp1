package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class SurveyInfoBean implements Serializable {
    private String onlineUrl;
    private int openStatus;

    public String getOnlineUrl() {
        return this.onlineUrl;
    }

    public int getOpenStatus() {
        return this.openStatus;
    }

    public void setOnlineUrl(String str) {
        this.onlineUrl = str;
    }

    public void setOpenStatus(int i) {
        this.openStatus = i;
    }
}
