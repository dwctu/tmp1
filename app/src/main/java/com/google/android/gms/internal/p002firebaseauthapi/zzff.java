package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzff {
    public static final byte[] zza = zzc(1, 0);
    public static final byte[] zzb = zzc(2, 32);
    public static final byte[] zzc = zzc(2, 16);
    public static final byte[] zzd = zzc(2, 17);
    public static final byte[] zze = zzc(2, 18);
    public static final byte[] zzf = zzc(2, 1);
    public static final byte[] zzg = zzc(2, 2);
    public static final byte[] zzh = zzc(2, 3);
    public static final byte[] zzi = zzc(2, 1);
    public static final byte[] zzj = zzc(2, 2);
    public static final byte[] zzk = zzc(2, 3);
    public static final byte[] zzl = new byte[0];
    private static final byte[] zzm = "KEM".getBytes(StandardCharsets.UTF_8);
    private static final byte[] zzn = "HPKE".getBytes(StandardCharsets.UTF_8);
    private static final byte[] zzo = "HPKE-v1".getBytes(StandardCharsets.UTF_8);

    public static void zza(zzmj zzmjVar) throws GeneralSecurityException {
        if (zzmjVar.zzf() == 2 || zzmjVar.zzf() == 1) {
            throw new GeneralSecurityException("Invalid KEM param: ".concat(zzmd.zza(zzmjVar.zzf())));
        }
        String str = "UNRECOGNIZED";
        if (zzmjVar.zze() == 2 || zzmjVar.zze() == 1) {
            int iZze = zzmjVar.zze();
            if (iZze == 2) {
                str = "KDF_UNKNOWN";
            } else if (iZze == 3) {
                str = "HKDF_SHA256";
            } else if (iZze == 4) {
                str = "HKDF_SHA384";
            } else if (iZze == 5) {
                str = "HKDF_SHA512";
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(str));
        }
        if (zzmjVar.zzd() == 2 || zzmjVar.zzd() == 1) {
            int iZzd = zzmjVar.zzd();
            if (iZzd == 2) {
                str = "AEAD_UNKNOWN";
            } else if (iZzd == 3) {
                str = "AES_128_GCM";
            } else if (iZzd == 4) {
                str = "AES_256_GCM";
            } else if (iZzd == 5) {
                str = "CHACHA20_POLY1305";
            }
            throw new GeneralSecurityException("Invalid AEAD param: ".concat(str));
        }
    }

    public static byte[] zzb(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zzor.zzc(zzn, bArr, bArr2, bArr3);
    }

    public static byte[] zzc(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] zzd(byte[] bArr) throws GeneralSecurityException {
        return zzor.zzc(zzm, bArr);
    }

    public static byte[] zze(String str, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzor.zzc(zzo, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }

    public static byte[] zzf(String str, byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        return zzor.zzc(zzc(2, i), zzo, bArr2, str.getBytes(StandardCharsets.UTF_8), bArr);
    }
}
