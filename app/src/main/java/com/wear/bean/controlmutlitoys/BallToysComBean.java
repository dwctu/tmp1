package com.wear.bean.controlmutlitoys;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class BallToysComBean {
    private String deviceId;
    private String expSplit;
    private String groups;
    private boolean isSwitched;
    private String tag;

    public BallToysComBean(String str, String str2) {
        this.deviceId = str;
        this.tag = str2;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getExpSplit() {
        return this.expSplit;
    }

    public String getGroups() {
        return this.groups;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean isSwitched() {
        return this.isSwitched;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setExpSplit(String str) {
        this.expSplit = str;
    }

    public void setGroups(String str) {
        this.groups = str;
    }

    public void setSwitched(boolean z) {
        this.isSwitched = z;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String toString() {
        return "BallToysComBean{deviceId='" + this.deviceId + "', tag='" + this.tag + "', groups='" + this.groups + "', isSwitched=" + this.isSwitched + ", expSplit='" + this.expSplit + '\'' + MessageFormatter.DELIM_STOP;
    }

    public BallToysComBean(String str, String str2, String str3, boolean z) {
        this.deviceId = str;
        this.tag = str2;
        this.groups = str3;
        this.isSwitched = z;
        this.expSplit = ",";
    }
}
