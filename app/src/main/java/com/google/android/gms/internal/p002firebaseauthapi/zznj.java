package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zznj extends zzacd implements zzadn {
    private zznj() {
        super(zznm.zzb);
    }

    public final zznj zza(zznl zznlVar) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        zznm.zze((zznm) this.zza, zznlVar);
        return this;
    }

    public final zznj zzb(int i) {
        if (this.zzb) {
            zzo();
            this.zzb = false;
        }
        ((zznm) this.zza).zze = i;
        return this;
    }

    public /* synthetic */ zznj(zzni zzniVar) {
        super(zznm.zzb);
    }
}
