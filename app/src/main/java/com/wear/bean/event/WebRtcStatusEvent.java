package com.wear.bean.event;

/* loaded from: classes3.dex */
public class WebRtcStatusEvent {
    public static final int STATUS_CONNECTED = 1;
    public static final int STATUS_DISCONNECTED = 0;
    private int status;

    public WebRtcStatusEvent(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
