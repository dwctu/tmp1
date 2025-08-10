package dc;

import android.graphics.drawable.Drawable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: SkinCompatVersionUtils.java */
/* loaded from: classes5.dex */
public final class mi4 {
    public static Class<?> a;
    public static Method b;
    public static Method c;
    public static Class<?> d;
    public static Method e;
    public static Method f;
    public static Class<?> g;
    public static Method h;

    static {
        try {
            d = Class.forName("android.support.v4.graphics.drawable.WrappedDrawable");
        } catch (ClassNotFoundException unused) {
            if (pi4.a) {
                pi4.a("SkinCompatUtils", "hasV4WrappedDrawable = false");
            }
        }
        try {
            a = Class.forName("android.support.v4.graphics.drawable.DrawableWrapper");
        } catch (ClassNotFoundException unused2) {
            if (pi4.a) {
                pi4.a("SkinCompatUtils", "hasV4DrawableWrapper = false");
            }
        }
        try {
            g = Class.forName("android.support.v7.graphics.drawable.DrawableWrapper");
        } catch (ClassNotFoundException unused3) {
            if (pi4.a) {
                pi4.a("SkinCompatUtils", "hasV7DrawableWrapper = false");
            }
        }
    }

    public static Drawable a(Drawable drawable) throws NoSuchMethodException, SecurityException {
        Class<?> cls = a;
        if (cls != null) {
            if (b == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    b = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "getV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = b;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e2) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "getV4DrawableWrapperWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
        return drawable;
    }

    public static Drawable b(Drawable drawable) throws NoSuchMethodException, SecurityException {
        Class<?> cls = d;
        if (cls != null) {
            if (e == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    e = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "getV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = e;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e2) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "getV4WrappedDrawableWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
        return drawable;
    }

    public static Drawable c(Drawable drawable) throws NoSuchMethodException, SecurityException {
        Class<?> cls = g;
        if (cls != null) {
            if (h == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("getWrappedDrawable", new Class[0]);
                    h = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "getV7DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = h;
            if (method != null) {
                try {
                    return (Drawable) method.invoke(drawable, new Object[0]);
                } catch (Exception e2) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "getV7DrawableWrapperWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
        return drawable;
    }

    public static boolean d(Drawable drawable) {
        Class<?> cls = a;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static boolean e(Drawable drawable) {
        Class<?> cls = d;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static boolean f(Drawable drawable) {
        Class<?> cls = g;
        return cls != null && cls.isAssignableFrom(drawable.getClass());
    }

    public static void g(Drawable drawable, Drawable drawable2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = a;
        if (cls != null) {
            if (c == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "setV4DrawableWrapperWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = c;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e2) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "setV4DrawableWrapperWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
    }

    public static void h(Drawable drawable, Drawable drawable2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = d;
        if (cls != null) {
            if (f == null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setWrappedDrawable", Drawable.class);
                    f = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "setV4WrappedDrawableWrappedDrawable No Such Method");
                    }
                }
            }
            Method method = f;
            if (method != null) {
                try {
                    method.invoke(drawable, drawable2);
                } catch (Exception e2) {
                    if (pi4.a) {
                        pi4.a("SkinCompatUtils", "setV4WrappedDrawableWrappedDrawable invoke error: " + e2);
                    }
                }
            }
        }
    }
}
