package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzxc {
    private final zzxd zza;
    private final TaskCompletionSource zzb;

    public zzxc(zzxd zzxdVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzxdVar;
        this.zzb = taskCompletionSource;
    }

    public final void zza(Object obj, Status status) {
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(obj);
            return;
        }
        zzxd zzxdVar = this.zza;
        if (zzxdVar.zzs != null) {
            TaskCompletionSource taskCompletionSource = this.zzb;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzxdVar.zzd);
            zzxd zzxdVar2 = this.zza;
            taskCompletionSource.setException(zzwe.zzc(firebaseAuth, zzxdVar2.zzs, ("reauthenticateWithCredential".equals(zzxdVar2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) ? this.zza.zze : null));
            return;
        }
        AuthCredential authCredential = zzxdVar.zzp;
        if (authCredential != null) {
            this.zzb.setException(zzwe.zzb(status, authCredential, zzxdVar.zzq, zzxdVar.zzr));
        } else {
            this.zzb.setException(zzwe.zza(status));
        }
    }
}
