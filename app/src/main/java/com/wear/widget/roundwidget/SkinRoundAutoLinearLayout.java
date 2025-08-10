package com.wear.widget.roundwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.zhy.autolayout.AutoLinearLayout;
import dc.aj4;
import dc.kb1;
import dc.lb1;
import dc.si4;
import dc.yi4;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: SkinRoundAutoLinearLayout.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J(\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0014J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J(\u0010\u001f\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u000bH\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020!H\u0016J\u0018\u00102\u001a\u00020\u00142\u0006\u00101\u001a\u00020!2\u0006\u0010/\u001a\u00020\u000bH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/wear/widget/roundwidget/SkinRoundAutoLinearLayout;", "Lcom/zhy/autolayout/AutoLinearLayout;", "Lcom/kproduce/roundcorners/core/RoundMethodInterface;", "Lskin/support/widget/SkinCompatSupportable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackgroundTintHelper", "Lskin/support/widget/SkinCompatBackgroundHelper;", "mHelper", "Lcom/kproduce/roundcorners/core/RoundHelper;", "mStrokeHelper", "Lskin/support/widget/SkinCompatRoundStrokeHelper;", "applySkin", "", "draw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", XHTMLText.H, "oldw", "oldh", "setBackgroundResource", "resId", "setRadius", "radiusDp", "", "radiusTopLeftDp", "radiusTopRightDp", "radiusBottomLeftDp", "radiusBottomRightDp", "setRadiusBottom", "setRadiusBottomLeft", "setRadiusBottomRight", "setRadiusLeft", "setRadiusRight", "setRadiusTop", "setRadiusTopLeft", "setRadiusTopRight", "setStrokeColor", "color", "setStrokeWidth", "widthDp", "setStrokeWidthColor", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class SkinRoundAutoLinearLayout extends AutoLinearLayout implements aj4 {

    @NotNull
    public final kb1 b;

    @Nullable
    public si4 c;

    @Nullable
    public yi4 d;

    public SkinRoundAutoLinearLayout(@Nullable Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.b();
        }
        b();
    }

    public final void b() {
        yi4 yi4Var = this.d;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.c() != -1) {
                setStrokeColor(yi4Var.c());
            }
        }
    }

    @Override // android.view.View
    public void draw(@Nullable Canvas canvas) {
        this.b.g(canvas);
        super.draw(canvas);
        this.b.m(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.b.k(w, h);
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.d(resId);
        }
    }

    public void setRadius(float radiusDp) {
        this.b.j(radiusDp);
    }

    public void setRadiusBottom(float radiusDp) {
        this.b.e(radiusDp);
    }

    public void setRadiusBottomLeft(float radiusDp) {
        this.b.a(radiusDp);
    }

    public void setRadiusBottomRight(float radiusDp) {
        this.b.q(radiusDp);
    }

    public void setRadiusLeft(float radiusDp) {
        this.b.p(radiusDp);
    }

    public void setRadiusRight(float radiusDp) {
        this.b.o(radiusDp);
    }

    public void setRadiusTop(float radiusDp) {
        this.b.f(radiusDp);
    }

    public void setRadiusTopLeft(float radiusDp) {
        this.b.d(radiusDp);
    }

    public void setRadiusTopRight(float radiusDp) {
        this.b.h(radiusDp);
    }

    public void setStrokeColor(int color) {
        this.b.l(color);
    }

    public void setStrokeWidth(float widthDp) {
        this.b.r(widthDp);
    }

    public void setStrokeWidthColor(float widthDp, int color) {
        this.b.b(widthDp, color);
    }

    public SkinRoundAutoLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setRadius(float radiusTopLeftDp, float radiusTopRightDp, float radiusBottomLeftDp, float radiusBottomRightDp) {
        this.b.n(radiusTopLeftDp, radiusTopRightDp, radiusBottomLeftDp, radiusBottomRightDp);
    }

    public SkinRoundAutoLinearLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        lb1 lb1Var = new lb1();
        this.b = lb1Var;
        lb1Var.i(context, attributeSet, this);
        this.c = new si4(this);
        if (isInEditMode()) {
            return;
        }
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.c(attributeSet, i);
        }
        yi4 yi4Var = new yi4(this);
        this.d = yi4Var;
        if (yi4Var != null) {
            yi4Var.e(attributeSet, i);
        }
        b();
    }
}
