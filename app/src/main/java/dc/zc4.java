package dc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import okhttp3.internal.Util;

/* compiled from: RequestBody.java */
/* loaded from: classes5.dex */
public abstract class zc4 {

    /* compiled from: RequestBody.java */
    public class a extends zc4 {
        public final /* synthetic */ tc4 a;
        public final /* synthetic */ qd4 b;

        public a(tc4 tc4Var, qd4 qd4Var) {
            this.a = tc4Var;
            this.b = qd4Var;
        }

        @Override // dc.zc4
        public long contentLength() throws IOException {
            return this.b.s();
        }

        @Override // dc.zc4
        public tc4 contentType() {
            return this.a;
        }

        @Override // dc.zc4
        public void writeTo(od4 od4Var) throws IOException {
            od4Var.U(this.b);
        }
    }

    /* compiled from: RequestBody.java */
    public class b extends zc4 {
        public final /* synthetic */ tc4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ int d;

        public b(tc4 tc4Var, int i, byte[] bArr, int i2) {
            this.a = tc4Var;
            this.b = i;
            this.c = bArr;
            this.d = i2;
        }

        @Override // dc.zc4
        public long contentLength() {
            return this.b;
        }

        @Override // dc.zc4
        public tc4 contentType() {
            return this.a;
        }

        @Override // dc.zc4
        public void writeTo(od4 od4Var) throws IOException {
            od4Var.write(this.c, this.d, this.b);
        }
    }

    /* compiled from: RequestBody.java */
    public class c extends zc4 {
        public final /* synthetic */ tc4 a;
        public final /* synthetic */ File b;

        public c(tc4 tc4Var, File file) {
            this.a = tc4Var;
            this.b = file;
        }

        @Override // dc.zc4
        public long contentLength() {
            return this.b.length();
        }

        @Override // dc.zc4
        public tc4 contentType() {
            return this.a;
        }

        @Override // dc.zc4
        public void writeTo(od4 od4Var) throws IOException {
            fe4 fe4VarJ = wd4.j(this.b);
            try {
                od4Var.w(fe4VarJ);
                if (fe4VarJ != null) {
                    fe4VarJ.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (fe4VarJ != null) {
                        try {
                            fe4VarJ.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    public static zc4 create(tc4 tc4Var, String str) {
        Charset charsetA = StandardCharsets.UTF_8;
        if (tc4Var != null && (charsetA = tc4Var.a()) == null) {
            charsetA = StandardCharsets.UTF_8;
            tc4Var = tc4.d(tc4Var + "; charset=utf-8");
        }
        return create(tc4Var, str.getBytes(charsetA));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract tc4 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(od4 od4Var) throws IOException;

    public static zc4 create(tc4 tc4Var, qd4 qd4Var) {
        return new a(tc4Var, qd4Var);
    }

    public static zc4 create(tc4 tc4Var, byte[] bArr) {
        return create(tc4Var, bArr, 0, bArr.length);
    }

    public static zc4 create(tc4 tc4Var, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount(bArr.length, i, i2);
        return new b(tc4Var, i2, bArr, i);
    }

    public static zc4 create(tc4 tc4Var, File file) {
        Objects.requireNonNull(file, "file == null");
        return new c(tc4Var, file);
    }
}
