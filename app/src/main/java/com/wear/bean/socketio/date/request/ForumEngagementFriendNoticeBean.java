package com.wear.bean.socketio.date.request;

/* loaded from: classes3.dex */
public class ForumEngagementFriendNoticeBean extends DateBean {
    public Object datingId;
    public Object receiverIsAgree;

    @Override // com.wear.bean.socketio.date.request.DateBean, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "ForumEngagementFriendNoticeDTO";
    }
}
