package com.wear.main.longDistance;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.firebase.database.annotations.NotNull;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import com.wear.widget.calendar.MonthView;
import com.wear.widget.calendar.VerticalCalendarView;
import dc.pj3;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SearchChatCalendarActivity extends BaseActivity {
    public String a;
    public String b;
    public String c;

    @BindView(R.id.calendar_view)
    public VerticalCalendarView calendarView;
    public boolean d;
    public Map<String, CommunMessage> e;

    @BindView(R.id.tv_no_result)
    public TextView tv_no_result;

    public class a implements Consumer<Map<String, CommunMessage>> {
        public a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<String, CommunMessage> map) throws Exception {
            SearchChatCalendarActivity.this.e = map;
            if (SearchChatCalendarActivity.this.e.isEmpty()) {
                SearchChatCalendarActivity.this.calendarView.setVisibility(8);
                SearchChatCalendarActivity.this.tv_no_result.setVisibility(0);
                return;
            }
            ArrayList arrayList = new ArrayList(SearchChatCalendarActivity.this.e.keySet());
            CommunMessage communMessage = (CommunMessage) SearchChatCalendarActivity.this.e.get(arrayList.get(0));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(communMessage.getCreated());
            SearchChatCalendarActivity.this.calendarView.setCalendarRange(calendar, Calendar.getInstance(), arrayList);
        }
    }

    public class b implements ObservableOnSubscribe<Map<String, CommunMessage>> {
        public b() {
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(@NotNull ObservableEmitter<Map<String, CommunMessage>> observableEmitter) throws Exception {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<CommunMessage> listFindDateMessage = SearchChatCalendarActivity.this.d ? DaoUtils.getCommunMessageDao().findDateMessage(WearUtils.y.p(), WearUtils.k0(SearchChatCalendarActivity.this.c)) : DaoUtils.getCommunMessageDao().findDateMessage(WearUtils.y.p(), SearchChatCalendarActivity.this.b);
            if (listFindDateMessage != null && !listFindDateMessage.isEmpty()) {
                Calendar calendar = Calendar.getInstance();
                for (CommunMessage communMessage : listFindDateMessage) {
                    calendar.setTime(communMessage.getCreated());
                    linkedHashMap.put(calendar.get(1) + Constants.FILENAME_SEQUENCE_SEPARATOR + calendar.get(2) + Constants.FILENAME_SEQUENCE_SEPARATOR + calendar.get(5), communMessage);
                }
            }
            observableEmitter.onNext(linkedHashMap);
        }
    }

    public class c implements MonthView.a {
        public c() {
        }

        @Override // com.wear.widget.calendar.MonthView.a
        public void a(MonthView monthView, int i, int i2, int i3) {
            CommunMessage communMessage = (CommunMessage) SearchChatCalendarActivity.this.e.get(i + Constants.FILENAME_SEQUENCE_SEPARATOR + i2 + Constants.FILENAME_SEQUENCE_SEPARATOR + i3);
            if (communMessage != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("searchMessage", communMessage);
                if (SearchChatCalendarActivity.this.d) {
                    bundle.putString("roomId", SearchChatCalendarActivity.this.c);
                    pj3.g(SearchChatCalendarActivity.this, ChatRoomActivity.class, bundle);
                } else {
                    bundle.putString("userId", SearchChatCalendarActivity.this.a);
                    pj3.g(SearchChatCalendarActivity.this, ChatActivity.class, bundle);
                }
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_chat_calendar);
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            String string = getIntent().getExtras().getString("userId");
            this.a = string;
            this.b = WearUtils.i0(string);
            this.c = getIntent().getExtras().getString("roomId");
            this.d = !TextUtils.isEmpty(r2);
        }
        y4();
    }

    @SuppressLint({"CheckResult"})
    public final void y4() {
        Observable.create(new b()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
        this.calendarView.setOnDayClickListener(new c());
    }
}
