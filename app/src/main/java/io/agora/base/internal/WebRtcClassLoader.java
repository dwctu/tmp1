package io.agora.base.internal;

import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class WebRtcClassLoader {
    @Nullable
    @CalledByNative
    public static Object getClassLoader() {
        return WebRtcClassLoader.class.getClassLoader();
    }
}
