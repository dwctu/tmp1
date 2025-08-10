package com.epicgames.unreal;

/* loaded from: classes.dex */
public class NativeCalls {
    public static native void AllowJavaBackButtonEvent(boolean z);

    public static native void AllowSleep(String str);

    public static native void CallNativeToEmbedded(String str, int i, String str2, String str3, String[] strArr, String str4);

    public static native void ForwardNotification(String str);

    public static native void HandleCustomTouchEvent(int i, int i2, int i3, int i4, float f, float f2);

    public static native void KeepAwake(String str, boolean z);

    public static native void RouteServiceIntent(String str, String str2);

    public static native void SetNamedObject(String str, Object obj);

    public static native void UELogError(String str);

    public static native void UELogLog(String str);

    public static native void UELogVerbose(String str);

    public static native void UELogWarning(String str);

    public static native void WebViewVisible(boolean z);
}
