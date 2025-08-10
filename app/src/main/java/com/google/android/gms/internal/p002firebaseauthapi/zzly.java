package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzly extends zzach implements zzadn {
    private static final zzly zzb;
    private zzmb zze;
    private int zzf;
    private int zzg;

    static {
        zzly zzlyVar = new zzly();
        zzb = zzlyVar;
        zzach.zzE(zzly.class, zzlyVar);
    }

    private zzly() {
    }

    public static zzlx zzb() {
        return (zzlx) zzb.zzt();
    }

    public static zzly zzd() {
        return zzb;
    }

    public static zzly zze(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzly) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzg(zzly zzlyVar, zzmb zzmbVar) {
        zzmbVar.getClass();
        zzlyVar.zze = zzmbVar;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzmb zzf() {
        zzmb zzmbVar = this.zze;
        return zzmbVar == null ? zzmb.zzd() : zzmbVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzly();
        }
        zzlw zzlwVar = null;
        if (i2 == 4) {
            return new zzlx(zzlwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
