package com.wear.ui.chat.pancel.helper.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import dc.vi1;
import dc.vu2;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: PanelView.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB+\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\"\u0010\u0013\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/PanelView;", "Landroid/widget/FrameLayout;", "Lcom/wear/ui/chat/pancel/helper/view/pannel/IPanelView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isToggle", "", "panelLayoutId", "triggerViewId", "assertView", "", "getBindingTriggerViewId", "initView", "isShowing", "isTriggerViewCanToggle", "onFinishInflate", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelView extends FrameLayout implements vu2 {
    public int a;
    public int b;
    public boolean c;

    @JvmOverloads
    public PanelView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PanelView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PanelView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.c = true;
        c(attributeSet, i, 0);
    }

    @Override // dc.vu2
    /* renamed from: a, reason: from getter */
    public boolean getC() {
        return this.c;
    }

    public void b() {
        if (this.a == -1 || this.b == -1) {
            throw new RuntimeException("PanelView -- you must set 'panel_layout' and panel_trigger by Integer id");
        }
        if (getChildCount() > 0) {
            throw new RuntimeException("PanelView -- you can't have any child!");
        }
        LayoutInflater.from(getContext()).inflate(this.a, (ViewGroup) this, true);
    }

    public final void c(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vi1.PanelView, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…nelView, defStyleAttr, 0)");
        this.a = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.b = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.c = typedArrayObtainStyledAttributes.getBoolean(1, this.c);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // dc.vu2
    /* renamed from: getBindingTriggerViewId, reason: from getter */
    public int getB() {
        return this.b;
    }

    @Override // dc.vu2
    public boolean isShowing() {
        return isShown();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public /* synthetic */ PanelView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
