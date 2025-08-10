package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zznk extends zzacd implements zzadn {
    private zznk() {
        super(zznl.zzb);
    }

    public final zznk zza(int i) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zznl) this.zza).zzg = i;
        return this;
    }

    public final zznk zzb(zzoa zzoaVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zznl) this.zza).zzh = zzoaVar.zza();
        return this;
    }

    public final zznk zzc(String str) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        zznl.zzd((zznl) this.zza, str);
        return this;
    }

    public final zznk zzd(int i) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zznl) this.zza).zzf = zzmw.zza(i);
        return this;
    }

    public /* synthetic */ zznk(zzni zzniVar) {
        super(zznl.zzb);
    }
}
