package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzgb {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    public zzgb(Class cls, zzgt... zzgtVarArr) {
        this.zza = cls;
        HashMap map = new HashMap();
        for (int i = 0; i <= 0; i++) {
            zzgt zzgtVar = zzgtVarArr[i];
            if (map.containsKey(zzgtVar.zzb())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzgtVar.zzb().getCanonicalName())));
            }
            map.put(zzgtVar.zzb(), zzgtVar);
        }
        this.zzc = zzgtVarArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(map);
    }

    public zzga zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zzmt zzb();

    public abstract zzadm zzc(zzabe zzabeVar) throws zzacp;

    public abstract String zzd();

    public abstract void zze(zzadm zzadmVar) throws GeneralSecurityException;

    public int zzf() {
        return 1;
    }

    public final Class zzj() {
        return this.zzc;
    }

    public final Class zzk() {
        return this.zza;
    }

    public final Object zzl(zzadm zzadmVar, Class cls) throws GeneralSecurityException {
        zzgt zzgtVar = (zzgt) this.zzb.get(cls);
        if (zzgtVar != null) {
            return zzgtVar.zza(zzadmVar);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public final Set zzm() {
        return this.zzb.keySet();
    }
}
