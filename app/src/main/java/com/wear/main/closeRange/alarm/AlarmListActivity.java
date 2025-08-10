package com.wear.main.closeRange.alarm;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.closeRange.AlarmListAdapter;
import com.wear.bean.Alarm;
import com.wear.bean.AlarmListItems;
import com.wear.bean.AlarmPattern;
import com.wear.bean.User;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.AlarmDao;
import com.wear.dao.AlarmListDao;
import com.wear.dao.DaoUtils;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.EntityAlarm;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.cs3;
import dc.is3;
import dc.me3;
import dc.q61;
import dc.sg3;
import dc.th4;
import dc.tn2;
import dc.u51;
import dc.ye3;
import dc.zb2;
import dc.zn2;
import dc.zt3;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class AlarmListActivity extends BaseActivity implements View.OnClickListener {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public AlarmListAdapter c;

    @BindView(R.id.create_alarm_image)
    public TextView createAlarmImage;

    @BindView(R.id.create_alarm_top)
    public LinearLayout createAlarmTop;

    @BindView(R.id.create_empty_layout)
    public LinearLayout createEmptyLayout;

    @BindView(R.id.create_tv_text)
    public TextView createTvText;
    public Alarm d;
    public List<AlarmListItems> e = new ArrayList();
    public boolean f = false;
    public Dialog g = null;
    public ProgressDialog h;

    @BindView(R.id.iv_alarm_list_add)
    public ImageView ivAlarmListAdd;

    @BindView(R.id.ll_alarm_permission_tip)
    public LinearLayout llAlarmPermissionTip;

    @BindView(R.id.root_layout)
    public LinearLayout rootLayout;

    @BindView(R.id.rv_alarm_list)
    public RecyclerView rvAlarmList;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            AlarmListActivity alarmListActivity = AlarmListActivity.this;
            alarmListActivity.f = !alarmListActivity.f;
            alarmListActivity.c.notifyDataSetChanged();
            AlarmListActivity alarmListActivity2 = AlarmListActivity.this;
            if (alarmListActivity2.f) {
                alarmListActivity2.createAlarmTop.setVisibility(8);
                AlarmListActivity.this.llAlarmPermissionTip.setVisibility(8);
            } else {
                alarmListActivity2.createAlarmTop.setVisibility(0);
                AlarmListActivity.this.llAlarmPermissionTip.setVisibility(zt3.f() ? 8 : 0);
            }
            AlarmListActivity alarmListActivity3 = AlarmListActivity.this;
            alarmListActivity3.actionbar.setYesActionText(alarmListActivity3.f ? R.string.common_done : R.string.common_delete);
        }
    }

    public class b implements MyActionBar.f {
        public b(AlarmListActivity alarmListActivity) {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            AlarmListActivity alarmListActivity = AlarmListActivity.this;
            if (!alarmListActivity.f) {
                alarmListActivity.finish();
                return;
            }
            alarmListActivity.f = false;
            List<AlarmListItems> list = alarmListActivity.e;
            if (list != null && list.size() > 0) {
                AlarmListActivity.this.createAlarmTop.setVisibility(0);
            }
            AlarmListActivity alarmListActivity2 = AlarmListActivity.this;
            alarmListActivity2.actionbar.setYesActionText(alarmListActivity2.f ? R.string.common_done : R.string.common_delete);
            AlarmListActivity.this.llAlarmPermissionTip.setVisibility(zt3.f() ? 8 : 0);
            AlarmListActivity.this.c.notifyDataSetChanged();
        }
    }

    public class d implements is3.d {
        public final /* synthetic */ AlarmListItems a;

        public d(AlarmListItems alarmListItems) {
            this.a = alarmListItems;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            AlarmListActivity.this.x4(this.a.getId());
            AlarmMessagingService.d(this.a.getId(), true);
            DaoUtils.getAlarmListDao().delT(this.a);
            AlarmListActivity.this.e.remove(this.a);
            AlarmListActivity.this.y4();
            if (AlarmListActivity.this.e.isEmpty()) {
                AlarmListActivity.this.llAlarmPermissionTip.setVisibility(zt3.f() ? 8 : 0);
            } else {
                AlarmListActivity.this.llAlarmPermissionTip.setVisibility(8);
            }
        }
    }

    public class e implements zn2<String> {
        public final /* synthetic */ AlarmPattern a;
        public final /* synthetic */ AlarmListItems b;
        public final /* synthetic */ String c;

        public e(AlarmPattern alarmPattern, AlarmListItems alarmListItems, String str) {
            this.a = alarmPattern;
            this.b = alarmListItems;
            this.c = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws ParseException {
            if (WearUtils.e1(str)) {
                AlarmListActivity.this.h.dismiss();
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (!normalResponse.isResult()) {
                AlarmListActivity.this.h.dismiss();
                sg3.k(AlarmListActivity.this, normalResponse.getMessage());
                this.b.setIsSelected(0);
                DaoUtils.getAlarmListDao().updateOrAdd(this.b);
                return;
            }
            this.a.setAlarmUrl(normalResponse.getMessage());
            DaoUtils.getAlarmPatternDao().updateOrAdd(this.a);
            if (EntityAlarm.AlarmNotiType.fromString(this.b.getNotiType()) == EntityAlarm.AlarmNotiType.pattern) {
                AlarmListActivity.this.h.dismiss();
                AlarmListActivity.this.G4(this.c);
            } else if (EntityAlarm.AlarmNotiType.fromString(this.b.getNotiType()) == EntityAlarm.AlarmNotiType.sound) {
                AlarmListActivity.this.K4(this.c);
            } else {
                AlarmListActivity.this.h.dismiss();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            AlarmListActivity.this.h.dismiss();
            sg3.k(AlarmListActivity.this, netException.getMessage());
        }
    }

    public class f implements zn2<String> {
        public final /* synthetic */ AlarmListItems a;
        public final /* synthetic */ String b;

        public f(AlarmListItems alarmListItems, String str) {
            this.a = alarmListItems;
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws ParseException {
            AlarmListActivity.this.h.dismiss();
            if (WearUtils.e1(str)) {
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (!normalResponse.isResult()) {
                sg3.k(AlarmListActivity.this, normalResponse.getMessage());
                return;
            }
            this.a.setSoundurl(normalResponse.getMessage());
            DaoUtils.getAlarmListDao().updateOrAdd(this.a);
            AlarmListActivity.this.G4(this.b);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            AlarmListActivity.this.h.dismiss();
            sg3.k(AlarmListActivity.this, netException.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C4(boolean z, AlarmListItems alarmListItems) throws ParseException {
        if (!z) {
            alarmListItems.setIsSelected(0);
            alarmListItems.setHaveSnoozeCount(0);
            x4(alarmListItems.getId());
        } else {
            if (!zt3.f()) {
                if (this.llAlarmPermissionTip.getVisibility() == 0) {
                    this.llAlarmPermissionTip.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake_anim));
                    return;
                }
                return;
            }
            alarmListItems.setIsSelected(1);
            alarmListItems.setHaveSnoozeCount(0);
        }
        DaoUtils.getAlarmListDao().updateOrAdd(alarmListItems);
        I4(z, alarmListItems.getId());
        if (z) {
            if (alarmListItems.getFrequency().equals("customer")) {
                alarmListItems.setRingTime(null);
                alarmListItems.setDates(WearUtils.A.toJson(new String[]{be3.i.format(be3.I())}));
                DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
            }
            zt3.t(this.application, alarmListItems.getId(), false, true, true);
        }
        this.c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(List list, boolean z) {
        if (z) {
            H4(true);
        }
    }

    public void D4(int i) {
        Dialog dialog = this.g;
        if (dialog == null || !dialog.isShowing()) {
            if (zt3.f()) {
                E4(this.e.get(i).getId());
            } else if (this.llAlarmPermissionTip.getVisibility() == 0) {
                this.llAlarmPermissionTip.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake_anim));
            }
        }
    }

    public void E4(String str) {
        this.f = false;
        Intent intent = new Intent(this, (Class<?>) AlarmCreateActivity.class);
        intent.putExtra("userId", this.b);
        intent.putExtra("alarm_item_id", str);
        startActivityForResult(intent, 120);
    }

    public void F4(AlarmListItems alarmListItems) {
        String strE = ah4.e(R.string.alarm_delete_notices);
        is3.b bVar = new is3.b(this);
        bVar.p(strE);
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.common_delete));
        bVar.d(new d(alarmListItems));
        is3 is3VarH = cs3.h(bVar);
        this.g = is3VarH;
        is3VarH.show();
    }

    public void G4(String str) throws ParseException {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        if (WearUtils.e1(alarmListItemsFindById.getPatternId())) {
            return;
        }
        AlarmPattern alarmPatternFindById = DaoUtils.getAlarmPatternDao().findById(alarmListItemsFindById.getPatternId());
        if (WearUtils.e1(alarmPatternFindById.getAlarmUrl())) {
            return;
        }
        x4(str);
        EntityAlarm entityAlarm = new EntityAlarm();
        entityAlarm.setId(alarmListItemsFindById.getId());
        entityAlarm.setType(EntityAlarm.AlarmOPTType.pattern.toString());
        entityAlarm.setNotify(alarmListItemsFindById.getNotify());
        entityAlarm.setVersion(alarmListItemsFindById.getVersion());
        entityAlarm.setNotiType(alarmListItemsFindById.getNotiType());
        entityAlarm.setSoundurl(alarmListItemsFindById.getSoundurl());
        entityAlarm.setPattern(alarmListItemsFindById, alarmPatternFindById.getAlarmUrl());
        entityAlarm.getPattern().setTime(alarmListItemsFindById.getTime());
        zb2.O().E0(WearUtils.i0(this.b), entityAlarm, alarmListItemsFindById.getSendTime());
        alarmListItemsFindById.setIsSelected(1);
        DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindById);
        zt3.t(this.application, alarmListItemsFindById.getId(), false, true, true);
        User userV = WearUtils.y.v(this.b);
        if (userV == null || (userV != null && !userV.isOnline())) {
            String strE = ah4.e(R.string.chat_alarm_offline);
            Object[] objArr = new Object[1];
            objArr[0] = userV == null ? "" : userV.getUserName();
            sg3.k(this, String.format(strE, objArr));
        }
        finish();
    }

    public final void H4(boolean z) {
        this.llAlarmPermissionTip.setVisibility(z ? 8 : 0);
        this.createAlarmImage.setEnabled(z);
        this.createAlarmImage.setTextColor(th4.b(this, z ? R.color.alarm_create_text_color_enable : R.color.alarm_create_text_color_disable));
        this.createAlarmTop.setEnabled(z);
        this.ivAlarmListAdd.setImageResource(z ? R.drawable.alarm_list_add : R.drawable.alarm_list_add_disable);
        this.createTvText.setTextColor(th4.b(this, z ? R.color.alarm_list_add_text_color_enable : R.color.alarm_list_add_text_color_disable));
    }

    public void I4(boolean z, String str) {
        AlarmListItems next;
        Iterator<AlarmListItems> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.getId().equals(str)) {
                    break;
                }
            }
        }
        if (next != null) {
            next.setIsSelected(!z ? 0 : 1);
            DaoUtils.getAlarmListDao().update((AlarmListDao) next);
            this.c.notifyDataSetChanged();
        }
    }

    public final void J4(String str) {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        AlarmPattern alarmPatternFindById = DaoUtils.getAlarmPatternDao().findById(alarmListItemsFindById.getPatternId());
        System.out.println("alarmItemId=" + str + "  " + alarmListItemsFindById.getId());
        this.h = ProgressDialog.show(this, "", ah4.e(R.string.common_uploading), false, true);
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/pattern", WearUtils.x0(alarmListItemsFindById.getPatternId()), new HashMap(), new e(alarmPatternFindById, alarmListItemsFindById, str));
    }

    public final void K4(String str) {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/audio", new File(alarmListItemsFindById.getSoundurl()), new HashMap(), new f(alarmListItemsFindById, str));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws ParseException {
        AlarmListItems alarmListItems;
        super.onActivityResult(i, i2, intent);
        if (i == 120 && i2 == -1 && (alarmListItems = (AlarmListItems) intent.getSerializableExtra("item")) != null) {
            alarmListItems.setIsSelected(1);
            DaoUtils.getAlarmListDao().updateOrAdd(alarmListItems);
            AlarmMessagingService.d(alarmListItems.getId(), true);
            if (alarmListItems.getFrequency().equals("customer")) {
                alarmListItems.setRingTime(null);
                alarmListItems.setDates(WearUtils.A.toJson(new String[]{be3.i.format(be3.I())}));
                DaoUtils.getAlarmListDao().update((AlarmListDao) alarmListItems);
            }
            zt3.t(this.application, alarmListItems.getId(), false, true, true);
            if (alarmListItems.getNotify() >= 0) {
                J4(alarmListItems.getId());
            }
            y4();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.create_alarm_image || id == R.id.create_alarm_top) {
            E4(null);
        } else {
            if (id != R.id.ll_alarm_permission_tip) {
                return;
            }
            q61 q61VarM = q61.m(this);
            q61VarM.h("android.permission.SCHEDULE_EXACT_ALARM");
            q61VarM.j(new u51() { // from class: dc.x02
                @Override // dc.u51
                public /* synthetic */ void a(List list, boolean z) {
                    t51.a(this, list, z);
                }

                @Override // dc.u51
                public final void b(List list, boolean z) {
                    this.a.A4(list, z);
                }
            });
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_alarm_list);
        me3.c(me3.c.ALARM_UI_ENTER);
        ye3.c(NotificationCompat.CATEGORY_ALARM, "into page", null);
        ButterKnife.bind(this);
        be3.J();
        EventBus.getDefault().register(this);
        String stringExtra = getIntent().getStringExtra("userId");
        this.b = stringExtra;
        String str = WearUtils.e1(stringExtra) ? "" : this.b;
        this.b = str;
        if (this.mFirebaseAnalytics != null) {
            WearUtils.e1(str);
        }
        String strR = WearUtils.y.r();
        this.a = strR;
        this.a = WearUtils.e1(strR) ? "" : this.a;
        AlarmListAdapter alarmListAdapter = new AlarmListAdapter(this, this.application);
        this.c = alarmListAdapter;
        alarmListAdapter.p(new AlarmListAdapter.d() { // from class: dc.w02
            @Override // com.wear.adapter.closeRange.AlarmListAdapter.d
            public final void a(boolean z, AlarmListItems alarmListItems) throws ParseException {
                this.a.C4(z, alarmListItems);
            }
        });
        this.rvAlarmList.setAdapter(this.c);
        this.rvAlarmList.setLayoutManager(new LinearLayoutManager(this));
        this.createAlarmTop.setOnClickListener(this);
        this.createAlarmImage.setOnClickListener(this);
        this.llAlarmPermissionTip.setOnClickListener(this);
        w4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.ALARM_UI_EXIT);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AlarmListItems alarmListItems) {
        if (alarmListItems != null) {
            y4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Alarm alarmFindAlarm = DaoUtils.getAlarmDao().findAlarm(this.a, this.b);
        this.d = alarmFindAlarm;
        if (alarmFindAlarm == null) {
            Alarm alarm = new Alarm();
            this.d = alarm;
            alarm.setOwnerEmail(this.a);
            this.d.setFriendEmail(this.b);
            this.d.setMessage("");
            DaoUtils.getAlarmDao().add((AlarmDao) this.d);
        }
        y4();
    }

    public final void w4() {
        H4(zt3.f());
    }

    public void x4(String str) {
        AlarmMessagingService.d(str, true);
    }

    public final void y4() {
        List<AlarmListItems> listFindAlarmList = DaoUtils.getAlarmListDao().findAlarmList(this.a);
        this.e = listFindAlarmList;
        if (listFindAlarmList == null || listFindAlarmList.size() == 0) {
            this.createAlarmTop.setVisibility(8);
            this.rvAlarmList.setVisibility(8);
            this.createEmptyLayout.setVisibility(0);
        } else {
            this.createAlarmTop.setVisibility(0);
            this.rvAlarmList.setVisibility(0);
            this.createEmptyLayout.setVisibility(8);
            if (this.f) {
                this.createAlarmTop.setVisibility(8);
            } else {
                this.createAlarmTop.setVisibility(0);
            }
        }
        this.c.notifyDataSetChanged();
        List<AlarmListItems> list = this.e;
        if (list == null || list.size() <= 0) {
            this.actionbar.setYesAction("", new b(this));
        } else {
            this.actionbar.setYesAction(this.f ? R.string.common_done : R.string.common_delete, new a());
        }
        this.actionbar.setBackAction(new c());
    }
}
