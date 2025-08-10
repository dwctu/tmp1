package com.wear.ui.chat.pancel.helper.view.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.ot2;
import dc.ru2;
import dc.su2;
import dc.tu2;
import dc.uu2;
import dc.vi1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: FrameContentContainer.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB+\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002JV\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0016J\b\u0010,\u001a\u00020\u0013H\u0014J\u0012\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010/\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\b2\u0006\u00100\u001a\u000201H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/content/FrameContentContainer;", "Landroid/widget/FrameLayout;", "Lcom/wear/ui/chat/pancel/helper/view/content/IContentContainer;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "autoResetByOnTouch", "", "autoResetId", "contentContainer", "Lcom/wear/ui/chat/pancel/helper/view/content/ContentContainerImpl;", "editTextId", "changeContainerHeight", "", "targetHeight", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "findTriggerView", "Landroid/view/View;", TtmlNode.ATTR_ID, "getInputActionImpl", "Lcom/wear/ui/chat/pancel/helper/view/content/IInputAction;", "getResetActionImpl", "Lcom/wear/ui/chat/pancel/helper/view/content/IResetAction;", "initView", "layoutContainer", "l", "t", StreamManagement.AckRequest.ELEMENT, "b", "contentScrollMeasurers", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurer;", "defaultScrollHeight", "canScrollOutsize", "reset", "changed", "onFinishInflate", "onTouchEvent", "event", "translationContainer", "contentTranslationY", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FrameContentContainer extends FrameLayout implements su2 {

    @IdRes
    public int a;

    @IdRes
    public int b;
    public boolean c;
    public ru2 d;

    @JvmOverloads
    public FrameContentContainer(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public FrameContentContainer(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrameContentContainer(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.c = true;
        e(attributeSet, i, 0);
    }

    @Override // dc.su2
    public void a(@NotNull List<ot2> contentScrollMeasurers, int i, float f) {
        Intrinsics.checkNotNullParameter(contentScrollMeasurers, "contentScrollMeasurers");
        ru2 ru2Var = this.d;
        if (ru2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            ru2Var = null;
        }
        ru2Var.a(contentScrollMeasurers, i, f);
    }

    @Override // dc.su2
    public void b(int i, int i2, int i3, int i4, @NotNull List<ot2> contentScrollMeasurers, int i5, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(contentScrollMeasurers, "contentScrollMeasurers");
        ru2 ru2Var = this.d;
        if (ru2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            ru2Var = null;
        }
        ru2Var.b(i, i2, i3, i4, contentScrollMeasurers, i5, z, z2, z3);
    }

    @Override // dc.su2
    @Nullable
    public View c(int i) {
        ru2 ru2Var = this.d;
        if (ru2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            ru2Var = null;
        }
        return ru2Var.c(i);
    }

    @Override // dc.su2
    public void d(int i) {
        ru2 ru2Var = this.d;
        if (ru2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            ru2Var = null;
        }
        ru2Var.d(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(ev);
        return getI().c(ev, zDispatchTouchEvent) | zDispatchTouchEvent;
    }

    public final void e(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vi1.FrameContentContainer, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ntainer, defStyleAttr, 0)");
        this.a = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.b = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.c = typedArrayObtainStyledAttributes.getBoolean(1, this.c);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // dc.su2
    @NotNull
    /* renamed from: getInputActionImpl */
    public tu2 getH() {
        ru2 ru2Var = this.d;
        if (ru2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            ru2Var = null;
        }
        return ru2Var.getH();
    }

    @Override // dc.su2
    @NotNull
    /* renamed from: getResetActionImpl */
    public uu2 getI() {
        ru2 ru2Var = this.d;
        if (ru2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            ru2Var = null;
        }
        return ru2Var.getI();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = new ru2(this, this.c, this.a, this.b);
        addView(getH().g(), 0, new FrameLayout.LayoutParams(1, 1));
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        return getI().a(event) | super.onTouchEvent(event);
    }

    public /* synthetic */ FrameContentContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
