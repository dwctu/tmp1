package com.wear.bean;

/* loaded from: classes3.dex */
public class UserSettingsBean {
    private String jid;
    private String remark;
    private long setTop = 0;
    private int muteFlag = 0;

    public String getJid() {
        return this.jid;
    }

    public int getMuteFlag() {
        return this.muteFlag;
    }

    public String getRemark() {
        return this.remark;
    }

    public long getSetTop() {
        return this.setTop;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setMuteFlag(int i) {
        this.muteFlag = i;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSetTop(long j) {
        this.setTop = j;
    }
}
