package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class UserJidBean {
    public List<UserTempJid> usertempjid;

    public static class UserTempJid {
        public String userJid;

        public String getUserJid() {
            return this.userJid;
        }

        public void setUserJid(String str) {
            this.userJid = str;
        }
    }

    public List<UserTempJid> getUsertempjid() {
        return this.usertempjid;
    }

    public void setUsertempjid(List<UserTempJid> list) {
        this.usertempjid = list;
    }
}
