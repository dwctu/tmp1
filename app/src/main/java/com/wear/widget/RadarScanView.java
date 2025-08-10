package com.wear.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.lovense.wear.R;
import com.wear.bean.data.PointData;
import dc.qu1;
import dc.th4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
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
import skin.support.widget.SkinCompatView;

/* compiled from: RadarScanView.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 U2\u00020\u0001:\u0001UB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00108\u001a\u000209H\u0016J\u0018\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u0015H\u0002J\u0018\u0010=\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u0015H\u0002J\u0018\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0002J*\u0010A\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0015H\u0002J\"\u0010G\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u0015H\u0002J*\u0010H\u001a\u0002092\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010I\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J(\u0010J\u001a\u0002092\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0007H\u0002J\b\u0010K\u001a\u000209H\u0002J\b\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u00020\u0007H\u0002J\u0012\u0010N\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\u0018\u0010O\u001a\u0002092\u0006\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0014J\b\u0010R\u001a\u000209H\u0002J\u0006\u0010S\u001a\u000209J\u0006\u0010T\u001a\u000209R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0017\u0010\u000fR\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001d\u0010\u000fR\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b!\u0010\u000fR\u001b\u0010#\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b$\u0010\u000fR\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00102\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b3\u0010\u000fR\u001b\u00105\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b6\u0010\u000f¨\u0006V"}, d2 = {"Lcom/wear/widget/RadarScanView;", "Lskin/support/widget/SkinCompatView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bitmap", "Landroid/graphics/Bitmap;", "bitmapPaint", "Landroid/graphics/Paint;", "bluePaint", "getBluePaint", "()Landroid/graphics/Paint;", "bluePaint$delegate", "Lkotlin/Lazy;", "bluePath", "Landroid/graphics/Path;", "innerAlpha", "", "innerPaint", "getInnerPaint", "innerPaint$delegate", "innerRadius", "mDegrees", "mostAlpha", "mostPaint", "getMostPaint", "mostPaint$delegate", "mostRadius", "paint", "getPaint", "paint$delegate", "pathPaint", "getPathPaint", "pathPaint$delegate", "pointList", "Ljava/util/ArrayList;", "Lcom/wear/bean/data/PointData;", "Lkotlin/collections/ArrayList;", "pointPaint", "redPath", "samplingX", "", "scaleAlpha", "scaleRadius", "startTime", "", "sweepPaint", "getSweepPaint", "sweepPaint$delegate", "whitePaint", "getWhitePaint", "whitePaint$delegate", "applySkin", "", "calculateCosValue", "x", TypedValues.CycleType.S_WAVE_OFFSET, "calculateSinValue", "changeAlpha", "color", "alpha", "drawRadarScan", "canvas", "Landroid/graphics/Canvas;", "cx", "cy", "radius", "drawRaindrop", "drawSinLine", "drawStatusIcon", "drawSweep", "generatePoint", "generateRandomColor", "generateRandomDegrees", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removePoint", "scanRestore", "scanSuccess", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RadarScanView extends SkinCompatView {
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public final long i;

    @Nullable
    public float[] j;

    @NotNull
    public final ArrayList<PointData> k;

    @NotNull
    public final Lazy l;

    @NotNull
    public final Lazy m;

    @NotNull
    public final Lazy n;

    @NotNull
    public final Lazy o;

    @NotNull
    public final Lazy p;

    @NotNull
    public final Lazy q;

    @NotNull
    public final Lazy r;

    @NotNull
    public final Paint s;

    @NotNull
    public final Path t;

    @NotNull
    public final Path u;

    @NotNull
    public Bitmap v;

    @NotNull
    public final Paint w;

    /* compiled from: RadarScanView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Paint> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            Context context = this.$context;
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6.0f);
            paint.setColor(ContextCompat.getColor(context, R.color.color_accent_second));
            return paint;
        }
    }

    /* compiled from: RadarScanView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Paint> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            Context context = this.$context;
            paint.setAntiAlias(true);
            paint.setColor(ContextCompat.getColor(context, R.color.cicrle_color));
            paint.setAlpha(77);
            return paint;
        }
    }

    /* compiled from: RadarScanView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Paint> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            Context context = this.$context;
            paint.setAntiAlias(true);
            paint.setColor(ContextCompat.getColor(context, R.color.cicrle_color));
            paint.setAlpha(77);
            return paint;
        }
    }

    /* compiled from: RadarScanView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Paint> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            Context context = this.$context;
            paint.setAntiAlias(true);
            paint.setColor(ContextCompat.getColor(context, R.color.cicrle_color));
            paint.setAlpha(77);
            return paint;
        }
    }

    /* compiled from: RadarScanView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<Paint> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            Context context = this.$context;
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6.0f);
            paint.setColor(ContextCompat.getColor(context, R.color.cicrle_color));
            return paint;
        }
    }

    /* compiled from: RadarScanView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<Paint> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            return paint;
        }
    }

    /* compiled from: RadarScanView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<Paint> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            return paint;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RadarScanView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RadarScanView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RadarScanView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final Paint getBluePaint() {
        return (Paint) this.m.getValue();
    }

    private final Paint getInnerPaint() {
        return (Paint) this.o.getValue();
    }

    private final Paint getMostPaint() {
        return (Paint) this.p.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.n.getValue();
    }

    private final Paint getPathPaint() {
        return (Paint) this.l.getValue();
    }

    private final Paint getSweepPaint() {
        return (Paint) this.r.getValue();
    }

    private final Paint getWhitePaint() {
        return (Paint) this.q.getValue();
    }

    @Override // skin.support.widget.SkinCompatView, dc.aj4
    public void P1() {
        super.P1();
        if (th4.e().p()) {
            getWhitePaint().setColor(-1);
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_search_back);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(resources…rawable.icon_search_back)");
            this.v = bitmapDecodeResource;
            return;
        }
        getWhitePaint().setColor(th4.b(getContext(), R.color.bg));
        Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_search_back_white);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource2, "decodeResource(resources…e.icon_search_back_white)");
        this.v = bitmapDecodeResource2;
    }

    public final float a(float f2, float f3) {
        return (((float) Math.cos(((f2 * 12.566370614359172d) / getWidth()) - f3)) * 60) + (getHeight() / 2) + 30;
    }

    public final float b(float f2, float f3) {
        return (((float) Math.sin(((f2 * 12.566370614359172d) / getWidth()) - f3)) * 60) + (getHeight() / 2) + 30;
    }

    public final int c(int i, int i2) {
        return Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i));
    }

    public final void d(Canvas canvas, float f2, float f3, float f4) {
        float f5 = 3;
        float f6 = 67.0f / ((0.77f * f4) / f5);
        if (canvas != null) {
            canvas.drawCircle(f2, f3, this.b, getPaint());
        }
        float f7 = this.b;
        if (f7 > f4) {
            this.b = f4 * 0.23f;
            this.c = 77.0f;
        } else {
            this.b = f7 + f5;
            this.c -= f6;
        }
        getPaint().setAlpha(Math.abs((int) this.c));
        if (canvas != null) {
            canvas.drawCircle(f2, f3, this.d, getInnerPaint());
        }
        float f8 = this.d;
        if (f8 > f4) {
            this.d = f4 * 0.23f;
            this.e = 77.0f;
        } else {
            this.d = f8 + f5;
            this.e -= f6;
        }
        getInnerPaint().setAlpha(Math.abs((int) this.e));
        if (canvas != null) {
            canvas.drawCircle(f2, f3, this.f, getMostPaint());
        }
        float f9 = this.f;
        if (f9 > f4) {
            this.f = 0.23f * f4;
            this.g = 77.0f;
        } else {
            this.f = f9 + f5;
            this.g -= f6;
        }
        getMostPaint().setAlpha(Math.abs((int) this.g));
        e(canvas, f2, f3);
        if (canvas != null) {
            h(canvas, f2, f3, (int) f4);
        }
        this.h = (this.h + 2) % 360;
    }

    public final void e(Canvas canvas, float f2, float f3) {
        i();
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            PointData pointData = (PointData) it.next();
            this.s.setColor(pointData.getColor());
            this.s.setAlpha((int) pointData.getAlpha());
            float f4 = 2;
            float width = 200 / (((getWidth() / 2) - pointData.getDefaultPath()) / f4);
            double d2 = 180;
            double radiusPath = f2 + (pointData.getRadiusPath() * Math.cos((pointData.getDegrees() * 3.141592653589793d) / d2));
            Iterator it2 = it;
            double radiusPath2 = f3 + (pointData.getRadiusPath() * Math.sin((pointData.getDegrees() * 3.141592653589793d) / d2));
            if (canvas != null) {
                canvas.drawCircle((float) radiusPath, (float) radiusPath2, pointData.getRadius(), this.s);
            }
            pointData.setRadiusPath(pointData.getRadiusPath() + f4);
            pointData.setAlpha(pointData.getAlpha() - width);
            it = it2;
        }
        l();
    }

    public final void f(float f2, float f3, float f4, Canvas canvas) {
        this.t.reset();
        this.u.reset();
        this.t.addCircle(f2, f3, f4 * 0.23f, Path.Direction.CW);
        if (canvas != null) {
            canvas.clipPath(this.t);
        }
        this.t.reset();
        if (this.j == null) {
            this.j = new float[128];
            float width = getWidth() / 128;
            for (int i = 0; i < 128; i++) {
                float[] fArr = this.j;
                Intrinsics.checkNotNull(fArr);
                fArr[i] = i * width;
            }
        }
        for (int i2 = 0; i2 < 128; i2++) {
            float[] fArr2 = this.j;
            Intrinsics.checkNotNull(fArr2);
            float fB = b(fArr2[i2], (System.currentTimeMillis() - this.i) / 300.0f);
            if (i2 == 0) {
                this.t.moveTo(0.0f, fB);
            }
            if (fB <= getHeight()) {
                Path path = this.t;
                float[] fArr3 = this.j;
                Intrinsics.checkNotNull(fArr3);
                path.lineTo(fArr3[i2], fB);
            }
            float[] fArr4 = this.j;
            Intrinsics.checkNotNull(fArr4);
            float fA = a(fArr4[i2], (System.currentTimeMillis() - this.i) / 300.0f);
            if (i2 == 0) {
                this.u.moveTo(0.0f, fA);
            }
            if (fA <= getHeight()) {
                Path path2 = this.u;
                float[] fArr5 = this.j;
                Intrinsics.checkNotNull(fArr5);
                path2.lineTo(fArr5[i2], fA);
            }
        }
        if (canvas != null) {
            canvas.drawPath(this.t, getPathPaint());
        }
        if (canvas != null) {
            canvas.drawPath(this.u, getBluePaint());
        }
    }

    public final void g(Canvas canvas) {
        float width = (getWidth() - this.v.getWidth()) / 2.0f;
        float height = (getHeight() - this.v.getHeight()) / 2.0f;
        if (canvas != null) {
            canvas.drawBitmap(this.v, width, height, this.w);
        }
    }

    public final void h(Canvas canvas, float f2, float f3, int i) {
        int color = ContextCompat.getColor(getContext(), R.color.cicrle_color);
        getSweepPaint().setShader(new SweepGradient(f2, f3, new int[]{0, c(color, 0), c(color, 13), c(color, 26)}, new float[]{0.0f, 0.6f, 0.8f, 1.0f}));
        canvas.rotate(this.h, f2, f3);
        canvas.drawCircle(f2, f3, i, getSweepPaint());
    }

    public final void i() {
        if (this.k.size() < 10) {
            int iK = k();
            float fNextInt = r0.nextInt(getWidth() / 2) * 0.23f;
            float width = getWidth() / 2.0f;
            this.k.add(new PointData(fNextInt, fNextInt, new Random().nextInt(20) + 10, iK, (200.0f / width) * (width - fNextInt), j()));
        }
    }

    public final int j() {
        Random random = new Random();
        return Color.rgb(random.nextInt(TsExtractor.TS_STREAM_TYPE_AC3) + 126, random.nextInt(38) + 88, random.nextInt(94) + 161);
    }

    public final int k() {
        return new Random().nextInt(360) - 180;
    }

    public final void l() {
        Iterator<PointData> it = this.k.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "pointList.iterator()");
        while (it.hasNext()) {
            PointData next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            PointData pointData = next;
            if (pointData.getRadiusPath() > getWidth() / 2 || pointData.getAlpha() < 0.0f) {
                it.remove();
            }
        }
    }

    public final void m() {
        Bitmap bitmapDecodeResource;
        if (th4.e().p()) {
            bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_search_back);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "{\n            BitmapFact…on_search_back)\n        }");
        } else {
            bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_search_back_white);
            Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "{\n            BitmapFact…rch_back_white)\n        }");
        }
        this.v = bitmapDecodeResource;
    }

    public final void n() {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.matcher_success);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(resources…drawable.matcher_success)");
        this.v = bitmapDecodeResource;
    }

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float width2 = getWidth() / 2.0f;
        d(canvas, width, height, width2);
        if (canvas != null) {
            canvas.rotate(-this.h, width, height);
        }
        if (canvas != null) {
            canvas.drawCircle(width, height, 0.23f * width2, getWhitePaint());
        }
        f(width, height, width2, canvas);
        g(canvas);
        postInvalidateDelayed(8L);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iCoerceAtMost = RangesKt___RangesKt.coerceAtMost(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(iCoerceAtMost, iCoerceAtMost);
        float f2 = iCoerceAtMost * 0.5f;
        this.b = f2;
        this.d = f2 - qu1.a(50);
        this.f = f2 - qu1.a(100);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RadarScanView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = 10.0f;
        this.e = 25.0f;
        this.g = 51.0f;
        this.i = System.currentTimeMillis();
        this.k = new ArrayList<>();
        this.l = LazyKt__LazyJVMKt.lazy(new e(context));
        this.m = LazyKt__LazyJVMKt.lazy(new a(context));
        this.n = LazyKt__LazyJVMKt.lazy(new d(context));
        this.o = LazyKt__LazyJVMKt.lazy(new b(context));
        this.p = LazyKt__LazyJVMKt.lazy(new c(context));
        this.q = LazyKt__LazyJVMKt.lazy(g.a);
        this.r = LazyKt__LazyJVMKt.lazy(f.a);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.s = paint;
        this.t = new Path();
        this.u = new Path();
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_search_back);
        Intrinsics.checkNotNullExpressionValue(bitmapDecodeResource, "decodeResource(resources…rawable.icon_search_back)");
        this.v = bitmapDecodeResource;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.w = paint2;
        P1();
    }
}
