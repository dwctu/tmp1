package dc;

import dc.ba4;
import java.io.IOException;

/* compiled from: ExtractAllFilesTask.java */
/* loaded from: classes5.dex */
public class ca4 extends z94<a> {
    public final char[] f;
    public x84 g;

    /* compiled from: ExtractAllFilesTask.java */
    public static class a extends aa4 {
        public final String b;

        public a(String str, n94 n94Var) {
            super(n94Var);
            this.b = str;
        }
    }

    public ca4(s94 s94Var, char[] cArr, m94 m94Var, ba4.b bVar) {
        super(s94Var, m94Var, bVar);
        this.f = cArr;
    }

    @Override // dc.ba4
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public long d(a aVar) {
        return p84.c(q().a().a());
    }

    @Override // dc.ba4
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void f(a aVar, y94 y94Var) throws IOException {
        try {
            a94 a94VarY = y(aVar.a);
            try {
                for (k94 k94Var : q().a().a()) {
                    if (k94Var.i().startsWith("__MACOSX")) {
                        y94Var.l(k94Var.l());
                    } else {
                        this.g.b(k94Var);
                        o(a94VarY, k94Var, aVar.b, null, y94Var, new byte[aVar.a.a()]);
                        j();
                    }
                }
                if (a94VarY != null) {
                    a94VarY.close();
                }
            } finally {
            }
        } finally {
            x84 x84Var = this.g;
            if (x84Var != null) {
                x84Var.close();
            }
        }
    }

    public final k94 x(s94 s94Var) {
        if (s94Var.a() == null || s94Var.a().a() == null || s94Var.a().a().size() == 0) {
            return null;
        }
        return s94Var.a().a().get(0);
    }

    public final a94 y(n94 n94Var) throws IOException {
        this.g = ia4.b(q());
        k94 k94VarX = x(q());
        if (k94VarX != null) {
            this.g.b(k94VarX);
        }
        return new a94(this.g, this.f, n94Var);
    }
}
