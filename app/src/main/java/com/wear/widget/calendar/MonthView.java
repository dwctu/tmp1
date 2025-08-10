package com.wear.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.lovense.wear.R;
import dc.ah4;
import dc.be3;
import dc.ce3;
import dc.th4;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class MonthView extends View {
    public Calendar a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public List<String> h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public TextPaint o;
    public TextPaint p;
    public Paint q;
    public a r;

    public interface a {
        void a(MonthView monthView, int i, int i2, int i3);
    }

    public MonthView(Context context) {
        super(context);
        this.a = Calendar.getInstance();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 1;
        this.g = -1;
        this.h = new ArrayList();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = ce3.a(getContext(), 56.0f);
        this.n = ce3.a(getContext(), 30.0f);
        g();
    }

    public final void a(Canvas canvas) {
        int iD = d();
        int iA = (this.l / 2) + this.m + ce3.a(getContext(), 10.0f);
        float fAscent = (this.p.ascent() + this.p.descent()) / 2.0f;
        for (int i = 1; i <= this.b; i++) {
            int i2 = this.k;
            int paddingLeft = (i2 * iD) + (i2 / 2) + getPaddingLeft();
            String strValueOf = String.valueOf(i);
            if (i == this.g) {
                this.p.setColor(th4.b(getContext(), R.color.color_FFFFFFF_85));
                int i3 = (this.h.isEmpty() || !this.h.contains(strValueOf)) ? R.color.search_chat_date_select_un_default : R.color.search_chat_date_select_default;
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                paint.setColor(th4.b(getContext(), i3));
                float f = paddingLeft;
                float f2 = iA;
                canvas.drawCircle(f, f2, ce3.a(getContext(), 16.0f), paint);
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setColor(th4.b(getContext(), i3));
                paint2.setTextSize(ce3.g(getContext(), 10.0f));
                paint2.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(ah4.e(R.string.search_chat_today), f, (f2 - fAscent) + ce3.a(getContext(), 24.0f), paint2);
            } else {
                this.p.setColor(th4.b(getContext(), (this.h.isEmpty() || !this.h.contains(strValueOf)) ? R.color.text_color_25 : R.color.text_color_85));
            }
            canvas.drawText(strValueOf, paddingLeft, iA - fAscent, this.p);
            iD++;
            if (iD == 7) {
                iD = 0;
                iA += this.l;
            }
        }
    }

    public final void b(Canvas canvas) {
        float f = this.m;
        canvas.drawLine(0.0f, f, canvas.getWidth(), f, this.q);
    }

    public final void c(Canvas canvas) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(be3.t(this.c));
        if (this.c == 0) {
            str = " " + this.d;
        } else {
            str = "";
        }
        sb.append(str);
        canvas.drawText(sb.toString(), this.n, (this.m - ce3.a(getContext(), 12.0f)) - this.o.getFontMetrics().descent, this.o);
    }

    public final int d() {
        int i = this.e;
        int i2 = this.f;
        int i3 = i - i2;
        return i < i2 ? i3 + 7 : i3;
    }

    public final int e(int i, int i2) {
        int i3;
        int paddingTop;
        int paddingLeft = i - getPaddingLeft();
        if (paddingLeft < 0 || paddingLeft >= this.i || (paddingTop = i2 - getPaddingTop()) < (i3 = this.m) || paddingTop >= this.j) {
            return -1;
        }
        int iD = ((((paddingLeft * 7) / this.i) + (((paddingTop - i3) / this.l) * 7)) + 1) - d();
        if (i(iD)) {
            return iD;
        }
        return -1;
    }

    public final int f(int i, int i2) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                return ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) ? 28 : 29;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                return 0;
        }
    }

    public final void g() {
        this.a.setFirstDayOfWeek(1);
        setBackgroundColor(th4.b(getContext(), R.color.bg));
        h();
    }

    public int getMonth() {
        return this.c;
    }

    public int getYear() {
        return this.d;
    }

    public final void h() {
        TextPaint textPaint = new TextPaint();
        this.o = textPaint;
        textPaint.setAntiAlias(true);
        this.o.setTextSize(ce3.g(getContext(), 14.0f));
        this.o.setTextAlign(Paint.Align.LEFT);
        this.o.setColor(th4.b(getContext(), R.color.text_color_25));
        Paint paint = new Paint();
        this.q = paint;
        paint.setAntiAlias(true);
        this.q.setColor(th4.b(getContext(), R.color.user_guides_item_line_color));
        TextPaint textPaint2 = new TextPaint();
        this.p = textPaint2;
        textPaint2.setAntiAlias(true);
        this.p.setTextSize(ce3.g(getContext(), 14.0f));
        this.p.setTextAlign(Paint.Align.CENTER);
    }

    public final boolean i(int i) {
        return i >= 1 && i <= this.b;
    }

    public final boolean j(int i) {
        return i >= 0 && i <= 11;
    }

    public final boolean k(int i) {
        if (!i(i)) {
            return false;
        }
        a aVar = this.r;
        if (aVar == null) {
            return true;
        }
        aVar.a(this, this.d, this.c, i);
        return true;
    }

    public final boolean l(int i, Calendar calendar) {
        return this.d == calendar.get(1) && this.c == calendar.get(2) && i == calendar.get(5);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingLeft = paddingRight - getPaddingLeft();
        int paddingTop = paddingBottom - getPaddingTop();
        if (paddingLeft == this.i || paddingTop == this.j) {
            return;
        }
        this.i = paddingLeft;
        this.j = paddingTop;
        int i5 = paddingLeft / 7;
        this.k = i5;
        this.l = i5;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = ((View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()) / 7;
        this.k = size;
        this.l = size;
        int iD = d() + this.b;
        int i3 = iD / 7;
        if (iD % 7 != 0) {
            i3++;
        }
        setMeasuredDimension(i, View.resolveSize((this.l * i3) + this.m + getPaddingTop() + getPaddingBottom() + ce3.a(getContext(), 20.0f), i2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) (motionEvent.getX() + 0.5f);
        int y = (int) (motionEvent.getY() + 0.5f);
        if (motionEvent.getAction() == 1) {
            k(e(x, y));
        }
        return true;
    }

    public void setMonthParams(int i, int i2, List<Calendar> list) {
        if (j(i)) {
            this.c = i;
        }
        this.d = i2;
        this.a.set(1, i2);
        this.a.set(2, i);
        this.a.set(5, 1);
        this.b = f(i, i2);
        this.e = this.a.get(7);
        this.g = -1;
        int i3 = 0;
        while (i3 < this.b) {
            i3++;
            if (l(i3, Calendar.getInstance())) {
                this.g = i3;
            }
        }
        this.h.clear();
        if (list != null && !list.isEmpty()) {
            Iterator<Calendar> it = list.iterator();
            while (it.hasNext()) {
                this.h.add(String.valueOf(it.next().get(5)));
            }
        }
        requestLayout();
    }

    public void setOnDayClickListener(a aVar) {
        this.r = aVar;
    }

    public MonthView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Calendar.getInstance();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 1;
        this.g = -1;
        this.h = new ArrayList();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = ce3.a(getContext(), 56.0f);
        this.n = ce3.a(getContext(), 30.0f);
        g();
    }

    public MonthView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = Calendar.getInstance();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 1;
        this.g = -1;
        this.h = new ArrayList();
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = ce3.a(getContext(), 56.0f);
        this.n = ce3.a(getContext(), 30.0f);
        g();
    }
}
