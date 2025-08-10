package com.google.android.play.core.internal;

import android.content.Context;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzaw implements com.google.android.play.core.splitinstall.zzh {
    private final Context zza;
    private final com.google.android.play.core.splitcompat.zze zzb;
    private final zzay zzc;
    private final Executor zzd;
    private final com.google.android.play.core.splitcompat.zzr zze;

    public zzaw(Context context, Executor executor, zzay zzayVar, com.google.android.play.core.splitcompat.zze zzeVar, com.google.android.play.core.splitcompat.zzr zzrVar, byte[] bArr) {
        this.zza = context;
        this.zzb = zzeVar;
        this.zzc = zzayVar;
        this.zzd = executor;
        this.zze = zzrVar;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzaw zzawVar, List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        Integer numZze = zzawVar.zze(list);
        if (numZze == null) {
            return;
        }
        if (numZze.intValue() == 0) {
            zzfVar.zzc();
        } else {
            zzfVar.zzb(numZze.intValue());
        }
    }

    public static /* bridge */ /* synthetic */ void zzc(zzaw zzawVar, com.google.android.play.core.splitinstall.zzf zzfVar) {
        try {
            if (SplitCompat.zzd(zzce.zza(zzawVar.zza))) {
                zzfVar.zza();
            } else {
                zzfVar.zzb(-12);
            }
        } catch (Exception unused) {
            zzfVar.zzb(-12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd  */
    @androidx.annotation.Nullable
    @com.google.android.play.core.splitinstall.model.SplitInstallErrorCode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Integer zze(java.util.List r14) {
        /*
            r13 = this;
            r0 = -13
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Exception -> Lf6
            com.google.android.play.core.splitcompat.zze r2 = r13.zzb     // Catch: java.lang.Exception -> Lf6
            java.io.File r2 = r2.zzd()     // Catch: java.lang.Exception -> Lf6
            java.lang.String r3 = "rw"
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> Lf6
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch: java.lang.Exception -> Lf6
            r2 = 0
            java.nio.channels.FileLock r3 = r1.tryLock()     // Catch: java.lang.Throwable -> L19 java.nio.channels.OverlappingFileLockException -> L1c
            goto L1d
        L19:
            r14 = move-exception
            goto Lea
        L1c:
            r3 = r2
        L1d:
            if (r3 == 0) goto Lf0
            r2 = 0
            r4 = -11
            java.util.Iterator r14 = r14.iterator()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
        L26:
            boolean r5 = r14.hasNext()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            if (r5 == 0) goto La0
            java.lang.Object r5 = r14.next()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            android.content.Intent r5 = (android.content.Intent) r5     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.lang.String r6 = "split_id"
            java.lang.String r6 = r5.getStringExtra(r6)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            android.content.Context r7 = r13.zza     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            android.net.Uri r5 = r5.getData()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.lang.String r8 = "r"
            android.content.res.AssetFileDescriptor r5 = r7.openAssetFileDescriptor(r5, r8)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            com.google.android.play.core.splitcompat.zze r7 = r13.zzb     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.io.File r7 = r7.zze(r6)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            boolean r8 = r7.exists()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            if (r8 == 0) goto L61
            long r8 = r7.length()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            long r10 = r5.getLength()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L61
            goto L67
        L61:
            boolean r8 = r7.exists()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            if (r8 != 0) goto L26
        L67:
            com.google.android.play.core.splitcompat.zze r8 = r13.zzb     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.io.File r6 = r8.zzg(r6)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            boolean r6 = r6.exists()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            if (r6 != 0) goto L26
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.io.FileInputStream r5 = r5.createInputStream()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L9b
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L9b
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L96
        L85:
            int r8 = r6.read(r7)     // Catch: java.lang.Throwable -> L96
            if (r8 <= 0) goto L8f
            r5.write(r7, r2, r8)     // Catch: java.lang.Throwable -> L96
            goto L85
        L8f:
            r5.close()     // Catch: java.lang.Throwable -> L9b
            r6.close()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            goto L26
        L96:
            r14 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L9a
        L9a:
            throw r14     // Catch: java.lang.Throwable -> L9b
        L9b:
            r14 = move-exception
            r6.close()     // Catch: java.lang.Throwable -> L9f
        L9f:
            throw r14     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
        La0:
            com.google.android.play.core.splitcompat.zze r14 = r13.zzb     // Catch: java.lang.Throwable -> L19
            java.io.File r14 = r14.zzb()     // Catch: java.lang.Throwable -> L19
            java.io.File[] r14 = r14.listFiles()     // Catch: java.lang.Throwable -> L19
            com.google.android.play.core.internal.zzay r5 = r13.zzc     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> Ldd
            boolean r5 = r5.zzc(r14)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> Ldd
            if (r5 == 0) goto Ldd
            com.google.android.play.core.internal.zzay r5 = r13.zzc     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> Ldd
            boolean r14 = r5.zza(r14)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> Ldd
            if (r14 == 0) goto Ldd
            com.google.android.play.core.splitcompat.zze r14 = r13.zzb     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.io.File r14 = r14.zzb()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.io.File[] r14 = r14.listFiles()     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.util.Arrays.sort(r14)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            int r4 = r14.length     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
        Lc8:
            int r4 = r4 + (-1)
            if (r4 < 0) goto Le2
            r5 = r14[r4]     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            com.google.android.play.core.splitcompat.zze.zzm(r5)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            r5 = r14[r4]     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            com.google.android.play.core.splitcompat.zze r6 = r13.zzb     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            java.io.File r6 = r6.zzf(r5)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            r5.renameTo(r6)     // Catch: java.lang.Throwable -> L19 java.lang.Throwable -> Le0
            goto Lc8
        Ldd:
            r2 = -11
            goto Le2
        Le0:
            r2 = -13
        Le2:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L19
            r3.release()     // Catch: java.lang.Throwable -> L19
            goto Lf0
        Lea:
            if (r1 == 0) goto Lef
            r1.close()     // Catch: java.lang.Throwable -> Lef
        Lef:
            throw r14     // Catch: java.lang.Exception -> Lf6
        Lf0:
            if (r1 == 0) goto Lf5
            r1.close()     // Catch: java.lang.Exception -> Lf6
        Lf5:
            return r2
        Lf6:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.zzaw.zze(java.util.List):java.lang.Integer");
    }

    @Override // com.google.android.play.core.splitinstall.zzh
    public final void zzd(List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        if (!SplitCompat.zze()) {
            throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        }
        this.zzd.execute(new zzav(this, list, zzfVar));
    }
}
