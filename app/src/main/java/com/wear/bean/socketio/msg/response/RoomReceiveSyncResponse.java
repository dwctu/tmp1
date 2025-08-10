package com.wear.bean.socketio.msg.response;

import java.util.List;

/* loaded from: classes3.dex */
public class RoomReceiveSyncResponse extends BaseGroupControlResponse {
    private long createTime;
    private MasterBean master;
    private List<PlayerListBean> playerList;
    private String roomId;
    private boolean syncControlling;

    public static class MasterBean {
        private String jid;
        private String scMethodEnum;
        private String toyJson;
        private String toyType;

        public String getJid() {
            return this.jid;
        }

        public String getScMethodEnum() {
            return this.scMethodEnum;
        }

        public String getToyJson() {
            return this.toyJson;
        }

        public String getToyType() {
            return this.toyType;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setScMethodEnum(String str) {
            this.scMethodEnum = str;
        }

        public void setToyJson(String str) {
            this.toyJson = str;
        }

        public void setToyType(String str) {
            this.toyType = str;
        }
    }

    public static class PlayerListBean {
        private String jid;
        private int status;
        private String toyJson;

        public String getJid() {
            return this.jid;
        }

        public int getStatus() {
            return this.status;
        }

        public String getToyJson() {
            return this.toyJson;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setToyJson(String str) {
            this.toyJson = str;
        }
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public MasterBean getMaster() {
        return this.master;
    }

    public List<PlayerListBean> getPlayerList() {
        return this.playerList;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public boolean isSyncControlling() {
        return this.syncControlling;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setMaster(MasterBean masterBean) {
        this.master = masterBean;
    }

    public void setPlayerList(List<PlayerListBean> list) {
        this.playerList = list;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSyncControlling(boolean z) {
        this.syncControlling = z;
    }
}
