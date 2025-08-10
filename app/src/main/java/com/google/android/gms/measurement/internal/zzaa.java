package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzaa extends zzkn {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzaa(zzkz zzkzVar) {
        super(zzkzVar);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza, null);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    private final boolean zzf(int i, int i2) {
        zzu zzuVar = (zzu) this.zzc.get(Integer.valueOf(i));
        if (zzuVar == null) {
            return false;
        }
        return zzuVar.zze.get(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:408:0x0a6d, code lost:
    
        r0 = r64.zzs.zzay().zzk();
        r6 = com.google.android.gms.measurement.internal.zzeo.zzn(r64.zza);
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0a81, code lost:
    
        if (r7.zzj() == false) goto L411;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0a83, code lost:
    
        r7 = java.lang.Integer.valueOf(r7.zza());
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x0a8c, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x0a8d, code lost:
    
        r0.zzc("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r7));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ce A[PHI: r0 r5
  0x02ce: PHI (r0v69 java.util.Map) = (r0v45 java.util.Map), (r0v71 java.util.Map), (r0v39 java.util.Map) binds: [B:126:0x02fb, B:115:0x02d6, B:112:0x02cc] A[DONT_GENERATE, DONT_INLINE]
  0x02ce: PHI (r5v16 android.database.Cursor) = (r5v9 android.database.Cursor), (r5v17 android.database.Cursor), (r5v17 android.database.Cursor) binds: [B:126:0x02fb, B:115:0x02d6, B:112:0x02cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0796 A[PHI: r0 r5 r22 r28 r29
  0x0796: PHI (r0v92 java.util.Map) = (r0v94 java.util.Map), (r0v101 java.util.Map) binds: [B:307:0x07c6, B:291:0x0794] A[DONT_GENERATE, DONT_INLINE]
  0x0796: PHI (r5v33 android.database.Cursor) = (r5v34 android.database.Cursor), (r5v36 android.database.Cursor) binds: [B:307:0x07c6, B:291:0x0794] A[DONT_GENERATE, DONT_INLINE]
  0x0796: PHI (r22v13 com.google.android.gms.measurement.internal.zzas) = (r22v14 com.google.android.gms.measurement.internal.zzas), (r22v18 com.google.android.gms.measurement.internal.zzas) binds: [B:307:0x07c6, B:291:0x0794] A[DONT_GENERATE, DONT_INLINE]
  0x0796: PHI (r28v7 java.lang.String) = (r28v8 java.lang.String), (r28v11 java.lang.String) binds: [B:307:0x07c6, B:291:0x0794] A[DONT_GENERATE, DONT_INLINE]
  0x0796: PHI (r29v8 java.lang.String) = (r29v9 java.lang.String), (r29v11 java.lang.String) binds: [B:307:0x07c6, B:291:0x0794] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x07e9  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x087c  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0947 A[PHI: r0 r13 r65
  0x0947: PHI (r0v142 java.util.Map) = (r0v144 java.util.Map), (r0v150 java.util.Map) binds: [B:373:0x096d, B:362:0x0945] A[DONT_GENERATE, DONT_INLINE]
  0x0947: PHI (r13v16 android.database.Cursor) = (r13v17 android.database.Cursor), (r13v18 android.database.Cursor) binds: [B:373:0x096d, B:362:0x0945] A[DONT_GENERATE, DONT_INLINE]
  0x0947: PHI (r65v8 java.util.Iterator) = (r65v9 java.util.Iterator), (r65v12 java.util.Iterator) binds: [B:373:0x096d, B:362:0x0945] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0990  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0aca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0153 A[PHI: r0 r5
  0x0153: PHI (r0v199 java.util.Map) = (r0v198 java.util.Map), (r0v203 java.util.Map) binds: [B:53:0x0175, B:42:0x0151] A[DONT_GENERATE, DONT_INLINE]
  0x0153: PHI (r5v57 android.database.Cursor) = (r5v56 android.database.Cursor), (r5v58 android.database.Cursor) binds: [B:53:0x0175, B:42:0x0151] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b5a, TRY_LEAVE, TryCatch #12 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:454:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c4 A[Catch: SQLiteException -> 0x0228, all -> 0x0b5a, TRY_ENTER, TryCatch #12 {SQLiteException -> 0x0228, blocks: (B:61:0x01ae, B:63:0x01b4, B:67:0x01c4, B:68:0x01c9, B:69:0x01d3, B:70:0x01e3, B:72:0x01f2), top: B:454:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0251  */
    /* JADX WARN: Type inference failed for: r4v29, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v59, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zza(java.lang.String r65, java.util.List r66, java.util.List r67, java.lang.Long r68, java.lang.Long r69) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.zzkn
    public final boolean zzb() {
        return false;
    }
}
