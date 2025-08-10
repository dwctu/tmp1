package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zznh extends zzach implements zzadn {
    private static final zznh zzb;
    private int zze;
    private zzacm zzf = zzach.zzy();

    static {
        zznh zznhVar = new zznh();
        zzb = zznhVar;
        zzach.zzE(zznh.class, zznhVar);
    }

    private zznh() {
    }

    public static zzne zzc() {
        return (zzne) zzb.zzt();
    }

    public static zznh zzf(byte[] bArr, zzabu zzabuVar) throws zzacp {
        return (zznh) zzach.zzx(zzb, bArr, zzabuVar);
    }

    public static /* synthetic */ void zzi(zznh zznhVar, zzng zzngVar) {
        zzngVar.getClass();
        zzacm zzacmVar = zznhVar.zzf;
        if (!zzacmVar.zzc()) {
            zznhVar.zzf = zzach.zzz(zzacmVar);
        }
        zznhVar.zzf.add(zzngVar);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzng zzd(int i) {
        return (zzng) this.zzf.get(i);
    }

    public final List zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzng.class});
        }
        if (i2 == 3) {
            return new zznh();
        }
        zznd zzndVar = null;
        if (i2 == 4) {
            return new zzne(zzndVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
