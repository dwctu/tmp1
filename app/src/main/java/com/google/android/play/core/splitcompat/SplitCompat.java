package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.play.core.internal.zzau;
import com.google.android.play.core.internal.zzaw;
import com.google.android.play.core.internal.zzay;
import com.google.android.play.core.internal.zzaz;
import com.google.android.play.core.internal.zzba;
import com.google.android.play.core.internal.zzbt;
import com.google.android.play.core.splitinstall.zzbe;
import com.google.android.play.core.splitinstall.zzx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public class SplitCompat {
    public static final /* synthetic */ int zza = 0;
    private static final AtomicReference zzb = new AtomicReference(null);
    private final zze zzc;
    private final zzbe zzd;

    @GuardedBy("emulatedSplits")
    private final Set zze = new HashSet();
    private final zza zzf;

    private SplitCompat(Context context) {
        try {
            zze zzeVar = new zze(context);
            this.zzc = zzeVar;
            this.zzf = new zza(zzeVar);
            this.zzd = new zzbe(context);
        } catch (PackageManager.NameNotFoundException e) {
            throw new zzbt("Failed to initialize FileStorage", e);
        }
    }

    public static boolean install(@NonNull Context context) {
        return zzi(context, false);
    }

    public static boolean installActivity(@NonNull Context context) {
        if (zzj()) {
            return false;
        }
        SplitCompat splitCompat = (SplitCompat) zzb.get();
        if (splitCompat != null) {
            return splitCompat.zzf.zzb(context, splitCompat.zzf());
        }
        if (context.getApplicationContext() != null) {
            install(context.getApplicationContext());
        }
        return install(context);
    }

    public static boolean zzd(Context context) {
        return zzi(context, true);
    }

    public static boolean zze() {
        return zzb.get() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set zzf() {
        HashSet hashSet;
        synchronized (this.zze) {
            hashSet = new HashSet(this.zze);
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg(Set set) throws IOException {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zze.zzl(this.zzc.zzg((String) it.next()));
        }
        this.zzd.zzb();
    }

    @RequiresApi(21)
    private final synchronized void zzh(Context context, boolean z) throws IOException {
        ZipFile zipFile;
        if (z) {
            this.zzc.zzk();
        } else {
            zzd.zza().execute(new zzp(this));
        }
        String packageName = context.getPackageName();
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(packageName, 0).splitNames;
            List<String> arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
            Set<zzs> setZzj = this.zzc.zzj();
            Set setZza = this.zzd.zza();
            HashSet hashSet = new HashSet();
            Iterator it = setZzj.iterator();
            while (it.hasNext()) {
                String strZzb = ((zzs) it.next()).zzb();
                if (arrayList.contains(strZzb) || setZza.contains(com.google.android.play.core.splitinstall.zzs.zzb(strZzb))) {
                    hashSet.add(strZzb);
                    it.remove();
                }
            }
            if (z) {
                zzg(hashSet);
            } else if (!hashSet.isEmpty()) {
                zzd.zza().execute(new zzq(this, hashSet));
            }
            HashSet hashSet2 = new HashSet();
            Iterator it2 = setZzj.iterator();
            while (it2.hasNext()) {
                String strZzb2 = ((zzs) it2.next()).zzb();
                if (!com.google.android.play.core.splitinstall.zzs.zzf(strZzb2)) {
                    hashSet2.add(strZzb2);
                }
            }
            for (String str : arrayList) {
                if (!com.google.android.play.core.splitinstall.zzs.zzf(str)) {
                    hashSet2.add(str);
                }
            }
            HashSet<zzs> hashSet3 = new HashSet(setZzj.size());
            for (zzs zzsVar : setZzj) {
                if (com.google.android.play.core.splitinstall.zzs.zze(zzsVar.zzb()) || hashSet2.contains(com.google.android.play.core.splitinstall.zzs.zzb(zzsVar.zzb()))) {
                    hashSet3.add(zzsVar);
                }
            }
            zzm zzmVar = new zzm(this.zzc);
            zzaz zzazVarZza = zzba.zza();
            ClassLoader classLoader = context.getClassLoader();
            if (z) {
                zzazVarZza.zza(classLoader, zzmVar.zzc());
            } else {
                Iterator it3 = hashSet3.iterator();
                while (it3.hasNext()) {
                    Set setZzb = zzmVar.zzb((zzs) it3.next());
                    if (setZzb == null) {
                        it3.remove();
                    } else {
                        zzazVarZza.zza(classLoader, setZzb);
                    }
                }
            }
            HashSet hashSet4 = new HashSet();
            for (zzs zzsVar2 : hashSet3) {
                try {
                    zipFile = new ZipFile(zzsVar2.zza());
                    try {
                        ZipEntry entry = zipFile.getEntry("classes.dex");
                        zipFile.close();
                        if (entry == null || zzazVarZza.zzb(classLoader, this.zzc.zza(zzsVar2.zzb()), zzsVar2.zza(), z)) {
                            hashSet4.add(zzsVar2.zza());
                        } else {
                            "split was not installed ".concat(zzsVar2.zza().toString());
                        }
                    } catch (IOException e) {
                        e = e;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                    zipFile = null;
                }
            }
            this.zzf.zza(context, hashSet4);
            HashSet hashSet5 = new HashSet();
            for (zzs zzsVar3 : hashSet3) {
                if (hashSet4.contains(zzsVar3.zza())) {
                    String strZzb3 = zzsVar3.zzb();
                    StringBuilder sb = new StringBuilder(strZzb3.length() + 30);
                    sb.append("Split '");
                    sb.append(strZzb3);
                    sb.append("' installation emulated");
                    sb.toString();
                    hashSet5.add(zzsVar3.zzb());
                } else {
                    String strZzb4 = zzsVar3.zzb();
                    StringBuilder sb2 = new StringBuilder(strZzb4.length() + 35);
                    sb2.append("Split '");
                    sb2.append(strZzb4);
                    sb2.append("' installation not emulated.");
                    sb2.toString();
                }
            }
            synchronized (this.zze) {
                this.zze.addAll(hashSet5);
            }
        } catch (PackageManager.NameNotFoundException e3) {
            throw new IOException(String.format("Cannot load data for application '%s'", packageName), e3);
        }
    }

    private static boolean zzi(final Context context, boolean z) {
        if (zzj()) {
            return false;
        }
        AtomicReference atomicReference = zzb;
        boolean zCompareAndSet = atomicReference.compareAndSet(null, new SplitCompat(context));
        SplitCompat splitCompat = (SplitCompat) atomicReference.get();
        if (zCompareAndSet) {
            com.google.android.play.core.splitinstall.zzo.INSTANCE.zzb(new zzaw(context, zzd.zza(), new zzay(context, splitCompat.zzc, new zzau()), splitCompat.zzc, new zzr(), null));
            com.google.android.play.core.splitinstall.zzr.zzb(new zzo(splitCompat));
            zzd.zza().execute(new Runnable() { // from class: com.google.android.play.core.splitcompat.zzn
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    int i = SplitCompat.zza;
                    try {
                        zzx.zzc(context2).zzg(true);
                    } catch (SecurityException unused) {
                    }
                }
            });
        }
        try {
            splitCompat.zzh(context, z);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean zzj() {
        return Build.VERSION.SDK_INT < 21;
    }
}
