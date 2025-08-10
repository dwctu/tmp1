package io.agora.rtc2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class UserInfo {
    public int uid;
    public String userAccount;

    public UserInfo() {
    }

    public UserInfo(int i, String str) {
        this.uid = i;
        this.userAccount = str;
    }

    @CalledByNative
    public void SetUid(int i) {
        this.uid = i;
    }

    @CalledByNative
    public void SetUserAccount(String str) {
        this.userAccount = str;
    }
}
