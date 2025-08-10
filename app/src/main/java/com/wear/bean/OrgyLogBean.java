package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tb_orgy_log")
/* loaded from: classes3.dex */
public class OrgyLogBean extends BaseEntity {

    @DatabaseField
    private String activityId;

    @DatabaseField
    private String campaignLink;

    @DatabaseField
    private String content;

    @DatabaseField
    private String eventId;

    @DatabaseField
    private String locationTime;

    @DatabaseField
    private String page;

    @DatabaseField
    private String position;

    @DatabaseField
    private String stage;

    @DatabaseField
    private String targetLink;

    @DatabaseField
    private String timestamp;

    @DatabaseField
    private String type;

    public String getActivityId() {
        return this.activityId;
    }

    public String getCampaignLink() {
        return this.campaignLink;
    }

    public String getContent() {
        return this.content;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getLocationTime() {
        return this.locationTime;
    }

    public String getPage() {
        return this.page;
    }

    public String getPosition() {
        return this.position;
    }

    public String getStage() {
        return this.stage;
    }

    public String getTargetLink() {
        return this.targetLink;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setCampaignLink(String str) {
        this.campaignLink = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setLocationTime(String str) {
        this.locationTime = str;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setStage(String str) {
        this.stage = str;
    }

    public void setTargetLink(String str) {
        this.targetLink = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
