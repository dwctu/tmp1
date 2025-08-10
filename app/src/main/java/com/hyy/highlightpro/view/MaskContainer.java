package com.hyy.highlightpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewGroupKt;
import dc.t71;
import dc.u71;
import dc.v71;
import dc.x71;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskContainer.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020\tH\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\tH\u0014J\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+H\u0014J\u001a\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH\u0014J\u0010\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0014\u00105\u001a\u00020\t2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001907J\u0014\u00108\u001a\u00020\t2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u000bJ\u000e\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000bR\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/hyy/highlightpro/view/MaskContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backPressedCallback", "Lkotlin/Function0;", "", "bgColor", "", "defaultBgColor", "getDefaultBgColor", "()I", "defaultHighlightBgColor", "getDefaultHighlightBgColor", "enableHighlight", "", "getEnableHighlight$highlight_pro_release", "()Z", "setEnableHighlight$highlight_pro_release", "(Z)V", "highLightViewParameters", "", "Lcom/hyy/highlightpro/parameter/HighlightParameter;", "interceptBackPressed", "getInterceptBackPressed$highlight_pro_release", "setInterceptBackPressed$highlight_pro_release", "needAnchorTipView", "getNeedAnchorTipView$highlight_pro_release", "setNeedAnchorTipView$highlight_pro_release", "rootHeight", "rootWidth", "addTipsView", "calculateTipsViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "view", "Landroid/view/View;", "parameter", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBackgroundColor", "color", "setHighLightParameters", "list", "", "setOnBackPressedCallback", "block", "setRootHeight", VideoCaptureFormat.keyHeight, "setRootWidth", VideoCaptureFormat.keyWidth, "Companion", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMaskContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MaskContainer.kt\ncom/hyy/highlightpro/view/MaskContainer\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,268:1\n470#2:269\n470#2:270\n1855#3,2:271\n1855#3,2:273\n1855#3:277\n1856#3:279\n1855#3,2:280\n1855#3:282\n1856#3:285\n1864#3,3:286\n1295#4,2:275\n84#5:278\n84#5:283\n84#5:284\n*S KotlinDebug\n*F\n+ 1 MaskContainer.kt\ncom/hyy/highlightpro/view/MaskContainer\n*L\n35#1:269\n38#1:270\n59#1:271,2\n70#1:273,2\n117#1:277\n117#1:279\n130#1:280,2\n161#1:282\n161#1:285\n248#1:286,3\n102#1:275,2\n124#1:278\n217#1:283\n235#1:284\n*E\n"})
/* loaded from: classes3.dex */
public final class MaskContainer extends FrameLayout {
    public int a;
    public int b;
    public int c;

    @NotNull
    public final List<u71> d;

    @Nullable
    public Function0<Unit> e;
    public boolean f;
    public boolean g;
    public boolean h;

    /* compiled from: View.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n+ 2 MaskContainer.kt\ncom/hyy/highlightpro/view/MaskContainer\n*L\n1#1,432:1\n126#2:433\n*E\n"})
    public static final class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* compiled from: View.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n+ 2 MaskContainer.kt\ncom/hyy/highlightpro/view/MaskContainer\n*L\n1#1,432:1\n218#2,4:433\n*E\n"})
    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ RectF c;
        public final /* synthetic */ View d;

