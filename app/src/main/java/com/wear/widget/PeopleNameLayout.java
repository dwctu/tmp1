package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class PeopleNameLayout extends LinearLayout {
    public int a;
    public int b;
    public TextView c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public int g;
    public int h;

    public PeopleNameLayout(Context context) {
        super(context);
        this.a = 1;
        this.b = 2;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.h = getMeasuredWidth();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f.getMeasuredWidth() != 0 && this.g != this.f.getMeasuredWidth()) {
            this.c.setMaxWidth(this.h - this.f.getMeasuredWidth());
            this.g = this.f.getMeasuredWidth();
        } else if (this.f.getMeasuredWidth() == 0) {
            this.c.setMaxWidth(this.h);
        }
    }

    public void setToyName(int i, String str) {
        TextView textView;
        TextView textView2 = this.d;
        if (textView2 == null || (textView = this.e) == null) {
            return;
        }
        if (i == this.a) {
            textView2.setText(str);
        } else if (i == this.b) {
            textView.setText(str);
        }
    }

    public void setToyVisibility(int i, int i2) {
        TextView textView;
        TextView textView2 = this.d;
        if (textView2 == null || (textView = this.e) == null) {
            return;
        }
        if (i == this.a) {
            textView2.setVisibility(i2);
        } else if (i == this.b) {
            textView.setVisibility(i2);
        }
    }

    public void setUserName(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public PeopleNameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1;
        this.b = 2;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_people_name, this);
        this.c = (TextView) findViewById(R.id.user_name);
        this.f = (LinearLayout) findViewById(R.id.ll_toy);
        this.d = (TextView) findViewById(R.id.toy_type_name_1);
        this.e = (TextView) findViewById(R.id.toy_type_name_2);
    }

    public PeopleNameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1;
        this.b = 2;
    }
}
