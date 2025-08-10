package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhz implements zzbm {
    private final zzbu zza;
    private final zzif zzb;
    private final zzif zzc;

    public /* synthetic */ zzhz(zzbu zzbuVar, zzhy zzhyVar) {
        zzif zzifVarZza;
        this.zza = zzbuVar;
        if (zzbuVar.zzf()) {
            zzig zzigVarZzb = zzgl.zza().zzb();
            zzil zzilVarZza = zzgi.zza(zzbuVar);
            this.zzb = zzigVarZzb.zza(zzilVarZza, "mac", "compute");
            zzifVarZza = zzigVarZzb.zza(zzilVarZza, "mac", "verify");
        } else {
            zzifVarZza = zzgi.zza;
            this.zzb = zzifVarZza;
        }
        this.zzc = zzifVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length <= 5) {
            throw new GeneralSecurityException("tag too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
        for (zzbq zzbqVar : this.zza.zze(bArrCopyOf)) {
            try {
                ((zzbm) zzbqVar.zze()).zza(bArrCopyOfRange, zzbqVar.zzd().equals(zzoa.LEGACY) ? zzor.zzc(bArr2, zzia.zzb) : bArr2);
                zzbqVar.zza();
                return;
            } catch (GeneralSecurityException e) {
                zzia.zza.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", "tag prefix matches a key, but cannot verify: ".concat(e.toString()));
            }
        }
        for (zzbq zzbqVar2 : this.zza.zze(zzas.zza)) {
            try {
                ((zzbm) zzbqVar2.zze()).zza(bArr, bArr2);
                zzbqVar2.zza();
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("invalid MAC");
    }
}
