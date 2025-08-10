package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: FinderPatternFinder.java */
/* loaded from: classes3.dex */
public class Sa {
    private static final int[] a = {1, 3, 1, 1};
    private static final int[] b = {1, 1, 3, 1};
    private static boolean c = false;
    private static boolean d = false;
    private static final b e = new b();
    private final C0417y f;
    private final com.huawei.hms.scankit.aiscan.common.A j;
    private final List<Qa> g = new ArrayList();
    private final int[] i = new int[5];
    private final List<Qa> h = new ArrayList();

    /* compiled from: FinderPatternFinder.java */
    public static final class a implements Comparator<Qa>, Serializable {
        private final float a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Qa qa, Qa qa2) {
            int iCompare = Integer.compare(qa2.a(), qa.a());
            return iCompare == 0 ? Float.compare(Math.abs(qa.e() - this.a), Math.abs(qa2.e() - this.a)) : iCompare;
        }

        private a(float f) {
            this.a = f;
        }
    }

    /* compiled from: FinderPatternFinder.java */
    public static final class b implements Comparator<Qa>, Serializable {
        private b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Qa qa, Qa qa2) {
            return Float.compare(qa.e(), qa2.e());
        }
    }

    /* compiled from: FinderPatternFinder.java */
    public static final class c implements Comparator<Qa>, Serializable {
        private final float a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Qa qa, Qa qa2) {
            return Float.compare(Math.abs(qa2.e() - this.a), Math.abs(qa.e() - this.a));
        }

        private c(float f) {
            this.a = f;
        }
    }

    public Sa(C0417y c0417y, com.huawei.hms.scankit.aiscan.common.A a2) {
        this.f = c0417y;
        this.j = a2;
    }

    public static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    private boolean b(int[] iArr, int[] iArr2) {
        if ((iArr2[0] & 1) != 0) {
            int i = iArr2[0];
            iArr[i] = iArr[i] + 1;
        } else if (iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean zA = a(iArr, iArr2[1], iArr2[2], false);
                if (zA) {
                    iArr2[4] = 2;
                }
                if (!zA) {
                    zA = a(iArr, iArr2[1], iArr2[2]);
                }
                if (zA) {
                    iArr2[0] = 0;
                    a(iArr);
                    return true;
                }
            }
            if (b(iArr)) {
                int i2 = iArr2[2];
                for (int i3 = iArr2[0]; i3 > 2; i3--) {
                    i2 -= iArr[i3];
                }
                if (b(iArr, iArr2[1], i2)) {
                    d(iArr);
                    iArr2[0] = 3;
                    return true;
                }
            }
            if (_a.d && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
                return true;
            }
            d(iArr);
            iArr2[0] = 3;
        } else {
            int i4 = iArr2[0] + 1;
            iArr2[0] = i4;
            iArr[i4] = iArr[i4] + 1;
        }
        return false;
    }

    private Qa[] c() throws C0309a {
        Qa[] qaArrA = this.g.size() > 2 ? a(true) : null;
        if (this.g.size() == 2) {
            int i = this.g.get(0).e() > this.g.get(1).e() ? 0 : 1;
            if (Math.max(this.g.get(0).e(), this.g.get(1).e()) / Math.min(this.g.get(0).e(), this.g.get(1).e()) > 1.5d) {
                Qa qa = this.g.get(i);
                this.g.clear();
                this.g.add(qa);
            }
        }
        if (this.g.size() == 1 && this.h.size() > 1) {
            qaArrA = g();
        }
        if (this.g.size() == 1 && this.h.size() == 1) {
            this.g.addAll(this.h);
            this.h.clear();
        }
        if (this.g.size() == 2) {
            try {
                qaArrA = h();
            } catch (C0309a unused) {
                qaArrA = b();
            }
        }
        if (this.g.size() != 0) {
            return qaArrA;
        }
        this.g.addAll(this.h);
        return this.g.size() < 20 ? a(false) : f();
    }

    private int[] d() {
        a(this.i);
        return this.i;
    }

    private static void e() {
        c = false;
        d = false;
    }

    private Qa[] f() throws C0309a {
        int size = this.g.size();
        if (size < 3) {
            throw C0309a.a();
        }
        float fE = 0.0f;
        if (size > 3) {
            Iterator<Qa> it = this.g.iterator();
            float f = 0.0f;
            float f2 = 0.0f;
            while (it.hasNext()) {
                float fE2 = it.next().e();
                f += fE2;
                f2 += fE2 * fE2;
            }
            float f3 = f / size;
            float fSqrt = (float) Math.sqrt((f2 / r0) - (f3 * f3));
            Collections.sort(this.g, new c(f3));
            float fMax = Math.max(0.2f * f3, fSqrt);
            int i = 0;
            while (i < this.g.size() && this.g.size() > 3) {
                if (Math.abs(this.g.get(i).e() - f3) > fMax) {
                    this.g.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.g.size() > 3) {
            Iterator<Qa> it2 = this.g.iterator();
            while (it2.hasNext()) {
                fE += it2.next().e();
            }
            Collections.sort(this.g, new a(fE / this.g.size()));
            List<Qa> list = this.g;
            list.subList(3, list.size()).clear();
        }
        double[] dArr = {a(this.g.get(0), this.g.get(1)), a(this.g.get(1), this.g.get(2)), a(this.g.get(0), this.g.get(2))};
        Arrays.sort(dArr);
        if (Math.abs(((dArr[1] + dArr[0]) - dArr[2]) / ((Math.sqrt(dArr[0]) * 2.0d) * Math.sqrt(dArr[1]))) <= 0.25d) {
            return new Qa[]{this.g.get(0), this.g.get(1), this.g.get(2)};
        }
        throw C0309a.a();
    }

    private Qa[] g() throws C0309a {
        Collections.sort(this.h, e);
        double[] dArr = new double[3];
        Qa[] qaArr = new Qa[3];
        int i = 0;
        double d2 = Double.MAX_VALUE;
        while (i < this.g.size()) {
            Qa qa = this.g.get(i);
            float fE = qa.e();
            int i2 = 0;
            while (i2 < this.h.size() - 1) {
                Qa qa2 = this.h.get(i2);
                double dE = qa2.e() / fE;
                if (dE <= 1.25d && dE >= 0.75d) {
                    double dA = a(qa, qa2);
                    if (Math.sqrt(dA) >= fE * 13.0f) {
                        int i3 = i2 + 1;
                        while (i3 < this.h.size()) {
                            Qa qa3 = this.h.get(i3);
                            int i4 = i;
                            double dE2 = qa3.e() / fE;
                            if (dE2 <= 1.25d && dE2 >= 0.75d) {
                                dArr[0] = dA;
                                dArr[1] = a(qa2, qa3);
                                dArr[2] = a(qa, qa3);
                                Arrays.sort(dArr);
                                double dAbs = (Math.abs(dArr[2] - (dArr[1] * 2.0d)) + Math.abs(dArr[2] - (dArr[0] * 2.0d))) / dArr[2];
                                double dSqrt = ((dArr[1] + dArr[0]) - dArr[2]) / ((Math.sqrt(dArr[0]) * 2.0d) * Math.sqrt(dArr[1]));
                                if (dAbs < d2 && Math.abs(dSqrt) < 0.2d) {
                                    qaArr[0] = qa;
                                    qaArr[1] = qa2;
                                    qaArr[2] = qa3;
                                    d2 = dAbs;
                                }
                            }
                            i3++;
                            i = i4;
                        }
                    }
                }
                i2++;
                i = i;
            }
            i++;
        }
        if (d2 != Double.MAX_VALUE) {
            return qaArr;
        }
        throw C0309a.a();
    }

    private Qa[] h() throws C0309a {
        Qa qa;
        Qa qa2;
        double d2;
        char c2 = 0;
        Qa qa3 = this.g.get(0);
        char c3 = 1;
        Qa qa4 = this.g.get(1);
        Qa qa5 = this.g.get(1);
        double dA = a(qa3, qa4);
        double[] dArr = new double[3];
        float fMin = Math.min(qa3.e(), qa4.e());
        Collections.sort(this.g, new c(fMin));
        int i = 0;
        double d3 = Double.MAX_VALUE;
        while (i < this.h.size()) {
            Qa qa6 = this.h.get(i);
            float fE = qa6.e();
            if (fE > 1.25f * fMin || fE < 0.75f * fMin) {
                qa = qa3;
                qa2 = qa4;
                d2 = dA;
            } else {
                dArr[c2] = dA;
                dArr[c3] = a(qa4, qa6);
                dArr[2] = a(qa3, qa6);
                Arrays.sort(dArr);
                double dAbs = (Math.abs(dArr[2] - (dArr[c3] * 2.0d)) + Math.abs(dArr[2] - (dArr[c2] * 2.0d))) / dArr[2];
                double dSqrt = ((dArr[c3] + dArr[c2]) - dArr[2]) / ((Math.sqrt(dArr[c2]) * 2.0d) * Math.sqrt(dArr[c3]));
                if (!_a.d || Math.abs(dSqrt) >= 0.25d) {
                    qa = qa3;
                    qa2 = qa4;
                    d2 = dA;
                } else {
                    boolean z = qa3.b() < ((float) this.f.d()) * 0.3f && qa4.b() > ((float) this.f.d()) * 0.7f;
                    boolean z2 = qa4.b() < ((float) this.f.d()) * 0.3f && qa3.b() > ((float) this.f.d()) * 0.7f;
                    boolean z3 = qa3.c() < ((float) this.f.b()) * 0.3f && qa4.c() > ((float) this.f.b()) * 0.7f;
                    qa2 = qa4;
                    boolean z4 = qa4.c() < ((float) this.f.b()) * 0.3f && qa3.c() > ((float) this.f.b()) * 0.7f;
                    qa = qa3;
                    boolean z5 = qa6.b() < ((float) this.f.d()) * 0.3f || qa6.b() > ((float) this.f.d()) * 0.7f;
                    d2 = dA;
                    boolean z6 = qa6.c() < ((float) this.f.b()) * 0.3f || qa6.c() > ((float) this.f.b()) * 0.7f;
                    if (((z || z2) && !z5) || ((z3 || z4) && !z6)) {
                    }
                }
                if (dAbs < d3 && Math.abs(dSqrt) < 0.25d) {
                    qa5 = qa6;
                    d3 = dAbs;
                }
            }
            i++;
            qa4 = qa2;
            qa3 = qa;
            dA = d2;
            c2 = 0;
            c3 = 1;
        }
        if (d3 == Double.MAX_VALUE) {
            throw C0309a.a();
        }
        this.g.add(qa5);
        return new Qa[]{this.g.get(0), this.g.get(1), this.g.get(2)};
    }

    public final void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public final Ta a() throws C0309a {
        int iB = this.f.b();
        int iD = this.f.d();
        int i = (iB * 3) / 388;
        if (i < 3) {
            i = 3;
        }
        if (_a.i) {
            i = 2;
        }
        a(i, iB, iD);
        Qa[] qaArrC = c();
        if (qaArrC != null) {
            com.huawei.hms.scankit.aiscan.common.z.a(qaArrC);
            if ((this.f.b() * this.f.d()) / (Math.sqrt(a(qaArrC[0], qaArrC[1])) * Math.sqrt(a(qaArrC[1], qaArrC[2]))) <= 900.0d) {
                return new Ta(qaArrC);
            }
            throw C0309a.a();
        }
        throw C0309a.a();
    }

    private boolean d(int i, int i2, int i3, int[] iArr) {
        C0417y c0417y = this.f;
        while (i >= 0 && !c0417y.b(i2, i) && iArr[3] <= i3) {
            iArr[3] = iArr[3] + 1;
            i--;
        }
        if (i >= 0 && iArr[3] <= i3) {
            while (i >= 0 && c0417y.b(i2, i) && iArr[2] <= i3) {
                iArr[2] = iArr[2] + 1;
                i--;
            }
            if (i >= 0 && iArr[2] <= i3) {
                while (i >= 0 && !c0417y.b(i2, i) && iArr[1] <= i3) {
                    iArr[1] = iArr[1] + 1;
                    i--;
                }
                if (i >= 0 && iArr[1] <= i3) {
                    while (i >= 0 && c0417y.b(i2, i) && iArr[0] <= i3) {
                        iArr[0] = iArr[0] + 1;
                        i--;
                    }
                    return iArr[0] > i3;
                }
            }
        }
        return true;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void a(int r11, int r12, int r13) {
        /*
            r10 = this;
            r0 = 5
            int[] r1 = new int[r0]
            int r2 = r11 + (-1)
        L5:
            if (r2 >= r12) goto L5e
            r10.a(r1)
            int[] r3 = new int[r0]
            r4 = 0
            r3[r4] = r4
            r5 = 1
            r3[r5] = r2
            r6 = 2
            r3[r6] = r4
            r7 = 3
            r3[r7] = r13
            r7 = 4
            r3[r7] = r11
            r8 = 0
        L1c:
            if (r8 >= r13) goto L39
            r3[r6] = r8
            com.huawei.hms.scankit.p.y r9 = r10.f
            boolean r9 = r9.b(r8, r2)
            if (r9 == 0) goto L2c
            r10.a(r1, r3)
            goto L33
        L2c:
            boolean r9 = r10.b(r1, r3)
            if (r9 == 0) goto L33
            goto L37
        L33:
            r8 = r3[r6]
            r11 = r3[r7]
        L37:
            int r8 = r8 + r5
            goto L1c
        L39:
            boolean r5 = b(r1)
            if (r5 == 0) goto L4e
            r3 = r3[r4]
            r5 = r13
        L42:
            if (r3 <= r6) goto L4a
            r7 = r1[r3]
            int r5 = r5 - r7
            int r3 = r3 + (-1)
            goto L42
        L4a:
            r10.b(r1, r2, r5)
            goto L4f
        L4e:
            r5 = r13
        L4f:
            boolean r3 = a(r1, r4)
            if (r3 == 0) goto L5c
            boolean r3 = r10.a(r1, r2, r5, r4)
            if (r3 == 0) goto L5c
            r11 = 2
        L5c:
            int r2 = r2 + r11
            goto L5
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Sa.a(int, int, int):void");
    }

    public static boolean c(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = 0.75f * f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    private float b(int i, int i2, int i3, int i4, boolean z) {
        C0417y c0417y = this.f;
        int iB = c0417y.b();
        int[] iArrD = d();
        if (b(i, i2, i3, iArrD)) {
            return Float.NaN;
        }
        int i5 = i + 1;
        while (i5 < iB && c0417y.b(i2, i5)) {
            iArrD[2] = iArrD[2] + 1;
            i5++;
        }
        if (i5 == iB) {
            return Float.NaN;
        }
        while (i5 < iB && !c0417y.b(i2, i5) && iArrD[3] < i3) {
            iArrD[3] = iArrD[3] + 1;
            i5++;
        }
        if (i5 == iB || iArrD[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < iB && c0417y.b(i2, i5) && iArrD[4] < i3) {
            iArrD[4] = iArrD[4] + 1;
            i5++;
        }
        if (iArrD[4] >= i3 && !d && !c) {
            return Float.NaN;
        }
        int i6 = iArrD[0] + iArrD[1] + iArrD[2] + iArrD[3] + iArrD[4];
        if (z) {
            if (Math.abs(i6 - i4) * 5 >= i4 * 3 && !d && !c) {
                return Float.NaN;
            }
        } else if (i6 >= i4 * 3 || i6 * 3 <= i4) {
            return Float.NaN;
        }
        if (a(iArrD, z)) {
            return a(iArrD, i5);
        }
        return Float.NaN;
    }

    private boolean c(int i, int i2, int i3, int[] iArr) {
        C0417y c0417y = this.f;
        while (i >= 0 && !c0417y.b(i2, i) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i--;
        }
        if (i < 0 || iArr[1] > i3) {
            return true;
        }
        while (i >= 0 && c0417y.b(i2, i) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i--;
        }
        return iArr[0] > i3;
    }

    private void a(int[] iArr, int[] iArr2) {
        if ((iArr2[0] & 1) == 1) {
            iArr2[0] = iArr2[0] + 1;
        }
        if (iArr2[0] >= 0 && iArr2[0] < iArr.length) {
            int i = iArr2[0];
            iArr[i] = iArr[i] + 1;
        }
        if (iArr2[2] == iArr2[3] - 1 && iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean zA = a(iArr, iArr2[1], iArr2[2], false);
                if (zA) {
                    iArr2[4] = 2;
                }
                if (!zA) {
                    zA = a(iArr, iArr2[1], iArr2[2]);
                }
                if (zA) {
                    iArr2[0] = 0;
                    a(iArr);
                    while (iArr2[2] < this.f.d() && !this.f.b(iArr2[2], iArr2[1])) {
                        iArr2[2] = iArr2[2] + 1;
                    }
                }
            }
            if (_a.d && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
            }
        }
    }

    private boolean b(int i, int i2, int i3, int[] iArr) {
        C0417y c0417y = this.f;
        while (i >= 0 && c0417y.b(i2, i)) {
            iArr[2] = iArr[2] + 1;
            i--;
        }
        if (i < 0) {
            return true;
        }
        while (i >= 0 && !c0417y.b(i2, i) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i--;
        }
        if (i < 0 || iArr[1] > i3) {
            return true;
        }
        while (i >= 0 && c0417y.b(i2, i) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i--;
        }
        return (iArr[0] <= i3 || d || c) ? false : true;
    }

    public static boolean b(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = 0.5f * f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs((5.0f * f) - ((float) iArr[1])) < f2 && Math.abs(f - ((float) iArr[2])) < f2;
    }

    private static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean a(int[] iArr, boolean z) {
        float f;
        float f2;
        e();
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        if (z && _a.d) {
            f = 0.75f;
            f2 = 1.0f;
        } else {
            f = 0.5f;
            f2 = 3.0f;
        }
        float f3 = i / 7.0f;
        float f4 = f * f3;
        if (Math.abs(f3 - iArr[0]) < f4 && Math.abs(f3 - iArr[1]) < f4 && Math.abs((3.0f * f3) - iArr[2]) < f2 * f4 && Math.abs(f3 - iArr[3]) < f4 && Math.abs(f3 - iArr[4]) < f4) {
            return true;
        }
        if (!z) {
            return false;
        }
        int[] iArr2 = new int[iArr.length - 1];
        int i4 = 0;
        while (i4 < iArr.length - 1) {
            int i5 = i4 + 1;
            iArr2[i4] = iArr[i5];
            i4 = i5;
        }
        int[] iArr3 = new int[iArr.length - 1];
        for (int i6 = 0; i6 < iArr.length - 1; i6++) {
            iArr3[i6] = iArr[i6];
        }
        float fA = a(iArr2, a, 0.5f);
        float fA2 = a(iArr3, b, 0.5f);
        boolean z2 = fA < 0.3f;
        c = z2;
        boolean z3 = fA2 < 0.3f;
        d = z3;
        return z2 || z3;
    }

    private float b(int i, int i2, int i3, int i4) {
        C0417y c0417y = this.f;
        int iB = c0417y.b();
        int[] iArrD = d();
        if (d(i, i2, i3, iArrD)) {
            return Float.NaN;
        }
        int i5 = i + 1;
        while (i5 < iB && !c0417y.b(i2, i5) && iArrD[3] <= i3) {
            iArrD[3] = iArrD[3] + 1;
            i5++;
        }
        if (i5 < 0 || iArrD[3] > i3) {
            return Float.NaN;
        }
        while (i5 < iB && c0417y.b(i2, i5)) {
            iArrD[4] = iArrD[4] + 1;
            i5++;
        }
        if (iArrD[4] <= i3 && Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + iArrD[4]) - i4) * 5 < i4 * 2 && a(iArrD, true)) {
            return a(iArrD, i5);
        }
        return Float.NaN;
    }

    public final boolean b(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float f = i2 - (i3 / 2);
        int i4 = (int) f;
        float fA = a(i, i4, iArr[1], i3);
        if (Float.isNaN(fA)) {
            fA = a(i, (int) (f - ((iArr[1] * 2) / 5)), (int) (((iArr[1] * 2) / 5) + f), iArr[1], i3);
            if (Float.isNaN(fA) && _a.d) {
                fA = b(i, i4, iArr[1], i3);
            }
        }
        if (Float.isNaN(fA)) {
            return false;
        }
        return a(false, fA, f, i3 / 7.0f);
    }

    public final void a(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    private boolean a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] iArrD = d();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.f.b(i2 - i6, i - i6)) {
            iArrD[2] = iArrD[2] + 1;
            i6++;
        }
        if (iArrD[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.f.b(i2 - i6, i - i6)) {
            iArrD[1] = iArrD[1] + 1;
            i6++;
        }
        if (iArrD[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.f.b(i2 - i6, i - i6)) {
            iArrD[0] = iArrD[0] + 1;
            i6++;
        }
        if (iArrD[0] == 0) {
            return false;
        }
        int iB = this.f.b();
        int iD = this.f.d();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 >= iB || (i5 = i2 + i7) >= iD || !this.f.b(i5, i8)) {
                break;
            }
            iArrD[2] = iArrD[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i + i7;
            if (i9 >= iB || (i4 = i2 + i7) >= iD || this.f.b(i4, i9)) {
                break;
            }
            iArrD[3] = iArrD[3] + 1;
            i7++;
        }
        if (iArrD[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 >= iB || (i3 = i2 + i7) >= iD || !this.f.b(i3, i10)) {
                break;
            }
            iArrD[4] = iArrD[4] + 1;
            i7++;
        }
        if (iArrD[4] == 0) {
            return false;
        }
        return c(iArrD);
    }

    private Qa[] b() throws C0309a {
        Qa qa = this.g.get(0);
        Qa qa2 = this.g.get(1);
        float[] fArr = qa.b() < qa2.b() ? new float[]{qa.b(), qa2.b()} : new float[]{qa2.b(), qa.b()};
        float[] fArr2 = qa.b() < qa2.b() ? new float[]{qa.c(), qa2.c()} : new float[]{qa2.c(), qa.c()};
        float fE = (qa.e() + qa2.e()) / 2.0f;
        float fE2 = ((qa.e() + qa2.e()) * 7.0f) / 1.5f;
        if (Math.abs(fArr[0] - fArr[1]) > fE2 && Math.abs(fArr2[0] - fArr2[1]) <= fE2) {
            this.g.add(new Qa((fArr[0] + fArr2[0]) - fArr2[1], (fArr2[0] + fArr[1]) - fArr[0], fE, false, 0));
        } else if (Math.abs(fArr[0] - fArr[1]) > fE2 || Math.abs(fArr2[0] - fArr2[1]) <= fE2) {
            if (Math.abs(fArr[0] - fArr[1]) > fE2 && Math.abs(fArr2[0] - fArr2[1]) > fE2) {
                this.g.add(new Qa((((fArr[0] + fArr[1]) + fArr2[1]) - fArr2[0]) / 2.0f, (((fArr2[0] + fArr2[1]) + fArr[0]) - fArr[1]) / 2.0f, fE, false, 0));
            }
        } else if (fArr[0] < fArr[1]) {
            this.g.add(new Qa((fArr[1] + fArr2[0]) - fArr2[1], (fArr2[1] + fArr[1]) - fArr[0], fE, false, 0));
        } else {
            this.g.add(new Qa((fArr[0] + fArr2[1]) - fArr2[0], (fArr2[0] + fArr[0]) - fArr[1], fE, false, 0));
        }
        if (this.g.size() == 3) {
            return new Qa[]{this.g.get(0), this.g.get(1), this.g.get(2)};
        }
        throw C0309a.a();
    }

    private float a(int i, int i2, int i3, int i4, boolean z) {
        C0417y c0417y = this.f;
        int iD = c0417y.d();
        int[] iArrD = d();
        if (a(i, i2, i3, iArrD)) {
            return Float.NaN;
        }
        int i5 = i + 1;
        while (i5 < iD && c0417y.b(i5, i2)) {
            iArrD[2] = iArrD[2] + 1;
            i5++;
        }
        if (i5 == iD) {
            return Float.NaN;
        }
        while (i5 < iD && !c0417y.b(i5, i2) && iArrD[3] < i3) {
            iArrD[3] = iArrD[3] + 1;
            i5++;
        }
        if (i5 == iD || iArrD[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < iD && c0417y.b(i5, i2) && iArrD[4] < i3) {
            iArrD[4] = iArrD[4] + 1;
            i5++;
        }
        if (iArrD[4] >= i3 && !d && !c) {
            return Float.NaN;
        }
        if ((Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + iArrD[4]) - i4) * 5 < i4 || d || c) && a(iArrD, z)) {
            return a(iArrD, i5);
        }
        return Float.NaN;
    }

    private boolean a(int i, int i2, int i3, int[] iArr) {
        C0417y c0417y = this.f;
        while (i >= 0 && c0417y.b(i, i2)) {
            iArr[2] = iArr[2] + 1;
            i--;
        }
        if (i < 0) {
            return true;
        }
        while (i >= 0 && !c0417y.b(i, i2) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i--;
        }
        if (i < 0 || iArr[1] > i3) {
            return true;
        }
        while (i >= 0 && c0417y.b(i, i2) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i--;
        }
        return (iArr[0] <= i3 || d || c) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int[] r17, int r18, int r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Sa.a(int[], int, int, boolean):boolean");
    }

    private static double a(Qa qa, Qa qa2) {
        double dB = qa.b() - qa2.b();
        double dC = qa.c() - qa2.c();
        return (dB * dB) + (dC * dC);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.Qa[] a(boolean r27) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Sa.a(boolean):com.huawei.hms.scankit.p.Qa[]");
    }

    private float a(int i, int i2, int i3, int i4) {
        C0417y c0417y = this.f;
        int iB = c0417y.b();
        int[] iArrD = d();
        if (c(i, i2, i3, iArrD)) {
            return Float.NaN;
        }
        int i5 = i + 1;
        while (i5 < iB && !c0417y.b(i2, i5) && iArrD[1] <= i3) {
            iArrD[1] = iArrD[1] + 1;
            i5++;
        }
        if (i5 < 0 || iArrD[1] > i3) {
            return Float.NaN;
        }
        while (i5 < iB && c0417y.b(i2, i5)) {
            iArrD[2] = iArrD[2] + 1;
            i5++;
        }
        if (i5 == iB) {
            return Float.NaN;
        }
        while (i5 < iB && !c0417y.b(i2, i5) && iArrD[3] < i3) {
            iArrD[3] = iArrD[3] + 1;
            i5++;
        }
        if (i5 == iB || iArrD[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < iB && c0417y.b(i2, i5) && iArrD[4] < i3) {
            iArrD[4] = iArrD[4] + 1;
            i5++;
        }
        if (iArrD[4] >= i3 || Math.abs(((((iArrD[0] + iArrD[1]) + iArrD[2]) + iArrD[3]) + iArrD[4]) - i4) * 5 >= i4 * 2) {
            return Float.NaN;
        }
        if (_a.d) {
            if (a(iArrD, true)) {
                return a(iArrD, i5);
            }
            return Float.NaN;
        }
        if (a(iArrD, false)) {
            return a(iArrD, i5);
        }
        return Float.NaN;
    }

    private float a(int i, int i2, int i3, int i4, int i5) {
        C0417y c0417y = this.f;
        int iB = c0417y.b();
        int i6 = i2;
        while (i6 <= i3) {
            int[] iArrD = d();
            int i7 = i;
            while (i7 >= 0 && !c0417y.b(i6, i7) && iArrD[1] <= i4) {
                iArrD[1] = iArrD[1] + 1;
                i7--;
            }
            if (i7 >= 0) {
                double d2 = i4 * 1.5d;
                if (iArrD[1] > d2) {
                    continue;
                } else {
                    while (i7 >= 0 && c0417y.b(i6, i7) && iArrD[0] <= i4) {
                        iArrD[0] = iArrD[0] + 1;
                        i7--;
                    }
                    if (iArrD[0] > i4 / 2) {
                        continue;
                    } else {
                        int i8 = i + 1;
                        while (i8 < iB && !c0417y.b(i6, i8) && iArrD[1] <= i4) {
                            iArrD[1] = iArrD[1] + 1;
                            i8++;
                        }
                        if (i8 >= 0 && iArrD[1] <= d2) {
                            while (i8 < iB && c0417y.b(i6, i8)) {
                                iArrD[2] = iArrD[2] + 1;
                                i8++;
                            }
                            if (Math.abs(((iArrD[0] + iArrD[1]) + iArrD[2]) - i5) * 5 < i5 * 2 && b(iArrD)) {
                                return (i8 - (iArrD[1] / 2)) - iArrD[2];
                            }
                        }
                    }
                }
            }
            i6 += i3 - i2;
        }
        return Float.NaN;
    }

    public final boolean a(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float fA = a(iArr, i2);
        float fB = b(i, (int) fA, iArr[2], i3, false);
        if (Float.isNaN(fB)) {
            fB = a(i, (int) ((fA - (iArr[2] / 2)) - (iArr[1] / 2)), (int) ((iArr[2] / 2) + fA + (iArr[3] / 2)), iArr[1] + iArr[2] + iArr[3], i3);
        }
        if (Float.isNaN(fB)) {
            return false;
        }
        return a(false, fB, fA, i3 / 7.0f);
    }

    private boolean a(boolean z, float f, float f2, float f3) {
        int i = 0;
        while (true) {
            if (i >= this.h.size()) {
                break;
            }
            Qa qa = this.h.get(i);
            if (qa.a(f3, f, f2)) {
                this.h.set(i, qa.a(f, f2, f3, false));
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            Qa qa2 = new Qa(f2, f, f3, false);
            this.h.add(qa2);
            com.huawei.hms.scankit.aiscan.common.A a2 = this.j;
            if (a2 != null) {
                a2.a(qa2);
            }
        }
        return true;
    }
}
