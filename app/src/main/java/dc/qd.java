package dc;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: _ARouter.java */
/* loaded from: classes.dex */
public final class qd {
    public static ILogger a = new vd(ILogger.defaultTag);
    public static volatile boolean b = false;
    public static volatile qd c = null;
    public static volatile boolean d = false;
    public static volatile ThreadPoolExecutor e = sd.a();
    public static Handler f;
    public static Context g;
    public static InterceptorService h;

    /* compiled from: _ARouter.java */
    public class a implements Runnable {
        public final /* synthetic */ Postcard a;

        public a(qd qdVar, Postcard postcard) {
            this.a = postcard;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(qd.g, "There's no route matched!\n Path = [" + this.a.getPath() + "]\n Group = [" + this.a.getGroup() + "]", 1).show();
        }
    }

    /* compiled from: _ARouter.java */
    public class b implements InterceptorCallback {
        public final /* synthetic */ int a;
        public final /* synthetic */ NavigationCallback b;
        public final /* synthetic */ Postcard c;

        public b(int i, NavigationCallback navigationCallback, Postcard postcard) {
            this.a = i;
            this.b = navigationCallback;
            this.c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            qd.this.a(postcard, this.a, this.b);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th) {
            NavigationCallback navigationCallback = this.b;
            if (navigationCallback != null) {
                navigationCallback.onInterrupt(this.c);
            }
            qd.a.info(ILogger.defaultTag, "Navigation failed, termination by interceptor : " + th.getMessage());
        }
    }

    /* compiled from: _ARouter.java */
    public class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Intent c;
        public final /* synthetic */ Postcard d;
        public final /* synthetic */ NavigationCallback e;

        public c(int i, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
            this.a = i;
            this.b = context;
            this.c = intent;
            this.d = postcard;
            this.e = navigationCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            qd.this.r(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* compiled from: _ARouter.java */
    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RouteType.values().length];
            a = iArr;
            try {
                iArr[RouteType.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RouteType.PROVIDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RouteType.BOARDCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RouteType.FRAGMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RouteType.METHOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RouteType.SERVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static void e() {
        h = (InterceptorService) pd.c().a("/arouter/service/interceptor").navigation();
    }

    public static boolean h() {
        return b;
    }

    public static qd j() {
        if (!d) {
            throw new InitException("ARouterCore::Init::Invoke init(context) first!");
        }
        if (c == null) {
            synchronized (qd.class) {
                if (c == null) {
                    c = new qd();
                }
            }
        }
        return c;
    }

    public static synchronized boolean k(Application application) {
        g = application;
        nd.d(application, e);
        a.info(ILogger.defaultTag, "ARouter init success!");
        d = true;
        f = new Handler(Looper.getMainLooper());
        return true;
    }

    public static void l(Object obj) {
        AutowiredService autowiredService = (AutowiredService) pd.c().a("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public static synchronized void o() {
        b = true;
        a.info(ILogger.defaultTag, "ARouter openDebug");
    }

    public static synchronized void p() {
        a.showLog(true);
        a.info(ILogger.defaultTag, "ARouter openLog");
    }

    public final Object a(Postcard postcard, int i, NavigationCallback navigationCallback) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Context context = postcard.getContext();
        int i2 = d.a[postcard.getType().ordinal()];
        if (i2 == 1) {
            Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            String action = postcard.getAction();
            if (!yd.b(action)) {
                intent.setAction(action);
            }
            q(new c(i, context, intent, postcard, navigationCallback));
            return null;
        }
        if (i2 == 2) {
            return postcard.getProvider();
        }
        if (i2 == 3 || i2 == 4 || i2 == 5) {
            try {
                Object objNewInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                if (objNewInstance instanceof Fragment) {
                    ((Fragment) objNewInstance).setArguments(postcard.getExtras());
                } else if (objNewInstance instanceof androidx.fragment.app.Fragment) {
                    ((androidx.fragment.app.Fragment) objNewInstance).setArguments(postcard.getExtras());
                }
                return objNewInstance;
            } catch (Exception e2) {
                a.error(ILogger.defaultTag, "Fetch fragment instance error, " + yd.a(e2.getStackTrace()));
            }
        }
        return null;
    }

    public Postcard f(String str) {
        if (yd.b(str)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) pd.c().g(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return g(str, i(str), Boolean.TRUE);
    }

    public Postcard g(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (yd.b(str) || yd.b(str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) pd.c().g(PathReplaceService.class)) != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    public final String i(String str) {
        if (yd.b(str) || !str.startsWith("/")) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String strSubstring = str.substring(1, str.indexOf("/", 1));
            if (yd.b(strSubstring)) {
                throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
            }
            return strSubstring;
        } catch (Exception e2) {
            a.warning(ILogger.defaultTag, "Failed to extract default group! " + e2.getMessage());
            return null;
        }
    }

    public Object m(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) pd.c().g(PretreatmentService.class);
        if (pretreatmentService != null && !pretreatmentService.onPretreatment(context, postcard)) {
            return null;
        }
        postcard.setContext(context == null ? g : context);
        try {
            nd.c(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return a(postcard, i, navigationCallback);
            }
            h.doInterceptions(postcard, new b(i, navigationCallback, postcard));
            return null;
        } catch (NoRouteFoundException e2) {
            a.warning(ILogger.defaultTag, e2.getMessage());
            if (h()) {
                q(new a(this, postcard));
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) pd.c().g(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public <T> T n(Class<? extends T> cls) {
        try {
            Postcard postcardB = nd.b(cls.getName());
            if (postcardB == null) {
                postcardB = nd.b(cls.getSimpleName());
            }
            if (postcardB == null) {
                return null;
            }
            postcardB.setContext(g);
            nd.c(postcardB);
            return (T) postcardB.getProvider();
        } catch (NoRouteFoundException e2) {
            a.warning(ILogger.defaultTag, e2.getMessage());
            return null;
        }
    }

    public final void q(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f.post(runnable);
        } else {
            runnable.run();
        }
    }

    public final void r(int i, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i < 0) {
            ContextCompat.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.startActivityForResult((Activity) context, intent, i, postcard.getOptionsBundle());
        } else {
            a.warning(ILogger.defaultTag, "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }
}
