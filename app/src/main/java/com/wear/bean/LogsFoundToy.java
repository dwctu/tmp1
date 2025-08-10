package com.wear.bean;

/* loaded from: classes3.dex */
public class LogsFoundToy {
    public String dt;
    public long ft;
    public String mac;
    public String name;
    public Long rquestConnectTime;
    public int rssi;
    public long st;
    public Long startScanTime;

    public String getDt() {
        return this.dt;
    }

    public long getFt() {
        return this.ft;
    }

    public String getMac() {
        return this.mac;
    }

    public String getName() {
        return this.name;
    }

    public Long getRquestConnectTime() {
        return this.rquestConnectTime;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getSt() {
        return this.st;
    }

    public long getStartScanTime() {
        return this.startScanTime.longValue();
    }

    public void setDt(String str) {
        this.dt = str;
    }

    public void setFt(long j) {
        this.ft = j;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRquestConnectTime(Long l) {
        this.rquestConnectTime = l;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public void setSt(long j) {
        this.st = j;
    }

    public void setStartScanTime(Long l) {
        this.startScanTime = l;
    }
}
