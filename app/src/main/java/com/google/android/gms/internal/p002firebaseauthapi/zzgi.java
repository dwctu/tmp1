package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzgi {
    public static final zzif zza = new zzgh(null);

    public static zzil zza(zzbu zzbuVar) {
        zzbe zzbeVar;
        zzih zzihVar = new zzih();
        zzihVar.zzb(zzbuVar.zzb());
        Iterator it = zzbuVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzbq zzbqVar : (List) it.next()) {
                int iZzg = zzbqVar.zzg() - 2;
                if (iZzg == 1) {
                    zzbeVar = zzbe.zza;
                } else if (iZzg == 2) {
                    zzbeVar = zzbe.zzb;
                } else {
                    if (iZzg != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzbeVar = zzbe.zzc;
                }
                zzihVar.zza(zzbeVar, zzbqVar.zza(), zzbqVar.zzc());
            }
        }
        if (zzbuVar.zza() != null) {
            zzihVar.zzc(zzbuVar.zza().zza());
        }
        try {
            return zzihVar.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
