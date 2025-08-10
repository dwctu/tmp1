package dc;

import com.squareup.moshi.JsonDataException;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: JsonWriter.java */
/* loaded from: classes3.dex */
public abstract class vf1 implements Closeable, Flushable {
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int a = 0;
    public int[] b = new int[32];
    public String[] c = new String[32];
    public int[] d = new int[32];
    public int i = -1;

    public static vf1 A(od4 od4Var) {
        return new tf1(od4Var);
    }

    public final int C() {
        int i = this.a;
        if (i != 0) {
            return this.b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void I() throws IOException {
        int iC = C();
        if (iC != 5 && iC != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.h = true;
    }

    public final void K(int i) {
        int[] iArr = this.b;
        int i2 = this.a;
        this.a = i2 + 1;
        iArr[i2] = i;
    }

    public final void L(int i) {
        this.b[this.a - 1] = i;
    }

    public final void O(boolean z) {
        this.f = z;
    }

    public final void V(boolean z) {
        this.g = z;
    }

    public abstract vf1 X(double d) throws IOException;

    public abstract vf1 b() throws IOException;

    public abstract vf1 b0(long j) throws IOException;

    public abstract vf1 d0(Number number) throws IOException;

    public abstract vf1 e() throws IOException;

    public abstract vf1 e0(String str) throws IOException;

    public final boolean f() {
        int i = this.a;
        int[] iArr = this.b;
        if (i != iArr.length) {
            return false;
        }
        if (i == 256) {
            throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
        }
        this.b = Arrays.copyOf(iArr, iArr.length * 2);
        String[] strArr = this.c;
        this.c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        int[] iArr2 = this.d;
        this.d = Arrays.copyOf(iArr2, iArr2.length * 2);
        if (!(this instanceof uf1)) {
            return true;
        }
        uf1 uf1Var = (uf1) this;
        Object[] objArr = uf1Var.j;
        uf1Var.j = Arrays.copyOf(objArr, objArr.length * 2);
        return true;
    }

    public abstract vf1 f0(boolean z) throws IOException;

    public final String getPath() {
        return rf1.a(this.a, this.b, this.c, this.d);
    }

    public abstract vf1 j() throws IOException;

    public abstract vf1 m() throws IOException;

    public final boolean p() {
        return this.g;
    }

    public final boolean q() {
        return this.f;
    }

    public abstract vf1 x(String str) throws IOException;

    public abstract vf1 y() throws IOException;
}
