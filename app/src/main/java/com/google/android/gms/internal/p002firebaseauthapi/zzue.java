package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzue implements zzxi {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzwc zzb;
    public final /* synthetic */ zzuh zzc;

    public zzue(zzuh zzuhVar, String str, zzwc zzwcVar) {
        this.zzc = zzuhVar;
        this.zza = str;
        this.zzb = zzwcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzza zzzaVar = (zzza) obj;
        String strZze = zzzaVar.zze();
        zzzq zzzqVar = new zzzq();
        zzzqVar.zze(strZze);
        zzzqVar.zzg(this.zza);
        zzuh.zze(this.zzc, this.zzb, zzzaVar, zzzqVar, this);
    }
}
