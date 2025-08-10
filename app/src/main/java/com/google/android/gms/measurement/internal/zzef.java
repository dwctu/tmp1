package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.internal.measurement.zzpf;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzef extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    public zzef(zzfy zzfyVar, long j) {
        super(zzfyVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|(1:4)(21:87|6|(1:10)(2:11|(1:13))|83|14|(4:16|(1:18)(1:20)|85|21)|26|(1:31)(1:30)|32|33|43|(1:45)|89|46|(1:48)|49|(3:51|(1:53)(1:54)|55)|(3:57|(1:59)(1:60)|61)|65|(2:68|(1:70)(4:71|(3:74|(1:92)(1:93)|72)|91|77))(1:77)|(2:79|80)(2:81|82))|5|26|(2:28|31)(0)|32|33|43|(0)|89|46|(0)|49|(0)|(0)|65|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01db, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01dc, code lost:
    
        r11.zzs.zzay().zzd().zzc("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzeo.zzn(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0194 A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:57:0x01bc, B:59:0x01d2, B:61:0x01d7, B:60:0x01d5), top: B:89:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bc A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:57:0x01bc, B:59:0x01d2, B:61:0x01d7, B:60:0x01d5), top: B:89:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x024c  */
    @Override // com.google.android.gms.measurement.internal.zzf
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({com.google.firebase.remoteconfig.RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", com.huawei.hms.mlsdk.common.MLApplicationSetting.BundleKeyConstants.AppInfo.appName, "gmpAppId", "gaAppId"})
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd() throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzef.zzd():void");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return true;
    }

    @WorkerThread
    public final int zzh() {
        zza();
        return this.zzj;
    }

    @WorkerThread
    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v38, types: [com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzlh] */
    /* JADX WARN: Type inference failed for: r9v39, types: [com.google.android.gms.measurement.internal.zzgr] */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v48 */
    /* JADX WARN: Type inference failed for: r9v49 */
    /* JADX WARN: Type inference failed for: r9v50 */
    @WorkerThread
    public final zzq zzj(String str) throws IllegalAccessException, NoSuchAlgorithmException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String str2;
        Class<?> clsLoadClass;
        Object objInvoke;
        String str3;
        long jMin;
        String str4;
        long j;
        String str5;
        String str6;
        zzg();
        String strZzl = zzl();
        String strZzm = zzm();
        zza();
        String str7 = this.zzb;
        zza();
        long j2 = this.zzc;
        zza();
        Preconditions.checkNotNull(this.zzd);
        String str8 = this.zzd;
        this.zzs.zzf().zzh();
        zza();
        zzg();
        long j3 = this.zzf;
        if (j3 == 0) {
            ?? Zzv = this.zzs.zzv();
            Context contextZzau = this.zzs.zzau();
            String packageName = this.zzs.zzau().getPackageName();
            Zzv.zzg();
            Preconditions.checkNotNull(contextZzau);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzau.getPackageManager();
            MessageDigest messageDigestZzF = zzlh.zzF();
            long j4 = -1;
            if (messageDigestZzF == null) {
                Zzv.zzs.zzay().zzd().zza("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (Zzv.zzag(contextZzau, packageName)) {
                            j4 = 0;
                            Zzv = Zzv;
                        } else {
                            Signature[] signatureArr = Wrappers.packageManager(contextZzau).getPackageInfo(Zzv.zzs.zzau().getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                Zzv.zzs.zzay().zzk().zza("Could not get signatures");
                                Zzv = Zzv;
                            } else {
                                long jZzp = zzlh.zzp(messageDigestZzF.digest(signatureArr[0].toByteArray()));
                                j4 = jZzp;
                                Zzv = jZzp;
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Zzv.zzs.zzay().zzd().zzb("Package name not found", e);
                    }
                }
                j3 = 0;
                this.zzf = j3;
            }
            j3 = j4;
            this.zzf = j3;
        }
        long j5 = j3;
        boolean zZzJ = this.zzs.zzJ();
        boolean z = !this.zzs.zzm().zzk;
        zzg();
        if (this.zzs.zzJ()) {
            zzpf.zzc();
            if (this.zzs.zzf().zzs(null, zzeb.zzaa)) {
                this.zzs.zzay().zzj().zza("Disabled IID for tests.");
            } else {
                try {
                    clsLoadClass = this.zzs.zzau().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (clsLoadClass != null) {
                    try {
                        objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzs.zzau());
                    } catch (Exception unused2) {
                        this.zzs.zzay().zzm().zza("Failed to obtain Firebase Analytics instance");
                    }
                    if (objInvoke == null) {
                        str2 = null;
                    } else {
                        try {
                            str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                        } catch (Exception unused3) {
                            this.zzs.zzay().zzl().zza("Failed to retrieve Firebase Instance Id");
                        }
                    }
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        zzfy zzfyVar = this.zzs;
        long jZza = zzfyVar.zzm().zzc.zza();
        if (jZza == 0) {
            str3 = strZzl;
            jMin = zzfyVar.zzc;
        } else {
            str3 = strZzl;
            jMin = Math.min(zzfyVar.zzc, jZza);
        }
        zza();
        int i = this.zzj;
        boolean zZzr = this.zzs.zzf().zzr();
        zzfd zzfdVarZzm = this.zzs.zzm();
        zzfdVarZzm.zzg();
        boolean z2 = zzfdVarZzm.zza().getBoolean("deferred_analytics_collection", false);
        zza();
        String str9 = this.zzl;
        Boolean boolValueOf = this.zzs.zzf().zzk("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r2.booleanValue());
        long j6 = this.zzg;
        List list = this.zzh;
        String strZzh = this.zzs.zzm().zzc().zzh();
        if (this.zzi == null) {
            str4 = str9;
            j = j6;
            if (this.zzs.zzf().zzs(null, zzeb.zzax)) {
                this.zzi = this.zzs.zzv().zzC();
            } else {
                this.zzi = "";
            }
        } else {
            str4 = str9;
            j = j6;
        }
        String str10 = this.zzi;
        zzoz.zzc();
        if (this.zzs.zzf().zzs(null, zzeb.zzas)) {
            zzg();
            if (this.zzn == 0) {
                str5 = str10;
            } else {
                str5 = str10;
                long jCurrentTimeMillis = this.zzs.zzav().currentTimeMillis() - this.zzn;
                if (this.zzm != null && jCurrentTimeMillis > 86400000 && this.zzo == null) {
                    zzo();
                }
            }
            if (this.zzm == null) {
                zzo();
            }
            str6 = this.zzm;
        } else {
            str5 = str10;
            str6 = null;
        }
        return new zzq(str3, strZzm, str7, j2, str8, 73000L, j5, str, zZzJ, z, str2, 0L, jMin, i, zZzr, z2, str4, boolValueOf, j, list, (String) null, strZzh, str5, str6);
    }

    @WorkerThread
    public final String zzk() {
        zza();
        return this.zzl;
    }

    @WorkerThread
    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    @WorkerThread
    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    @WorkerThread
    public final List zzn() {
        return this.zzh;
    }

    @WorkerThread
    public final void zzo() {
        String str;
        zzg();
        if (this.zzs.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            this.zzs.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            this.zzs.zzay().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzem zzemVarZzc = this.zzs.zzay().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzemVarZzc.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = this.zzs.zzav().currentTimeMillis();
    }

    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzo = str;
        return z;
    }
}
