package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzeb implements zzat {
    private final zzbu zza;
    private final zzif zzb;
    private final zzif zzc;

    public zzeb(zzbu zzbuVar) {
        zzif zzifVarZza;
        this.zza = zzbuVar;
        if (zzbuVar.zzf()) {
            zzig zzigVarZzb = zzgl.zza().zzb();
            zzil zzilVarZza = zzgi.zza(zzbuVar);
            this.zzb = zzigVarZzb.zza(zzilVarZza, "daead", "encrypt");
            zzifVarZza = zzigVarZzb.zza(zzilVarZza, "daead", "decrypt");
        } else {
            zzifVarZza = zzgi.zza;
            this.zzb = zzifVarZza;
        }
        this.zzc = zzifVarZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzat
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzbq zzbqVar : this.zza.zze(bArrCopyOf)) {
                try {
                    byte[] bArrZza = ((zzat) zzbqVar.zze()).zza(bArrCopyOfRange, bArr2);
                    zzbqVar.zza();
                    int length2 = bArrCopyOfRange.length;
                    return bArrZza;
                } catch (GeneralSecurityException e) {
                    zzec.zza.logp(Level.INFO, "com.google.crypto.tink.daead.DeterministicAeadWrapper$WrappedDeterministicAead", "decryptDeterministically", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e.toString()));
                }
            }
        }
        for (zzbq zzbqVar2 : this.zza.zze(zzas.zza)) {
            try {
                byte[] bArrZza2 = ((zzat) zzbqVar2.zze()).zza(bArr, bArr2);
                zzbqVar2.zza();
                int length3 = bArr.length;
                return bArrZza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
