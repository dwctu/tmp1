package com.wear.bean.socketio.date.response;

/* loaded from: classes3.dex */
public class ForumEngagementNoticeBean implements UserInfoDao {
    private String datingId;
    private String sponsor;
    private String sponsorName;
    private long time;
    private String toyJson;

    @Override // com.wear.bean.socketio.date.response.UserInfoDao
    public String getDatingId() {
        return this.datingId;
    }

    @Override // com.wear.bean.socketio.date.response.UserInfoDao
    public String getFriendId() {
        return getSponsor();
    }

    @Override // com.wear.bean.socketio.date.response.UserInfoDao
    public String getFriendName() {
        return getSponsorName();
    }

    public String getSponsor() {
        return this.sponsor;
    }

    public String getSponsorName() {
        return this.sponsorName;
    }

    public long getTime() {
        return this.time;
    }

    public String getToyJson() {
        return this.toyJson;
    }

    public void setDatingId(String str) {
        this.datingId = str;
    }

    public void setSponsor(String str) {
        this.sponsor = str;
    }

    public void setSponsorName(String str) {
        this.sponsorName = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setToyJson(String str) {
        this.toyJson = str;
    }
}
