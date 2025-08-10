package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzli extends zzach implements zzadn {
    private static final zzli zzb;
    private int zze;
    private zzlc zzf;
    private zzabe zzg;
    private zzabe zzh;

    static {
        zzli zzliVar = new zzli();
        zzb = zzliVar;
        zzach.zzE(zzli.class, zzliVar);
    }

    private zzli() {
        zzabe zzabeVar = zzabe.zzb;
        this.zzg = zzabeVar;
        this.zzh = zzabeVar;
    }

    public static zzlh zzc() {
        return (zzlh) zzb.zzt();
    }

    public static zzli zze() {
        return zzb;
    }

    public static zzli zzf(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzli) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzk(zzli zzliVar, zzlc zzlcVar) {
        zzlcVar.getClass();
        zzliVar.zzf = zzlcVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzlc zzb() {
        zzlc zzlcVar = this.zzf;
        return zzlcVar == null ? zzlc.zzd() : zzlcVar;
    }

    public final zzabe zzg() {
        return this.zzg;
    }

    public final zzabe zzh() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzli();
        }
        zzlg zzlgVar = null;
        if (i2 == 4) {
            return new zzlh(zzlgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
