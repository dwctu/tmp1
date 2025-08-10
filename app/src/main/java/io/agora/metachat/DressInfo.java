package io.agora.metachat;

import io.agora.base.internal.CalledByNative;
import java.util.Arrays;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class DressInfo {
    public byte[] mExtraCustomInfo;

    public DressInfo() {
        this.mExtraCustomInfo = null;
    }

    @CalledByNative
    public DressInfo(byte[] bArr) {
        this.mExtraCustomInfo = bArr;
    }

    @CalledByNative
    public byte[] getExtraCustomInfo() {
        return this.mExtraCustomInfo;
    }

    public String toString() {
        return "DressInfo{mExtraCustomInfo=" + Arrays.toString(this.mExtraCustomInfo) + MessageFormatter.DELIM_STOP;
    }
}
