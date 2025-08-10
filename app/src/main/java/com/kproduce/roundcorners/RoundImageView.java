package com.kproduce.roundcorners;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import dc.kb1;
import dc.lb1;

/* loaded from: classes3.dex */
public class RoundImageView extends AppCompatImageView {
    public final kb1 a;

    public RoundImageView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.a.g(canvas);
        super.draw(canvas);
        this.a.m(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.k(i, i2);
    }

    public void setRadius(float f) {
        this.a.j(f);
    }

    public void setRadiusBottom(float f) {
        this.a.e(f);
    }

    public void setRadiusBottomLeft(float f) {
        this.a.a(f);
    }

    public void setRadiusBottomRight(float f) {
        this.a.q(f);
    }

    public void setRadiusLeft(float f) {
        this.a.p(f);
    }

    public void setRadiusRight(float f) {
        this.a.o(f);
    }

    public void setRadiusTop(float f) {
        this.a.f(f);
    }

    public void setRadiusTopLeft(float f) {
        this.a.d(f);
    }

    public void setRadiusTopRight(float f) {
        this.a.h(f);
    }

    public void setStrokeColor(int i) {
        this.a.l(i);
    }

    public void setStrokeWidth(float f) {
        this.a.r(f);
    }

    public void setStrokeWidthColor(float f, int i) {
        this.a.b(f, i);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setRadius(float f, float f2, float f3, float f4) {
        this.a.n(f, f2, f3, f4);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        lb1 lb1Var = new lb1();
        this.a = lb1Var;
        lb1Var.i(context, attributeSet, this);
    }
}
