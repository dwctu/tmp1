package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zztm implements zzxi {
    public final /* synthetic */ zztn zza;

    public zztm(zztn zztnVar) {
        this.zza = zztnVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zza.zzb.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaal zzaalVar = (zzaal) obj;
        if (TextUtils.isEmpty(zzaalVar.zzb()) || TextUtils.isEmpty(zzaalVar.zzc())) {
            this.zza.zzb.zzh(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        zzza zzzaVar = new zzza(zzaalVar.zzc(), zzaalVar.zzb(), Long.valueOf(zzzc.zza(zzaalVar.zzb())), "Bearer");
        zztn zztnVar = this.zza;
        zztnVar.zzc.zzO(zzzaVar, null, null, Boolean.FALSE, null, zztnVar.zzb, this);
    }
}
