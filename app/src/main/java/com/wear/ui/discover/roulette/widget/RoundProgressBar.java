package com.wear.ui.discover.roulette.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.koushikdutta.async.http.AsyncHttpRequest;
import dc.h14;
import dc.n04;
import dc.qu1;
import dc.uy3;
import dc.vi1;
import dc.wz3;
import dc.xz3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skin.support.widget.SkinCompatTextView;

/* compiled from: RoundProgressBar.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0002DEB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020*H\u0014J\u0006\u0010+\u001a\u00020#J\b\u0010,\u001a\u0004\u0018\u00010\u001dJ\b\u0010-\u001a\u00020*H\u0014J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0014J\u0011\u00101\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102J\u0006\u00103\u001a\u00020*J\b\u00104\u001a\u00020*H\u0002J\u0010\u00105\u001a\u00020*2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u00106\u001a\u00020*2\b\b\u0001\u00107\u001a\u00020\u0007J\u0010\u00108\u001a\u00020*2\b\b\u0001\u0010 \u001a\u00020\u0007J\u0010\u00109\u001a\u00020*2\b\b\u0001\u0010!\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020*2\u0006\u0010\"\u001a\u00020#J\u0010\u0010;\u001a\u00020*2\b\b\u0001\u0010$\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020*2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u001dJ\u000e\u0010?\u001a\u00020*2\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010@\u001a\u00020*J\u0006\u0010A\u001a\u00020*J\b\u0010B\u001a\u00020*H\u0002J\u0010\u0010C\u001a\u00020#2\u0006\u0010\"\u001a\u00020#H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lcom/wear/ui/discover/roulette/widget/RoundProgressBar;", "Lskin/support/widget/SkinCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "circleColor", "coroutineJob", "Lkotlinx/coroutines/Job;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "inCircleColors", "Landroid/content/res/ColorStateList;", "isDrawText", "", "mArcRect", "Landroid/graphics/RectF;", "mCountdownProgressListener", "Lcom/wear/ui/discover/roulette/widget/RoundProgressBar$OnCountdownEndListener;", "mPaint", "Landroid/graphics/Paint;", "mProgressType", "Lcom/wear/ui/discover/roulette/widget/RoundProgressBar$ProgressType;", "oldCountDownTime", "oldProgress", "outLineColor", "outLineWidth", "progress", "", "progressLineColor", "progressLineWidth", "timeMillis", "dpToPx", "dps", "drawableStateChanged", "", "getProgress", "getProgressType", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "progressChangeTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reStart", "resetProgress", "setCountdownProgressListener", "setInCircleColor", "inCircleColor", "setOutLineColor", "setOutLineWidth", "setProgress", "setProgressColor", "setProgressLineWidth", "setProgressType", "progressType", "setTimeMillis", TtmlNode.START, "stop", "validateCircleColor", "validateProgress", "OnCountdownEndListener", "ProgressType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RoundProgressBar extends SkinCompatTextView {

    @NotNull
    public final wz3 e;

    @Nullable
    public h14 f;
    public int g;
    public int h;

    @Nullable
    public ColorStateList i;
    public int j;
    public int k;
    public int l;

    @NotNull
    public final Paint m;

    @NotNull
    public final RectF n;
    public float o;

    @NotNull
    public b p;
    public int q;

    @NotNull
    public final Rect r;
    public boolean s;

    @Nullable
    public a t;
    public int u;
    public int v;

    /* compiled from: RoundProgressBar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/discover/roulette/widget/RoundProgressBar$OnCountdownEndListener;", "", "onEnd", "", "onProgress", "countTime", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(int i);

        void e();
    }

    /* compiled from: RoundProgressBar.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/wear/ui/discover/roulette/widget/RoundProgressBar$ProgressType;", "", "(Ljava/lang/String;I)V", "COUNT", "COUNT_BACK", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        COUNT,
        COUNT_BACK
    }

    /* compiled from: RoundProgressBar.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            iArr[b.COUNT.ordinal()] = 1;
            iArr[b.COUNT_BACK.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: RoundProgressBar.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.widget.RoundProgressBar", f = "RoundProgressBar.kt", i = {0}, l = {313, 314}, m = "progressChangeTask", n = {"this"}, s = {"L$0"})
    public static final class d extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoundProgressBar.this.d(this);
        }
    }

    /* compiled from: RoundProgressBar.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.widget.RoundProgressBar$start$1", f = "RoundProgressBar.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RoundProgressBar.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RoundProgressBar roundProgressBar = RoundProgressBar.this;
                this.label = 1;
                if (roundProgressBar.d(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundProgressBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RoundProgressBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int c(int i) {
        return MathKt__MathJVMKt.roundToInt(getResources().getDisplayMetrics().density * i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.widget.RoundProgressBar.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        i();
    }

    public final void e() {
        f();
        g();
    }

    public final void f() {
        float f;
        int i = c.a[this.p.ordinal()];
        if (i == 1) {
            f = 0.0f;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f = 1.0f;
        }
        this.o = f;
    }

    public final void g() {
        h();
        this.f = uy3.d(this.e, null, null, new e(null), 3, null);
    }

    @NotNull
    /* renamed from: getBounds, reason: from getter */
    public final Rect getR() {
        return this.r;
    }

    /* renamed from: getProgress, reason: from getter */
    public final float getO() {
        return this.o;
    }

    @Nullable
    /* renamed from: getProgressType, reason: from getter */
    public final b getP() {
        return this.p;
    }

    public final void h() {
        h14 h14Var = this.f;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
    }

    public final void i() {
        ColorStateList colorStateList = this.i;
        Intrinsics.checkNotNull(colorStateList);
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        if (this.j != colorForState) {
            this.j = colorForState;
            invalidate();
        }
    }

    public final float j(float f) {
        if (f > 1.0f) {
            return 1.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h14 h14Var = this.f;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getDrawingRect(this.r);
        float fWidth = (this.r.height() > this.r.width() ? this.r.width() : this.r.height()) / 2;
        ColorStateList colorStateList = this.i;
        Intrinsics.checkNotNull(colorStateList);
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        this.m.setStyle(Paint.Style.FILL);
        this.m.setColor(colorForState);
        canvas.drawCircle(this.r.centerX(), this.r.centerY(), fWidth - this.h, this.m);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.h);
        this.m.setColor(this.g);
        canvas.drawCircle(this.r.centerX(), this.r.centerY(), fWidth - (this.h / 2), this.m);
        if (this.s) {
            TextPaint paint = getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            paint.setTextSize(qu1.a(14));
            paint.setColor(getCurrentTextColor());
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            float fCenterY = this.r.centerY() - ((paint.descent() + paint.ascent()) / 2);
            StringBuilder sb = new StringBuilder();
            sb.append((int) (this.u / 1000.0f));
            sb.append('s');
            canvas.drawText(sb.toString(), this.r.centerX(), fCenterY, paint);
        }
        this.m.setColor(this.k);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.l);
        this.m.setAntiAlias(true);
        int i = this.l;
        RectF rectF = this.n;
        Rect rect = this.r;
        int i2 = i / 2;
        rectF.set(rect.left + i2, rect.top + i2, rect.right - i2, rect.bottom - i2);
        canvas.drawArc(this.n, -90.0f, (-360) * this.o, false, this.m);
    }

    public final void setCountdownProgressListener(@Nullable a aVar) {
        this.t = aVar;
    }

    public final void setInCircleColor(@ColorInt int inCircleColor) {
        this.i = ColorStateList.valueOf(inCircleColor);
        invalidate();
    }

    public final void setOutLineColor(@ColorInt int outLineColor) {
        this.g = outLineColor;
        invalidate();
    }

    public final void setOutLineWidth(@ColorInt int outLineWidth) {
        this.h = outLineWidth;
        invalidate();
    }

    public final void setProgress(float progress) {
        this.o = j(progress);
        invalidate();
    }

    public final void setProgressColor(@ColorInt int progressLineColor) {
        this.k = progressLineColor;
        invalidate();
    }

    public final void setProgressLineWidth(int progressLineWidth) {
        this.l = progressLineWidth;
        invalidate();
    }

    public final void setProgressType(@NotNull b progressType) {
        Intrinsics.checkNotNullParameter(progressType, "progressType");
        this.p = progressType;
        f();
        invalidate();
    }

    public final void setTimeMillis(int timeMillis) {
        this.q = timeMillis * 1000;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoundProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = xz3.a(n04.c());
        this.h = c(2);
        this.i = ColorStateList.valueOf(0);
        this.k = Color.parseColor("#FF2D89");
        this.l = c(2);
        Paint paint = new Paint();
        this.m = paint;
        this.n = new RectF();
        this.o = 1.0f;
        this.p = b.COUNT_BACK;
        this.q = AsyncHttpRequest.DEFAULT_TIMEOUT;
        this.r = new Rect();
        this.s = true;
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.RoundProgressBar);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.RoundProgressBar)");
        this.g = typedArrayObtainStyledAttributes.getColor(1, this.g);
        this.k = typedArrayObtainStyledAttributes.getColor(2, this.k);
        this.s = typedArrayObtainStyledAttributes.getBoolean(0, this.s);
        typedArrayObtainStyledAttributes.recycle();
        this.u = this.q;
    }
}
