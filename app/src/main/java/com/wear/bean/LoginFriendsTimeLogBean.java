package com.wear.bean;

import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.ye3;

/* loaded from: classes3.dex */
public class LoginFriendsTimeLogBean {
    private Boolean autoLogin;
    private String netType;
    private Long request_id;
    private Times times;

    public class Times {
        private long fetchRoster;
        private transient long fetchRosterTimeStar;
        private long friendVcard;
        private transient long friendVcardTimeStar;
        private long groupList;
        private transient long groupListTimeStar;
        private long groupMember;
        private transient long groupMemberTimeStar;
        private long total;

        public Times() {
        }
    }

    private Times getTimes() {
        if (this.times == null) {
            this.times = new Times();
        }
        return this.times;
    }

    private void logL0005() {
        if (!MyApplication.O || this.times.fetchRoster == 0 || this.times.friendVcard == 0 || this.times.groupList == 0 || this.times.groupMember == 0) {
            return;
        }
        Times times = this.times;
        times.total = times.fetchRoster + this.times.friendVcard + this.times.groupList + this.times.groupMember;
        this.netType = ye3.w();
        ye3.Q("L0005", nd3.s(WearUtils.A.toJson(this)));
        clear();
    }

    public void clear() {
        this.request_id = null;
        this.times = null;
        this.netType = null;
    }

    public void setAutoLogin(Boolean bool) {
        this.autoLogin = bool;
    }

    public void setFetchRosterTimeEnd(long j) {
        if (getTimes().fetchRosterTimeStar > 0) {
            getTimes().fetchRoster = j - getTimes().fetchRosterTimeStar;
            logL0005();
        }
    }

    public void setFetchRosterTimeStar(long j) {
        getTimes().fetchRosterTimeStar = j;
    }

    public void setFriendVcardTimeEnd(long j) {
        if (getTimes().friendVcardTimeStar > 0) {
            getTimes().friendVcard = j - getTimes().friendVcardTimeStar;
            logL0005();
        }
    }

    public void setFriendVcardTimeStar(long j) {
        getTimes().friendVcardTimeStar = j;
    }

    public void setGroupListTimeEnd(long j) {
        if (getTimes().groupListTimeStar > 0) {
            getTimes().groupList = j - getTimes().groupListTimeStar;
            logL0005();
        }
    }

    public void setGroupListTimeStar(long j) {
        getTimes().groupListTimeStar = j;
    }

    public void setGroupMemberTimeEnd(long j) {
        if (getTimes().groupMemberTimeStar > 0) {
            getTimes().groupMember = j - getTimes().groupMemberTimeStar;
            logL0005();
        }
    }

    public void setGroupMemberTimeStar(long j) {
        getTimes().groupMemberTimeStar = j;
    }

    public void setRequest_id(Long l) {
        this.request_id = l;
    }
}
