package com.google.android.play.core.missingsplits;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import com.google.android.play.core.internal.zzag;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzb implements MissingSplitsManager {
    private static final zzag zza = new zzag("MissingSplitsManagerImpl");
    private final Context zzb;
    private final Runtime zzc;
    private final zza zzd;
    private final AtomicReference zze;

    public zzb(Context context, Runtime runtime, zza zzaVar, AtomicReference atomicReference) {
        this.zzb = context;
        this.zzc = runtime;
        this.zzd = zzaVar;
        this.zze = atomicReference;
    }

    @TargetApi(21)
    private final List zza() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.zzb.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getAppTasks();
        return appTasks != null ? appTasks : Collections.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean disableAppIfMissingRequiredSplits() throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.missingsplits.zzb.disableAppIfMissingRequiredSplits():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    @Override // com.google.android.play.core.missingsplits.MissingSplitsManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isMissingRequiredSplits() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference r0 = r9.zze
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference r1 = r9.zze     // Catch: java.lang.Throwable -> Lb9
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> Lb9
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> Lb9
            if (r1 != 0) goto Lab
            java.util.concurrent.atomic.AtomicReference r1 = r9.zze     // Catch: java.lang.Throwable -> Lb9
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb9
            r3 = 21
            r4 = 1
            r5 = 0
            if (r2 >= r3) goto L1a
        L17:
            r4 = 0
            goto La4
        L1a:
            android.content.Context r6 = r9.zzb     // Catch: java.lang.Throwable -> Lb9
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: java.lang.Throwable -> Lb9
            android.content.Context r7 = r9.zzb     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> Lb9
            java.lang.String r7 = r7.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> Lb9
            r8 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> Lb9
            if (r6 == 0) goto L17
            android.os.Bundle r6 = r6.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> Lb9
            if (r6 == 0) goto L17
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> Lb9
            java.lang.String r8 = "com.android.vending.splits.required"
            java.lang.Object r6 = r6.get(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> Lb9
            boolean r6 = r7.equals(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L91 java.lang.Throwable -> Lb9
            if (r6 == 0) goto L17
            if (r2 >= r3) goto L47
            java.util.Set r2 = java.util.Collections.emptySet()     // Catch: java.lang.Throwable -> Lb9
            goto L7c
        L47:
            android.content.Context r2 = r9.zzb     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            android.content.Context r3 = r9.zzb     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            java.lang.String r3 = r3.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            java.util.HashSet r3 = new java.util.HashSet     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            r3.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            if (r2 == 0) goto L65
            java.lang.String[] r2 = r2.splitNames     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
            if (r2 == 0) goto L65
            java.util.Collections.addAll(r3, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L67 java.lang.Throwable -> Lb9
        L65:
            r2 = r3
            goto L7c
        L67:
            com.google.android.play.core.internal.zzag r2 = com.google.android.play.core.missingsplits.zzb.zza     // Catch: java.lang.Throwable -> Lb9
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lb9
            android.content.Context r6 = r9.zzb     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Throwable -> Lb9
            r3[r5] = r6     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r6 = "App '%s' is not found in PackageManager"
            r2.zze(r6, r3)     // Catch: java.lang.Throwable -> Lb9
            java.util.Set r2 = java.util.Collections.emptySet()     // Catch: java.lang.Throwable -> Lb9
        L7c:
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> Lb9
            if (r3 != 0) goto La4
            int r3 = r2.size()     // Catch: java.lang.Throwable -> Lb9
            if (r3 != r4) goto L17
            java.lang.String r3 = ""
            boolean r2 = r2.contains(r3)     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L17
            goto La4
        L91:
            com.google.android.play.core.internal.zzag r2 = com.google.android.play.core.missingsplits.zzb.zza     // Catch: java.lang.Throwable -> Lb9
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lb9
            android.content.Context r4 = r9.zzb     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> Lb9
            r3[r5] = r4     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r4 = "App '%s' is not found in the PackageManager"
            r2.zze(r4, r3)     // Catch: java.lang.Throwable -> Lb9
            goto L17
        La4:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> Lb9
            r1.set(r2)     // Catch: java.lang.Throwable -> Lb9
        Lab:
            java.util.concurrent.atomic.AtomicReference r1 = r9.zze     // Catch: java.lang.Throwable -> Lb9
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> Lb9
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> Lb9
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            return r1
        Lb9:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb9
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.missingsplits.zzb.isMissingRequiredSplits():boolean");
    }
}
