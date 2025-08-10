package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzwq {
    private final int zza;

    /* JADX WARN: Multi-variable type inference failed */
    public zzwq(String str) throws NumberFormatException {
        int i = -1;
        try {
            List listZzd = zzaf.zzc("[.-]").zzd(str);
            if (listZzd.size() == 1) {
                i = Integer.parseInt(str);
                str = str;
            } else {
                str = str;
                if (listZzd.size() >= 3) {
                    int i2 = (Integer.parseInt((String) listZzd.get(0)) * 1000000) + (Integer.parseInt((String) listZzd.get(1)) * 1000);
                    int i3 = Integer.parseInt((String) listZzd.get(2));
                    i = i2 + i3;
                    str = i3;
                }
            }
        } catch (IllegalArgumentException e) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                String.format("Version code parsing failed for: %s with exception %s.", str, e);
            }
        }
        this.zza = i;
    }

    public static zzwq zza() throws Throwable {
        String version = LibraryVersion.getInstance().getVersion("firebase-auth");
        if (TextUtils.isEmpty(version) || version.equals(GrsBaseInfo.CountryCodeSource.UNKNOWN)) {
            version = "-1";
        }
        return new zzwq(version);
    }

    public final String zzb() {
        return String.format("X%s", Integer.toString(this.zza));
    }
}
