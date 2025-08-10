package com.wear.widget.roundwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.DrawableRes;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.kproduce.roundcorners.RoundTextView;
import dc.ah4;
import dc.aj4;
import dc.bh4;
import dc.bj4;
import dc.ch4;
import dc.si4;
import dc.vi4;
import dc.yi4;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SkinRoundTextView.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000bH\u0016J0\u0010$\u001a\u00020\u001d2\b\b\u0001\u0010%\u001a\u00020\u000b2\b\b\u0001\u0010&\u001a\u00020\u000b2\b\b\u0001\u0010'\u001a\u00020\u000b2\b\b\u0001\u0010(\u001a\u00020\u000bH\u0016J0\u0010)\u001a\u00020\u001d2\b\b\u0001\u0010*\u001a\u00020\u000b2\b\b\u0001\u0010&\u001a\u00020\u000b2\b\b\u0001\u0010+\u001a\u00020\u000b2\b\b\u0001\u0010(\u001a\u00020\u000bH\u0016J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u001dH\u0002J\u001a\u00101\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u000bH\u0016J)\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u000b2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0016¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020.H\u0016J\u0018\u00106\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020.H\u0016J\u0012\u00109\u001a\u00020\u001d2\b\u0010:\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010;\u001a\u00020\u001dH\u0002J\b\u0010<\u001a\u00020\u001dH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/wear/widget/roundwidget/SkinRoundTextView;", "Lcom/kproduce/roundcorners/RoundTextView;", "Lskin/support/widget/SkinCompatSupportable;", "Lskin/support/TextSupportable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "isAutoSetLineHeight", "", "key", "keyArgs", "", "", "[Ljava/lang/Object;", "mBackgroundTintHelper", "Lskin/support/widget/SkinCompatBackgroundHelper;", "mStrokeHelper", "Lskin/support/widget/SkinCompatRoundStrokeHelper;", "mTextHelper", "Lskin/support/widget/SkinCompatTextHelper;", "applySkin", "", "flashText", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setBackgroundResource", "resId", "setCompoundDrawablesRelativeWithIntrinsicBounds", TtmlNode.START, "top", TtmlNode.END, "bottom", "setCompoundDrawablesWithIntrinsicBounds", TtmlNode.LEFT, TtmlNode.RIGHT, "setLineSpacing", "add", "", "mult", "setStrokeColor", "setTextAppearance", "setTextResId", OrmLiteConfigUtil.RESOURCE_DIR_NAME, "args", "(I[Ljava/lang/Object;)V", "setTextSize", "size", "unit", "setTextT", "s", "setTouchStrokeColor", "updateLineSpacing", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class SkinRoundTextView extends RoundTextView implements aj4, bh4 {

    @NotNull
    public final String b;

    @Nullable
    public bj4 c;

    @Nullable
    public si4 d;

    @Nullable
    public yi4 e;
    public int f;
    public boolean g;

    @Nullable
    public Object[] h;

    public SkinRoundTextView(@Nullable Context context) {
        this(context, null);
    }

    private final void setTextT(String s) {
        if (s != null) {
            String str = "flashText setTextT: " + s;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(s, Arrays.copyOf(new Object[]{30}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            setText(str2);
        }
    }

    @Override // dc.aj4
    public void P1() {
        si4 si4Var = this.d;
        if (si4Var != null) {
            si4Var.b();
        }
        bj4 bj4Var = this.c;
        if (bj4Var != null) {
            bj4Var.d();
        }
        b();
    }

    @Override // dc.bh4
    public void a() {
        Object[] objArr = this.h;
        if (objArr != null) {
            Intrinsics.checkNotNull(objArr);
            if (!(objArr.length == 0)) {
                bj4 bj4Var = this.c;
                if (bj4Var != null) {
                    bj4Var.o(0);
                }
                Object[] objArr2 = this.h;
                Intrinsics.checkNotNull(objArr2);
                int length = objArr2.length;
                Object[] objArr3 = new Object[length];
                Object[] objArr4 = this.h;
                Intrinsics.checkNotNull(objArr4);
                int length2 = objArr4.length;
                for (int i = 0; i < length2; i++) {
                    Object[] objArr5 = this.h;
                    Intrinsics.checkNotNull(objArr5);
                    if (objArr5[i] instanceof Integer) {
                        this.f = 0;
                        Object[] objArr6 = this.h;
                        Intrinsics.checkNotNull(objArr6);
                        Object obj = objArr6[i];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        objArr3[i] = ah4.e(((Integer) obj).intValue());
                    } else {
                        Object[] objArr7 = this.h;
                        Intrinsics.checkNotNull(objArr7);
                        objArr3[i] = objArr7[i];
                    }
                }
                if (this.f == 2131690030) {
                    String str = "flashText: " + ah4.e(this.f);
                    StringBuilder sb = new StringBuilder();
                    sb.append("flashText vluas: ");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String strE = ah4.e(this.f);
                    Intrinsics.checkNotNullExpressionValue(strE, "getString(key)");
                    Object[] objArrCopyOf = Arrays.copyOf(objArr3, length);
                    String str2 = String.format(strE, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    sb.append(str2);
                    sb.toString();
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String strE2 = ah4.e(this.f);
                Intrinsics.checkNotNullExpressionValue(strE2, "getString(key)");
                Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, length);
                String str3 = String.format(strE2, Arrays.copyOf(objArrCopyOf2, objArrCopyOf2.length));
                Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
                setText(str3);
                return;
            }
        }
        int i2 = this.f;
        if (i2 != 0) {
            if (i2 != 2131690030) {
                setText(ah4.e(i2));
                return;
            }
            String str4 = "flashText: " + ah4.e(this.f);
            String str5 = "flashText vluas: " + ah4.e(this.f);
            setTextT(ah4.e(this.f));
        }
    }

    public final void b() {
        yi4 yi4Var = this.e;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.c() != -1) {
                super.setStrokeColor(yi4Var.c());
            }
        }
    }

    public final void c() {
        yi4 yi4Var = this.e;
        if (yi4Var != null) {
            yi4Var.b();
            if (yi4Var.d() != -1) {
                super.setStrokeColor(yi4Var.d());
            }
        }
    }

    public final void d() {
        if (this.g) {
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
                c();
            } else if (numValueOf != null && numValueOf.intValue() == 1) {
                b();
            } else if (numValueOf != null && numValueOf.intValue() == 3) {
                b();
            }
        }
        return super.onTouchEvent(event);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void setBackgroundResource(int resId) {
        super.setBackgroundResource(resId);
        si4 si4Var = this.d;
        if (si4Var != null) {
            si4Var.d(resId);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int start, @DrawableRes int top, @DrawableRes int end, @DrawableRes int bottom) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        bj4 bj4Var = this.c;
        if (bj4Var != null) {
            bj4Var.l(start, top, end, bottom);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int left, @DrawableRes int top, @DrawableRes int right, @DrawableRes int bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        bj4 bj4Var = this.c;
        if (bj4Var != null) {
            bj4Var.m(left, top, right, bottom);
        }
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float add, float mult) {
        this.g = false;
        super.setLineSpacing(add, mult);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int resId) {
        setTextAppearance(getContext(), resId);
    }

    @Override // dc.bh4
    public void setTextResId(int res, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.h = new Object[]{args};
        this.f = vi4.a(res);
        bj4 bj4Var = this.c;
        if (bj4Var != null) {
            bj4Var.o(res);
        }
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        d();
    }

    public SkinRoundTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@Nullable Context context, int resId) {
        super.setTextAppearance(context, resId);
        bj4 bj4Var = this.c;
        if (bj4Var != null) {
            bj4Var.n(context, resId);
        }
        d();
    }

    public SkinRoundTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "SkinRoundTextView";
        si4 si4Var = new si4(this);
        this.d = si4Var;
        if (si4Var != null) {
            si4Var.c(attributeSet, i);
        }
        bj4 bj4VarH = bj4.h(this);
        this.c = bj4VarH;
        if (bj4VarH != null) {
            bj4VarH.k(attributeSet, i);
        }
        bj4 bj4Var = this.c;
        this.f = bj4Var != null ? bj4Var.j() : 0;
        ah4.c.add(new ch4(this));
        yi4 yi4Var = new yi4(this);
        this.e = yi4Var;
        if (yi4Var != null) {
            yi4Var.e(attributeSet, i);
        }
        b();
        setIncludeFontPadding(false);
        this.g = getLineSpacingExtra() == 0.0f;
        d();
    }

    @Override // android.widget.TextView
    public void setTextSize(float size) {
        super.setTextSize(size);
        d();
    }
}
