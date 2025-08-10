package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbq {
    private final Object zza;
    private final byte[] zzb;
    private final zzoa zzc;
    private final int zzd;
    private final zzaw zze;
    private final int zzf;

    public zzbq(Object obj, byte[] bArr, int i, zzoa zzoaVar, int i2, zzaw zzawVar) {
        this.zza = obj;
        this.zzb = Arrays.copyOf(bArr, bArr.length);
        this.zzf = i;
        this.zzc = zzoaVar;
        this.zzd = i2;
        this.zze = zzawVar;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzaw zzb() {
        return this.zze;
    }

    public final zzbn zzc() {
        return this.zze.zza();
    }

    public final zzoa zzd() {
        return this.zzc;
    }

    public final Object zze() {
        return this.zza;
    }

    public final byte[] zzf() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzg() {
        return this.zzf;
    }
}
