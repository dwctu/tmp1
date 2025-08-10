package com.wear.bean.socketio.msg.response;

import java.util.List;

/* loaded from: classes3.dex */
public class ReceiveMultiToOneControlInviteV2Response {
    private String ackId;
    private Long createTime;
    private String creatorJid;
    private List<DSPlayerListBean> playerList;
    private String roomId;
    private TargeterBean targeter;

    public static class TargeterBean {
        private String ackId;
        private String jid;
        private String roomId;
        private String status;
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

        public String getStatus() {
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

        public void setStatus(String str) {
            this.status = str;
        }

        public void setToyJson(String str) {
            this.toyJson = str;
        }
    }

    public String getAckId() {
        return this.ackId;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getCreatorJid() {
        return this.creatorJid;
    }

    public List<DSPlayerListBean> getPlayerList() {
        return this.playerList;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public TargeterBean getTargeter() {
        return this.targeter;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setCreatorJid(String str) {
        this.creatorJid = str;
    }

    public void setPlayerList(List<DSPlayerListBean> list) {
        this.playerList = list;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setTargeter(TargeterBean targeterBean) {
        this.targeter = targeterBean;
    }
}
