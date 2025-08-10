package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zztk implements zzxi {
    public final /* synthetic */ zzxi zza;
    public final /* synthetic */ zzza zzb;
    public final /* synthetic */ zztl zzc;

    public zztk(zztl zztlVar, zzxi zzxiVar, zzza zzzaVar) {
        this.zzc = zztlVar;
        this.zza = zzxiVar;
        this.zzb = zzzaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zzc.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listZzb = ((zzyr) obj).zzb();
        if (listZzb == null || listZzb.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzyt zzytVar = (zzyt) listZzb.get(0);
        zzzq zzzqVar = new zzzq();
        zzzqVar.zze(this.zzb.zze());
        zzzqVar.zzb(this.zzc.zza);
        zztl zztlVar = this.zzc;
        zzuh.zzf(zztlVar.zzc, zztlVar.zzb, this.zzb, zzytVar, zzzqVar, this.zza);
    }
}
