package dc;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* compiled from: MiscUtils.java */
/* loaded from: classes.dex */
public class gd {
    public static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean e(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static int f(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int g(float f, float f2) {
        return h((int) f, (int) f2);
    }

    public static int h(int i, int i2) {
        return i - (i2 * f(i, i2));
    }

    public static void i(pa paVar, Path path) {
        path.reset();
        PointF pointFB = paVar.b();
        path.moveTo(pointFB.x, pointFB.y);
        a.set(pointFB.x, pointFB.y);
        for (int i = 0; i < paVar.a().size(); i++) {
            h9 h9Var = paVar.a().get(i);
            PointF pointFA = h9Var.a();
            PointF pointFB2 = h9Var.b();
            PointF pointFC = h9Var.c();
            if (pointFA.equals(a) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            a.set(pointFC.x, pointFC.y);
        }
        if (paVar.d()) {
            path.close();
        }
    }

    public static double j(double d, double d2, @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float k(float f, float f2, @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int l(int i, int i2, @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static void m(l9 l9Var, int i, List<l9> list, l9 l9Var2, g8 g8Var) {
        if (l9Var.c(g8Var.getName(), i)) {
            list.add(l9Var2.a(g8Var.getName()).i(g8Var));
        }
    }
}
