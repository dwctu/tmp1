package io.agora.metachat;

import io.agora.base.internal.CalledByNative;
import io.agora.rtc2.RtcEngine;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class MetachatConfig {
    public RtcEngine mRtcEngine = null;
    public String mAppId = "";
    public String mRtmToken = "";
    public String mLocalDownloadPath = "";
    public String mUserId = "";
    public IMetachatEventHandler mEventHandler = null;

    @CalledByNative
    public String getAppId() {
        return this.mAppId;
    }

    @CalledByNative
    public IMetachatEventHandler getEventHandler() {
        return this.mEventHandler;
    }

    @CalledByNative
    public String getLocalDownloadPath() {
        return this.mLocalDownloadPath;
    }

    @CalledByNative
    public String getRtmToken() {
        return this.mRtmToken;
    }

    @CalledByNative
    public String getUserId() {
        return this.mUserId;
    }

    public String toString() {
        return "MetachatConfig{mRtcEngine=" + this.mRtcEngine + ", mAppId='" + this.mAppId + "', mRtmToken='" + this.mRtmToken + "', mLocalDownloadPath='" + this.mLocalDownloadPath + "', mUserId='" + this.mUserId + "', mEventHandler=" + this.mEventHandler + MessageFormatter.DELIM_STOP;
    }
}
