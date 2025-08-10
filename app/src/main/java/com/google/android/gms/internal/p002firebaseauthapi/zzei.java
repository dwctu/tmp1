package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzei {

    @Deprecated
    public static final zzod zza;

    @Deprecated
    public static final zzod zzb;

    @Deprecated
    public static final zzod zzc;

    static {
        new zzeh();
        new zzef();
        zza = zzod.zzb();
        zzb = zzod.zzb();
        zzc = zzod.zzb();
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzbz.zzo(new zzek());
        zzbz.zzo(new zzem());
        zzcc.zza();
        if (zzdw.zzb()) {
            return;
        }
        zzbz.zzm(new zzef(), new zzeh(), true);
        zzbz.zzm(new zzfc(), new zzfe(), true);
    }
}
