package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.protocol.EntityAlarm;
import com.wear.util.WearUtils;
import dc.nd3;

@DatabaseTable(tableName = "tb_alarm_lists")
/* loaded from: classes3.dex */
public class AlarmListItems extends BaseEntity {
    public static final String ALARM_STATUS_ACCEPT = "2#";
    public static final String ALARM_STATUS_AUTO = "1#";
    public static final String ALARM_STATUS_REJECT = "-1#";
    public static final String ALARM_STATUS_WAIT = "0#";

    @DatabaseField
    private int accept;

    @DatabaseField
    private String alarmTitle;
    public EntityAlarm bean;

    @DatabaseField
    private String dates;

    @DatabaseField
    private int duration;

    @DatabaseField
    private String frequency;

    @DatabaseField
    private String friendEmail;

    @DatabaseField
    private int haveSnoozeCount;

    @DatabaseField
    private int isSelected;

    @DatabaseField
    private String nextTime;

    @DatabaseField
    private String notiType;

    @DatabaseField
    private String ownerEmail;

    @DatabaseField
    private String patternId;

    @DatabaseField
    private String receiveAlarmId;

    @DatabaseField
    private String reveiveFilePath;

    @DatabaseField
    private String ringTime;

    @DatabaseField
    private String sendTime;

    @DatabaseField
    private int snoozeCount;

    @DatabaseField
    private int snoozeDuration;

    @DatabaseField
    private String soundFileath;

    @DatabaseField
    private String soundurl;

    @DatabaseField
    private String time;

    @DatabaseField
    private int receiveFlag = 0;

    @DatabaseField
    private int notify = -1;

    @DatabaseField
    private int version = 1;

    public int getAccept() {
        return this.accept;
    }

    public String getAlarmTitle() {
        return this.alarmTitle;
    }

    public EntityAlarm getBean() {
        return this.bean;
    }

    public String getDates() {
        return this.dates;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String getFriendEmail() {
        String strF = nd3.f(this.friendEmail);
        return WearUtils.e1(strF) ? this.friendEmail : strF;
    }

    public int getHaveSnoozeCount() {
        return this.haveSnoozeCount;
    }

    public int getIsSelected() {
        return this.isSelected;
    }

    public String getNextTime() {
        return this.nextTime;
    }

    public String getNotiType() {
        return this.notiType;
    }

    public int getNotify() {
        return this.notify;
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

    public String getPatternId() {
        return this.patternId;
    }

    public String getReceiveAlarmId() {
        return this.receiveAlarmId;
    }

    public int getReceiveFlag() {
        return this.receiveFlag;
    }

    public String getReveiveFilePath() {
        return this.reveiveFilePath;
    }

    public String getRingTime() {
        return this.ringTime;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public int getSnoozeCount() {
        return this.snoozeCount;
    }

    public int getSnoozeDuration() {
        return this.snoozeDuration;
    }

    public String getSoundFileath() {
        return this.soundFileath;
    }

    public String getSoundurl() {
        return this.soundurl;
    }

    public String getTime() {
        return this.time;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAccept(int i) {
        this.accept = i;
    }

    public void setAlarmTitle(String str) {
        this.alarmTitle = str;
    }

    public void setBean(EntityAlarm entityAlarm) {
        this.bean = entityAlarm;
    }

    public void setDates(String str) {
        this.dates = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public void setFriendEmail(String str) {
        this.friendEmail = nd3.p(str);
    }

    public void setHaveSnoozeCount(int i) {
        this.haveSnoozeCount = i;
    }

    public void setIsSelected(int i) {
        this.isSelected = i;
    }

    public void setNextTime(String str) {
        this.nextTime = str;
    }

    public void setNotiType(String str) {
        this.notiType = str;
    }

    public void setNotify(int i) {
        this.notify = i;
    }

    public void setOwnerEmail(String str) {
        this.ownerEmail = nd3.p(str);
    }

    public void setPatternId(String str) {
        this.patternId = str;
    }

    public void setReceiveAlarmId(String str) {
        this.receiveAlarmId = str;
    }

    public void setReceiveFlag(int i) {
        this.receiveFlag = i;
    }

    public void setReveiveFilePath(String str) {
        this.reveiveFilePath = str;
    }

    public void setRingTime(String str) {
        this.ringTime = str;
    }

    public void setSendTime(String str) {
        this.sendTime = str;
    }

    public void setSnoozeCount(int i) {
        this.snoozeCount = i;
    }

    public void setSnoozeDuration(int i) {
        this.snoozeDuration = i;
    }

    public void setSoundFileath(String str) {
        this.soundFileath = str;
    }

    public void setSoundurl(String str) {
        this.soundurl = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
