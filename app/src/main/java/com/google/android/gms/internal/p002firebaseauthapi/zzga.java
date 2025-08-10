package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzga {
    private final Class zza;

    public zzga(Class cls) {
        this.zza = cls;
    }

    public abstract zzadm zza(zzadm zzadmVar) throws GeneralSecurityException;

    public abstract zzadm zzb(zzabe zzabeVar) throws zzacp;

    public Map zzc() throws GeneralSecurityException {
        return Collections.emptyMap();
    }

    public abstract void zzd(zzadm zzadmVar) throws GeneralSecurityException;

    public final Class zzg() {
        return this.zza;
    }
}
