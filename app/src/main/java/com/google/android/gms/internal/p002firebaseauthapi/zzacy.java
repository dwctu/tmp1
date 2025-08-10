package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzacy extends zzada {
    private zzacy() {
        super(null);
    }

    public /* synthetic */ zzacy(zzacx zzacxVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzada
    public final List zza(Object obj, long j) {
        zzacm zzacmVar = (zzacm) zzaez.zzf(obj, j);
        if (zzacmVar.zzc()) {
            return zzacmVar;
        }
        int size = zzacmVar.size();
        zzacm zzacmVarZzd = zzacmVar.zzd(size == 0 ? 10 : size + size);
        zzaez.zzs(obj, j, zzacmVarZzd);
        return zzacmVarZzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzada
    public final void zzb(Object obj, long j) {
        ((zzacm) zzaez.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzada
    public final void zzc(Object obj, Object obj2, long j) {
        zzacm zzacmVarZzd = (zzacm) zzaez.zzf(obj, j);
        zzacm zzacmVar = (zzacm) zzaez.zzf(obj2, j);
        int size = zzacmVarZzd.size();
        int size2 = zzacmVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzacmVarZzd.zzc()) {
                zzacmVarZzd = zzacmVarZzd.zzd(size2 + size);
            }
            zzacmVarZzd.addAll(zzacmVar);
        }
        if (size > 0) {
            zzacmVar = zzacmVarZzd;
        }
        zzaez.zzs(obj, j, zzacmVar);
    }
}
