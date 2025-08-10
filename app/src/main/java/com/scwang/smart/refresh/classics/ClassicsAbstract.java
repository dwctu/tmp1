package com.scwang.smart.refresh.classics;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.extractor.mp3.IndexSeeker;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import dc.ae1;
import dc.de1;
import dc.kd1;
import dc.se1;
import dc.vd1;
import dc.zd1;

/* loaded from: classes3.dex */
public abstract class ClassicsAbstract<T extends ClassicsAbstract<?>> extends SimpleComponent implements vd1 {
    public TextView d;
    public ImageView e;
    public ImageView f;
    public zd1 g;
    public kd1 h;
    public kd1 i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    public ClassicsAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 500;
        this.n = 20;
        this.o = 20;
        this.p = 0;
        this.b = de1.d;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    public int f(@NonNull ae1 ae1Var, boolean z) {
        ImageView imageView = this.f;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.m;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    public void g(@NonNull zd1 zd1Var, int i, int i2) {
        this.g = zd1Var;
        zd1Var.e(this, this.l);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    public void i(@NonNull ae1 ae1Var, int i, int i2) {
        ImageView imageView = this.f;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(IndexSeeker.MIN_TIME_BETWEEN_POINTS_US);
            }
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    public void j(@NonNull ae1 ae1Var, int i, int i2) {
        i(ae1Var, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.e;
        ImageView imageView2 = this.f;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Object drawable = this.f.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.p == 0) {
            this.n = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.o = paddingBottom;
            if (this.n == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int iC = this.n;
                if (iC == 0) {
                    iC = se1.c(20.0f);
                }
                this.n = iC;
                int iC2 = this.o;
                if (iC2 == 0) {
                    iC2 = se1.c(20.0f);
                }
                this.o = iC2;
                setPadding(paddingLeft, this.n, paddingRight, iC2);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int size = View.MeasureSpec.getSize(i2);
            int i3 = this.p;
            if (size < i3) {
                int i4 = (size - i3) / 2;
                setPadding(getPaddingLeft(), i4, getPaddingRight(), i4);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.n, getPaddingRight(), this.o);
        }
        super.onMeasure(i, i2);
        if (this.p == 0) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                int measuredHeight = getChildAt(i5).getMeasuredHeight();
                if (this.p < measuredHeight) {
                    this.p = measuredHeight;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T r() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T s(@ColorInt int i) {
        this.j = true;
        this.d.setTextColor(i);
        kd1 kd1Var = this.h;
        if (kd1Var != null) {
            kd1Var.a(i);
            this.e.invalidateDrawable(this.h);
        }
        kd1 kd1Var2 = this.i;
        if (kd1Var2 != null) {
            kd1Var2.a(i);
            this.f.invalidateDrawable(this.i);
        }
        r();
        return this;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.k) {
                t(iArr[0]);
                this.k = false;
            }
            if (this.j) {
                return;
            }
            if (iArr.length > 1) {
                s(iArr[1]);
            }
            this.j = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T t(@ColorInt int i) {
        this.k = true;
        this.l = i;
        zd1 zd1Var = this.g;
        if (zd1Var != null) {
            zd1Var.e(this, i);
        }
        r();
        return this;
    }
}
