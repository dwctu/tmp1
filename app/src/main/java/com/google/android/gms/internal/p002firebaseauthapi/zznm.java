package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zznm extends zzach implements zzadn {
    private static final zznm zzb;
    private int zze;
    private zzacm zzf = zzach.zzy();

    static {
        zznm zznmVar = new zznm();
        zzb = zznmVar;
        zzach.zzE(zznm.class, zznmVar);
    }

    private zznm() {
    }

    public static zznj zza() {
        return (zznj) zzb.zzt();
    }

    public static /* synthetic */ void zze(zznm zznmVar, zznl zznlVar) {
        zznlVar.getClass();
        zzacm zzacmVar = zznmVar.zzf;
        if (!zzacmVar.zzc()) {
            zznmVar.zzf = zzach.zzz(zzacmVar);
        }
        zznmVar.zzf.add(zznlVar);
    }

    public final zznl zzb(int i) {
        return (zznl) this.zzf.get(0);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zznl.class});
        }
        if (i2 == 3) {
            return new zznm();
        }
        zzni zzniVar = null;
        if (i2 == 4) {
            return new zznj(zzniVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
