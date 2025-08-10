package dc;

import androidx.annotation.Nullable;

/* compiled from: Repeater.java */
/* loaded from: classes.dex */
public class oa implements fa {
    public final String a;
    public final r9 b;
    public final r9 c;
    public final ba d;
    public final boolean e;

    public oa(String str, r9 r9Var, r9 r9Var2, ba baVar, boolean z) {
        this.a = str;
        this.b = r9Var;
        this.c = r9Var2;
        this.d = baVar;
        this.e = z;
    }

    @Override // dc.fa
    @Nullable
    public y7 a(h7 h7Var, va vaVar) {
        return new l8(h7Var, vaVar, this);
    }

    public r9 b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public r9 d() {
        return this.c;
    }

    public ba e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }
}
