package com.google.android.gms.internal.p002firebaseauthapi;

import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaex extends zzaey {
    public zzaex(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.firebase-auth-api.zzaez.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.firebase-auth-api.zzaez.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.firebase-auth-api.zzaez.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.firebase-auth-api.zzaez.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final void zzc(Object obj, long j, boolean z) {
        if (zzaez.zzb) {
            zzaez.zzi(obj, j, z);
        } else {
            zzaez.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final void zzd(Object obj, long j, byte b) {
        if (zzaez.zzb) {
            zzaez.zzD(obj, j, b);
        } else {
            zzaez.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final void zzf(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaey
    public final boolean zzg(Object obj, long j) {
        return zzaez.zzb ? zzaez.zzt(obj, j) : zzaez.zzu(obj, j);
    }
}
