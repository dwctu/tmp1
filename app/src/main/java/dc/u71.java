package dc;

import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import dc.t71;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HighlightParameter.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00000B2\u0006\u0010C\u001a\u00020\u0000H\u0086\u0002J\u000e\u0010D\u001a\u00020E2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\u001a\u0010,\u001a\u00020-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR\u001a\u0010;\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\u001a\u0010>\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001f¨\u0006I"}, d2 = {"Lcom/hyy/highlightpro/parameter/HighlightParameter;", "", "()V", "constraints", "", "Lcom/hyy/highlightpro/parameter/Constraints;", "getConstraints$highlight_pro_release", "()Ljava/util/List;", "highLightView", "Landroid/view/View;", "getHighLightView$highlight_pro_release", "()Landroid/view/View;", "setHighLightView$highlight_pro_release", "(Landroid/view/View;)V", "highLightViewId", "", "getHighLightViewId$highlight_pro_release", "()I", "setHighLightViewId$highlight_pro_release", "(I)V", "highlightShape", "Lcom/hyy/highlightpro/shape/HighlightShape;", "getHighlightShape$highlight_pro_release", "()Lcom/hyy/highlightpro/shape/HighlightShape;", "setHighlightShape$highlight_pro_release", "(Lcom/hyy/highlightpro/shape/HighlightShape;)V", "horizontalPadding", "", "getHorizontalPadding$highlight_pro_release", "()F", "setHorizontalPadding$highlight_pro_release", "(F)V", "marginOffset", "Lcom/hyy/highlightpro/parameter/MarginOffset;", "getMarginOffset$highlight_pro_release", "()Lcom/hyy/highlightpro/parameter/MarginOffset;", "setMarginOffset$highlight_pro_release", "(Lcom/hyy/highlightpro/parameter/MarginOffset;)V", "offsetX", "getOffsetX$highlight_pro_release", "setOffsetX$highlight_pro_release", "offsetY", "getOffsetY$highlight_pro_release", "setOffsetY$highlight_pro_release", "rect", "Landroid/graphics/RectF;", "getRect$highlight_pro_release", "()Landroid/graphics/RectF;", "setRect$highlight_pro_release", "(Landroid/graphics/RectF;)V", "tipViewDisplayAnimation", "Landroid/view/animation/Animation;", "getTipViewDisplayAnimation$highlight_pro_release", "()Landroid/view/animation/Animation;", "setTipViewDisplayAnimation$highlight_pro_release", "(Landroid/view/animation/Animation;)V", "tipsView", "getTipsView$highlight_pro_release", "setTipsView$highlight_pro_release", "tipsViewId", "getTipsViewId$highlight_pro_release", "setTipsViewId$highlight_pro_release", "verticalPadding", "getVerticalPadding$highlight_pro_release", "setVerticalPadding$highlight_pro_release", "plus", "", "highlightParameter", "setHighLightView", "", "setHighLightViewId", "viewId", "Builder", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u71 {

    @Nullable
    public View b;

    @Nullable
    public View d;

    @Nullable
    public x71 e;
    public float g;
    public float h;
    public int j;
    public int k;

    @Nullable
    public Animation m;
    public int a = -1;
    public int c = -1;

    @NotNull
    public RectF f = new RectF();

    @NotNull
    public v71 i = new v71(0, 0, 0, 0, 15, null);

    @NotNull
    public final List<t71> l = CollectionsKt__CollectionsKt.mutableListOf(t71.i.a, t71.h.a);

    /* compiled from: HighlightParameter.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/hyy/highlightpro/parameter/HighlightParameter$Builder;", "", "()V", "highlightParameter", "Lcom/hyy/highlightpro/parameter/HighlightParameter;", "build", "offsetX", "", "offsetY", "setConstraints", "constraints", "", "Lcom/hyy/highlightpro/parameter/Constraints;", "setHighlightHorizontalPadding", "padding", "", "setHighlightShape", "highlightShape", "Lcom/hyy/highlightpro/shape/HighlightShape;", "setHighlightVerticalPadding", "setHighlightView", "highLightView", "Landroid/view/View;", "setHighlightViewId", "viewId", "setMarginOffset", "marginOffset", "Lcom/hyy/highlightpro/parameter/MarginOffset;", "setTipViewDisplayAnimation", "tipViewDisplayAnimation", "Landroid/view/animation/Animation;", "setTipsView", "tipsView", "setTipsViewId", "highlight_pro_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        @NotNull
        public final u71 a = new u71();

        @NotNull
        /* renamed from: a, reason: from getter */
        public final u71 getA() {
            return this.a;
        }

        @NotNull
        public final a b(@NotNull List<? extends t71> constraints) {
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            this.a.a().clear();
            this.a.a().addAll(constraints);
            return this;
        }

        @NotNull
        public final a c(@NotNull x71 highlightShape) {
            Intrinsics.checkNotNullParameter(highlightShape, "highlightShape");
            this.a.p(highlightShape);
            return this;
        }

        @NotNull
        public final a d(int i) {
            this.a.o(i);
            return this;
        }

        @NotNull
        public final a e(@NotNull v71 marginOffset) {
            Intrinsics.checkNotNullParameter(marginOffset, "marginOffset");
            this.a.q(marginOffset);
            return this;
        }

        @NotNull
        public final a f(@NotNull View tipsView) {
            Intrinsics.checkNotNullParameter(tipsView, "tipsView");
            this.a.s(tipsView);
            return this;
        }
    }

    @NotNull
    public final List<t71> a() {
        return this.l;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final View getB() {
        return this.b;
    }

    /* renamed from: c, reason: from getter */
    public final int getA() {
        return this.a;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final x71 getE() {
        return this.e;
    }

    /* renamed from: e, reason: from getter */
    public final float getG() {
        return this.g;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final v71 getI() {
        return this.i;
    }

    /* renamed from: g, reason: from getter */
    public final int getJ() {
        return this.j;
    }

    /* renamed from: h, reason: from getter */
    public final int getK() {
        return this.k;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final RectF getF() {
        return this.f;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final Animation getM() {
        return this.m;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final View getD() {
        return this.d;
    }

    /* renamed from: l, reason: from getter */
    public final int getC() {
        return this.c;
    }

    /* renamed from: m, reason: from getter */
    public final float getH() {
        return this.h;
    }

    public final void n(@Nullable View view) {
        this.b = view;
    }

    public final void o(int i) {
        this.a = i;
    }

    public final void p(@Nullable x71 x71Var) {
        this.e = x71Var;
    }

    public final void q(@NotNull v71 v71Var) {
        Intrinsics.checkNotNullParameter(v71Var, "<set-?>");
        this.i = v71Var;
    }

    public final void r(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.f = rectF;
    }

    public final void s(@Nullable View view) {
        this.d = view;
    }
}
