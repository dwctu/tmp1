package dc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: TestCase.java */
/* loaded from: classes4.dex */
public abstract class zx3 extends vx3 implements yx3 {
    public String a;

    public zx3() {
        this.a = null;
    }

    public static void c(String str, Object obj) {
        vx3.c(str, obj);
    }

    public static void e(String str) {
        vx3.e(str);
        throw null;
    }

    @Override // dc.yx3
    public int a() {
        return 1;
    }

    @Override // dc.yx3
    public void b(cy3 cy3Var) {
        cy3Var.f(this);
    }

    public String f() {
        return this.a;
    }

    public void g() throws Throwable {
        j();
        try {
            h();
            try {
                k();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                k();
            } catch (Throwable unused) {
            }
        }
        if (th != null) {
            throw th;
        }
    }

    public void h() throws Throwable {
        c("TestCase.fName cannot be null", this.a);
        try {
            Method method = getClass().getMethod(this.a, null);
            if (!Modifier.isPublic(method.getModifiers())) {
                e("Method \"" + this.a + "\" should be public");
                throw null;
            }
            try {
                method.invoke(this, new Object[0]);
            } catch (IllegalAccessException e) {
                e.fillInStackTrace();
                throw e;
            } catch (InvocationTargetException e2) {
                e2.fillInStackTrace();
                throw e2.getTargetException();
            }
        } catch (NoSuchMethodException unused) {
            e("Method \"" + this.a + "\" not found");
            throw null;
        }
    }

    public void i(String str) {
        this.a = str;
    }

    public void j() throws Exception {
    }

    public void k() throws Exception {
    }

    public String toString() {
        return f() + "(" + getClass().getName() + ")";
    }

    public zx3(String str) {
        this.a = str;
    }
}
