package org.jivesoftware.smackx.disco.bean.response;

import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* loaded from: classes5.dex */
public class Room {
    private String banType;
    private String byWho;
    private long enterTime;
    private String mcs;
    private String rns;
    private String roomId;
    private String roomName;
    private String rps;
    private int status;
    private String url;

    public String getBanType() {
        return this.banType;
    }

    public String getByWho() {
        return this.byWho;
    }

    public long getEnterTime() {
        return this.enterTime;
    }

    public String getMcs() {
        return this.mcs;
    }

    public String getRns() {
        return this.rns;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getRps() {
        return this.rps;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isRoomActive() {
        return this.banType.equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
    }

    public boolean isRoomDisbanded() {
        return this.banType.equals("disbanded");
    }

    public boolean isRoomProhibited() {
        return this.banType.equals("prohibited");
    }

    public void setBanType(String str) {
        this.banType = str;
    }

    public void setByWho(String str) {
        this.byWho = str;
    }

    public void setEnterTime(long j) {
        this.enterTime = j;
    }

    public void setMcs(String str) {
        this.mcs = str;
    }

    public void setRns(String str) {
        this.rns = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setRps(String str) {
        this.rps = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
