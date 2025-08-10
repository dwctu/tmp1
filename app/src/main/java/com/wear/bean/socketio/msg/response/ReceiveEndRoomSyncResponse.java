package com.wear.bean.socketio.msg.response;

/* loaded from: classes3.dex */
public class ReceiveEndRoomSyncResponse {
    private String ackId;
    private Object requestId;
    private boolean requestReceipt;
    private String roomId;
    private boolean syncControlling;

    public String getAckId() {
        return this.ackId;
    }

    public Object getRequestId() {
        return this.requestId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public boolean isRequestReceipt() {
        return this.requestReceipt;
    }

    public boolean isSyncControlling() {
        return this.syncControlling;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setRequestId(Object obj) {
        this.requestId = obj;
    }

    public void setRequestReceipt(boolean z) {
        this.requestReceipt = z;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSyncControlling(boolean z) {
        this.syncControlling = z;
    }
}
