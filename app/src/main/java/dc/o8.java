package dc;

import dc.p8;
import dc.ua;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class o8 implements y7, p8.b {
    public final boolean a;
    public final List<p8.b> b = new ArrayList();
    public final ua.a c;
    public final p8<?, Float> d;
    public final p8<?, Float> e;
    public final p8<?, Float> f;

    public o8(va vaVar, ua uaVar) {
        uaVar.c();
        this.a = uaVar.g();
        this.c = uaVar.f();
        p8<Float, Float> p8VarA = uaVar.e().a();
        this.d = p8VarA;
        p8<Float, Float> p8VarA2 = uaVar.b().a();
        this.e = p8VarA2;
        p8<Float, Float> p8VarA3 = uaVar.d().a();
        this.f = p8VarA3;
        vaVar.i(p8VarA);
        vaVar.i(p8VarA2);
        vaVar.i(p8VarA3);
        p8VarA.a(this);
        p8VarA2.a(this);
        p8VarA3.a(this);
    }

    @Override // dc.p8.b
    public void a() {
        for (int i = 0; i < this.b.size(); i++) {
            this.b.get(i).a();
        }
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
    }

    public void c(p8.b bVar) {
        this.b.add(bVar);
    }

    public p8<?, Float> d() {
        return this.e;
    }

    public p8<?, Float> f() {
        return this.f;
    }

    public p8<?, Float> h() {
        return this.d;
    }

    public ua.a i() {
        return this.c;
    }

    public boolean j() {
        return this.a;
    }
}
