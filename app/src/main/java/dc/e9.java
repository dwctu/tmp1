package dc;

import androidx.annotation.Nullable;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e9<K, A> extends p8<K, A> {
    public final A i;

    public e9(kd<A> kdVar) {
        this(kdVar, null);
    }

    @Override // dc.p8
    public float c() {
        return 1.0f;
    }

    @Override // dc.p8
    public A h() {
        kd<A> kdVar = this.e;
        A a = this.i;
        return kdVar.b(0.0f, 0.0f, a, a, f(), f(), f());
    }

    @Override // dc.p8
    public A i(id<K> idVar, float f) {
        return h();
    }

    @Override // dc.p8
    public void k() {
        if (this.e != null) {
            super.k();
        }
    }

    @Override // dc.p8
    public void m(float f) {
        this.d = f;
    }

    public e9(kd<A> kdVar, @Nullable A a) {
        super(Collections.emptyList());
        n(kdVar);
        this.i = a;
    }
}