        public b(View view, Ref.ObjectRef objectRef, RectF rectF, View view2) {
            this.a = view;
            this.b = objectRef;
            this.c = rectF;
            this.d = view2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            View view = this.a;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.element;
            RectF rectF = this.c;
            layoutParams.leftMargin = (int) ((rectF.left + (rectF.width() / 2.0f)) - (view.getWidth() / 2.0f));
            this.d.setLayoutParams((ViewGroup.LayoutParams) this.b.element);
        }
    }

    /* compiled from: View.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n+ 2 MaskContainer.kt\ncom/hyy/highlightpro/view/MaskContainer\n*L\n1#1,432:1\n236#2,4:433\n*E\n"})
    public static final class c implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ RectF c;
        public final /* synthetic */ View d;

        public c(View view, Ref.ObjectRef objectRef, RectF rectF, View view2) {
            this.a = view;
            this.b = objectRef;
            this.c = rectF;
            this.d = view2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            View view = this.a;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.element;
            RectF rectF = this.c;
            layoutParams.topMargin = (int) ((rectF.top + (rectF.height() / 2.0f)) - (view.getHeight() / 2.0f));
            this.d.setLayoutParams((ViewGroup.LayoutParams) this.b.element);
        }
    }

    public /* synthetic */ MaskContainer(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final int getDefaultBgColor() {
        return Color.parseColor("#00000000");
    }

    private final int getDefaultHighlightBgColor() {
        return Color.parseColor("#80000000");
    }

    public final void a() {
        if (this.h) {
            for (u71 u71Var : this.d) {
                View d = u71Var.getD();
                if (d != null) {
                    FrameLayout.LayoutParams layoutParamsB = b(d, u71Var);
                    if (u71Var.getM() != null) {
                        d.startAnimation(u71Var.getM());
                    }
                    addView(d, layoutParamsB);
                    View d2 = u71Var.getD();
                    if (d2 != null) {
                        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(d2, new a(d2)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
                    }
                }
            }
            return;
        }
        for (u71 u71Var2 : this.d) {
            View d3 = u71Var2.getD();
            if (d3 != null) {
                ViewGroup.LayoutParams layoutParams = d3.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                } else {
                    Intrinsics.checkNotNullExpressionValue(layoutParams, "this.layoutParams ?: Lay…ENT\n                    )");
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = u71Var2.getK();
                layoutParams2.leftMargin = u71Var2.getJ();
                if (u71Var2.getM() != null) {
                    d3.startAnimation(u71Var2.getM());
                }
                addView(d3, layoutParams2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.widget.FrameLayout$LayoutParams] */
    public final FrameLayout.LayoutParams b(View view, u71 u71Var) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        objectRef.element = (FrameLayout.LayoutParams) layoutParams;
        System.out.println((Object) ("MaskContainer calculateTipsViewLayoutParams tipsView layoutParams--> " + objectRef.element));
        v71 i = u71Var.getI();
        RectF f = u71Var.getF();
        ArrayList arrayList = new ArrayList();
        for (t71 t71Var : u71Var.a()) {
            if (Intrinsics.areEqual(t71Var, t71.h.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).leftMargin = (int) (f.left + i.getA());
                arrayList.add(Integer.valueOf(GravityCompat.START));
            } else if (Intrinsics.areEqual(t71Var, t71.f.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).rightMargin = (int) ((this.a - f.right) + f.width() + i.getC());
                arrayList.add(Integer.valueOf(GravityCompat.END));
            } else if (Intrinsics.areEqual(t71Var, t71.g.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).leftMargin = (int) (f.right + i.getA());
                arrayList.add(Integer.valueOf(GravityCompat.START));
            } else if (Intrinsics.areEqual(t71Var, t71.e.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).rightMargin = (int) ((this.a - f.right) + i.getC());
                arrayList.add(Integer.valueOf(GravityCompat.END));
            } else if (Intrinsics.areEqual(t71Var, t71.j.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).topMargin = (int) (f.top + i.getB());
                arrayList.add(48);
            } else if (Intrinsics.areEqual(t71Var, t71.a.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).bottomMargin = (int) ((this.b - f.bottom) + i.getD());
                arrayList.add(80);
            } else if (Intrinsics.areEqual(t71Var, t71.b.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).bottomMargin = (int) ((this.b - f.bottom) + f.height() + i.getD());
                arrayList.add(80);
            } else if (Intrinsics.areEqual(t71Var, t71.i.a)) {
                ((FrameLayout.LayoutParams) objectRef.element).topMargin = (int) (f.bottom + i.getB());
                arrayList.add(48);
            } else if (Intrinsics.areEqual(t71Var, t71.c.a)) {
                T t = objectRef.element;
                int i2 = ((FrameLayout.LayoutParams) t).width;
                if (i2 <= 0) {
                    ((FrameLayout.LayoutParams) t).leftMargin = (int) (f.left + (f.width() / 2.0f));
                    arrayList.add(Integer.valueOf(GravityCompat.START));
                    Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(view, new b(view, objectRef, f, view)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
                } else {
                    ((FrameLayout.LayoutParams) t).leftMargin = (int) ((f.left + (f.width() / 2.0f)) - (i2 / 2.0f));
                    arrayList.add(Integer.valueOf(GravityCompat.START));
                }
            } else if (Intrinsics.areEqual(t71Var, t71.d.a)) {
                T t2 = objectRef.element;
                int i3 = ((FrameLayout.LayoutParams) t2).height;
                if (i3 <= 0) {
                    ((FrameLayout.LayoutParams) t2).topMargin = (int) (f.top + (f.height() / 2.0f));
                    arrayList.add(48);
                    Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(view, new c(view, objectRef, f, view)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
                } else {
                    ((FrameLayout.LayoutParams) t2).topMargin = (int) ((f.top + (f.height() / 2.0f)) - (i3 / 2.0f));
                    arrayList.add(48);
                }
            }
        }
        int i4 = 0;
        for (Object obj : arrayList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int iIntValue = ((Number) obj).intValue();
            if (i4 == 0) {
                ((FrameLayout.LayoutParams) objectRef.element).gravity = iIntValue;
            } else {
                ((FrameLayout.LayoutParams) objectRef.element).gravity |= iIntValue;
            }
            i4 = i5;
        }
        return (FrameLayout.LayoutParams) objectRef.element;
    }

    /* renamed from: getEnableHighlight$highlight_pro_release, reason: from getter */
    public final boolean getF() {
        return this.f;
    }

    /* renamed from: getInterceptBackPressed$highlight_pro_release, reason: from getter */
    public final boolean getG() {
        return this.g;
    }

    /* renamed from: getNeedAnchorTipView$highlight_pro_release, reason: from getter */
    public final boolean getH() {
        return this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.clear();
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.f) {
            if (this.c == -1) {
                this.c = getDefaultBgColor();
            }
            canvas.drawColor(this.c);
            return;
        }
        canvas.save();
        Iterator<T> it = this.d.iterator();
        while (it.hasNext()) {
            x71 e = ((u71) it.next()).getE();
            if (e != null) {
                canvas.clipPath(e.b(), Region.Op.DIFFERENCE);
            }
        }
        if (this.c == -1) {
            this.c = getDefaultHighlightBgColor();
        }
        canvas.drawColor(this.c);
        Iterator<T> it2 = this.d.iterator();
        while (it2.hasNext()) {
            x71 e2 = ((u71) it2.next()).getE();
            if (e2 != null) {
                e2.a(canvas);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        Function0<Unit> function0 = this.e;
        if (function0 != null) {
            function0.invoke();
        }
        return this.g;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        this.c = color;
    }

    public final void setEnableHighlight$highlight_pro_release(boolean z) {
        this.f = z;
    }

    public final void setHighLightParameters(@NotNull List<u71> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (it.hasNext()) {
            it.next().clearAnimation();
        }
        removeAllViews();
        this.d.clear();
        this.d.addAll(list);
        a();
    }

    public final void setInterceptBackPressed$highlight_pro_release(boolean z) {
        this.g = z;
    }

    public final void setNeedAnchorTipView$highlight_pro_release(boolean z) {
        this.h = z;
    }

    public final void setOnBackPressedCallback(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.e = block;
    }

    public final void setRootHeight(int height) {
        this.b = height;
    }

    public final void setRootWidth(int width) {
        this.a = width;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = -1;
        this.d = new ArrayList();
        this.f = true;
        this.h = true;
        setWillNotDraw(false);
    }
}
