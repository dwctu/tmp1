package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzacc implements zzadk {
    private static final zzacc zza = new zzacc();

    private zzacc() {
    }

    public static zzacc zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadk
    public final zzadj zzb(Class cls) {
        if (!zzach.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzadj) zzach.zzv(cls.asSubclass(zzach.class)).zzj(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadk
    public final boolean zzc(Class cls) {
        return zzach.class.isAssignableFrom(cls);
    }
}
