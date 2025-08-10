package dc;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import com.broadcom.bt.util.io.IOUtils;
import com.google.gson.Gson;
import dc.de0;
import dc.ee0;
import dc.ve0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: UtilsBridge.java */
/* loaded from: classes.dex */
public class xe0 {

    /* compiled from: UtilsBridge.java */
    public static final class a {
        public String a;
        public LinkedHashMap<String, String> b = new LinkedHashMap<>();
        public LinkedHashMap<String, String> c = new LinkedHashMap<>();

        public a(String str) {
            this.a = str;
        }

        public void a(String str, String str2) {
            b(this.b, str, str2);
        }

        public final void b(Map<String, String> map, String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            int length = 19 - str.length();
            if (length > 0) {
                str = str + "                   ".substring(0, length);
            }
            map.put(str, str2);
        }

        public String c() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = "************* " + this.a + " Head ****************\n";
            sb.append(str);
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            sb.append("Rom Info           : ");
            sb.append(ke0.c());
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("Device Manufacturer: ");
            sb.append(Build.MANUFACTURER);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("Device Model       : ");
            sb.append(Build.MODEL);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("Android Version    : ");
            sb.append(Build.VERSION.RELEASE);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("Android SDK        : ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("App VersionName    : ");
            sb.append(gd0.g());
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append("App VersionCode    : ");
            sb.append(gd0.e());
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(c());
            sb.append(str);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            return sb.toString();
        }
    }

    public static Activity A() {
        return we0.g.o();
    }

    public static void B(Application application) {
        we0.g.p(application);
        C();
        me0.g(application);
    }

    public static void C() {
        de0.d dVarR = de0.r();
        dVarR.z(gd0.i());
        dVarR.x(gd0.i());
        dVarR.y(true);
        dVarR.A(3);
    }

    public static byte[] D(InputStream inputStream) {
        return qd0.i(inputStream);
    }

    public static boolean E(Activity activity) {
        return ed0.g(activity);
    }

    public static boolean F() {
        return we0.g.q();
    }

    public static boolean G(File file) {
        return vd0.s(file);
    }

    @RequiresApi(api = 23)
    public static boolean H() {
        return he0.a();
    }

    public static boolean I() {
        return ye0.a();
    }

    public static boolean J() {
        return le0.a();
    }

    public static boolean K(String str) {
        return re0.f(str);
    }

    public static View L(@LayoutRes int i) {
        return ye0.b(i);
    }

    public static void M() {
        N(fd0.f());
    }

    public static void N(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            se0.b().execute(runnable);
        }
    }

    public static void O(ve0.a aVar) {
        we0.g.v(aVar);
    }

    public static void P(ve0.c cVar) {
        we0.g.x(cVar);
    }

    public static void Q(Runnable runnable) {
        se0.f(runnable);
    }

    public static void R(Runnable runnable, long j) {
        se0.g(runnable, j);
    }

    public static String S(Object obj) {
        return xd0.j(obj);
    }

    public static void T(Application application) {
        we0.g.A(application);
    }

    public static Bitmap U(View view) {
        return yd0.a(view);
    }

    public static boolean V(String str, String str2, boolean z) {
        return ud0.f(str, str2, z);
    }

    public static void a(ve0.a aVar) {
        we0.g.d(aVar);
    }

    public static void b(ve0.c cVar) {
        we0.g.f(cVar);
    }

    public static String c(byte[] bArr) {
        return qd0.a(bArr);
    }

    public static void d(Closeable... closeableArr) throws IOException {
        nd0.a(closeableArr);
    }

    public static boolean e(File file) {
        return vd0.a(file);
    }

    public static boolean f(File file) {
        return vd0.b(file);
    }

    public static int g(float f) {
        return qe0.a(f);
    }

    public static void h() {
        ed0.b();
    }

    public static void i(Activity activity) {
        be0.a(activity);
    }

    public static String j(@Nullable String str, Object... objArr) {
        return re0.a(str, objArr);
    }

    public static String k(String str) {
        return ae0.a(str);
    }

    public static <T> T l(String str, Type type) {
        return (T) xd0.e(str, type);
    }

    public static List<WeakReference<Activity>> m() {
        return we0.g.j();
    }

    public static int n() {
        return oe0.a();
    }

    public static Application o() {
        return we0.g.n();
    }

    public static String p() {
        return ie0.a();
    }

    public static File q(String str) {
        return vd0.l(str);
    }

    public static String r(Throwable th) {
        return te0.a(th);
    }

    public static Gson s() {
        return xd0.g();
    }

    public static Intent t(String str) {
        return zd0.a(str);
    }

    public static String u(String str) {
        return ed0.d(str);
    }

    public static int v() {
        return id0.a();
    }

    public static Notification w(ee0.a aVar, ve0.b<NotificationCompat.Builder> bVar) {
        return ee0.a(aVar, bVar);
    }

    public static ne0 x() {
        return ne0.e("Utils");
    }

    public static int y() {
        return id0.b();
    }

    public static String z(@StringRes int i) {
        return re0.b(i);
    }
}
