package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import com.samsung.android.sdk.bt.gatt.BluetoothGatt;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzabg extends zzabi {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    public /* synthetic */ zzabg(byte[] bArr, int i, int i2, boolean z, zzabf zzabfVar) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzf = i2;
        this.zzh = 0;
    }

    private final void zzv() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = this.zzj;
        if (i <= i2) {
            this.zzg = 0;
            return;
        }
        int i3 = i - i2;
        this.zzg = i3;
        this.zzf = i - i3;
    }

    public final byte zza() throws IOException {
        int i = this.zzh;
        if (i == this.zzf) {
            throw zzacp.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final int zzb() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final int zzc(int i) throws zzacp {
        if (i < 0) {
            throw zzacp.zzf();
        }
        int i2 = i + this.zzh;
        if (i2 < 0) {
            throw zzacp.zzg();
        }
        int i3 = this.zzj;
        if (i2 > i3) {
            throw zzacp.zzi();
        }
        this.zzj = i2;
        zzv();
        return i3;
    }

    public final int zzd() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw zzacp.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r2[r3] >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zze() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 != r0) goto L7
            goto L6c
        L7:
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzh = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6c
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L23
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L69
        L23:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L30
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2e:
            r1 = r3
            goto L69
        L30:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L69
        L3e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6c
        L69:
            r5.zzh = r1
            return r0
        L6c:
            long r0 = r5.zzi()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzabg.zze():int");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final int zzf() throws IOException {
        if (zzp()) {
            this.zzi = 0;
            return 0;
        }
        int iZze = zze();
        this.zzi = iZze;
        if ((iZze >>> 3) != 0) {
            return iZze;
        }
        throw zzacp.zzc();
    }

    public final long zzg() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw zzacp.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final long zzh() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzh = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        j = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            long j5 = (bArr[i5] << 28) ^ i9;
                            if (j5 < 0) {
                                int i10 = i7 + 1;
                                long j6 = j5 ^ (bArr[i7] << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i10 + 1;
                                    j5 = j6 ^ (bArr[i10] << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i10 = i7 + 1;
                                        j6 = j5 ^ (bArr[i7] << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i10 + 1;
                                            j = (j6 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                i10 = i7 + 1;
                                                if (bArr[i7] >= 0) {
                                                    j2 = j;
                                                    i5 = i10;
                                                    this.zzh = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j3 ^ j6;
                                i5 = i10;
                                this.zzh = i5;
                                return j2;
                            }
                            j4 = 266354560;
                            j = j5 ^ j4;
                        }
                    }
                    i5 = i7;
                    j2 = j;
                    this.zzh = i5;
                    return j2;
                }
                i = i6 ^ BluetoothGatt.GATT_NO_RESOURCES;
                j2 = i;
                this.zzh = i5;
                return j2;
            }
        }
        return zzi();
    }

    public final long zzi() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((zza() & 128) == 0) {
                return j;
            }
        }
        throw zzacp.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final zzabe zzj() throws IOException {
        int iZze = zze();
        if (iZze > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZze <= i - i2) {
                zzabe zzabeVarZzo = zzabe.zzo(this.zze, i2, iZze);
                this.zzh += iZze;
                return zzabeVarZzo;
            }
        }
        if (iZze == 0) {
            return zzabe.zzb;
        }
        if (iZze > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZze <= i3 - i4) {
                int i5 = iZze + i4;
                this.zzh = i5;
                return zzabe.zzq(Arrays.copyOfRange(this.zze, i4, i5));
            }
        }
        if (iZze <= 0) {
            throw zzacp.zzf();
        }
        throw zzacp.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final String zzk() throws IOException {
        int iZze = zze();
        if (iZze > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZze <= i - i2) {
                String str = new String(this.zze, i2, iZze, zzacn.zzb);
                this.zzh += iZze;
                return str;
            }
        }
        if (iZze == 0) {
            return "";
        }
        if (iZze < 0) {
            throw zzacp.zzf();
        }
        throw zzacp.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final String zzl() throws IOException {
        int iZze = zze();
        if (iZze > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZze <= i - i2) {
                String strZzd = zzafe.zzd(this.zze, i2, iZze);
                this.zzh += iZze;
                return strZzd;
            }
        }
        if (iZze == 0) {
            return "";
        }
        if (iZze <= 0) {
            throw zzacp.zzf();
        }
        throw zzacp.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final void zzm(int i) throws zzacp {
        if (this.zzi != i) {
            throw zzacp.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final void zzn(int i) {
        this.zzj = i;
        zzv();
    }

    public final void zzo(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzacp.zzi();
        }
        throw zzacp.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final boolean zzp() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final boolean zzq() throws IOException {
        return zzh() != 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final boolean zzr(int i) throws IOException {
        int iZzf;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i3 < 10) {
                    if (zza() < 0) {
                        i3++;
                    }
                }
                throw zzacp.zze();
            }
            while (i3 < 10) {
                byte[] bArr = this.zze;
                int i4 = this.zzh;
                this.zzh = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzacp.zze();
            return true;
        }
        if (i2 == 1) {
            zzo(8);
            return true;
        }
        if (i2 == 2) {
            zzo(zze());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzacp.zza();
            }
            zzo(4);
            return true;
        }
        do {
            iZzf = zzf();
            if (iZzf == 0) {
                break;
            }
        } while (zzr(iZzf));
        zzm(((i >>> 3) << 3) | 4);
        return true;
    }
}
