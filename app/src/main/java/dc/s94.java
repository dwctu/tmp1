package dc;

import java.io.File;
import java.util.ArrayList;

/* compiled from: ZipModel.java */
/* loaded from: classes5.dex */
public class s94 implements Cloneable {
    public f94 a;
    public i94 b;
    public o94 c;
    public p94 d;
    public boolean e;
    public File f;
    public boolean g;

    public s94() {
        new ArrayList();
        new ArrayList();
        this.a = new f94();
        this.b = new i94();
        this.c = new o94();
        this.d = new p94();
        this.g = false;
    }

    public f94 a() {
        return this.a;
    }

    public i94 b() {
        return this.b;
    }

    public o94 c() {
        return this.c;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public p94 d() {
        return this.d;
    }

    public File e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public boolean g() {
        return this.g;
    }

    public void h(f94 f94Var) {
        this.a = f94Var;
    }

    public void i(i94 i94Var) {
        this.b = i94Var;
    }

    public void k(boolean z) {
        this.e = z;
    }

    public void l(o94 o94Var) {
        this.c = o94Var;
    }

    public void m(p94 p94Var) {
        this.d = p94Var;
    }

    public void n(boolean z) {
        this.g = z;
    }

    public void o(File file) {
        this.f = file;
    }
}
