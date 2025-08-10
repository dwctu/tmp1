package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.zbt;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public final class RevocationBoundService extends Service {
    @Override // android.app.Service
    @RecentlyNullable
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) || "com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            if (Log.isLoggable("RevocationService", 2)) {
                String strValueOf = String.valueOf(intent.getAction());
                if (strValueOf.length() != 0) {
                    "RevocationBoundService handling ".concat(strValueOf);
                } else {
                    new String("RevocationBoundService handling ");
                }
            }
            return new zbt(this);
        }
        String strValueOf2 = String.valueOf(intent.getAction());
        if (strValueOf2.length() != 0) {
            "Unknown action sent to RevocationBoundService: ".concat(strValueOf2);
            return null;
        }
        new String("Unknown action sent to RevocationBoundService: ");
        return null;
    }
}
