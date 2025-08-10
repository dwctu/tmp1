package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzny extends zzach implements zzadn {
    private static final zzny zzb;
    private String zze = "";
    private zzmz zzf;

    static {
        zzny zznyVar = new zzny();
        zzb = zznyVar;
        zzach.zzE(zzny.class, zznyVar);
    }

    private zzny() {
    }

    public static zzny zzc() {
        return zzb;
    }

    public static zzny zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzny) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public final zzmz zza() {
        zzmz zzmzVar = this.zzf;
        return zzmzVar == null ? zzmz.zzc() : zzmzVar;
    }

    public final String zze() {
        return this.zze;
    }

    public final boolean zzf() {
        return this.zzf != null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzny();
        }
        zznw zznwVar = null;
        if (i2 == 4) {
            return new zznx(zznwVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
