package com.wear.bean.event;

/* loaded from: classes3.dex */
public class LoginOrOfflineEvent {
    private boolean isLogin;

    public LoginOrOfflineEvent() {
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public void setLogin(boolean z) {
        this.isLogin = z;
    }

    public LoginOrOfflineEvent(boolean z) {
        this.isLogin = z;
    }
}
