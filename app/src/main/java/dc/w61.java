package dc;

import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: NotificationServiceProxy.java */
/* loaded from: classes2.dex */
public final class w61 implements InvocationHandler {
    public final Object a;

    public w61(Object obj) {
        this.a = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        name.hashCode();
        switch (name) {
            case "cancelToast":
            case "enqueueToastEx":
            case "enqueueToast":
                objArr[0] = DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE;
                break;
        }
        return method.invoke(this.a, objArr);
    }
}
