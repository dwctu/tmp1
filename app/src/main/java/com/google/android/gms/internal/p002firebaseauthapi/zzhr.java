package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhr {
    public static final /* synthetic */ int zza = 0;
    private static final zzpx zzb;
    private static final zzgs zzc;
    private static final zzgp zzd;
    private static final zzfy zze;
    private static final zzfv zzf;

    static {
        zzpx zzpxVarZzb = zzhg.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzpxVarZzb;
        zzc = zzgs.zzc(zzhn.zza, zzhm.class, zzgw.class);
        zzd = zzgp.zzc(zzho.zza, zzpxVarZzb, zzgw.class);
        zze = zzfy.zzc(zzhp.zza, zzhh.class, zzgv.class);
        zzf = zzfv.zzb(new zzft() { // from class: com.google.android.gms.internal.firebase-auth-api.zzhq
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzft
            public final zzaw zza(zzgx zzgxVar, zzca zzcaVar) throws GeneralSecurityException {
                zzhl zzhlVar;
                int i = zzhr.zza;
                if (!((zzgv) zzgxVar).zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
                }
                try {
                    zzip zzipVarZzd = zzip.zzd(((zzgv) zzgxVar).zze(), zzabu.zza());
                    if (zzipVarZzd.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    zziv zzivVarZze = zzipVarZzd.zze();
                    zzoa zzoaVarZzc = ((zzgv) zzgxVar).zzc();
                    int iZza = zzivVarZze.zza();
                    zzoa zzoaVar = zzoa.UNKNOWN_PREFIX;
                    int iOrdinal = zzoaVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzhlVar = zzhl.zza;
                    } else if (iOrdinal == 2) {
                        zzhlVar = zzhl.zzc;
                    } else if (iOrdinal == 3) {
                        zzhlVar = zzhl.zzd;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzoaVarZzc.zza());
                        }
                        zzhlVar = zzhl.zzb;
                    }
                    return zzhh.zzb(zzhm.zzc(iZza, zzhlVar), zzpy.zzb(zzipVarZzd.zzf().zzt(), zzcaVar), ((zzgv) zzgxVar).zzf());
                } catch (zzacp | IllegalArgumentException unused) {
                    throw new GeneralSecurityException("Parsing AesCmacKey failed");
                }
            }
        }, zzpxVarZzb, zzgv.class);
    }

    public static void zza() throws GeneralSecurityException {
        zzgm zzgmVarZzb = zzgm.zzb();
        zzgmVarZzb.zzf(zzc);
        zzgmVarZzb.zze(zzd);
        zzgmVarZzb.zzd(zze);
        zzgmVarZzb.zzc(zzf);
    }
}
