package com.google.firebase.auth;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzo implements OnCompleteListener {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ TimeUnit zzc;
    public final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zzd;
    public final /* synthetic */ Activity zze;
    public final /* synthetic */ Executor zzf;
    public final /* synthetic */ boolean zzg;
    public final /* synthetic */ FirebaseAuth zzh;

    public zzo(FirebaseAuth firebaseAuth, String str, long j, TimeUnit timeUnit, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z) {
        this.zzh = firebaseAuth;
        this.zza = str;
        this.zzb = j;
        this.zzc = timeUnit;
        this.zzd = onVerificationStateChangedCallbacks;
        this.zze = activity;
        this.zzf = executor;
        this.zzg = z;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        String strZza;
        String str;
        if (task.isSuccessful()) {
            String strZzb = ((com.google.firebase.auth.internal.zze) task.getResult()).zzb();
            strZza = ((com.google.firebase.auth.internal.zze) task.getResult()).zza();
            str = strZzb;
        } else {
            "Error while validating application identity: ".concat(String.valueOf(task.getException() != null ? task.getException().getMessage() : ""));
            strZza = null;
            str = null;
        }
        this.zzh.zzJ(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, strZza, str);
    }
}
