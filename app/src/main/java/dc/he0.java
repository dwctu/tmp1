package dc;

import android.provider.Settings;
import androidx.annotation.RequiresApi;

/* compiled from: PermissionUtils.java */
/* loaded from: classes.dex */
public final class he0 {
    @RequiresApi(api = 23)
    public static boolean a() {
        return Settings.canDrawOverlays(ve0.a());
    }
}
