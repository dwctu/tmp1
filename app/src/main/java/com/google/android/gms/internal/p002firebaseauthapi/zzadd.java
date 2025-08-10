package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzadd implements zzadk {
    private final zzadk[] zza;

    public zzadd(zzadk... zzadkVarArr) {
        this.zza = zzadkVarArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadk
    public final zzadj zzb(Class cls) {
        zzadk[] zzadkVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzadk zzadkVar = zzadkVarArr[i];
            if (zzadkVar.zzc(cls)) {
                return zzadkVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadk
    public final boolean zzc(Class cls) {
        zzadk[] zzadkVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzadkVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
