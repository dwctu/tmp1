package com.wear.bean.socketio.timestamp;

/* loaded from: classes3.dex */
public class TimestampResponse {
    private String ackId;
    private long serverTimestamp;

    public String getAckId() {
        return this.ackId;
    }

    public long getServerTimestamp() {
        return this.serverTimestamp;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setServerTimestamp(long j) {
        this.serverTimestamp = j;
    }
}
