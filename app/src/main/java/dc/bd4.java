package dc;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import okhttp3.internal.Util;

/* compiled from: ResponseBody.java */
/* loaded from: classes5.dex */
public abstract class bd4 implements Closeable {
    private Reader reader;

    /* compiled from: ResponseBody.java */
    public class a extends bd4 {
        public final /* synthetic */ tc4 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ pd4 c;

        public a(tc4 tc4Var, long j, pd4 pd4Var) {
            this.a = tc4Var;
            this.b = j;
            this.c = pd4Var;
        }

        @Override // dc.bd4
        public long contentLength() {
            return this.b;
        }

        @Override // dc.bd4
        public tc4 contentType() {
            return this.a;
        }

        @Override // dc.bd4
        public pd4 source() {
            return this.c;
        }
    }

    /* compiled from: ResponseBody.java */
    public static final class b extends Reader {
        public final pd4 a;
        public final Charset b;
        public boolean c;
        public Reader d;

        public b(pd4 pd4Var, Charset charset) {
            this.a = pd4Var;
            this.b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.c = true;
            Reader reader = this.d;
            if (reader != null) {
                reader.close();
            } else {
                this.a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.a.a0(), Util.bomAwareCharset(this.a, this.b));
                this.d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) throws Exception {
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private Charset charset() {
        tc4 tc4VarContentType = contentType();
        return tc4VarContentType != null ? tc4VarContentType.b(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    public static bd4 create(tc4 tc4Var, String str) {
        Charset charsetA = StandardCharsets.UTF_8;
        if (tc4Var != null && (charsetA = tc4Var.a()) == null) {
            charsetA = StandardCharsets.UTF_8;
            tc4Var = tc4.d(tc4Var + "; charset=utf-8");
        }
        nd4 nd4Var = new nd4();
        nd4Var.t0(str, charsetA);
        return create(tc4Var, nd4Var.f0(), nd4Var);
    }

    public final InputStream byteStream() {
        return source().a0();
    }

    public final byte[] bytes() throws Exception {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        pd4 pd4VarSource = source();
        try {
            byte[] bArrM = pd4VarSource.M();
            if (pd4VarSource != null) {
                $closeResource(null, pd4VarSource);
            }
            if (jContentLength == -1 || jContentLength == bArrM.length) {
                return bArrM;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + bArrM.length + ") disagree");
        } finally {
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        b bVar = new b(source(), charset());
        this.reader = bVar;
        return bVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract tc4 contentType();

    public abstract pd4 source();

    public final String string() throws Exception {
        pd4 pd4VarSource = source();
        try {
            String strQ = pd4VarSource.Q(Util.bomAwareCharset(pd4VarSource, charset()));
            if (pd4VarSource != null) {
                $closeResource(null, pd4VarSource);
            }
            return strQ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (pd4VarSource != null) {
                    $closeResource(th, pd4VarSource);
                }
                throw th2;
            }
        }
    }

    public static bd4 create(tc4 tc4Var, byte[] bArr) {
        nd4 nd4Var = new nd4();
        nd4Var.k0(bArr);
        return create(tc4Var, bArr.length, nd4Var);
    }

    public static bd4 create(tc4 tc4Var, qd4 qd4Var) {
        nd4 nd4Var = new nd4();
        nd4Var.j0(qd4Var);
        return create(tc4Var, qd4Var.s(), nd4Var);
    }

    public static bd4 create(tc4 tc4Var, long j, pd4 pd4Var) {
        Objects.requireNonNull(pd4Var, "source == null");
        return new a(tc4Var, j, pd4Var);
    }
}
