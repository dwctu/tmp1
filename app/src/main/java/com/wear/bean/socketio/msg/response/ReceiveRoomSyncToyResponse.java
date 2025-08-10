package com.wear.bean.socketio.msg.response;

import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class ReceiveRoomSyncToyResponse {
    private String order;
    private String roomId;
    private int version = 0;

    public String getOrder() {
        return this.order;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getVersion() {
        return this.version;
    }

    public void setOrder(String str) {
        this.order = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "ReceiveRoomSyncToyResponse{version=" + this.version + ", order='" + this.order + "', roomId='" + this.roomId + '\'' + MessageFormatter.DELIM_STOP;
    }
}
