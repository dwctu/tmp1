package dc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

/* compiled from: DensityUtils.java */
/* loaded from: classes4.dex */
public class ce3 {
    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static ColorStateList b(Resources resources, int i) {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColorStateList(i, null) : resources.getColorStateList(i);
    }

    public static boolean c(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int d(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return size;
        }
        return 0;
    }

    public static int e(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return size;
        }
        return 0;
    }

    public static void f(TextView textView, int i) {
        Drawable drawableD = th4.d(textView.getContext(), i);
        drawableD.setBounds(0, 0, drawableD.getMinimumWidth(), drawableD.getMinimumHeight());
        textView.setCompoundDrawables(null, drawableD, null, null);
    }

    public static int g(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
