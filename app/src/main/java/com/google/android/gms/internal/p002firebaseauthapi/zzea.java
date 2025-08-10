package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzea {
    public static final String zza;

    @Deprecated
    public static final zzod zzb;

    @Deprecated
    public static final zzod zzc;

    static {
        new zzdz();
        zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
        zzb = zzod.zzb();
        zzc = zzod.zzb();
        try {
            zzbz.zzo(new zzec());
            if (zzdw.zzb()) {
                return;
            }
            zzbz.zzn(new zzdz(), true);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
