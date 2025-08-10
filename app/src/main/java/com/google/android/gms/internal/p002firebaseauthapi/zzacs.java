package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public class zzacs {
    private static final zzabu zzb = zzabu.zza;
    public volatile zzadm zza;
    private volatile zzabe zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzacs)) {
            return false;
        }
        zzacs zzacsVar = (zzacs) obj;
        zzadm zzadmVar = this.zza;
        zzadm zzadmVar2 = zzacsVar.zza;
        if (zzadmVar == null && zzadmVar2 == null) {
            return zzb().equals(zzacsVar.zzb());
        }
        if (zzadmVar != null && zzadmVar2 != null) {
            return zzadmVar.equals(zzadmVar2);
        }
        if (zzadmVar != null) {
            zzacsVar.zzc(zzadmVar.zzH());
            return zzadmVar.equals(zzacsVar.zza);
        }
        zzc(zzadmVar2.zzH());
        return this.zza.equals(zzadmVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzabb) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzs();
        }
        return 0;
    }

    public final zzabe zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzabe.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            return this.zzc;
        }
    }

    public final void zzc(zzadm zzadmVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzadmVar;
                    this.zzc = zzabe.zzb;
                } catch (zzacp unused) {
                    this.zza = zzadmVar;
                    this.zzc = zzabe.zzb;
                }
            }
        }
    }
}
