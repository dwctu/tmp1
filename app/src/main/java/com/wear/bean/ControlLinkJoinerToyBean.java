package com.wear.bean;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class ControlLinkJoinerToyBean implements Serializable {
    private String battery;
    private String fVersion;
    private String id;
    private String isControl;
    private String name;
    private String status;
    private String type;
    private String workMode;

    public String getBattery() {
        return this.battery;
    }

    public String getFVersion() {
        return this.fVersion;
    }

    public String getId() {
        return this.id;
    }

    public String getIsControl() {
        return this.isControl;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public String getType() {
        return this.type;
    }

    public String getWorkMode() {
        return this.workMode;
    }

    public void setBattery(String str) {
        this.battery = str;
    }

    public void setFVersion(String str) {
        this.fVersion = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIsControl(String str) {
        this.isControl = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setWorkMode(String str) {
        this.workMode = str;
    }
}
