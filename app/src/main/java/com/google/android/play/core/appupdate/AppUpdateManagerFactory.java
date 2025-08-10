package com.google.android.play.core.appupdate;

import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class AppUpdateManagerFactory {
    private AppUpdateManagerFactory() {
    }

    @NonNull
    public static AppUpdateManager create(@NonNull Context context) {
        return zza.zza(context).zza();
    }
}
