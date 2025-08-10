package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p002firebaseauthapi.zzza;
import com.google.firebase.auth.internal.zzbk;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzt implements zzbk {
    public final /* synthetic */ FirebaseAuth zza;

    public zzt(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzza zzzaVar, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(zzzaVar);
        Preconditions.checkNotNull(firebaseUser);
        firebaseUser.zzh(zzzaVar);
        FirebaseAuth.zzH(this.zza, firebaseUser, zzzaVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
            this.zza.signOut();
        }
    }
}
