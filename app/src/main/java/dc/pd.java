package dc;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;

/* compiled from: ARouter.java */
/* loaded from: classes.dex */
public final class pd {
    public static volatile pd a = null;
    public static volatile boolean b = false;
    public static ILogger c;

    public static boolean b() {
        return qd.h();
    }

    public static pd c() {
        if (!b) {
            throw new InitException("ARouter::Init::Invoke init(context) first!");
        }
        if (a == null) {
            synchronized (pd.class) {
                if (a == null) {
                    a = new pd();
                }
            }
        }
        return a;
    }

    public static void d(Application application) {
        if (b) {
            return;
        }
        ILogger iLogger = qd.a;
        c = iLogger;
        iLogger.info(ILogger.defaultTag, "ARouter init start.");
        b = qd.k(application);
        if (b) {
            qd.e();
        }
        qd.a.info(ILogger.defaultTag, "ARouter init over.");
    }

    public static synchronized void h() {
        qd.o();
    }

    public static synchronized void i() {
        qd.p();
    }

    public Postcard a(String str) {
        return qd.j().f(str);
    }

    public void e(Object obj) {
        qd.l(obj);
    }

    public Object f(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        return qd.j().m(context, postcard, i, navigationCallback);
    }

    public <T> T g(Class<? extends T> cls) {
        return (T) qd.j().n(cls);
    }
}
