package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zztg implements zzxi {
    public final /* synthetic */ zzaai zza;
    public final /* synthetic */ zzwc zzb;
    public final /* synthetic */ zzuh zzc;

    public zztg(zzuh zzuhVar, zzaai zzaaiVar, zzwc zzwcVar) {
        this.zzc = zzuhVar;
        this.zza = zzaaiVar;
        this.zzb = zzwcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzd(((zzza) obj).zze());
        this.zzc.zza.zzt(this.zza, new zztf(this, this));
    }
}
