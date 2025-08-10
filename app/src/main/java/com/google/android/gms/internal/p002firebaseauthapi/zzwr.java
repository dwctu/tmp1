package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzwr extends zzxj implements zzya {

    @VisibleForTesting
    public zzws zza;
    private zzwl zzb;
    private zzwm zzc;
    private zzxo zzd;
    private final zzwq zze;
    private final FirebaseApp zzf;
    private final String zzg;

    @VisibleForTesting
    public zzwr(FirebaseApp firebaseApp, zzwq zzwqVar, zzxo zzxoVar, zzwl zzwlVar, zzwm zzwmVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.zzf = firebaseApp;
        String apiKey = firebaseApp.getOptions().getApiKey();
        this.zzg = apiKey;
        this.zze = (zzwq) Preconditions.checkNotNull(zzwqVar);
        zzw(null, null, null);
        zzyb.zze(apiKey, this);
    }

    @NonNull
    private final zzws zzv() {
        if (this.zza == null) {
            FirebaseApp firebaseApp = this.zzf;
            this.zza = new zzws(firebaseApp.getApplicationContext(), firebaseApp, this.zze.zzb());
        }
        return this.zza;
    }

    private final void zzw(zzxo zzxoVar, zzwl zzwlVar, zzwm zzwmVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.zzd = null;
        this.zzb = null;
        this.zzc = null;
        String strZza = zzxy.zza("firebear.secureToken");
        if (TextUtils.isEmpty(strZza)) {
            strZza = zzyb.zzd(this.zzg);
        } else {
            "Found hermetic configuration for secureToken URL: ".concat(String.valueOf(strZza));
        }
        if (this.zzd == null) {
            this.zzd = new zzxo(strZza, zzv());
        }
        String strZza2 = zzxy.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(strZza2)) {
            strZza2 = zzyb.zzb(this.zzg);
        } else {
            "Found hermetic configuration for identityToolkit URL: ".concat(String.valueOf(strZza2));
        }
        if (this.zzb == null) {
            this.zzb = new zzwl(strZza2, zzv());
        }
        String strZza3 = zzxy.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(strZza3)) {
            strZza3 = zzyb.zzc(this.zzg);
        } else {
            "Found hermetic configuration for identityToolkitV2 URL: ".concat(String.valueOf(strZza3));
        }
        if (this.zzc == null) {
            this.zzc = new zzwm(strZza3, zzv());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zza(zzye zzyeVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzyeVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/createAuthUri", this.zzg), zzyeVar, zzxiVar, zzyf.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzb(zzyh zzyhVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzyhVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/deleteAccount", this.zzg), zzyhVar, zzxiVar, Void.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzc(zzyi zzyiVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzyiVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/emailLinkSignin", this.zzg), zzyiVar, zzxiVar, zzyj.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzd(zzyk zzykVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzykVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwm zzwmVar = this.zzc;
        zzxl.zza(zzwmVar.zza("/accounts/mfaEnrollment:finalize", this.zzg), zzykVar, zzxiVar, zzyl.class, zzwmVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zze(zzym zzymVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzymVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwm zzwmVar = this.zzc;
        zzxl.zza(zzwmVar.zza("/accounts/mfaSignIn:finalize", this.zzg), zzymVar, zzxiVar, zzyn.class, zzwmVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzf(zzyp zzypVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzypVar);
        Preconditions.checkNotNull(zzxiVar);
        zzxo zzxoVar = this.zzd;
        zzxl.zza(zzxoVar.zza("/token", this.zzg), zzypVar, zzxiVar, zzza.class, zzxoVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzg(zzyq zzyqVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzyqVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/getAccountInfo", this.zzg), zzyqVar, zzxiVar, zzyr.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzh(zzyx zzyxVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzyxVar);
        Preconditions.checkNotNull(zzxiVar);
        if (zzyxVar.zzb() != null) {
            zzv().zzc(zzyxVar.zzb().zze());
        }
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/getOobConfirmationCode", this.zzg), zzyxVar, zzxiVar, zzyy.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzya
    public final void zzi() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        zzw(null, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzj(zzzk zzzkVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzzkVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/resetPassword", this.zzg), zzzkVar, zzxiVar, zzzl.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzk(zzzn zzznVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzznVar);
        Preconditions.checkNotNull(zzxiVar);
        if (!TextUtils.isEmpty(zzznVar.zzc())) {
            zzv().zzc(zzznVar.zzc());
        }
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/sendVerificationCode", this.zzg), zzznVar, zzxiVar, zzzp.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzl(zzzq zzzqVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzzqVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/setAccountInfo", this.zzg), zzzqVar, zzxiVar, zzzr.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzm(@Nullable String str, zzxi zzxiVar) {
        Preconditions.checkNotNull(zzxiVar);
        zzv().zzb(str);
        ((zzty) zzxiVar).zza.zzm();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzn(zzzs zzzsVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzzsVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/signupNewUser", this.zzg), zzzsVar, zzxiVar, zzzt.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzo(zzzu zzzuVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzzuVar);
        Preconditions.checkNotNull(zzxiVar);
        if (!TextUtils.isEmpty(zzzuVar.zzc())) {
            zzv().zzc(zzzuVar.zzc());
        }
        zzwm zzwmVar = this.zzc;
        zzxl.zza(zzwmVar.zza("/accounts/mfaEnrollment:start", this.zzg), zzzuVar, zzxiVar, zzzv.class, zzwmVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzp(zzzw zzzwVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzzwVar);
        Preconditions.checkNotNull(zzxiVar);
        if (!TextUtils.isEmpty(zzzwVar.zzc())) {
            zzv().zzc(zzzwVar.zzc());
        }
        zzwm zzwmVar = this.zzc;
        zzxl.zza(zzwmVar.zza("/accounts/mfaSignIn:start", this.zzg), zzzwVar, zzxiVar, zzzx.class, zzwmVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzq(zzaaa zzaaaVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzaaaVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/verifyAssertion", this.zzg), zzaaaVar, zzxiVar, zzaac.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzr(zzaad zzaadVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzaadVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/verifyCustomToken", this.zzg), zzaadVar, zzxiVar, zzaae.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzs(zzaag zzaagVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzaagVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/verifyPassword", this.zzg), zzaagVar, zzxiVar, zzaah.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzt(zzaai zzaaiVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzaaiVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwl zzwlVar = this.zzb;
        zzxl.zza(zzwlVar.zza("/verifyPhoneNumber", this.zzg), zzaaiVar, zzxiVar, zzaaj.class, zzwlVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxj
    public final void zzu(zzaak zzaakVar, zzxi zzxiVar) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Preconditions.checkNotNull(zzaakVar);
        Preconditions.checkNotNull(zzxiVar);
        zzwm zzwmVar = this.zzc;
        zzxl.zza(zzwmVar.zza("/accounts/mfaEnrollment:withdraw", this.zzg), zzaakVar, zzxiVar, zzaal.class, zzwmVar.zzb);
    }
}
