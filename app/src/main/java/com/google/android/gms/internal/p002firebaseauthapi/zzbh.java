package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbh {
    private final zznh zza;
    private final zzie zzb = zzie.zza;

    private zzbh(zznh zznhVar) {
        this.zza = zznhVar;
    }

    public static final zzbh zza(zznh zznhVar) throws GeneralSecurityException {
        zzi(zznhVar);
        return new zzbh(zznhVar);
    }

    public static final zzbh zzh(zzfq zzfqVar, zzap zzapVar) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zzlq zzlqVarZza = zzfqVar.zza();
        if (zzlqVarZza == null || zzlqVarZza.zzd().zzd() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        try {
            zznh zznhVarZzf = zznh.zzf(zzapVar.zza(zzlqVarZza.zzd().zzt(), bArr), zzabu.zza());
            zzi(zznhVarZzf);
            return new zzbh(zznhVarZzf);
        } catch (zzacp unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static void zzi(zznh zznhVar) throws GeneralSecurityException {
        if (zznhVar == null || zznhVar.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final String toString() {
        return zzcb.zza(this.zza).toString();
    }

    public final zzbh zzb() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new GeneralSecurityException("cleartext keyset is not available");
        }
        zzne zzneVarZzc = zznh.zzc();
        for (zzng zzngVar : this.zza.zzg()) {
            zzmu zzmuVarZzb = zzngVar.zzb();
            if (zzmuVarZzb.zzb() != zzmt.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("The keyset contains a non-private key");
            }
            String strZzf = zzmuVarZzb.zzf();
            zzabe zzabeVarZze = zzmuVarZzb.zze();
            zzax zzaxVarZza = zzbz.zza(strZzf);
            if (!(zzaxVarZza instanceof zzbw)) {
                throw new GeneralSecurityException("manager for key type " + strZzf + " is not a PrivateKeyManager");
            }
            zzmu zzmuVarZzf = ((zzbw) zzaxVarZza).zzf(zzabeVarZze);
            zzbz.zzf(zzmuVarZzf);
            zznf zznfVar = (zznf) zzngVar.zzu();
            zznfVar.zza(zzmuVarZzf);
            zzneVarZzc.zzb((zzng) zznfVar.zzk());
        }
        zzneVarZzc.zzc(this.zza.zzb());
        return new zzbh((zznh) zzneVarZzc.zzk());
    }

    public final zznh zzc() {
        return this.zza;
    }

    public final zznm zzd() {
        return zzcb.zza(this.zza);
    }

    public final Object zze(Class cls) throws GeneralSecurityException {
        Class clsZze = zzbz.zze(cls);
        if (clsZze == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(cls.getName())));
        }
        zzcb.zzb(this.zza);
        zzbp zzbpVar = new zzbp(clsZze, null);
        zzbpVar.zzc(this.zzb);
        for (zzng zzngVar : this.zza.zzg()) {
            if (zzngVar.zzk() == 3) {
                Object objZzg = zzbz.zzg(zzngVar.zzb(), clsZze);
                if (zzngVar.zza() == this.zza.zzb()) {
                    zzbpVar.zza(objZzg, zzngVar);
                } else {
                    zzbpVar.zzb(objZzg, zzngVar);
                }
            }
        }
        return zzbz.zzk(zzbpVar.zzd(), cls);
    }

    public final void zzf(zzbj zzbjVar, zzap zzapVar) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zznh zznhVar = this.zza;
        byte[] bArrZzb = zzapVar.zzb(zznhVar.zzr(), bArr);
        try {
            if (!zznh.zzf(zzapVar.zza(bArrZzb, bArr), zzabu.zza()).equals(zznhVar)) {
                throw new GeneralSecurityException("cannot encrypt keyset");
            }
            zzlp zzlpVarZza = zzlq.zza();
            zzlpVarZza.zza(zzabe.zzn(bArrZzb));
            zzlpVarZza.zzb(zzcb.zza(zznhVar));
            zzbjVar.zzb((zzlq) zzlpVarZza.zzk());
        } catch (zzacp unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public final void zzg(zzbj zzbjVar) throws GeneralSecurityException, IOException {
        for (zzng zzngVar : this.zza.zzg()) {
            if (zzngVar.zzb().zzb() == zzmt.UNKNOWN_KEYMATERIAL || zzngVar.zzb().zzb() == zzmt.SYMMETRIC || zzngVar.zzb().zzb() == zzmt.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", zzngVar.zzb().zzb().name(), zzngVar.zzb().zzf()));
            }
        }
        zzbjVar.zzc(this.zza);
    }
}
