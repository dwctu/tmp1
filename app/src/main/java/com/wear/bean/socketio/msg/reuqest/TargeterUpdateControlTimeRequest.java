package com.wear.bean.socketio.msg.reuqest;

/* loaded from: classes3.dex */
public class TargeterUpdateControlTimeRequest extends BaseGroupControlRequest {
    private String controlTime;
    private String roomId;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "TARGETER_UPDATE_CONTROL_TIME";
    }

    public String getControlTime() {
        return this.controlTime;
    }

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest
    public String getRoomId() {
        return this.roomId;
    }

    public void setControlTime(String str) {
        this.controlTime = str;
    }

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest
    public void setRoomId(String str) {
        this.roomId = str;
    }
}
