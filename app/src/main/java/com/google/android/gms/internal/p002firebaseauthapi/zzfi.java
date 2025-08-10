package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfi implements zzex {
    private final zzes zza;

    public zzfi(zzes zzesVar) {
        this.zza = zzesVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzex
    public final byte[] zza(byte[] bArr, zzey zzeyVar) throws GeneralSecurityException {
        byte[] bArrZza = zzpv.zza(zzeyVar.zza().zzc(), bArr);
        byte[] bArrZzc = zzor.zzc(bArr, zzeyVar.zzb().zzc());
        byte[] bArrZzd = zzff.zzd(zzff.zzb);
        zzes zzesVar = this.zza;
        return zzesVar.zzb(null, bArrZza, "eae_prk", bArrZzc, "shared_secret", bArrZzd, zzesVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzex
    public final byte[] zzb() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzc(), zzff.zzf)) {
            return zzff.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
