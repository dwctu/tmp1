package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzwn {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzwn";

    private zzwn() {
    }

    public static Object zza(String str, Type type) throws zzui {
        if (type == String.class) {
            try {
                zzyd zzydVar = new zzyd();
                zzydVar.zzb(str);
                if (zzydVar.zzd()) {
                    return zzydVar.zzc();
                }
                throw new zzui("No error message: " + str);
            } catch (Exception e) {
                throw new zzui("Json conversion failed! ".concat(String.valueOf(e.getMessage())), e);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            zzwp zzwpVar = (zzwp) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                zzwpVar.zza(str);
                return zzwpVar;
            } catch (Exception e2) {
                throw new zzui("Json conversion failed! ".concat(String.valueOf(e2.getMessage())), e2);
            }
        } catch (Exception e3) {
            throw new zzui("Instantiation of JsonResponse failed! ".concat(type.toString()), e3);
        }
    }
}
