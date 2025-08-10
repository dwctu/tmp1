package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public abstract class zzs {
    public abstract zzs zza(@SplitInstallErrorCode int i);

    public abstract zzs zzb(Map map);

    public abstract zzt zzc();

    public abstract Map zzd();

    public final zzt zze() {
        zzb(Collections.unmodifiableMap(zzd()));
        return zzc();
    }
}
