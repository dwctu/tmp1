package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;
import java.util.HashMap;

@DatabaseTable(tableName = "tb_user_setting")
/* loaded from: classes3.dex */
public class UserSetting extends BaseEntity {

    @DatabaseField
    private long addTime;

    @DatabaseField
    private Boolean audioVibration;

    @DatabaseField
    private Boolean autoAccept;

    @DatabaseField
    private Boolean autoPlayAlarm = Boolean.FALSE;

    @DatabaseField
    private Boolean autoPlayPattern;

    @DatabaseField
    private String friendUserId;

    @DatabaseField
    private boolean friendsRequestClick;

    @DatabaseField
    private Boolean logNotify;

    @DatabaseField
    private Boolean messageVibration;

    @DatabaseField
    private String passiveConfig;

    @DatabaseField
    private String userId;

    public long getAddTime() {
        return this.addTime;
    }

    public Boolean getAudioVibration() {
        Boolean bool = this.audioVibration;
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public Boolean getAutoAccept() {
        return this.autoAccept;
    }

    public Boolean getAutoPlayAlarm() {
        return this.autoPlayAlarm;
    }

    public Boolean getAutoPlayPattern() {
        return this.autoPlayPattern;
    }

    public String getFriendUserId() {
        String strF = nd3.f(this.friendUserId);
        return WearUtils.e1(strF) ? this.friendUserId : strF;
    }

    public Boolean getLogNotify() {
        return this.logNotify;
    }

    public Boolean getMessageVibration() {
        return this.messageVibration;
    }

    public String getOldFriendUserId() {
        return this.friendUserId;
    }

    public String getOldUserId() {
        return this.userId;
    }

    public Boolean getPassiveAutoAccept() {
        return !WearUtils.e1(getPassiveConfig()) ? Boolean.valueOf(WearUtils.y1((String) ((HashMap) WearUtils.A.fromJson(getPassiveConfig(), HashMap.class)).get("304305"))) : Boolean.FALSE;
    }

    public String getPassiveConfig() {
        return this.passiveConfig;
    }

    public String getUserId() {
        String strF = nd3.f(this.userId);
        return WearUtils.e1(strF) ? this.userId : strF;
    }

    public boolean isFriendsRequestClick() {
        return this.friendsRequestClick;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public void setAudioVibration(Boolean bool) {
        this.audioVibration = bool;
    }

    public void setAutoAccept(Boolean bool) {
        this.autoAccept = bool;
    }

    public void setAutoPlayAlarm(Boolean bool) {
        this.autoPlayAlarm = bool;
    }

    public void setAutoPlayPattern(Boolean bool) {
        this.autoPlayPattern = bool;
    }

    public void setFriendUserId(String str) {
        this.friendUserId = nd3.p(str);
    }

    public void setFriendsRequestClick(boolean z) {
        this.friendsRequestClick = z;
    }

    public void setLogNotify(Boolean bool) {
        this.logNotify = bool;
    }

    public void setMessageVibration(Boolean bool) {
        this.messageVibration = bool;
    }

    public void setPassiveAutoAccept(Boolean bool) {
        HashMap map = new HashMap();
        if (!WearUtils.e1(getPassiveConfig())) {
            map = (HashMap) WearUtils.A.fromJson(getPassiveConfig(), HashMap.class);
        }
        map.put("304305", bool.booleanValue() ? "true" : "false");
        setPassiveConfig(WearUtils.A.toJson(map));
    }

    public void setPassiveConfig(String str) {
        this.passiveConfig = str;
    }

    public void setUserId(String str) {
        this.userId = nd3.p(str);
    }
}
