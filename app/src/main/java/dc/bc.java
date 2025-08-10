package dc;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.wear.widget.control.FingImageLayout;
import dc.xc;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
public class bc {
    public static SparseArrayCompat<WeakReference<Interpolator>> b;
    public static final Interpolator a = new LinearInterpolator();
    public static xc.a c = xc.a.a("t", "s", "e", "o", "i", XHTMLText.H, "to", "ti");
    public static xc.a d = xc.a.a("x", FingImageLayout.ObjectAnimatorY);

    @Nullable
    public static WeakReference<Interpolator> a(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (bc.class) {
            weakReference = g().get(i);
        }
        return weakReference;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorCreate;
        pointF.x = gd.c(pointF.x, -1.0f, 1.0f);
        pointF.y = gd.c(pointF.y, -100.0f, 100.0f);
        pointF2.x = gd.c(pointF2.x, -1.0f, 1.0f);
        float fC = gd.c(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fC;
        int i = hd.i(pointF.x, pointF.y, pointF2.x, fC);
        WeakReference<Interpolator> weakReferenceA = a(i);
        Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                interpolatorCreate = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                interpolatorCreate = "The Path cannot loop back on itself.".equals(e.getMessage()) ? PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = interpolatorCreate;
            try {
                h(i, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> id<T> c(xc xcVar, f7 f7Var, float f, uc<T> ucVar, boolean z, boolean z2) throws IOException {
        return (z && z2) ? e(f7Var, xcVar, f, ucVar) : z ? d(f7Var, xcVar, f, ucVar) : f(xcVar, f, ucVar);
    }

    public static <T> id<T> d(f7 f7Var, xc xcVar, float f, uc<T> ucVar) throws IOException {
        Interpolator interpolatorB;
        T t;
        xcVar.f();
        PointF pointFE = null;
        PointF pointFE2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFE3 = null;
        PointF pointFE4 = null;
        boolean z = false;
        float fX = 0.0f;
        while (xcVar.p()) {
            switch (xcVar.O(c)) {
                case 0:
                    fX = (float) xcVar.x();
                    break;
                case 1:
                    tA2 = ucVar.a(xcVar, f);
                    break;
                case 2:
                    tA = ucVar.a(xcVar, f);
                    break;
                case 3:
                    pointFE = ac.e(xcVar, 1.0f);
                    break;
                case 4:
                    pointFE2 = ac.e(xcVar, 1.0f);
                    break;
                case 5:
                    if (xcVar.y() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointFE3 = ac.e(xcVar, f);
                    break;
                case 7:
                    pointFE4 = ac.e(xcVar, f);
                    break;
                default:
                    xcVar.X();
                    break;
            }
        }
        xcVar.m();
        if (z) {
            interpolatorB = a;
            t = tA2;
        } else {
            interpolatorB = (pointFE == null || pointFE2 == null) ? a : b(pointFE, pointFE2);
            t = tA;
        }
        id<T> idVar = new id<>(f7Var, tA2, t, interpolatorB, fX, null);
        idVar.o = pointFE3;
        idVar.p = pointFE4;
        return idVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> dc.id<T> e(dc.f7 r21, dc.xc r22, float r23, dc.uc<T> r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.bc.e(dc.f7, dc.xc, float, dc.uc):dc.id");
    }

    public static <T> id<T> f(xc xcVar, float f, uc<T> ucVar) throws IOException {
        return new id<>(ucVar.a(xcVar, f));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (b == null) {
            b = new SparseArrayCompat<>();
        }
        return b;
    }

    public static void h(int i, WeakReference<Interpolator> weakReference) {
        synchronized (bc.class) {
            b.put(i, weakReference);
        }
    }
}
