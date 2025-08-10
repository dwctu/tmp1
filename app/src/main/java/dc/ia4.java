package dc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/* compiled from: UnzipUtil.java */
/* loaded from: classes5.dex */
public class ia4 {
    public static void a(k94 k94Var, File file) throws IOException {
        try {
            Path path = file.toPath();
            ea4.k(path, k94Var.L());
            ea4.l(path, k94Var.k());
        } catch (NoSuchMethodError unused) {
            ea4.m(file, k94Var.k());
        }
    }

    public static x84 b(s94 s94Var) throws IOException {
        return s94Var.e().getName().endsWith(".zip.001") ? new v84(s94Var.e()) : new c94(s94Var.e(), s94Var.f(), s94Var.b().b());
    }
}
