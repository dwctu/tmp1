package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhu extends zzgb {
    public zzhu() {
        super(zzlv.class, new zzhs(zzbm.class));
    }

    public static final void zzh(zzlv zzlvVar) throws GeneralSecurityException {
        zzpu.zzc(zzlvVar.zza(), 0);
        if (zzlvVar.zzg().zzd() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzn(zzlvVar.zzf());
    }

    public static /* bridge */ /* synthetic */ zzfz zzi(int i, int i2, int i3, int i4) {
        zzlx zzlxVarZzb = zzly.zzb();
        zzma zzmaVarZzb = zzmb.zzb();
        zzmaVarZzb.zzb(i3);
        zzmaVarZzb.zza(i2);
        zzlxVarZzb.zzb((zzmb) zzmaVarZzb.zzk());
        zzlxVarZzb.zza(i);
        return new zzfz((zzly) zzlxVarZzb.zzk(), i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzn(zzmb zzmbVar) throws GeneralSecurityException {
        if (zzmbVar.zza() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int iZzf = zzmbVar.zzf() - 2;
        if (iZzf == 1) {
            if (zzmbVar.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iZzf == 2) {
            if (zzmbVar.zza() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iZzf == 3) {
            if (zzmbVar.zza() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (iZzf == 4) {
            if (zzmbVar.zza() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (iZzf != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (zzmbVar.zza() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzht(this, zzly.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzlv.zze(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzh((zzlv) zzadmVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final int zzf() {
        return 2;
    }
}
