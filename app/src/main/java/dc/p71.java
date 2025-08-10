package dc;

import android.content.Context;
import android.view.View;

/* compiled from: LocationToastStyle.java */
/* loaded from: classes2.dex */
public class p71 implements m71<View> {
    public final m71<?> a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;

    public p71(m71<?> m71Var, int i, int i2, int i3, float f, float f2) {
        this.a = m71Var;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = f2;
    }

    @Override // dc.m71
    public float a() {
        return this.e;
    }

    @Override // dc.m71
    public View b(Context context) {
        return this.a.b(context);
    }

    @Override // dc.m71
    public float c() {
        return this.f;
    }

    @Override // dc.m71
    public int d() {
        return this.b;
    }

    @Override // dc.m71
    public int e() {
        return this.c;
    }

    @Override // dc.m71
    public int f() {
        return this.d;
    }
}
