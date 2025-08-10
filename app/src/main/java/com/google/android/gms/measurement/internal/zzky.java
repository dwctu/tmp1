package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzky {
    public final String zza;
    public long zzb;

    private zzky(zzkz zzkzVar, String str) {
        this.zza = str;
        this.zzb = zzkzVar.zzav().elapsedRealtime();
    }
}
