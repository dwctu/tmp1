package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzcd {
    public static final zzmz zza = zzb(16);
    public static final zzmz zzb = zzb(32);
    public static final zzmz zzc = zza(16, 16);
    public static final zzmz zzd = zza(32, 16);
    public static final zzmz zze = zzc(16, 16, 32, 16, 5);
    public static final zzmz zzf = zzc(32, 16, 32, 32, 5);
    public static final zzmz zzg;
    public static final zzmz zzh;

    static {
        zzmy zzmyVarZza = zzmz.zza();
        new zzcy();
        zzmyVarZza.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzoa zzoaVar = zzoa.TINK;
        zzmyVarZza.zza(zzoaVar);
        zzg = (zzmz) zzmyVarZza.zzk();
        zzmy zzmyVarZza2 = zzmz.zza();
        new zzdi();
        zzmyVarZza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzmyVarZza2.zza(zzoaVar);
        zzh = (zzmz) zzmyVarZza2.zzk();
    }

    public static zzmz zza(int i, int i2) {
        zzjp zzjpVarZzb = zzjq.zzb();
        zzjpVarZzb.zza(i);
        zzjs zzjsVarZzb = zzjt.zzb();
        zzjsVarZzb.zza(16);
        zzjpVarZzb.zzb((zzjt) zzjsVarZzb.zzk());
        zzjq zzjqVar = (zzjq) zzjpVarZzb.zzk();
        zzmy zzmyVarZza = zzmz.zza();
        zzmyVarZza.zzc(zzjqVar.zzo());
        new zzcp();
        zzmyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzmyVarZza.zza(zzoa.TINK);
        return (zzmz) zzmyVarZza.zzk();
    }

    public static zzmz zzb(int i) {
        zzjy zzjyVarZzb = zzjz.zzb();
        zzjyVarZzb.zza(i);
        zzjz zzjzVar = (zzjz) zzjyVarZzb.zzk();
        zzmy zzmyVarZza = zzmz.zza();
        zzmyVarZza.zzc(zzjzVar.zzo());
        new zzcs();
        zzmyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzmyVarZza.zza(zzoa.TINK);
        return (zzmz) zzmyVarZza.zzk();
    }

    public static zzmz zzc(int i, int i2, int i3, int i4, int i5) {
        zzjg zzjgVarZzb = zzjh.zzb();
        zzjj zzjjVarZzb = zzjk.zzb();
        zzjjVarZzb.zza(16);
        zzjgVarZzb.zzb((zzjk) zzjjVarZzb.zzk());
        zzjgVarZzb.zza(i);
        zzjh zzjhVar = (zzjh) zzjgVarZzb.zzk();
        zzlx zzlxVarZzb = zzly.zzb();
        zzma zzmaVarZzb = zzmb.zzb();
        zzmaVarZzb.zzb(5);
        zzmaVarZzb.zza(i4);
        zzlxVarZzb.zzb((zzmb) zzmaVarZzb.zzk());
        zzlxVarZzb.zza(32);
        zzly zzlyVar = (zzly) zzlxVarZzb.zzk();
        zzja zzjaVarZza = zzjb.zza();
        zzjaVarZza.zza(zzjhVar);
        zzjaVarZza.zzb(zzlyVar);
        zzjb zzjbVar = (zzjb) zzjaVarZza.zzk();
        zzmy zzmyVarZza = zzmz.zza();
        zzmyVarZza.zzc(zzjbVar.zzo());
        new zzcj();
        zzmyVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzmyVarZza.zza(zzoa.TINK);
        return (zzmz) zzmyVarZza.zzk();
    }
}
