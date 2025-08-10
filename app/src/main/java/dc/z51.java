package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionDelegateImplV14.java */
@RequiresApi(api = 14)
/* loaded from: classes2.dex */
public class z51 implements y51 {
    public static Intent d(@NonNull Context context) {
        Intent intentPrepare = VpnService.prepare(context);
        return !m61.a(context, intentPrepare) ? l61.b(context) : intentPrepare;
    }

    public static boolean e(@NonNull Context context) {
        return VpnService.prepare(context) == null;
    }

    @Override // dc.y51
    public boolean a(@NonNull Context context, @NonNull String str) {
        if (m61.h(str, "android.permission.BIND_VPN_SERVICE")) {
            return e(context);
        }
        return true;
    }

    @Override // dc.y51
    public boolean b(@NonNull Activity activity, @NonNull String str) {
        return false;
    }

    @Override // dc.y51
    public Intent c(@NonNull Context context, @NonNull String str) {
        return m61.h(str, "android.permission.BIND_VPN_SERVICE") ? d(context) : l61.b(context);
    }
}
