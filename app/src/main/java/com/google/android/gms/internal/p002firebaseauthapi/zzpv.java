package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzpv {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 32);
        bArrCopyOf[0] = (byte) (bArrCopyOf[0] & 248);
        int i = bArrCopyOf[31] & Byte.MAX_VALUE;
        bArrCopyOf[31] = (byte) i;
        bArrCopyOf[31] = (byte) (i | 64);
        int i2 = zzot.zzb;
        if (bArr2.length != 32) {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr2, 32);
        bArrCopyOf2[31] = (byte) (bArrCopyOf2[31] & Byte.MAX_VALUE);
        for (int i3 = 0; i3 < 7; i3++) {
            byte[][] bArr3 = zzot.zza;
            if (zzor.zzb(bArr3[i3], bArrCopyOf2)) {
                throw new InvalidKeyException("Banned public key: ".concat(zzpl.zza(bArr3[i3])));
            }
        }
        long[] jArrZzk = zzpk.zzk(bArrCopyOf2);
        long[] jArr2 = new long[19];
        long[] jArr3 = new long[19];
        jArr3[0] = 1;
        long[] jArr4 = new long[19];
        jArr4[0] = 1;
        long[] jArr5 = new long[19];
        long[] jArr6 = new long[19];
        long[] jArr7 = new long[19];
        jArr7[0] = 1;
        long[] jArr8 = new long[19];
        long[] jArr9 = new long[19];
        jArr9[0] = 1;
        System.arraycopy(jArrZzk, 0, jArr2, 0, 10);
        int i4 = 0;
        for (int i5 = 32; i4 < i5; i5 = 32) {
            int i6 = bArrCopyOf[(32 - i4) - 1] & 255;
            int i7 = 0;
            while (i7 < 8) {
                int i8 = (i6 >> (7 - i7)) & 1;
                zzot.zza(jArr4, jArr2, i8);
                zzot.zza(jArr5, jArr3, i8);
                byte[] bArr4 = bArrCopyOf;
                long[] jArrCopyOf = Arrays.copyOf(jArr4, 10);
                int i9 = i6;
                long[] jArr10 = new long[19];
                long[] jArr11 = jArr;
                long[] jArr12 = new long[19];
                int i10 = i4;
                long[] jArr13 = new long[19];
                int i11 = i7;
                long[] jArr14 = new long[19];
                long[] jArr15 = new long[19];
                long[] jArr16 = jArr9;
                long[] jArr17 = new long[19];
                long[] jArr18 = new long[19];
                zzpk.zzi(jArr4, jArr4, jArr5);
                zzpk.zzh(jArr5, jArrCopyOf, jArr5);
                long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
                zzpk.zzi(jArr2, jArr2, jArr3);
                zzpk.zzh(jArr3, jArrCopyOf2, jArr3);
                zzpk.zzb(jArr14, jArr2, jArr5);
                zzpk.zzb(jArr15, jArr4, jArr3);
                zzpk.zze(jArr14);
                zzpk.zzd(jArr14);
                zzpk.zze(jArr15);
                zzpk.zzd(jArr15);
                long[] jArr19 = jArr2;
                System.arraycopy(jArr14, 0, jArrCopyOf2, 0, 10);
                zzpk.zzi(jArr14, jArr14, jArr15);
                zzpk.zzh(jArr15, jArrCopyOf2, jArr15);
                zzpk.zzg(jArr18, jArr14);
                zzpk.zzg(jArr17, jArr15);
                zzpk.zzb(jArr15, jArr17, jArrZzk);
                zzpk.zze(jArr15);
                zzpk.zzd(jArr15);
                System.arraycopy(jArr18, 0, jArr6, 0, 10);
                System.arraycopy(jArr15, 0, jArr7, 0, 10);
                zzpk.zzg(jArr12, jArr4);
                zzpk.zzg(jArr13, jArr5);
                zzpk.zzb(jArr8, jArr12, jArr13);
                zzpk.zze(jArr8);
                zzpk.zzd(jArr8);
                zzpk.zzh(jArr13, jArr12, jArr13);
                Arrays.fill(jArr10, 10, 18, 0L);
                zzpk.zzf(jArr10, jArr13, 121665L);
                zzpk.zzd(jArr10);
                zzpk.zzi(jArr10, jArr10, jArr12);
                zzpk.zzb(jArr16, jArr13, jArr10);
                zzpk.zze(jArr16);
                zzpk.zzd(jArr16);
                zzot.zza(jArr8, jArr6, i8);
                zzot.zza(jArr16, jArr7, i8);
                i7 = i11 + 1;
                jArr9 = jArr5;
                jArr2 = jArr6;
                i6 = i9;
                jArr = jArr11;
                i4 = i10;
                jArr6 = jArr19;
                jArr5 = jArr16;
                bArrCopyOf = bArr4;
                long[] jArr20 = jArr4;
                jArr4 = jArr8;
                jArr8 = jArr20;
                long[] jArr21 = jArr7;
                jArr7 = jArr3;
                jArr3 = jArr21;
            }
            i4++;
            bArrCopyOf = bArrCopyOf;
        }
        long[] jArr22 = jArr;
        long[] jArr23 = new long[10];
        long[] jArr24 = new long[10];
        long[] jArr25 = new long[10];
        long[] jArr26 = new long[10];
        long[] jArr27 = new long[10];
        long[] jArr28 = new long[10];
        long[] jArr29 = new long[10];
        long[] jArr30 = new long[10];
        long[] jArr31 = new long[10];
        long[] jArr32 = new long[10];
        long[] jArr33 = jArr2;
        long[] jArr34 = new long[10];
        zzpk.zzg(jArr24, jArr5);
        zzpk.zzg(jArr34, jArr24);
        zzpk.zzg(jArr32, jArr34);
        zzpk.zza(jArr25, jArr32, jArr5);
        zzpk.zza(jArr26, jArr25, jArr24);
        zzpk.zzg(jArr32, jArr26);
        zzpk.zza(jArr27, jArr32, jArr25);
        zzpk.zzg(jArr32, jArr27);
        zzpk.zzg(jArr34, jArr32);
        zzpk.zzg(jArr32, jArr34);
        zzpk.zzg(jArr34, jArr32);
        zzpk.zzg(jArr32, jArr34);
        zzpk.zza(jArr28, jArr32, jArr27);
        zzpk.zzg(jArr32, jArr28);
        zzpk.zzg(jArr34, jArr32);
        for (int i12 = 2; i12 < 10; i12 += 2) {
            zzpk.zzg(jArr32, jArr34);
            zzpk.zzg(jArr34, jArr32);
        }
        zzpk.zza(jArr29, jArr34, jArr28);
        zzpk.zzg(jArr32, jArr29);
        zzpk.zzg(jArr34, jArr32);
        for (int i13 = 2; i13 < 20; i13 += 2) {
            zzpk.zzg(jArr32, jArr34);
            zzpk.zzg(jArr34, jArr32);
        }
        zzpk.zza(jArr32, jArr34, jArr29);
        zzpk.zzg(jArr34, jArr32);
        zzpk.zzg(jArr32, jArr34);
        for (int i14 = 2; i14 < 10; i14 += 2) {
            zzpk.zzg(jArr34, jArr32);
            zzpk.zzg(jArr32, jArr34);
        }
        zzpk.zza(jArr30, jArr32, jArr28);
        zzpk.zzg(jArr32, jArr30);
        zzpk.zzg(jArr34, jArr32);
        for (int i15 = 2; i15 < 50; i15 += 2) {
            zzpk.zzg(jArr32, jArr34);
            zzpk.zzg(jArr34, jArr32);
        }
        zzpk.zza(jArr31, jArr34, jArr30);
        zzpk.zzg(jArr34, jArr31);
        zzpk.zzg(jArr32, jArr34);
        for (int i16 = 2; i16 < 100; i16 += 2) {
            zzpk.zzg(jArr34, jArr32);
            zzpk.zzg(jArr32, jArr34);
        }
        zzpk.zza(jArr34, jArr32, jArr31);
        zzpk.zzg(jArr32, jArr34);
        zzpk.zzg(jArr34, jArr32);
        for (int i17 = 2; i17 < 50; i17 += 2) {
            zzpk.zzg(jArr32, jArr34);
            zzpk.zzg(jArr34, jArr32);
        }
        zzpk.zza(jArr32, jArr34, jArr30);
        zzpk.zzg(jArr34, jArr32);
        zzpk.zzg(jArr32, jArr34);
        zzpk.zzg(jArr34, jArr32);
        zzpk.zzg(jArr32, jArr34);
        zzpk.zzg(jArr34, jArr32);
        zzpk.zza(jArr23, jArr34, jArr26);
        zzpk.zza(jArr22, jArr4, jArr23);
        long[] jArr35 = new long[10];
        long[] jArr36 = new long[10];
        long[] jArr37 = new long[11];
        long[] jArr38 = new long[11];
        long[] jArr39 = new long[11];
        zzpk.zza(jArr35, jArrZzk, jArr22);
        zzpk.zzi(jArr36, jArrZzk, jArr22);
        long[] jArr40 = new long[10];
        jArr40[0] = 486662;
        zzpk.zzi(jArr38, jArr36, jArr40);
        zzpk.zza(jArr38, jArr38, jArr3);
        zzpk.zzi(jArr38, jArr38, jArr33);
        zzpk.zza(jArr38, jArr38, jArr35);
        zzpk.zza(jArr38, jArr38, jArr33);
        zzpk.zzf(jArr37, jArr38, 4L);
        zzpk.zzd(jArr37);
        zzpk.zza(jArr38, jArr35, jArr3);
        zzpk.zzh(jArr38, jArr38, jArr3);
        zzpk.zza(jArr39, jArr36, jArr33);
        zzpk.zzi(jArr38, jArr38, jArr39);
        zzpk.zzg(jArr38, jArr38);
        if (zzor.zzb(zzpk.zzj(jArr37), zzpk.zzj(jArr38))) {
            return zzpk.zzj(jArr22);
        }
        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzpl.zza(bArr2)));
    }

    public static byte[] zzb(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return zza(bArr, bArr2);
    }
}
