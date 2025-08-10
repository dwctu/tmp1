package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfr implements zzbj {
    private final SharedPreferences.Editor zza;
    private final String zzb = "GenericIdpKeyset";

    public zzfr(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final void zzb(zzlq zzlqVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzpl.zza(zzlqVar.zzr())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbj
    public final void zzc(zznh zznhVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzpl.zza(zznhVar.zzr())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
