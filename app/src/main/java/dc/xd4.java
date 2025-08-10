package dc;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Options.java */
/* loaded from: classes5.dex */
public final class xd4 extends AbstractList<qd4> implements RandomAccess {
    public final qd4[] a;
    public final int[] b;

    public xd4(qd4[] qd4VarArr, int[] iArr) {
        this.a = qd4VarArr;
        this.b = iArr;
    }

    public static void a(long j, nd4 nd4Var, int i, List<qd4> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6;
        nd4 nd4Var2;
        int i7 = i2;
        if (i7 >= i3) {
            throw new AssertionError();
        }
        for (int i8 = i7; i8 < i3; i8++) {
            if (list.get(i8).s() < i) {
                throw new AssertionError();
            }
        }
        qd4 qd4Var = list.get(i2);
        qd4 qd4Var2 = list.get(i3 - 1);
        int iIntValue = -1;
        if (i == qd4Var.s()) {
            iIntValue = list2.get(i7).intValue();
            i7++;
            qd4Var = list.get(i7);
        }
        int i9 = i7;
        if (qd4Var.i(i) == qd4Var2.i(i)) {
            int i10 = 0;
            int iMin = Math.min(qd4Var.s(), qd4Var2.s());
            for (int i11 = i; i11 < iMin && qd4Var.i(i11) == qd4Var2.i(i11); i11++) {
                i10++;
            }
            long jC = 1 + j + c(nd4Var) + 2 + i10;
            nd4Var.p0(-i10);
            nd4Var.p0(iIntValue);
            int i12 = i;
            while (true) {
                i4 = i + i10;
                if (i12 >= i4) {
                    break;
                }
                nd4Var.p0(qd4Var.i(i12) & 255);
                i12++;
            }
            if (i9 + 1 == i3) {
                if (i4 != list.get(i9).s()) {
                    throw new AssertionError();
                }
                nd4Var.p0(list2.get(i9).intValue());
                return;
            } else {
                nd4 nd4Var3 = new nd4();
                nd4Var.p0((int) ((c(nd4Var3) + jC) * (-1)));
                a(jC, nd4Var3, i4, list, i9, i3, list2);
                nd4Var.write(nd4Var3, nd4Var3.f0());
                return;
            }
        }
        int i13 = 1;
        for (int i14 = i9 + 1; i14 < i3; i14++) {
            if (list.get(i14 - 1).i(i) != list.get(i14).i(i)) {
                i13++;
            }
        }
        long jC2 = j + c(nd4Var) + 2 + (i13 * 2);
        nd4Var.p0(i13);
        nd4Var.p0(iIntValue);
        for (int i15 = i9; i15 < i3; i15++) {
            byte bI = list.get(i15).i(i);
            if (i15 == i9 || bI != list.get(i15 - 1).i(i)) {
                nd4Var.p0(bI & 255);
            }
        }
        nd4 nd4Var4 = new nd4();
        int i16 = i9;
        while (i16 < i3) {
            byte bI2 = list.get(i16).i(i);
            int i17 = i16 + 1;
            int i18 = i17;
            while (true) {
                if (i18 >= i3) {
                    i5 = i3;
                    break;
                } else {
                    if (bI2 != list.get(i18).i(i)) {
                        i5 = i18;
                        break;
                    }
                    i18++;
                }
            }
            if (i17 == i5 && i + 1 == list.get(i16).s()) {
                nd4Var.p0(list2.get(i16).intValue());
                i6 = i5;
                nd4Var2 = nd4Var4;
            } else {
                nd4Var.p0((int) ((c(nd4Var4) + jC2) * (-1)));
                i6 = i5;
                nd4Var2 = nd4Var4;
                a(jC2, nd4Var4, i + 1, list, i16, i5, list2);
            }
            nd4Var4 = nd4Var2;
            i16 = i6;
        }
        nd4 nd4Var5 = nd4Var4;
        nd4Var.write(nd4Var5, nd4Var5.f0());
    }

    public static int c(nd4 nd4Var) {
        return (int) (nd4Var.f0() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bc, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static dc.xd4 d(dc.qd4... r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.xd4.d(dc.qd4[]):dc.xd4");
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public qd4 get(int i) {
        return this.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.length;
    }
}
