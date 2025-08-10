package com.wear.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.lovense.wear.R;
import dc.ah4;
import dc.ce3;

/* loaded from: classes4.dex */
public class WidthTextView extends AppCompatTextView {
    public WidthTextView(Context context) {
        super(context);
    }

    public final void b(int i, TextPaint textPaint, int i2) {
        setTextSize(i2);
        if (textPaint.measureText(ah4.e(R.string.closeRange_remoteControl)) > i) {
            b(i, textPaint, i2 - 1);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iA = (ce3.a(getContext(), 110.0f) * 92) / 110;
        if (ce3.c(getContext())) {
            return;
        }
        b(iA, getPaint(), 14);
    }

    public WidthTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WidthTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
