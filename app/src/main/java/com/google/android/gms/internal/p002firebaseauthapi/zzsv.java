package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzsv implements zzxi {
    public final /* synthetic */ zzzq zza;
    public final /* synthetic */ zzyt zzb;
    public final /* synthetic */ zzwc zzc;
    public final /* synthetic */ zzza zzd;
    public final /* synthetic */ zzxh zze;
    public final /* synthetic */ zzuh zzf;

    public zzsv(zzuh zzuhVar, zzzq zzzqVar, zzyt zzytVar, zzwc zzwcVar, zzza zzzaVar, zzxh zzxhVar) {
        this.zzf = zzuhVar;
        this.zza = zzzqVar;
        this.zzb = zzytVar;
        this.zzc = zzwcVar;
        this.zzd = zzzaVar;
        this.zze = zzxhVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxh
    public final void zza(@Nullable String str) {
        this.zze.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzzr zzzrVar = (zzzr) obj;
        if (this.zza.zzn("EMAIL")) {
            this.zzb.zzg(null);
        } else {
            zzzq zzzqVar = this.zza;
            if (zzzqVar.zzk() != null) {
                this.zzb.zzg(zzzqVar.zzk());
            }
        }
        if (this.zza.zzn("DISPLAY_NAME")) {
            this.zzb.zzf(null);
        } else {
            zzzq zzzqVar2 = this.zza;
            if (zzzqVar2.zzj() != null) {
                this.zzb.zzf(zzzqVar2.zzj());
            }
        }
        if (this.zza.zzn("PHOTO_URL")) {
            this.zzb.zzj(null);
        } else {
            zzzq zzzqVar3 = this.zza;
            if (zzzqVar3.zzm() != null) {
                this.zzb.zzj(zzzqVar3.zzm());
            }
        }
        if (!TextUtils.isEmpty(this.zza.zzl())) {
            this.zzb.zzi(Base64Utils.encode("redacted".getBytes()));
        }
        List listZzf = zzzrVar.zzf();
        if (listZzf == null) {
            listZzf = new ArrayList();
        }
        this.zzb.zzk(listZzf);
        zzwc zzwcVar = this.zzc;
        zzza zzzaVar = this.zzd;
        Preconditions.checkNotNull(zzzaVar);
        Preconditions.checkNotNull(zzzrVar);
        String strZzd = zzzrVar.zzd();
        String strZze = zzzrVar.zze();
        if (!TextUtils.isEmpty(strZzd) && !TextUtils.isEmpty(strZze)) {
            zzzaVar = new zzza(strZze, strZzd, Long.valueOf(zzzrVar.zzb()), zzzaVar.zzg());
        }
        zzwcVar.zzi(zzzaVar, this.zzb);
    }
}
