package com.wear.main.longDistance;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.calendar.VerticalCalendarView;

/* loaded from: classes3.dex */
public class SearchChatCalendarActivity_ViewBinding implements Unbinder {
    public SearchChatCalendarActivity a;

    @UiThread
    public SearchChatCalendarActivity_ViewBinding(SearchChatCalendarActivity searchChatCalendarActivity, View view) {
        this.a = searchChatCalendarActivity;
        searchChatCalendarActivity.calendarView = (VerticalCalendarView) Utils.findRequiredViewAsType(view, R.id.calendar_view, "field 'calendarView'", VerticalCalendarView.class);
        searchChatCalendarActivity.tv_no_result = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_no_result, "field 'tv_no_result'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchChatCalendarActivity searchChatCalendarActivity = this.a;
        if (searchChatCalendarActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchChatCalendarActivity.calendarView = null;
        searchChatCalendarActivity.tv_no_result = null;
    }
}
