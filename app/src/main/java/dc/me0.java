package dc;

import android.app.Application;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.mmkv.MMKV;

/* compiled from: SP.java */
/* loaded from: classes.dex */
public final class me0 {
    public static me0 b;
    public MMKV a;

    public static boolean a(String str, boolean z) {
        return b().a.c(str, z);
    }

    public static me0 b() {
        if (b == null) {
            synchronized (me0.class) {
                if (b == null) {
                    b = new me0();
                }
            }
        }
        return b;
    }

    public static long c(String str, long j) {
        return b().a.e(str, j);
    }

    public static <T extends Parcelable> T d(String str, Class<T> cls) {
        return (T) e(str, cls, null);
    }

    public static <T extends Parcelable> T e(String str, Class<T> cls, @Nullable T t) {
        return (T) b().a.f(str, cls, t);
    }

    public static String f(String str, String str2) {
        return b().a.g(str, str2);
    }

    public static void g(Application application) {
        try {
            de0.l(" rootDir = " + MMKV.u(application));
            b().a = MMKV.j();
        } catch (Throwable unused) {
        }
    }

    public static void h(String str, long j) {
        b().a.o(str, j);
    }

    public static void i(String str, Parcelable parcelable) {
        b().a.p(str, parcelable);
    }

    public static void j(String str, String str2) {
        b().a.q(str, str2);
    }

    public static void k(String str, boolean z) {
        b().a.s(str, z);
    }

    public static void l(String str) {
        b().a.remove(str);
    }
}
