package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmz extends zzach implements zzadn {
    private static final zzmz zzb;
    private String zze = "";
    private zzabe zzf = zzabe.zzb;
    private int zzg;

    static {
        zzmz zzmzVar = new zzmz();
        zzb = zzmzVar;
        zzach.zzE(zzmz.class, zzmzVar);
    }

    private zzmz() {
    }

    public static zzmy zza() {
        return (zzmy) zzb.zzt();
    }

    public static zzmz zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzg(zzmz zzmzVar, String str) {
        str.getClass();
        zzmzVar.zze = str;
    }

    public final zzoa zzd() {
        zzoa zzoaVarZzb = zzoa.zzb(this.zzg);
        return zzoaVarZzb == null ? zzoa.UNRECOGNIZED : zzoaVarZzb;
    }

    public final zzabe zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzmz();
        }
        zzmx zzmxVar = null;
        if (i2 == 4) {
            return new zzmy(zzmxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
