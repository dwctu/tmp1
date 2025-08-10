package dc;

import android.content.res.Resources;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;

/* compiled from: BarUtils.java */
/* loaded from: classes.dex */
public final class id0 {
    public static int a() {
        Resources resources = ve0.a().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int b() {
        Resources resources = ve0.a().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE));
    }
}
