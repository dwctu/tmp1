package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import dc.ce3;
import dc.gg3;
import dc.vi1;

/* loaded from: classes4.dex */
public class ScreenView extends View {
    public int a;

    public ScreenView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.a = ((gg3.e(context) - ce3.a(context, 32.0f)) * (context.obtainStyledAttributes(attributeSet, vi1.ScreenView).getInt(0, 0) * 2)) / 692;
    }

    public final int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return size;
        }
        return 0;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iA = a(i);
        int iA2 = this.a;
        if (iA2 <= 0) {
            iA2 = a(i2);
        }
        setMeasuredDimension(iA, iA2);
    }
}
