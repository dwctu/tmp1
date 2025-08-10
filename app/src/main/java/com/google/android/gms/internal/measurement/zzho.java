package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzho {
    public static volatile zzif zza = zzif.zzc();
    private static final Object zzb = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:17|(1:19)(8:20|(1:22)(1:23)|24|(0)|34|35|36|37)|29|42|30|31|(1:33)|34|35|36|37) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r6 = r6.getAuthority()
            java.lang.String r0 = "com.google.android.gms.phenotype"
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L17
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            r5.concat(r6)
            return r1
        L17:
            com.google.android.gms.internal.measurement.zzif r6 = com.google.android.gms.internal.measurement.zzho.zza
            boolean r6 = r6.zzb()
            if (r6 == 0) goto L2c
            com.google.android.gms.internal.measurement.zzif r5 = com.google.android.gms.internal.measurement.zzho.zza
            java.lang.Object r5 = r5.zza()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L2c:
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzho.zzb
            monitor-enter(r6)
            com.google.android.gms.internal.measurement.zzif r0 = com.google.android.gms.internal.measurement.zzho.zza     // Catch: java.lang.Throwable -> L9c
            boolean r0 = r0.zzb()     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L45
            com.google.android.gms.internal.measurement.zzif r5 = com.google.android.gms.internal.measurement.zzho.zza     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r5 = r5.zza()     // Catch: java.lang.Throwable -> L9c
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L9c
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L9c
            return r5
        L45:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> L9c
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L52
            goto L73
        L52:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = "com.google.android.gms.phenotype"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L9c
            r4 = 29
            if (r3 >= r4) goto L60
            r3 = 0
            goto L62
        L60:
            r3 = 268435456(0x10000000, float:2.524355E-29)
        L62:
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L84
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Throwable -> L9c
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L9c
            if (r0 != 0) goto L73
            goto L84
        L73:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L84 java.lang.Throwable -> L9c
            int r5 = r5.flags     // Catch: java.lang.Throwable -> L9c
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L84
            r1 = 1
        L84:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzif r5 = com.google.android.gms.internal.measurement.zzif.zzd(r5)     // Catch: java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzho.zza = r5     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L9c
            com.google.android.gms.internal.measurement.zzif r5 = com.google.android.gms.internal.measurement.zzho.zza
            java.lang.Object r5 = r5.zza()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L9c:
            r5 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L9c
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzho.zza(android.content.Context, android.net.Uri):boolean");
    }
}
