package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzow implements zzav {
    private final zzoy zza;
    private final String zzb;
    private final byte[] zzc;
    private final zzou zzd;

    public zzow(ECPublicKey eCPublicKey, byte[] bArr, String str, int i, zzou zzouVar) throws GeneralSecurityException {
        zzoz.zzd(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zza = new zzoy(eCPublicKey);
        this.zzc = bArr;
        this.zzb = str;
        this.zzd = zzouVar;
    }
}
