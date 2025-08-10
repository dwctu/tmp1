package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzgy {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    public zzgy() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgy zza(zzfv zzfvVar) throws GeneralSecurityException {
        zzha zzhaVar = new zzha(zzfvVar.zzd(), zzfvVar.zzc(), null);
        if (this.zzb.containsKey(zzhaVar)) {
            zzfv zzfvVar2 = (zzfv) this.zzb.get(zzhaVar);
            if (!zzfvVar2.equals(zzfvVar) || !zzfvVar.equals(zzfvVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzhaVar.toString()));
            }
        } else {
            this.zzb.put(zzhaVar, zzfvVar);
        }
        return this;
    }

    public final zzgy zzb(zzfy zzfyVar) throws GeneralSecurityException {
        zzhc zzhcVar = new zzhc(zzfyVar.zza(), zzfyVar.zzb(), null);
        if (this.zza.containsKey(zzhcVar)) {
            zzfy zzfyVar2 = (zzfy) this.zza.get(zzhcVar);
            if (!zzfyVar2.equals(zzfyVar) || !zzfyVar.equals(zzfyVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzhcVar.toString()));
            }
        } else {
            this.zza.put(zzhcVar, zzfyVar);
        }
        return this;
    }

    public final zzgy zzc(zzgp zzgpVar) throws GeneralSecurityException {
        zzha zzhaVar = new zzha(zzgpVar.zzb(), zzgpVar.zza(), null);
        if (this.zzd.containsKey(zzhaVar)) {
            zzgp zzgpVar2 = (zzgp) this.zzd.get(zzhaVar);
            if (!zzgpVar2.equals(zzgpVar) || !zzgpVar.equals(zzgpVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzhaVar.toString()));
            }
        } else {
            this.zzd.put(zzhaVar, zzgpVar);
        }
        return this;
    }

    public final zzgy zzd(zzgs zzgsVar) throws GeneralSecurityException {
        zzhc zzhcVar = new zzhc(zzgsVar.zza(), zzgsVar.zzb(), null);
        if (this.zzc.containsKey(zzhcVar)) {
            zzgs zzgsVar2 = (zzgs) this.zzc.get(zzhcVar);
            if (!zzgsVar2.equals(zzgsVar) || !zzgsVar.equals(zzgsVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzhcVar.toString()));
            }
        } else {
            this.zzc.put(zzhcVar, zzgsVar);
        }
        return this;
    }

    public zzgy(zzhe zzheVar) {
        this.zza = new HashMap(zzheVar.zza);
        this.zzb = new HashMap(zzheVar.zzb);
        this.zzc = new HashMap(zzheVar.zzc);
        this.zzd = new HashMap(zzheVar.zzd);
    }
}
