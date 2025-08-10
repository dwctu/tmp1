package dc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.wear.util.WearUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: BitmapUtils.java */
/* loaded from: classes4.dex */
public class sd3 {
    public static void a(Context context, Bitmap bitmap, View view, int i, ImageView imageView) {
        if (Build.VERSION.SDK_INT > 17) {
            d(context, bitmap, view, i, imageView);
        } else {
            c(context, bitmap, view, i, imageView);
        }
    }

    public static Bitmap b(Bitmap bitmap, int i) {
        int[] iArr;
        int i2 = i;
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr9 = iArr6;
                int i27 = iArr2[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr10 = iArr8[i24 + i2];
                iArr10[0] = (i27 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr10[1] = (i27 & 65280) >> 8;
                iArr10[2] = i27 & 255;
                int iAbs = i11 - Math.abs(i24);
                i25 += iArr10[0] * iAbs;
                i16 += iArr10[1] * iAbs;
                i17 += iArr10[2] * iAbs;
                if (i24 > 0) {
                    i21 += iArr10[0];
                    i22 += iArr10[1];
                    i23 += iArr10[2];
                } else {
                    i18 += iArr10[0];
                    i19 += iArr10[1];
                    i20 += iArr10[2];
                }
                i24++;
                i5 = i26;
                iArr6 = iArr9;
            }
            int i28 = i5;
            int[] iArr11 = iArr6;
            int i29 = i2;
            int i30 = i25;
            int i31 = 0;
            while (i31 < width) {
                iArr3[i13] = iArr7[i30];
                iArr4[i13] = iArr7[i16];
                iArr5[i13] = iArr7[i17];
                int i32 = i30 - i18;
                int i33 = i16 - i19;
                int i34 = i17 - i20;
                int[] iArr12 = iArr8[((i29 - i2) + i6) % i6];
                int i35 = i18 - iArr12[0];
                int i36 = i19 - iArr12[1];
                int i37 = i20 - iArr12[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr11[i31] = Math.min(i31 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i38 = iArr2[i14 + iArr11[i31]];
                iArr12[0] = (i38 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
                iArr12[1] = (i38 & 65280) >> 8;
                iArr12[2] = i38 & 255;
                int i39 = i21 + iArr12[0];
                int i40 = i22 + iArr12[1];
                int i41 = i23 + iArr12[2];
                i30 = i32 + i39;
                i16 = i33 + i40;
                i17 = i34 + i41;
                i29 = (i29 + 1) % i6;
                int[] iArr13 = iArr8[i29 % i6];
                i18 = i35 + iArr13[0];
                i19 = i36 + iArr13[1];
                i20 = i37 + iArr13[2];
                i21 = i39 - iArr13[0];
                i22 = i40 - iArr13[1];
                i23 = i41 - iArr13[2];
                i13++;
                i31++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap2;
            height = i15;
            i5 = i28;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = bitmapCopy;
        int i42 = i5;
        int[] iArr14 = iArr6;
        int i43 = height;
        int[] iArr15 = iArr7;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i2;
            int i46 = i6;
            int[] iArr16 = iArr2;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = i45;
            int i55 = i45 * width;
            int i56 = 0;
            int i57 = 0;
            while (i54 <= i2) {
                int i58 = width;
                int iMax = Math.max(0, i55) + i44;
                int[] iArr17 = iArr8[i54 + i2];
                iArr17[0] = iArr3[iMax];
                iArr17[1] = iArr4[iMax];
                iArr17[2] = iArr5[iMax];
                int iAbs2 = i11 - Math.abs(i54);
                i56 += iArr3[iMax] * iAbs2;
                i57 += iArr4[iMax] * iAbs2;
                i47 += iArr5[iMax] * iAbs2;
                if (i54 > 0) {
                    i51 += iArr17[0];
                    i52 += iArr17[1];
                    i53 += iArr17[2];
                } else {
                    i48 += iArr17[0];
                    i49 += iArr17[1];
                    i50 += iArr17[2];
                }
                int i59 = i42;
                if (i54 < i59) {
                    i55 += i58;
                }
                i54++;
                i42 = i59;
                width = i58;
            }
            int i60 = width;
            int i61 = i42;
            int i62 = i2;
            int i63 = i44;
            int i64 = i57;
            int i65 = i43;
            int i66 = i56;
            int i67 = 0;
            while (i67 < i65) {
                iArr16[i63] = (iArr16[i63] & ViewCompat.MEASURED_STATE_MASK) | (iArr15[i66] << 16) | (iArr15[i64] << 8) | iArr15[i47];
                int i68 = i66 - i48;
                int i69 = i64 - i49;
                int i70 = i47 - i50;
                int[] iArr18 = iArr8[((i62 - i2) + i46) % i46];
                int i71 = i48 - iArr18[0];
                int i72 = i49 - iArr18[1];
                int i73 = i50 - iArr18[2];
                if (i44 == 0) {
                    iArr14[i67] = Math.min(i67 + i11, i61) * i60;
                }
                int i74 = iArr14[i67] + i44;
                iArr18[0] = iArr3[i74];
                iArr18[1] = iArr4[i74];
                iArr18[2] = iArr5[i74];
                int i75 = i51 + iArr18[0];
                int i76 = i52 + iArr18[1];
                int i77 = i53 + iArr18[2];
                i66 = i68 + i75;
                i64 = i69 + i76;
                i47 = i70 + i77;
                i62 = (i62 + 1) % i46;
                int[] iArr19 = iArr8[i62];
                i48 = i71 + iArr19[0];
                i49 = i72 + iArr19[1];
                i50 = i73 + iArr19[2];
                i51 = i75 - iArr19[0];
                i52 = i76 - iArr19[1];
                i53 = i77 - iArr19[2];
                i63 += i60;
                i67++;
                i2 = i;
            }
            i44++;
            i2 = i;
            i42 = i61;
            i43 = i65;
            i6 = i46;
            iArr2 = iArr16;
            width = i60;
        }
        int i78 = width;
        bitmap3.setPixels(iArr2, 0, i78, 0, 0, i78, i43);
        return bitmap3;
    }

    public static void c(Context context, Bitmap bitmap, View view, float f, ImageView imageView) {
        imageView.setBackground(new BitmapDrawable(context.getResources(), b(f(bitmap, view), (int) f)));
        bitmap.recycle();
    }

    @SuppressLint({"NewApi"})
    public static void d(Context context, Bitmap bitmap, View view, float f, ImageView imageView) {
        Bitmap bitmapF = f(bitmap, view);
        RenderScript renderScriptCreate = RenderScript.create(context);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapF);
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, allocationCreateFromBitmap.getElement());
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(f);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap);
        allocationCreateFromBitmap.copyTo(bitmapF);
        imageView.setBackground(new BitmapDrawable(context.getResources(), bitmapF));
        bitmap.recycle();
        renderScriptCreate.destroy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0140, code lost:
    
        if (r7 == 7) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
    
        if (r7 == 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        r9 = r16 - r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        if (r7 == 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f0, code lost:
    
        if (r7 == 5) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f2, code lost:
    
        r11 = r17 + r19;
        r9 = r16 - r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x011c, code lost:
    
        if (r7 == 6) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap e(int r16, int r17, int r18, int r19, java.util.ArrayList<android.graphics.Bitmap> r20) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.sd3.e(int, int, int, int, java.util.ArrayList):android.graphics.Bitmap");
    }

    public static Bitmap f(Bitmap bitmap, View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapCreateBitmap;
    }

    public static Bitmap g(ArrayList<Bitmap> arrayList) {
        int iA;
        int i;
        int iA2 = ce3.a(WearUtils.x, 180.0f);
        int size = arrayList.size();
        if (size < 2) {
            iA = 0;
            i = iA2;
        } else if (size <= 4) {
            iA = ce3.a(WearUtils.x, 5.0f);
            i = (iA2 - iA) / 2;
        } else {
            iA = ce3.a(WearUtils.x, 4.0f);
            i = (iA2 - (iA * 2)) / 3;
        }
        return e(iA2, i, Color.parseColor("#FFD8D8D8"), iA, arrayList);
    }

    public static Bitmap h(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width < height ? width : height;
        Canvas canvas = new Canvas(Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        float f = i;
        RectF rectF = new RectF(0.0f, 0.0f, f, f);
        float f2 = i / 2;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
        return bitmap;
    }
}
