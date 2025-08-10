package dc;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: SkinCompatRoundStrokeHelper.java */
/* loaded from: classes5.dex */
public class yi4 extends vi4 {
    public final View a;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;

    public yi4(View view) {
        this.a = view;
    }

    public void b() {
        if (this.d != 0) {
            this.b = th4.b(this.a.getContext(), this.d);
        }
        if (this.e != 0) {
            this.c = th4.b(this.a.getContext(), this.e);
        }
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public void e(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, yg4.SkinRoundStrokeHelper, i, 0);
        try {
            int i2 = yg4.SkinRoundStrokeHelper_rStrokeColor;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.d = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
                this.e = typedArrayObtainStyledAttributes.getResourceId(yg4.SkinRoundStrokeHelper_rTouchStrokeColor, 0);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
