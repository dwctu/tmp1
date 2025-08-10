package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzil {
    private final zzie zza;
    private final List zzb;
    private final Integer zzc;

    public /* synthetic */ zzil(zzie zzieVar, List list, Integer num, zzik zzikVar) {
        this.zza = zzieVar;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzil)) {
            return false;
        }
        zzil zzilVar = (zzil) obj;
        if (this.zza.equals(zzilVar.zza) && this.zzb.equals(zzilVar.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzilVar.zzc;
            if (num == num2) {
                return true;
            }
            if (num != null && num.equals(num2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.zza, this.zzb, this.zzc);
    }
}
