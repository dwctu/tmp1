package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CurveView.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0002J\"\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\nH\u0002J\u0012\u0010-\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/wear/widget/CurveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_amplitude", "", "_frequency", "value", "amplitude", "getAmplitude", "()F", "setAmplitude", "(F)V", "frequency", "getFrequency", "setFrequency", "paintArray", "", "Landroid/graphics/Paint;", "getPaintArray", "()Ljava/util/List;", "paintArray$delegate", "Lkotlin/Lazy;", "path", "Landroid/graphics/Path;", "phaseShift", "getPhaseShift", "samplingX", "", "startTime", "", "calculateSinValue", "maxAmplitude", "normedAmplitude", "x", "drawSinLine", "", "canvas", "Landroid/graphics/Canvas;", FirebaseAnalytics.Param.INDEX, "onDraw", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CurveView extends View {
    public final long a;

    @Nullable
    public float[] b;

    @NotNull
    public final Path c;
    public float d;
    public float e;
    public final float f;

    @NotNull
    public final Lazy g;

    /* compiled from: CurveView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<List<Paint>> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<Paint> invoke() {
            ArrayList arrayList = new ArrayList();
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, CurveView.this.getHeight(), ContextCompat.getColor(this.$context, R.color.color_accent), ContextCompat.getColor(this.$context, R.color.color_accent_second), Shader.TileMode.CLAMP);
            for (int i = 0; i < 5; i++) {
                float fCoerceAtMost = RangesKt___RangesKt.coerceAtMost(1.0f, (((1.0f - ((i * 1.0f) / 5)) / 3.0f) * 2.0f) + 0.33333334f);
                if (i == 0) {
                    Paint paint = new Paint(1);
                    paint.setStrokeWidth(bu2.a(this.$context, 1.0f));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(ContextCompat.getColor(this.$context, R.color.color_accent_second));
                    paint.setShader(linearGradient);
                    arrayList.add(paint);
                } else {
                    Paint paint2 = new Paint(1);
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    double d = fCoerceAtMost * 1.0f;
                    double d2 = 255;
                    sb.append((int) (0.4d * d * d2));
                    sb.toString();
                    paint2.setColor(-1);
                    paint2.setAlpha((int) (d * 0.6d * d2));
                    paint2.setStrokeWidth(bu2.a(this.$context, 1.0f));
                    paint2.setStyle(Paint.Style.STROKE);
                    paint2.setShader(linearGradient);
                    arrayList.add(paint2);
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CurveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CurveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CurveView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final List<Paint> getPaintArray() {
        return (List) this.g.getValue();
    }

    public final float a(float f, float f2, float f3) {
        return (f * f2 * ((float) Math.sin(((((this.e * 2) * 3.141592653589793d) * f3) / getWidth()) - ((System.currentTimeMillis() - this.a) / 100.0f)))) + (getHeight() / 2);
    }

    public final void b(Canvas canvas, int i, float f) {
        if (this.b == null) {
            this.b = new float[128];
            float width = getWidth() / 128;
            for (int i2 = 0; i2 < 128; i2++) {
                float[] fArr = this.b;
                Intrinsics.checkNotNull(fArr);
                fArr[i2] = i2 * width;
            }
        }
        for (int i3 = 0; i3 < 128; i3++) {
            float[] fArr2 = this.b;
            Intrinsics.checkNotNull(fArr2);
            float fA = a((getHeight() / 2.0f) - 4.0f, f, fArr2[i3]);
            if (i3 == 0) {
                this.c.moveTo(0.0f, fA);
            } else {
                Path path = this.c;
                float[] fArr3 = this.b;
                Intrinsics.checkNotNull(fArr3);
                path.lineTo(fArr3[i3], fA);
            }
        }
        if (canvas != null) {
            canvas.drawPath(this.c, getPaintArray().get(i));
        }
    }

    /* renamed from: getAmplitude, reason: from getter */
    public final float getD() {
        return this.d;
    }

    /* renamed from: getFrequency, reason: from getter */
    public final float getE() {
        return this.e;
    }

    /* renamed from: getPhaseShift, reason: from getter */
    public final float getF() {
        return this.f;
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 5; i++) {
            this.c.reset();
            b(canvas, i, (((1.0f - (i / 5.0f)) * 1.5f) - 0.5f) * this.d);
        }
    }

    public final void setAmplitude(float f) {
        this.d = f;
    }

    public final void setFrequency(float f) {
        this.e = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CurveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = System.currentTimeMillis();
        this.c = new Path();
        this.e = 1.8f;
        this.f = -0.25f;
        this.g = LazyKt__LazyJVMKt.lazy(new a(context));
    }
}
