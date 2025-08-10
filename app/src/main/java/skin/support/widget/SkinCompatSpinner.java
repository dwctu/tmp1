package skin.support.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatSpinner;
import dc.aj4;
import dc.kh4;
import dc.lh4;
import dc.si4;
import dc.vi4;
import dc.xh4;

/* loaded from: classes5.dex */
public class SkinCompatSpinner extends AppCompatSpinner implements aj4 {
    public static final String c = SkinCompatSpinner.class.getSimpleName();
    public static final int[] d = {R.attr.spinnerMode};
    public si4 a;
    public int b;

    public SkinCompatSpinner(Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
        a();
    }

    public final void a() {
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA != 0) {
            setPopupBackgroundDrawable(xh4.a(getContext(), this.b));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i) {
        super.setPopupBackgroundResource(i);
        this.b = i;
        a();
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, kh4.spinnerStyle);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i, i2, theme);
        this.b = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, lh4.Spinner, i, 0);
        if (getPopupContext() != null) {
            if (i2 == -1) {
                if (Build.VERSION.SDK_INT >= 11) {
                    TypedArray typedArrayObtainStyledAttributes2 = null;
                    try {
                        typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d, i, 0);
                        i2 = typedArrayObtainStyledAttributes2.hasValue(0) ? typedArrayObtainStyledAttributes2.getInt(0, 0) : i2;
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes2 != null) {
                        }
                    } catch (Throwable th) {
                        if (typedArrayObtainStyledAttributes2 != null) {
                            typedArrayObtainStyledAttributes2.recycle();
                        }
                        throw th;
                    }
                    if (typedArrayObtainStyledAttributes2 != null) {
                        typedArrayObtainStyledAttributes2.recycle();
                    }
                } else {
                    i2 = 1;
                }
            }
            if (i2 == 1) {
                TypedArray typedArrayObtainStyledAttributes3 = getPopupContext().obtainStyledAttributes(attributeSet, lh4.Spinner, i, 0);
                this.b = typedArrayObtainStyledAttributes3.getResourceId(lh4.Spinner_android_popupBackground, 0);
                typedArrayObtainStyledAttributes3.recycle();
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, i);
    }
}
