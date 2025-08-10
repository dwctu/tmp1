package com.wear.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.wear.util.WearUtils;
import dc.ce3;
import net.qiujuer.genius.graphics.Blur;

/* loaded from: classes4.dex */
public class BlurTextView extends AppCompatTextView {
    public Bitmap a;
    public int b;
    public int c;

    public BlurTextView(Context context) {
        super(context);
        this.a = null;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Bitmap drawingCache;
        super.onMeasure(i, i2);
        this.b = ce3.e(i);
        int iD = ce3.d(i2);
        this.c = iD;
        if (this.b <= 0 || iD <= 0 || (drawingCache = getDrawingCache()) == null) {
            return;
        }
        Bitmap bitmapCopy = drawingCache.copy(drawingCache.getConfig(), true);
        this.a = bitmapCopy;
        int width = bitmapCopy.getWidth();
        int height = this.a.getHeight();
        int[] iArr = new int[width * height];
        this.a.getPixels(iArr, 0, width, 0, 0, width, height);
        Blur.c(iArr, width, height, 8);
        this.a.setPixels(iArr, 0, width, 0, 0, width, height);
        Bitmap bitmap = this.a;
        Blur.b(bitmap, 8);
        this.a = bitmap;
        setBackground(new BitmapDrawable(getContext().getResources(), this.a));
    }

    public void setTextValue(CharSequence charSequence) {
        super.setText(charSequence);
        if (WearUtils.e1(charSequence.toString())) {
            return;
        }
        this.a = null;
    }

    public void setType(boolean z, int i) {
    }

    public BlurTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public BlurTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
    }
}
