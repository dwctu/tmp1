package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zztq implements zzxi {
    public final /* synthetic */ zztr zza;

    public zztq(zztr zztrVar) {
        this.zza = zztrVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zza.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzyl zzylVar = (zzyl) obj;
        zzza zzzaVar = new zzza(zzylVar.zzc(), zzylVar.zzb(), Long.valueOf(zzzc.zza(zzylVar.zzb())), "Bearer");
        zztr zztrVar = this.zza;
        zztrVar.zzc.zzO(zzzaVar, null, null, Boolean.FALSE, null, zztrVar.zzb, this);
    }
}
