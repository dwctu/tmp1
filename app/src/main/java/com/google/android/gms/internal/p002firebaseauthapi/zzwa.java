package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzwa extends zzxg {
    public zzwa(FirebaseApp firebaseApp) {
        this.zza = new zzwd(firebaseApp);
        this.zzb = Executors.newCachedThreadPool();
    }

    @NonNull
    @VisibleForTesting
    public static zzx zzN(FirebaseApp firebaseApp, zzyt zzytVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzytVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzytVar, "firebase"));
        List listZzr = zzytVar.zzr();
        if (listZzr != null && !listZzr.isEmpty()) {
            for (int i = 0; i < listZzr.size(); i++) {
                arrayList.add(new zzt((zzzg) listZzr.get(i)));
            }
        }
        zzx zzxVar = new zzx(firebaseApp, arrayList);
        zzxVar.zzr(new zzz(zzytVar.zzb(), zzytVar.zza()));
        zzxVar.zzq(zzytVar.zzt());
        zzxVar.zzp(zzytVar.zzd());
        zzxVar.zzi(zzba.zzb(zzytVar.zzq()));
        return zzxVar;
    }

    public final Task zzA(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3, zzg zzgVar) {
        zzvl zzvlVar = new zzvl(str, str2, str3);
        zzvlVar.zzf(firebaseApp);
        zzvlVar.zzd(zzgVar);
        return zzP(zzvlVar);
    }

    public final Task zzB(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, zzg zzgVar) {
        zzvm zzvmVar = new zzvm(emailAuthCredential);
        zzvmVar.zzf(firebaseApp);
        zzvmVar.zzd(zzgVar);
        return zzP(zzvmVar);
    }

    public final Task zzC(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzg zzgVar) {
        zzxr.zzc();
        zzvn zzvnVar = new zzvn(phoneAuthCredential, str);
        zzvnVar.zzf(firebaseApp);
        zzvnVar.zzd(zzgVar);
        return zzP(zzvnVar);
    }

    public final Task zzD(zzag zzagVar, String str, @Nullable String str2, long j, boolean z, boolean z2, @Nullable String str3, @Nullable String str4, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, @Nullable Activity activity) {
        zzvo zzvoVar = new zzvo(zzagVar, str, str2, j, z, z2, str3, str4, z3);
        zzvoVar.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
        return zzP(zzvoVar);
    }

    public final Task zzE(zzag zzagVar, PhoneMultiFactorInfo phoneMultiFactorInfo, @Nullable String str, long j, boolean z, boolean z2, @Nullable String str2, @Nullable String str3, boolean z3, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, @Nullable Activity activity) {
        zzvp zzvpVar = new zzvp(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzagVar.zzd()), str, j, z, z2, str2, str3, z3);
        zzvpVar.zzh(onVerificationStateChangedCallbacks, activity, executor, phoneMultiFactorInfo.getUid());
        return zzP(zzvpVar);
    }

    public final Task zzF(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzvq zzvqVar = new zzvq(firebaseUser.zzf(), str);
        zzvqVar.zzf(firebaseApp);
        zzvqVar.zzg(firebaseUser);
        zzvqVar.zzd(zzbkVar);
        zzvqVar.zze(zzbkVar);
        return zzP(zzvqVar);
    }

    public final Task zzG(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbkVar);
        List listZzg = firebaseUser.zzg();
        if ((listZzg != null && !listZzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzwe.zza(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (((str.hashCode() == 1216985755 && str.equals("password")) ? (char) 0 : (char) 65535) != 0) {
            zzvs zzvsVar = new zzvs(str);
            zzvsVar.zzf(firebaseApp);
            zzvsVar.zzg(firebaseUser);
            zzvsVar.zzd(zzbkVar);
            zzvsVar.zze(zzbkVar);
            return zzP(zzvsVar);
        }
        zzvr zzvrVar = new zzvr();
        zzvrVar.zzf(firebaseApp);
        zzvrVar.zzg(firebaseUser);
        zzvrVar.zzd(zzbkVar);
        zzvrVar.zze(zzbkVar);
        return zzP(zzvrVar);
    }

    public final Task zzH(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzvt zzvtVar = new zzvt(str);
        zzvtVar.zzf(firebaseApp);
        zzvtVar.zzg(firebaseUser);
        zzvtVar.zzd(zzbkVar);
        zzvtVar.zze(zzbkVar);
        return zzP(zzvtVar);
    }

    public final Task zzI(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzvu zzvuVar = new zzvu(str);
        zzvuVar.zzf(firebaseApp);
        zzvuVar.zzg(firebaseUser);
        zzvuVar.zzd(zzbkVar);
        zzvuVar.zze(zzbkVar);
        return zzP(zzvuVar);
    }

    public final Task zzJ(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzbk zzbkVar) {
        zzxr.zzc();
        zzvv zzvvVar = new zzvv(phoneAuthCredential);
        zzvvVar.zzf(firebaseApp);
        zzvvVar.zzg(firebaseUser);
        zzvvVar.zzd(zzbkVar);
        zzvvVar.zze(zzbkVar);
        return zzP(zzvvVar);
    }

    public final Task zzK(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzbk zzbkVar) {
        zzvw zzvwVar = new zzvw(userProfileChangeRequest);
        zzvwVar.zzf(firebaseApp);
        zzvwVar.zzg(firebaseUser);
        zzvwVar.zzd(zzbkVar);
        zzvwVar.zze(zzbkVar);
        return zzP(zzvwVar);
    }

    public final Task zzL(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzg(7);
        return zzP(new zzvx(str, str2, actionCodeSettings));
    }

    public final Task zzM(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzvy zzvyVar = new zzvy(str, str2);
        zzvyVar.zzf(firebaseApp);
        return zzP(zzvyVar);
    }

    public final void zzO(FirebaseApp firebaseApp, zzzn zzznVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zzvz zzvzVar = new zzvz(zzznVar);
        zzvzVar.zzf(firebaseApp);
        zzvzVar.zzh(onVerificationStateChangedCallbacks, activity, executor, zzznVar.zzd());
        zzP(zzvzVar);
    }

    public final Task zza(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzuj zzujVar = new zzuj(str, str2);
        zzujVar.zzf(firebaseApp);
        return zzP(zzujVar);
    }

    public final Task zzb(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzuk zzukVar = new zzuk(str, str2);
        zzukVar.zzf(firebaseApp);
        return zzP(zzukVar);
    }

    public final Task zzc(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3) {
        zzul zzulVar = new zzul(str, str2, str3);
        zzulVar.zzf(firebaseApp);
        return zzP(zzulVar);
    }

    public final Task zzd(FirebaseApp firebaseApp, String str, String str2, String str3, zzg zzgVar) {
        zzum zzumVar = new zzum(str, str2, str3);
        zzumVar.zzf(firebaseApp);
        zzumVar.zzd(zzgVar);
        return zzP(zzumVar);
    }

    @NonNull
    public final Task zze(FirebaseUser firebaseUser, zzan zzanVar) {
        zzun zzunVar = new zzun();
        zzunVar.zzg(firebaseUser);
        zzunVar.zzd(zzanVar);
        zzunVar.zze(zzanVar);
        return zzP(zzunVar);
    }

    public final Task zzf(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzuo zzuoVar = new zzuo(str, str2);
        zzuoVar.zzf(firebaseApp);
        return zzP(zzuoVar);
    }

    public final Task zzg(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, @Nullable String str, zzg zzgVar) {
        zzxr.zzc();
        zzup zzupVar = new zzup(phoneMultiFactorAssertion, firebaseUser.zzf(), str);
        zzupVar.zzf(firebaseApp);
        zzupVar.zzd(zzgVar);
        return zzP(zzupVar);
    }

    public final Task zzh(FirebaseApp firebaseApp, @Nullable FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzg zzgVar) {
        zzxr.zzc();
        zzuq zzuqVar = new zzuq(phoneMultiFactorAssertion, str);
        zzuqVar.zzf(firebaseApp);
        zzuqVar.zzd(zzgVar);
        if (firebaseUser != null) {
            zzuqVar.zzg(firebaseUser);
        }
        return zzP(zzuqVar);
    }

    public final Task zzi(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbk zzbkVar) {
        zzur zzurVar = new zzur(str);
        zzurVar.zzf(firebaseApp);
        zzurVar.zzg(firebaseUser);
        zzurVar.zzd(zzbkVar);
        zzurVar.zze(zzbkVar);
        return zzP(zzurVar);
    }

    public final Task zzj(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzbk zzbkVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbkVar);
        List listZzg = firebaseUser.zzg();
        if (listZzg != null && listZzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzwe.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (emailAuthCredential.zzg()) {
                zzuv zzuvVar = new zzuv(emailAuthCredential);
                zzuvVar.zzf(firebaseApp);
                zzuvVar.zzg(firebaseUser);
                zzuvVar.zzd(zzbkVar);
                zzuvVar.zze(zzbkVar);
                return zzP(zzuvVar);
            }
            zzus zzusVar = new zzus(emailAuthCredential);
            zzusVar.zzf(firebaseApp);
            zzusVar.zzg(firebaseUser);
            zzusVar.zzd(zzbkVar);
            zzusVar.zze(zzbkVar);
            return zzP(zzusVar);
        }
        if (authCredential instanceof PhoneAuthCredential) {
            zzxr.zzc();
            zzuu zzuuVar = new zzuu((PhoneAuthCredential) authCredential);
            zzuuVar.zzf(firebaseApp);
            zzuuVar.zzg(firebaseUser);
            zzuuVar.zzd(zzbkVar);
            zzuuVar.zze(zzbkVar);
            return zzP(zzuuVar);
        }
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbkVar);
        zzut zzutVar = new zzut(authCredential);
        zzutVar.zzf(firebaseApp);
        zzutVar.zzg(firebaseUser);
        zzutVar.zzd(zzbkVar);
        zzutVar.zze(zzbkVar);
        return zzP(zzutVar);
    }

    public final Task zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzbk zzbkVar) {
        zzuw zzuwVar = new zzuw(authCredential, str);
        zzuwVar.zzf(firebaseApp);
        zzuwVar.zzg(firebaseUser);
        zzuwVar.zzd(zzbkVar);
        zzuwVar.zze(zzbkVar);
        return zzP(zzuwVar);
    }

    public final Task zzl(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzbk zzbkVar) {
        zzux zzuxVar = new zzux(authCredential, str);
        zzuxVar.zzf(firebaseApp);
        zzuxVar.zzg(firebaseUser);
        zzuxVar.zzd(zzbkVar);
        zzuxVar.zze(zzbkVar);
        return zzP(zzuxVar);
    }

    public final Task zzm(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzbk zzbkVar) {
        zzuy zzuyVar = new zzuy(emailAuthCredential);
        zzuyVar.zzf(firebaseApp);
        zzuyVar.zzg(firebaseUser);
        zzuyVar.zzd(zzbkVar);
        zzuyVar.zze(zzbkVar);
        return zzP(zzuyVar);
    }

    public final Task zzn(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzbk zzbkVar) {
        zzuz zzuzVar = new zzuz(emailAuthCredential);
        zzuzVar.zzf(firebaseApp);
        zzuzVar.zzg(firebaseUser);
        zzuzVar.zzd(zzbkVar);
        zzuzVar.zze(zzbkVar);
        return zzP(zzuzVar);
    }

    public final Task zzo(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, @Nullable String str3, zzbk zzbkVar) {
        zzva zzvaVar = new zzva(str, str2, str3);
        zzvaVar.zzf(firebaseApp);
        zzvaVar.zzg(firebaseUser);
        zzvaVar.zzd(zzbkVar);
        zzvaVar.zze(zzbkVar);
        return zzP(zzvaVar);
    }

    public final Task zzp(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, @Nullable String str3, zzbk zzbkVar) {
        zzvb zzvbVar = new zzvb(str, str2, str3);
        zzvbVar.zzf(firebaseApp);
        zzvbVar.zzg(firebaseUser);
        zzvbVar.zzd(zzbkVar);
        zzvbVar.zze(zzbkVar);
        return zzP(zzvbVar);
    }

    public final Task zzq(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzbk zzbkVar) {
        zzxr.zzc();
        zzvc zzvcVar = new zzvc(phoneAuthCredential, str);
        zzvcVar.zzf(firebaseApp);
        zzvcVar.zzg(firebaseUser);
        zzvcVar.zzd(zzbkVar);
        zzvcVar.zze(zzbkVar);
        return zzP(zzvcVar);
    }

    public final Task zzr(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzbk zzbkVar) {
        zzxr.zzc();
        zzvd zzvdVar = new zzvd(phoneAuthCredential, str);
        zzvdVar.zzf(firebaseApp);
        zzvdVar.zzg(firebaseUser);
        zzvdVar.zzd(zzbkVar);
        zzvdVar.zze(zzbkVar);
        return zzP(zzvdVar);
    }

    @NonNull
    public final Task zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzbk zzbkVar) {
        zzve zzveVar = new zzve();
        zzveVar.zzf(firebaseApp);
        zzveVar.zzg(firebaseUser);
        zzveVar.zzd(zzbkVar);
        zzveVar.zze(zzbkVar);
        return zzP(zzveVar);
    }

    public final Task zzt(FirebaseApp firebaseApp, @Nullable ActionCodeSettings actionCodeSettings, String str) {
        zzvf zzvfVar = new zzvf(str, actionCodeSettings);
        zzvfVar.zzf(firebaseApp);
        return zzP(zzvfVar);
    }

    public final Task zzu(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2) {
        actionCodeSettings.zzg(1);
        zzvg zzvgVar = new zzvg(str, actionCodeSettings, str2, "sendPasswordResetEmail");
        zzvgVar.zzf(firebaseApp);
        return zzP(zzvgVar);
    }

    public final Task zzv(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2) {
        actionCodeSettings.zzg(6);
        zzvg zzvgVar = new zzvg(str, actionCodeSettings, str2, "sendSignInLinkToEmail");
        zzvgVar.zzf(firebaseApp);
        return zzP(zzvgVar);
    }

    @NonNull
    public final Task zzw(@Nullable String str) {
        return zzP(new zzvh(str));
    }

    public final Task zzx(FirebaseApp firebaseApp, zzg zzgVar, @Nullable String str) {
        zzvi zzviVar = new zzvi(str);
        zzviVar.zzf(firebaseApp);
        zzviVar.zzd(zzgVar);
        return zzP(zzviVar);
    }

    public final Task zzy(FirebaseApp firebaseApp, AuthCredential authCredential, @Nullable String str, zzg zzgVar) {
        zzvj zzvjVar = new zzvj(authCredential, str);
        zzvjVar.zzf(firebaseApp);
        zzvjVar.zzd(zzgVar);
        return zzP(zzvjVar);
    }

    public final Task zzz(FirebaseApp firebaseApp, String str, @Nullable String str2, zzg zzgVar) {
        zzvk zzvkVar = new zzvk(str, str2);
        zzvkVar.zzf(firebaseApp);
        zzvkVar.zzd(zzgVar);
        return zzP(zzvkVar);
    }
}
