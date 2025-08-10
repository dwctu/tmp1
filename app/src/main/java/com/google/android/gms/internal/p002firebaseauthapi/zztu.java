package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zztu implements zzxi {
    public final /* synthetic */ zzxi zza;
    public final /* synthetic */ zzza zzb;
    public final /* synthetic */ zztv zzc;

    public zztu(zztv zztvVar, zzxi zzxiVar, zzza zzzaVar) {
        this.zzc = zztvVar;
        this.zza = zzxiVar;
        this.zzb = zzzaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listZzb = ((zzyr) obj).zzb();
        if (listZzb == null || listZzb.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zzi(this.zzb, (zzyt) listZzb.get(0));
        }
    }
}
