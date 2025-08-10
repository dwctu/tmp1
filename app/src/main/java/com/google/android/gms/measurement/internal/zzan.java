package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzan {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b A[Catch: SQLiteException -> 0x00d7, TryCatch #0 {SQLiteException -> 0x00d7, blocks: (B:21:0x0046, B:23:0x006c, B:25:0x007b, B:27:0x0083, B:28:0x0086, B:29:0x00a4, B:31:0x00a7, B:33:0x00aa, B:35:0x00b2, B:36:0x00b9, B:37:0x00bc, B:39:0x00c2, B:42:0x00d3, B:43:0x00d6, B:22:0x0065), top: B:54:0x0046, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7 A[Catch: SQLiteException -> 0x00d7, LOOP:1: B:31:0x00a7->B:36:0x00b9, LOOP_START, PHI: r12
  0x00a7: PHI (r12v1 int) = (r12v0 int), (r12v2 int) binds: [B:30:0x00a5, B:36:0x00b9] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteException -> 0x00d7, blocks: (B:21:0x0046, B:23:0x006c, B:25:0x007b, B:27:0x0083, B:28:0x0086, B:29:0x00a4, B:31:0x00a7, B:33:0x00aa, B:35:0x00b2, B:36:0x00b9, B:37:0x00bc, B:39:0x00c2, B:42:0x00d3, B:43:0x00d6, B:22:0x0065), top: B:54:0x0046, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2 A[Catch: SQLiteException -> 0x00d7, TryCatch #0 {SQLiteException -> 0x00d7, blocks: (B:21:0x0046, B:23:0x006c, B:25:0x007b, B:27:0x0083, B:28:0x0086, B:29:0x00a4, B:31:0x00a7, B:33:0x00aa, B:35:0x00b2, B:36:0x00b9, B:37:0x00bc, B:39:0x00c2, B:42:0x00d3, B:43:0x00d6, B:22:0x0065), top: B:54:0x0046, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v2 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void zza(com.google.android.gms.measurement.internal.zzeo r14, android.database.sqlite.SQLiteDatabase r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String[] r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(com.google.android.gms.measurement.internal.zzeo, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static void zzb(zzeo zzeoVar, SQLiteDatabase sQLiteDatabase) {
        if (zzeoVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzeoVar.zzk().zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzeoVar.zzk().zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzeoVar.zzk().zza("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzeoVar.zzk().zza("Failed to turn on database write permission for owner");
    }
}
