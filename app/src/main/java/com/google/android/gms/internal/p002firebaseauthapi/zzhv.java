package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhv {

    @Deprecated
    public static final zzod zza;

    @Deprecated
    public static final zzod zzb;

    @Deprecated
    public static final zzod zzc;

    static {
        new zzhu();
        zzod zzodVarZzb = zzod.zzb();
        zza = zzodVarZzb;
        zzb = zzodVarZzb;
        zzc = zzodVarZzb;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzbz.zzo(new zzia());
        zzbz.zzn(new zzhu(), true);
        if (zzdw.zzb()) {
            return;
        }
        zzbz.zzn(new zzhk(), true);
        zzhr.zza();
    }
}
