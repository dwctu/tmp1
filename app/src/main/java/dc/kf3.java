package dc;

import android.content.Context;
import android.os.Build;
import com.wear.util.WearUtils;

/* compiled from: OaidUtils.java */
/* loaded from: classes4.dex */
public class kf3 {
    public static String a(Context context) {
        return "Remote/" + WearUtils.q + " (" + Build.MODEL + ";Android" + Build.VERSION.RELEASE + ") DeviceID/" + tz.i();
    }
}
