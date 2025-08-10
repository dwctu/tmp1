package dc;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AdaptScreenUtils.java */
/* loaded from: classes.dex */
public final class fd0 {
    public static List<Field> a;

    /* compiled from: AdaptScreenUtils.java */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            fd0.g();
        }
    }

    public static void b(@NonNull Resources resources, float f) {
        resources.getDisplayMetrics().xdpi = f;
        ve0.a().getResources().getDisplayMetrics().xdpi = f;
        d(resources, f);
    }

    public static void c(Resources resources, float f) {
        Iterator<Field> it = a.iterator();
        while (it.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) it.next().get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(Resources resources, float f) {
        if (a != null) {
            c(resources, f);
            return;
        }
        a = new ArrayList();
        Class<?> superclass = resources.getClass();
        Field[] declaredFields = superclass.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics displayMetricsE = e(resources, field);
                    if (displayMetricsE != null) {
                        a.add(field);
                        displayMetricsE.xdpi = f;
                    }
                }
            }
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return;
            } else {
                declaredFields = superclass.getDeclaredFields();
            }
        }
    }

    public static DisplayMetrics e(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Runnable f() {
        return new a();
    }

    public static void g() {
        b(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
