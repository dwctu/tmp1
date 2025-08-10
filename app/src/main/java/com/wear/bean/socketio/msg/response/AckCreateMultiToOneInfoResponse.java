package com.wear.bean.socketio.msg.response;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class AckCreateMultiToOneInfoResponse implements Serializable {
    private String ackId;
    private List<String> playerJidList;
    private List<DSPlayerListBean> playerList;
    private String requestId;
    private boolean requestReceipt;
    private String roomId;
    private int status;
    private String targeterJid;

    public String getAckId() {
        return this.ackId;
    }

    public List<String> getPlayerJidList() {
        return this.playerJidList;
    }

    public List<DSPlayerListBean> getPlayerList() {
        return this.playerList;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTargeterJid() {
        return this.targeterJid;
    }

    public boolean isRequestReceipt() {
        return this.requestReceipt;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setPlayerJidList(List<String> list) {
        this.playerJidList = list;
    }

    public void setPlayerList(List<DSPlayerListBean> list) {
        this.playerList = list;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setRequestReceipt(boolean z) {
        this.requestReceipt = z;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTargeterJid(String str) {
        this.targeterJid = str;
    }
}
