package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmr extends zzacd implements zzadn {
    private zzmr() {
        super(zzmu.zzb);
    }

    public final zzmr zza(zzmt zzmtVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zzmu) this.zza).zzg = zzmtVar.zza();
        return this;
    }

    public final zzmr zzb(String str) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zzmu) this.zza).zze = str;
        return this;
    }

    public final zzmr zzc(zzabe zzabeVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zzmu) this.zza).zzf = zzabeVar;
        return this;
    }

    public /* synthetic */ zzmr(zzmq zzmqVar) {
        super(zzmu.zzb);
    }
}
