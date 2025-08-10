package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbz {
    private static final Logger zza = Logger.getLogger(zzbz.class.getName());
    private static final AtomicReference zzb = new AtomicReference(new zzbd());
    private static final ConcurrentMap zzc = new ConcurrentHashMap();
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private static final ConcurrentMap zze = new ConcurrentHashMap();
    private static final ConcurrentMap zzf = new ConcurrentHashMap();
    private static final ConcurrentMap zzg = new ConcurrentHashMap();

    private zzbz() {
    }

    @Deprecated
    public static zzax zza(String str) throws GeneralSecurityException {
        return ((zzbd) zzb.get()).zza(str);
    }

    public static zzax zzb(String str) throws GeneralSecurityException {
        return ((zzbd) zzb.get()).zzc(str);
    }

    public static synchronized zzmu zzc(zzmz zzmzVar) throws GeneralSecurityException {
        zzax zzaxVarZzb;
        zzaxVarZzb = zzb(zzmzVar.zzf());
        if (!((Boolean) zzd.get(zzmzVar.zzf())).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzmzVar.zzf())));
        }
        return zzaxVarZzb.zza(zzmzVar.zze());
    }

    public static synchronized zzadm zzd(zzmz zzmzVar) throws GeneralSecurityException {
        zzax zzaxVarZzb;
        zzaxVarZzb = zzb(zzmzVar.zzf());
        if (!((Boolean) zzd.get(zzmzVar.zzf())).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzmzVar.zzf())));
        }
        return zzaxVarZzb.zzb(zzmzVar.zze());
    }

    public static Class zze(Class cls) {
        zzbv zzbvVar = (zzbv) zzf.get(cls);
        if (zzbvVar == null) {
            return null;
        }
        return zzbvVar.zza();
    }

    @Deprecated
    public static Object zzf(zzmu zzmuVar) throws GeneralSecurityException {
        String strZzf = zzmuVar.zzf();
        return ((zzbd) zzb.get()).zza(strZzf).zzc(zzmuVar.zze());
    }

    public static Object zzg(zzmu zzmuVar, Class cls) throws GeneralSecurityException {
        return zzh(zzmuVar.zzf(), zzmuVar.zze(), cls);
    }

    public static Object zzh(String str, zzabe zzabeVar, Class cls) throws GeneralSecurityException {
        return ((zzbd) zzb.get()).zzb(str, cls).zzc(zzabeVar);
    }

    public static Object zzi(String str, zzadm zzadmVar, Class cls) throws GeneralSecurityException {
        return ((zzbd) zzb.get()).zzb(str, cls).zzd(zzadmVar);
    }

    public static Object zzj(String str, byte[] bArr, Class cls) throws GeneralSecurityException {
        return zzh(str, zzabe.zzn(bArr), cls);
    }

    public static Object zzk(zzbu zzbuVar, Class cls) throws GeneralSecurityException {
        zzbv zzbvVar = (zzbv) zzf.get(cls);
        if (zzbvVar == null) {
            throw new GeneralSecurityException("No wrapper found for ".concat(String.valueOf(zzbuVar.zzc().getName())));
        }
        if (zzbvVar.zza().equals(zzbuVar.zzc())) {
            return zzbvVar.zzc(zzbuVar);
        }
        throw new GeneralSecurityException("Wrong input primitive class, expected " + zzbvVar.zza().toString() + ", got " + zzbuVar.zzc().toString());
    }

    public static synchronized Map zzl() {
        return Collections.unmodifiableMap(zzg);
    }

    public static synchronized void zzm(zzgu zzguVar, zzgb zzgbVar, boolean z) throws GeneralSecurityException {
        AtomicReference atomicReference = zzb;
        zzbd zzbdVar = new zzbd((zzbd) atomicReference.get());
        zzbdVar.zzd(zzguVar, zzgbVar);
        String strZzd = zzguVar.zzd();
        String strZzd2 = zzgbVar.zzd();
        zzp(strZzd, zzguVar.zza().zzc(), true);
        zzp(strZzd2, Collections.emptyMap(), false);
        if (!((zzbd) atomicReference.get()).zzf(strZzd)) {
            zzc.put(strZzd, new zzby(zzguVar));
            zzq(zzguVar.zzd(), zzguVar.zza().zzc());
        }
        ConcurrentMap concurrentMap = zzd;
        concurrentMap.put(strZzd, Boolean.TRUE);
        concurrentMap.put(strZzd2, Boolean.FALSE);
        atomicReference.set(zzbdVar);
    }

    public static synchronized void zzn(zzgb zzgbVar, boolean z) throws GeneralSecurityException {
        AtomicReference atomicReference = zzb;
        zzbd zzbdVar = new zzbd((zzbd) atomicReference.get());
        zzbdVar.zze(zzgbVar);
        String strZzd = zzgbVar.zzd();
        zzp(strZzd, zzgbVar.zza().zzc(), true);
        if (!((zzbd) atomicReference.get()).zzf(strZzd)) {
            zzc.put(strZzd, new zzby(zzgbVar));
            zzq(strZzd, zzgbVar.zza().zzc());
        }
        zzd.put(strZzd, Boolean.TRUE);
        atomicReference.set(zzbdVar);
    }

    public static synchronized void zzo(zzbv zzbvVar) throws GeneralSecurityException {
        if (zzbvVar == null) {
            throw new IllegalArgumentException("wrapper must be non-null");
        }
        Class clsZzb = zzbvVar.zzb();
        ConcurrentMap concurrentMap = zzf;
        if (concurrentMap.containsKey(clsZzb)) {
            zzbv zzbvVar2 = (zzbv) concurrentMap.get(clsZzb);
            if (!zzbvVar.getClass().getName().equals(zzbvVar2.getClass().getName())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", "Attempted overwrite of a registered PrimitiveWrapper for type ".concat(clsZzb.toString()));
                throw new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", clsZzb.getName(), zzbvVar2.getClass().getName(), zzbvVar.getClass().getName()));
            }
        }
        concurrentMap.put(clsZzb, zzbvVar);
    }

    private static synchronized void zzp(String str, Map map, boolean z) throws GeneralSecurityException {
        if (z) {
            ConcurrentMap concurrentMap = zzd;
            if (concurrentMap.containsKey(str) && !((Boolean) concurrentMap.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
            if (((zzbd) zzb.get()).zzf(str)) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!zzg.containsKey(entry.getKey())) {
                        throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                    }
                }
            } else {
                for (Map.Entry entry2 : map.entrySet()) {
                    if (zzg.containsKey(entry2.getKey())) {
                        throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.gms.internal.firebase-auth-api.zzadm, java.lang.Object] */
    private static void zzq(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzg.put((String) entry.getKey(), zzbf.zze(str, ((zzfz) entry.getValue()).zza.zzr(), ((zzfz) entry.getValue()).zzb));
        }
    }
}
