package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzxu extends zzwc {
    public final /* synthetic */ zzxx zza;
    private final String zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzxu(zzxx zzxxVar, zzwc zzwcVar, String str) {
        super(zzwcVar);
        this.zza = zzxxVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwc
    public final void zzb(String str) {
        zzxx.zza.d("onCodeSent", new Object[0]);
        zzxw zzxwVar = (zzxw) this.zza.zzd.get(this.zzb);
        if (zzxwVar == null) {
            return;
        }
        Iterator it = zzxwVar.zzb.iterator();
        while (it.hasNext()) {
            ((zzwc) it.next()).zzb(str);
        }
        zzxwVar.zzg = true;
        zzxwVar.zzd = str;
        if (zzxwVar.zza <= 0) {
            this.zza.zzh(this.zzb);
        } else if (!zzxwVar.zzc) {
            this.zza.zzn(this.zzb);
        } else {
            if (zzag.zzd(zzxwVar.zze)) {
                return;
            }
            zzxx.zze(this.zza, this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwc
    public final void zzh(Status status) {
        zzxx.zza.e("SMS verification code request failed: " + CommonStatusCodes.getStatusCodeString(status.getStatusCode()) + " " + status.getStatusMessage(), new Object[0]);
        zzxw zzxwVar = (zzxw) this.zza.zzd.get(this.zzb);
        if (zzxwVar == null) {
            return;
        }
        Iterator it = zzxwVar.zzb.iterator();
        while (it.hasNext()) {
            ((zzwc) it.next()).zzh(status);
        }
        this.zza.zzj(this.zzb);
    }
}
