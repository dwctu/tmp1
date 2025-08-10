package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_alarm")
/* loaded from: classes3.dex */
public class Alarm extends BaseEntity {

    @DatabaseField
    private String friendEmail;

    @DatabaseField
    private String message;

    @DatabaseField
    private String missSwitchOn;

    @DatabaseField
    private String notifySwitchOn;

    @DatabaseField
    private String ownerEmail;

    public Alarm() {
        setId(WearUtils.E());
    }

    public String getFriendEmail() {
        String strF = nd3.f(this.friendEmail);
        return WearUtils.e1(strF) ? this.friendEmail : strF;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMissSwitchOn() {
        return this.missSwitchOn;
    }

    public String getNotifySwitchOn() {
        return this.notifySwitchOn;
    }

    public String getOldFriendEmail() {
        return this.friendEmail;
    }

    public String getOldOwnerEmail() {
        return this.ownerEmail;
    }

    public String getOwnerEmail() {
        String strF = nd3.f(this.ownerEmail);
        return WearUtils.e1(strF) ? this.ownerEmail : strF;
    }

    public void setFriendEmail(String str) {
        this.friendEmail = nd3.p(str);
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMissSwitchOn(String str) {
        this.missSwitchOn = str;
    }

    public void setNotifySwitchOn(String str) {
        this.notifySwitchOn = str;
    }

    public void setOwnerEmail(String str) {
        this.ownerEmail = nd3.p(str);
    }
}
