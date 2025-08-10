package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzgf extends zzaw {
    private final zzgv zza;

    public zzgf(zzgv zzgvVar, zzca zzcaVar) throws GeneralSecurityException {
        int i = zzgc.zzb[zzgvVar.zzb().ordinal()];
        this.zza = zzgvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaw
    public final zzbn zza() {
        zzgv zzgvVar = this.zza;
        return new zzge(zzgvVar.zzg(), zzgvVar.zzc(), null);
    }
}
