package dc;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;

/* compiled from: SkinCompatThemeUtils.java */
/* loaded from: classes5.dex */
public class uh4 {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final int[] b = {-16842910};
    public static final int[] c = {R.attr.state_enabled};
    public static final int[] d = {R.attr.state_window_focused};
    public static final int[] e = {R.attr.state_focused};
    public static final int[] f = {R.attr.state_activated};
    public static final int[] g = {R.attr.state_accelerated};
    public static final int[] h = {R.attr.state_hovered};
    public static final int[] i = {R.attr.state_drag_can_accept};
    public static final int[] j = {R.attr.state_drag_hovered};
    public static final int[] k = {R.attr.state_pressed};
    public static final int[] l = {R.attr.state_checked};
    public static final int[] m = {R.attr.state_selected};
    public static final int[] n = new int[0];
    public static final int[] o = new int[1];

    public static int a(Context context, int i2) {
        ColorStateList colorStateListF = f(context, i2);
        if (colorStateListF != null && colorStateListF.isStateful()) {
            return colorStateListF.getColorForState(b, colorStateListF.getDefaultColor());
        }
        TypedValue typedValueG = g();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueG, true);
        return e(context, i2, typedValueG.getFloat());
    }

    public static int b(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int c(Context context) {
        return b(context, new int[]{R.attr.textColorPrimary});
    }

    public static int d(Context context, int i2) {
        int[] iArr = o;
        iArr[0] = i2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                return th4.b(context, resourceId);
            }
            return 0;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int e(Context context, int i2, float f2) {
        return ei4.a(d(context, i2), Math.round(Color.alpha(r0) * f2));
    }

    public static ColorStateList f(Context context, int i2) {
        int[] iArr = o;
        iArr[0] = i2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                return th4.c(context, resourceId);
            }
            return null;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static TypedValue g() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static int h(Context context) {
        return b(context, new int[]{R.attr.windowBackground});
    }
}
