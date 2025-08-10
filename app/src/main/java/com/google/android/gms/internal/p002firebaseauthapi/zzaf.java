package com.google.android.gms.internal.p002firebaseauthapi;

import com.broadcom.bt.util.io.FilenameUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaf {
    private final zzn zza;
    private final zzae zzb;

    private zzaf(zzae zzaeVar) {
        zzm zzmVar = zzm.zza;
        this.zzb = zzaeVar;
        this.zza = zzmVar;
    }

    public static zzaf zzb(char c) {
        return new zzaf(new zzaa(new zzk(FilenameUtils.EXTENSION_SEPARATOR)));
    }

    public static zzaf zzc(String str) {
        zzq zzqVarZza = zzx.zza("[.-]");
        if (!((zzs) zzqVarZza.zza("")).zza.matches()) {
            return new zzaf(new zzac(zzqVarZza));
        }
        throw new IllegalArgumentException(zzag.zzb("The pattern may not match the empty string: %s", zzqVarZza));
    }

    public final List zzd(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Iterator itZza = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (itZza.hasNext()) {
            arrayList.add((String) itZza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
