package dc;

import android.graphics.PointF;
import androidx.annotation.Nullable;

/* compiled from: AnimatableTransform.java */
/* loaded from: classes.dex */
public class ba implements fa {

    @Nullable
    public final u9 a;

    @Nullable
    public final ca<PointF, PointF> b;

    @Nullable
    public final w9 c;

    @Nullable
    public final r9 d;

    @Nullable
    public final t9 e;

    @Nullable
    public final r9 f;

    @Nullable
    public final r9 g;

    @Nullable
    public final r9 h;

    @Nullable
    public final r9 i;

    public ba() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // dc.fa
    @Nullable
    public y7 a(h7 h7Var, va vaVar) {
        return null;
    }

    public d9 b() {
        return new d9(this);
    }

    @Nullable
    public u9 c() {
        return this.a;
    }

    @Nullable
    public r9 d() {
        return this.i;
    }

    @Nullable
    public t9 e() {
        return this.e;
    }

    @Nullable
    public ca<PointF, PointF> f() {
        return this.b;
    }

    @Nullable
    public r9 g() {
        return this.d;
    }

    @Nullable
    public w9 h() {
        return this.c;
    }

    @Nullable
    public r9 i() {
        return this.f;
    }

    @Nullable
    public r9 j() {
        return this.g;
    }

    @Nullable
    public r9 k() {
        return this.h;
    }

    public ba(@Nullable u9 u9Var, @Nullable ca<PointF, PointF> caVar, @Nullable w9 w9Var, @Nullable r9 r9Var, @Nullable t9 t9Var, @Nullable r9 r9Var2, @Nullable r9 r9Var3, @Nullable r9 r9Var4, @Nullable r9 r9Var5) {
        this.a = u9Var;
        this.b = caVar;
        this.c = w9Var;
        this.d = r9Var;
        this.e = t9Var;
        this.h = r9Var2;
        this.i = r9Var3;
        this.f = r9Var4;
        this.g = r9Var5;
    }
}
