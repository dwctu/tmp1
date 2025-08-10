package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzxm {
    private final String zza;
    private final String zzb;

    public zzxm(Context context, String str) {
        Preconditions.checkNotNull(context);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(str);
        this.zza = strCheckNotEmpty;
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, strCheckNotEmpty);
            if (packageCertificateHashBytes != null) {
                this.zzb = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            } else {
                "single cert required: ".concat(String.valueOf(str));
                this.zzb = null;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            "no pkg: ".concat(String.valueOf(str));
            this.zzb = null;
        }
    }

    @Nullable
    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
