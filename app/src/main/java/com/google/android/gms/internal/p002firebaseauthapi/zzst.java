package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzst implements zzxi {
    public final /* synthetic */ zzwc zza;
    public final /* synthetic */ zzuh zzb;

    public zzst(zzuh zzuhVar, zzwc zzwcVar) {
        this.zzb = zzuhVar;
        this.zza = zzwcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzyj zzyjVar = (zzyj) obj;
        if (zzyjVar.zzg()) {
            this.zza.zzf(new zzso(zzyjVar.zzd(), zzyjVar.zzf(), null));
        } else {
            this.zzb.zzO(new zzza(zzyjVar.zze(), zzyjVar.zzc(), Long.valueOf(zzyjVar.zzb()), "Bearer"), null, null, Boolean.valueOf(zzyjVar.zzh()), null, this.zza, this);
        }
    }
}
