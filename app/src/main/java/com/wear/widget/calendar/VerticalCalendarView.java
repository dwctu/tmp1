package com.wear.widget.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.vending.expansion.downloader.Constants;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.widget.calendar.MonthView;
import dc.be3;
import dc.ce3;
import dc.cg3;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes4.dex */
public class VerticalCalendarView extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public DayOfWeekView g;
    public TextView h;
    public RecyclerView i;
    public List<Calendar> j;
    public b k;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            String str;
            int iMin;
            int iMin2;
            super.onScrolled(recyclerView, i, i2);
            int iFindFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            MonthView monthView = (MonthView) recyclerView.findViewHolderForLayoutPosition(iFindFirstVisibleItemPosition).itemView;
            int month = monthView.getMonth();
            int year = monthView.getYear();
            StringBuilder sb = new StringBuilder();
            sb.append(be3.t(month));
            if (month == 0 || iFindFirstVisibleItemPosition == 0) {
                str = " " + year;
            } else {
                str = "";
            }
            sb.append(str);
            VerticalCalendarView.this.h.setText(sb.toString());
            if (iFindFirstVisibleItemPosition != VerticalCalendarView.this.a) {
                VerticalCalendarView.this.a = iFindFirstVisibleItemPosition;
                if (VerticalCalendarView.this.m(i2)) {
                    VerticalCalendarView.this.h.layout(VerticalCalendarView.this.e, VerticalCalendarView.this.c - VerticalCalendarView.this.b, VerticalCalendarView.this.f, VerticalCalendarView.this.d - VerticalCalendarView.this.b);
                    return;
                } else {
                    VerticalCalendarView.this.h.layout(VerticalCalendarView.this.e, VerticalCalendarView.this.c, VerticalCalendarView.this.f, VerticalCalendarView.this.d);
                    return;
                }
            }
            if (recyclerView.findViewHolderForLayoutPosition(VerticalCalendarView.this.a + 1) != null) {
                if (((MonthView) recyclerView.findViewHolderForLayoutPosition(VerticalCalendarView.this.a + 1).itemView).getTop() <= VerticalCalendarView.this.b) {
                    iMin = Math.min(VerticalCalendarView.this.h.getTop() - i2, VerticalCalendarView.this.c);
                    iMin2 = Math.min(VerticalCalendarView.this.h.getBottom() - i2, VerticalCalendarView.this.d);
                } else {
                    iMin = VerticalCalendarView.this.c;
                    iMin2 = VerticalCalendarView.this.d;
                }
                VerticalCalendarView.this.h.layout(VerticalCalendarView.this.e, iMin, VerticalCalendarView.this.f, iMin2);
            }
        }
    }

    public class b extends BaseAdapter<Calendar> {
        public List<String> j;
        public MonthView.a k;

        public b(VerticalCalendarView verticalCalendarView, List<Calendar> list, int i) {
            super(list, i);
        }

        public void A(MonthView.a aVar) {
            this.k = aVar;
        }

        @Override // com.wear.adapter.BaseAdapter
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public void y(BaseAdapter.ViewHolder viewHolder, Calendar calendar, int i) {
            MonthView monthView = (MonthView) viewHolder.itemView;
            ArrayList arrayList = new ArrayList();
            List<String> list = this.j;
            if (list != null && !list.isEmpty()) {
                for (String str : this.j) {
                    Calendar calendar2 = Calendar.getInstance();
                    String[] strArrSplit = str.split(Constants.FILENAME_SEQUENCE_SEPARATOR);
                    calendar2.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
                    if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2)) {
                        arrayList.add(calendar2);
                    }
                }
            }
            monthView.setMonthParams(calendar.get(2), calendar.get(1), arrayList);
            monthView.setOnDayClickListener(this.k);
        }

        public void z(List<String> list) {
            this.j = list;
        }
    }

    public VerticalCalendarView(@NonNull Context context) {
        super(context);
        this.a = 0;
        this.b = ce3.a(getContext(), 20.0f) + 10;
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        this.e = Integer.MIN_VALUE;
        this.f = Integer.MIN_VALUE;
        l();
    }

    public final Calendar j(int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        return calendar;
    }

    public final void k() {
        this.i = (RecyclerView) findViewById(R.id.recycler_view_calendar);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        b bVar = new b(this, arrayList, R.layout.item_single_month);
        this.k = bVar;
        cg3.f(this.i, bVar);
        this.i.addOnScrollListener(new a());
    }

    public final void l() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_calendar_view, (ViewGroup) this, true);
        this.h = (TextView) findViewById(R.id.tv_month_label);
        DayOfWeekView dayOfWeekView = (DayOfWeekView) findViewById(R.id.header_day_of_week);
        this.g = dayOfWeekView;
        dayOfWeekView.setParams();
        k();
    }

    public final boolean m(int i) {
        return i < 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c == Integer.MIN_VALUE) {
            this.c = this.h.getTop();
        }
        if (this.d == Integer.MIN_VALUE) {
            this.d = this.h.getBottom();
        }
        if (this.e == Integer.MIN_VALUE) {
            this.e = this.h.getLeft();
        }
        if (this.f == Integer.MIN_VALUE) {
            this.f = this.h.getRight();
        }
    }

    public void setCalendarRange(Calendar calendar, Calendar calendar2, List<String> list) {
        if (calendar == null || calendar2 == null) {
            return;
        }
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar2.get(1);
        int i4 = calendar2.get(2);
        if (i <= i3) {
            if (i != i3 || i2 <= i4) {
                if (i == i3) {
                    while (i2 <= i4) {
                        this.j.add(j(i, i2));
                        i2++;
                    }
                } else {
                    for (int i5 = i; i5 <= i3; i5++) {
                        for (int i6 = 0; i6 <= 11; i6++) {
                            if (i5 == i) {
                                if (i6 >= i2) {
                                    this.j.add(j(i5, i6));
                                }
                            } else if (i5 != i3) {
                                this.j.add(j(i5, i6));
                            } else if (i6 <= i4) {
                                this.j.add(j(i5, i6));
                            }
                        }
                    }
                }
                this.k.z(list);
                this.k.notifyDataSetChanged();
                this.i.scrollToPosition(this.k.getItemCount() - 1);
            }
        }
    }

    public void setOnDayClickListener(MonthView.a aVar) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.A(aVar);
        }
    }

    public VerticalCalendarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = ce3.a(getContext(), 20.0f) + 10;
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        this.e = Integer.MIN_VALUE;
        this.f = Integer.MIN_VALUE;
        l();
    }

    public VerticalCalendarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = ce3.a(getContext(), 20.0f) + 10;
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        this.e = Integer.MIN_VALUE;
        this.f = Integer.MIN_VALUE;
        l();
    }
}
