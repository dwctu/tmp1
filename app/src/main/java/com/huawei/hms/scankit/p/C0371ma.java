package com.huawei.hms.scankit.p;

import java.util.Formatter;

/* compiled from: DetectionResultColumn.java */
/* renamed from: com.huawei.hms.scankit.p.ma, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0371ma {
    private final C0351ha a;
    private final C0355ia[] b;

    public C0371ma(C0351ha c0351ha) {
        this.a = new C0351ha(c0351ha);
        this.b = new C0355ia[(c0351ha.d() - c0351ha.f()) + 1];
    }

    public final void a(int i, C0355ia c0355ia) {
        this.b[c(i)] = c0355ia;
    }

    public final C0355ia b(int i) {
        C0355ia c0355ia;
        C0355ia c0355ia2;
        C0355ia c0355iaA = a(i);
        if (c0355iaA != null) {
            return c0355iaA;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iC = c(i) - i2;
            if (iC >= 0 && (c0355ia2 = this.b[iC]) != null) {
                return c0355ia2;
            }
            int iC2 = c(i) + i2;
            C0355ia[] c0355iaArr = this.b;
            if (iC2 < c0355iaArr.length && (c0355ia = c0355iaArr[iC2]) != null) {
                return c0355ia;
            }
        }
        return null;
    }

    public final int c(int i) {
        return i - this.a.f();
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (C0355ia c0355ia : this.b) {
                if (c0355ia == null) {
                    int i2 = i + 1;
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i = i2;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(c0355ia.c()), Integer.valueOf(c0355ia.e()));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public final C0355ia a(int i) {
        return this.b[c(i)];
    }

    public final C0351ha a() {
        return this.a;
    }

    public final C0355ia[] b() {
        return this.b;
    }
}
