package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p002firebaseauthapi.zzza;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@VisibleForTesting
/* loaded from: classes2.dex */
public class zzs implements com.google.firebase.auth.internal.zzg {
    public final /* synthetic */ FirebaseAuth zza;

    public zzs(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzza zzzaVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzzaVar);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzzaVar);
        this.zza.zzE(firebaseUser, zzzaVar, true);
    }
}
