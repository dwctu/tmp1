package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzlu extends zzacd implements zzadn {
    private zzlu() {
        super(zzlv.zzb);
    }

    public final zzlu zza(zzabe zzabeVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zzlv) this.zza).zzg = zzabeVar;
        return this;
    }

    public final zzlu zzb(zzmb zzmbVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        zzlv.zzi((zzlv) this.zza, zzmbVar);
        return this;
    }

    public final zzlu zzc(int i) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zzlv) this.zza).zze = 0;
        return this;
    }

    public /* synthetic */ zzlu(zzlt zzltVar) {
        super(zzlv.zzb);
    }
}
