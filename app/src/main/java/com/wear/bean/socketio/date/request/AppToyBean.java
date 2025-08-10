package com.wear.bean.socketio.date.request;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class AppToyBean {
    private int battery;
    private int firmwareVersion;
    private String toyId;
    private String toyName;
    private String toyType;
    private String toyVersion;

    public int getBattery() {
        return this.battery;
    }

    public int getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public String getToyId() {
        return this.toyId;
    }

    public String getToyName() {
        return this.toyName;
    }

    public String getToyType() {
        return this.toyType;
    }

    public String getToyVersion() {
        return this.toyVersion;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public void setFirmwareVersion(int i) {
        this.firmwareVersion = i;
    }

    public void setToyId(String str) {
        this.toyId = str;
    }

    public void setToyName(String str) {
        this.toyName = str;
    }

    public void setToyType(String str) {
        this.toyType = str;
    }

    public void setToyVersion(String str) {
        this.toyVersion = str;
    }

    public String toString() {
        return "AppToyBean{toyId='" + this.toyId + "', toyName='" + this.toyName + "', toyType='" + this.toyType + "', toyVersion='" + this.toyVersion + "', battery=" + this.battery + ", firmwareVersion=" + this.firmwareVersion + MessageFormatter.DELIM_STOP;
    }
}
