package com.wear.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PushChatLogRecordBean {
    private List<String> listJid = new ArrayList();
    private String pushDate;

    public List<String> getListJid() {
        return this.listJid;
    }

    public String getPushDate() {
        return this.pushDate;
    }

    public void setListJid(List<String> list) {
        this.listJid = list;
    }

    public void setPushDate(String str) {
        this.pushDate = str;
    }
}
