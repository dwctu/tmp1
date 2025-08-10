package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzen {
    public static final zzmz zza;
    public static final zzmz zzb;
    public static final zzmz zzc;
    private static final byte[] zzd;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zzmz zzmzVar = zzcd.zza;
        zzoa zzoaVar = zzoa.TINK;
        zza = zza(4, 5, 3, zzmzVar, zzoaVar, bArr);
        zzb = zza(4, 5, 4, zzmzVar, zzoa.RAW, bArr);
        zzc = zza(4, 5, 3, zzcd.zze, zzoaVar, bArr);
    }

    public static zzmz zza(int i, int i2, int i3, zzmz zzmzVar, zzoa zzoaVar, byte[] bArr) {
        zzky zzkyVarZza = zzkz.zza();
        zzlk zzlkVarZza = zzll.zza();
        zzlkVarZza.zzb(4);
        zzlkVarZza.zzc(5);
        zzlkVarZza.zza(zzabe.zzn(bArr));
        zzll zzllVar = (zzll) zzlkVarZza.zzk();
        zzkv zzkvVarZza = zzkw.zza();
        zzkvVarZza.zza(zzmzVar);
        zzkw zzkwVar = (zzkw) zzkvVarZza.zzk();
        zzlb zzlbVarZzb = zzlc.zzb();
        zzlbVarZzb.zzb(zzllVar);
        zzlbVarZzb.zza(zzkwVar);
        zzlbVarZzb.zzc(i3);
        zzkyVarZza.zza((zzlc) zzlbVarZzb.zzk());
        zzkz zzkzVar = (zzkz) zzkyVarZza.zzk();
        zzmy zzmyVarZza = zzmz.zza();
        new zzef();
        zzmyVarZza.zzb("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
        zzmyVarZza.zza(zzoaVar);
        zzmyVarZza.zzc(zzkzVar.zzo());
        return (zzmz) zzmyVarZza.zzk();
    }
}
