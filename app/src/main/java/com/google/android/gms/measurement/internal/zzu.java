package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzny;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzu {
    public final /* synthetic */ zzaa zza;
    private String zzb;
    private boolean zzc;
    private com.google.android.gms.internal.measurement.zzgh zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public /* synthetic */ zzu(zzaa zzaaVar, String str, zzt zztVar) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    @NonNull
    public final com.google.android.gms.internal.measurement.zzfo zza(int i) {
        ArrayList arrayList;
        List listEmptyList;
        com.google.android.gms.internal.measurement.zzfn zzfnVarZzb = com.google.android.gms.internal.measurement.zzfo.zzb();
        zzfnVarZzb.zza(i);
        zzfnVarZzb.zzc(this.zzc);
        com.google.android.gms.internal.measurement.zzgh zzghVar = this.zzd;
        if (zzghVar != null) {
            zzfnVarZzb.zzd(zzghVar);
        }
        com.google.android.gms.internal.measurement.zzgg zzggVarZzf = com.google.android.gms.internal.measurement.zzgh.zzf();
        zzggVarZzf.zzb(zzlb.zzr(this.zze));
        zzggVarZzf.zzd(zzlb.zzr(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            Iterator it = this.zzg.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                Long l = (Long) this.zzg.get(Integer.valueOf(iIntValue));
                if (l != null) {
                    com.google.android.gms.internal.measurement.zzfp zzfpVarZzc = com.google.android.gms.internal.measurement.zzfq.zzc();
                    zzfpVarZzc.zzb(iIntValue);
                    zzfpVarZzc.zza(l.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzfq) zzfpVarZzc.zzaE());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzggVarZzf.zza(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.zzh.keySet()) {
                com.google.android.gms.internal.measurement.zzgi zzgiVarZzd = com.google.android.gms.internal.measurement.zzgj.zzd();
                zzgiVarZzd.zzb(num.intValue());
                List list = (List) this.zzh.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzgiVarZzd.zza(list);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzgj) zzgiVarZzd.zzaE());
            }
            listEmptyList = arrayList3;
        }
        zzggVarZzf.zzc(listEmptyList);
        zzfnVarZzb.zzb(zzggVarZzf);
        return (com.google.android.gms.internal.measurement.zzfo) zzfnVarZzb.zzaE();
    }

    public final void zzc(@NonNull zzy zzyVar) {
        int iZza = zzyVar.zza();
        Boolean bool = zzyVar.zzd;
        if (bool != null) {
            this.zzf.set(iZza, bool.booleanValue());
        }
        Boolean bool2 = zzyVar.zze;
        if (bool2 != null) {
            this.zze.set(iZza, bool2.booleanValue());
        }
        if (zzyVar.zzf != null) {
            Map map = this.zzg;
            Integer numValueOf = Integer.valueOf(iZza);
            Long l = (Long) map.get(numValueOf);
            long jLongValue = zzyVar.zzf.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzg.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (zzyVar.zzg != null) {
            Map map2 = this.zzh;
            Integer numValueOf2 = Integer.valueOf(iZza);
            List arrayList = (List) map2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.zzh.put(numValueOf2, arrayList);
            }
            if (zzyVar.zzc()) {
                arrayList.clear();
            }
            zzny.zzc();
            zzag zzagVarZzf = this.zza.zzs.zzf();
            String str = this.zzb;
            zzea zzeaVar = zzeb.zzW;
            if (zzagVarZzf.zzs(str, zzeaVar) && zzyVar.zzb()) {
                arrayList.clear();
            }
            zzny.zzc();
            if (!this.zza.zzs.zzf().zzs(this.zzb, zzeaVar)) {
                arrayList.add(Long.valueOf(zzyVar.zzg.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(zzyVar.zzg.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public /* synthetic */ zzu(zzaa zzaaVar, String str, com.google.android.gms.internal.measurement.zzgh zzghVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzt zztVar) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzghVar;
    }
}
