package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfh implements zzey {
    private final zzpx zza;
    private final zzpx zzb;

    private zzfh(byte[] bArr, byte[] bArr2) {
        this.zza = zzpx.zzb(bArr);
        this.zzb = zzpx.zzb(bArr2);
    }

    public static zzfh zzc(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        zzoz.zze(zzoz.zzj(zzoz.zzk(i), 1, bArr2), zzoz.zzh(i, bArr));
        return new zzfh(bArr, bArr2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzey
    public final zzpx zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzey
    public final zzpx zzb() {
        return this.zzb;
    }
}
