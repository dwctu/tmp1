package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzia implements zzbv {
    private static final Logger zza = Logger.getLogger(zzia.class.getName());
    private static final byte[] zzb = {0};

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final Class zza() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final Class zzb() {
        return zzbm.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final /* bridge */ /* synthetic */ Object zzc(zzbu zzbuVar) throws GeneralSecurityException {
        Iterator it = zzbuVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzbq zzbqVar : (List) it.next()) {
                if (zzbqVar.zzb() instanceof zzhw) {
                    zzhw zzhwVar = (zzhw) zzbqVar.zzb();
                    zzpx zzpxVarZzb = zzpx.zzb(zzbqVar.zzf());
                    if (!zzpxVarZzb.equals(zzhwVar.zzd())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + zzhwVar.zzc().toString() + " has wrong output prefix (" + zzhwVar.zzd().toString() + ") instead of (" + zzpxVarZzb.toString() + ")");
                    }
                }
            }
        }
        return new zzhz(zzbuVar, null);
    }
}
