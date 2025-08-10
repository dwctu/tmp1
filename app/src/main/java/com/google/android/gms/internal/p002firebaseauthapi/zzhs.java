package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhs extends zzgt {
    public zzhs(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgt
    public final /* bridge */ /* synthetic */ Object zza(zzadm zzadmVar) throws GeneralSecurityException {
        zzlv zzlvVar = (zzlv) zzadmVar;
        int iZzf = zzlvVar.zzf().zzf();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzlvVar.zzg().zzt(), "HMAC");
        int iZza = zzlvVar.zzf().zza();
        int i = iZzf - 2;
        if (i == 1) {
            return new zzpq(new zzpp("HMACSHA1", secretKeySpec), iZza);
        }
        if (i == 2) {
            return new zzpq(new zzpp("HMACSHA384", secretKeySpec), iZza);
        }
        if (i == 3) {
            return new zzpq(new zzpp("HMACSHA256", secretKeySpec), iZza);
        }
        if (i == 4) {
            return new zzpq(new zzpp("HMACSHA512", secretKeySpec), iZza);
        }
        if (i == 5) {
            return new zzpq(new zzpp("HMACSHA224", secretKeySpec), iZza);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
