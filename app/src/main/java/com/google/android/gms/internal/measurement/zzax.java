package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzax {
    public final Map zza = new HashMap();
    public final zzbj zzb = new zzbj();

    public zzax() {
        zzb(new zzav());
        zzb(new zzay());
        zzb(new zzaz());
        zzb(new zzbc());
        zzb(new zzbh());
        zzb(new zzbi());
        zzb(new zzbk());
    }

    public final zzap zza(zzg zzgVar, zzap zzapVar) {
        zzh.zzc(zzgVar);
        if (!(zzapVar instanceof zzaq)) {
            return zzapVar;
        }
        zzaq zzaqVar = (zzaq) zzapVar;
        ArrayList arrayListZzc = zzaqVar.zzc();
        String strZzb = zzaqVar.zzb();
        return (this.zza.containsKey(strZzb) ? (zzaw) this.zza.get(strZzb) : this.zzb).zza(strZzb, zzgVar, arrayListZzc);
    }

    public final void zzb(zzaw zzawVar) {
        Iterator it = zzawVar.zza.iterator();
        while (it.hasNext()) {
            this.zza.put(((zzbl) it.next()).zzb().toString(), zzawVar);
        }
    }
}
