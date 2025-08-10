package dc;

import java.io.IOException;
import java.util.List;

/* compiled from: AnimatableValueParser.java */
/* loaded from: classes.dex */
public class ob {
    public static <T> List<id<T>> a(xc xcVar, float f, f7 f7Var, uc<T> ucVar) throws IOException {
        return cc.a(xcVar, f7Var, f, ucVar, false);
    }

    public static <T> List<id<T>> b(xc xcVar, f7 f7Var, uc<T> ucVar) throws IOException {
        return cc.a(xcVar, f7Var, 1.0f, ucVar, false);
    }

    public static q9 c(xc xcVar, f7 f7Var) throws IOException {
        return new q9(b(xcVar, f7Var, qb.a));
    }

    public static z9 d(xc xcVar, f7 f7Var) throws IOException {
        return new z9(b(xcVar, f7Var, sb.a));
    }

    public static r9 e(xc xcVar, f7 f7Var) throws IOException {
        return f(xcVar, f7Var, true);
    }

    public static r9 f(xc xcVar, f7 f7Var, boolean z) throws IOException {
        return new r9(a(xcVar, z ? hd.e() : 1.0f, f7Var, tb.a));
    }

    public static s9 g(xc xcVar, f7 f7Var, int i) throws IOException {
        return new s9(b(xcVar, f7Var, new wb(i)));
    }

    public static t9 h(xc xcVar, f7 f7Var) throws IOException {
        return new t9(b(xcVar, f7Var, zb.a));
    }

    public static v9 i(xc xcVar, f7 f7Var) throws IOException {
        return new v9(cc.a(xcVar, f7Var, hd.e(), jc.a, true));
    }

    public static w9 j(xc xcVar, f7 f7Var) throws IOException {
        return new w9(b(xcVar, f7Var, nc.a));
    }

    public static x9 k(xc xcVar, f7 f7Var) throws IOException {
        return new x9(a(xcVar, hd.e(), f7Var, oc.a));
    }
}
