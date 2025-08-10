package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzte implements zzxi {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzwc zzc;
    public final /* synthetic */ zzuh zzd;

    public zzte(zzuh zzuhVar, String str, String str2, zzwc zzwcVar) {
        this.zzd = zzuhVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzwcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzza zzzaVar = (zzza) obj;
        zzzq zzzqVar = new zzzq();
        zzzqVar.zze(zzzaVar.zze());
        zzzqVar.zzd(this.zza);
        zzzqVar.zzg(this.zzb);
        zzuh.zze(this.zzd, this.zzc, zzzaVar, zzzqVar, this);
    }
}
