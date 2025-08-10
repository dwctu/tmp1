package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzjb extends zzach implements zzadn {
    private static final zzjb zzb;
    private zzjh zze;
    private zzly zzf;

    static {
        zzjb zzjbVar = new zzjb();
        zzb = zzjbVar;
        zzach.zzE(zzjb.class, zzjbVar);
    }

    private zzjb() {
    }

    public static zzja zza() {
        return (zzja) zzb.zzt();
    }

    public static zzjb zzc(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzjb) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzf(zzjb zzjbVar, zzjh zzjhVar) {
        zzjhVar.getClass();
        zzjbVar.zze = zzjhVar;
    }

    public static /* synthetic */ void zzg(zzjb zzjbVar, zzly zzlyVar) {
        zzlyVar.getClass();
        zzjbVar.zzf = zzlyVar;
    }

    public final zzjh zzd() {
        zzjh zzjhVar = this.zze;
        return zzjhVar == null ? zzjh.zzd() : zzjhVar;
    }

    public final zzly zze() {
        zzly zzlyVar = this.zzf;
        return zzlyVar == null ? zzly.zzd() : zzlyVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzjb();
        }
        zziz zzizVar = null;
        if (i2 == 4) {
            return new zzja(zzizVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
