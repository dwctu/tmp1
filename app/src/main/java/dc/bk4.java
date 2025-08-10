package dc;

import android.view.View;

/* compiled from: MeasureHelper.java */
/* loaded from: classes5.dex */
public class bk4 {
    public int a;
    public int b;
    public int c;
    public int d;

    public int[] a(int i, int i2) {
        int i3;
        int i4 = this.d;
        if (i4 == 90 || i4 == 270) {
            int i5 = i + i2;
            i2 = i5 - i2;
            i = i5 - i2;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i6 = this.b;
        if (i6 == 0 || (i3 = this.a) == 0) {
            return new int[]{size, size2};
        }
        int i7 = this.c;
        if (i7 == 1) {
            i2 = (size / 16) * 9;
            if (size2 <= i2) {
                i = (size2 / 9) * 16;
                i2 = size2;
            }
            i = size;
        } else if (i7 == 2) {
            i2 = (size / 4) * 3;
            if (size2 <= i2) {
                i = (size2 / 3) * 4;
                i2 = size2;
            }
            i = size;
        } else if (i7 != 3) {
            if (i7 == 4) {
                i2 = i6;
                i = i3;
            } else if (i7 != 5) {
                if (i3 * size2 < size * i6) {
                    i = (i3 * size2) / i6;
                } else if (i3 * size2 > size * i6) {
                    i2 = (i6 * size) / i3;
                    i = size;
                } else {
                    i = size;
                }
                i2 = size2;
            } else if (i3 * size2 > size * i6) {
                i = (i3 * size2) / i6;
                i2 = size2;
            } else {
                i2 = (i6 * size) / i3;
                i = size;
            }
        }
        return new int[]{i, i2};
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public void d(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
