package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfk {
    private final zzap zza;
    private final zzat zzb;

    public zzfk(zzap zzapVar) {
        this.zza = zzapVar;
        this.zzb = null;
    }

    public zzfk(zzat zzatVar) {
        this.zza = null;
        this.zzb = zzatVar;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzap zzapVar = this.zza;
        return zzapVar != null ? zzapVar.zza(bArr, bArr2) : this.zzb.zza(bArr, bArr2);
    }
}
