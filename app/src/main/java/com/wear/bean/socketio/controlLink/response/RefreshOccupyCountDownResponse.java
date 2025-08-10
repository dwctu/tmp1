package com.wear.bean.socketio.controlLink.response;

/* loaded from: classes3.dex */
public class RefreshOccupyCountDownResponse {
    private String linkId;
    private boolean reachMaxAbnormalCount;
    private int remainTime;

    public String getLinkId() {
        return this.linkId;
    }

    public int getRemainTime() {
        return this.remainTime;
    }

    public boolean isReachMaxAbnormalCount() {
        return this.reachMaxAbnormalCount;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setReachMaxAbnormalCount(boolean z) {
        this.reachMaxAbnormalCount = z;
    }

    public void setRemainTime(int i) {
        this.remainTime = i;
    }
}
