package dc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

/* compiled from: AndroidVersion.java */
@SuppressLint({"AnnotateVersionCheck"})
/* loaded from: classes2.dex */
public final class n51 {
    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    public static int b(Context context) {
        return context.getApplicationInfo().targetSdkVersion;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean n() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean o() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
