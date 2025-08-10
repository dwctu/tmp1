package dc;

import dc.ba4;
import dc.ca4;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.lingala.zip4j.exception.ZipException;

/* compiled from: ZipFile.java */
/* loaded from: classes5.dex */
public class c84 implements Closeable {
    public File a;
    public s94 b;
    public y94 c;
    public boolean d;
    public char[] e;
    public ThreadFactory g;
    public ExecutorService h;
    public Charset f = null;
    public int i = 4096;
    public List<InputStream> j = new ArrayList();
    public boolean k = true;

    public c84(File file, char[] cArr) {
        if (file == null) {
            throw new IllegalArgumentException("input zip file parameter is null");
        }
        this.a = file;
        this.e = cArr;
        this.d = false;
        this.c = new y94();
    }

    public final ba4.b b() {
        if (this.d) {
            if (this.g == null) {
                this.g = Executors.defaultThreadFactory();
            }
            this.h = Executors.newSingleThreadExecutor(this.g);
        }
        return new ba4.b(this.h, this.d, this.c);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<InputStream> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.j.clear();
    }

    public final n94 e() {
        return new n94(this.f, this.i, this.k);
    }

    public final void f() {
        s94 s94Var = new s94();
        this.b = s94Var;
        s94Var.o(this.a);
    }

    public void j(String str) throws IOException {
        m(str, new m94());
    }

    public void m(String str, m94 m94Var) throws IOException {
        if (!ja4.h(str)) {
            throw new ZipException("output path is null or invalid");
        }
        if (!ja4.d(new File(str))) {
            throw new ZipException("invalid output path");
        }
        if (this.b == null) {
            q();
        }
        s94 s94Var = this.b;
        if (s94Var == null) {
            throw new ZipException("Internal error occurred when extracting zip file");
        }
        new ca4(s94Var, this.e, m94Var, b()).e(new ca4.a(str, e()));
    }

    public final RandomAccessFile p() throws IOException {
        if (!ea4.h(this.a)) {
            return new RandomAccessFile(this.a, x94.READ.getValue());
        }
        w84 w84Var = new w84(this.a, x94.READ.getValue(), ea4.d(this.a));
        w84Var.e();
        return w84Var;
    }

    public final void q() throws IOException {
        if (this.b != null) {
            return;
        }
        if (!this.a.exists()) {
            f();
            return;
        }
        if (!this.a.canRead()) {
            throw new ZipException("no read access for the input zip file");
        }
        try {
            RandomAccessFile randomAccessFileP = p();
            try {
                s94 s94VarH = new n84().h(randomAccessFileP, e());
                this.b = s94VarH;
                s94VarH.o(this.a);
                if (randomAccessFileP != null) {
                    randomAccessFileP.close();
                }
            } finally {
            }
        } catch (ZipException e) {
            throw e;
        } catch (IOException e2) {
            throw new ZipException(e2);
        }
    }

    public String toString() {
        return this.a.toString();
    }
}
