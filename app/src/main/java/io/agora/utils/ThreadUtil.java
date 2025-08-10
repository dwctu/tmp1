package io.agora.utils;

import android.os.Looper;
import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class ThreadUtil {
    private ThreadUtil() {
        throw new IllegalStateException("Utility class");
    }

    @CalledByNative
    public static boolean isOnMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
