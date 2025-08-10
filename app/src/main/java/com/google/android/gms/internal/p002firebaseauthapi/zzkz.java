package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzkz extends zzach implements zzadn {
    private static final zzkz zzb;
    private zzlc zze;

    static {
        zzkz zzkzVar = new zzkz();
        zzb = zzkzVar;
        zzach.zzE(zzkz.class, zzkzVar);
    }

    private zzkz() {
    }

    public static zzky zza() {
        return (zzky) zzb.zzt();
    }

    public static zzkz zzc(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzkz) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zze(zzkz zzkzVar, zzlc zzlcVar) {
        zzlcVar.getClass();
        zzkzVar.zze = zzlcVar;
    }

    public final zzlc zzd() {
        zzlc zzlcVar = this.zze;
        return zzlcVar == null ? zzlc.zzd() : zzlcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zze"});
        }
        if (i2 == 3) {
            return new zzkz();
        }
        zzkx zzkxVar = null;
        if (i2 == 4) {
            return new zzky(zzkxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
