package com.wear.widget;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.fv1;
import dc.lv1;

/* loaded from: classes4.dex */
public abstract class BaseFloatIngView extends FrameLayout {
    public static int e = -1;
    public static int f = -1;
    public static boolean g = false;
    public fv1 a;
    public b b;
    public AnimatorSet c;
    public lv1 d;

    public class a extends lv1 {
        public a() {
        }

        @Override // dc.lv1
        public void a(boolean z) {
            fv1 fv1Var = BaseFloatIngView.this.a;
            if (fv1Var != null) {
                fv1Var.b(z);
            }
            BaseFloatIngView.this.b.c = z;
        }
    }

    public static class b {
        public int a;
        public int b;
        public boolean c = false;
    }

    public BaseFloatIngView(@NonNull Context context) {
        super(context);
        this.b = new b();
        AnimatorSet animatorSet = new AnimatorSet();
        this.c = animatorSet;
        a aVar = new a();
        this.d = aVar;
        animatorSet.addListener(aVar);
    }

    public abstract b getData();

    public void setListener(fv1 fv1Var) {
        this.a = fv1Var;
    }

    public void setPointX(int i, int i2, boolean z) {
    }

    public abstract void setWidthAndHeight(Activity activity, int i, int i2);

    public BaseFloatIngView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new b();
        AnimatorSet animatorSet = new AnimatorSet();
        this.c = animatorSet;
        a aVar = new a();
        this.d = aVar;
        animatorSet.addListener(aVar);
    }

    public BaseFloatIngView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new b();
        AnimatorSet animatorSet = new AnimatorSet();
        this.c = animatorSet;
        a aVar = new a();
        this.d = aVar;
        animatorSet.addListener(aVar);
    }
}
