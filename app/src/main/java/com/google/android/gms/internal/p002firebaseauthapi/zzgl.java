package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzgl {
    private static final zzgl zza = new zzgl();
    private static final zzgk zzb = new zzgk(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzgl zza() {
        return zza;
    }

    public final zzig zzb() {
        zzig zzigVar = (zzig) this.zzc.get();
        return zzigVar == null ? zzb : zzigVar;
    }
}
