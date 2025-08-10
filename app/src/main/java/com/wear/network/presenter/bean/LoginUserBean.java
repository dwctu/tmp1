package com.wear.network.presenter.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class LoginUserBean implements Serializable {
    private int accept;
    private String appAccountCode;
    private List<BackupXmppUrlsBean> backupXmppUrls;
    private Birth birth;
    private List<String> blockedFriends;
    private List<String> byMessageMuteList;
    private String email;
    private boolean enableAgoraIO = true;
    private boolean enableColdRestart = false;
    private String feature;
    private String ip;
    private int isSupportGroup;
    private boolean isTest;
    private int logAccept;
    private boolean newUser;
    private String pwdType;
    private List<RecommendXmppUrlsBean> recommendXmppUrls;
    private String remoteAccountId;
    private int syncPatternSwitch;
    private int syncPatternTips;
    private String uid;
    private int userId;
    private List<UserSettingsBean> userSettings;
    private String username;
    private boolean verify;
    private int verifyEmailTipIntervalDays;
    private String verifyEmailUrl;
    private long verifyExpiredTime;
    private String ws_server_url;
    private String wtoken;
    private String xmppPort;
    private String xmppUrl;

    public static class Birth implements Serializable {
        private int subscribeStatus = 0;
        private boolean isShowBirthdayTip = false;
        private int birthdayMonth = 0;
        private int birthdayDay = 0;

        public int getBirthdayDay() {
            return this.birthdayDay;
        }

        public int getBirthdayMonth() {
            return this.birthdayMonth;
        }

        public int getSubscribeStatus() {
            return this.subscribeStatus;
        }

        public boolean isShowBirthdayTip() {
            return this.isShowBirthdayTip;
        }

        public void setBirthdayDay(int i) {
            this.birthdayDay = i;
        }

        public void setBirthdayMonth(int i) {
            this.birthdayMonth = i;
        }

        public void setShowBirthdayTip(boolean z) {
            this.isShowBirthdayTip = z;
        }

        public void setSubscribeStatus(int i) {
            this.subscribeStatus = i;
        }
    }

    public static class UserSettingsBean implements Serializable {
        private String jid;
        private String muteFlag;

        public String getJid() {
            return this.jid;
        }

        public String getMuteFlag() {
            return this.muteFlag;
        }

        public void setJid(String str) {
            this.jid = str;
        }

        public void setMuteFlag(String str) {
            this.muteFlag = str;
        }
    }

    public int getAccept() {
        return this.accept;
    }

    public String getAppAccountCode() {
        return this.appAccountCode;
    }

    public List<BackupXmppUrlsBean> getBackupXmppUrls() {
        return this.backupXmppUrls;
    }

    public Birth getBirth() {
        Birth birth = this.birth;
        return birth == null ? new Birth() : birth;
    }

    public List<String> getBlockedFriends() {
        return this.blockedFriends;
    }

    public List<String> getByMessageMuteList() {
        return this.byMessageMuteList;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFeature() {
        return this.feature;
    }

    public String getIp() {
        return this.ip;
    }

    public int getIsSupportGroup() {
        return this.isSupportGroup;
    }

    public int getLogAccept() {
        return this.logAccept;
    }

    public String getPwdType() {
        return this.pwdType;
    }

    public List<RecommendXmppUrlsBean> getRecommendXmppUrls() {
        return this.recommendXmppUrls;
    }

    public String getRemoteAccountId() {
        return this.remoteAccountId;
    }

    public int getSyncPatternSwitch() {
        return this.syncPatternSwitch;
    }

    public int getSyncPatternTips() {
        return this.syncPatternTips;
    }

    public String getUid() {
        return this.uid;
    }

    public int getUserId() {
        return this.userId;
    }

    public List<UserSettingsBean> getUserSettings() {
        return this.userSettings;
    }

    public String getUsername() {
        return this.username;
    }

    public int getVerifyEmailTipIntervalDays() {
        return this.verifyEmailTipIntervalDays;
    }

    public String getVerifyEmailUrl() {
        return this.verifyEmailUrl;
    }

    public long getVerifyExpiredTime() {
        return this.verifyExpiredTime;
    }

    public String getWs_server_url() {
        return this.ws_server_url;
    }

    public String getWtoken() {
        return this.wtoken;
    }

    public String getXmppPort() {
        return this.xmppPort;
    }

    public String getXmppUrl() {
        return this.xmppUrl;
    }

    public boolean isEnableAgoraIO() {
        return this.enableAgoraIO;
    }

    public boolean isEnableColdRestart() {
        return this.enableColdRestart;
    }

    public boolean isIsTest() {
        return this.isTest;
    }

    public boolean isNewUser() {
        return this.newUser;
    }

    public boolean isVerify() {
        return this.verify;
    }

    public void setAccept(int i) {
        this.accept = i;
    }

    public void setAppAccountCode(String str) {
        this.appAccountCode = str;
    }

    public void setBackupXmppUrls(List<BackupXmppUrlsBean> list) {
        this.backupXmppUrls = list;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public void setBlockedFriends(List<String> list) {
        this.blockedFriends = list;
    }

    public void setByMessageMuteList(List<String> list) {
        this.byMessageMuteList = list;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEnableAgoraIO(boolean z) {
        this.enableAgoraIO = z;
    }

    public void setEnableColdRestart(boolean z) {
        this.enableColdRestart = z;
    }

    public void setFeature(String str) {
        this.feature = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setIsSupportGroup(int i) {
        this.isSupportGroup = i;
    }

    public void setIsTest(boolean z) {
        this.isTest = z;
    }

    public void setLogAccept(int i) {
        this.logAccept = i;
    }

    public void setNewUser(boolean z) {
        this.newUser = z;
    }

    public void setPwdType(String str) {
        this.pwdType = str;
    }

    public void setRecommendXmppUrls(List<RecommendXmppUrlsBean> list) {
        this.recommendXmppUrls = list;
    }

    public void setRemoteAccountId(String str) {
        this.remoteAccountId = str;
    }

    public void setSyncPatternSwitch(int i) {
        this.syncPatternSwitch = i;
    }

    public void setSyncPatternTips(int i) {
        this.syncPatternTips = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUserSettings(List<UserSettingsBean> list) {
        this.userSettings = list;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setVerify(boolean z) {
        this.verify = z;
    }

    public void setVerifyEmailTipIntervalDays(int i) {
        this.verifyEmailTipIntervalDays = i;
    }

    public void setVerifyEmailUrl(String str) {
        this.verifyEmailUrl = str;
    }

    public void setVerifyExpiredTime(long j) {
        this.verifyExpiredTime = j;
    }

    public void setWs_server_url(String str) {
        this.ws_server_url = str;
    }

    public void setWtoken(String str) {
        this.wtoken = str;
    }

    public void setXmppPort(String str) {
        this.xmppPort = str;
    }

    public void setXmppUrl(String str) {
        this.xmppUrl = str;
    }
}
