package dc;

import java.util.ArrayList;

/* compiled from: ConfigManager.java */
/* loaded from: classes4.dex */
public class f93 {
    public static volatile f93 j;
    public String a;
    public boolean b;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public boolean f = false;
    public int g = 1;
    public boolean h;
    public l93 i;

    public static f93 b() {
        if (j == null) {
            synchronized (g93.class) {
                if (j == null) {
                    j = new f93();
                }
            }
        }
        return j;
    }

    public l93 a() throws Exception {
        l93 l93Var = this.i;
        if (l93Var != null) {
            return l93Var;
        }
        throw new Exception("imageLoader is null");
    }

    public int c() {
        return this.g;
    }

    public String d() {
        return this.a;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.c;
    }

    public boolean i() {
        return this.d;
    }

    public boolean j() {
        return this.h;
    }

    public void k(boolean z) {
        this.e = z;
    }

    public void l(l93 l93Var) {
        this.i = l93Var;
    }

    public void m(ArrayList<String> arrayList) {
    }

    public void n(int i) {
        if (i > 1) {
            o(1);
        }
        this.g = i;
    }

    public void o(int i) {
    }

    public void p(boolean z) {
        this.f = z;
    }

    public void q(boolean z) {
        this.b = z;
    }

    public void r(boolean z) {
        this.c = z;
    }

    public void s(boolean z) {
        this.d = z;
    }

    public void t(boolean z) {
        this.h = z;
    }

    public void u(String str) {
        this.a = str;
    }
}
