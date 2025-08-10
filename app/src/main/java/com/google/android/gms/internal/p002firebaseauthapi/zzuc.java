package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzuc implements zzxi {
    public final /* synthetic */ UserProfileChangeRequest zza;
    public final /* synthetic */ zzwc zzb;
    public final /* synthetic */ zzuh zzc;

    public zzuc(zzuh zzuhVar, UserProfileChangeRequest userProfileChangeRequest, zzwc zzwcVar) {
        this.zzc = zzuhVar;
        this.zza = userProfileChangeRequest;
        this.zzb = zzwcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzza zzzaVar = (zzza) obj;
        zzzq zzzqVar = new zzzq();
        zzzqVar.zze(zzzaVar.zze());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzzqVar.zzc(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzzqVar.zzh(this.zza.zza());
        }
        zzuh.zze(this.zzc, this.zzb, zzzaVar, zzzqVar, this);
    }
}
