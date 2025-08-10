package dc;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: SkinShadowHelper.java */
/* loaded from: classes5.dex */
public class dj4 extends vi4 {
    public final View a;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;

    public dj4(View view) {
        this.a = view;
    }

    public void b() {
        if (this.b != 0) {
            this.c = th4.b(this.a.getContext(), this.b);
        }
        if (this.d != 0) {
            this.e = th4.b(this.a.getContext(), this.d);
        }
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.c;
    }

    public void e(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, yg4.SkinShadowHelper, i, 0);
        try {
            int i2 = lh4.SkinShadowHelper_hl_shadowColor;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            int i3 = lh4.SkinShadowHelper_hl_layoutBackground;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.d = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
