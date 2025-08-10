package dc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import dc.th1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BitmapUtil.kt */
/* loaded from: classes3.dex */
public final class yh1 {
    public static final yh1 a = new yh1();

    @NotNull
    public final Bitmap a() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        Intrinsics.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(16, …or.TRANSPARENT)\n        }");
        return bitmapCreateBitmap;
    }

    @NotNull
    public final Bitmap b(@NotNull th1 src) {
        Intrinsics.checkParameterIsNotNull(src, "src");
        int iO = src.o();
        int iG = src.g();
        Bitmap bitmap = Bitmap.createBitmap(iO, iG, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Rect rect = new Rect(0, 0, iO, iG);
        Rect rect2 = new Rect();
        TextPaint textPaint = new TextPaint();
        float f = iG;
        float f2 = 0.8f;
        textPaint.setTextSize(f * 0.8f);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        if (src.m() == th1.d.BOLD) {
            textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        }
        textPaint.setColor(src.c());
        String strN = src.n();
        while (f2 > 0.1f) {
            textPaint.getTextBounds(strN, 0, strN.length(), rect2);
            if (rect2.width() <= rect.width()) {
                break;
            }
            f2 -= 0.1f;
            textPaint.setTextSize(f * f2);
        }
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        canvas.drawText(strN, rect.centerX(), (rect.centerY() - (fontMetricsInt.top / 2)) - (fontMetricsInt.bottom / 2), textPaint);
        Intrinsics.checkExpressionValueIsNotNull(bitmap, "bitmap");
        return bitmap;
    }
}
