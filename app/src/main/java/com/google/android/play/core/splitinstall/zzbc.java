package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.play.core.internal.zzbz;
import com.google.android.play.core.internal.zzce;
import com.google.android.play.core.internal.zzch;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.huawei.hms.feature.dynamic.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzbc {
    private static final com.google.android.play.core.internal.zzag zzb = new com.google.android.play.core.internal.zzag("SplitInstallService");
    private static final Intent zzc = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    @Nullable
    @VisibleForTesting
    public com.google.android.play.core.internal.zzas zza;
    private final String zzd;

    public zzbc(Context context, String str) {
        this.zzd = str;
        if (zzch.zzb(context)) {
            this.zza = new com.google.android.play.core.internal.zzas(zzce.zza(context), zzb, "SplitInstallService", zzc, new com.google.android.play.core.internal.zzan() { // from class: com.google.android.play.core.splitinstall.zzak
                @Override // com.google.android.play.core.internal.zzan
                public final Object zza(IBinder iBinder) {
                    return zzbz.zzb(iBinder);
                }
            }, null);
        }
    }

    public static /* bridge */ /* synthetic */ Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11003);
        return bundle;
    }

    public static /* bridge */ /* synthetic */ ArrayList zzl(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("language", str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static /* bridge */ /* synthetic */ ArrayList zzm(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Bundle bundle = new Bundle();
            bundle.putString(b.i, str);
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private static Task zzn() {
        zzb.zzb("onError(%d)", -14);
        return Tasks.zza(new SplitInstallException(-14));
    }

    public final Task zzc(int i) {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("cancelInstall(%d)", Integer.valueOf(i));
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzas(this, zziVar, i, zziVar), zziVar);
        return zziVar.zza();
    }

    public final Task zzd(List list) {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("deferredInstall(%s)", list);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzan(this, zziVar, list, zziVar), zziVar);
        return zziVar.zza();
    }

    public final Task zze(List list) {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("deferredLanguageInstall(%s)", list);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzao(this, zziVar, list, zziVar), zziVar);
        return zziVar.zza();
    }

    public final Task zzf(List list) {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("deferredLanguageUninstall(%s)", list);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzap(this, zziVar, list, zziVar), zziVar);
        return zziVar.zza();
    }

    public final Task zzg(List list) {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("deferredUninstall(%s)", list);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzam(this, zziVar, list, zziVar), zziVar);
        return zziVar.zza();
    }

    public final Task zzh(int i) {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("getSessionState(%d)", Integer.valueOf(i));
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzaq(this, zziVar, i, zziVar), zziVar);
        return zziVar.zza();
    }

    public final Task zzi() {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("getSessionStates", new Object[0]);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzar(this, zziVar, zziVar), zziVar);
        return zziVar.zza();
    }

    public final Task zzj(Collection collection, Collection collection2) {
        if (this.zza == null) {
            return zzn();
        }
        zzb.zzd("startInstall(%s,%s)", collection, collection2);
        com.google.android.play.core.tasks.zzi zziVar = new com.google.android.play.core.tasks.zzi();
        this.zza.zzq(new zzal(this, zziVar, collection, collection2, zziVar), zziVar);
        return zziVar.zza();
    }
}
