package com.google.firebase.auth.internal;

import android.app.Activity;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzb implements OnSuccessListener {
    public final /* synthetic */ TaskCompletionSource zza;
    public final /* synthetic */ FirebaseAuth zzb;
    public final /* synthetic */ zzbm zzc;
    public final /* synthetic */ Activity zzd;
    public final /* synthetic */ zzf zze;

    public zzb(zzf zzfVar, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzbm zzbmVar, Activity activity) {
        this.zze = zzfVar;
        this.zza = taskCompletionSource;
        this.zzb = firebaseAuth;
        this.zzc = zzbmVar;
        this.zzd = activity;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        SafetyNetApi.AttestationResponse attestationResponse = (SafetyNetApi.AttestationResponse) obj;
        if (zzbf.zza(attestationResponse)) {
            this.zza.setResult(new zze(attestationResponse.getJwsResult(), null));
        } else {
            this.zze.zze(this.zzb, this.zzc, this.zzd, this.zza);
        }
    }
}
