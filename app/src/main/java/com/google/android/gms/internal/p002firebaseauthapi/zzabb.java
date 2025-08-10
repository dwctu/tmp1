package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public class zzabb extends zzaba {
    public final byte[] zza;

    public zzabb(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzabe) || zzd() != ((zzabe) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzabb)) {
            return obj.equals(this);
        }
        zzabb zzabbVar = (zzabb) obj;
        int iZzm = zzm();
        int iZzm2 = zzabbVar.zzm();
        if (iZzm != 0 && iZzm2 != 0 && iZzm != iZzm2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzabbVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzabbVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzabbVar.zzd());
        }
        if (!(zzabbVar instanceof zzabb)) {
            return zzabbVar.zzg(0, iZzd).equals(zzg(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzabbVar.zza;
        zzabbVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public final int zzf(int i, int i2, int i3) {
        return zzacn.zzd(i, this.zza, 0, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public final zzabe zzg(int i, int i2) {
        int iZzl = zzabe.zzl(0, i2, zzd());
        return iZzl == 0 ? zzabe.zzb : new zzaay(this.zza, 0, iZzl);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public final zzabi zzh() {
        return zzabi.zzu(this.zza, 0, zzd(), true);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public final String zzi(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public final void zzj(zzaau zzaauVar) throws IOException {
        zzaauVar.zza(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabe
    public final boolean zzk() {
        return zzafe.zzf(this.zza, 0, zzd());
    }
}
