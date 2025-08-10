package com.google.android.play.core.assetpacks;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzco {
    private final Map zza = new HashMap();

    public final synchronized double zza(String str) {
        Double d = (Double) this.zza.get(str);
        if (d == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return d.doubleValue();
    }

    public final synchronized double zzb(String str, zzdg zzdgVar) {
        double d;
        d = (((zzce) zzdgVar).zzf + 1.0d) / ((zzce) zzdgVar).zzg;
        this.zza.put(str, Double.valueOf(d));
        return d;
    }

    public final synchronized void zzc(String str) {
        this.zza.put(str, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }
}
