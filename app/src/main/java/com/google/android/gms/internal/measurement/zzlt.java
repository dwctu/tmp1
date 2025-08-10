package com.google.android.gms.internal.measurement;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzlt {
    private static final zzlt zza = new zzlt();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzlx zzb = new zzld();

    private zzlt() {
    }

    public static zzlt zza() {
        return zza;
    }

    public final zzlw zzb(Class cls) {
        zzkm.zzf(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzlw zzlwVarZza = (zzlw) this.zzc.get(cls);
        if (zzlwVarZza == null) {
            zzlwVarZza = this.zzb.zza(cls);
            zzkm.zzf(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzkm.zzf(zzlwVarZza, "schema");
            zzlw zzlwVar = (zzlw) this.zzc.putIfAbsent(cls, zzlwVarZza);
            if (zzlwVar != null) {
                return zzlwVar;
            }
        }
        return zzlwVarZza;
    }
}
