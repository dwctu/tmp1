package skin.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import com.google.android.material.textfield.TextInputLayout;
import dc.ai4;
import dc.aj4;
import dc.bi4;
import dc.ci4;
import dc.si4;
import dc.th4;
import dc.vi4;
import dc.yg4;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import skin.support.widget.SkinCompatEditText;

/* loaded from: classes5.dex */
public class SkinMaterialTextInputLayout extends TextInputLayout implements aj4 {
    public si4 a;
    public int b;
    public int c;
    public int d;

    public SkinMaterialTextInputLayout(Context context) {
        this(context, null);
    }

    private TextView getCounterView() throws NoSuchFieldException {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mCounterView");
            declaredField.setAccessible(true);
            return (TextView) declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private TextView getErrorView() throws NoSuchFieldException {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mErrorView");
            declaredField.setAccessible(true);
            return (TextView) declaredField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setDefaultTextColor(ColorStateList colorStateList) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, colorStateList);
            g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFocusedTextColor(ColorStateList colorStateList) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = TextInputLayout.class.getDeclaredField("mFocusedTextColor");
            declaredField.setAccessible(true);
            declaredField.set(this, colorStateList);
            g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // dc.aj4
    public void P1() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        b();
        a();
        c();
        si4 si4Var = this.a;
        if (si4Var != null) {
            si4Var.b();
        }
    }

    public final void a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        TextView counterView;
        int iA = vi4.a(this.b);
        this.b = iA;
        if (iA == 0 || (counterView = getCounterView()) == null) {
            return;
        }
        counterView.setTextColor(th4.b(getContext(), this.b));
        f();
    }

    public final void b() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        TextView errorView;
        int iA = vi4.a(this.c);
        this.c = iA;
        if (iA == 0 || iA == ai4.design_error || (errorView = getErrorView()) == null) {
            return;
        }
        errorView.setTextColor(th4.b(getContext(), this.c));
        f();
    }

    public final void c() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        int iA = vi4.a(this.d);
        this.d = iA;
        if (iA != 0 && iA != ai4.abc_hint_foreground_material_light) {
            setFocusedTextColor(th4.c(getContext(), this.d));
            return;
        }
        if (getEditText() != null) {
            int textColorResId = 0;
            if (getEditText() instanceof SkinCompatEditText) {
                textColorResId = ((SkinCompatEditText) getEditText()).getTextColorResId();
            } else if (getEditText() instanceof SkinMaterialTextInputEditText) {
                textColorResId = ((SkinMaterialTextInputEditText) getEditText()).getTextColorResId();
            }
            int iA2 = vi4.a(textColorResId);
            if (iA2 != 0) {
                setFocusedTextColor(th4.c(getContext(), iA2));
            }
        }
    }

    public final void d(@StyleRes int i) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i != 0) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(i, yg4.SkinTextAppearance);
            int i2 = yg4.SkinTextAppearance_android_textColor;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        a();
    }

    public final void e(@StyleRes int i) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i != 0) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(i, yg4.SkinTextAppearance);
            int i2 = yg4.SkinTextAppearance_android_textColor;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.c = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        b();
    }

    public final void f() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method declaredMethod = TextInputLayout.class.getDeclaredMethod("updateEditTextBackground", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void g() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method declaredMethod = TextInputLayout.class.getDeclaredMethod("updateLabelState", Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Boolean.FALSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setCounterEnabled(boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.setCounterEnabled(z);
        if (z) {
            a();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setErrorEnabled(boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.setErrorEnabled(z);
        if (z) {
            b();
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setErrorTextAppearance(@StyleRes int i) throws IllegalAccessException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.setErrorTextAppearance(i);
        e(i);
    }

    public SkinMaterialTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinMaterialTextInputLayout(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = 0;
        this.d = 0;
        si4 si4Var = new si4(this);
        this.a = si4Var;
        si4Var.c(attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ci4.TextInputLayout, i, bi4.Widget_Design_TextInputLayout);
        int i2 = ci4.TextInputLayout_android_textColorHint;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.d = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            c();
        }
        e(typedArrayObtainStyledAttributes.getResourceId(ci4.TextInputLayout_errorTextAppearance, 0));
        d(typedArrayObtainStyledAttributes.getResourceId(ci4.TextInputLayout_counterTextAppearance, 0));
        typedArrayObtainStyledAttributes.getResourceId(ci4.TextInputLayout_passwordToggleDrawable, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
