package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzxa implements zzwb {
    public final /* synthetic */ zzxd zza;

    public zzxa(zzxd zzxdVar) {
        this.zza = zzxdVar;
    }

    private final void zzp(zzxb zzxbVar) {
        this.zza.zzi.execute(new zzwz(this, zzxbVar));
    }

    private final void zzq(Status status, AuthCredential authCredential, @Nullable String str, @Nullable String str2) {
        zzxd.zzk(this.zza, status);
        zzxd zzxdVar = this.zza;
        zzxdVar.zzp = authCredential;
        zzxdVar.zzq = str;
        zzxdVar.zzr = str2;
        zzao zzaoVar = zzxdVar.zzg;
        if (zzaoVar != null) {
            zzaoVar.zzb(status);
        }
        this.zza.zzl(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zza(String str) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        zzxd zzxdVar = this.zza;
        zzxdVar.zzo = str;
        zzxdVar.zza = true;
        zzp(new zzwx(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzb(String str) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        this.zza.zzo = str;
        zzp(new zzwv(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzc(zzyf zzyfVar) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 3, "Unexpected response type " + i);
        zzxd zzxdVar = this.zza;
        zzxdVar.zzl = zzyfVar;
        zzxd.zzj(zzxdVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzd() throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 5, "Unexpected response type " + i);
        zzxd.zzj(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zze(zzsm zzsmVar) {
        zzq(zzsmVar.zza(), zzsmVar.zzb(), zzsmVar.zzc(), zzsmVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzf(zzso zzsoVar) {
        zzxd zzxdVar = this.zza;
        zzxdVar.zzs = zzsoVar;
        zzxdVar.zzl(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 2, "Unexpected response type " + i);
        zzq(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzh(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzxd zzxdVar = this.zza;
        if (zzxdVar.zzb == 8) {
            zzxdVar.zza = true;
            zzp(new zzwy(this, status));
        } else {
            zzxd.zzk(zzxdVar, status);
            this.zza.zzl(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzi(zzza zzzaVar, zzyt zzytVar) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 2, "Unexpected response type: " + i);
        zzxd zzxdVar = this.zza;
        zzxdVar.zzj = zzzaVar;
        zzxdVar.zzk = zzytVar;
        zzxd.zzj(zzxdVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzj(@Nullable zzzl zzzlVar) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 4, "Unexpected response type " + i);
        zzxd zzxdVar = this.zza;
        zzxdVar.zzm = zzzlVar;
        zzxd.zzj(zzxdVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzk() throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 6, "Unexpected response type " + i);
        zzxd.zzj(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzl(String str) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 7, "Unexpected response type " + i);
        zzxd zzxdVar = this.zza;
        zzxdVar.zzn = str;
        zzxd.zzj(zzxdVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzm() throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 9, "Unexpected response type " + i);
        zzxd.zzj(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzn(zzza zzzaVar) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 1, "Unexpected response type: " + i);
        zzxd zzxdVar = this.zza;
        zzxdVar.zzj = zzzaVar;
        zzxd.zzj(zzxdVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwb
    public final void zzo(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        int i = this.zza.zzb;
        Preconditions.checkState(i == 8, "Unexpected response type " + i);
        this.zza.zza = true;
        zzp(new zzww(this, phoneAuthCredential));
    }
}
