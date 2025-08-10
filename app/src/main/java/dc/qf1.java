package dc;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonEncodingException;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: JsonReader.java */
/* loaded from: classes3.dex */
public abstract class qf1 implements Closeable {
    public int a;
    public int[] b = new int[32];
    public String[] c = new String[32];
    public int[] d = new int[32];
    public boolean e;
    public boolean f;

    /* compiled from: JsonReader.java */
    public static final class a {
        public final String[] a;
        public final xd4 b;

        public a(String[] strArr, xd4 xd4Var) {
            this.a = strArr;
            this.b = xd4Var;
        }

        public static a a(String... strArr) {
            try {
                qd4[] qd4VarArr = new qd4[strArr.length];
                nd4 nd4Var = new nd4();
                for (int i = 0; i < strArr.length; i++) {
                    tf1.l0(nd4Var, strArr[i]);
                    nd4Var.readByte();
                    qd4VarArr[i] = nd4Var.L();
                }
                return new a((String[]) strArr.clone(), xd4.d(qd4VarArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: JsonReader.java */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public static qf1 L(pd4 pd4Var) {
        return new sf1(pd4Var);
    }

    public abstract int A() throws IOException;

    public abstract long C() throws IOException;

    public abstract <T> T I() throws IOException;

    public abstract String K() throws IOException;

    public abstract b O() throws IOException;

    public abstract void V() throws IOException;

    public final void X(int i) {
        int i2 = this.a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.c;
            this.c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.d;
            this.d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.b;
        int i3 = this.a;
        this.a = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract void b() throws IOException;

    public abstract int b0(a aVar) throws IOException;

    public abstract int d0(a aVar) throws IOException;

    public abstract void e() throws IOException;

    public final void e0(boolean z) {
        this.f = z;
    }

    public abstract void f() throws IOException;

    public final void f0(boolean z) {
        this.e = z;
    }

    public abstract void g0() throws IOException;

    public final String getPath() {
        return rf1.a(this.a, this.b, this.c, this.d);
    }

    public abstract void h0() throws IOException;

    public final JsonEncodingException i0(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void j() throws IOException;

    public final boolean m() {
        return this.f;
    }

    public abstract boolean p() throws IOException;

    public final boolean q() {
        return this.e;
    }

    public abstract boolean x() throws IOException;

    public abstract double y() throws IOException;
}
