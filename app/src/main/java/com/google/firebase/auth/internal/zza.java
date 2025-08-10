package com.google.firebase.auth.internal;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zza implements OnFailureListener {
    public final /* synthetic */ FirebaseAuth zza;
    public final /* synthetic */ zzbm zzb;
    public final /* synthetic */ Activity zzc;
    public final /* synthetic */ TaskCompletionSource zzd;
    public final /* synthetic */ zzf zze;

    public zza(zzf zzfVar, FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        this.zze = zzfVar;
        this.zza = firebaseAuth;
        this.zzb = zzbmVar;
        this.zzc = activity;
        this.zzd = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@NonNull Exception exc) {
        String unused = zzf.zza;
        "Problem retrieving SafetyNet Token: ".concat(String.valueOf(exc.getMessage()));
        this.zze.zze(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
