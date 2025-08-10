package com.wear.bean.socketio.msg.response;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class DSPlayerListBean implements Serializable {
    private String ackId;
    private String jid;
    private String roomId;
    private Integer status;
    private String toyJson;

    public String getAckId() {
        return this.ackId;
    }

    public String getJid() {
        return this.jid;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getToyJson() {
        return this.toyJson;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setToyJson(String str) {
        this.toyJson = str;
    }
}
