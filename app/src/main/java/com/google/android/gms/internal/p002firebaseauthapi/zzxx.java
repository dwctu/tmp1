package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzxx {
    private static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private final HashMap zzd = new HashMap();

    public zzxx(@NonNull Context context) {
        this.zzb = (Context) Preconditions.checkNotNull(context);
        zzf.zza();
        this.zzc = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }

    @VisibleForTesting
    public static String zzb(String str) {
        Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ void zze(zzxx zzxxVar, String str) {
        zzxw zzxwVar = (zzxw) zzxxVar.zzd.get(str);
        if (zzxwVar == null || zzag.zzd(zzxwVar.zzd) || zzag.zzd(zzxwVar.zze) || zzxwVar.zzb.isEmpty()) {
            return;
        }
        Iterator it = zzxwVar.zzb.iterator();
        while (it.hasNext()) {
            ((zzwc) it.next()).zzo(PhoneAuthCredential.zzc(zzxwVar.zzd, zzxwVar.zze));
        }
        zzxwVar.zzh = true;
    }

    private static String zzm(String str, String str2) throws NoSuchAlgorithmException {
        String str3 = str + " " + str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(str3.getBytes(zzo.zzc));
            String strSubstring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + strSubstring, new Object[0]);
            return strSubstring;
        } catch (NoSuchAlgorithmException e) {
            zza.e("NoSuchAlgorithm: ".concat(String.valueOf(e.getMessage())), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzn(String str) {
        zzxw zzxwVar = (zzxw) this.zzd.get(str);
        if (zzxwVar == null || zzxwVar.zzh || zzag.zzd(zzxwVar.zzd)) {
            return;
        }
        zza.w("Timed out waiting for SMS.", new Object[0]);
        Iterator it = zzxwVar.zzb.iterator();
        while (it.hasNext()) {
            ((zzwc) it.next()).zza(zzxwVar.zzd);
        }
        zzxwVar.zzi = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public final void zzh(String str) {
        zzxw zzxwVar = (zzxw) this.zzd.get(str);
        if (zzxwVar == null) {
            return;
        }
        if (!zzxwVar.zzi) {
            zzn(str);
        }
        zzj(str);
    }

    public final String zzc() throws NoSuchAlgorithmException {
        try {
            String packageName = this.zzb.getPackageName();
            String strZzm = zzm(packageName, (Build.VERSION.SDK_INT < 28 ? Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures : Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo.getApkContentsSigners())[0].toCharsString());
            if (strZzm != null) {
                return strZzm;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    public final void zzi(zzwc zzwcVar, String str) {
        zzxw zzxwVar = (zzxw) this.zzd.get(str);
        if (zzxwVar == null) {
            return;
        }
        zzxwVar.zzb.add(zzwcVar);
        if (zzxwVar.zzg) {
            zzwcVar.zzb(zzxwVar.zzd);
        }
        if (zzxwVar.zzh) {
            zzwcVar.zzo(PhoneAuthCredential.zzc(zzxwVar.zzd, zzxwVar.zze));
        }
        if (zzxwVar.zzi) {
            zzwcVar.zza(zzxwVar.zzd);
        }
    }

    public final void zzj(String str) {
        zzxw zzxwVar = (zzxw) this.zzd.get(str);
        if (zzxwVar == null) {
            return;
        }
        ScheduledFuture scheduledFuture = zzxwVar.zzf;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            zzxwVar.zzf.cancel(false);
        }
        zzxwVar.zzb.clear();
        this.zzd.remove(str);
    }

    public final void zzk(final String str, zzwc zzwcVar, long j, boolean z) {
        this.zzd.put(str, new zzxw(j, z));
        zzi(zzwcVar, str);
        zzxw zzxwVar = (zzxw) this.zzd.get(str);
        long j2 = zzxwVar.zza;
        if (j2 <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzxwVar.zzf = this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzxs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(str);
            }
        }, j2, TimeUnit.SECONDS);
        if (!zzxwVar.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzxv zzxvVar = new zzxv(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        zzb.zza(this.zzb.getApplicationContext(), zzxvVar, intentFilter);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzxt(this));
    }

    public final boolean zzl(String str) {
        return this.zzd.get(str) != null;
    }
}
