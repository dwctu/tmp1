package com.wear.bean.socketio.display;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes3.dex */
public class DisplayPannelIfoBean {
    private int controlTime;
    private String controlType;
    private String csName;
    private String csToyInfo;
    private int expire;
    private String modName;
    private String modToyId;
    private String pcOrMobile;
    private String pf;
    private int readyTime;
    private String status;
    private int waitSeconds;

    public int getControlTime() {
        return this.controlTime;
    }

    public String getControlType() {
        return this.controlType;
    }

    public String getCsName() {
        return this.csName;
    }

    public String getCsToyInfo() {
        return this.csToyInfo;
    }

    public int getExpire() {
        return this.expire;
    }

    public String getModName() {
        return this.modName;
    }

    public String getModToyId() {
        return this.modToyId;
    }

    public String getPcOrMobile() {
        return this.pcOrMobile;
    }

    public String getPf() {
        return this.pf;
    }

    public int getReadyTime() {
        return this.readyTime;
    }

    public String getStatus() {
        return this.status;
    }

    public int getWaitSeconds() {
        return this.waitSeconds;
    }

    public boolean isReady() {
        return "ready".equals(this.status);
    }

    public boolean isStart() {
        return TtmlNode.START.equals(this.status);
    }

    public boolean isTwoWay() {
        return "twoWay".equals(this.controlType) || TextUtils.isEmpty(this.controlType);
    }

    public void setControlTime(int i) {
        this.controlTime = i;
    }

    public void setControlType(String str) {
        this.controlType = str;
    }

    public void setCsName(String str) {
        this.csName = str;
    }

    public void setCsToyInfo(String str) {
        this.csToyInfo = str;
    }

    public void setExpire(int i) {
        this.expire = i;
    }

    public void setModName(String str) {
        this.modName = str;
    }

    public void setModToyId(String str) {
        this.modToyId = str;
    }

    public void setPcOrMobile(String str) {
        this.pcOrMobile = str;
    }

    public void setPf(String str) {
        this.pf = str;
    }

    public void setReadyTime(int i) {
        this.readyTime = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setWaitSeconds(int i) {
        this.waitSeconds = i;
    }
}
