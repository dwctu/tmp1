package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzsr implements zzxi {
    public final /* synthetic */ zzwc zza;
    public final /* synthetic */ zzuh zzb;

    public zzsr(zzuh zzuhVar, zzwc zzwcVar) {
        this.zzb = zzuhVar;
        this.zza = zzwcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zza.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaah zzaahVar = (zzaah) obj;
        if (zzaahVar.zzg()) {
            this.zza.zzf(new zzso(zzaahVar.zzd(), zzaahVar.zzf(), null));
        } else {
            this.zzb.zzO(new zzza(zzaahVar.zze(), zzaahVar.zzc(), Long.valueOf(zzaahVar.zzb()), "Bearer"), null, null, Boolean.FALSE, null, this.zza, this);
        }
    }
}
