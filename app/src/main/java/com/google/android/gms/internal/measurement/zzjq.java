package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzjq {
    public static final zzjq zza = new zzjq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzjq zzd;
    private final Map zze;

    public zzjq() {
        this.zze = new HashMap();
    }

    public static zzjq zza() {
        zzjq zzjqVar = zzd;
        if (zzjqVar != null) {
            return zzjqVar;
        }
        synchronized (zzjq.class) {
            zzjq zzjqVar2 = zzd;
            if (zzjqVar2 != null) {
                return zzjqVar2;
            }
            zzjq zzjqVarZzb = zzjy.zzb(zzjq.class);
            zzd = zzjqVarZzb;
            return zzjqVarZzb;
        }
    }

    public final zzkc zzb(zzll zzllVar, int i) {
        return (zzkc) this.zze.get(new zzjp(zzllVar, i));
    }

    public zzjq(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
