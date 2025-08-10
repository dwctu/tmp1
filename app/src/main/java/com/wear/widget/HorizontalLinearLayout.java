package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.vi1;

/* loaded from: classes4.dex */
public class HorizontalLinearLayout extends LinearLayout implements View.OnClickListener {
    public Context a;
    public int[] b;
    public SparseArray<TextView> c;
    public int d;

    public HorizontalLinearLayout(Context context) {
        super(context);
        this.c = new SparseArray<>();
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.a = context;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.HorizontalLinearLayout);
            if (typedArrayObtainStyledAttributes.hasValue(0)) {
                this.b = getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(0, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.b == null) {
            this.b = new int[]{0, 1, 3, 5, 10, 15};
        }
        for (int i : this.b) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_textview, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_text);
            textView.setGravity(17);
            textView.getPaint().setFakeBoldText(true);
            textView.setLineSpacing(1.0f, 1.0f);
            textView.setText("" + i);
            textView.setTextColor(ContextCompat.getColor(context, R.color.dot_point_choose_background));
            addView(viewInflate, new LinearLayout.LayoutParams(0, -1, 1.0f));
            this.c.put(i, textView);
            textView.setOnClickListener(this);
        }
        this.d = this.b[0];
        b();
    }

    public final void b() {
        for (int i = 0; i < this.c.size(); i++) {
            int iKeyAt = this.c.keyAt(i);
            if (this.d == iKeyAt) {
                this.c.get(iKeyAt).setTextColor(ContextCompat.getColor(this.a, R.color.white));
                this.c.get(iKeyAt).setBackgroundResource(R.drawable.line_trans_bg_pick_round);
            } else {
                this.c.get(iKeyAt).setTextColor(ContextCompat.getColor(this.a, R.color.dot_point_choose_background));
                this.c.get(iKeyAt).setBackgroundResource(R.drawable.line_trans_bg_lightblack_round);
            }
        }
    }

    public int getSelect() {
        return this.d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof TextView) {
            String string = ((TextView) view).getText().toString();
            if (WearUtils.q1(string)) {
                this.d = Integer.parseInt(string);
                b();
            }
        }
    }

    public void setSelect(int i) {
        this.d = i;
        b();
    }

    public HorizontalLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new SparseArray<>();
        a(context, attributeSet);
    }

    public HorizontalLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new SparseArray<>();
        a(context, attributeSet);
    }
}
