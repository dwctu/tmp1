package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzgu extends zzgb {
    private final Class zza;

    @SafeVarargs
    public zzgu(Class cls, Class cls2, zzgt... zzgtVarArr) {
        super(cls, zzgtVarArr);
        this.zza = cls2;
    }

    public abstract zzadm zzg(zzadm zzadmVar) throws GeneralSecurityException;
}
