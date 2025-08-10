package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import dc.lh0;
import dc.mh0;
import dc.nh0;
import dc.oh0;
import dc.ph0;
import dc.qh0;
import dc.rh0;
import dc.sh0;

/* loaded from: classes.dex */
public class PhotoView extends AppCompatImageView {
    public sh0 a;
    public ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public final void a() {
        this.a = new sh0(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public sh0 getAttacher() {
        return this.a;
    }

    public RectF getDisplayRect() {
        return this.a.D();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.G();
    }

    public float getMaximumScale() {
        return this.a.J();
    }

    public float getMediumScale() {
        return this.a.K();
    }

    public float getMinimumScale() {
        return this.a.L();
    }

    public float getScale() {
        return this.a.M();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.a.N();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.Q(z);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.a.o0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        sh0 sh0Var = this.a;
        if (sh0Var != null) {
            sh0Var.o0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        sh0 sh0Var = this.a;
        if (sh0Var != null) {
            sh0Var.o0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        sh0 sh0Var = this.a;
        if (sh0Var != null) {
            sh0Var.o0();
        }
    }

    public void setMaximumScale(float f) {
        this.a.S(f);
    }

    public void setMediumScale(float f) {
        this.a.T(f);
    }

    public void setMinimumScale(float f) {
        this.a.U(f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.V(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.W(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.X(onLongClickListener);
    }

    public void setOnMatrixChangeListener(lh0 lh0Var) {
        this.a.Y(lh0Var);
    }

    public void setOnOutsidePhotoTapListener(mh0 mh0Var) {
        this.a.Z(mh0Var);
    }

    public void setOnPhotoTapListener(nh0 nh0Var) {
        this.a.a0(nh0Var);
    }

    public void setOnScaleChangeListener(oh0 oh0Var) {
        this.a.b0(oh0Var);
    }

    public void setOnSingleFlingListener(ph0 ph0Var) {
        this.a.c0(ph0Var);
    }

    public void setOnViewDragListener(qh0 qh0Var) {
        this.a.d0(qh0Var);
    }

    public void setOnViewTapListener(rh0 rh0Var) {
        this.a.e0(rh0Var);
    }

    public void setRotationBy(float f) {
        this.a.f0(f);
    }

    public void setRotationTo(float f) {
        this.a.g0(f);
    }

    public void setScale(float f) {
        this.a.h0(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.a.k0(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        sh0 sh0Var = this.a;
        if (sh0Var == null) {
            this.b = scaleType;
        } else {
            sh0Var.l0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.a.m0(i);
    }

    public void setZoomable(boolean z) {
        this.a.n0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f, boolean z) {
        this.a.j0(f, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.a.i0(f, f2, f3, z);
    }
}
