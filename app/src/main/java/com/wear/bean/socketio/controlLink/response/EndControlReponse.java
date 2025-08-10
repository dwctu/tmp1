package com.wear.bean.socketio.controlLink.response;

/* loaded from: classes3.dex */
public class EndControlReponse {
    private int banTime;
    private boolean controllerBanned;
    private int endPersonType;
    private String endType;
    private boolean fromHttpDisable;
    private String linkId;
    private String timeUnit;

    public int getBanTime() {
        return this.banTime;
    }

    public int getEndPersonType() {
        return this.endPersonType;
    }

    public String getEndType() {
        return this.endType;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public String getTimeUnit() {
        return this.timeUnit;
    }

    public boolean isControllerBanned() {
        return this.controllerBanned;
    }

    public boolean isFromHttpDisable() {
        return this.fromHttpDisable;
    }

    public void setBanTime(int i) {
        this.banTime = i;
    }

    public void setControllerBanned(boolean z) {
        this.controllerBanned = z;
    }

    public void setEndPersonType(int i) {
        this.endPersonType = i;
    }

    public void setEndType(String str) {
        this.endType = str;
    }

    public void setFromHttpDisable(boolean z) {
        this.fromHttpDisable = z;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setTimeUnit(String str) {
        this.timeUnit = str;
    }
}
