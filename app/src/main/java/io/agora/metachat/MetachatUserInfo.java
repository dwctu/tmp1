package io.agora.metachat;

import io.agora.base.internal.CalledByNative;
import java.util.Arrays;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class MetachatUserInfo {
    public byte[] mExtraCustomInfo;
    public String mUserIconUrl;
    public String mUserId;
    public String mUserName;

    public MetachatUserInfo() {
        this.mUserId = "";
        this.mUserName = "";
        this.mUserIconUrl = "";
        this.mExtraCustomInfo = null;
    }

    @CalledByNative
    public MetachatUserInfo(String str, String str2, String str3, byte[] bArr) {
        this.mUserId = str;
        this.mUserName = str2;
        this.mUserIconUrl = str3;
        this.mExtraCustomInfo = bArr;
    }

    @CalledByNative
    public byte[] getExtraCustomInfo() {
        return this.mExtraCustomInfo;
    }

    @CalledByNative
    public String getUserIconUrl() {
        return this.mUserIconUrl;
    }

    @CalledByNative
    public String getUserId() {
        return this.mUserId;
    }

    @CalledByNative
    public String getUserName() {
        return this.mUserName;
    }

    public String toString() {
        return "MetachatUserInfo{mUserId='" + this.mUserId + "', mUserName='" + this.mUserName + "', mUserIconUrl='" + this.mUserIconUrl + "', mExtraCustomInfo=" + Arrays.toString(this.mExtraCustomInfo) + MessageFormatter.DELIM_STOP;
    }
}
