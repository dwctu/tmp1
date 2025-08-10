package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzwd {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzuh zzb;
    private final zzxx zzc;

    public zzwd(FirebaseApp firebaseApp) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzuh(new zzwr(firebaseApp, zzwq.zza(), null, null, null));
        this.zzc = new zzxx(applicationContext);
    }

    private static boolean zzG(long j, boolean z) {
        if (j > 0 && z) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    public final void zzA(zzsa zzsaVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzsaVar);
        Preconditions.checkNotNull(zzwbVar);
        String phoneNumber = zzsaVar.zzb().getPhoneNumber();
        zzwc zzwcVar = new zzwc(zzwbVar, zza);
        if (this.zzc.zzl(phoneNumber)) {
            if (!zzsaVar.zzg()) {
                this.zzc.zzi(zzwcVar, phoneNumber);
                return;
            }
            this.zzc.zzj(phoneNumber);
        }
        long jZza = zzsaVar.zza();
        boolean zZzh = zzsaVar.zzh();
        zzzw zzzwVarZzb = zzzw.zzb(zzsaVar.zzd(), zzsaVar.zzb().getUid(), zzsaVar.zzb().getPhoneNumber(), zzsaVar.zzc(), zzsaVar.zze(), zzsaVar.zzf());
        if (zzG(jZza, zZzh)) {
            zzzwVarZzb.zzd(new zzyc(this.zzc.zzc()));
        }
        this.zzc.zzk(phoneNumber, zzwcVar, jZza, zZzh);
        this.zzb.zzG(zzzwVarZzb, new zzxu(this.zzc, zzwcVar, phoneNumber));
    }

    public final void zzB(zzsc zzscVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzscVar);
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzH(zzscVar.zza(), zzscVar.zzb(), new zzwc(zzwbVar, zza));
    }

    public final void zzC(zzse zzseVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzseVar);
        Preconditions.checkNotEmpty(zzseVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzI(zzseVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzD(zzsg zzsgVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzsgVar);
        Preconditions.checkNotEmpty(zzsgVar.zzb());
        Preconditions.checkNotEmpty(zzsgVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzJ(zzsgVar.zzb(), zzsgVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzE(zzsi zzsiVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzsiVar);
        Preconditions.checkNotEmpty(zzsiVar.zzb());
        Preconditions.checkNotNull(zzsiVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzK(zzsiVar.zzb(), zzsiVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzF(zzsk zzskVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzskVar);
        this.zzb.zzL(zzyx.zzc(zzskVar.zza(), zzskVar.zzb(), zzskVar.zzc()), new zzwc(zzwbVar, zza));
    }

    public final void zza(zzqa zzqaVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqaVar);
        Preconditions.checkNotEmpty(zzqaVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzg(zzqaVar.zza(), zzqaVar.zzb(), new zzwc(zzwbVar, zza));
    }

    public final void zzb(zzqc zzqcVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqcVar);
        Preconditions.checkNotEmpty(zzqcVar.zza());
        Preconditions.checkNotEmpty(zzqcVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzh(zzqcVar.zza(), zzqcVar.zzb(), new zzwc(zzwbVar, zza));
    }

    public final void zzc(zzqe zzqeVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqeVar);
        Preconditions.checkNotEmpty(zzqeVar.zza());
        Preconditions.checkNotEmpty(zzqeVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzi(zzqeVar.zza(), zzqeVar.zzb(), new zzwc(zzwbVar, zza));
    }

    public final void zzd(zzqg zzqgVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqgVar);
        Preconditions.checkNotEmpty(zzqgVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzj(zzqgVar.zza(), zzqgVar.zzb(), new zzwc(zzwbVar, zza));
    }

    public final void zze(zzqi zzqiVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqiVar);
        Preconditions.checkNotEmpty(zzqiVar.zza());
        Preconditions.checkNotEmpty(zzqiVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzk(zzqiVar.zza(), zzqiVar.zzb(), zzqiVar.zzc(), new zzwc(zzwbVar, zza));
    }

    public final void zzf(zzqk zzqkVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqkVar);
        Preconditions.checkNotEmpty(zzqkVar.zza());
        Preconditions.checkNotEmpty(zzqkVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzl(zzqkVar.zza(), zzqkVar.zzb(), zzqkVar.zzc(), new zzwc(zzwbVar, zza));
    }

    public final void zzg(zzqm zzqmVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqmVar);
        Preconditions.checkNotEmpty(zzqmVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzm(zzqmVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzh(zzqo zzqoVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqoVar);
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzn(zzyk.zzb(zzqoVar.zzb(), (String) Preconditions.checkNotNull(zzqoVar.zza().zzg()), (String) Preconditions.checkNotNull(zzqoVar.zza().getSmsCode()), zzqoVar.zzc()), zzqoVar.zzb(), new zzwc(zzwbVar, zza));
    }

    public final void zzi(zzqq zzqqVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqqVar);
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzo(zzym.zzb(zzqqVar.zzb(), (String) Preconditions.checkNotNull(zzqqVar.zza().zzg()), (String) Preconditions.checkNotNull(zzqqVar.zza().getSmsCode())), new zzwc(zzwbVar, zza));
    }

    public final void zzj(zzqs zzqsVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqsVar);
        Preconditions.checkNotNull(zzwbVar);
        Preconditions.checkNotEmpty(zzqsVar.zza());
        this.zzb.zzp(zzqsVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzk(zzqu zzquVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzquVar);
        Preconditions.checkNotEmpty(zzquVar.zza());
        this.zzb.zzq(zzquVar.zza(), zzquVar.zzb(), new zzwc(zzwbVar, zza));
    }

    public final void zzl(zzqw zzqwVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqwVar);
        Preconditions.checkNotEmpty(zzqwVar.zzb());
        Preconditions.checkNotEmpty(zzqwVar.zzc());
        Preconditions.checkNotEmpty(zzqwVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzr(zzqwVar.zzb(), zzqwVar.zzc(), zzqwVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzm(zzqy zzqyVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzqyVar);
        Preconditions.checkNotEmpty(zzqyVar.zzb());
        Preconditions.checkNotNull(zzqyVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzs(zzqyVar.zzb(), zzqyVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzn(zzra zzraVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzwbVar);
        Preconditions.checkNotNull(zzraVar);
        PhoneAuthCredential phoneAuthCredential = (PhoneAuthCredential) Preconditions.checkNotNull(zzraVar.zza());
        this.zzb.zzt(Preconditions.checkNotEmpty(zzraVar.zzb()), zzxn.zza(phoneAuthCredential), new zzwc(zzwbVar, zza));
    }

    public final void zzo(zzrc zzrcVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzrcVar);
        Preconditions.checkNotEmpty(zzrcVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzu(zzrcVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzp(@NonNull zzre zzreVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzreVar);
        Preconditions.checkNotEmpty(zzreVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzv(zzreVar.zzb(), zzreVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzq(@NonNull zzrg zzrgVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzrgVar);
        Preconditions.checkNotEmpty(zzrgVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzw(zzrgVar.zzb(), zzrgVar.zza(), zzrgVar.zzc(), new zzwc(zzwbVar, zza));
    }

    public final void zzr(zzri zzriVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzwbVar);
        Preconditions.checkNotNull(zzriVar);
        zzzn zzznVar = (zzzn) Preconditions.checkNotNull(zzriVar.zza());
        String strZzd = zzznVar.zzd();
        zzwc zzwcVar = new zzwc(zzwbVar, zza);
        if (this.zzc.zzl(strZzd)) {
            if (!zzznVar.zzf()) {
                this.zzc.zzi(zzwcVar, strZzd);
                return;
            }
            this.zzc.zzj(strZzd);
        }
        long jZzb = zzznVar.zzb();
        boolean zZzg = zzznVar.zzg();
        if (zzG(jZzb, zZzg)) {
            zzznVar.zze(new zzyc(this.zzc.zzc()));
        }
        this.zzc.zzk(strZzd, zzwcVar, jZzb, zZzg);
        this.zzb.zzx(zzznVar, new zzxu(this.zzc, zzwcVar, strZzd));
    }

    public final void zzs(zzrk zzrkVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzrkVar);
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzy(zzrkVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzt(zzrm zzrmVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzrmVar);
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzz(zzrmVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzu(zzro zzroVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzroVar);
        Preconditions.checkNotNull(zzroVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzA(zzroVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzv(zzrq zzrqVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzrqVar);
        Preconditions.checkNotEmpty(zzrqVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzB(new zzaad(zzrqVar.zzb(), zzrqVar.zza()), new zzwc(zzwbVar, zza));
    }

    public final void zzw(zzrs zzrsVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzrsVar);
        Preconditions.checkNotEmpty(zzrsVar.zza());
        Preconditions.checkNotEmpty(zzrsVar.zzb());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzC(zzrsVar.zza(), zzrsVar.zzb(), zzrsVar.zzc(), new zzwc(zzwbVar, zza));
    }

    public final void zzx(zzru zzruVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzruVar);
        Preconditions.checkNotNull(zzruVar.zza());
        Preconditions.checkNotNull(zzwbVar);
        this.zzb.zzD(zzruVar.zza(), new zzwc(zzwbVar, zza));
    }

    public final void zzy(zzrw zzrwVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzwbVar);
        Preconditions.checkNotNull(zzrwVar);
        this.zzb.zzE(zzxn.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzrwVar.zza())), new zzwc(zzwbVar, zza));
    }

    public final void zzz(zzry zzryVar, zzwb zzwbVar) {
        Preconditions.checkNotNull(zzryVar);
        Preconditions.checkNotNull(zzwbVar);
        String strZzd = zzryVar.zzd();
        zzwc zzwcVar = new zzwc(zzwbVar, zza);
        if (this.zzc.zzl(strZzd)) {
            if (!zzryVar.zzg()) {
                this.zzc.zzi(zzwcVar, strZzd);
                return;
            }
            this.zzc.zzj(strZzd);
        }
        long jZza = zzryVar.zza();
        boolean zZzh = zzryVar.zzh();
        zzzu zzzuVarZzb = zzzu.zzb(zzryVar.zzb(), zzryVar.zzd(), zzryVar.zzc(), zzryVar.zze(), zzryVar.zzf());
        if (zzG(jZza, zZzh)) {
            zzzuVarZzb.zzd(new zzyc(this.zzc.zzc()));
        }
        this.zzc.zzk(strZzd, zzwcVar, jZza, zZzh);
        this.zzb.zzF(zzzuVarZzb, new zzxu(this.zzc, zzwcVar, strZzd));
    }
}
