package dc;

import java.lang.reflect.Modifier;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: ToastLogInterceptor.java */
/* loaded from: classes2.dex */
public class c71 implements j71 {
    @Override // dc.j71
    public boolean a(d71 d71Var) {
        e(d71Var.a);
        return false;
    }

    public boolean b(Class<?> cls) {
        return j71.class.isAssignableFrom(cls) || f71.class.equals(cls) || cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
    }

    public boolean c() {
        return f71.e();
    }

    public void d(String str) {
    }

    public void e(CharSequence charSequence) {
        if (c()) {
            for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
                int lineNumber = stackTraceElement.getLineNumber();
                if (lineNumber > 0) {
                    try {
                        if (!b(Class.forName(stackTraceElement.getClassName()))) {
                            d("(" + stackTraceElement.getFileName() + SignatureImpl.INNER_SEP + lineNumber + ") " + charSequence.toString());
                            return;
                        }
                        continue;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
