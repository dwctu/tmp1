package com.google.firebase.auth.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbe {
    private boolean zza;

    @Nullable
    private String zzb;

    private zzbe() {
    }

    @Nullable
    public static zzbe zza(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map mapZzb = zzaz.zzb(str);
        try {
            zzbe zzbeVar = new zzbe();
            Object obj = mapZzb.get("basicIntegrity");
            boolean z = false;
            if (obj != null && ((Boolean) obj).booleanValue()) {
                z = true;
            }
            zzbeVar.zza = z;
            String str2 = (String) mapZzb.get("advice");
            if (str2 == null) {
                str2 = "";
            }
            zzbeVar.zzb = str2;
            return zzbeVar;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zza;
    }
}
