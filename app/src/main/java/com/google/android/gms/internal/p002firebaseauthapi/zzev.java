package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzev implements zzau {
    private static final byte[] zza = new byte[0];
    private final zzey zzb;
    private final zzex zzc;
    private final zzet zzd;
    private final zzes zze;

    private zzev(zzey zzeyVar, zzex zzexVar, zzes zzesVar, zzet zzetVar, int i, byte[] bArr) {
        this.zzb = zzeyVar;
        this.zzc = zzexVar;
        this.zze = zzesVar;
        this.zzd = zzetVar;
    }

    public static zzev zzb(zzmm zzmmVar) throws GeneralSecurityException {
        zzey zzeyVarZzc;
        if (!zzmmVar.zzk()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        }
        if (!zzmmVar.zze().zzl()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        if (zzmmVar.zzf().zzs()) {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
        zzmj zzmjVarZzb = zzmmVar.zze().zzb();
        zzex zzexVarZzb = zzez.zzb(zzmjVarZzb);
        zzes zzesVarZzc = zzez.zzc(zzmjVarZzb);
        zzet zzetVarZza = zzez.zza(zzmjVarZzb);
        int iZzf = zzmjVarZzb.zzf();
        int i = 1;
        if (iZzf - 2 != 1) {
            throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(zzmd.zza(iZzf)));
        }
        int iZzf2 = zzmmVar.zze().zzb().zzf() - 2;
        if (iZzf2 == 1) {
            zzeyVarZzc = zzfj.zzc(zzmmVar.zzf().zzt());
        } else {
            if (iZzf2 != 2 && iZzf2 != 3 && iZzf2 != 4) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            byte[] bArrZzt = zzmmVar.zzf().zzt();
            byte[] bArrZzt2 = zzmmVar.zze().zzg().zzt();
            int iZzf3 = zzmmVar.zze().zzb().zzf() - 2;
            if (iZzf3 != 2) {
                if (iZzf3 == 3) {
                    i = 2;
                } else {
                    if (iZzf3 != 4) {
                        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
                    }
                    i = 3;
                }
            }
            zzeyVarZzc = zzfh.zzc(bArrZzt, bArrZzt2, i);
        }
        return new zzev(zzeyVarZzc, zzexVarZzb, zzesVarZzc, zzetVarZza, 32, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzau
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 32) {
            throw new GeneralSecurityException("Ciphertext is too short.");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 32);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 32, length);
        zzey zzeyVar = this.zzb;
        zzex zzexVar = this.zzc;
        zzes zzesVar = this.zze;
        zzet zzetVar = this.zzd;
        return zzeu.zzb(bArrCopyOf, zzexVar.zza(bArrCopyOf, zzeyVar), zzexVar, zzesVar, zzetVar, new byte[0]).zza(bArrCopyOfRange, zza);
    }
}
