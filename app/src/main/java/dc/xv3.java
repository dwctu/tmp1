package dc;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AutoLayoutHelper.java */
/* loaded from: classes4.dex */
public class xv3 {
    public static final int[] b = {R.attr.textSize, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight};
    public static wv3 c;
    public final ViewGroup a;

    /* compiled from: AutoLayoutHelper.java */
    public interface a {
        cv3 a();
    }

    public xv3(ViewGroup viewGroup) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.a = viewGroup;
        if (c == null) {
            c(viewGroup);
        }
    }

    public static cv3 b(Context context, AttributeSet attributeSet) {
        cv3 cv3Var = new cv3();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, dv3.AutoLayout_Layout);
        int i = typedArrayObtainStyledAttributes.getInt(dv3.AutoLayout_Layout_layout_auto_basewidth, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(dv3.AutoLayout_Layout_layout_auto_baseheight, 0);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, b);
        int indexCount = typedArrayObtainStyledAttributes2.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes2.getIndex(i3);
            if (zv3.b(typedArrayObtainStyledAttributes2.peekValue(index))) {
                try {
                    int dimensionPixelOffset = typedArrayObtainStyledAttributes2.getDimensionPixelOffset(index, 0);
                    switch (index) {
                        case 0:
                            cv3Var.a(new uv3(dimensionPixelOffset, i, i2));
                            break;
                        case 1:
                            cv3Var.a(new pv3(dimensionPixelOffset, i, i2));
                            break;
                        case 2:
                            cv3Var.a(new rv3(dimensionPixelOffset, i, i2));
                            break;
                        case 3:
                            cv3Var.a(new tv3(dimensionPixelOffset, i, i2));
                            break;
                        case 4:
                            cv3Var.a(new sv3(dimensionPixelOffset, i, i2));
                            break;
                        case 5:
                            cv3Var.a(new qv3(dimensionPixelOffset, i, i2));
                            break;
                        case 6:
                            cv3Var.a(new vv3(dimensionPixelOffset, i, i2));
                            break;
                        case 7:
                            cv3Var.a(new fv3(dimensionPixelOffset, i, i2));
                            break;
                        case 8:
                            cv3Var.a(new gv3(dimensionPixelOffset, i, i2));
                            break;
                        case 9:
                            cv3Var.a(new iv3(dimensionPixelOffset, i, i2));
                            break;
                        case 10:
                            cv3Var.a(new kv3(dimensionPixelOffset, i, i2));
                            break;
                        case 11:
                            cv3Var.a(new jv3(dimensionPixelOffset, i, i2));
                            break;
                        case 12:
                            cv3Var.a(new hv3(dimensionPixelOffset, i, i2));
                            break;
                        case 13:
                            cv3Var.a(new mv3(dimensionPixelOffset, i, i2));
                            break;
                        case 14:
                            cv3Var.a(new lv3(dimensionPixelOffset, i, i2));
                            break;
                        case 15:
                            cv3Var.a(new ov3(dimensionPixelOffset, i, i2));
                            break;
                        case 16:
                            cv3Var.a(new nv3(dimensionPixelOffset, i, i2));
                            break;
                    }
                } catch (Exception unused) {
                }
            }
        }
        typedArrayObtainStyledAttributes2.recycle();
        aw3.a(" getAutoLayoutInfo " + cv3Var.toString());
        return cv3Var;
    }

    public void a() {
        cv3 cv3VarA;
        wv3.d().a();
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.a.getChildAt(i);
            Object layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof a) && (cv3VarA = ((a) layoutParams).a()) != null) {
                cv3VarA.b(childAt);
            }
        }
    }

    public final void c(ViewGroup viewGroup) throws IllegalAccessException, PackageManager.NameNotFoundException, IllegalArgumentException, InvocationTargetException {
        wv3 wv3VarD = wv3.d();
        c = wv3VarD;
        wv3VarD.h(viewGroup.getContext());
    }
}
