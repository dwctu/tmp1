package com.wear.main.longDistance.alarm;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Alarm;
import com.wear.bean.AlarmListItems;
import com.wear.bean.AlarmPattern;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.AlarmDao;
import com.wear.dao.DaoUtils;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.main.patterns.SingleChoosePatternsActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.EntityAlarm;
import com.wear.protocol.EntitySystem;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.bo3;
import dc.kd0;
import dc.kn3;
import dc.na2;
import dc.pj3;
import dc.sg3;
import dc.sr3;
import dc.tn2;
import dc.xe2;
import dc.zb2;
import dc.zn2;
import dc.zt3;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ChatAlarmActivity extends BaseActivity implements View.OnClickListener {
    public MyApplication a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.alarm_list_layout)
    public LinearLayout alarmListLayout;

    @BindView(R.id.alarm_message_settings)
    public LinearLayout alarmMessageSettings;

    @BindView(R.id.alarm_miss_swith)
    public SwitchView alarmMissSwith;

    @BindView(R.id.alarm_notify_swith)
    public SwitchView alarmNotifySwith;
    public LayoutInflater b;
    public String c;

    @BindView(R.id.create_alarm_action_more)
    public ImageView createAlarmActionMore;

    @BindView(R.id.create_alarm_action_more_layout)
    public LinearLayout createAlarmActionMoreLayout;

    @BindView(R.id.create_alarm_action_one)
    public ImageView createAlarmActionOne;

    @BindView(R.id.create_alarm_my_timepicker_view)
    public LinearLayout createAlarmActionOneLayout;
    public Alarm d;
    public List<AlarmListItems> e;
    public ProgressDialog f;

    @BindView(R.id.tv_alarm_message_content)
    public TextView tvAlarmMessageContent;

    @BindView(R.id.tv_create_alarm_action_more)
    public TextView tvCreateAlarmActionMore;

    public class a implements bo3.d {
        public a() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (WearUtils.y.u() == null) {
                pj3.f(ChatAlarmActivity.this, LoginActivity.class);
                ChatAlarmActivity.this.finish();
            } else {
                ChatAlarmActivity.this.startActivityForResult(new Intent(ChatAlarmActivity.this, (Class<?>) SingleChoosePatternsActivity.class), 22);
            }
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            System.out.println("alarmNotifySwith.isChecked=" + z);
            if (z) {
                ChatAlarmActivity.this.d.setNotifySwitchOn("true");
            } else {
                ChatAlarmActivity.this.d.setNotifySwitchOn("false");
            }
            DaoUtils.getAlarmDao().updateOrAdd(ChatAlarmActivity.this.d);
            EntitySystem entitySystem = new EntitySystem();
            if (z) {
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C300.toString(), null);
            } else {
                entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C301.toString(), null);
            }
            zb2 zb2VarO = zb2.O();
            ChatAlarmActivity chatAlarmActivity = ChatAlarmActivity.this;
            zb2VarO.F0(chatAlarmActivity, WearUtils.i0(chatAlarmActivity.c), entitySystem);
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            System.out.println("alarmMissSwith.isChecked=" + z);
            if (z) {
                ChatAlarmActivity.this.d.setMissSwitchOn("true");
            } else {
                ChatAlarmActivity.this.d.setMissSwitchOn("false");
            }
            DaoUtils.getAlarmDao().updateOrAdd(ChatAlarmActivity.this.d);
            ChatAlarmActivity.this.F4(Boolean.valueOf(z));
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatAlarmActivity.this.alarmListLayout.removeAllViews();
            if (ChatAlarmActivity.this.e == null || ChatAlarmActivity.this.e.size() == 0) {
                ChatAlarmActivity.this.createAlarmActionOneLayout.setVisibility(0);
                ChatAlarmActivity.this.createAlarmActionMoreLayout.setVisibility(8);
            } else {
                ChatAlarmActivity.this.createAlarmActionOneLayout.setVisibility(8);
                ChatAlarmActivity.this.createAlarmActionMoreLayout.setVisibility(0);
                Iterator it = ChatAlarmActivity.this.e.iterator();
                while (it.hasNext()) {
                    ChatAlarmActivity.this.B4((AlarmListItems) it.next());
                }
            }
            ChatAlarmActivity.this.alarmListLayout.invalidate();
        }
    }

    public class e implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ AlarmListItems a;

        public e(AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws ParseException {
            System.out.println("isChecked=" + z);
            if (z) {
                ChatAlarmActivity.this.E4(this.a.getId());
                return;
            }
            this.a.setIsSelected(0);
            DaoUtils.getAlarmListDao().updateOrAdd(this.a);
            ChatAlarmActivity.this.A4(this.a.getId());
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ AlarmListItems a;

        public f(AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChatAlarmActivity.this.C4(this.a.getId(), this.a.getPatternId());
        }
    }

    public class g implements View.OnLongClickListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ AlarmListItems b;

        public g(View view, AlarmListItems alarmListItems) {
            this.a = view;
            this.b = alarmListItems;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ChatAlarmActivity.this.D4(this.a, this.b);
            return true;
        }
    }

    public class h implements kn3.d {
        public final /* synthetic */ AlarmListItems a;
        public final /* synthetic */ View b;

        public h(AlarmListItems alarmListItems, View view) {
            this.a = alarmListItems;
            this.b = view;
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            ChatAlarmActivity.this.A4(this.a.getId());
            AlarmMessagingService.d(this.a.getId(), true);
            ChatAlarmActivity.this.alarmListLayout.removeView(this.b);
            DaoUtils.getAlarmListDao().delT(this.a);
            ChatAlarmActivity.this.alarmListLayout.invalidate();
        }
    }

    public class i implements zn2<String> {
        public final /* synthetic */ AlarmPattern a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AlarmListItems c;

        public i(AlarmPattern alarmPattern, String str, AlarmListItems alarmListItems) {
            this.a = alarmPattern;
            this.b = str;
            this.c = alarmListItems;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws ParseException {
            ChatAlarmActivity.this.f.dismiss();
            if (WearUtils.e1(str)) {
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse.isResult()) {
                this.a.setAlarmUrl(normalResponse.getMessage());
                DaoUtils.getAlarmPatternDao().updateOrAdd(this.a);
                ChatAlarmActivity.this.E4(this.b);
            } else {
                sg3.k(ChatAlarmActivity.this, normalResponse.getMessage());
                this.c.setIsSelected(0);
                DaoUtils.getAlarmListDao().updateOrAdd(this.c);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ChatAlarmActivity.this.f.dismiss();
        }
    }

    public class j implements bo3.d {

        public class a implements sr3.c {
            public a() {
            }

            @Override // dc.sr3.c
            public void a(Toy toy) {
                Intent intent = new Intent(ChatAlarmActivity.this, (Class<?>) CreatePatternActivity.class);
                kd0.b("extras_toy", toy);
                intent.putExtra("is_recording_pattern", 1);
                intent.putExtra("is_create_home", false);
                ChatAlarmActivity.this.startActivity(intent);
            }
        }

        public j() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (WearUtils.y.u() == null) {
                pj3.f(ChatAlarmActivity.this, LoginActivity.class);
                ChatAlarmActivity.this.finish();
            } else {
                if (na2.m().i()) {
                    na2.m().t();
                    return;
                }
                sr3 sr3Var = new sr3(ChatAlarmActivity.this);
                sr3Var.j(new a());
                sr3Var.show();
            }
        }
    }

    public final void A4(String str) {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        DaoUtils.getAlarmPatternDao().findById(alarmListItemsFindById.getPatternId());
        EntityAlarm entityAlarm = new EntityAlarm();
        entityAlarm.setId(alarmListItemsFindById.getId());
        entityAlarm.setType(EntityAlarm.AlarmOPTType.delete.toString());
        entityAlarm.setPattern(null);
        zb2.O().E0(WearUtils.i0(this.c), entityAlarm, null);
        AlarmMessagingService.d(str, true);
    }

    public final void B4(AlarmListItems alarmListItems) {
        View viewInflate = this.b.inflate(R.layout.item_chat_alarm, (ViewGroup) this.alarmListLayout, false);
        ((TextView) viewInflate.findViewById(R.id.alart_frequency)).setText(alarmListItems.getFrequency());
        String strK4 = SetAlarmActivity.K4(alarmListItems.getFrequency(), null);
        ((TextView) viewInflate.findViewById(R.id.alart_frequency)).setText(strK4);
        if (strK4.equals(SetAlarmActivity.u.get(Integer.valueOf(R.id.touch_once)))) {
            String str = ((String[]) WearUtils.A.fromJson(alarmListItems.getDates(), String[].class))[0];
            ((TextView) viewInflate.findViewById(R.id.alart_time)).setText(str + " " + alarmListItems.getTime());
        } else {
            ((TextView) viewInflate.findViewById(R.id.alart_time)).setText(alarmListItems.getTime());
        }
        SwitchView switchView = (SwitchView) viewInflate.findViewById(R.id.alarm_activat_swith);
        if (alarmListItems.getIsSelected() > 0) {
            switchView.setChecked(true);
        } else {
            switchView.setChecked(false);
        }
        switchView.setOnCheckedChangeListener(new e(alarmListItems));
        viewInflate.setOnClickListener(new f(alarmListItems));
        this.alarmListLayout.addView(viewInflate);
        viewInflate.setOnLongClickListener(new g(viewInflate, alarmListItems));
    }

    public void C4(String str, String str2) {
        Pattern patternK = xe2.L0().K(str2);
        if (patternK == null && DaoUtils.getAlarmPatternDao().findById(str2) == null) {
            finish();
        }
        if (patternK != null) {
            DaoUtils.getAlarmPatternDao().addIfNotExist(new AlarmPattern(patternK));
        }
        Intent intent = new Intent(this, (Class<?>) SetAlarmActivity.class);
        intent.putExtra("friend_user_id", this.c);
        intent.putExtra("alarm_item_id", str);
        intent.putExtra("pattern_id", str2);
        startActivityForResult(intent, 120);
    }

    public void D4(View view, AlarmListItems alarmListItems) {
        kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.alarm_delete_notices), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) new h(alarmListItems, view));
        kn3Var.show();
        kn3Var.r();
    }

    public final void E4(String str) throws ParseException {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        if (WearUtils.e1(alarmListItemsFindById.getPatternId())) {
            return;
        }
        AlarmPattern alarmPatternFindById = DaoUtils.getAlarmPatternDao().findById(alarmListItemsFindById.getPatternId());
        if (WearUtils.e1(alarmPatternFindById.getAlarmUrl())) {
            return;
        }
        A4(str);
        EntityAlarm entityAlarm = new EntityAlarm();
        entityAlarm.setId(alarmListItemsFindById.getId());
        entityAlarm.setType(EntityAlarm.AlarmOPTType.pattern.toString());
        entityAlarm.setPattern(alarmListItemsFindById, alarmPatternFindById.getAlarmUrl());
        zb2.O().E0(WearUtils.i0(this.c), entityAlarm, null);
        alarmListItemsFindById.setIsSelected(1);
        DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindById);
        zt3.t(this.a, alarmListItemsFindById.getId(), false, true, true);
        User userV = WearUtils.y.v(this.c);
        if ((userV != null && (userV == null || userV.isOnline())) || userV == null || WearUtils.x.i.D(WearUtils.i0(userV.getId()), true)) {
            return;
        }
        String strE = ah4.e(R.string.chat_alarm_offline);
        Object[] objArr = new Object[1];
        objArr[0] = userV == null ? "" : userV.getUserName();
        sg3.k(this, String.format(strE, objArr));
    }

    public final void F4(Boolean bool) {
        EntitySystem entitySystem = new EntitySystem();
        if (bool.booleanValue()) {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C302.toString(), this.d.getMessage());
        } else {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C303.toString(), null);
        }
        zb2.O().F0(this, WearUtils.i0(this.c), entitySystem);
    }

    public final void G4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_toy_pattern);
        bo3Var.show();
        bo3Var.d(R.id.touch_record, new j());
        bo3Var.d(R.id.touch_selects, new a());
        bo3Var.d(R.id.touch_cancel, null);
    }

    public final void H4() {
        this.createAlarmActionOne.setOnClickListener(this);
        this.createAlarmActionMore.setOnClickListener(this);
        this.alarmMessageSettings.setOnClickListener(this);
        this.tvCreateAlarmActionMore.setOnClickListener(this);
        if (WearUtils.y1(this.d.getNotifySwitchOn())) {
            this.alarmNotifySwith.setChecked(true);
        } else {
            this.alarmNotifySwith.setChecked(false);
        }
        if (WearUtils.y1(this.d.getMissSwitchOn())) {
            this.alarmMissSwith.setChecked(true);
        } else {
            this.alarmMissSwith.setChecked(false);
        }
        this.tvAlarmMessageContent.setText(this.d.getMessage());
        this.alarmNotifySwith.setOnCheckedChangeListener(new b());
        this.alarmMissSwith.setOnCheckedChangeListener(new c());
        this.alarmListLayout.postDelayed(new d(), 200L);
    }

    public final void I4(String str, String str2) throws ParseException {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        AlarmPattern alarmPatternFindById = DaoUtils.getAlarmPatternDao().findById(str2);
        System.out.println("alarmItemId=" + str + "  " + alarmListItemsFindById.getId());
        if (!WearUtils.e1(alarmPatternFindById.getAlarmUrl())) {
            E4(str);
            return;
        }
        this.f = ProgressDialog.show(this, "", ah4.e(R.string.common_uploading), false, true);
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/pattern", WearUtils.x0(str2), new HashMap(), new i(alarmPatternFindById, str, alarmListItemsFindById));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) throws ParseException {
        Alarm alarm;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 22) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("choose_patterns");
                if (WearUtils.e1(stringExtra) || xe2.L0().K(stringExtra) == null) {
                    return;
                }
                C4(null, stringExtra);
                return;
            }
            return;
        }
        if (i2 == 24) {
            if (intent != null) {
                String stringExtra2 = intent.getStringExtra("program_pattern_id");
                if (WearUtils.e1(stringExtra2) || xe2.L0().K(stringExtra2) == null) {
                    return;
                }
                C4(null, stringExtra2);
                return;
            }
            return;
        }
        if (i2 != 120) {
            if (i2 != 153 || i3 != -1 || intent == null || intent.getStringExtra("message") == null || (alarm = this.d) == null) {
                return;
            }
            alarm.setMessage(intent.getStringExtra("message"));
            DaoUtils.getAlarmDao().update((AlarmDao) this.d);
            if (this.alarmMissSwith.isChecked()) {
                F4(Boolean.TRUE);
                return;
            }
            return;
        }
        if (i3 == -1) {
            String stringExtra3 = intent.getStringExtra("alarmItemId");
            String stringExtra4 = intent.getStringExtra("alarmPatternId");
            if (intent == null || WearUtils.e1(stringExtra3) || WearUtils.e1(stringExtra4)) {
                return;
            }
            AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(stringExtra3);
            if (!alarmListItemsFindById.getPatternId().equals(stringExtra4)) {
                alarmListItemsFindById.setPatternId(stringExtra4);
                DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindById);
            }
            if (DaoUtils.getAlarmPatternDao().findById(stringExtra4) != null) {
                I4(stringExtra3, stringExtra4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alarm_message_settings /* 2131362053 */:
                pj3.q(this, AlarmMessageActivity.class, 153, "message", this.tvAlarmMessageContent.getText().toString());
                break;
            case R.id.create_alarm_action_more /* 2131362463 */:
            case R.id.create_alarm_action_one /* 2131362465 */:
            case R.id.tv_create_alarm_action_more /* 2131365024 */:
                G4();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat_alarm);
        ButterKnife.bind(this);
        this.a = (MyApplication) getApplication();
        this.c = getIntent().getStringExtra("userId");
        this.b = getLayoutInflater();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Alarm alarmFindAlarm = DaoUtils.getAlarmDao().findAlarm(WearUtils.y.r(), this.c);
        this.d = alarmFindAlarm;
        if (alarmFindAlarm == null) {
            Alarm alarm = new Alarm();
            this.d = alarm;
            alarm.setOwnerEmail(WearUtils.y.r());
            this.d.setFriendEmail(this.c);
            this.d.setMessage("");
            DaoUtils.getAlarmDao().add((AlarmDao) this.d);
        }
        this.e = DaoUtils.getAlarmListDao().findAlarmList(this.c, 0, WearUtils.y.r());
        H4();
    }
}
