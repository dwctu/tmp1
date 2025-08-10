package com.wear.bean;

import com.wear.bean.socketio.chatBase.BaseChatResponseBean;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class ControlLinkInfoBean extends BaseChatResponseBean implements Serializable {
    private CreatorBean creator;
    private EndInfoBean endInfo;
    private JoinerBean joiner;
    private boolean joinerFirstTime;
    private LinkBean link;
    private String linkId;
    private int linkStatus;
    private String platform;
    private PunishmentBean punishment;
    private String selfId;
    private int version;
    private String x;
    private String y;

    public static class CreatorBean implements Serializable {
        private Boolean newVersion;
        private List<ControlLinkCreatorToyBean> toys;
        private String userId;

        public List<ControlLinkCreatorToyBean> getToys() {
            return this.toys;
        }

        public String getUserId() {
            return this.userId;
        }

        public Boolean isNewVersion() {
            return this.newVersion;
        }

        public void setNewVersion(Boolean bool) {
            this.newVersion = bool;
        }

        public void setToys(List<ControlLinkCreatorToyBean> list) {
            this.toys = list;
        }

        public void setUserId(String str) {
            this.userId = str;
        }
    }

    public static class EndInfoBean implements Serializable {
        private int endPersonType;

        public int getEndPersonType() {
            return this.endPersonType;
        }

        public void setEndPersonType(int i) {
            this.endPersonType = i;
        }
    }

    public static class JoinerBean implements Serializable {
        private Boolean newVersion;
        private List<ControlLinkJoinerToyBean> toys;
        private String userId;

        public List<ControlLinkJoinerToyBean> getToys() {
            return this.toys;
        }

        public String getUserId() {
            return this.userId;
        }

        public Boolean isNewVersion() {
            return this.newVersion;
        }

        public void setNewVersion(Boolean bool) {
            this.newVersion = bool;
        }

        public void setToys(List<ControlLinkJoinerToyBean> list) {
            this.toys = list;
        }

        public void setUserId(String str) {
            this.userId = str;
        }
    }

    public static class LinkBean implements Serializable {
        private long createTime;
        private long expireDate;
        private long expires;
        private boolean isStart;
        private long leftControlTime;
        private String linkDesc;
        private String msgType;
        private long startTimerTime;
        private List<String> tags;

        public long getCreateTime() {
            return this.createTime;
        }

        public long getExpireDate() {
            return this.expireDate;
        }

        public long getExpires() {
            return this.expires;
        }

        public long getLeftControlTime() {
            return this.leftControlTime;
        }

        public String getLinkDesc() {
            return this.linkDesc;
        }

        public String getMsgType() {
            return this.msgType;
        }

        public long getStartTimerTime() {
            return this.startTimerTime;
        }

        public List<String> getTags() {
            return this.tags;
        }

        public boolean isIsStart() {
            return this.isStart;
        }

        public void setCreateTime(long j) {
            this.createTime = j;
        }

        public void setExpireDate(long j) {
            this.expireDate = j;
        }

        public void setExpires(long j) {
            this.expires = j;
        }

        public void setIsStart(boolean z) {
            this.isStart = z;
        }

        public void setLeftControlTime(long j) {
            this.leftControlTime = j;
        }

        public void setLinkDesc(String str) {
            this.linkDesc = str;
        }

        public void setMsgType(String str) {
            this.msgType = str;
        }

        public void setStartTimerTime(long j) {
            this.startTimerTime = j;
        }

        public void setTags(List<String> list) {
            this.tags = list;
        }
    }

    public static class PunishmentBean implements Serializable {
        private int banTime;
        private boolean controllerBanned;
        private String timeUnit;

        public int getBanTime() {
            return this.banTime;
        }

        public String getTimeUnit() {
            return this.timeUnit;
        }

        public boolean isControllerBanned() {
            return this.controllerBanned;
        }

        public void setBanTime(int i) {
            this.banTime = i;
        }

        public void setControllerBanned(boolean z) {
            this.controllerBanned = z;
        }

        public void setTimeUnit(String str) {
            this.timeUnit = str;
        }
    }

    public CreatorBean getCreator() {
        return this.creator;
    }

    public EndInfoBean getEndInfo() {
        return this.endInfo;
    }

    public JoinerBean getJoiner() {
        return this.joiner;
    }

    public LinkBean getLink() {
        return this.link;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public int getLinkStatus() {
        return this.linkStatus;
    }

    public String getPlatform() {
        return this.platform;
    }

    public PunishmentBean getPunishment() {
        return this.punishment;
    }

    public String getSelfId() {
        return this.selfId;
    }

    public int getVersion() {
        return this.version;
    }

    public String getX() {
        return this.x;
    }

    public String getY() {
        return this.y;
    }

    public boolean isJoinerFirstTime() {
        return this.joinerFirstTime;
    }

    public void setCreator(CreatorBean creatorBean) {
        this.creator = creatorBean;
    }

    public void setEndInfo(EndInfoBean endInfoBean) {
        this.endInfo = endInfoBean;
    }

    public void setJoiner(JoinerBean joinerBean) {
        this.joiner = joinerBean;
    }

    public void setJoinerFirstTime(boolean z) {
        this.joinerFirstTime = z;
    }

    public void setLink(LinkBean linkBean) {
        this.link = linkBean;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setLinkStatus(int i) {
        this.linkStatus = i;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPunishment(PunishmentBean punishmentBean) {
        this.punishment = punishmentBean;
    }

    public void setSelfId(String str) {
        this.selfId = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public void setX(String str) {
        this.x = str;
    }

    public void setY(String str) {
        this.y = str;
    }
}
