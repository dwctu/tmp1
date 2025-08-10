package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzir {
    public static int zza(byte[] bArr, int i, zziq zziqVar) throws zzko {
        int iZzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza;
        if (i2 < 0) {
            throw zzko.zzd();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzko.zzf();
        }
        if (i2 == 0) {
            zziqVar.zzc = zzjd.zzb;
            return iZzj;
        }
        zziqVar.zzc = zzjd.zzl(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzc(zzlw zzlwVar, byte[] bArr, int i, int i2, int i3, zziq zziqVar) throws IOException {
        zzlo zzloVar = (zzlo) zzlwVar;
        Object objZze = zzloVar.zze();
        int iZzc = zzloVar.zzc(objZze, bArr, i, i2, i3, zziqVar);
        zzloVar.zzf(objZze);
        zziqVar.zzc = objZze;
        return iZzc;
    }

    public static int zzd(zzlw zzlwVar, byte[] bArr, int i, int i2, zziq zziqVar) throws IOException {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zziqVar);
            i3 = zziqVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzko.zzf();
        }
        Object objZze = zzlwVar.zze();
        int i5 = i3 + i4;
        zzlwVar.zzh(objZze, bArr, i4, i5, zziqVar);
        zzlwVar.zzf(objZze);
        zziqVar.zzc = objZze;
        return i5;
    }

    public static int zze(zzlw zzlwVar, int i, byte[] bArr, int i2, int i3, zzkl zzklVar, zziq zziqVar) throws IOException {
        int iZzd = zzd(zzlwVar, bArr, i2, i3, zziqVar);
        zzklVar.add(zziqVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zziqVar);
            if (i != zziqVar.zza) {
                break;
            }
            iZzd = zzd(zzlwVar, bArr, iZzj, i3, zziqVar);
            zzklVar.add(zziqVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzkl zzklVar, zziq zziqVar) throws IOException {
        zzkf zzkfVar = (zzkf) zzklVar;
        int iZzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zziqVar);
            zzkfVar.zzh(zziqVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzko.zzf();
    }

    public static int zzg(byte[] bArr, int i, zziq zziqVar) throws zzko {
        int iZzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza;
        if (i2 < 0) {
            throw zzko.zzd();
        }
        if (i2 == 0) {
            zziqVar.zzc = "";
            return iZzj;
        }
        zziqVar.zzc = new String(bArr, iZzj, i2, zzkm.zzb);
        return iZzj + i2;
    }

    public static int zzh(byte[] bArr, int i, zziq zziqVar) throws zzko {
        int iZzj = zzj(bArr, i, zziqVar);
        int i2 = zziqVar.zza;
        if (i2 < 0) {
            throw zzko.zzd();
        }
        if (i2 == 0) {
            zziqVar.zzc = "";
            return iZzj;
        }
        zziqVar.zzc = zznc.zzd(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, zzmo zzmoVar, zziq zziqVar) throws zzko {
        if ((i >>> 3) == 0) {
            throw zzko.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zziqVar);
            zzmoVar.zzh(i, Long.valueOf(zziqVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzmoVar.zzh(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zziqVar);
            int i5 = zziqVar.zza;
            if (i5 < 0) {
                throw zzko.zzd();
            }
            if (i5 > bArr.length - iZzj) {
                throw zzko.zzf();
            }
            if (i5 == 0) {
                zzmoVar.zzh(i, zzjd.zzb);
            } else {
                zzmoVar.zzh(i, zzjd.zzl(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzko.zzb();
            }
            zzmoVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzmo zzmoVarZze = zzmo.zze();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzj2 = zzj(bArr, i2, zziqVar);
            int i8 = zziqVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, iZzj2, i3, zzmoVarZze, zziqVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzko.zze();
        }
        zzmoVar.zzh(i, zzmoVarZze);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, zziq zziqVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zziqVar);
        }
        zziqVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zziq zziqVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zziqVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zziqVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zziqVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zziqVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zziqVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzkl zzklVar, zziq zziqVar) {
        zzkf zzkfVar = (zzkf) zzklVar;
        int iZzj = zzj(bArr, i2, zziqVar);
        zzkfVar.zzh(zziqVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zziqVar);
            if (i != zziqVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zziqVar);
            zzkfVar.zzh(zziqVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i, zziq zziqVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zziqVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zziqVar.zzb = j2;
        return i3;
    }

    public static long zzn(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
