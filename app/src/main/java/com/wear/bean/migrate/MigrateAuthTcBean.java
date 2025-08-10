package com.wear.bean.migrate;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;

/* loaded from: classes3.dex */
public class MigrateAuthTcBean {
    private int code;
    private int msgNums;
    private String platform;

    public MigrateAuthTcBean(int i, int i2, String str) {
        this.code = i;
        this.msgNums = i2;
        this.platform = str;
    }

    public int getCode() {
        return this.code;
    }

    public int getMsgNums() {
        return this.msgNums;
    }

    public int getPlatformInt() {
        return !DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE.equals(this.platform) ? 1 : 0;
    }
}
