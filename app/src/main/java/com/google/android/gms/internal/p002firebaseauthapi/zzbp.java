package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbp {
    private final Class zza;
    private zzbq zzc;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private zzie zzd = zzie.zza;

    public /* synthetic */ zzbp(Class cls, zzbo zzboVar) {
        this.zza = cls;
    }

    private final zzbp zze(Object obj, zzng zzngVar, boolean z) throws GeneralSecurityException {
        byte[] bArrArray;
        if (this.zzb == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        }
        if (zzngVar.zzk() != 3) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        ConcurrentMap concurrentMap = this.zzb;
        Integer numValueOf = Integer.valueOf(zzngVar.zza());
        if (zzngVar.zze() == zzoa.RAW) {
            numValueOf = null;
        }
        zzaw zzawVarZza = zzgm.zzb().zza(zzgv.zza(zzngVar.zzb().zzf(), zzngVar.zzb().zze(), zzngVar.zzb().zzb(), zzngVar.zze(), numValueOf), zzca.zza());
        int iOrdinal = zzngVar.zze().ordinal();
        if (iOrdinal == 1) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(zzngVar.zza()).array();
        } else if (iOrdinal == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzngVar.zza()).array();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzngVar.zza()).array();
        } else {
            bArrArray = zzas.zza;
        }
        zzbq zzbqVar = new zzbq(obj, bArrArray, zzngVar.zzk(), zzngVar.zze(), zzngVar.zza(), zzawVarZza);
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzbqVar);
        zzbs zzbsVar = new zzbs(zzbqVar.zzf(), null);
        List list = (List) concurrentMap.put(zzbsVar, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(zzbqVar);
            concurrentMap.put(zzbsVar, Collections.unmodifiableList(arrayList2));
        }
        if (z) {
            if (this.zzc != null) {
                throw new IllegalStateException("you cannot set two primary primitives");
            }
            this.zzc = zzbqVar;
        }
        return this;
    }

    public final zzbp zza(Object obj, zzng zzngVar) throws GeneralSecurityException {
        zze(obj, zzngVar, true);
        return this;
    }

    public final zzbp zzb(Object obj, zzng zzngVar) throws GeneralSecurityException {
        zze(obj, zzngVar, false);
        return this;
    }

    public final zzbp zzc(zzie zzieVar) {
        if (this.zzb == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }
        this.zzd = zzieVar;
        return this;
    }

    public final zzbu zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        zzbu zzbuVar = new zzbu(concurrentMap, this.zzc, this.zzd, this.zza, null);
        this.zzb = null;
        return zzbuVar;
    }
}
