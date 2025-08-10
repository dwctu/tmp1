package com.google.android.gms.internal.p002firebaseauthapi;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzge extends zzbn {
    private final String zza;
    private final zzoa zzb;

    public /* synthetic */ zzge(String str, zzoa zzoaVar, zzgd zzgdVar) {
        this.zza = str;
        this.zzb = zzoaVar;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.zza;
        zzoa zzoaVar = this.zzb;
        zzmt zzmtVar = zzmt.UNKNOWN_KEYMATERIAL;
        zzoa zzoaVar2 = zzoa.UNKNOWN_PREFIX;
        int iOrdinal = zzoaVar.ordinal();
        objArr[1] = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }
}
