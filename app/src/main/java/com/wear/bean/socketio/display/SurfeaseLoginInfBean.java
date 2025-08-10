package com.wear.bean.socketio.display;

import dc.pf2;

/* loaded from: classes3.dex */
public class SurfeaseLoginInfBean implements pf2 {
    private String deviceId;
    private UserInfo userInfo;

    public static class UserInfo {
        private String avatar;
        private String nickName;
        private String remark;

        public String getAvatar() {
            return this.avatar;
        }

        public String getNickName() {
            return this.nickName;
        }

        public String getRemark() {
            return this.remark;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setNickName(String str) {
            this.nickName = str;
        }

        public void setRemark(String str) {
            this.remark = str;
        }
    }

    @Override // dc.pf2
    public String getAction() {
        return "SurfeaseLoginInfoDTO";
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
