package com.wear.bean.socketio.msg.reuqest;

/* loaded from: classes3.dex */
public class EndRoomsSyncRequest extends BaseGroupControlRequest {
    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "endRoomsSync";
    }
}
