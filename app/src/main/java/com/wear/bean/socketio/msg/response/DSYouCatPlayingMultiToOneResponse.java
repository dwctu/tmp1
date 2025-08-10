package com.wear.bean.socketio.msg.response;

import java.util.List;

/* loaded from: classes3.dex */
public class DSYouCatPlayingMultiToOneResponse {
    private String ackId;
    private Long createTime;
    private String creatorJid;
    private String currentPlayerJid;
    private Integer everyoneHaveControlTime;
    private List<DSPlayerListBean> playerList;
    private Long playerRemainTime;
    private Long playerStartControlTime;
    private String roomId;
    private Boolean start;
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

    public String getCurrentPlayerJid() {
        return this.currentPlayerJid;
    }

    public Integer getEveryoneHaveControlTime() {
        return this.everyoneHaveControlTime;
    }

    public List<DSPlayerListBean> getPlayerList() {
        return this.playerList;
    }

    public Long getPlayerRemainTime() {
        return this.playerRemainTime;
    }

    public Long getPlayerStartControlTime() {
        return this.playerStartControlTime;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public Boolean getStart() {
        return this.start;
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

    public void setCurrentPlayerJid(String str) {
        this.currentPlayerJid = str;
    }

    public void setEveryoneHaveControlTime(Integer num) {
        this.everyoneHaveControlTime = num;
    }

    public void setPlayerList(List<DSPlayerListBean> list) {
        this.playerList = list;
    }

    public void setPlayerRemainTime(Long l) {
        this.playerRemainTime = l;
    }

    public void setPlayerStartControlTime(Long l) {
        this.playerStartControlTime = l;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setStart(Boolean bool) {
        this.start = bool;
    }

    public void setTargeter(TargeterBean targeterBean) {
        this.targeter = targeterBean;
    }
}
