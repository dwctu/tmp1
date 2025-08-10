package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmy extends zzacd implements zzadn {
    private zzmy() {
        super(zzmz.zzb);
    }

    public final zzmy zza(zzoa zzoaVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zzmz) this.zza).zzg = zzoaVar.zza();
        return this;
    }

    public final zzmy zzb(String str) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        zzmz.zzg((zzmz) this.zza, str);
        return this;
    }

    public final zzmy zzc(zzabe zzabeVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zzmz) this.zza).zzf = zzabeVar;
        return this;
    }

    public /* synthetic */ zzmy(zzmx zzmxVar) {
        super(zzmz.zzb);
    }
}
