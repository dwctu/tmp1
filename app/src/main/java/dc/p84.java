package dc;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: HeaderUtil.java */
/* loaded from: classes5.dex */
public class p84 {
    public static String a(byte[] bArr, boolean z, Charset charset) {
        if (charset != null) {
            return new String(bArr, charset);
        }
        if (z) {
            return new String(bArr, fa4.b);
        }
        try {
            return new String(bArr, "Cp437");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static long b(s94 s94Var) {
        return s94Var.g() ? s94Var.d().c() : s94Var.b().d();
    }

    public static long c(List<k94> list) {
        long jL = 0;
        for (k94 k94Var : list) {
            jL += (k94Var.m() == null || k94Var.m().e() <= 0) ? k94Var.l() : k94Var.m().e();
        }
        return jL;
    }
}
