package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhh extends zzhw {
    private final zzhm zza;
    private final zzpy zzb;
    private final Integer zzc;

    private zzhh(zzhm zzhmVar, zzpy zzpyVar, Integer num) {
        this.zza = zzhmVar;
        this.zzb = zzpyVar;
        this.zzc = num;
    }

    public static zzhh zzb(zzhm zzhmVar, zzpy zzpyVar, Integer num) throws GeneralSecurityException {
        if (zzpyVar.zza() != 32) {
            throw new GeneralSecurityException("Invalid key size");
        }
        if (zzhmVar.zzd() && num == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with format with ID requirement");
        }
        if (zzhmVar.zzd() || num == null) {
            return new zzhh(zzhmVar, zzpyVar, num);
        }
        throw new GeneralSecurityException("Cannot create key with ID requirement with format without ID requirement");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhw, com.google.android.gms.internal.p002firebaseauthapi.zzaw
    public final /* synthetic */ zzbn zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhw
    public final /* synthetic */ zzhx zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzhw
    public final zzpx zzd() {
        zzhm zzhmVar = this.zza;
        if (zzhmVar.zzb() == zzhl.zzd) {
            return zzpx.zzb(new byte[0]);
        }
        if (zzhmVar.zzb() == zzhl.zzc || zzhmVar.zzb() == zzhl.zzb) {
            return zzpx.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        }
        if (zzhmVar.zzb() == zzhl.zza) {
            return zzpx.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        throw new IllegalStateException("Unknown AesCmacParameters.Variant: ".concat(zzhmVar.zzb().toString()));
    }
}
