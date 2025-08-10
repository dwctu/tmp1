package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcp extends zzgb {
    public zzcp() {
        super(zzjn.class, new zzcn(zzap.class));
    }

    public static /* bridge */ /* synthetic */ zzfz zzg(int i, int i2, int i3) {
        zzjp zzjpVarZzb = zzjq.zzb();
        zzjpVarZzb.zza(i);
        zzjs zzjsVarZzb = zzjt.zzb();
        zzjsVarZzb.zza(16);
        zzjpVarZzb.zzb((zzjt) zzjsVarZzb.zzk());
        return new zzfz((zzjq) zzjpVarZzb.zzk(), i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzco(this, zzjq.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzjn.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzjn zzjnVar = (zzjn) zzadmVar;
        zzpu.zzc(zzjnVar.zza(), 0);
        zzpu.zzb(zzjnVar.zzf().zzd());
        if (zzjnVar.zze().zza() != 12 && zzjnVar.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
