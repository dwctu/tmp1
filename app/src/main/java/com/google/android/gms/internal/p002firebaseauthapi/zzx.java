package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzx {
    private static final Logger zza = Logger.getLogger(zzx.class.getName());
    private static final zzw zzb = new zzw(null);

    private zzx() {
    }

    public static zzq zza(String str) {
        return new zzt(Pattern.compile("[.-]"));
    }

    public static String zzb(String str) {
        return str == null ? "" : str;
    }

    public static boolean zzc(String str) {
        return str == null || str.isEmpty();
    }
}
