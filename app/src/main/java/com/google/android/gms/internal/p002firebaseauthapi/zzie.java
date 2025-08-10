package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzie {
    public static final zzie zza = new zzic().zza();
    private final Map zzb;

    public final boolean equals(Object obj) {
        if (obj instanceof zzie) {
            return this.zzb.equals(((zzie) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
