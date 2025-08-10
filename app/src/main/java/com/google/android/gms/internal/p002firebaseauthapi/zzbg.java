package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbg {
    public static zzbf zza(String str) throws GeneralSecurityException {
        zzbf zzbfVar = (zzbf) zzbz.zzl().get(str);
        if (zzbfVar != null) {
            return zzbfVar;
        }
        throw new GeneralSecurityException("cannot find key template: ".concat(str));
    }
}
