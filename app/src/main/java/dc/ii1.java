package dc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScaleTypeUtil.kt */
/* loaded from: classes3.dex */
public final class ii1 {
    public static final /* synthetic */ KProperty[] j = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ii1.class), "scaleTypeFitXY", "getScaleTypeFitXY()Lcom/tencent/qgame/animplayer/util/ScaleTypeFitXY;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ii1.class), "scaleTypeFitCenter", "getScaleTypeFitCenter()Lcom/tencent/qgame/animplayer/util/ScaleTypeFitCenter;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ii1.class), "scaleTypeCenterCrop", "getScaleTypeCenterCrop()Lcom/tencent/qgame/animplayer/util/ScaleTypeCenterCrop;"))};
    public int d;
    public int e;
    public int f;
    public int g;

    @Nullable
    public bi1 i;
    public final Lazy a = LazyKt__LazyJVMKt.lazy(c.a);
    public final Lazy b = LazyKt__LazyJVMKt.lazy(b.a);
    public final Lazy c = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public di1 h = di1.FIT_XY;

    /* compiled from: ScaleTypeUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ldc/ei1;", "a", "()Ldc/ei1;"}, k = 3, mv = {1, 4, 0})
    public static final class a extends Lambda implements Function0<ei1> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ei1 invoke() {
            return new ei1();
        }
    }

    /* compiled from: ScaleTypeUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ldc/fi1;", "a", "()Ldc/fi1;"}, k = 3, mv = {1, 4, 0})
    public static final class b extends Lambda implements Function0<fi1> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final fi1 invoke() {
            return new fi1();
        }
    }

    /* compiled from: ScaleTypeUtil.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ldc/gi1;", "a", "()Ldc/gi1;"}, k = 3, mv = {1, 4, 0})
    public static final class c extends Lambda implements Function0<gi1> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final gi1 invoke() {
            return new gi1();
        }
    }

    public final boolean a() {
        return this.d > 0 && this.e > 0 && this.f > 0 && this.g > 0;
    }

    public final bi1 b() {
        bi1 bi1Var = this.i;
        if (bi1Var != null) {
            xh1.c.d("AnimPlayer.ScaleTypeUtil", "custom scaleType");
            return bi1Var;
        }
        xh1.c.d("AnimPlayer.ScaleTypeUtil", "scaleType=" + this.h);
        int i = hi1.a[this.h.ordinal()];
        if (i == 1) {
            return g();
        }
        if (i == 2) {
            return f();
        }
        if (i == 3) {
            return e();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final FrameLayout.LayoutParams c(@Nullable View view) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) (layoutParams instanceof FrameLayout.LayoutParams ? layoutParams : null);
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        }
        FrameLayout.LayoutParams layoutParams3 = layoutParams2;
        if (a()) {
            return b().a(this.d, this.e, this.f, this.g, layoutParams3);
        }
        xh1.c.b("AnimPlayer.ScaleTypeUtil", "params error: layoutWidth=" + this.d + ", layoutHeight=" + this.e + ", videoWidth=" + this.f + ", videoHeight=" + this.g);
        return layoutParams3;
    }

    @NotNull
    public final Pair<Integer, Integer> d() {
        Pair<Integer, Integer> realSize = b().getRealSize();
        xh1.c.d("AnimPlayer.ScaleTypeUtil", "get real size (" + realSize.getFirst().intValue() + ", " + realSize.getSecond().intValue() + ')');
        return realSize;
    }

    public final ei1 e() {
        Lazy lazy = this.c;
        KProperty kProperty = j[2];
        return (ei1) lazy.getValue();
    }

    public final fi1 f() {
        Lazy lazy = this.b;
        KProperty kProperty = j[1];
        return (fi1) lazy.getValue();
    }

    public final gi1 g() {
        Lazy lazy = this.a;
        KProperty kProperty = j[0];
        return (gi1) lazy.getValue();
    }

    public final void h(@NotNull di1 di1Var) {
        Intrinsics.checkParameterIsNotNull(di1Var, "<set-?>");
        this.h = di1Var;
    }

    public final void i(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public final void j(@Nullable bi1 bi1Var) {
        this.i = bi1Var;
    }

    public final void k(int i, int i2) {
        this.f = i;
        this.g = i2;
    }
}
