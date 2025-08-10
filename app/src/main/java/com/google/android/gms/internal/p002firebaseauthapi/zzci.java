package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzci extends zzga {
    public final /* synthetic */ zzcj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzci(zzcj zzcjVar, Class cls) {
        super(cls);
        this.zza = zzcjVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzjb zzjbVar = (zzjb) zzadmVar;
        new zzcm();
        zzje zzjeVarZzf = zzcl.zzf(zzjbVar.zzd());
        zzadm zzadmVarZza = new zzhu().zza().zza(zzjbVar.zze());
        zzix zzixVarZzb = zziy.zzb();
        zzixVarZzb.zza(zzjeVarZzf);
        zzixVarZzb.zzb((zzlv) zzadmVarZza);
        zzixVarZzb.zzc(0);
        return (zziy) zzixVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzjb.zzc(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzcj.zzg(16, 16, 32, 16, 5, 1));
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzcj.zzg(16, 16, 32, 16, 5, 3));
        map.put("AES256_CTR_HMAC_SHA256", zzcj.zzg(32, 16, 32, 32, 5, 1));
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzcj.zzg(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzjb zzjbVar = (zzjb) zzadmVar;
        ((zzcl) new zzcm().zza()).zzd(zzjbVar.zzd());
        new zzhu().zza().zzd(zzjbVar.zze());
        zzpu.zzb(zzjbVar.zzd().zza());
    }
}
