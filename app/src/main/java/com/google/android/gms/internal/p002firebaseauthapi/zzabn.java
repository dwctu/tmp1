package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzabn extends zzabk {
    private final OutputStream zzf;

    public zzabn(OutputStream outputStream, int i) {
        super(i);
        this.zzf = outputStream;
    }

    private final void zzL() throws IOException {
        this.zzf.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzM(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzL();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzN() throws IOException {
        if (this.zzc > 0) {
            zzL();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzO(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzL();
        }
        zzc(b);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzP(int i, boolean z) throws IOException {
        zzM(11);
        zzf(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzQ(int i, zzabe zzabeVar) throws IOException {
        zzs((i << 3) | 2);
        zzs(zzabeVar.zzd());
        zzabeVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp, com.google.android.gms.internal.p002firebaseauthapi.zzaau
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzp(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzh(int i, int i2) throws IOException {
        zzM(14);
        zzf((i << 3) | 5);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzi(int i) throws IOException {
        zzM(4);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzj(int i, long j) throws IOException {
        zzM(18);
        zzf((i << 3) | 1);
        zze(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzk(long j) throws IOException {
        zzM(8);
        zze(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzl(int i, int i2) throws IOException {
        zzM(20);
        zzf(i << 3);
        if (i2 >= 0) {
            zzf(i2);
        } else {
            zzg(i2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzm(int i) throws IOException {
        if (i >= 0) {
            zzs(i);
        } else {
            zzu(i);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzn(int i, zzadm zzadmVar, zzady zzadyVar) throws IOException {
        zzs((i << 3) | 2);
        zzaao zzaaoVar = (zzaao) zzadmVar;
        int iZzn = zzaaoVar.zzn();
        if (iZzn == -1) {
            iZzn = zzadyVar.zza(zzaaoVar);
            zzaaoVar.zzp(iZzn);
        }
        zzs(iZzn);
        zzadyVar.zzn(zzadmVar, this.zze);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzo(int i, String str) throws IOException {
        zzs((i << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, 0, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, 0, this.zza, i4, i5);
        int i6 = i2 - i5;
        this.zzc = this.zzb;
        this.zzd += i5;
        zzL();
        if (i6 <= this.zzb) {
            System.arraycopy(bArr, i5, this.zza, 0, i6);
            this.zzc = i6;
        } else {
            this.zzf.write(bArr, i5, i6);
        }
        this.zzd += i6;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzq(int i, int i2) throws IOException {
        zzs((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzr(int i, int i2) throws IOException {
        zzM(20);
        zzf(i << 3);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzs(int i) throws IOException {
        zzM(5);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzt(int i, long j) throws IOException {
        zzM(20);
        zzf(i << 3);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabp
    public final void zzu(long j) throws IOException {
        zzM(10);
        zzg(j);
    }

    public final void zzv(String str) throws IOException {
        int iZzc;
        try {
            int length = str.length() * 3;
            int iZzE = zzabp.zzE(length);
            int i = iZzE + length;
            int i2 = this.zzb;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iZzb = zzafe.zzb(str, bArr, 0, length);
                zzs(iZzb);
                zzp(bArr, 0, iZzb);
                return;
            }
            if (i > i2 - this.zzc) {
                zzL();
            }
            int iZzE2 = zzabp.zzE(str.length());
            int i3 = this.zzc;
            try {
                if (iZzE2 == iZzE) {
                    int i4 = i3 + iZzE2;
                    this.zzc = i4;
                    int iZzb2 = zzafe.zzb(str, this.zza, i4, this.zzb - i4);
                    this.zzc = i3;
                    iZzc = (iZzb2 - i3) - iZzE2;
                    zzf(iZzc);
                    this.zzc = iZzb2;
                } else {
                    iZzc = zzafe.zzc(str);
                    zzf(iZzc);
                    this.zzc = zzafe.zzb(str, this.zza, this.zzc, iZzc);
                }
                this.zzd += iZzc;
            } catch (zzafd e) {
                this.zzd -= this.zzc - i3;
                this.zzc = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzabm(e2);
            }
        } catch (zzafd e3) {
            zzJ(str, e3);
        }
    }
}
