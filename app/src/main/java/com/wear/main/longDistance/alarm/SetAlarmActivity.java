package com.wear.main.longDistance.alarm;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.AlarmListItems;
import com.wear.bean.AlarmPattern;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.main.patterns.SingleChoosePatternsActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.bf;
import dc.bo3;
import dc.ce3;
import dc.gg3;
import dc.kd0;
import dc.na2;
import dc.pj3;
import dc.se;
import dc.sg3;
import dc.sr3;
import dc.xe2;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class SetAlarmActivity extends BaseActivity implements View.OnClickListener {
    public static Map<Integer, String> u = new g();
    public static Map<Integer, String> v = new h();
    public static Map<Integer, String[]> w = new i();
    public Handler a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String[] b;
    public float c;

    @BindView(R.id.create_alarm_action_more_layout)
    public LinearLayout createAlarmActionMoreLayout;

    @BindView(R.id.date_settings)
    public LinearLayout dateSettings;
    public boolean e;

    @BindView(R.id.frequency_settings)
    public LinearLayout frequencySettings;
    public Timer h;
    public MyApplication i;
    public String j;
    public String k;
    public String l;
    public Calendar m;
    public List<String> o;
    public int p;
    public String q;
    public se s;
    public se t;

    @BindView(R.id.time_settings)
    public LinearLayout timeSettings;

    @BindView(R.id.tv_date_content)
    public TextView tvDateContent;

    @BindView(R.id.tv_frequency_content)
    public TextView tvFrequencyContent;

    @BindView(R.id.tv_time_content)
    public TextView tvTimeContent;
    public int d = 0;
    public AlarmListItems f = null;
    public ViewHolder g = null;
    public AlarmPattern n = null;

    public static class ViewHolder {

        @BindView(R.id.pattern_author)
        public TextView patternAuthor;

        @BindView(R.id.pattern_message)
        public LinearLayout patternMessage;

        @BindView(R.id.pattern_name)
        public TextView patternName;

        @BindView(R.id.pattern_play_layout)
        public LinearLayout patternPlayLayout;

        @BindView(R.id.pattern_select_icon)
        public ImageView patternSelectIcon;

        @BindView(R.id.pattern_timer)
        public TextView patternTimer;

        @BindView(R.id.toy_type_1)
        public ImageView toyType1;

        @BindView(R.id.toy_type_2)
        public ImageView toyType2;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.patternSelectIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.pattern_select_icon, "field 'patternSelectIcon'", ImageView.class);
            viewHolder.patternName = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_name, "field 'patternName'", TextView.class);
            viewHolder.toyType1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_type_1, "field 'toyType1'", ImageView.class);
            viewHolder.toyType2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_type_2, "field 'toyType2'", ImageView.class);
            viewHolder.patternAuthor = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_author, "field 'patternAuthor'", TextView.class);
            viewHolder.patternTimer = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_timer, "field 'patternTimer'", TextView.class);
            viewHolder.patternMessage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_message, "field 'patternMessage'", LinearLayout.class);
            viewHolder.patternPlayLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_play_layout, "field 'patternPlayLayout'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.patternSelectIcon = null;
            viewHolder.patternName = null;
            viewHolder.toyType1 = null;
            viewHolder.toyType2 = null;
            viewHolder.patternAuthor = null;
            viewHolder.patternTimer = null;
            viewHolder.patternMessage = null;
            viewHolder.patternPlayLayout = null;
        }
    }

    public class a implements se.b {
        public a() {
        }

        @Override // dc.se.b
        public void a(Date date, View view) {
            SetAlarmActivity.this.tvTimeContent.setText(be3.d.format(date));
            SetAlarmActivity.this.f.setTime(be3.d.format(date));
            SetAlarmActivity.this.m.set(11, Integer.valueOf(be3.q.format(date)).intValue());
            SetAlarmActivity.this.m.set(12, Integer.valueOf(be3.r.format(date)).intValue());
        }
    }

    public class b implements bf {

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetAlarmActivity.this.t.y();
                SetAlarmActivity.this.t.f();
            }
        }

        /* renamed from: com.wear.main.longDistance.alarm.SetAlarmActivity$b$b, reason: collision with other inner class name */
        public class ViewOnClickListenerC0124b implements View.OnClickListener {
            public ViewOnClickListenerC0124b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetAlarmActivity.this.t.f();
            }
        }

        public b() {
        }

        @Override // dc.bf
        public void a(View view) {
            TextView textView = (TextView) view.findViewById(R.id.tv_finish);
            TextView textView2 = (TextView) view.findViewById(R.id.iv_cancel);
            textView.setOnClickListener(new a());
            textView2.setOnClickListener(new ViewOnClickListenerC0124b());
        }
    }

    public class c implements se.b {
        public c() {
        }

        @Override // dc.se.b
        public void a(Date date, View view) {
            SetAlarmActivity.this.tvDateContent.setText(be3.h.format(date));
            SetAlarmActivity.this.q = be3.i.format(date);
            SetAlarmActivity.this.m.set(1, Integer.valueOf(be3.n.format(date)).intValue());
            SetAlarmActivity.this.m.set(2, Integer.valueOf(be3.o.format(date)).intValue() - 1);
            SetAlarmActivity.this.m.set(5, Integer.valueOf(be3.p.format(date)).intValue());
        }
    }

    public class d implements bo3.d {

        public class a implements sr3.c {
            public final /* synthetic */ sr3 a;

            public a(sr3 sr3Var) {
                this.a = sr3Var;
            }

            @Override // dc.sr3.c
            public void a(Toy toy) {
                Intent intent = new Intent(SetAlarmActivity.this, (Class<?>) CreatePatternActivity.class);
                kd0.b("extras_toy", toy);
                intent.putExtra("is_recording_pattern", 1);
                intent.putExtra("is_create_home", false);
                SetAlarmActivity.this.startActivity(intent);
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }

        public d() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (WearUtils.y.u() == null) {
                pj3.f(SetAlarmActivity.this, LoginActivity.class);
                SetAlarmActivity.this.finish();
            } else {
                if (na2.m().i()) {
                    na2.m().t();
                    return;
                }
                sr3 sr3Var = new sr3(SetAlarmActivity.this);
                sr3Var.j(new a(sr3Var));
                sr3Var.show();
            }
        }
    }

    public class e implements bo3.d {
        public e() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (WearUtils.y.u() == null) {
                pj3.f(SetAlarmActivity.this, LoginActivity.class);
                SetAlarmActivity.this.finish();
            } else {
                SetAlarmActivity.this.startActivityForResult(new Intent(SetAlarmActivity.this, (Class<?>) SingleChoosePatternsActivity.class), 22);
            }
        }
    }

    public class f implements bo3.d {
        public f() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (WearUtils.y.u() == null) {
                pj3.f(SetAlarmActivity.this, LoginActivity.class);
                SetAlarmActivity.this.finish();
                return;
            }
            switch (i) {
                case R.id.touch_costomer_week /* 2131364801 */:
                    if (SetAlarmActivity.this.p != R.id.touch_costomer_week) {
                        pj3.o(SetAlarmActivity.this, AlarmCustomerWeekActivity.class, 153);
                        break;
                    } else {
                        Intent intent = new Intent(SetAlarmActivity.this, (Class<?>) AlarmCustomerWeekActivity.class);
                        intent.putExtra("dates", SetAlarmActivity.w.get(Integer.valueOf(R.id.touch_costomer_week)));
                        SetAlarmActivity.this.startActivityForResult(intent, 153);
                        break;
                    }
                case R.id.touch_everyday /* 2131364803 */:
                    SetAlarmActivity.this.tvFrequencyContent.setText(ah4.e(R.string.set_alarm_frequency_everyday));
                    SetAlarmActivity.this.p = R.id.touch_everyday;
                    break;
                case R.id.touch_once /* 2131364804 */:
                    SetAlarmActivity.this.tvFrequencyContent.setText(ah4.e(R.string.set_alarm_frequency_once));
                    SetAlarmActivity.this.p = R.id.touch_once;
                    break;
                case R.id.touch_weekday /* 2131364809 */:
                    SetAlarmActivity.this.tvFrequencyContent.setText(ah4.e(R.string.set_alarm_frequency_weekday));
                    SetAlarmActivity.this.p = R.id.touch_weekday;
                    break;
            }
        }
    }

    public class g extends HashMap {
        public g() {
            put(Integer.valueOf(R.id.touch_once), ah4.e(R.string.alarm_defind_repeat_notice));
            put(Integer.valueOf(R.id.touch_weekday), ah4.e(R.string.set_alarm_frequency_weekday));
            put(Integer.valueOf(R.id.touch_everyday), ah4.e(R.string.set_alarm_frequency_everyday));
            put(Integer.valueOf(R.id.touch_costomer_week), ah4.e(R.string.set_alarm_frequency_customer_week));
        }
    }

    public class h extends HashMap {
        public h() {
            put(Integer.valueOf(R.id.touch_once), "customer");
            put(Integer.valueOf(R.id.touch_weekday), "weekday");
            put(Integer.valueOf(R.id.touch_everyday), "everyday");
            put(Integer.valueOf(R.id.touch_costomer_week), "customerweek");
        }
    }

    public class i extends HashMap {
        public i() {
            put(Integer.valueOf(R.id.touch_once), new String[0]);
            put(Integer.valueOf(R.id.touch_weekday), new String[]{"1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5"});
            put(Integer.valueOf(R.id.touch_everyday), new String[]{"1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7"});
            put(Integer.valueOf(R.id.touch_costomer_week), new String[0]);
            put(Integer.valueOf(R.id.repeat), new String[]{ah4.e(R.string.alarm_list_repeat_mon), ah4.e(R.string.alarm_list_repeat_Tue), ah4.e(R.string.alarm_list_repeat_Wed), ah4.e(R.string.alarm_list_repeat_Thur), ah4.e(R.string.alarm_list_repeat_Fri), ah4.e(R.string.alarm_list_repeat_Sat), ah4.e(R.string.alarm_list_repeat_Sun)});
        }
    }

    public class j extends HashMap {
        public j() {
            put(Integer.valueOf(R.id.touch_once), ah4.e(R.string.alarm_defind_repeat_notice));
            put(Integer.valueOf(R.id.touch_weekday), ah4.e(R.string.set_alarm_frequency_weekday));
            put(Integer.valueOf(R.id.touch_everyday), ah4.e(R.string.set_alarm_frequency_everyday));
            put(Integer.valueOf(R.id.touch_costomer_week), ah4.e(R.string.set_alarm_frequency_customer_week));
        }
    }

    public class k extends HashMap {
        public k() {
            put(Integer.valueOf(R.id.touch_once), "customer");
            put(Integer.valueOf(R.id.touch_weekday), "weekday");
            put(Integer.valueOf(R.id.touch_everyday), "everyday");
            put(Integer.valueOf(R.id.touch_costomer_week), "customerweek");
        }
    }

    public class l extends HashMap {
        public l() {
            put(Integer.valueOf(R.id.touch_once), new String[0]);
            put(Integer.valueOf(R.id.touch_weekday), new String[]{"1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5"});
            put(Integer.valueOf(R.id.touch_everyday), new String[]{"1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7"});
            put(Integer.valueOf(R.id.touch_costomer_week), new String[0]);
            put(Integer.valueOf(R.id.repeat), new String[]{ah4.e(R.string.alarm_list_repeat_mon), ah4.e(R.string.alarm_list_repeat_Tue), ah4.e(R.string.alarm_list_repeat_Wed), ah4.e(R.string.alarm_list_repeat_Thur), ah4.e(R.string.alarm_list_repeat_Fri), ah4.e(R.string.alarm_list_repeat_Sat), ah4.e(R.string.alarm_list_repeat_Sun)});
        }
    }

    public class m implements MyActionBar.f {
        public m() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (SetAlarmActivity.this.f != null) {
                try {
                    if (be3.B(be3.I(), be3.j.parse(SetAlarmActivity.this.q + " " + SetAlarmActivity.this.f.getTime().trim()), 0) && SetAlarmActivity.this.p == R.id.touch_once) {
                        sg3.i(SetAlarmActivity.this, R.string.alarm_defind_times_notice);
                        return;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SetAlarmActivity setAlarmActivity = SetAlarmActivity.this;
                setAlarmActivity.f.setFrequency(SetAlarmActivity.v.get(Integer.valueOf(setAlarmActivity.p)));
                if (SetAlarmActivity.this.p == R.id.touch_once) {
                    SetAlarmActivity setAlarmActivity2 = SetAlarmActivity.this;
                    setAlarmActivity2.f.setDates(WearUtils.A.toJson(new String[]{setAlarmActivity2.q}));
                } else {
                    SetAlarmActivity setAlarmActivity3 = SetAlarmActivity.this;
                    setAlarmActivity3.f.setDates(WearUtils.A.toJson(SetAlarmActivity.w.get(Integer.valueOf(setAlarmActivity3.p))));
                }
                DaoUtils.getAlarmListDao().updateOrAdd(SetAlarmActivity.this.f);
                Intent intent = new Intent();
                intent.putExtra("alarmItemId", SetAlarmActivity.this.f.getId());
                intent.putExtra("alarmPatternId", SetAlarmActivity.this.l);
                SetAlarmActivity.this.setResult(-1, intent);
                SetAlarmActivity.this.finish();
            }
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SetAlarmActivity setAlarmActivity = SetAlarmActivity.this;
            if (setAlarmActivity.e) {
                setAlarmActivity.N4();
                return;
            }
            if (setAlarmActivity.n.getData() == null) {
                SetAlarmActivity.this.n.setData(WearUtils.N1(SetAlarmActivity.this.n.getFile().getPath()));
            }
            if (WearUtils.e1(SetAlarmActivity.this.n.getData())) {
                return;
            }
            if (SetAlarmActivity.this.n.getHead() == null) {
                SetAlarmActivity setAlarmActivity2 = SetAlarmActivity.this;
                setAlarmActivity2.b = setAlarmActivity2.n.getData().split(",");
            } else {
                SetAlarmActivity setAlarmActivity3 = SetAlarmActivity.this;
                setAlarmActivity3.b = setAlarmActivity3.n.getData().split(";");
            }
            SetAlarmActivity.this.a.sendEmptyMessageDelayed(1, 500L);
            SetAlarmActivity setAlarmActivity4 = SetAlarmActivity.this;
            setAlarmActivity4.e = true;
            setAlarmActivity4.g.patternSelectIcon.setImageResource(R.drawable.chat_toolbar_pattern_pause);
        }
    }

    public class o implements bf {

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetAlarmActivity.this.s.y();
                SetAlarmActivity.this.s.f();
            }
        }

        public class b implements View.OnClickListener {
            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SetAlarmActivity.this.s.f();
            }
        }

        public o() {
        }

        @Override // dc.bf
        public void a(View view) {
            TextView textView = (TextView) view.findViewById(R.id.tv_finish);
            TextView textView2 = (TextView) view.findViewById(R.id.iv_cancel);
            textView.setOnClickListener(new a());
            textView2.setOnClickListener(new b());
        }
    }

    public class p extends Handler {

        public class a extends TimerTask {

            /* renamed from: com.wear.main.longDistance.alarm.SetAlarmActivity$p$a$a, reason: collision with other inner class name */
            public class RunnableC0125a implements Runnable {
                public final /* synthetic */ String a;

                public RunnableC0125a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SetAlarmActivity.this.i.G().f(this.a);
                }
            }

            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() throws NumberFormatException {
                SetAlarmActivity setAlarmActivity = SetAlarmActivity.this;
                String[] strArr = setAlarmActivity.b;
                int i = 0;
                if (strArr != null) {
                    int i2 = setAlarmActivity.d;
                    if (i2 + 1 < strArr.length) {
                        String str = strArr[i2];
                        if (!WearUtils.e1(str)) {
                            if (SetAlarmActivity.this.n.getHead() == null) {
                                float f = Float.parseFloat(str);
                                SetAlarmActivity setAlarmActivity2 = SetAlarmActivity.this;
                                if (f != setAlarmActivity2.c) {
                                    setAlarmActivity2.c = f;
                                    WearUtils.x.G().W((int) f);
                                }
                            } else {
                                SetAlarmActivity setAlarmActivity3 = SetAlarmActivity.this;
                                setAlarmActivity3.o = setAlarmActivity3.n.getHead().createCommands(str);
                                if (SetAlarmActivity.this.o != null) {
                                    for (String str2 : SetAlarmActivity.this.o) {
                                        if (SetAlarmActivity.this.o.size() == 1 || i < SetAlarmActivity.this.o.size() - 1) {
                                            SetAlarmActivity.this.a.postDelayed(new RunnableC0125a(str2), 50L);
                                        }
                                        i++;
                                    }
                                }
                            }
                        }
                        SetAlarmActivity setAlarmActivity4 = SetAlarmActivity.this;
                        setAlarmActivity4.d++;
                        setAlarmActivity4.a.sendEmptyMessage(7);
                        return;
                    }
                }
                Handler handler = setAlarmActivity.a;
                handler.sendMessage(Message.obtain(handler, 6, setAlarmActivity.g));
                SetAlarmActivity setAlarmActivity5 = SetAlarmActivity.this;
                setAlarmActivity5.d = 0;
                setAlarmActivity5.a.sendEmptyMessage(5);
            }
        }

        public p() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TextView textView;
            int i = message.what;
            if (i == 1) {
                SetAlarmActivity setAlarmActivity = SetAlarmActivity.this;
                if (setAlarmActivity.g == null) {
                    return;
                }
                if (setAlarmActivity.h == null) {
                    setAlarmActivity.h = new Timer();
                }
                SetAlarmActivity.this.h.schedule(new a(), 100L, 100L);
                return;
            }
            if (i == 5) {
                SetAlarmActivity.this.N4();
                return;
            }
            if (i != 7) {
                return;
            }
            long jK0 = WearUtils.K0(SetAlarmActivity.this.n.getTimer());
            SetAlarmActivity setAlarmActivity2 = SetAlarmActivity.this;
            int i2 = (int) (jK0 - ((setAlarmActivity2.d * 100) / 1000));
            if (i2 < 0) {
                i2 = 0;
            }
            ViewHolder viewHolder = setAlarmActivity2.g;
            if (viewHolder == null || (textView = viewHolder.patternTimer) == null) {
                return;
            }
            textView.setText(WearUtils.I0(i2));
        }
    }

    public static int F4(String str) {
        Integer key;
        Iterator<Map.Entry<Integer, String>> it = v.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                key = null;
                break;
            }
            Map.Entry<Integer, String> next = it.next();
            if (next.getValue().equals(str)) {
                key = next.getKey();
                break;
            }
        }
        return key.intValue();
    }

    public static void J4() {
        u = new j();
        v = new k();
        w = new l();
    }

    public static String K4(String str, String str2) {
        String str3;
        String str4;
        Iterator<Map.Entry<Integer, String>> it = v.entrySet().iterator();
        while (true) {
            str3 = "";
            if (!it.hasNext()) {
                str4 = "";
                break;
            }
            Map.Entry<Integer, String> next = it.next();
            if (next.getValue().equals(str)) {
                str4 = u.get(next.getKey());
                break;
            }
        }
        if (WearUtils.e1(str4) || !str4.equals(u.get(Integer.valueOf(R.id.touch_costomer_week))) || str2 == null) {
            return str4;
        }
        String[] strArr = (String[]) WearUtils.A.fromJson(str2, String[].class);
        if (WearUtils.j1(strArr)) {
            return str4;
        }
        if (strArr.length == 7) {
            return ah4.e(R.string.set_alarm_frequency_everyday);
        }
        for (String str5 : strArr) {
            if (WearUtils.q1(str5)) {
                str3 = str3 + w.get(Integer.valueOf(R.id.repeat))[Integer.valueOf(r4).intValue() - 1] + ", ";
            }
        }
        return str3.endsWith(", ") ? str3.substring(0, str3.length() - 2) : str3;
    }

    public final void E4() {
        this.f.setPatternId(this.l);
        Pattern patternK = xe2.L0().K(this.l);
        if (patternK == null) {
            finish();
        }
        DaoUtils.getAlarmPatternDao().addIfNotExist(new AlarmPattern(patternK));
    }

    public final void G4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.valueOf(be3.n.format(be3.I())).intValue(), 0, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2027, 2, 28);
        se.a aVar = new se.a(this, new c());
        aVar.S(ah4.e(R.string.set_alarm_date));
        aVar.O(this.m);
        aVar.R(calendar, calendar2);
        aVar.Q(R.layout.pickerview_custom_date, new b());
        aVar.T(new boolean[]{true, true, true, false, false, false});
        aVar.P(-14373475);
        aVar.N(true);
        se seVarM = aVar.M();
        this.t = seVarM;
        seVarM.u();
    }

    public final void H4() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 1, 23);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2027, 2, 28);
        se.a aVar = new se.a(this, new a());
        aVar.O(this.m);
        aVar.R(calendar, calendar2);
        aVar.Q(R.layout.pickerview_custom_time, new o());
        aVar.T(new boolean[]{false, false, false, true, true, false});
        aVar.P(-14373475);
        aVar.N(true);
        se seVarM = aVar.M();
        this.s = seVarM;
        seVarM.u();
    }

    public final void I4() {
        AlarmPattern alarmPatternFindById = DaoUtils.getAlarmPatternDao().findById(this.l);
        this.n = alarmPatternFindById;
        if (alarmPatternFindById == null) {
            finish();
        }
        this.createAlarmActionMoreLayout.removeAllViews();
        ViewHolder viewHolder = new ViewHolder(getLayoutInflater().inflate(R.layout.long_pattern_send_item, this.createAlarmActionMoreLayout));
        this.g = viewHolder;
        viewHolder.patternName.setText(this.n.getName());
        this.g.patternAuthor.setText(WearUtils.e1(this.n.getAuthor()) ? ah4.e(R.string.common_anonymous) : this.n.getAuthor());
        this.g.patternTimer.setText(this.n.getTimer());
        if (WearUtils.e1(this.n.getToyFunc())) {
            this.g.toyType1.setImageResource(R.drawable.icon_label_toy_function_vibration);
            this.g.toyType2.setVisibility(8);
        } else {
            String[] strArrSplit = this.n.getToyFunc().split(",");
            int i2 = 0;
            this.g.toyType2.setVisibility(strArrSplit.length > 1 ? 0 : 8);
            while (i2 < strArrSplit.length) {
                ViewHolder viewHolder2 = this.g;
                ImageView imageView = i2 == 0 ? viewHolder2.toyType1 : viewHolder2.toyType2;
                if (!TextUtils.equals(strArrSplit[i2], PSOProgramService.VS_Key)) {
                    TextUtils.equals(strArrSplit[i2], "v1");
                }
                if (TextUtils.equals(strArrSplit[i2], "v2")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
                }
                if (TextUtils.equals(strArrSplit[i2], "p")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_contraction);
                }
                if (TextUtils.equals(strArrSplit[i2], StreamManagement.AckRequest.ELEMENT)) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_rotation);
                }
                if (TextUtils.equals(strArrSplit[i2], "t")) {
                    imageView.setImageResource(i2 == 0 ? R.drawable.icon_label_toy_function_thrusting : R.drawable.icon_label_toy_function_speed);
                }
                if (TextUtils.equals(strArrSplit[i2], "s")) {
                    imageView.setImageResource(R.drawable.icon_white_function_suction);
                }
                if (TextUtils.equals(strArrSplit[i2], "f")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_fingering);
                }
                if (TextUtils.equals(strArrSplit[i2], GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_depth);
                }
                if (TextUtils.equals(strArrSplit[i2], "pos")) {
                    imageView.setImageResource(R.drawable.icon_velvo_position);
                }
                i2++;
            }
        }
        gg3.k(this.g.patternSelectIcon, ce3.a(this.i, 40.0f));
        this.g.patternSelectIcon.setImageResource(R.drawable.chat_toolbar_pattern_play);
        this.g.patternPlayLayout.setOnClickListener(new n());
    }

    public final void L4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_alarm_frequency);
        bo3Var.show();
        f fVar = new f();
        bo3Var.d(R.id.touch_once, fVar);
        bo3Var.d(R.id.touch_weekday, fVar);
        bo3Var.d(R.id.touch_everyday, fVar);
        bo3Var.d(R.id.touch_costomer_week, fVar);
        bo3Var.d(R.id.touch_cancel, null);
    }

    public final void M4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_toy_pattern);
        bo3Var.show();
        bo3Var.d(R.id.touch_record, new d());
        bo3Var.d(R.id.touch_selects, new e());
        bo3Var.d(R.id.touch_cancel, null);
    }

    public void N4() {
        this.e = false;
        Timer timer = this.h;
        if (timer != null) {
            timer.cancel();
            this.h = null;
        }
        this.g.patternSelectIcon.setImageResource(R.drawable.chat_toolbar_pattern_play);
        this.i.G().u0();
        this.g.patternTimer.setText(this.n.getTimer());
    }

    public final void O4() throws ParseException {
        Date date;
        I4();
        this.createAlarmActionMoreLayout.setOnClickListener(this);
        this.frequencySettings.setOnClickListener(this);
        this.timeSettings.setOnClickListener(this);
        this.dateSettings.setOnClickListener(this);
        Calendar calendar = Calendar.getInstance();
        this.m = calendar;
        calendar.setTime(be3.I());
        if (WearUtils.e1(this.k)) {
            this.m.add(12, 0);
            AlarmListItems alarmListItems = new AlarmListItems();
            this.f = alarmListItems;
            alarmListItems.setId(WearUtils.E());
            this.f.setIsSelected(1);
            this.f.setFriendEmail(this.j);
            this.f.setOwnerEmail(WearUtils.y.r());
            this.f.setPatternId(this.l);
            this.f.setTime(be3.d.format(this.m.getTime()));
            this.p = R.id.touch_once;
            this.f.setFrequency(v.get(Integer.valueOf(R.id.touch_once)));
        } else {
            AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(this.k);
            this.f = alarmListItemsFindById;
            try {
                String[] strArr = !WearUtils.e1(alarmListItemsFindById.getDates()) ? (String[]) WearUtils.A.fromJson(this.f.getDates(), String[].class) : null;
                if (strArr == null || WearUtils.e1(this.f.getTime()) || !WearUtils.Z0(strArr[0])) {
                    Date dateI = be3.I();
                    if (strArr != null && F4(this.f.getFrequency()) == R.id.touch_costomer_week) {
                        w.put(Integer.valueOf(R.id.touch_costomer_week), strArr);
                    }
                    date = dateI;
                } else {
                    date = be3.j.parse(strArr[0].trim() + " " + this.f.getTime().trim());
                }
                this.m.set(1, Integer.valueOf(be3.n.format(date)).intValue());
                this.m.set(2, Integer.valueOf(be3.o.format(date)).intValue() - 1);
                this.m.set(5, Integer.valueOf(be3.p.format(date)).intValue());
                this.m.set(11, Integer.valueOf(be3.q.format(date)).intValue());
                this.m.set(12, Integer.valueOf(be3.r.format(date)).intValue());
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            this.p = F4(this.f.getFrequency());
        }
        this.tvTimeContent.setText(be3.d.format(this.m.getTime()));
        this.tvFrequencyContent.setText(K4(this.f.getFrequency(), null));
        this.q = be3.i.format(this.m.getTime());
        this.tvDateContent.setText(be3.h.format(this.m.getTime()));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 22) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("choose_patterns");
                if (WearUtils.e1(stringExtra) || xe2.L0().K(stringExtra) == null) {
                    return;
                }
                this.l = stringExtra;
                E4();
                I4();
                return;
            }
            return;
        }
        if (i2 != 24) {
            if (i2 == 153 && intent != null) {
                this.p = R.id.touch_costomer_week;
                this.tvFrequencyContent.setText(ah4.e(R.string.set_alarm_frequency_customer_week));
                String[] stringArrayExtra = intent.getStringArrayExtra("dates");
                if (stringArrayExtra != null) {
                    w.put(Integer.valueOf(R.id.touch_costomer_week), stringArrayExtra);
                    return;
                }
                return;
            }
            return;
        }
        if (intent != null) {
            String stringExtra2 = intent.getStringExtra("program_pattern_id");
            if (WearUtils.e1(stringExtra2) || xe2.L0().K(stringExtra2) == null) {
                return;
            }
            this.l = stringExtra2;
            E4();
            I4();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_alarm_action_more_layout /* 2131362464 */:
                M4();
                break;
            case R.id.date_settings /* 2131362507 */:
                G4();
                break;
            case R.id.frequency_settings /* 2131362803 */:
                L4();
                break;
            case R.id.time_settings /* 2131364747 */:
                H4();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws ParseException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_set_alarm);
        this.a = new p();
        ButterKnife.bind(this);
        this.i = (MyApplication) getApplication();
        Intent intent = getIntent();
        this.j = intent.getStringExtra("friend_user_id");
        this.k = intent.getStringExtra("alarm_item_id");
        this.l = intent.getStringExtra("pattern_id");
        getLayoutInflater();
        O4();
        this.actionbar.setYesAction(R.string.common_save, new m());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        N4();
        super.onPause();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
