package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzp implements OnCompleteListener {
    public final /* synthetic */ PhoneAuthOptions zza;
    public final /* synthetic */ FirebaseAuth zzb;

    public zzp(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions) {
        this.zzb = firebaseAuth;
        this.zza = phoneAuthOptions;
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
            if (task.getException() != null) {
                "Error while validating application identity: ".concat(String.valueOf(task.getException().getMessage()));
            }
            str = null;
            strZza = null;
        }
        long jLongValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZzL = this.zzb.zzL(this.zza.zzh(), this.zza.zze());
        com.google.firebase.auth.internal.zzag zzagVar = (com.google.firebase.auth.internal.zzag) Preconditions.checkNotNull(this.zza.zzc());
        if (zzagVar.zze()) {
            this.zzb.zze.zzD(zzagVar, (String) Preconditions.checkNotNull(this.zza.zzh()), this.zzb.zzi, jLongValue, this.zza.zzd() != null, this.zza.zzj(), str, strZza, this.zzb.zzK(), onVerificationStateChangedCallbacksZzL, this.zza.zzi(), this.zza.zza());
        } else {
            this.zzb.zze.zzE(zzagVar, (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf()), this.zzb.zzi, jLongValue, this.zza.zzd() != null, this.zza.zzj(), str, strZza, this.zzb.zzK(), onVerificationStateChangedCallbacksZzL, this.zza.zzi(), this.zza.zza());
        }
    }
}
