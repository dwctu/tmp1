package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfg implements zzex {
    private final zzes zza;
    private final int zzb;

    private zzfg(zzes zzesVar, int i) {
        this.zza = zzesVar;
        this.zzb = i;
    }

    public static zzfg zzc(int i) throws GeneralSecurityException {
        int i2 = i - 1;
        return i2 != 0 ? i2 != 1 ? new zzfg(new zzes("HmacSha512"), 3) : new zzfg(new zzes("HmacSha384"), 2) : new zzfg(new zzes("HmacSha256"), 1);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzex
    public final byte[] zza(byte[] bArr, zzey zzeyVar) throws IllegalStateException, GeneralSecurityException {
        byte[] bArrZzg = zzoz.zzg(zzoz.zzh(this.zzb, zzeyVar.zza().zzc()), zzoz.zzj(zzoz.zzk(this.zzb), 1, bArr));
        byte[] bArrZzc = zzor.zzc(bArr, zzeyVar.zzb().zzc());
        byte[] bArrZzd = zzff.zzd(zzb());
        zzes zzesVar = this.zza;
        return zzesVar.zzb(null, bArrZzg, "eae_prk", bArrZzc, "shared_secret", bArrZzd, zzesVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzex
    public final byte[] zzb() throws GeneralSecurityException {
        int i = this.zzb - 1;
        return i != 0 ? i != 1 ? zzff.zze : zzff.zzd : zzff.zzc;
    }
}
