package io.agora.rtc2;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IMediaExtensionObserver {
    @CalledByNative
    void onError(String str, String str2, int i, String str3);

    @CalledByNative
    void onEvent(String str, String str2, String str3, String str4);

    @CalledByNative
    void onStarted(String str, String str2);

    @CalledByNative
    void onStopped(String str, String str2);
}
