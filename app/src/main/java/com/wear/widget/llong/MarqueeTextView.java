package com.wear.widget.llong;

import android.content.Context;
import android.util.AttributeSet;
import com.wear.widget.MediumBoldTextView;

/* loaded from: classes4.dex */
public class MarqueeTextView extends MediumBoldTextView {
    public MarqueeTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
