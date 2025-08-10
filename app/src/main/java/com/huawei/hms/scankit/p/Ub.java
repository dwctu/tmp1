package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import org.bouncycastle.asn1.eac.EACTags;

/* compiled from: HighLevelEncoder.java */
/* loaded from: classes3.dex */
public final class Ub {
    public static final String[] a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    public static final int[][] b = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] c;
    public static final int[][] d;
    private final byte[] e;

    /* compiled from: HighLevelEncoder.java */
    public static class a<State> implements Comparator<Wb> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Wb wb, Wb wb2) {
            return wb.b() - wb2.b();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);
        c = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            c[0][i] = (i - 65) + 2;
        }
        c[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            c[1][i2] = (i2 - 97) + 2;
        }
        c[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            c[2][i3] = (i3 - 48) + 2;
        }
        int[][] iArr2 = c;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            c[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, EACTags.SECURE_MESSAGING_TEMPLATE};
        for (int i5 = 0; i5 < 31; i5++) {
            if (iArr4[i5] > 0) {
                c[4][iArr4[i5]] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        d = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        try {
            int[][] iArr7 = d;
            if (com.huawei.hms.scankit.util.b.a(iArr7, 0) && com.huawei.hms.scankit.util.b.a(iArr7[0], 4)) {
                iArr7[0][4] = 0;
            }
            if (com.huawei.hms.scankit.util.b.a(iArr7, 1) && com.huawei.hms.scankit.util.b.a(iArr7[1], 4)) {
                iArr7[1][4] = 0;
            }
            if (com.huawei.hms.scankit.util.b.a(iArr7, 1) && com.huawei.hms.scankit.util.b.a(iArr7[1], 0)) {
                iArr7[1][0] = 28;
            }
            if (com.huawei.hms.scankit.util.b.a(iArr7, 3) && com.huawei.hms.scankit.util.b.a(iArr7[3], 4)) {
                iArr7[3][4] = 0;
            }
            if (com.huawei.hms.scankit.util.b.a(iArr7, 2) && com.huawei.hms.scankit.util.b.a(iArr7[2], 4)) {
                iArr7[2][4] = 0;
            }
            if (com.huawei.hms.scankit.util.b.a(iArr7, 2) && com.huawei.hms.scankit.util.b.a(iArr7[2], 0)) {
                iArr7[2][0] = 15;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public Ub(byte[] bArr) {
        this.e = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.scankit.p.C0413x a() {
        /*
            r8 = this;
            com.huawei.hms.scankit.p.Wb r0 = com.huawei.hms.scankit.p.Wb.a
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = 0
        L8:
            byte[] r3 = r8.e
            int r4 = r3.length
            if (r2 >= r4) goto L4d
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L15
            r5 = r3[r4]
            goto L16
        L15:
            r5 = 0
        L16:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L37
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L33
            r6 = 46
            if (r3 == r6) goto L2f
            r6 = 58
            if (r3 == r6) goto L2b
            goto L3d
        L2b:
            if (r5 != r7) goto L3d
            r3 = 5
            goto L3e
        L2f:
            if (r5 != r7) goto L3d
            r3 = 3
            goto L3e
        L33:
            if (r5 != r7) goto L3d
            r3 = 4
            goto L3e
        L37:
            r3 = 10
            if (r5 != r3) goto L3d
            r3 = 2
            goto L3e
        L3d:
            r3 = 0
        L3e:
            if (r3 <= 0) goto L46
            java.util.Collection r0 = a(r0, r2, r3)
            r2 = r4
            goto L4a
        L46:
            java.util.Collection r0 = r8.a(r0, r2)
        L4a:
            int r2 = r2 + 1
            goto L8
        L4d:
            com.huawei.hms.scankit.p.Ub$a r1 = new com.huawei.hms.scankit.p.Ub$a
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.huawei.hms.scankit.p.Wb r0 = (com.huawei.hms.scankit.p.Wb) r0
            byte[] r1 = r8.e
            com.huawei.hms.scankit.p.x r0 = r0.a(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Ub.a():com.huawei.hms.scankit.p.x");
    }

    private Collection<Wb> a(Iterable<Wb> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<Wb> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, linkedList);
        }
        return a(linkedList);
    }

    private void a(Wb wb, int i, Collection<Wb> collection) {
        if (com.huawei.hms.scankit.util.b.a(this.e, i)) {
            char c2 = (char) (this.e[i] & 255);
            int[][] iArr = c;
            boolean z = com.huawei.hms.scankit.util.b.a(iArr, wb.c()) && com.huawei.hms.scankit.util.b.a(iArr[wb.c()], (int) c2) && iArr[wb.c()][c2] > 0;
            Wb wbB = null;
            for (int i2 = 0; i2 <= 4; i2++) {
                int[][] iArr2 = c;
                int i3 = (com.huawei.hms.scankit.util.b.a(iArr2, i2) && com.huawei.hms.scankit.util.b.a(iArr2[i2], (int) c2)) ? iArr2[i2][c2] : 0;
                if (i3 > 0) {
                    if (wbB == null) {
                        wbB = wb.b(i);
                    }
                    if (!z || i2 == wb.c() || i2 == 2) {
                        collection.add(wbB.a(i2, i3));
                    }
                    if (!z && d[wb.c()][i2] >= 0) {
                        collection.add(wbB.b(i2, i3));
                    }
                }
            }
            int[][] iArr3 = c;
            if (com.huawei.hms.scankit.util.b.a(iArr3, wb.c()) && com.huawei.hms.scankit.util.b.a(iArr3[wb.c()], (int) c2)) {
                if (wb.a() > 0 || iArr3[wb.c()][c2] == 0) {
                    collection.add(wb.a(i));
                }
            }
        }
    }

    private static Collection<Wb> a(Iterable<Wb> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<Wb> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, i2, linkedList);
        }
        return a(linkedList);
    }

    private static void a(Wb wb, int i, int i2, Collection<Wb> collection) {
        Wb wbB = wb.b(i);
        collection.add(wbB.a(4, i2));
        if (wb.c() != 4) {
            collection.add(wbB.b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(wbB.a(2, 16 - i2).a(2, 1));
        }
        if (wb.a() > 0) {
            collection.add(wb.a(i).a(i + 1));
        }
    }

    private static Collection<Wb> a(Iterable<Wb> iterable) {
        LinkedList linkedList = new LinkedList();
        for (Wb wb : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Wb wb2 = (Wb) it.next();
                if (wb2.a(wb)) {
                    z = false;
                    break;
                }
                if (wb.a(wb2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(wb);
            }
        }
        return linkedList;
    }
}
