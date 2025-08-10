package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzfn implements com.google.android.gms.internal.measurement.zzr {
    public final /* synthetic */ zzfp zza;

    public zzfn(zzfp zzfpVar) {
        this.zza = zzfpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        int i2 = i - 1;
        zzem zzemVarZzi = i2 != 0 ? i2 != 1 ? i2 != 3 ? i2 != 4 ? this.zza.zzs.zzay().zzi() : z ? this.zza.zzs.zzay().zzm() : !z2 ? this.zza.zzs.zzay().zzl() : this.zza.zzs.zzay().zzk() : this.zza.zzs.zzay().zzj() : z ? this.zza.zzs.zzay().zzh() : !z2 ? this.zza.zzs.zzay().zze() : this.zza.zzs.zzay().zzd() : this.zza.zzs.zzay().zzc();
        int size = list.size();
        if (size == 1) {
            zzemVarZzi.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzemVarZzi.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzemVarZzi.zza(str);
        } else {
            zzemVarZzi.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
