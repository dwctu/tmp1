package com.wear.bean.socketio.date.response;

/* loaded from: classes3.dex */
public class ForumEngagementCheckNoticeDTOBean implements UserInfoDao {
    public String datingId;
    public String receiver;
    public String receiverName;
    public boolean status;

    @Override // com.wear.bean.socketio.date.response.UserInfoDao
    public String getDatingId() {
        return this.datingId;
    }

    @Override // com.wear.bean.socketio.date.response.UserInfoDao
    public String getFriendId() {
        return this.receiver;
    }

    @Override // com.wear.bean.socketio.date.response.UserInfoDao
    public String getFriendName() {
        return this.receiverName;
    }
}
