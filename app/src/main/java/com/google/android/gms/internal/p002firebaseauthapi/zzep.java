package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzep implements zzou {
    private final String zza;
    private final int zzb;
    private zzjw zzc;
    private zziy zzd;
    private int zze;
    private zzki zzf;

    public zzep(zzmz zzmzVar) throws GeneralSecurityException {
        String strZzf = zzmzVar.zzf();
        this.zza = strZzf;
        if (strZzf.equals(zzcc.zzb)) {
            try {
                zzjz zzjzVarZzd = zzjz.zzd(zzmzVar.zze(), zzabu.zza());
                this.zzc = (zzjw) zzbz.zzd(zzmzVar);
                this.zzb = zzjzVarZzd.zza();
                return;
            } catch (zzacp e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (strZzf.equals(zzcc.zza)) {
            try {
                zzjb zzjbVarZzc = zzjb.zzc(zzmzVar.zze(), zzabu.zza());
                this.zzd = (zziy) zzbz.zzd(zzmzVar);
                this.zze = zzjbVarZzc.zzd().zza();
                this.zzb = this.zze + zzjbVarZzc.zze().zza();
                return;
            } catch (zzacp e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        }
        if (!strZzf.equals(zzea.zza)) {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(strZzf)));
        }
        try {
            zzkl zzklVarZzd = zzkl.zzd(zzmzVar.zze(), zzabu.zza());
            this.zzf = (zzki) zzbz.zzd(zzmzVar);
            this.zzb = zzklVarZzd.zza();
        } catch (zzacp e3) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzou
    public final zzfk zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.zza.equals(zzcc.zzb)) {
            zzjv zzjvVarZzb = zzjw.zzb();
            zzjvVarZzb.zzj(this.zzc);
            zzjvVarZzb.zza(zzabe.zzo(bArr, 0, this.zzb));
            return new zzfk((zzap) zzbz.zzi(this.zza, (zzjw) zzjvVarZzb.zzk(), zzap.class));
        }
        if (!this.zza.equals(zzcc.zza)) {
            if (!this.zza.equals(zzea.zza)) {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            zzkh zzkhVarZzb = zzki.zzb();
            zzkhVarZzb.zzj(this.zzf);
            zzkhVarZzb.zza(zzabe.zzo(bArr, 0, this.zzb));
            return new zzfk((zzat) zzbz.zzi(this.zza, (zzki) zzkhVarZzb.zzk(), zzat.class));
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
        zzjd zzjdVarZzb = zzje.zzb();
        zzjdVarZzb.zzj(this.zzd.zze());
        zzjdVarZzb.zza(zzabe.zzn(bArrCopyOfRange));
        zzje zzjeVar = (zzje) zzjdVarZzb.zzk();
        zzlu zzluVarZzb = zzlv.zzb();
        zzluVarZzb.zzj(this.zzd.zzf());
        zzluVarZzb.zza(zzabe.zzn(bArrCopyOfRange2));
        zzlv zzlvVar = (zzlv) zzluVarZzb.zzk();
        zzix zzixVarZzb = zziy.zzb();
        zzixVarZzb.zzc(this.zzd.zza());
        zzixVarZzb.zza(zzjeVar);
        zzixVarZzb.zzb(zzlvVar);
        return new zzfk((zzap) zzbz.zzi(this.zza, (zziy) zzixVarZzb.zzk(), zzap.class));
    }
}
