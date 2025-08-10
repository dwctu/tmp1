package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzxv extends BroadcastReceiver {
    public final /* synthetic */ zzxx zza;
    private final String zzb;

    public zzxv(zzxx zzxxVar, String str) {
        this.zza = zzxxVar;
        this.zzb = str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).getStatusCode() == 0) {
                String str = (String) extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                zzxw zzxwVar = (zzxw) this.zza.zzd.get(this.zzb);
                if (zzxwVar == null) {
                    zzxx.zza.e("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    String strZzb = zzxx.zzb(str);
                    zzxwVar.zze = strZzb;
                    if (strZzb == null) {
                        zzxx.zza.e("Unable to extract verification code.", new Object[0]);
                    } else if (!zzag.zzd(zzxwVar.zzd)) {
                        zzxx.zze(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
