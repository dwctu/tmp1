package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzsu implements zzxi {
    public final /* synthetic */ zzxh zza;
    public final /* synthetic */ zzwc zzb;
    public final /* synthetic */ zzza zzc;
    public final /* synthetic */ zzzq zzd;
    public final /* synthetic */ zzuh zze;

    public zzsu(zzuh zzuhVar, zzxh zzxhVar, zzwc zzwcVar, zzza zzzaVar, zzzq zzzqVar) {
        this.zze = zzuhVar;
        this.zza = zzxhVar;
        this.zzb = zzwcVar;
        this.zzc = zzzaVar;
        this.zzd = zzzqVar;
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
            zzuh.zzf(this.zze, this.zzb, this.zzc, (zzyt) listZzb.get(0), this.zzd, this.zza);
        }
    }
}
