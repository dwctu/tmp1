package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhj extends zzga {
    public zzhj(zzhk zzhkVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzis zzisVar = (zzis) zzadmVar;
        zzio zzioVarZzb = zzip.zzb();
        zzioVarZzb.zzc(0);
        zzioVarZzb.zza(zzabe.zzn(zzps.zza(zzisVar.zza())));
        zzioVarZzb.zzb(zzisVar.zze());
        return (zzip) zzioVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzis.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final Map zzc() throws GeneralSecurityException {
        HashMap map = new HashMap();
        zzir zzirVarZzb = zzis.zzb();
        zzirVarZzb.zza(32);
        zziu zziuVarZzb = zziv.zzb();
        zziuVarZzb.zza(16);
        zzirVarZzb.zzb((zziv) zziuVarZzb.zzk());
        map.put("AES_CMAC", new zzfz((zzis) zzirVarZzb.zzk(), 1));
        zzir zzirVarZzb2 = zzis.zzb();
        zzirVarZzb2.zza(32);
        zziu zziuVarZzb2 = zziv.zzb();
        zziuVarZzb2.zza(16);
        zzirVarZzb2.zzb((zziv) zziuVarZzb2.zzk());
        map.put("AES256_CMAC", new zzfz((zzis) zzirVarZzb2.zzk(), 1));
        zzir zzirVarZzb3 = zzis.zzb();
        zzirVarZzb3.zza(32);
        zziu zziuVarZzb3 = zziv.zzb();
        zziuVarZzb3.zza(16);
        zzirVarZzb3.zzb((zziv) zziuVarZzb3.zzk());
        map.put("AES256_CMAC_RAW", new zzfz((zzis) zzirVarZzb3.zzk(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ void zzd(zzadm zzadmVar) throws GeneralSecurityException {
        zzis zzisVar = (zzis) zzadmVar;
        zzhk.zzi(zzisVar.zze());
        zzhk.zzn(zzisVar.zza());
    }
}
