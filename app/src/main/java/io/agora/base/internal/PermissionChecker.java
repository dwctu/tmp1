package io.agora.base.internal;

import android.content.Context;

/* loaded from: classes4.dex */
public class PermissionChecker {
    public static boolean forceCheckPermissionFail = false;

    @CalledByNative
    public static boolean hasCameraPermission() {
        return hasPermission("android.permission.CAMERA");
    }

    @CalledByNative
    public static boolean hasChangeNetPermission() {
        return hasPermission("android.permission.CHANGE_NETWORK_STATE");
    }

    public static boolean hasPermission(String str) {
        Context applicationContext = ContextUtils.getApplicationContext();
        return (applicationContext == null || forceCheckPermissionFail || applicationContext.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    @CalledByNative
    public static boolean hasRecordAudioPermission() {
        return hasPermission("android.permission.RECORD_AUDIO");
    }

    public static void setForceCheckPermissionFail(boolean z) {
        forceCheckPermissionFail = z;
    }
}
