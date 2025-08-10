package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcc {
    public static final String zza;
    public static final String zzb;

    @Deprecated
    public static final zzod zzc;

    @Deprecated
    public static final zzod zzd;

    @Deprecated
    public static final zzod zze;

    static {
        new zzcj();
        zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
        new zzcs();
        zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
        new zzcv();
        new zzcp();
        new zzdb();
        new zzdf();
        new zzcy();
        new zzdi();
        zzod zzodVarZzb = zzod.zzb();
        zzc = zzodVarZzb;
        zzd = zzodVarZzb;
        zze = zzodVarZzb;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzbz.zzo(new zzcg());
        zzhv.zza();
        zzbz.zzn(new zzcj(), true);
        zzbz.zzn(new zzcs(), true);
        if (zzdw.zzb()) {
            return;
        }
        zzbz.zzn(new zzcp(), true);
        zzcv.zzg(true);
        zzbz.zzn(new zzcy(), true);
        zzbz.zzn(new zzdb(), true);
        zzbz.zzn(new zzdf(), true);
        zzbz.zzn(new zzdi(), true);
    }
}
