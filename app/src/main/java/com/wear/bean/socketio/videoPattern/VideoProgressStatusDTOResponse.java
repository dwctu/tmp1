package com.wear.bean.socketio.videoPattern;

/* loaded from: classes3.dex */
public class VideoProgressStatusDTOResponse {
    private String localTime;
    private String serverTime;
    private String speed;
    private String videoId;
    private String videoTime;

    public String getLocalTime() {
        return this.localTime;
    }

    public String getServerTime() {
        return this.serverTime;
    }

    public String getSpeed() {
        return this.speed;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoTime() {
        return this.videoTime;
    }

    public void setLocalTime(String str) {
        this.localTime = str;
    }

    public void setServerTime(String str) {
        this.serverTime = str;
    }

    public void setSpeed(String str) {
        this.speed = str;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public void setVideoTime(String str) {
        this.videoTime = str;
    }
}
