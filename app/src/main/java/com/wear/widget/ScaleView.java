package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import dc.bu2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScaleView.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/wear/widget/ScaleView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_commandValue", "backgroundPaint", "Landroid/graphics/Paint;", "backgroundRect", "Landroid/graphics/RectF;", "commandValue", "getCommandValue", "()I", "gradientPaint", "gradientRect", "paths", "", "Landroid/graphics/Path;", "radius", "", "getRadius", "()F", "radius$delegate", "Lkotlin/Lazy;", "scalePaint", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "updateCommandValue", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ScaleView extends View {

    @NotNull
    public final RectF a;

    @NotNull
    public final RectF b;

    @NotNull
    public final Paint c;

    @NotNull
    public final Paint d;

    @NotNull
    public final Paint e;

    @NotNull
    public final Lazy f;

    @NotNull
    public final List<Path> g;
    public int h;

    /* compiled from: ScaleView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Float> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(bu2.a(this.$context, 1.5f));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScaleView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScaleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ScaleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final float getRadius() {
        return ((Number) this.f.getValue()).floatValue();
    }

    public final void a(int i) {
        this.h = i;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        float fA = bu2.a(context, 218.0f);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        float fA2 = bu2.a(context2, 3.0f);
        float f = i == 0 ? 0.0f : i >= 20 ? fA : (i * fA) / 20.0f;
        this.c.setShader(new LinearGradient(0.0f, 0.0f, fA2, f, ContextCompat.getColor(getContext(), R.color.scale_start_color), ContextCompat.getColor(getContext(), R.color.scale_end_color), Shader.TileMode.CLAMP));
        this.a.set(0.0f, 0.0f, fA2, fA);
        this.b.set(0.0f, fA, fA2, fA - f);
        invalidate();
    }

    /* renamed from: getCommandValue, reason: from getter */
    public final int getH() {
        return this.h;
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawRoundRect(this.a, getRadius(), getRadius(), this.e);
        }
        if (canvas != null) {
            canvas.drawRoundRect(this.b, getRadius(), getRadius(), this.c);
        }
        for (int i = 0; i < 9; i++) {
            if (canvas != null) {
                canvas.drawPath(this.g.get(i), this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ScaleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new RectF();
        this.b = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.c = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(Color.parseColor("#000004"));
        this.d = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(Color.parseColor("#3C3C3F"));
        this.e = paint3;
        this.f = LazyKt__LazyJVMKt.lazy(new a(context));
        this.g = new ArrayList();
        float fA = bu2.a(context, 3.0f);
        float fA2 = bu2.a(context, 17.0f);
        float fA3 = bu2.a(context, 5.0f);
        int i2 = 0;
        while (i2 < 9) {
            float f = fA2 + fA3;
            float f2 = (i2 * f) + fA2;
            i2++;
            RectF rectF = new RectF(0.0f, f2, fA, i2 * f);
            Path path = new Path();
            path.addRect(rectF, Path.Direction.CW);
            Path path2 = new Path();
            float f3 = fA / 2.0f;
            path2.addCircle(f3, rectF.top, getRadius(), Path.Direction.CW);
            Path path3 = new Path();
            path3.addCircle(f3, rectF.bottom, getRadius(), Path.Direction.CW);
            path.op(path2, Path.Op.DIFFERENCE);
            path.op(path3, Path.Op.DIFFERENCE);
            this.g.add(path);
        }
    }
}
