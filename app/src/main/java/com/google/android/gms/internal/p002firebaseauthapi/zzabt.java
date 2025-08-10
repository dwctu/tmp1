package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzabt {
    private final Object zza;
    private final int zzb;

    public zzabt(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzabt)) {
            return false;
        }
        zzabt zzabtVar = (zzabt) obj;
        return this.zza == zzabtVar.zza && this.zzb == zzabtVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
