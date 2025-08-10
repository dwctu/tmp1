package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzic {
    private HashMap zza = new HashMap();

    public final zzie zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzie zzieVar = new zzie(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzieVar;
    }
}
