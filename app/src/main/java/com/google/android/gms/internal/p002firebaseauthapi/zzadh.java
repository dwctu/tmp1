package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzadh {
    public static final int zza(int i, Object obj, Object obj2) {
        zzadg zzadgVar = (zzadg) obj;
        if (zzadgVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzadgVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean zzb(Object obj) {
        return !((zzadg) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzadg zzadgVarZzb = (zzadg) obj;
        zzadg zzadgVar = (zzadg) obj2;
        if (!zzadgVar.isEmpty()) {
            if (!zzadgVarZzb.zze()) {
                zzadgVarZzb = zzadgVarZzb.zzb();
            }
            zzadgVarZzb.zzd(zzadgVar);
        }
        return zzadgVarZzb;
    }
}
