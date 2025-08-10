package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.auth.zze;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzsw implements zzxi {
    public final /* synthetic */ zzxh zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ Boolean zzd;
    public final /* synthetic */ zze zze;
    public final /* synthetic */ zzwc zzf;
    public final /* synthetic */ zzza zzg;

    public zzsw(zzuh zzuhVar, zzxh zzxhVar, String str, String str2, Boolean bool, zze zzeVar, zzwc zzwcVar, zzza zzzaVar) {
        this.zza = zzxhVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzeVar;
        this.zzf = zzwcVar;
        this.zzg = zzzaVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List listZzb = ((zzyr) obj).zzb();
        if (listZzb == null || listZzb.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        int i = 0;
        zzyt zzytVar = (zzyt) listZzb.get(0);
        zzzi zzziVarZzl = zzytVar.zzl();
        List listZzc = zzziVarZzl != null ? zzziVarZzl.zzc() : null;
        if (listZzc != null && !listZzc.isEmpty()) {
            if (TextUtils.isEmpty(this.zzb)) {
                ((zzzg) listZzc.get(0)).zzh(this.zzc);
            } else {
                while (true) {
                    if (i >= listZzc.size()) {
                        break;
                    }
                    if (((zzzg) listZzc.get(i)).zzf().equals(this.zzb)) {
                        ((zzzg) listZzc.get(i)).zzh(this.zzc);
                        break;
                    }
                    i++;
                }
            }
        }
        zzytVar.zzh(this.zzd.booleanValue());
        zzytVar.zze(this.zze);
        this.zzf.zzi(this.zzg, zzytVar);
    }
}
