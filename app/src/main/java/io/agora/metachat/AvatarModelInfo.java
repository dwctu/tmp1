package io.agora.metachat;

import io.agora.base.internal.CalledByNative;
import java.util.Arrays;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class AvatarModelInfo {
    public String mBundleCode;
    public byte[] mExtraCustomInfo;
    public boolean mLocalVisible;
    public boolean mRemoteVisible;
    public boolean mSyncPosition;

    public AvatarModelInfo() {
        this.mBundleCode = "";
        this.mLocalVisible = false;
        this.mRemoteVisible = false;
        this.mSyncPosition = false;
        this.mExtraCustomInfo = null;
    }

    @CalledByNative
    public AvatarModelInfo(String str, boolean z, boolean z2, boolean z3, byte[] bArr) {
        this.mBundleCode = str;
        this.mLocalVisible = z;
        this.mRemoteVisible = z2;
        this.mSyncPosition = z3;
        this.mExtraCustomInfo = bArr;
    }

    @CalledByNative
    public String getBundleCode() {
        return this.mBundleCode;
    }

    @CalledByNative
    public byte[] getExtraCustomInfo() {
        return this.mExtraCustomInfo;
    }

    @CalledByNative
    public boolean getLocalVisible() {
        return this.mLocalVisible;
    }

    @CalledByNative
    public boolean getRemoteVisible() {
        return this.mRemoteVisible;
    }

    @CalledByNative
    public boolean getSyncPosition() {
        return this.mSyncPosition;
    }

    public String toString() {
        return "AvatarModelInfo{mBundleCode='" + this.mBundleCode + "', mLocalVisible=" + this.mLocalVisible + ", mRemoteVisible=" + this.mRemoteVisible + ", mSyncPosition=" + this.mSyncPosition + ", mExtraCustomInfo=" + Arrays.toString(this.mExtraCustomInfo) + MessageFormatter.DELIM_STOP;
    }
}
