package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaeq {
    private static final zzaeq zza = new zzaeq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaeq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaeq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaeq zzc() {
        return zza;
    }

    public static zzaeq zzd(zzaeq zzaeqVar, zzaeq zzaeqVar2) {
        int i = zzaeqVar.zzb + zzaeqVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzaeqVar.zzc, i);
        System.arraycopy(zzaeqVar2.zzc, 0, iArrCopyOf, zzaeqVar.zzb, zzaeqVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzaeqVar.zzd, i);
        System.arraycopy(zzaeqVar2.zzd, 0, objArrCopyOf, zzaeqVar.zzb, zzaeqVar2.zzb);
        return new zzaeq(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzaeq zze() {
        return new zzaeq(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzaeq)) {
            return false;
        }
        zzaeq zzaeqVar = (zzaeq) obj;
        int i = this.zzb;
        if (i == zzaeqVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaeqVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzaeqVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzE;
        int iZzF;
        int iZzE2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzE3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.zzd[i2]).longValue();
                    iZzE2 = zzabp.zzE(i4 << 3) + 8;
                } else if (i5 == 2) {
                    zzabe zzabeVar = (zzabe) this.zzd[i2];
                    int iZzE4 = zzabp.zzE(i4 << 3);
                    int iZzd = zzabeVar.zzd();
                    iZzE3 += iZzE4 + zzabp.zzE(iZzd) + iZzd;
                } else if (i5 == 3) {
                    int iZzD = zzabp.zzD(i4);
                    iZzE = iZzD + iZzD;
                    iZzF = ((zzaeq) this.zzd[i2]).zza();
                } else {
                    if (i5 != 5) {
                        throw new IllegalStateException(zzacp.zza());
                    }
                    ((Integer) this.zzd[i2]).intValue();
                    iZzE2 = zzabp.zzE(i4 << 3) + 4;
                }
                iZzE3 += iZzE2;
            } else {
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzE = zzabp.zzE(i4 << 3);
                iZzF = zzabp.zzF(jLongValue);
            }
            iZzE2 = iZzE + iZzF;
            iZzE3 += iZzE2;
        }
        this.zze = iZzE3;
        return iZzE3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzE = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            zzabe zzabeVar = (zzabe) this.zzd[i2];
            int iZzE2 = zzabp.zzE(8);
            int iZzd = zzabeVar.zzd();
            iZzE += iZzE2 + iZzE2 + zzabp.zzE(16) + zzabp.zzE(i3 >>> 3) + zzabp.zzE(24) + zzabp.zzE(iZzd) + iZzd;
        }
        this.zze = iZzE;
        return iZzE;
    }

    public final void zzf() {
        this.zzf = false;
    }

    public final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzado.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    public final void zzh(int i, Object obj) {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.zzb;
        int[] iArr = this.zzc;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
        int[] iArr2 = this.zzc;
        int i4 = this.zzb;
        iArr2[i4] = i;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    public final void zzi(zzabq zzabqVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzabqVar.zzt(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzabqVar.zzm(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzabqVar.zzd(i3, (zzabe) obj);
                } else if (i4 == 3) {
                    zzabqVar.zzE(i3);
                    ((zzaeq) obj).zzi(zzabqVar);
                    zzabqVar.zzh(i3);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(zzacp.zza());
                    }
                    zzabqVar.zzk(i3, ((Integer) obj).intValue());
                }
            }
        }
    }
}
