package com.wear.bean.socketio.msg.response;

import java.util.List;

/* loaded from: classes3.dex */
public class DSAckPlayerJoinMultiToOneResponse {
    private String ackId;
    private long createTime;
    private String creatorJid;
    private String currentPlayerJid;
    private long everyoneHaveControlTime;
    private List<DSPlayerListBean> playerList;
    private long playerRemainTime;
    private long playerStartControlTime;
    private String roomId;
    private boolean start;
    private TargeterBean targeter;

    public static class TargeterBean {
        private Object ackId;
        private String jid;
        private String roomId;
        private Object status;
        private String toyJson;

        public Object getAckId() {
            return this.ackId;
        }

        public String getJid() {
            return this.jid;
        }

        public String getRoomId() {
            return this.roomId;
        }

        public Object getStatus() {
            return this.status;
        }

        public String getToyJson() {
            return this.toyJson;
        }

        public void setAckId(Object obj) {
            this.ackId = obj;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setRoomId(String str) {
            this.roomId = str;
        }

        public void setStatus(Object obj) {
            this.status = obj;
        }

        public void setToyJson(String str) {
            this.toyJson = str;
        }
    }

    public String getAckId() {
        return this.ackId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getCreatorJid() {
        return this.creatorJid;
    }

    public String getCurrentPlayerJid() {
        return this.currentPlayerJid;
    }

    public long getEveryoneHaveControlTime() {
        return this.everyoneHaveControlTime;
    }

    public List<DSPlayerListBean> getPlayerList() {
        return this.playerList;
    }

    public long getPlayerRemainTime() {
        return this.playerRemainTime;
    }

    public long getPlayerStartControlTime() {
        return this.playerStartControlTime;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public TargeterBean getTargeter() {
        return this.targeter;
    }

    public boolean isStart() {
        return this.start;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setCreatorJid(String str) {
        this.creatorJid = str;
    }

    public void setCurrentPlayerJid(String str) {
        this.currentPlayerJid = str;
    }

    public void setEveryoneHaveControlTime(long j) {
        this.everyoneHaveControlTime = j;
    }

    public void setPlayerList(List<DSPlayerListBean> list) {
        this.playerList = list;
    }

    public void setPlayerRemainTime(long j) {
        this.playerRemainTime = j;
    }

    public void setPlayerStartControlTime(long j) {
        this.playerStartControlTime = j;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setStart(boolean z) {
        this.start = z;
    }

    public void setTargeter(TargeterBean targeterBean) {
        this.targeter = targeterBean;
    }
}
