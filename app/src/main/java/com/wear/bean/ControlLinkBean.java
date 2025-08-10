package com.wear.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ControlLinkBean implements Serializable {
    private ControlPermissionResponse controlPermission;
    private CreatorBean creator;
    private EndInfoBean endInfo;
    private JoinerBean joiner;
    private boolean joinerFirstTime;
    private LinkBean link;
    private String linkId;
    private int linkStatus;
    private MakeFriendBean makeFriend;
    private int openType = 1;
    private String platform;
    private PunishmentBean punishment;
    private String selfId;
    private int version;
    private String x;
    private String y;

    public static class ControlPermissionResponse implements Serializable {
        public boolean creatorExistUntreatedLiveControlRequest;
        public boolean creatorExistUntreatedSyncControlRequest;
        public long creatorLastApplyLiveControlTime;
        public long creatorLastApplySyncControlTime;
        public boolean joinerHasLiveControlPermission;
        public boolean joinerHasSyncControlPermission;
        public boolean openControlPermission;

        public boolean getCreatorExistUntreatedLiveControlRequest() {
            return this.creatorExistUntreatedLiveControlRequest;
        }

        public boolean getCreatorExistUntreatedSyncControlRequest() {
            return this.creatorExistUntreatedSyncControlRequest;
        }

        public long getCreatorLastApplyLiveControlTime() {
            return this.creatorLastApplyLiveControlTime;
        }

        public long getCreatorLastApplySyncControlTime() {
            return this.creatorLastApplySyncControlTime;
        }

        public boolean getJoinerHasLiveControlPermission() {
            return this.joinerHasLiveControlPermission;
        }

        public boolean getJoinerHasSyncControlPermission() {
            return this.joinerHasSyncControlPermission;
        }

        public boolean getOpenControlPermission() {
            return this.openControlPermission;
        }

        public void setCreatorExistUntreatedLiveControlRequest(boolean z) {
            this.creatorExistUntreatedLiveControlRequest = z;
        }

        public void setCreatorExistUntreatedSyncControlRequest(boolean z) {
            this.creatorExistUntreatedSyncControlRequest = z;
        }

        public void setCreatorLastApplyLiveControlTime(long j) {
            this.creatorLastApplyLiveControlTime = j;
        }

        public void setCreatorLastApplySyncControlTime(long j) {
            this.creatorLastApplySyncControlTime = j;
        }

        public void setJoinerHasLiveControlPermission(boolean z) {
            this.joinerHasLiveControlPermission = z;
        }

        public void setJoinerHasSyncControlPermission(boolean z) {
            this.joinerHasSyncControlPermission = z;
        }

        public void setOpenControlPermission(boolean z) {
            this.openControlPermission = z;
        }
    }

    public static class CreatorBean implements Serializable {
        private boolean newVersion;
        private List<ControlLinkCreatorToyBean> toys = new ArrayList();
        private String userId;

        public List<ControlLinkCreatorToyBean> getToys() {
            return this.toys;
        }

        public String getUserId() {
            return this.userId;
        }

        public boolean isNewVersion() {
            return this.newVersion;
        }

        public void setNewVersion(boolean z) {
            this.newVersion = z;
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
        private boolean newVersion;
        private List<ControlLinkJoinerToyBean> toys = new ArrayList();
        private String userId;

        public List<ControlLinkJoinerToyBean> getToys() {
            return this.toys;
        }

        public String getUserId() {
            return this.userId;
        }

        public boolean isNewVersion() {
            return this.newVersion;
        }

        public void setNewVersion(boolean z) {
            this.newVersion = z;
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

    public static class MakeFriendBean {
        public boolean existOtherAddReq;
        public boolean needRefreshOpenfireFriend;
        public boolean otherAcceptAddReq;

        public boolean getExistOtherAddReq() {
            return this.existOtherAddReq;
        }

        public boolean getNeedRefreshOpenfireFriend() {
            return this.needRefreshOpenfireFriend;
        }

        public boolean getOtherAcceptAddReq() {
            return this.otherAcceptAddReq;
        }

        public void setExistOtherAddReq(boolean z) {
            this.existOtherAddReq = z;
        }

        public void setNeedRefreshOpenfireFriend(boolean z) {
            this.needRefreshOpenfireFriend = z;
        }

        public void setOtherAcceptAddReq(boolean z) {
            this.otherAcceptAddReq = z;
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

    public ControlPermissionResponse getControlPermission() {
        return this.controlPermission;
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

    public MakeFriendBean getMakeFriend() {
        return this.makeFriend;
    }

    public int getOpenType() {
        return this.openType;
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

    public void setControlPermission(ControlPermissionResponse controlPermissionResponse) {
        this.controlPermission = controlPermissionResponse;
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

    public void setMakeFriend(MakeFriendBean makeFriendBean) {
        this.makeFriend = makeFriendBean;
    }

    public void setOpenType(int i) {
        this.openType = i;
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
