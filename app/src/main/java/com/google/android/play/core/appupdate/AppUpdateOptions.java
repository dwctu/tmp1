package com.google.android.play.core.appupdate;

import androidx.annotation.NonNull;
import com.google.android.play.core.install.model.AppUpdateType;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public abstract class AppUpdateOptions {

    /* compiled from: com.google.android.play:core@@1.10.3 */
    public static abstract class Builder {
        @NonNull
        public abstract AppUpdateOptions build();

        @NonNull
        public abstract Builder setAllowAssetPackDeletion(boolean z);

        @NonNull
        public abstract Builder setAppUpdateType(@AppUpdateType int i);
    }

    @NonNull
    public static AppUpdateOptions defaultOptions(@AppUpdateType int i) {
        return newBuilder(i).build();
    }

    @NonNull
    public static Builder newBuilder(@AppUpdateType int i) {
        zzu zzuVar = new zzu();
        zzuVar.setAppUpdateType(i);
        zzuVar.setAllowAssetPackDeletion(false);
        return zzuVar;
    }

    public abstract boolean allowAssetPackDeletion();

    @AppUpdateType
    public abstract int appUpdateType();
}
