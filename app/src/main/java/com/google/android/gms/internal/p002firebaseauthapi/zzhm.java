package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhm extends zzhx {
    private final int zza;
    private final zzhl zzb;

    private zzhm(int i, zzhl zzhlVar) {
        this.zza = i;
        this.zzb = zzhlVar;
    }

    public static zzhm zzc(int i, zzhl zzhlVar) throws GeneralSecurityException {
        if (i >= 10 && i <= 16) {
            return new zzhm(i, zzhlVar);
        }
        throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhm)) {
            return false;
        }
        zzhm zzhmVar = (zzhm) obj;
        return zzhmVar.zza() == zza() && zzhmVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + this.zzb.toString() + ", " + this.zza + "-byte tags)";
    }

    public final int zza() {
        zzhl zzhlVar = this.zzb;
        if (zzhlVar == zzhl.zzd) {
            return this.zza;
        }
        if (zzhlVar == zzhl.zza || zzhlVar == zzhl.zzb || zzhlVar == zzhl.zzc) {
            return this.zza + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzhl zzb() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzb != zzhl.zzd;
    }
}
