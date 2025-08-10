package com.wear.bean;

import java.util.Date;

/* loaded from: classes3.dex */
public class TypingBean {
    private Date created;
    private String fromJid;
    private boolean isTyping;

    public Date getCreated() {
        return this.created;
    }

    public String getFromJid() {
        return this.fromJid;
    }

    public boolean isTyping() {
        return this.isTyping;
    }

    public void setCreated(Date date) {
        this.created = date;
    }

    public void setFromJid(String str) {
        this.fromJid = str;
    }

    public void setTyping(boolean z) {
        this.isTyping = z;
    }
}
