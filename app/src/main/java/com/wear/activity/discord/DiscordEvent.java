package com.wear.activity.discord;

/* loaded from: classes3.dex */
public class DiscordEvent {
    public static String STATUS_CREATE = "0";
    public static String STATUS_OVER = "2";
    public static String STATUS_UNDERWAY = "1";
    public static int TYPE_ACTIVITY_OVER = 2;
    public static int TYPE_ACTIVITY_STATUS = 5;
    public static int TYPE_JOIN_ACTIVITY = 3;
    public static int TYPE_LEAVE_ACTIVITY = 4;
    public static int TYPE_SCAN_QRCODE = 1;
    private String errorMsg;
    private int eventType;
    private String orderKey;
    private String status;
    private String url;

    public DiscordEvent(int i) {
        this.eventType = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setEventType(int i) {
        this.eventType = i;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
