package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzej implements zzau {
    private final zzbu zza;
    private final zzif zzb;

    public zzej(zzbu zzbuVar) {
        this.zza = zzbuVar;
        this.zzb = zzbuVar.zzf() ? zzgl.zza().zzb().zza(zzgi.zza(zzbuVar), "hybrid_decrypt", "decrypt") : zzgi.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzau
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzbq zzbqVar : this.zza.zze(bArrCopyOfRange)) {
                try {
                    byte[] bArrZza = ((zzau) zzbqVar.zze()).zza(bArrCopyOfRange2, null);
                    zzbqVar.zza();
                    int length2 = bArrCopyOfRange2.length;
                    return bArrZza;
                } catch (GeneralSecurityException e) {
                    zzek.zza.logp(Level.INFO, "com.google.crypto.tink.hybrid.HybridDecryptWrapper$WrappedHybridDecrypt", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(String.valueOf(e.toString())));
                }
            }
        }
        for (zzbq zzbqVar2 : this.zza.zze(zzas.zza)) {
            try {
                byte[] bArrZza2 = ((zzau) zzbqVar2.zze()).zza(bArr, null);
                zzbqVar2.zza();
                int length3 = bArr.length;
                return bArrZza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
