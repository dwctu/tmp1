package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzxd implements zzxf {
    private boolean zza;
    public final int zzb;
    public FirebaseApp zzd;
    public FirebaseUser zze;
    public Object zzf;
    public zzao zzg;
    public Executor zzi;
    public zzza zzj;
    public zzyt zzk;
    public zzyf zzl;
    public zzzl zzm;
    public String zzn;
    public String zzo;
    public AuthCredential zzp;
    public String zzq;
    public String zzr;
    public zzso zzs;

    @VisibleForTesting
    public Object zzt;

    @VisibleForTesting
    public Status zzu;
    public zzxc zzv;

    @VisibleForTesting
    public final zzxa zzc = new zzxa(this);
    public final List zzh = new ArrayList();

    public zzxd(int i) {
        this.zzb = i;
    }

    public static /* bridge */ /* synthetic */ void zzj(zzxd zzxdVar) {
        zzxdVar.zzb();
        Preconditions.checkState(zzxdVar.zza, "no success or failure set on method implementation");
    }

    public static /* bridge */ /* synthetic */ void zzk(zzxd zzxdVar, Status status) {
        zzao zzaoVar = zzxdVar.zzg;
        if (zzaoVar != null) {
            zzaoVar.zzb(status);
        }
    }

    public abstract void zzb();

    public final zzxd zzd(Object obj) {
        this.zzf = Preconditions.checkNotNull(obj, "external callback cannot be null");
        return this;
    }

    public final zzxd zze(zzao zzaoVar) {
        this.zzg = (zzao) Preconditions.checkNotNull(zzaoVar, "external failure callback cannot be null");
        return this;
    }

    public final zzxd zzf(FirebaseApp firebaseApp) {
        this.zzd = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzxd zzg(FirebaseUser firebaseUser) {
        this.zze = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzxd zzh(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = zzxr.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzh) {
            this.zzh.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(onVerificationStateChangedCallbacksZza));
        }
        if (activity != null) {
            zzwu.zza(activity, this.zzh);
        }
        this.zzi = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final void zzl(Status status) {
        this.zza = true;
        this.zzu = status;
        this.zzv.zza(null, status);
    }

    public final void zzm(Object obj) {
        this.zza = true;
        this.zzt = obj;
        this.zzv.zza(obj, null);
    }
}
