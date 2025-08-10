package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public abstract class zzaep {
    public abstract int zza(Object obj);

    public abstract int zzb(Object obj);

    public abstract Object zzc(Object obj);

    public abstract Object zzd(Object obj);

    public abstract Object zze(Object obj, Object obj2);

    public abstract Object zzf();

    public abstract Object zzg(Object obj);

    public abstract void zzh(Object obj, int i, int i2);

    public abstract void zzi(Object obj, int i, long j);

    public abstract void zzj(Object obj, int i, Object obj2);

    public abstract void zzk(Object obj, int i, zzabe zzabeVar);

    public abstract void zzl(Object obj, int i, long j);

    public abstract void zzm(Object obj);

    public abstract void zzn(Object obj, Object obj2);

    public abstract void zzo(Object obj, Object obj2);

    public final boolean zzp(Object obj, zzadx zzadxVar) throws IOException {
        int iZzd = zzadxVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzl(obj, i, zzadxVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zzi(obj, i, zzadxVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzk(obj, i, zzadxVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzacp.zza();
            }
            zzh(obj, i, zzadxVar.zzf());
            return true;
        }
        Object objZzf = zzf();
        int i3 = 4 | (i << 3);
        while (zzadxVar.zzc() != Integer.MAX_VALUE && zzp(objZzf, zzadxVar)) {
        }
        if (i3 != zzadxVar.zzd()) {
            throw zzacp.zzb();
        }
        zzg(objZzf);
        zzj(obj, i, objZzf);
        return true;
    }

    public abstract boolean zzq(zzadx zzadxVar);

    public abstract void zzr(Object obj, zzabq zzabqVar) throws IOException;
}
