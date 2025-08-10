package com.google.android.gms.internal.common;

import android.os.Build;
import io.agora.rtc2.internal.AudioRoutingController;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzd {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 23 ? AudioRoutingController.DEVICE_OUT_USB_HEADSET : 0;
    }
}
