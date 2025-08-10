package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzwe;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzav extends BroadcastReceiver {
    public final /* synthetic */ zzax zza;
    private final WeakReference zzb;
    private final TaskCompletionSource zzc;
    private final FirebaseAuth zzd;
    private final FirebaseUser zze;

    public zzav(zzax zzaxVar, Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zza = zzaxVar;
        this.zzb = new WeakReference(activity);
        this.zzc = taskCompletionSource;
        this.zzd = firebaseAuth;
        this.zze = firebaseUser;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.zzb.get()) == null) {
            this.zzc.setException(zzwe.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zze(context);
            return;
        }
        if (!intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            if (zzbl.zzd(intent)) {
                this.zzc.setException(zzwe.zza(zzbl.zza(intent)));
                zzax.zze(context);
                return;
            } else {
                if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
                    this.zzc.setException(zzwe.zza(zzai.zza("WEB_CONTEXT_CANCELED")));
                    zzax.zze(context);
                    return;
                }
                return;
            }
        }
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
            zzax zzaxVar = this.zza;
            TaskCompletionSource taskCompletionSource = this.zzc;
            this.zzd.signInWithCredential(zzax.zzi(intent)).addOnSuccessListener(new zzaq(zzaxVar, taskCompletionSource, context)).addOnFailureListener(new zzap(zzaxVar, taskCompletionSource, context));
            return;
        }
        if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
            zzax zzaxVar2 = this.zza;
            TaskCompletionSource taskCompletionSource2 = this.zzc;
            this.zze.linkWithCredential(zzax.zzi(intent)).addOnSuccessListener(new zzas(zzaxVar2, taskCompletionSource2, context)).addOnFailureListener(new zzar(zzaxVar2, taskCompletionSource2, context));
        } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
            zzax zzaxVar3 = this.zza;
            TaskCompletionSource taskCompletionSource3 = this.zzc;
            this.zze.reauthenticateAndRetrieveData(zzax.zzi(intent)).addOnSuccessListener(new zzau(zzaxVar3, taskCompletionSource3, context)).addOnFailureListener(new zzat(zzaxVar3, taskCompletionSource3, context));
        } else {
            this.zzc.setException(zzwe.zza(zzai.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        }
    }
}
