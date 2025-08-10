package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzco extends zzga {
    public final /* synthetic */ zzcp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzco(zzcp zzcpVar, Class cls) {
        super(cls);
        this.zza = zzcpVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzjq zzjqVar = (zzjq) zzadmVar;
        zzjm zzjmVarZzb = zzjn.zzb();
        zzjmVarZzb.zza(zzabe.zzn(zzps.zza(zzjqVar.zza())));
        zzjmVarZzb.zzb(zzjqVar.zze());
        zzjmVarZzb.zzc(0);
        return (zzjn) zzjmVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzjq.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzcp.zzg(16, 16, 1));
        map.put("AES128_EAX_RAW", zzcp.zzg(16, 16, 3));
        map.put("AES256_EAX", zzcp.zzg(32, 16, 1));
        map.put("AES256_EAX_RAW", zzcp.zzg(32, 16, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzjq zzjqVar = (zzjq) zzadmVar;
        zzpu.zzb(zzjqVar.zza());
        if (zzjqVar.zze().zza() != 12 && zzjqVar.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
