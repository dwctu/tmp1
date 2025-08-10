package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzfv {
    private final zzpx zza;
    private final Class zzb;

    public /* synthetic */ zzfv(zzpx zzpxVar, Class cls, zzfu zzfuVar) {
        this.zza = zzpxVar;
        this.zzb = cls;
    }

    public static zzfv zzb(zzft zzftVar, zzpx zzpxVar, Class cls) {
        return new zzfs(zzpxVar, cls, zzftVar);
    }

    public abstract zzaw zza(zzgx zzgxVar, zzca zzcaVar) throws GeneralSecurityException;

    public final zzpx zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
