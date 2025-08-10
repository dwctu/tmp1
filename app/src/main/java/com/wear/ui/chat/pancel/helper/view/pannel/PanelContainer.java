package com.wear.ui.chat.pancel.helper.view.pannel;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.vu2;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PanelContainer.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB+\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\bJ\"\u0010\u001a\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0014J0\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0014J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0016J.\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0'2\u0006\u0010\u0019\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0'R*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/pannel/PanelContainer;", "Landroid/widget/FrameLayout;", "Lcom/wear/ui/chat/pancel/helper/interfaces/ViewAssertion;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "<set-?>", "Landroid/util/SparseArray;", "Lcom/wear/ui/chat/pancel/helper/view/pannel/IPanelView;", "panelSparseArray", "getPanelSparseArray", "()Landroid/util/SparseArray;", "assertView", "", "changeContainerHeight", "targetHeight", "getPanelId", "panel", "getPanelView", "panelId", "initView", "onFinishInflate", "onLayout", "changed", "", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "setTranslationY", "translationY", "", "showPanel", "Landroid/util/Pair;", "size", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelContainer extends FrameLayout {

    @NotNull
    public SparseArray<vu2> a;

    @JvmOverloads
    public PanelContainer(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PanelContainer(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PanelContainer(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.a = new SparseArray<>();
        e(attributeSet, i, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        this.a = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            KeyEvent.Callback childAt = getChildAt(i);
            vu2 vu2Var = childAt instanceof vu2 ? (vu2) childAt : 0;
            if (vu2Var == 0) {
                throw new RuntimeException("PanelContainer -- PanelContainer's child should be IPanelView");
            }
            this.a.put(vu2Var.getBindingTriggerViewId(), vu2Var);
            ((View) vu2Var).setVisibility(8);
        }
    }

    public final void b(int i) {
        if (getLayoutParams() == null || getLayoutParams().height == i) {
            return;
        }
        getLayoutParams().height = i;
    }

    public final int c(@Nullable vu2 vu2Var) {
        if (vu2Var != null) {
            return vu2Var.getBindingTriggerViewId();
        }
        return 0;
    }

    @Nullable
    public final vu2 d(int i) {
        return this.a.get(i);
    }

    public final void e(AttributeSet attributeSet, int i, int i2) {
    }

    @NotNull
    public final Pair<Integer, Integer> f(int i, @NotNull Pair<Integer, Integer> size) {
        Intrinsics.checkNotNullParameter(size, "size");
        Object obj = (vu2) this.a.get(i);
        int size2 = this.a.size();
        for (int i2 = 0; i2 < size2; i2++) {
            SparseArray<vu2> sparseArray = this.a;
            Object obj2 = (vu2) sparseArray.get(sparseArray.keyAt(i2));
            if (obj2 instanceof View) {
                ((View) obj2).setVisibility(!Intrinsics.areEqual(obj2, obj) ? 8 : 0);
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        View view = (View) obj;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (!Intrinsics.areEqual(pair.first, size.first) || !Intrinsics.areEqual(pair.second, size.second)) {
            Object obj3 = size.first;
            Intrinsics.checkNotNullExpressionValue(obj3, "size.first");
            layoutParams.width = ((Number) obj3).intValue();
            Object obj4 = size.second;
            Intrinsics.checkNotNullExpressionValue(obj4, "size.second");
            layoutParams.height = ((Number) obj4).intValue();
            view.setLayoutParams(layoutParams);
        }
        return pair;
    }

    @NotNull
    public final SparseArray<vu2> getPanelSparseArray() {
        return this.a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
    }

    public /* synthetic */ PanelContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
