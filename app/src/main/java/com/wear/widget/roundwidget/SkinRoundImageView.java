package com.wear.widget.roundwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.DrawableRes;
import com.kproduce.roundcorners.RoundImageView;
import dc.aj4;
import dc.si4;
import dc.wi4;
import dc.yi4;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: SkinRoundImageView.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\b\u0001\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/wear/widget/roundwidget/SkinRoundImageView;", "Lcom/kproduce/roundcorners/RoundImageView;", "Lskin/support/widget/SkinCompatSupportable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackgroundTintHelper", "Lskin/support/widget/SkinCompatBackgroundHelper;", "mImageHelper", "Lskin/support/widget/SkinCompatImageHelper;", "mStrokeHelper", "Lskin/support/widget/SkinCompatRoundStrokeHelper;", "applySkin", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setBackgroundResource", "resId", "setImageResource", "setStrokeColor", "color", "setTouchStrokeColor", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class SkinRoundImageView extends RoundImageView implements aj4 {

    @Nullable
    public si4 b;

    @Nullable
    public wi4 c;

    @Nullable
    public yi4 d;

    public SkinRoundImageView(@Nullable Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.b();
        }
        wi4 wi4Var = this.c;
        if (wi4Var != null) {
            wi4Var.b();
        }
        a();
    }

    public final void a() {
        yi4 yi4Var = this.d;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.c() != -1) {
                super.setStrokeColor(yi4Var.c());
            }
        }
    }

    public final void b() {
        yi4 yi4Var = this.d;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.d() != -1) {
                super.setStrokeColor(yi4Var.d());
            }
        }
    }

    @Override // android.view.View
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

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.d(resId);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int resId) {
        wi4 wi4Var = this.c;
        if (wi4Var != null) {
            wi4Var.d(resId);
        }
    }

    @Override // com.kproduce.roundcorners.RoundImageView
    public void setStrokeColor(int color) {
        super.setStrokeColor(color);
    }

    public SkinRoundImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinRoundImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        si4 si4Var = new si4(this);
        this.b = si4Var;
        if (si4Var != null) {
            si4Var.c(attributeSet, i);
        }
        wi4 wi4Var = new wi4(this);
        this.c = wi4Var;
        if (wi4Var != null) {
            wi4Var.c(attributeSet, i);
        }
        yi4 yi4Var = new yi4(this);
        this.d = yi4Var;
        if (yi4Var != null) {
            yi4Var.e(attributeSet, i);
        }
        a();
    }
}
