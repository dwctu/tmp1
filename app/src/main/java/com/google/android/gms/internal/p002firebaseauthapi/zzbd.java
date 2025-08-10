package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbd {
    private static final Logger zza = Logger.getLogger(zzbd.class.getName());
    private final ConcurrentMap zzb;

    public zzbd() {
        this.zzb = new ConcurrentHashMap();
    }

    private final zzax zzg(String str, Class cls) throws GeneralSecurityException {
        zzbc zzbcVarZzh = zzh(str);
        if (cls == null) {
            return zzbcVarZzh.zzb();
        }
        if (zzbcVarZzh.zze().contains(cls)) {
            return zzbcVarZzh.zza(cls);
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzbcVarZzh.zzc());
        Set<Class> setZze = zzbcVarZzh.zze();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class cls2 : setZze) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + strValueOf + ", supported primitives: " + sb.toString());
    }

    private final synchronized zzbc zzh(String str) throws GeneralSecurityException {
        if (!this.zzb.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzbc) this.zzb.get(str);
    }

    private final synchronized void zzi(zzbc zzbcVar, boolean z) throws GeneralSecurityException {
        String strZze = zzbcVar.zzb().zze();
        zzbc zzbcVar2 = (zzbc) this.zzb.get(strZze);
        if (zzbcVar2 != null && !zzbcVar2.zzc().equals(zzbcVar.zzc())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(strZze));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZze, zzbcVar2.zzc().getName(), zzbcVar.zzc().getName()));
        }
        if (z) {
            this.zzb.put(strZze, zzbcVar);
        } else {
            this.zzb.putIfAbsent(strZze, zzbcVar);
        }
    }

    @Deprecated
    public final zzax zza(String str) throws GeneralSecurityException {
        return zzg(str, null);
    }

    public final zzax zzb(String str, Class cls) throws GeneralSecurityException {
        return zzg(str, cls);
    }

    public final zzax zzc(String str) throws GeneralSecurityException {
        return zzh(str).zzb();
    }

    public final synchronized void zzd(zzgu zzguVar, zzgb zzgbVar) throws GeneralSecurityException {
        Class clsZzd;
        int iZzf = zzgbVar.zzf();
        if (!zzdv.zza(1)) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzguVar.getClass()) + " as it is not FIPS compatible.");
        }
        if (!zzdv.zza(iZzf)) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzgbVar.getClass()) + " as it is not FIPS compatible.");
        }
        String strZzd = zzguVar.zzd();
        String strZzd2 = zzgbVar.zzd();
        if (this.zzb.containsKey(strZzd) && ((zzbc) this.zzb.get(strZzd)).zzd() != null && (clsZzd = ((zzbc) this.zzb.get(strZzd)).zzd()) != null && !clsZzd.getName().equals(zzgbVar.getClass().getName())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + strZzd + " with inconsistent public key type " + strZzd2);
            throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzguVar.getClass().getName(), clsZzd.getName(), zzgbVar.getClass().getName()));
        }
        zzi(new zzbb(zzguVar, zzgbVar), true);
        zzi(new zzba(zzgbVar), false);
    }

    public final synchronized void zze(zzgb zzgbVar) throws GeneralSecurityException {
        if (!zzdv.zza(zzgbVar.zzf())) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzgbVar.getClass()) + " as it is not FIPS compatible.");
        }
        zzi(new zzba(zzgbVar), false);
    }

    public final boolean zzf(String str) {
        return this.zzb.containsKey(str);
    }

    public zzbd(zzbd zzbdVar) {
        this.zzb = new ConcurrentHashMap(zzbdVar.zzb);
    }
}
