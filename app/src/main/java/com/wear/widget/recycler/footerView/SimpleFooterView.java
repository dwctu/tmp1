package com.wear.widget.recycler.footerView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class SimpleFooterView extends BaseFooterView {
    public TextView a;
    public ProgressBar b;

    public SimpleFooterView(Context context) {
        this(context, null);
    }

    @Override // dc.ws3
    public void a() {
        this.b.setVisibility(0);
        this.a.setVisibility(8);
    }

    public SimpleFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_footer_view, this);
        this.b = (ProgressBar) viewInflate.findViewById(R.id.footer_view_progressbar);
        this.a = (TextView) viewInflate.findViewById(R.id.footer_view_tv);
    }
}
