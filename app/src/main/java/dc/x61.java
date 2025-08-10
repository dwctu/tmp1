package dc;

import android.annotation.SuppressLint;
import android.app.Application;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: NotificationToast.java */
/* loaded from: classes2.dex */
public class x61 extends a71 {
    public static boolean b;

    public x61(Application application) {
        super(application);
    }

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    public static void b() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (b) {
            return;
        }
        b = true;
        try {
            Method declaredMethod = Toast.class.getDeclaredMethod("getService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke == null) {
                return;
            }
            if (Proxy.isProxyClass(objInvoke.getClass()) && (Proxy.getInvocationHandler(objInvoke) instanceof w61)) {
                return;
            }
            Object objNewProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.INotificationManager")}, new w61(objInvoke));
            Field declaredField = Toast.class.getDeclaredField("sService");
            declaredField.setAccessible(true);
            declaredField.set(null, objNewProxyInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.Toast, dc.i71
    public void show() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        b();
        super.show();
    }
}
