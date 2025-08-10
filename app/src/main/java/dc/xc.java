package dc;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public abstract class xc implements Closeable {
    public static final String[] g = new String[128];
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
                    xc.b0(nd4Var, strArr[i]);
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

    static {
        for (int i = 0; i <= 31; i++) {
            g[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static xc I(pd4 pd4Var) {
        return new zc(pd4Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b0(dc.od4 r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = dc.xc.g
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.v(r8, r4, r3)
        L2e:
            r7.s(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.v(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.xc.b0(dc.od4, java.lang.String):void");
    }

    public abstract String A() throws IOException;

    public abstract String C() throws IOException;

    public abstract b K() throws IOException;

    public final void L(int i) {
        int i2 = this.a;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new vc("Nesting too deep at " + getPath());
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

    public abstract int O(a aVar) throws IOException;

    public abstract void V() throws IOException;

    public abstract void X() throws IOException;

    public final wc d0(String str) throws wc {
        throw new wc(str + " at path " + getPath());
    }

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public final String getPath() {
        return yc.a(this.a, this.b, this.c, this.d);
    }

    public abstract void j() throws IOException;

    public abstract void m() throws IOException;

    public abstract boolean p() throws IOException;

    public abstract boolean q() throws IOException;

    public abstract double x() throws IOException;

    public abstract int y() throws IOException;
}
