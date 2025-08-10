package com.wear.widget.roundwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.DrawableRes;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.kproduce.roundcorners.RoundButton;
import dc.aj4;
import dc.bj4;
import dc.si4;
import dc.yi4;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SkinRoundButton.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\nH\u0016J0\u0010\u001d\u001a\u00020\u00172\b\b\u0001\u0010\u001e\u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020\n2\b\b\u0001\u0010 \u001a\u00020\n2\b\b\u0001\u0010!\u001a\u00020\nH\u0016J0\u0010\"\u001a\u00020\u00172\b\b\u0001\u0010#\u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020\n2\b\b\u0001\u0010$\u001a\u00020\n2\b\b\u0001\u0010!\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\u001a\u0010&\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010'\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/wear/widget/roundwidget/SkinRoundButton;", "Lcom/kproduce/roundcorners/RoundButton;", "Lskin/support/widget/SkinCompatSupportable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "isAutoSetLineHeight", "", "mBackgroundTintHelper", "Lskin/support/widget/SkinCompatBackgroundHelper;", "mStrokeHelper", "Lskin/support/widget/SkinCompatRoundStrokeHelper;", "mTextHelper", "Lskin/support/widget/SkinCompatTextHelper;", "applySkin", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setBackgroundResource", "resId", "setCompoundDrawablesRelativeWithIntrinsicBounds", TtmlNode.START, "top", TtmlNode.END, "bottom", "setCompoundDrawablesWithIntrinsicBounds", TtmlNode.LEFT, TtmlNode.RIGHT, "setStrokeColor", "setTextAppearance", "setTextSize", "size", "", "unit", "setTouchStrokeColor", "updateLineSpacing", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class SkinRoundButton extends RoundButton implements aj4 {

    @NotNull
    public final String b;

    @Nullable
    public si4 c;

    @Nullable
    public bj4 d;

    @Nullable
    public yi4 e;
    public boolean f;

    public SkinRoundButton(@Nullable Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.b();
        }
        bj4 bj4Var = this.d;
        if (bj4Var != null) {
            bj4Var.d();
        }
        a();
    }

    public final void a() {
        yi4 yi4Var = this.e;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.c() != -1) {
                super.setStrokeColor(yi4Var.c());
            }
        }
    }

    public final void b() {
        yi4 yi4Var = this.e;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.d() != -1) {
                super.setStrokeColor(yi4Var.d());
            }
        }
    }

    public final void c() {
        if (this.f) {
            String str = "updateLineSpacing before: " + getTextSize() + ' ' + getLineHeight() + ' ' + getLineSpacingExtra() + ' ' + this;
            super.setLineSpacing(((float) ((Math.ceil(getTextSize() / 10) * 2) + getTextSize())) - (getLineHeight() - getLineSpacingExtra()), 1.0f);
            String str2 = "updateLineSpacing after: " + getTextSize() + ' ' + getLineHeight() + ' ' + getLineSpacingExtra() + ' ' + this;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        if (isClickable()) {
            Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
            if (numValueOf != null && numValueOf.intValue() == 0) {
                b();
            } else if (numValueOf != null && numValueOf.intValue() == 1) {
                a();
            } else if (numValueOf != null && numValueOf.intValue() == 3) {
                a();
            }
        }
        return super.onTouchEvent(event);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        si4 si4Var = this.c;
        if (si4Var != null) {
            si4Var.d(resId);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int start, @DrawableRes int top, @DrawableRes int end, @DrawableRes int bottom) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        bj4 bj4Var = this.d;
        if (bj4Var != null) {
            bj4Var.l(start, top, end, bottom);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int left, @DrawableRes int top, @DrawableRes int right, @DrawableRes int bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        bj4 bj4Var = this.d;
        if (bj4Var != null) {
            bj4Var.m(left, top, right, bottom);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int resId) {
        setTextAppearance(getContext(), resId);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        c();
    }

    public SkinRoundButton(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setTextAppearance(@Nullable Context context, int resId) {
        super.setTextAppearance(context, resId);
        bj4 bj4Var = this.d;
        if (bj4Var != null) {
            bj4Var.n(context, resId);
        }
        c();
    }

    public SkinRoundButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "SkinRoundButton";
        si4 si4Var = new si4(this);
        this.c = si4Var;
        if (si4Var != null) {
            si4Var.c(attributeSet, i);
        }
        bj4 bj4VarH = bj4.h(this);
        this.d = bj4VarH;
        if (bj4VarH != null) {
            bj4VarH.k(attributeSet, i);
        }
        yi4 yi4Var = new yi4(this);
        this.e = yi4Var;
        if (yi4Var != null) {
            yi4Var.e(attributeSet, i);
        }
        a();
        setIncludeFontPadding(false);
        this.f = getLineSpacingExtra() == 0.0f;
        c();
    }

    @Override // android.widget.TextView
    public void setTextSize(float size) {
        super.setTextSize(size);
        c();
    }
}
