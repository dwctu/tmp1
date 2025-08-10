package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzez {
    public static zzet zza(zzmj zzmjVar) throws GeneralSecurityException {
        if (zzmjVar.zzd() == 3) {
            return new zzeq(16);
        }
        if (zzmjVar.zzd() == 4) {
            return new zzeq(32);
        }
        if (zzmjVar.zzd() == 5) {
            return new zzer();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzex zzb(zzmj zzmjVar) throws GeneralSecurityException {
        if (zzmjVar.zzf() == 3) {
            return new zzfi(new zzes("HmacSha256"));
        }
        if (zzmjVar.zzf() == 4) {
            return zzfg.zzc(1);
        }
        if (zzmjVar.zzf() == 5) {
            return zzfg.zzc(2);
        }
        if (zzmjVar.zzf() == 6) {
            return zzfg.zzc(3);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }

    public static zzes zzc(zzmj zzmjVar) {
        if (zzmjVar.zze() == 3) {
            return new zzes("HmacSha256");
        }
        if (zzmjVar.zze() == 4) {
            return new zzes("HmacSha384");
        }
        if (zzmjVar.zze() == 5) {
            return new zzes("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }
}
