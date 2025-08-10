package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzacw extends zzada {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzacw() {
        super(null);
    }

    public /* synthetic */ zzacw(zzacv zzacvVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzf(Object obj, long j, int i) {
        zzact zzactVar;
        List list = (List) zzaez.zzf(obj, j);
        if (list.isEmpty()) {
            List zzactVar2 = list instanceof zzacu ? new zzact(i) : ((list instanceof zzadt) && (list instanceof zzacm)) ? ((zzacm) list).zzd(i) : new ArrayList(i);
            zzaez.zzs(obj, j, zzactVar2);
            return zzactVar2;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i);
            arrayList.addAll(list);
            zzaez.zzs(obj, j, arrayList);
            zzactVar = arrayList;
        } else {
            if (!(list instanceof zzaeu)) {
                if (!(list instanceof zzadt) || !(list instanceof zzacm)) {
                    return list;
                }
                zzacm zzacmVar = (zzacm) list;
                if (zzacmVar.zzc()) {
                    return list;
                }
                zzacm zzacmVarZzd = zzacmVar.zzd(list.size() + i);
                zzaez.zzs(obj, j, zzacmVarZzd);
                return zzacmVarZzd;
            }
            zzact zzactVar3 = new zzact(list.size() + i);
            zzactVar3.addAll(zzactVar3.size(), (zzaeu) list);
            zzaez.zzs(obj, j, zzactVar3);
            zzactVar = zzactVar3;
        }
        return zzactVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzada
    public final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzada
    public final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzaez.zzf(obj, j);
        if (list instanceof zzacu) {
            objUnmodifiableList = ((zzacu) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzadt) && (list instanceof zzacm)) {
                zzacm zzacmVar = (zzacm) list;
                if (zzacmVar.zzc()) {
                    zzacmVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzaez.zzs(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzada
    public final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzaez.zzf(obj2, j);
        List listZzf = zzf(obj, j, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzaez.zzs(obj, j, list);
    }
}
