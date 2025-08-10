package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcr extends zzga {
    public final /* synthetic */ zzcs zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcr(zzcs zzcsVar, Class cls) {
        super(cls);
        this.zza = zzcsVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzjv zzjvVarZzb = zzjw.zzb();
        zzjvVarZzb.zza(zzabe.zzn(zzps.zza(((zzjz) zzadmVar).zza())));
        zzjvVarZzb.zzb(0);
        return (zzjw) zzjvVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzjz.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzcs.zzg(16, 1));
        map.put("AES128_GCM_RAW", zzcs.zzg(16, 3));
        map.put("AES256_GCM", zzcs.zzg(32, 1));
        map.put("AES256_GCM_RAW", zzcs.zzg(32, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzpu.zzb(((zzjz) zzadmVar).zza());
    }
}
