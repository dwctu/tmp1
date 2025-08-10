package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzwf {

    @Nullable
    private String zza;

    @Nullable
    private String zzb;

    private zzwf() {
    }

    public static zzwf zza(String str) {
        zzwf zzwfVar = new zzwf();
        zzwfVar.zza = str;
        return zzwfVar;
    }

    public static zzwf zzb(String str) {
        zzwf zzwfVar = new zzwf();
        zzwfVar.zzb = str;
        return zzwfVar;
    }

    @Nullable
    public final String zzc() {
        return this.zza;
    }

    @Nullable
    public final String zzd() {
        return this.zzb;
    }
}
