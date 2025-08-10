package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzabu {
    public static final zzabu zza = new zzabu(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzabu() {
        this.zzd = new HashMap();
    }

    public static zzabu zza() {
        return zza;
    }

    public final zzacf zzb(zzadm zzadmVar, int i) {
        return (zzacf) this.zzd.get(new zzabt(zzadmVar, i));
    }

    public zzabu(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
