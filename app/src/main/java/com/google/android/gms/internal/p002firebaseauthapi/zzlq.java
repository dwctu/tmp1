package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzlq extends zzach implements zzadn {
    private static final zzlq zzb;
    private zzabe zze = zzabe.zzb;
    private zznm zzf;

    static {
        zzlq zzlqVar = new zzlq();
        zzb = zzlqVar;
        zzach.zzE(zzlq.class, zzlqVar);
    }

    private zzlq() {
    }

    public static zzlp zza() {
        return (zzlp) zzb.zzt();
    }

    public static zzlq zzc(byte[] bArr, zzabu zzabuVar) throws zzacp {
        return (zzlq) zzach.zzx(zzb, bArr, zzabuVar);
    }

    public static /* synthetic */ void zzf(zzlq zzlqVar, zznm zznmVar) {
        zznmVar.getClass();
        zzlqVar.zzf = zznmVar;
    }

    public final zzabe zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzlq();
        }
        zzlo zzloVar = null;
        if (i2 == 4) {
            return new zzlp(zzloVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
