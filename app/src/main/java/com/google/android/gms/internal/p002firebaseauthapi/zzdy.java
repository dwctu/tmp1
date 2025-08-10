package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzdy extends zzga {
    public final /* synthetic */ zzdz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdy(zzdz zzdzVar, Class cls) {
        super(cls);
        this.zza = zzdzVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzkh zzkhVarZzb = zzki.zzb();
        zzkhVarZzb.zza(zzabe.zzn(zzps.zza(((zzkl) zzadmVar).zza())));
        zzkhVarZzb.zzb(0);
        return (zzki) zzkhVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzkl.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        zzkk zzkkVarZzb = zzkl.zzb();
        zzkkVarZzb.zza(64);
        map.put("AES256_SIV", new zzfz((zzkl) zzkkVarZzb.zzk(), 1));
        zzkk zzkkVarZzb2 = zzkl.zzb();
        zzkkVarZzb2.zza(64);
        map.put("AES256_SIV_RAW", new zzfz((zzkl) zzkkVarZzb2.zzk(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzkl zzklVar = (zzkl) zzadmVar;
        if (zzklVar.zza() == 64) {
            return;
        }
        throw new InvalidAlgorithmParameterException("invalid key size: " + zzklVar.zza() + ". Valid keys must have 64 bytes.");
    }
}
