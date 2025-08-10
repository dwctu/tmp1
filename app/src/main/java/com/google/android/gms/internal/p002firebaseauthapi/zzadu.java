package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzadu {
    private static final zzadu zza = new zzadu();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzadz zzb = new zzade();

    private zzadu() {
    }

    public static zzadu zza() {
        return zza;
    }

    public final zzady zzb(Class cls) {
        zzacn.zzf(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzady zzadyVarZza = (zzady) this.zzc.get(cls);
        if (zzadyVarZza == null) {
            zzadyVarZza = this.zzb.zza(cls);
            zzacn.zzf(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            zzacn.zzf(zzadyVarZza, "schema");
            zzady zzadyVar = (zzady) this.zzc.putIfAbsent(cls, zzadyVarZza);
            if (zzadyVar != null) {
                return zzadyVar;
            }
        }
        return zzadyVarZza;
    }
}
