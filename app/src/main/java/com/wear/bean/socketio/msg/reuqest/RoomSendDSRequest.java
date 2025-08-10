package com.wear.bean.socketio.msg.reuqest;

import com.wear.bean.socketio.msg.ApiClassAnnotation;
import java.util.List;

@ApiClassAnnotation(cls = String.class)
/* loaded from: classes3.dex */
public class RoomSendDSRequest extends BaseGroupControlRequest {
    private List<String> playerJidList;
    private String targeterJid;

    @Override // com.wear.bean.socketio.msg.reuqest.BaseGroupControlRequest, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "createMultiToOneControlV2";
    }

    public List<String> getPlayerJidList() {
        return this.playerJidList;
    }

    public String getTargeterJid() {
        return this.targeterJid;
    }

    public void setPlayerJidList(List<String> list) {
        this.playerJidList = list;
    }

    public void setTargeterJid(String str) {
        this.targeterJid = str;
    }
}
