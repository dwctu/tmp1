package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcy extends zzgb {
    public zzcy() {
        super(zzko.class, new zzcw(zzap.class));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzcx(this, zzkr.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzko.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzko zzkoVar = (zzko) zzadmVar;
        zzpu.zzc(zzkoVar.zza(), 0);
        if (zzkoVar.zze().zzd() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
