package dc;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.wear.widget.control.FingImageLayout;
import dc.xc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
public class ac {
    public static final xc.a a = xc.a.a("x", FingImageLayout.ObjectAnimatorY);

    /* compiled from: JsonUtils.java */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[xc.b.values().length];
            a = iArr;
            try {
                iArr[xc.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[xc.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[xc.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(xc xcVar, float f) throws IOException {
        xcVar.e();
        float fX = (float) xcVar.x();
        float fX2 = (float) xcVar.x();
        while (xcVar.K() != xc.b.END_ARRAY) {
            xcVar.X();
        }
        xcVar.j();
        return new PointF(fX * f, fX2 * f);
    }

    public static PointF b(xc xcVar, float f) throws IOException {
        float fX = (float) xcVar.x();
        float fX2 = (float) xcVar.x();
        while (xcVar.p()) {
            xcVar.X();
        }
        return new PointF(fX * f, fX2 * f);
    }

    public static PointF c(xc xcVar, float f) throws IOException {
        xcVar.f();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (xcVar.p()) {
            int iO = xcVar.O(a);
            if (iO == 0) {
                fG = g(xcVar);
            } else if (iO != 1) {
                xcVar.V();
                xcVar.X();
            } else {
                fG2 = g(xcVar);
            }
        }
        xcVar.m();
        return new PointF(fG * f, fG2 * f);
    }

    @ColorInt
    public static int d(xc xcVar) throws IOException {
        xcVar.e();
        int iX = (int) (xcVar.x() * 255.0d);
        int iX2 = (int) (xcVar.x() * 255.0d);
        int iX3 = (int) (xcVar.x() * 255.0d);
        while (xcVar.p()) {
            xcVar.X();
        }
        xcVar.j();
        return Color.argb(255, iX, iX2, iX3);
    }

    public static PointF e(xc xcVar, float f) throws IOException {
        int i = a.a[xcVar.K().ordinal()];
        if (i == 1) {
            return b(xcVar, f);
        }
        if (i == 2) {
            return a(xcVar, f);
        }
        if (i == 3) {
            return c(xcVar, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + xcVar.K());
    }

    public static List<PointF> f(xc xcVar, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        xcVar.e();
        while (xcVar.K() == xc.b.BEGIN_ARRAY) {
            xcVar.e();
            arrayList.add(e(xcVar, f));
            xcVar.j();
        }
        xcVar.j();
        return arrayList;
    }

    public static float g(xc xcVar) throws IOException {
        xc.b bVarK = xcVar.K();
        int i = a.a[bVarK.ordinal()];
        if (i == 1) {
            return (float) xcVar.x();
        }
        if (i != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + bVarK);
        }
        xcVar.e();
        float fX = (float) xcVar.x();
        while (xcVar.p()) {
            xcVar.X();
        }
        xcVar.j();
        return fX;
    }
}
