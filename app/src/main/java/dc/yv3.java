package dc;

import android.view.View;

/* compiled from: AutoUtils.java */
/* loaded from: classes4.dex */
public class yv3 {
    public static void a(View view) {
        e(view);
        d(view);
        c(view);
        f(view, 3);
    }

    public static void b(View view, int i, int i2) {
        cv3 cv3VarC = cv3.c(view, i, i2);
        if (cv3VarC != null) {
            cv3VarC.b(view);
        }
    }

    public static void c(View view) {
        b(view, 16, 3);
    }

    public static void d(View view) {
        b(view, 8, 3);
    }

    public static void e(View view) {
        b(view, 3, 3);
    }

    public static void f(View view, int i) {
        b(view, 4, i);
    }

    public static int g(int i) {
        int iF = wv3.d().f();
        int iB = wv3.d().b();
        int i2 = i * iF;
        return i2 % iB == 0 ? i2 / iB : (i2 / iB) + 1;
    }

    public static int h(int i) {
        int iG = wv3.d().g();
        int iC = wv3.d().c();
        int i2 = i * iG;
        return i2 % iC == 0 ? i2 / iC : (i2 / iC) + 1;
    }
}
