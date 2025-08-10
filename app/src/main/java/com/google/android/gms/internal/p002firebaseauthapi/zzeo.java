package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzeo {
    public static void zza(zzlc zzlcVar) throws GeneralSecurityException {
        zzoz.zzk(zzc(zzlcVar.zze().zzf()));
        zzb(zzlcVar.zze().zzg());
        if (zzlcVar.zzh() == 2) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzbz.zzc(zzlcVar.zza().zzd());
    }

    public static String zzb(int i) throws NoSuchAlgorithmException {
        int i2 = i - 2;
        if (i2 == 1) {
            return "HmacSha1";
        }
        if (i2 == 2) {
            return "HmacSha384";
        }
        if (i2 == 3) {
            return "HmacSha256";
        }
        if (i2 == 4) {
            return "HmacSha512";
        }
        if (i2 == 5) {
            return "HmacSha224";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(Integer.toString(zzls.zza(i))));
    }

    public static int zzc(int i) throws GeneralSecurityException {
        int i2 = i - 2;
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        throw new GeneralSecurityException("unknown curve type: ".concat(Integer.toString(zzln.zza(i))));
    }

    public static int zzd(int i) throws GeneralSecurityException {
        int i2 = i - 2;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                if (i2 == 3) {
                    return 3;
                }
                throw new GeneralSecurityException("unknown point format: ".concat(Integer.toString(zzkt.zza(i))));
            }
        }
        return i3;
    }
}
