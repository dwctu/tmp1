package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* compiled from: SAFragmentUtils.java */
/* loaded from: classes.dex */
public class xr {

    @SuppressLint({"NewApi"})
    public static LruCache<String, WeakReference<Object>> a = new LruCache<>(Integer.MAX_VALUE);

    public static boolean a(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("getUserVisibleHint", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isHidden", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isResumed", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Activity d(Object obj) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                return (Activity) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean e(Object obj) throws ClassNotFoundException {
        Class<?> cls;
        Class<?> cls2;
        if (obj == null) {
            return false;
        }
        Class<?> cls3 = null;
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (Exception unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("android.support.v4.app.Fragment");
        } catch (Exception unused2) {
            cls2 = null;
        }
        try {
            cls3 = Class.forName("androidx.fragment.app.Fragment");
        } catch (Exception unused3) {
        }
        if (cls2 == null && cls3 == null && cls == null) {
            return false;
        }
        if (cls2 != null) {
            try {
                if (cls2.isInstance(obj)) {
                    return true;
                }
            } catch (Exception unused4) {
            }
        }
        if (cls3 != null && cls3.isInstance(obj)) {
            return true;
        }
        if (cls != null) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        try {
            objInvoke = obj.getClass().getMethod("getParentFragment", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            objInvoke = null;
        }
        try {
            if (objInvoke == null) {
                if (!b(obj) && a(obj) && c(obj)) {
                    return true;
                }
            } else if (!b(obj) && a(obj) && c(obj) && !b(objInvoke) && a(objInvoke) && c(objInvoke)) {
                return true;
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public static void g(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null || Build.VERSION.SDK_INT < 12) {
            return;
        }
        a.put(str, new WeakReference<>(obj));
    }

    public static String h(View view) {
        try {
            String str = null;
            for (ViewParent parent = view.getParent(); TextUtils.isEmpty(str) && (parent instanceof View); parent = parent.getParent()) {
                str = (String) ((View) parent).getTag(qr.a);
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }
}
