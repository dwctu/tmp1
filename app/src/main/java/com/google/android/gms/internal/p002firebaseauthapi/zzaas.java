package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaas {
    public static int zza(byte[] bArr, int i, zzaar zzaarVar) throws zzacp {
        int iZzj = zzj(bArr, i, zzaarVar);
        int i2 = zzaarVar.zza;
        if (i2 < 0) {
            throw zzacp.zzf();
        }
        if (i2 > bArr.length - iZzj) {
            throw zzacp.zzi();
        }
        if (i2 == 0) {
            zzaarVar.zzc = zzabe.zzb;
            return iZzj;
        }
        zzaarVar.zzc = zzabe.zzo(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzc(zzady zzadyVar, byte[] bArr, int i, int i2, int i3, zzaar zzaarVar) throws IOException {
        zzadp zzadpVar = (zzadp) zzadyVar;
        Object objZze = zzadpVar.zze();
        int iZzc = zzadpVar.zzc(objZze, bArr, i, i2, i3, zzaarVar);
        zzadpVar.zzf(objZze);
        zzaarVar.zzc = objZze;
        return iZzc;
    }

    public static int zzd(zzady zzadyVar, byte[] bArr, int i, int i2, zzaar zzaarVar) throws IOException {
        int iZzk = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzk = zzk(i3, bArr, iZzk, zzaarVar);
            i3 = zzaarVar.zza;
        }
        int i4 = iZzk;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzacp.zzi();
        }
        Object objZze = zzadyVar.zze();
        int i5 = i3 + i4;
        zzadyVar.zzi(objZze, bArr, i4, i5, zzaarVar);
        zzadyVar.zzf(objZze);
        zzaarVar.zzc = objZze;
        return i5;
    }

    public static int zze(zzady zzadyVar, int i, byte[] bArr, int i2, int i3, zzacm zzacmVar, zzaar zzaarVar) throws IOException {
        int iZzd = zzd(zzadyVar, bArr, i2, i3, zzaarVar);
        zzacmVar.add(zzaarVar.zzc);
        while (iZzd < i3) {
            int iZzj = zzj(bArr, iZzd, zzaarVar);
            if (i != zzaarVar.zza) {
                break;
            }
            iZzd = zzd(zzadyVar, bArr, iZzj, i3, zzaarVar);
            zzacmVar.add(zzaarVar.zzc);
        }
        return iZzd;
    }

    public static int zzf(byte[] bArr, int i, zzacm zzacmVar, zzaar zzaarVar) throws IOException {
        zzaci zzaciVar = (zzaci) zzacmVar;
        int iZzj = zzj(bArr, i, zzaarVar);
        int i2 = zzaarVar.zza + iZzj;
        while (iZzj < i2) {
            iZzj = zzj(bArr, iZzj, zzaarVar);
            zzaciVar.zzf(zzaarVar.zza);
        }
        if (iZzj == i2) {
            return iZzj;
        }
        throw zzacp.zzi();
    }

    public static int zzg(byte[] bArr, int i, zzaar zzaarVar) throws zzacp {
        int iZzj = zzj(bArr, i, zzaarVar);
        int i2 = zzaarVar.zza;
        if (i2 < 0) {
            throw zzacp.zzf();
        }
        if (i2 == 0) {
            zzaarVar.zzc = "";
            return iZzj;
        }
        zzaarVar.zzc = new String(bArr, iZzj, i2, zzacn.zzb);
        return iZzj + i2;
    }

    public static int zzh(byte[] bArr, int i, zzaar zzaarVar) throws zzacp {
        int iZzj = zzj(bArr, i, zzaarVar);
        int i2 = zzaarVar.zza;
        if (i2 < 0) {
            throw zzacp.zzf();
        }
        if (i2 == 0) {
            zzaarVar.zzc = "";
            return iZzj;
        }
        zzaarVar.zzc = zzafe.zzd(bArr, iZzj, i2);
        return iZzj + i2;
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, zzaeq zzaeqVar, zzaar zzaarVar) throws zzacp {
        if ((i >>> 3) == 0) {
            throw zzacp.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzm = zzm(bArr, i2, zzaarVar);
            zzaeqVar.zzh(i, Long.valueOf(zzaarVar.zzb));
            return iZzm;
        }
        if (i4 == 1) {
            zzaeqVar.zzh(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzj = zzj(bArr, i2, zzaarVar);
            int i5 = zzaarVar.zza;
            if (i5 < 0) {
                throw zzacp.zzf();
            }
            if (i5 > bArr.length - iZzj) {
                throw zzacp.zzi();
            }
            if (i5 == 0) {
                zzaeqVar.zzh(i, zzabe.zzb);
            } else {
                zzaeqVar.zzh(i, zzabe.zzo(bArr, iZzj, i5));
            }
            return iZzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzacp.zzc();
            }
            zzaeqVar.zzh(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzaeq zzaeqVarZze = zzaeq.zze();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzj2 = zzj(bArr, i2, zzaarVar);
            int i8 = zzaarVar.zza;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZzj2;
                break;
            }
            i7 = i8;
            i2 = zzi(i8, bArr, iZzj2, i3, zzaeqVarZze, zzaarVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzacp.zzg();
        }
        zzaeqVar.zzh(i, zzaeqVarZze);
        return i2;
    }

    public static int zzj(byte[] bArr, int i, zzaar zzaarVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzaarVar);
        }
        zzaarVar.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zzaar zzaarVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzaarVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzaarVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzaarVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzaarVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzaarVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzacm zzacmVar, zzaar zzaarVar) {
        zzaci zzaciVar = (zzaci) zzacmVar;
        int iZzj = zzj(bArr, i2, zzaarVar);
        zzaciVar.zzf(zzaarVar.zza);
        while (iZzj < i3) {
            int iZzj2 = zzj(bArr, iZzj, zzaarVar);
            if (i != zzaarVar.zza) {
                break;
            }
            iZzj = zzj(bArr, iZzj2, zzaarVar);
            zzaciVar.zzf(zzaarVar.zza);
        }
        return iZzj;
    }

    public static int zzm(byte[] bArr, int i, zzaar zzaarVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzaarVar.zzb = j;
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
        zzaarVar.zzb = j2;
        return i3;
    }

    public static long zzn(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }
}
