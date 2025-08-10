package com.wear.bean.socketio.msg.response;

import java.util.List;

/* loaded from: classes3.dex */
public class CreateRoomSyncResponse extends BaseGroupControlResponse {
    private String ackId;
    private List<PlayerListBean> playerList;
    private String roomId;

    public static class PlayerListBean {
        private String jid;
        private int status;

        public String getJid() {
            return this.jid;
        }

        public int getStatus() {
            return this.status;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }
    }

    public String getAckId() {
        return this.ackId;
    }

    public List<PlayerListBean> getPlayerList() {
        return this.playerList;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setPlayerList(List<PlayerListBean> list) {
        this.playerList = list;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
