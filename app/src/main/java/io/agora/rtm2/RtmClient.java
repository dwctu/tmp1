package io.agora.rtm2;

import androidx.annotation.NonNull;
import io.agora.rtm2.internal.RtmClientImpl;

/* loaded from: classes4.dex */
public abstract class RtmClient {
    private static RtmClient mInstance;

    public static synchronized RtmClient create() throws RuntimeException {
        if (!RtmClientImpl.initializeNativeLibs()) {
            return null;
        }
        if (mInstance == null) {
            mInstance = new RtmClientImpl();
        }
        return mInstance;
    }

    public static synchronized void release() {
        RtmClient rtmClient = mInstance;
        if (rtmClient == null) {
            return;
        }
        rtmClient.releaseClient();
        mInstance = null;
    }

    public abstract StreamChannel createStreamChannel(@NonNull String str);

    public abstract int initialize(RtmConfig rtmConfig);

    public abstract int releaseClient();
}
