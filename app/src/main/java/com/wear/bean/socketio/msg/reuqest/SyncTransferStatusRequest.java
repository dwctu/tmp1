package com.wear.bean.socketio.msg.reuqest;

/* loaded from: classes3.dex */
public class SyncTransferStatusRequest extends BaseGroupControlRequest {
    private String roomId;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "syncTransferStatus";
    }

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest
    public String getRoomId() {
        return this.roomId;
    }

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest
    public void setRoomId(String str) {
        this.roomId = str;
    }
}
