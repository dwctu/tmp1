package dc;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.widget.CompoundButtonCompat;

/* compiled from: SkinCompatCompoundButtonHelper.java */
/* loaded from: classes5.dex */
public class ti4 extends vi4 {
    public final CompoundButton a;
    public int b = 0;
    public int c = 0;

    public ti4(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public void b() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA != 0) {
            CompoundButton compoundButton = this.a;
            compoundButton.setButtonDrawable(xh4.a(compoundButton.getContext(), this.b));
        }
        int iA2 = vi4.a(this.c);
        this.c = iA2;
        if (iA2 != 0) {
            CompoundButton compoundButton2 = this.a;
            CompoundButtonCompat.setButtonTintList(compoundButton2, th4.c(compoundButton2.getContext(), this.c));
        }
    }

    public void c(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, lh4.CompoundButton, i, 0);
        try {
            int i2 = lh4.CompoundButton_android_button;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            int i3 = lh4.CompoundButton_buttonTint;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.c = typedArrayObtainStyledAttributes.getResourceId(i3, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            b();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(int i) {
        this.b = i;
        b();
    }
}
