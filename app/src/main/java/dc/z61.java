package dc;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Handler;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: SafeToast.java */
@TargetApi(19)
/* loaded from: classes2.dex */
public class z61 extends x61 {
    public boolean c;

    public z61(Application application) {
        super(application);
    }

    public final void c() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (this.c) {
            return;
        }
        this.c = true;
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            Handler handler = (Handler) declaredField2.get(obj);
            if (handler instanceof y61) {
                return;
            }
            declaredField2.set(obj, new y61(handler));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // dc.x61, android.widget.Toast, dc.i71
    public void show() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        c();
        super.show();
    }
}
