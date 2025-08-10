package dc;

import android.os.Build;
import com.google.android.vending.expansion.downloader.Constants;
import java.util.UUID;

/* compiled from: DeviceUtils.java */
/* loaded from: classes.dex */
public final class rd0 {
    public static String a() {
        return Build.MANUFACTURER;
    }

    public static String b() {
        String str = Build.MODEL;
        return str != null ? str.trim().replaceAll("\\s*", "") : "";
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }

    public static String d() {
        return UUID.randomUUID().toString().replaceAll(Constants.FILENAME_SEQUENCE_SEPARATOR, "");
    }

    public static boolean e() {
        return new dd0().a(ve0.a());
    }

    public static boolean f() {
        return new bd0().k(ve0.a()) || zc0.i(ve0.a(), null);
    }

    public static boolean g() {
        return new cd0().e(ve0.a());
    }
}
