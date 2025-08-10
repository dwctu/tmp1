package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.zzag;
import com.google.android.play.core.internal.zzan;
import com.google.android.play.core.internal.zzas;
import com.google.android.play.core.internal.zzce;
import com.google.android.play.core.internal.zzch;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzq {
    private static final zzag zzb = new zzag("AppUpdateService");
    private static final Intent zzc = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    @Nullable
    @VisibleForTesting
    public zzas zza;
    private final String zzd;
    private final Context zze;
    private final zzs zzf;

    public zzq(Context context, zzs zzsVar) {
        this.zzd = context.getPackageName();
        this.zze = context;
        this.zzf = zzsVar;
        if (zzch.zzb(context)) {
            this.zza = new zzas(zzce.zza(context), zzb, "AppUpdateService", zzc, new zzan() { // from class: com.google.android.play.core.appupdate.zzk
                @Override // com.google.android.play.core.internal.zzan
                public final Object zza(IBinder iBinder) {
                    return com.google.android.play.core.internal.zzo.zzb(iBinder);
                }
            }, null);
        }
    }

    public static /* bridge */ /* synthetic */ Bundle zzb(zzq zzqVar, String str) {
        Integer numValueOf;
        Bundle bundle = new Bundle();
        bundle.putAll(zzi());
        bundle.putString("package.name", str);
        try {
            numValueOf = Integer.valueOf(zzqVar.zze.getPackageManager().getPackageInfo(zzqVar.zze.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            zzb.zzb("The current version of the app could not be retrieved", new Object[0]);
            numValueOf = null;
        }
        if (numValueOf != null) {
            bundle.putInt("app.version.code", numValueOf.intValue());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle zzi() {
        Bundle bundle = new Bundle();
        bundle.putAll(PlayCoreVersion.zza("app_update"));
        bundle.putInt("playcore.version.code", 11003);
        return bundle;
    }

    private static Task zzj() {
        zzb.zzb("onError(%d)", -9);
        return Tasks.zza(new InstallException(-9));
    }

    public final Task zzf(String str) {
        if (this.zza == null) {
            return zzj();
        }
        zzb.zzd("completeUpdate(%s)", str);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzm(this, zziVar, zziVar, str), zziVar);
        return zziVar.zza();
    }

    public final Task zzg(String str) {
        if (this.zza == null) {
            return zzj();
        }
        zzb.zzd("requestUpdateInfo(%s)", str);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzl(this, zziVar, str, zziVar), zziVar);
        return zziVar.zza();
    }
}
