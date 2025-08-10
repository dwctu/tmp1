package com.wear.bean.socketio.date.request;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class AppUserStatusBean extends DateBean {
    public static String onlineStatus = "status_available";
    public Object controlStatus;
    public Object dToken;
    public Object uid;
    public final Object platform = DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE;
    public final Object ver = WearUtils.q;
    public final Object time = Long.valueOf(System.currentTimeMillis());

    @Override // com.wear.bean.socketio.date.request.DateBean, com.wear.bean.socketio.BaseRequestBean, dc.pf2
    public String getAction() {
        return "AppUserStatusDTO";
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }
}
