package com.wear.bean.socketio.msg.reuqest;

import com.wear.bean.socketio.msg.ApiClassAnnotation;
import java.util.List;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class RoomSendSyncRequest extends BaseGroupControlRequest {
    private List<String> playerJidList;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "roomSendSync";
    }

    public List<String> getPlayerJidList() {
        return this.playerJidList;
    }

    public void setPlayerJidList(List<String> list) {
        this.playerJidList = list;
    }
}
