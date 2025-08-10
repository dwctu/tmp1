package dc;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;

/* compiled from: ScreenUtils.java */
/* loaded from: classes.dex */
public final class oe0 {
    public static int a() {
        return b(ve0.a());
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return c(context, point)[0];
    }

    public static int[] c(Context context, Point point) {
        int iMin;
        int iMax;
        if (f(context)) {
            iMin = Math.max(point.x, point.y);
            iMax = Math.min(point.x, point.y);
        } else {
            iMin = Math.min(point.x, point.y);
            iMax = Math.max(point.x, point.y);
        }
        return new int[]{iMin, iMax};
    }

    public static int d() {
        return e(ve0.a());
    }

    public static int e(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return c(context, point)[0];
    }

    public static boolean f(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
