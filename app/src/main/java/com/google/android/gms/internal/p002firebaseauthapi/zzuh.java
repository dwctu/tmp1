package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzuh {
    private final zzxj zza;

    public zzuh(zzxj zzxjVar) {
        this.zza = (zzxj) Preconditions.checkNotNull(zzxjVar);
    }

    private final void zzM(String str, zzxi zzxiVar) {
        Preconditions.checkNotNull(zzxiVar);
        Preconditions.checkNotEmpty(str);
        zzza zzzaVarZzd = zzza.zzd(str);
        if (zzzaVarZzd.zzj()) {
            zzxiVar.zzb(zzzaVarZzd);
        } else {
            this.zza.zzf(new zzyp(zzzaVarZzd.zzf()), new zzug(this, zzxiVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzN(zzyi zzyiVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzyiVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzc(zzyiVar, new zzst(this, zzwcVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzO(zzza zzzaVar, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable zze zzeVar, zzwc zzwcVar, zzxh zzxhVar) {
        Preconditions.checkNotNull(zzzaVar);
        Preconditions.checkNotNull(zzxhVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzg(new zzyq(zzzaVar.zze()), new zzsw(this, zzxhVar, str2, str, bool, zzeVar, zzwcVar, zzzaVar));
    }

    private final void zzP(zzyx zzyxVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzyxVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzh(zzyxVar, new zztz(this, zzwcVar));
    }

    public static /* bridge */ /* synthetic */ void zzd(zzuh zzuhVar, zzaac zzaacVar, zzwc zzwcVar, zzxh zzxhVar) {
        if (!zzaacVar.zzp()) {
            zzuhVar.zzO(new zzza(zzaacVar.zzj(), zzaacVar.zzf(), Long.valueOf(zzaacVar.zzb()), "Bearer"), zzaacVar.zzi(), zzaacVar.zzh(), Boolean.valueOf(zzaacVar.zzo()), zzaacVar.zzc(), zzwcVar, zzxhVar);
            return;
        }
        zzwcVar.zze(new zzsm(zzaacVar.zzn() ? new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL) : zzai.zza(zzaacVar.zze()), zzaacVar.zzc(), zzaacVar.zzd(), zzaacVar.zzk()));
    }

    public static /* bridge */ /* synthetic */ void zze(zzuh zzuhVar, zzwc zzwcVar, zzza zzzaVar, zzzq zzzqVar, zzxh zzxhVar) {
        Preconditions.checkNotNull(zzwcVar);
        Preconditions.checkNotNull(zzzaVar);
        Preconditions.checkNotNull(zzzqVar);
        Preconditions.checkNotNull(zzxhVar);
        zzuhVar.zza.zzg(new zzyq(zzzaVar.zze()), new zzsu(zzuhVar, zzxhVar, zzwcVar, zzzaVar, zzzqVar));
    }

    public static /* bridge */ /* synthetic */ void zzf(zzuh zzuhVar, zzwc zzwcVar, zzza zzzaVar, zzyt zzytVar, zzzq zzzqVar, zzxh zzxhVar) {
        Preconditions.checkNotNull(zzwcVar);
        Preconditions.checkNotNull(zzzaVar);
        Preconditions.checkNotNull(zzytVar);
        Preconditions.checkNotNull(zzzqVar);
        Preconditions.checkNotNull(zzxhVar);
        zzuhVar.zza.zzl(zzzqVar, new zzsv(zzuhVar, zzzqVar, zzytVar, zzwcVar, zzzaVar, zzxhVar));
    }

    public final void zzA(zzaaa zzaaaVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzaaaVar);
        Preconditions.checkNotNull(zzwcVar);
        zzaaaVar.zzd(true);
        this.zza.zzq(zzaaaVar, new zzua(this, zzwcVar));
    }

    public final void zzB(zzaad zzaadVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzaadVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzr(zzaadVar, new zztp(this, zzwcVar));
    }

    public final void zzC(String str, String str2, @Nullable String str3, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzs(new zzaag(str, str2, str3), new zzsr(this, zzwcVar));
    }

    public final void zzD(EmailAuthCredential emailAuthCredential, zzwc zzwcVar) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzwcVar);
        if (emailAuthCredential.zzh()) {
            zzM(emailAuthCredential.zzc(), new zzss(this, emailAuthCredential, zzwcVar));
        } else {
            zzN(new zzyi(emailAuthCredential, null), zzwcVar);
        }
    }

    public final void zzE(zzaai zzaaiVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzaaiVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzt(zzaaiVar, new zztd(this, zzwcVar));
    }

    public final void zzF(zzzu zzzuVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzzuVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzo(zzzuVar, new zzto(this, zzwcVar));
    }

    public final void zzG(zzzw zzzwVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzzwVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzp(zzzwVar, new zztt(this, zzwcVar));
    }

    public final void zzH(String str, String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zztn(this, str2, zzwcVar));
    }

    public final void zzI(String str, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zztj(this, zzwcVar));
    }

    public final void zzJ(String str, String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str2, new zztl(this, str, zzwcVar));
    }

    public final void zzK(String str, UserProfileChangeRequest userProfileChangeRequest, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zzuc(this, userProfileChangeRequest, zzwcVar));
    }

    public final void zzL(zzyx zzyxVar, zzwc zzwcVar) {
        zzP(zzyxVar, zzwcVar);
    }

    public final void zzg(String str, @Nullable String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        zzzq zzzqVar = new zzzq();
        zzzqVar.zzf(str);
        zzzqVar.zzi(str2);
        this.zza.zzl(zzzqVar, new zzuf(this, zzwcVar));
    }

    public final void zzh(String str, String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zzud(this, str2, zzwcVar));
    }

    public final void zzi(String str, String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zzue(this, str2, zzwcVar));
    }

    public final void zzj(String str, @Nullable String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzj(new zzzk(str, null, str2), new zzsz(this, zzwcVar));
    }

    public final void zzk(String str, String str2, @Nullable String str3, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzj(new zzzk(str, str2, str3), new zztb(this, zzwcVar));
    }

    public final void zzl(String str, String str2, @Nullable String str3, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzn(new zzzs(str, str2, null, str3), new zzsq(this, zzwcVar));
    }

    public final void zzm(String str, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zztx(this, zzwcVar));
    }

    public final void zzn(zzyk zzykVar, String str, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzykVar);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zztr(this, zzykVar, zzwcVar));
    }

    public final void zzo(zzym zzymVar, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzymVar);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zze(zzymVar, new zzts(this, zzwcVar));
    }

    public final void zzp(String str, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzf(new zzyp(str), new zzta(this, zzwcVar));
    }

    public final void zzq(String str, @Nullable String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zza(new zzye(str, str2), new zzsx(this, zzwcVar));
    }

    public final void zzr(String str, String str2, String str3, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str3, new zzte(this, str, str2, zzwcVar));
    }

    public final void zzs(String str, zzaaa zzaaaVar, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaaVar);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zzti(this, zzaaaVar, zzwcVar));
    }

    public final void zzt(String str, zzaai zzaaiVar, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaiVar);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zztg(this, zzaaiVar, zzwcVar));
    }

    public final void zzu(String str, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        zzM(str, new zztv(this, zzwcVar));
    }

    public final void zzv(String str, @Nullable ActionCodeSettings actionCodeSettings, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        zzyx zzyxVar = new zzyx(4);
        zzyxVar.zzg(str);
        if (actionCodeSettings != null) {
            zzyxVar.zzd(actionCodeSettings);
        }
        zzP(zzyxVar, zzwcVar);
    }

    public final void zzw(String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzwcVar);
        zzyx zzyxVar = new zzyx(actionCodeSettings.zza());
        zzyxVar.zze(str);
        zzyxVar.zzd(actionCodeSettings);
        zzyxVar.zzf(str2);
        this.zza.zzh(zzyxVar, new zzsy(this, zzwcVar));
    }

    public final void zzx(zzzn zzznVar, zzwc zzwcVar) {
        Preconditions.checkNotEmpty(zzznVar.zzd());
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzk(zzznVar, new zztc(this, zzwcVar));
    }

    public final void zzy(@Nullable String str, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzm(str, new zzty(this, zzwcVar));
    }

    public final void zzz(@Nullable String str, zzwc zzwcVar) {
        Preconditions.checkNotNull(zzwcVar);
        this.zza.zzn(new zzzs(str), new zzub(this, zzwcVar));
    }
}
