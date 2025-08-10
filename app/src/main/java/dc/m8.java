package dc;

import android.graphics.Path;
import dc.p8;
import dc.ua;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class m8 implements i8, p8.b {
    public final boolean b;
    public final h7 c;
    public final p8<?, Path> d;
    public boolean e;
    public final Path a = new Path();
    public x7 f = new x7();

    public m8(h7 h7Var, va vaVar, sa saVar) {
        saVar.b();
        this.b = saVar.d();
        this.c = h7Var;
        p8<pa, Path> p8VarA = saVar.c().a();
        this.d = p8VarA;
        vaVar.i(p8VarA);
        p8VarA.a(this);
    }

    @Override // dc.p8.b
    public void a() {
        c();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        for (int i = 0; i < list.size(); i++) {
            y7 y7Var = list.get(i);
            if (y7Var instanceof o8) {
                o8 o8Var = (o8) y7Var;
                if (o8Var.i() == ua.a.SIMULTANEOUSLY) {
                    this.f.a(o8Var);
                    o8Var.c(this);
                }
            }
        }
    }

    public final void c() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // dc.i8
    public Path getPath() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        if (this.b) {
            this.e = true;
            return this.a;
        }
        this.a.set(this.d.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f.b(this.a);
        this.e = true;
        return this.a;
    }
}
