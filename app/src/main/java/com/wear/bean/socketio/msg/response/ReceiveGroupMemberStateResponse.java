package com.wear.bean.socketio.msg.response;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class ReceiveGroupMemberStateResponse implements Serializable {
    private String ackId;
    private List<PlayerJidListBean> playerJidList;

    public static class PlayerJidListBean implements Serializable {
        private String jid;
        private int onLine;
        private String openfireStatus;
        private String scStatus;
        private int state;
        private boolean supportMultiToOne;
        private String toyJson;

        public String getJid() {
            return this.jid;
        }

        public int getOnLine() {
            return this.onLine;
        }

        public String getOpenfireStatus() {
            return this.openfireStatus;
        }

        public String getScStatus() {
            return this.scStatus;
        }

        public int getState() {
            return this.state;
        }

        public String getToyJson() {
            return this.toyJson;
        }

        public boolean isSupportMultiToOne() {
            return this.supportMultiToOne;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setOnLine(int i) {
            this.onLine = i;
        }

        public void setOpenfireStatus(String str) {
            this.openfireStatus = str;
        }

        public void setScStatus(String str) {
            this.scStatus = str;
        }

        public void setState(int i) {
            this.state = i;
        }

        public void setSupportMultiToOne(boolean z) {
            this.supportMultiToOne = z;
        }

        public void setToyJson(String str) {
            this.toyJson = str;
        }
    }

    public String getAckId() {
        return this.ackId;
    }

    public List<PlayerJidListBean> getPlayerJidList() {
        return this.playerJidList;
    }

    public void setAckId(String str) {
        this.ackId = str;
    }

    public void setPlayerJidList(List<PlayerJidListBean> list) {
        this.playerJidList = list;
    }
}
