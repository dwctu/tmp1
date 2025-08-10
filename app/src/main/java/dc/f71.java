package dc;

import android.app.Application;

/* compiled from: Toaster.java */
/* loaded from: classes2.dex */
public final class f71 {
    public static Application a;
    public static k71 b;
    public static m71<?> c;
    public static j71 d;
    public static Boolean e;

    public static void a() {
        if (a == null) {
            throw new IllegalStateException("Toaster has not been initialized");
        }
    }

    public static void b(Application application) {
        d(application, c);
    }

    public static void c(Application application, k71 k71Var, m71<?> m71Var) {
        if (f()) {
            return;
        }
        a = application;
        s61.b().c(application);
        if (k71Var == null) {
            k71Var = new e71();
        }
        i(k71Var);
        if (m71Var == null) {
            m71Var = new n71();
        }
        j(m71Var);
    }

    public static void d(Application application, m71<?> m71Var) {
        c(application, null, m71Var);
    }

    public static boolean e() {
        if (e == null) {
            a();
            e = Boolean.valueOf((a.getApplicationInfo().flags & 2) != 0);
        }
        return e.booleanValue();
    }

    public static boolean f() {
        return (a == null || b == null || c == null) ? false : true;
    }

    public static void g(int i, int i2, int i3) {
        h(i, i2, i3, 0.0f, 0.0f);
    }

    public static void h(int i, int i2, int i3, float f, float f2) {
        c = new p71(c, i, i2, i3, f, f2);
    }

    public static void i(k71 k71Var) {
        if (k71Var == null) {
            return;
        }
        b = k71Var;
        k71Var.b(a);
    }

    public static void j(m71<?> m71Var) {
        if (m71Var == null) {
            return;
        }
        c = m71Var;
    }

    public static void k(d71 d71Var) {
        a();
        CharSequence charSequence = d71Var.a;
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        if (d71Var.f == null) {
            d71Var.f = b;
        }
        if (d71Var.g == null) {
            if (d == null) {
                d = new c71();
            }
            d71Var.g = d;
        }
        if (d71Var.e == null) {
            d71Var.e = c;
        }
        if (d71Var.g.a(d71Var)) {
            return;
        }
        if (d71Var.b == -1) {
            d71Var.b = d71Var.a.length() > 20 ? 1 : 0;
        }
        d71Var.f.a(d71Var);
    }

    public static void l(CharSequence charSequence) {
        d71 d71Var = new d71();
        d71Var.a = charSequence;
        d71Var.b = 0;
        k(d71Var);
    }
}
