package com.wear.bean.socketio.videoPattern;

/* loaded from: classes3.dex */
public class MPPlayMediaResponse {
    private String fileName;
    private long jsLocalTimestamp;
    private String mediaTimestamp;
    private String speed;

    public String getFileName() {
        return this.fileName;
    }

    public long getJsLocalTimestamp() {
        return this.jsLocalTimestamp;
    }

    public String getMediaTimestamp() {
        return this.mediaTimestamp;
    }

    public String getSpeed() {
        return this.speed;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setJsLocalTimestamp(long j) {
        this.jsLocalTimestamp = j;
    }

    public void setMediaTimestamp(String str) {
        this.mediaTimestamp = str;
    }

    public void setSpeed(String str) {
        this.speed = str;
    }
}
