package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import dc.aj4;
import dc.ce3;
import dc.th4;
import dc.vi1;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ConnectionsSideBar.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u00016B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0014J(\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0014J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0017J\u000e\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u0014J\u000e\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u001bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/wear/widget/ConnectionsSideBar;", "Landroid/view/View;", "Lskin/support/widget/SkinCompatSupportable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cellHeight", "", "getCellHeight", "()I", "setCellHeight", "(I)V", "cellWidth", "currentIndex", "getCurrentIndex", "setCurrentIndex", "indexed", "", "", "[Ljava/lang/String;", "itemCircleColor", "letterColor", "letterSize", "", "onLetterChangeListener", "Lcom/wear/widget/ConnectionsSideBar$OnLetterChangeListener;", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/RectF;", "rectRadius", "selectBackgroundRadius", "selectColor", "textHeight", "applySkin", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", XHTMLText.H, "oldw", "oldh", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setLetter", "letter", "setOnLetterChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "OnLetterChangeListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionsSideBar extends View implements aj4 {

    @NotNull
    public final Paint a;
    public final float b;

    @NotNull
    public final String[] c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final float j;

    @NotNull
    public final RectF k;
    public final float l;

    @Nullable
    public a m;

    /* compiled from: ConnectionsSideBar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/wear/widget/ConnectionsSideBar$OnLetterChangeListener;", "", "onLetterChange", "", "letter", "", "onReset", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();

        void b(@NotNull String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ConnectionsSideBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ConnectionsSideBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // dc.aj4
    public void P1() {
        this.g = th4.b(getContext(), R.color.lvs_ui_standard_systemText4);
        this.h = th4.b(getContext(), R.color.lvs_ui_standard_systemTextAccent);
        this.i = th4.b(getContext(), R.color.lvs_ui_standard_systemBrandGradient1);
    }

    /* renamed from: getCellHeight, reason: from getter */
    public final int getE() {
        return this.e;
    }

    /* renamed from: getCurrentIndex, reason: from getter */
    public final int getF() {
        return this.f;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        String[] strArr = this.c;
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            int i3 = i2 + 1;
            float fMeasureText = this.a.measureText(str);
            float f = 2;
            float f2 = (this.d - fMeasureText) / f;
            float f3 = ((this.e + this.b) / f) + (r9 * i2);
            if (i2 == this.f) {
                this.a.setColor(this.i);
                canvas.drawCircle((fMeasureText / f) + f2, f3 - (this.b / 4), this.l, this.a);
            }
            this.a.setColor(i2 == this.f ? this.h : this.g);
            canvas.drawText(str, f2, f3, this.a);
            i++;
            i2 = i3;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.d = getMeasuredWidth();
        this.e = getMeasuredHeight() / this.c.length;
        this.k.set(0.0f, 0.0f, w, h);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L1d
            if (r0 == r1) goto L12
            r2 = 2
            if (r0 == r2) goto L1d
            goto L46
        L12:
            com.wear.widget.ConnectionsSideBar$a r4 = r3.m
            if (r4 == 0) goto L19
            r4.a()
        L19:
            r3.invalidate()
            goto L46
        L1d:
            float r4 = r4.getY()
            int r0 = r3.e
            float r0 = (float) r0
            float r4 = r4 / r0
            int r4 = (int) r4
            int r0 = r3.f
            if (r0 != r4) goto L2b
            return r1
        L2b:
            r3.f = r4
            r0 = 0
            if (r4 < 0) goto L36
            java.lang.String[] r2 = r3.c
            int r2 = r2.length
            if (r4 >= r2) goto L36
            r0 = 1
        L36:
            if (r0 == 0) goto L43
            com.wear.widget.ConnectionsSideBar$a r0 = r3.m
            if (r0 == 0) goto L43
            java.lang.String[] r2 = r3.c
            r4 = r2[r4]
            r0.b(r4)
        L43:
            r3.invalidate()
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.ConnectionsSideBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setCellHeight(int i) {
        this.e = i;
    }

    public final void setCurrentIndex(int i) {
        this.f = i;
    }

    public final void setLetter(@NotNull String letter) {
        Intrinsics.checkNotNullParameter(letter, "letter");
        this.f = ArraysKt___ArraysKt.indexOf(this.c, letter);
        invalidate();
        String str = "setLetter: " + letter;
    }

    public final void setOnLetterChangeListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.m = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ConnectionsSideBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.a = paint;
        this.c = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};
        this.f = -1;
        this.k = new RectF();
        ce3.a(context, 26.0f);
        this.l = ce3.a(context, 7.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(vi1.SideBar);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…utes(R.styleable.SideBar)");
        this.g = th4.b(context, R.color.lvs_ui_standard_systemText4);
        this.h = th4.b(context, R.color.lvs_ui_standard_systemTextAccent);
        float dimension = typedArrayObtainStyledAttributes.getDimension(1, 24.0f);
        this.j = dimension;
        this.i = th4.b(context, R.color.lvs_ui_standard_systemBrandGradient1);
        typedArrayObtainStyledAttributes.recycle();
        paint.setTextSize(dimension);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.b = (float) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }
}
