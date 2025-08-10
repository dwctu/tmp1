package dc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio.java */
/* loaded from: classes5.dex */
public final class wd4 {
    public static final Logger a = Logger.getLogger(wd4.class.getName());

    /* compiled from: Okio.java */
    public class a implements ee4 {
        public final /* synthetic */ ge4 a;
        public final /* synthetic */ OutputStream b;

        public a(ge4 ge4Var, OutputStream outputStream) {
            this.a = ge4Var;
            this.b = outputStream;
        }

        @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.b.close();
        }

        @Override // dc.ee4, java.io.Flushable
        public void flush() throws IOException {
            this.b.flush();
        }

        @Override // dc.ee4
        public ge4 timeout() {
            return this.a;
        }

        public String toString() {
            return "sink(" + this.b + ")";
        }

        @Override // dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            he4.b(nd4Var.b, 0L, j);
            while (j > 0) {
                this.a.throwIfReached();
                be4 be4Var = nd4Var.a;
                int iMin = (int) Math.min(j, be4Var.c - be4Var.b);
                this.b.write(be4Var.a, be4Var.b, iMin);
                int i = be4Var.b + iMin;
                be4Var.b = i;
                long j2 = iMin;
                j -= j2;
                nd4Var.b -= j2;
                if (i == be4Var.c) {
                    nd4Var.a = be4Var.b();
                    ce4.a(be4Var);
                }
            }
        }
    }

    /* compiled from: Okio.java */
    public class b implements fe4 {
        public final /* synthetic */ ge4 a;
        public final /* synthetic */ InputStream b;

        public b(ge4 ge4Var, InputStream inputStream) {
            this.a = ge4Var;
            this.b = inputStream;
        }

        @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            this.b.close();
        }

        @Override // dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.a.throwIfReached();
                be4 be4VarI0 = nd4Var.i0(1);
                int i = this.b.read(be4VarI0.a, be4VarI0.c, (int) Math.min(j, 8192 - be4VarI0.c));
                if (i == -1) {
                    return -1L;
                }
                be4VarI0.c += i;
                long j2 = i;
                nd4Var.b += j2;
                return j2;
            } catch (AssertionError e) {
                if (wd4.e(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override // dc.fe4
        public ge4 timeout() {
            return this.a;
        }

        public String toString() {
            return "source(" + this.b + ")";
        }
    }

    /* compiled from: Okio.java */
    public class c implements ee4 {
        @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // dc.ee4, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // dc.ee4
        public ge4 timeout() {
            return ge4.NONE;
        }

        @Override // dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            nd4Var.skip(j);
        }
    }

    /* compiled from: Okio.java */
    public class d extends ld4 {
        public final /* synthetic */ Socket a;

        public d(Socket socket) {
            this.a = socket;
        }

        @Override // dc.ld4
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // dc.ld4
        public void timedOut() throws IOException {
            try {
                this.a.close();
            } catch (AssertionError e) {
                if (!wd4.e(e)) {
                    throw e;
                }
                wd4.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, (Throwable) e);
            } catch (Exception e2) {
                wd4.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, (Throwable) e2);
            }
        }
    }

    public static ee4 a(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static ee4 b() {
        return new c();
    }

    public static od4 c(ee4 ee4Var) {
        return new zd4(ee4Var);
    }

    public static pd4 d(fe4 fe4Var) {
        return new ae4(fe4Var);
    }

    public static boolean e(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static ee4 f(File file) throws FileNotFoundException {
        if (file != null) {
            return g(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static ee4 g(OutputStream outputStream) {
        return h(outputStream, new ge4());
    }

    public static ee4 h(OutputStream outputStream, ge4 ge4Var) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (ge4Var != null) {
            return new a(ge4Var, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static ee4 i(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        ld4 ld4VarN = n(socket);
        return ld4VarN.sink(h(socket.getOutputStream(), ld4VarN));
    }

    public static fe4 j(File file) throws FileNotFoundException {
        if (file != null) {
            return k(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static fe4 k(InputStream inputStream) {
        return l(inputStream, new ge4());
    }

    public static fe4 l(InputStream inputStream, ge4 ge4Var) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (ge4Var != null) {
            return new b(ge4Var, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static fe4 m(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        ld4 ld4VarN = n(socket);
        return ld4VarN.source(l(socket.getInputStream(), ld4VarN));
    }

    public static ld4 n(Socket socket) {
        return new d(socket);
    }
}
