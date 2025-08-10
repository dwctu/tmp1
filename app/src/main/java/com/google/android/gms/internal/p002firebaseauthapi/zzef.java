package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzef extends zzgu {
    private static final byte[] zza = new byte[0];

    public zzef() {
        super(zzlf.class, zzli.class, new zzed(zzau.class));
    }

    public static /* bridge */ /* synthetic */ zzfz zzi(int i, int i2, int i3, zzbf zzbfVar, byte[] bArr, int i4) {
        zzky zzkyVarZza = zzkz.zza();
        zzlk zzlkVarZza = zzll.zza();
        zzlkVarZza.zzb(4);
        zzlkVarZza.zzc(5);
        zzlkVarZza.zza(zzabe.zzn(bArr));
        zzll zzllVar = (zzll) zzlkVarZza.zzk();
        zzmy zzmyVarZza = zzmz.zza();
        zzmyVarZza.zzb(zzbfVar.zzb());
        zzmyVarZza.zzc(zzabe.zzn(zzbfVar.zzc()));
        int iZzd = zzbfVar.zzd() - 1;
        zzmyVarZza.zza(iZzd != 0 ? iZzd != 1 ? iZzd != 2 ? zzoa.CRUNCHY : zzoa.RAW : zzoa.LEGACY : zzoa.TINK);
        zzmz zzmzVar = (zzmz) zzmyVarZza.zzk();
        zzkv zzkvVarZza = zzkw.zza();
        zzkvVarZza.zza(zzmzVar);
        zzkw zzkwVar = (zzkw) zzkvVarZza.zzk();
        zzlb zzlbVarZzb = zzlc.zzb();
        zzlbVarZzb.zzb(zzllVar);
        zzlbVarZzb.zza(zzkwVar);
        zzlbVarZzb.zzc(i3);
        zzkyVarZza.zza((zzlc) zzlbVarZzb.zzk());
        return new zzfz((zzkz) zzkyVarZza.zzk(), i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzee(this, zzkz.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzlf.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzlf zzlfVar = (zzlf) zzadmVar;
        if (zzlfVar.zzf().zzs()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        zzpu.zzc(zzlfVar.zza(), 0);
        zzeo.zza(zzlfVar.zze().zzb());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgu
    public final /* synthetic */ zzadm zzg(zzadm zzadmVar) throws GeneralSecurityException {
        return ((zzlf) zzadmVar).zze();
    }
}
