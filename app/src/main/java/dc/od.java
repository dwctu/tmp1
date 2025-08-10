package dc;

import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Warehouse.java */
/* loaded from: classes.dex */
public class od {
    public static Map<String, Class<? extends IRouteGroup>> a = new HashMap();
    public static Map<String, RouteMeta> b = new HashMap();
    public static Map<Class, IProvider> c = new HashMap();
    public static Map<String, RouteMeta> d = new HashMap();
    public static Map<Integer, Class<? extends IInterceptor>> e = new md("More than one interceptors use same priority [%s]");
    public static List<IInterceptor> f = new ArrayList();
}
