package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzadq implements zzady {
    private final zzadm zza;
    private final zzaep zzb;
    private final boolean zzc;
    private final zzabv zzd;

    private zzadq(zzaep zzaepVar, zzabv zzabvVar, zzadm zzadmVar) {
        this.zzb = zzaepVar;
        this.zzc = zzabvVar.zzh(zzadmVar);
        this.zzd = zzabvVar;
        this.zza = zzadmVar;
    }

    public static zzadq zzc(zzaep zzaepVar, zzabv zzabvVar, zzadm zzadmVar) {
        return new zzadq(zzaepVar, zzabvVar, zzadmVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final int zza(Object obj) {
        zzaep zzaepVar = this.zzb;
        int iZzb = zzaepVar.zzb(zzaepVar.zzd(obj));
        if (!this.zzc) {
            return iZzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final Object zze() {
        return this.zza.zzA().zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final void zzg(Object obj, Object obj2) {
        zzaea.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzaea.zzE(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final void zzh(Object obj, zzadx zzadxVar, zzabu zzabuVar) throws IOException {
        boolean zZzO;
        zzaep zzaepVar = this.zzb;
        zzabv zzabvVar = this.zzd;
        Object objZzc = zzaepVar.zzc(obj);
        zzabz zzabzVarZzb = zzabvVar.zzb(obj);
        while (zzadxVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzadxVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZzc2 = zzabvVar.zzc(zzabuVar, this.zza, iZzd >>> 3);
                        if (objZzc2 != null) {
                            zzabvVar.zzf(zzadxVar, objZzc2, zzabuVar, zzabzVarZzb);
                        } else {
                            zZzO = zzaepVar.zzp(objZzc, zzadxVar);
                        }
                    } else {
                        zZzO = zzadxVar.zzO();
                    }
                    if (!zZzO) {
                        return;
                    }
                } else {
                    int iZzj = 0;
                    Object objZzc3 = null;
                    zzabe zzabeVarZzp = null;
                    while (zzadxVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzadxVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzadxVar.zzj();
                            objZzc3 = zzabvVar.zzc(zzabuVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZzc3 != null) {
                                zzabvVar.zzf(zzadxVar, objZzc3, zzabuVar, zzabzVarZzb);
                            } else {
                                zzabeVarZzp = zzadxVar.zzp();
                            }
                        } else if (!zzadxVar.zzO()) {
                            break;
                        }
                    }
                    if (zzadxVar.zzd() != 12) {
                        throw zzacp.zzb();
                    }
                    if (zzabeVarZzp != null) {
                        if (objZzc3 != null) {
                            zzabvVar.zzg(zzabeVarZzp, objZzc3, zzabuVar, zzabzVarZzb);
                        } else {
                            zzaepVar.zzk(objZzc, iZzj, zzabeVarZzp);
                        }
                    }
                }
            } finally {
                zzaepVar.zzn(obj, objZzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzaar zzaarVar) throws IOException {
        zzach zzachVar = (zzach) obj;
        if (zzachVar.zzc == zzaeq.zzc()) {
            zzachVar.zzc = zzaeq.zze();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzady
    public final void zzn(Object obj, zzabq zzabqVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
