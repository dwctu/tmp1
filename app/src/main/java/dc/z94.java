package dc;

import com.spotify.sdk.android.player.Config;
import dc.ba4;
import dc.y94;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.regex.Matcher;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: AbstractExtractFileTask.java */
/* loaded from: classes5.dex */
public abstract class z94<T> extends ba4<T> {
    public final s94 d;
    public final m94 e;

    public z94(s94 s94Var, m94 m94Var, ba4.b bVar) {
        super(bVar);
        this.d = s94Var;
        this.e = m94Var;
    }

    @Override // dc.ba4
    public y94.c g() {
        return y94.c.EXTRACT_ENTRY;
    }

    public final void k(File file, String str, k94 k94Var) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (file.isDirectory()) {
            String str2 = fa4.a;
            if (!canonicalPath.endsWith(str2)) {
                canonicalPath = canonicalPath + str2;
            }
        }
        String canonicalPath2 = new File(str).getCanonicalPath();
        String str3 = fa4.a;
        if (!canonicalPath2.endsWith(str3)) {
            canonicalPath2 = canonicalPath2 + str3;
        }
        if (canonicalPath.startsWith(canonicalPath2)) {
            return;
        }
        throw new ZipException("illegal file name that breaks out of the target directory: " + k94Var.i());
    }

    public final void l(File file) throws ZipException {
        if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return;
        }
        throw new ZipException("Unable to create parent directories: " + file.getParentFile());
    }

    public final void m(a94 a94Var, k94 k94Var, File file, y94 y94Var) throws IOException {
        String str = new String(s(a94Var, k94Var, y94Var));
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new ZipException("Could not create parent directories");
        }
        try {
            Path path = Paths.get(str, new String[0]);
            if (file.exists() && !file.delete()) {
                throw new ZipException("Could not delete existing symlink " + file);
            }
            Files.createSymbolicLink(file.toPath(), path, new FileAttribute[0]);
        } catch (NoSuchMethodError unused) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public final File n(k94 k94Var, String str, String str2) {
        String strI = k94Var.i();
        if (!ja4.h(str2)) {
            str2 = strI;
        }
        return new File(str, p(str2));
    }

    public void o(a94 a94Var, k94 k94Var, String str, String str2, y94 y94Var, byte[] bArr) throws Exception {
        boolean zR = r(k94Var);
        if (!zR || this.e.a()) {
            String str3 = fa4.a;
            if (!str.endsWith(str3)) {
                str = str + str3;
            }
            File fileN = n(k94Var, str, str2);
            y94Var.h(fileN.getAbsolutePath());
            k(fileN, str, k94Var);
            u(a94Var, k94Var);
            if (k94Var.o()) {
                if (!fileN.exists() && !fileN.mkdirs()) {
                    throw new ZipException("Could not create directory: " + fileN);
                }
            } else if (zR) {
                m(a94Var, k94Var, fileN, y94Var);
            } else {
                l(fileN);
                t(a94Var, fileN, y94Var, bArr);
            }
            if (zR) {
                return;
            }
            ia4.a(k94Var, fileN);
        }
    }

    public final String p(String str) {
        return str.replaceAll(":\\\\", Config.IN_FIELD_SEPARATOR).replaceAll("[/\\\\]", Matcher.quoteReplacement(fa4.a));
    }

    public s94 q() {
        return this.d;
    }

    public final boolean r(k94 k94Var) {
        byte[] bArrL = k94Var.L();
        if (bArrL == null || bArrL.length < 4) {
            return false;
        }
        return da4.a(bArrL[3], 5);
    }

    public final byte[] s(a94 a94Var, k94 k94Var, y94 y94Var) throws InterruptedException, IOException {
        int iL = (int) k94Var.l();
        byte[] bArr = new byte[iL];
        if (a94Var.read(bArr) != iL) {
            throw new ZipException("Could not read complete entry");
        }
        y94Var.l(iL);
        return bArr;
    }

    public final void t(a94 a94Var, File file, y94 y94Var, byte[] bArr) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int i = a94Var.read(bArr);
                    if (i == -1) {
                        fileOutputStream.close();
                        return;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                        y94Var.l(i);
                        j();
                    }
                } finally {
                }
            }
        } catch (Exception e) {
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    public final void u(a94 a94Var, k94 k94Var) throws IOException {
        if (da4.a(k94Var.j()[0], 6)) {
            throw new ZipException("Entry with name " + k94Var.i() + " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
        }
        l94 l94VarQ = a94Var.q(k94Var, false);
        if (l94VarQ != null) {
            if (!k94Var.i().equals(l94VarQ.i())) {
                throw new ZipException("File header and local file header mismatch");
            }
        } else {
            throw new ZipException("Could not read corresponding local file header for file header: " + k94Var.i());
        }
    }
}
