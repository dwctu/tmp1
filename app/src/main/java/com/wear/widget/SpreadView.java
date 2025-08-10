package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.wear.bean.data.PointData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpreadView.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\b\u0010#\u001a\u00020\u0016H\u0002R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\nj\b\u0012\u0004\u0012\u00020\r`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/wear/widget/SpreadView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pointColors", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pointList", "Lcom/wear/bean/data/PointData;", "pointPaint", "Landroid/graphics/Paint;", "whitePaint", "getWhitePaint", "()Landroid/graphics/Paint;", "whitePaint$delegate", "Lkotlin/Lazy;", "drawRaindrop", "", "canvas", "Landroid/graphics/Canvas;", "cx", "", "cy", "generatePoint", "generateRandomColor", "generateRandomDegrees", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removePoint", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class SpreadView extends View {

    @NotNull
    public final ArrayList<PointData> a;

    @NotNull
    public final ArrayList<Integer> b;

    @NotNull
    public final Paint c;

    @NotNull
    public final Lazy d;

    /* compiled from: SpreadView.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Paint> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Paint invoke() {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            return paint;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpreadView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpreadView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SpreadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final Paint getWhitePaint() {
        return (Paint) this.d.getValue();
    }

    public final void a(Canvas canvas, float f, float f2) {
        b();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            PointData pointData = (PointData) it.next();
            this.c.setColor(pointData.getColor());
            this.c.setAlpha((int) pointData.getAlpha());
            getWhitePaint().setAlpha((int) pointData.getAlpha());
            float f3 = 2;
            float width = 255 / (((getWidth() / 2) - pointData.getDefaultPath()) / f3);
            double d = 180;
            double radiusPath = f + (pointData.getRadiusPath() * Math.cos((pointData.getDegrees() * 3.141592653589793d) / d));
            Iterator it2 = it;
            double radiusPath2 = f2 + (pointData.getRadiusPath() * Math.sin((pointData.getDegrees() * 3.141592653589793d) / d));
            if (canvas != null) {
                canvas.drawCircle((float) radiusPath, (float) radiusPath2, pointData.getRadius() + f3, getWhitePaint());
            }
            if (canvas != null) {
                canvas.drawCircle((float) radiusPath, (float) radiusPath2, pointData.getRadius(), this.c);
            }
            pointData.setRadiusPath(pointData.getRadiusPath() + f3);
            pointData.setAlpha(pointData.getAlpha() - width);
            it = it2;
        }
        e();
    }

    public final void b() {
        if (this.a.size() < 10) {
            int iD = d();
            float fNextInt = 0.23f * r0.nextInt(getWidth() / 2);
            float width = fNextInt * (255.0f / (getWidth() / 2.0f));
            this.a.add(new PointData(fNextInt, width, new Random().nextInt(30) + 10, iD, 255 - width, c()));
        }
    }

    public final int c() {
        Integer num = this.b.get(new Random().nextInt(2));
        Intrinsics.checkNotNullExpressionValue(num, "pointColors[random.nextInt(2)]");
        return num.intValue();
    }

    public final int d() {
        return new Random().nextInt(360) - 180;
    }

    public final void e() {
        Iterator<PointData> it = this.a.iterator();
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

    @Override // android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        a(canvas, getWidth() / 2.0f, getHeight() / 2.0f);
        postInvalidateDelayed(8L);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iCoerceAtMost = RangesKt___RangesKt.coerceAtMost(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(iCoerceAtMost, iCoerceAtMost);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpreadView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new ArrayList<>();
        this.b = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(Color.parseColor("#FF58A1")), Integer.valueOf(Color.parseColor("#7E7EFF")));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.c = paint;
        this.d = LazyKt__LazyJVMKt.lazy(a.a);
    }
}
