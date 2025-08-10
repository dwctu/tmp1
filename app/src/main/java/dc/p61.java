package dc;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import androidx.annotation.NonNull;

/* compiled from: WindowPermissionCompat.java */
/* loaded from: classes2.dex */
public final class p61 {
    public static Intent a(@NonNull Context context) {
        if (!n51.l()) {
            if (n61.j()) {
                return o61.a(l61.d(context), l61.b(context));
            }
            if (n61.m()) {
                return o61.a(n61.n() ? l61.g(context) : null, l61.b(context));
            }
            return n61.i() ? o61.a(l61.c(context), l61.b(context)) : n61.p() ? o61.a(l61.k(context), l61.b(context)) : n61.o() ? o61.a(l61.i(context), l61.b(context)) : l61.b(context);
        }
        if (n51.d() && n61.m() && n61.n()) {
            return o61.a(l61.f(context), l61.b(context));
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(m61.l(context));
        return m61.a(context, intent) ? intent : l61.b(context);
    }

    public static boolean b(@NonNull Context context) {
        if (n51.l()) {
            return Settings.canDrawOverlays(context);
        }
        if (n51.i()) {
            return m61.e(context, "OP_SYSTEM_ALERT_WINDOW", 24);
        }
        return true;
    }
}
