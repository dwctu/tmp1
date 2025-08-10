package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzht extends zzga {
    public final /* synthetic */ zzhu zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzht(zzhu zzhuVar, Class cls) {
        super(cls);
        this.zza = zzhuVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzly zzlyVar = (zzly) zzadmVar;
        zzlu zzluVarZzb = zzlv.zzb();
        zzluVarZzb.zzc(0);
        zzluVarZzb.zzb(zzlyVar.zzf());
        zzluVarZzb.zza(zzabe.zzn(zzps.zza(zzlyVar.zza())));
        return (zzlv) zzluVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzly.zze(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzhu.zzi(32, 16, 5, 1));
        map.put("HMAC_SHA256_128BITTAG_RAW", zzhu.zzi(32, 16, 5, 3));
        map.put("HMAC_SHA256_256BITTAG", zzhu.zzi(32, 32, 5, 1));
        map.put("HMAC_SHA256_256BITTAG_RAW", zzhu.zzi(32, 32, 5, 3));
        map.put("HMAC_SHA512_128BITTAG", zzhu.zzi(64, 16, 6, 1));
        map.put("HMAC_SHA512_128BITTAG_RAW", zzhu.zzi(64, 16, 6, 3));
        map.put("HMAC_SHA512_256BITTAG", zzhu.zzi(64, 32, 6, 1));
        map.put("HMAC_SHA512_256BITTAG_RAW", zzhu.zzi(64, 32, 6, 3));
        map.put("HMAC_SHA512_512BITTAG", zzhu.zzi(64, 64, 6, 1));
        map.put("HMAC_SHA512_512BITTAG_RAW", zzhu.zzi(64, 64, 6, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzly zzlyVar = (zzly) zzadmVar;
        if (zzlyVar.zza() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzhu.zzn(zzlyVar.zzf());
    }
}
