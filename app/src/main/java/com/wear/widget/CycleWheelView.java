package com.wear.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.lovense.wear.R;
import dc.th4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class CycleWheelView extends ListView {
    public String a;
    public Handler b;
    public d c;
    public List<String> d;
    public int e;
    public int f;
    public float g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public e r;

    public class CycleWheelViewException extends Exception {
        private static final long serialVersionUID = 1;

        public CycleWheelViewException(String str) {
            super(str);
        }
    }

    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            CycleWheelView.this.s();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            View childAt;
            if (i != 0 || (childAt = CycleWheelView.this.getChildAt(0)) == null) {
                return;
            }
            float y = childAt.getY();
            if (y == 0.0f) {
                return;
            }
            if (Math.abs(y) < CycleWheelView.this.o / 2) {
                CycleWheelView cycleWheelView = CycleWheelView.this;
                cycleWheelView.smoothScrollBy(cycleWheelView.n(y), 50);
            } else {
                CycleWheelView cycleWheelView2 = CycleWheelView.this;
                cycleWheelView2.smoothScrollBy(cycleWheelView2.n(cycleWheelView2.o + y), 50);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CycleWheelView cycleWheelView = CycleWheelView.this;
            CycleWheelView.super.setSelection(cycleWheelView.o(this.a));
        }
    }

    public class c extends Drawable {
        public c() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int width = CycleWheelView.this.getWidth();
            Paint paint = new Paint();
            paint.setColor(CycleWheelView.this.h);
            paint.setStrokeWidth(CycleWheelView.this.i);
            Paint paint2 = new Paint();
            paint2.setColor(CycleWheelView.this.j);
            Paint paint3 = new Paint();
            paint3.setColor(CycleWheelView.this.k);
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, CycleWheelView.this.o * (CycleWheelView.this.l / 2), paint3);
            canvas.drawRect(0.0f, CycleWheelView.this.o * ((CycleWheelView.this.l / 2) + 1), f, CycleWheelView.this.o * CycleWheelView.this.l, paint3);
            canvas.drawRect(0.0f, CycleWheelView.this.o * (CycleWheelView.this.l / 2), f, CycleWheelView.this.o * ((CycleWheelView.this.l / 2) + 1), paint2);
            canvas.drawLine(0.0f, CycleWheelView.this.o * (CycleWheelView.this.l / 2), f, CycleWheelView.this.o * (CycleWheelView.this.l / 2), paint);
            canvas.drawLine(0.0f, CycleWheelView.this.o * ((CycleWheelView.this.l / 2) + 1), f, CycleWheelView.this.o * ((CycleWheelView.this.l / 2) + 1), paint);
        }

        @Override // android.graphics.drawable.Drawable
        @SuppressLint({"WrongConstant"})
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public class d extends BaseAdapter {
        public List<String> a = new ArrayList();

        public d() {
        }

        public void a(List<String> list) {
            this.a.clear();
            this.a.addAll(list);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (CycleWheelView.this.p) {
                return Integer.MAX_VALUE;
            }
            return (this.a.size() + CycleWheelView.this.l) - 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return "";
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(CycleWheelView.this.getContext()).inflate(CycleWheelView.this.m, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(CycleWheelView.this.n);
            if (i < CycleWheelView.this.l / 2 || (!CycleWheelView.this.p && i >= this.a.size() + (CycleWheelView.this.l / 2))) {
                textView.setText("");
                view.setVisibility(4);
            } else {
                textView.setText(this.a.get((i - (CycleWheelView.this.l / 2)) % this.a.size()));
                view.setVisibility(0);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return false;
        }
    }

    public interface e {
        void a(int i, String str);
    }

    public CycleWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = th4.b(getContext(), R.color.description_duration_item_text_color);
        this.f = -7829368;
        this.g = 0.8f;
        this.h = 0;
        this.i = 2;
        this.j = 0;
        this.k = 0;
        this.l = 5;
    }

    public List<String> getLabels() {
        return this.d;
    }

    public String getSelectLabel() {
        int selection = getSelection();
        if (selection < 0) {
            selection = 0;
        }
        try {
            return this.d.get(selection);
        } catch (Exception unused) {
            return "";
        }
    }

    public int getSelection() {
        if (this.q == 0) {
            this.q = this.l / 2;
        }
        return (this.q - (this.l / 2)) % this.d.size();
    }

    public final int n(float f) {
        return Math.abs(f) <= 2.0f ? (int) f : Math.abs(f) < 12.0f ? f > 0.0f ? 2 : -2 : (int) (f / 6.0f);
    }

    public final int o(int i) {
        List<String> list = this.d;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.p ? i + ((1073741823 / this.d.size()) * this.d.size()) : i;
    }

    public final void p() {
        this.b = new Handler();
        this.m = R.layout.item_cyclewheel;
        this.n = R.id.tv_label_item_wheel;
        this.c = new d();
        setVerticalScrollBarEnabled(false);
        setScrollingCacheEnabled(false);
        setCacheColorHint(0);
        setFadingEdgeLength(0);
        setOverScrollMode(2);
        setDividerHeight(0);
        setAdapter((ListAdapter) this.c);
        setOnScrollListener(new a());
    }

    public final void q() {
        this.o = r();
        getLayoutParams().height = this.o * this.l;
        this.c.a(this.d);
        this.c.notifyDataSetChanged();
        setBackgroundDrawable(new c());
    }

    public final int r() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(this.m, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return viewInflate.getMeasuredHeight();
    }

    public final void s() {
        int i = this.l / 2;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (getChildAt(0) == null) {
            return;
        }
        int i2 = Math.abs(getChildAt(0).getY()) <= ((float) (this.o / 2)) ? firstVisiblePosition + i : firstVisiblePosition + i + 1;
        if (i2 == this.q) {
            return;
        }
        this.q = i2;
        e eVar = this.r;
        if (eVar != null) {
            eVar.a(getSelection(), getSelectLabel());
        }
        t(firstVisiblePosition, i2, i);
    }

    public void setAlphaGradual(float f) {
        this.g = f;
        t(getFirstVisiblePosition(), this.q, this.l / 2);
    }

    public void setCycleEnable(boolean z) {
        if (this.p != z) {
            this.p = z;
            this.c.notifyDataSetChanged();
            setSelection(getSelection());
        }
    }

    public void setDivider(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void setLabelColor(int i) {
        this.f = i;
        t(getFirstVisiblePosition(), this.q, this.l / 2);
    }

    public void setLabelSelectColor(int i) {
        this.e = i;
        t(getFirstVisiblePosition(), this.q, this.l / 2);
    }

    public void setLabels(List<String> list, String str) {
        this.a = str;
        this.d = list;
        this.c.a(list);
        this.c.notifyDataSetChanged();
        q();
    }

    public void setOnWheelItemSelectedListener(e eVar) {
        this.r = eVar;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i) {
        this.b.post(new b(i));
    }

    public void setSolid(int i, int i2) {
        this.k = i;
        this.j = i2;
        q();
    }

    public void setWheelItemLayout(int i, int i2) {
        this.m = i;
        this.n = i2;
        d dVar = new d();
        this.c = dVar;
        dVar.a(this.d);
        setAdapter((ListAdapter) this.c);
        q();
    }

    public void setWheelSize(int i) throws CycleWheelViewException {
        if (i < 3 || i % 2 != 1) {
            throw new CycleWheelViewException("Wheel Size Error , Must Be 3,5,7,9...");
        }
        this.l = i;
        q();
    }

    public final void t(int i, int i2, int i3) {
        for (int i4 = (i2 - i3) - 1; i4 < i2 + i3 + 1; i4++) {
            View childAt = getChildAt(i4 - i);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(this.n);
                if (i2 == i4) {
                    textView.setTextColor(this.e);
                    childAt.setAlpha(1.0f);
                    textView.setText(textView.getText().toString() + this.a);
                } else {
                    textView.setTextColor(this.f);
                    childAt.setAlpha((float) Math.pow(this.g, Math.abs(i4 - i2)));
                    String string = textView.getText().toString();
                    if (string.contains(this.a)) {
                        textView.setText(string.substring(0, string.indexOf(this.a)));
                    }
                }
            }
        }
    }

    public CycleWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = th4.b(getContext(), R.color.description_duration_item_text_color);
        this.f = -7829368;
        this.g = 0.8f;
        this.h = 0;
        this.i = 2;
        this.j = 0;
        this.k = 0;
        this.l = 5;
        p();
    }

    public CycleWheelView(Context context) {
        super(context);
        this.e = th4.b(getContext(), R.color.description_duration_item_text_color);
        this.f = -7829368;
        this.g = 0.8f;
        this.h = 0;
        this.i = 2;
        this.j = 0;
        this.k = 0;
        this.l = 5;
    }
}
