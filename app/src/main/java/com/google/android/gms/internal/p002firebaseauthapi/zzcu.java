package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcu extends zzga {
    public final /* synthetic */ zzcv zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcu(zzcv zzcvVar, Class cls) {
        super(cls);
        this.zza = zzcvVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzkb zzkbVarZzb = zzkc.zzb();
        zzkbVarZzb.zza(zzabe.zzn(zzps.zza(((zzkf) zzadmVar).zza())));
        zzkbVarZzb.zzb(0);
        return (zzkc) zzkbVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzkf.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_GCM_SIV", zzcv.zzh(16, 1));
        map.put("AES128_GCM_SIV_RAW", zzcv.zzh(16, 3));
        map.put("AES256_GCM_SIV", zzcv.zzh(32, 1));
        map.put("AES256_GCM_SIV_RAW", zzcv.zzh(32, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzpu.zzb(((zzkf) zzadmVar).zza());
    }
}
