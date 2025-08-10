package dc;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: SkinCompatDividerHelper.java */
/* loaded from: classes5.dex */
public class ui4 extends vi4 {
    public final View a;
    public int b = 0;

    public ui4(View view) {
        this.a = view;
    }

    public void b() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA == 0) {
            return;
        }
        View view = this.a;
        if (view instanceof LinearLayout) {
            ((LinearLayout) view).setDividerDrawable(xh4.a(view.getContext(), this.b));
        }
    }

    public void c(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, yg4.SkinDividerHelper, i, 0);
        try {
            int i2 = yg4.SkinDividerHelper_android_divider;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            b();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
