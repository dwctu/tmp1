package com.wear.bean.socketio.msg.reuqest;

import java.util.List;

/* loaded from: classes3.dex */
public class GetGroupMemberStateRequest extends BaseGroupControlRequest {
    private List<String> playerJidList;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "getGroupMemberState";
    }

    public List<String> getPlayerJidList() {
        return this.playerJidList;
    }

    public void setPlayerJidList(List<String> list) {
        this.playerJidList = list;
    }
}
