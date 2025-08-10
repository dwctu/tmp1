package com.wear.widget.roundwidget;

import android.content.Context;
import android.util.AttributeSet;
import com.kproduce.roundcorners.RoundConstraintLayout;
import dc.aj4;
import dc.si4;
import dc.yi4;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: SkinRoundConstraintLayout.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/wear/widget/roundwidget/SkinRoundConstraintLayout;", "Lcom/kproduce/roundcorners/RoundConstraintLayout;", "Lskin/support/widget/SkinCompatSupportable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackgroundTintHelper", "Lskin/support/widget/SkinCompatBackgroundHelper;", "mStrokeHelper", "Lskin/support/widget/SkinCompatRoundStrokeHelper;", "applySkin", "", "setBackgroundResource", "resId", "setStrokeColor", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class SkinRoundConstraintLayout extends RoundConstraintLayout implements aj4 {

    @Nullable
    public si4 b;

    @Nullable
    public yi4 c;

    public SkinRoundConstraintLayout(@Nullable Context context) {
        this(context, null);
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.b();
        }
        a();
    }

    public final void a() {
        yi4 yi4Var = this.c;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.c() != -1) {
                super.setStrokeColor(yi4Var.c());
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.d(resId);
        }
    }

    public SkinRoundConstraintLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinRoundConstraintLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new si4(this);
        if (isInEditMode()) {
            return;
        }
        si4 si4Var = this.b;
        if (si4Var != null) {
            si4Var.c(attributeSet, i);
        }
        yi4 yi4Var = new yi4(this);
        this.c = yi4Var;
        if (yi4Var != null) {
            yi4Var.e(attributeSet, i);
        }
        a();
    }
}
