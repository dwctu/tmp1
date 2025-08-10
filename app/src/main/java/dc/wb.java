package dc;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* compiled from: GradientColorParser.java */
/* loaded from: classes.dex */
public class wb implements uc<ga> {
    public int a;

    public wb(int i) {
        this.a = i;
    }

    public final void b(ga gaVar, List<Float> list) {
        int i = this.a * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = list.get(i).floatValue();
            } else {
                dArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < gaVar.c(); i3++) {
            int i4 = gaVar.a()[i3];
            gaVar.a()[i3] = Color.argb(c(gaVar.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    @IntRange(from = 0, to = 255)
    public final int c(double d, double[] dArr, double[] dArr2) {
        double dJ;
        int i = 1;
        while (true) {
            if (i >= dArr.length) {
                dJ = dArr2[dArr2.length - 1];
                break;
            }
            int i2 = i - 1;
            double d2 = dArr[i2];
            double d3 = dArr[i];
            if (dArr[i] >= d) {
                dJ = gd.j(dArr2[i2], dArr2[i], gd.b((d - d2) / (d3 - d2), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d));
                break;
            }
            i++;
        }
        return (int) (dJ * 255.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    @Override // dc.uc
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public dc.ga a(dc.xc r13, float r14) throws java.io.IOException {
        /*
            r12 = this;
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            dc.xc$b r0 = r13.K()
            dc.xc$b r1 = dc.xc.b.BEGIN_ARRAY
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L17
            r13.e()
        L17:
            boolean r1 = r13.p()
            if (r1 == 0) goto L2a
            double r4 = r13.x()
            float r1 = (float) r4
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r14.add(r1)
            goto L17
        L2a:
            if (r0 == 0) goto L2f
            r13.j()
        L2f:
            int r13 = r12.a
            r0 = -1
            if (r13 != r0) goto L3c
            int r13 = r14.size()
            int r13 = r13 / 4
            r12.a = r13
        L3c:
            int r13 = r12.a
            float[] r0 = new float[r13]
            int[] r13 = new int[r13]
            r1 = 0
            r4 = 0
        L44:
            int r5 = r12.a
            int r5 = r5 * 4
            if (r3 >= r5) goto L95
            int r5 = r3 / 4
            java.lang.Object r6 = r14.get(r3)
            java.lang.Float r6 = (java.lang.Float) r6
            float r6 = r6.floatValue()
            double r6 = (double) r6
            int r8 = r3 % 4
            if (r8 == 0) goto L7d
            r9 = 4643176031446892544(0x406fe00000000000, double:255.0)
            if (r8 == r2) goto L79
            r11 = 2
            if (r8 == r11) goto L75
            r11 = 3
            if (r8 == r11) goto L69
            goto L92
        L69:
            double r6 = r6 * r9
            int r6 = (int) r6
            r7 = 255(0xff, float:3.57E-43)
            int r6 = android.graphics.Color.argb(r7, r1, r4, r6)
            r13[r5] = r6
            goto L92
        L75:
            double r6 = r6 * r9
            int r4 = (int) r6
            goto L92
        L79:
            double r6 = r6 * r9
            int r1 = (int) r6
            goto L92
        L7d:
            if (r5 <= 0) goto L8f
            int r8 = r5 + (-1)
            r8 = r0[r8]
            float r9 = (float) r6
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 < 0) goto L8f
            r6 = 1008981770(0x3c23d70a, float:0.01)
            float r9 = r9 + r6
            r0[r5] = r9
            goto L92
        L8f:
            float r6 = (float) r6
            r0[r5] = r6
        L92:
            int r3 = r3 + 1
            goto L44
        L95:
            dc.ga r1 = new dc.ga
            r1.<init>(r0, r13)
            r12.b(r1, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.wb.a(dc.xc, float):dc.ga");
    }
}
