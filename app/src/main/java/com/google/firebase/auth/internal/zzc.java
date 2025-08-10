package com.google.firebase.auth.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzc implements OnFailureListener {
    public final /* synthetic */ TaskCompletionSource zza;

    public zzc(zzf zzfVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@NonNull Exception exc) {
        String unused = zzf.zza;
        String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", exc.getMessage());
        this.zza.setResult(new zze(null, null));
    }
}
