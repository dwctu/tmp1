package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhe {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public /* synthetic */ zzhe(zzgy zzgyVar, zzhd zzhdVar) {
        this.zza = new HashMap(zzgyVar.zza);
        this.zzb = new HashMap(zzgyVar.zzb);
        this.zzc = new HashMap(zzgyVar.zzc);
        this.zzd = new HashMap(zzgyVar.zzd);
    }

    public final zzaw zza(zzgx zzgxVar, zzca zzcaVar) throws GeneralSecurityException {
        zzha zzhaVar = new zzha(zzgxVar.getClass(), zzgxVar.zzd(), null);
        if (this.zzb.containsKey(zzhaVar)) {
            return ((zzfv) this.zzb.get(zzhaVar)).zza(zzgxVar, zzcaVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + zzhaVar.toString() + " available");
    }
}
