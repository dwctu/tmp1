package dc;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: LogisticsCenter.java */
/* loaded from: classes.dex */
public class nd {
    public static Context a;
    public static ThreadPoolExecutor b;
    public static boolean c;

    /* compiled from: LogisticsCenter.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RouteType.values().length];
            a = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RouteType.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static synchronized void a(String str, IRouteGroup iRouteGroup) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (od.a.containsKey(str)) {
            od.a.get(str).getConstructor(new Class[0]).newInstance(new Object[0]).loadInto(od.b);
            od.a.remove(str);
        }
        if (iRouteGroup != null) {
            iRouteGroup.loadInto(od.b);
        }
    }

    public static Postcard b(String str) {
        RouteMeta routeMeta = od.d.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void c(Postcard postcard) {
        if (postcard == null) {
            throw new NoRouteFoundException("ARouter::No postcard!");
        }
        RouteMeta routeMeta = od.b.get(postcard.getPath());
        if (routeMeta != null) {
            postcard.setDestination(routeMeta.getDestination());
            postcard.setType(routeMeta.getType());
            postcard.setPriority(routeMeta.getPriority());
            postcard.setExtra(routeMeta.getExtra());
            Uri uri = postcard.getUri();
            if (uri != null) {
                Map<String, String> mapC = yd.c(uri);
                Map<String, Integer> paramsType = routeMeta.getParamsType();
                if (wd.b(paramsType)) {
                    for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                        f(postcard, entry.getValue(), entry.getKey(), mapC.get(entry.getKey()));
                    }
                    postcard.getExtras().putStringArray("wmHzgD4lOj5o4241", (String[]) paramsType.keySet().toArray(new String[0]));
                }
                postcard.withString("NTeRQWvye18AkPd6G", uri.toString());
            }
            int i = a.a[routeMeta.getType().ordinal()];
            if (i == 1) {
                Class<?> destination = routeMeta.getDestination();
                IProvider iProvider = od.c.get(destination);
                if (iProvider == null) {
                    try {
                        iProvider = (IProvider) destination.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iProvider.init(a);
                        od.c.put(destination, iProvider);
                    } catch (Exception e) {
                        pd.c.error(ILogger.defaultTag, "Init provider failed!", e);
                        throw new HandlerException("Init provider failed!");
                    }
                }
                postcard.setProvider(iProvider);
                postcard.greenChannel();
            } else if (i == 2) {
                postcard.greenChannel();
            }
        } else {
            if (!od.a.containsKey(postcard.getGroup())) {
                throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
            }
            try {
                if (pd.b()) {
                    pd.c.debug(ILogger.defaultTag, String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                a(postcard.getGroup(), null);
                if (pd.b()) {
                    pd.c.debug(ILogger.defaultTag, String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                }
                c(postcard);
            } catch (Exception e2) {
                throw new HandlerException("ARouter::Fatal exception when loading group meta. [" + e2.getMessage() + "]");
            }
        }
    }

    public static synchronized void d(Context context, ThreadPoolExecutor threadPoolExecutor) throws HandlerException {
        Set<String> setA;
        a = context;
        b = threadPoolExecutor;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            e();
            if (c) {
                pd.c.info(ILogger.defaultTag, "Load router map by arouter-auto-register plugin.");
            } else {
                if (pd.b() || xd.b(context)) {
                    pd.c.info(ILogger.defaultTag, "Run with debug mode or new install, rebuild router map.");
                    setA = ud.a(a, "com.alibaba.android.arouter.routes");
                    if (!setA.isEmpty()) {
                        context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putStringSet("ROUTER_MAP", setA).apply();
                    }
                    xd.c(context);
                } else {
                    pd.c.info(ILogger.defaultTag, "Load router map from cache.");
                    setA = new HashSet<>(context.getSharedPreferences("SP_AROUTER_CACHE", 0).getStringSet("ROUTER_MAP", new HashSet()));
                }
                pd.c.info(ILogger.defaultTag, "Find router map finished, map size = " + setA.size() + ", cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                jCurrentTimeMillis = System.currentTimeMillis();
                for (String str : setA) {
                    if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Root")) {
                        ((IRouteRoot) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(od.a);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Interceptors")) {
                        ((IInterceptorGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(od.e);
                    } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Providers")) {
                        ((IProviderGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(od.d);
                    }
                }
            }
            pd.c.info(ILogger.defaultTag, "Load root element finished, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
            if (od.a.size() == 0) {
                pd.c.error(ILogger.defaultTag, "No mapping files were found, check your configuration please!");
            }
            if (pd.b()) {
                pd.c.debug(ILogger.defaultTag, String.format(Locale.getDefault(), "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]", Integer.valueOf(od.a.size()), Integer.valueOf(od.e.size()), Integer.valueOf(od.d.size())));
            }
        } catch (Exception e) {
            throw new HandlerException("ARouter::ARouter init logistics center exception! [" + e.getMessage() + "]");
        }
    }

    public static void e() {
        c = false;
    }

    public static void f(Postcard postcard, Integer num, String str, String str2) {
        if (yd.b(str) || yd.b(str2)) {
            return;
        }
        try {
            if (num == null) {
                postcard.withString(str, str2);
            } else if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                postcard.withBoolean(str, Boolean.parseBoolean(str2));
            } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                postcard.withByte(str, Byte.parseByte(str2));
            } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                postcard.withShort(str, Short.parseShort(str2));
            } else if (num.intValue() == TypeKind.INT.ordinal()) {
                postcard.withInt(str, Integer.parseInt(str2));
            } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                postcard.withLong(str, Long.parseLong(str2));
            } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                postcard.withFloat(str, Float.parseFloat(str2));
            } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                postcard.withDouble(str, Double.parseDouble(str2));
            } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                postcard.withString(str, str2);
            } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(str, str2);
                } else {
                    postcard.withString(str, str2);
                }
            }
        } catch (Throwable th) {
            pd.c.warning(ILogger.defaultTag, "LogisticsCenter setValue failed! " + th.getMessage());
        }
    }
}
