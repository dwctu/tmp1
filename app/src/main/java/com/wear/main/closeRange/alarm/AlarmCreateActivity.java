package com.wear.main.closeRange.alarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.AlarmListItems;
import com.wear.bean.AlarmPattern;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.broadcast.AlarmMessagingService;
import com.wear.dao.DaoUtils;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.alarm.AlarmDurationDialog;
import com.wear.main.closeRange.alarm.AlarmSnoozeDialog;
import com.wear.main.longDistance.alarm.AlarmCustomerWeekActivity;
import com.wear.main.longDistance.alarm.SetAlarmActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.main.patterns.SingleChoosePatternsActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.protocol.EntityAlarm;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.be3;
import dc.bf;
import dc.bo3;
import dc.kd0;
import dc.kn3;
import dc.na2;
import dc.pj3;
import dc.q61;
import dc.sg3;
import dc.sr3;
import dc.t51;
import dc.th4;
import dc.tn2;
import dc.u51;
import dc.xe2;
import dc.y02;
import dc.zb2;
import dc.zn2;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class AlarmCreateActivity extends BaseActivity implements View.OnClickListener {
    public String a;

    @BindView(R.id.alarm_message_notification)
    public LinearLayout alarmMessageNotification;

    @BindView(R.id.alarm_message_repeat)
    public LinearLayout alarmMessageRepeat;

    @BindView(R.id.alarm_notify_swith)
    public SwitchView alarmNotifySwith;

    @BindView(R.id.alarm_notify_swith_layout)
    public LinearLayout alarmNotifySwithLayout;

    @BindView(R.id.alarm_title_settings)
    public LinearLayout alarmTitleSettings;
    public String b;

    @BindView(R.id.create_alarm_my_timepicker_view)
    public LinearLayout createAlarmActionOneLayout;

    @BindView(R.id.create_alarm_partner_timepicker_layout)
    public View createAlarmPartnerTimepickerLayout;

    @BindView(R.id.create_alarm_partner_timepicker_view)
    public LinearLayout createAlarmPartnerTimepickerView;
    public Calendar d;

    @BindView(R.id.iv_back)
    public ImageView ivBack;
    public int l;

    @BindView(R.id.ll_alarm_duration)
    public LinearLayout llAlarmDuration;

    @BindView(R.id.ll_alarm_snooze)
    public LinearLayout llAlarmSnooze;
    public int m;
    public int o;
    public String p;

    @BindView(R.id.rootView)
    public LinearLayout rootView;
    public boolean s;

    @BindView(R.id.tab_line)
    public View tabLine;

    @BindView(R.id.tv_alarm_duration)
    public TextView tvAlarmDuration;

    @BindView(R.id.tv_alarm_notification)
    public TextView tvAlarmNotification;

    @BindView(R.id.tv_alarm_repeat)
    public TextView tvAlarmRepeat;

    @BindView(R.id.tv_alarm_snooze)
    public TextView tvAlarmSnooze;

    @BindView(R.id.tv_alarm_title_content)
    public TextView tvAlarmTitleContent;

    @BindView(R.id.tv_my_gtm_time)
    public TextView tvMyGtmTime;

    @BindView(R.id.tv_pattern_gtm_time)
    public TextView tvPatternGtmTime;

    @BindView(R.id.tv_send)
    public TextView tvSend;
    public y02 y;
    public y02 z;
    public String c = "";
    public AlarmPattern e = null;
    public AlarmListItems f = null;
    public boolean g = false;
    public int h = 0;
    public int i = 0;
    public boolean j = true;
    public IPeopleInfo k = null;

    @Nullable
    public boolean n = false;
    public Handler q = new Handler();
    public List<String> t = null;
    public List<List<String>> u = null;
    public List<List<List<String>>> v = null;
    public int w = 0;
    public int x = 0;
    public int A = 0;
    public String B = "";
    public String C = "";

    public class a implements AlarmDurationDialog.c {
        public a() {
        }

        @Override // com.wear.main.closeRange.alarm.AlarmDurationDialog.c
        public void a(AlarmListItems alarmListItems) {
            AlarmCreateActivity alarmCreateActivity = AlarmCreateActivity.this;
            alarmCreateActivity.s = false;
            alarmCreateActivity.U4();
        }
    }

    public class b implements bo3.d {

        public class a implements sr3.c {
            public final /* synthetic */ sr3 a;

            public a(sr3 sr3Var) {
                this.a = sr3Var;
            }

            @Override // dc.sr3.c
            public void a(Toy toy) {
                Intent intent = new Intent(AlarmCreateActivity.this, (Class<?>) CreatePatternActivity.class);
                kd0.b("extras_toy", toy);
                intent.putExtra("is_recording_pattern", 1);
                intent.putExtra("is_create_home", false);
                AlarmCreateActivity.this.startActivity(intent);
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }

        public b() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            if (WearUtils.y.u() == null) {
                pj3.f(AlarmCreateActivity.this, LoginActivity.class);
                AlarmCreateActivity.this.finish();
            } else {
                sr3 sr3Var = new sr3(AlarmCreateActivity.this);
                sr3Var.j(new a(sr3Var));
                sr3Var.show();
            }
        }
    }

    public class c implements bo3.d {
        public c() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            AlarmCreateActivity.this.startActivityForResult(new Intent(AlarmCreateActivity.this, (Class<?>) SingleChoosePatternsActivity.class), 22);
        }
    }

    public class d implements bo3.d {
        public d() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            AlarmCreateActivity.this.P4();
        }
    }

    public class e implements kn3.d {
        public e() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(AlarmCreateActivity.this);
        }
    }

    public class f implements zn2<String> {
        public final /* synthetic */ AlarmPattern a;
        public final /* synthetic */ AlarmListItems b;
        public final /* synthetic */ String c;

        public f(AlarmPattern alarmPattern, AlarmListItems alarmListItems, String str) {
            this.a = alarmPattern;
            this.b = alarmListItems;
            this.c = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                AlarmCreateActivity.this.dismissLoadingProgress();
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (!normalResponse.isResult()) {
                AlarmCreateActivity.this.dismissLoadingProgress();
                sg3.k(AlarmCreateActivity.this, normalResponse.getMessage());
                this.b.setIsSelected(0);
                DaoUtils.getAlarmListDao().updateOrAdd(this.b);
                return;
            }
            this.a.setAlarmUrl(normalResponse.getMessage());
            DaoUtils.getAlarmPatternDao().updateOrAdd(this.a);
            if (EntityAlarm.AlarmNotiType.fromString(this.b.getNotiType()) == EntityAlarm.AlarmNotiType.pattern) {
                AlarmCreateActivity.this.dismissLoadingProgress();
                AlarmCreateActivity.this.Q4(this.c);
            } else if (EntityAlarm.AlarmNotiType.fromString(this.b.getNotiType()) == EntityAlarm.AlarmNotiType.sound) {
                AlarmCreateActivity.this.Y4(this.c);
            } else {
                AlarmCreateActivity.this.dismissLoadingProgress();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            AlarmCreateActivity.this.dismissLoadingProgress();
            sg3.k(AlarmCreateActivity.this, netException.getMessage());
        }
    }

    public class g implements zn2<String> {
        public final /* synthetic */ AlarmListItems a;
        public final /* synthetic */ String b;

        public g(AlarmListItems alarmListItems, String str) {
            this.a = alarmListItems;
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            String str2 = "uploadBitMap result----" + str;
            AlarmCreateActivity.this.dismissLoadingProgress();
            if (WearUtils.e1(str)) {
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (!normalResponse.isResult()) {
                sg3.k(AlarmCreateActivity.this, normalResponse.getMessage());
                return;
            }
            this.a.setSoundurl(normalResponse.getMessage());
            DaoUtils.getAlarmListDao().updateOrAdd(this.a);
            AlarmCreateActivity.this.Q4(this.b);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            AlarmCreateActivity.this.dismissLoadingProgress();
            sg3.k(AlarmCreateActivity.this, netException.getMessage());
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlarmCreateActivity.this.finish();
        }
    }

    public class i implements View.OnClickListener {

        public class a implements u51 {
            public a() {
            }

            @Override // dc.u51
            public /* synthetic */ void a(List list, boolean z) {
                t51.a(this, list, z);
            }

            @Override // dc.u51
            public void b(@NonNull List<String> list, boolean z) throws ParseException {
                if (z) {
                    AlarmCreateActivity.this.E4();
                }
            }
        }

        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws ParseException {
            AlarmCreateActivity alarmCreateActivity = AlarmCreateActivity.this;
            if (alarmCreateActivity.f != null) {
                if (!WearUtils.e1(alarmCreateActivity.a)) {
                    AlarmCreateActivity.this.E4();
                    return;
                }
                q61 q61VarM = q61.m(AlarmCreateActivity.this);
                q61VarM.h("android.permission.SCHEDULE_EXACT_ALARM");
                q61VarM.j(new a());
            }
        }
    }

    public class j extends HashMap<String, String> {
        public j() {
            put("time", AlarmCreateActivity.this.f.getTime());
            put("notificationType", AlarmCreateActivity.this.f.getNotiType());
            put("repeat", AlarmCreateActivity.this.f.getDates());
        }
    }

    public class k extends HashMap<String, String> {
        public k() {
            put("time", AlarmCreateActivity.this.f.getTime());
            put("notificationType", AlarmCreateActivity.this.f.getNotiType());
            put("repeat", AlarmCreateActivity.this.f.getDates());
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlarmCreateActivity alarmCreateActivity = AlarmCreateActivity.this;
            if (alarmCreateActivity.n) {
                return;
            }
            alarmCreateActivity.K4();
            AlarmCreateActivity.this.dismissLoadingProgress();
            AlarmCreateActivity.this.n = true;
        }
    }

    public class m implements bf {
        public m(AlarmCreateActivity alarmCreateActivity) {
        }

        @Override // dc.bf
        public void a(View view) {
            view.findViewById(R.id.top_action_layout).setVisibility(8);
        }
    }

    public class n implements y02.b {
        public n() {
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        @Override // dc.y02.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r7, int r8, int r9, int r10, android.view.View r11) {
            /*
                Method dump skipped, instructions count: 239
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.closeRange.alarm.AlarmCreateActivity.n.a(int, int, int, int, android.view.View):void");
        }

        @Override // dc.y02.b
        public void b() {
            AlarmCreateActivity.this.A = 1;
        }
    }

    public class o implements y02.b {
        public o() {
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x009e  */
        @Override // dc.y02.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r7, int r8, int r9, int r10, android.view.View r11) {
            /*
                Method dump skipped, instructions count: 240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.closeRange.alarm.AlarmCreateActivity.o.a(int, int, int, int, android.view.View):void");
        }

        @Override // dc.y02.b
        public void b() {
            AlarmCreateActivity.this.A = 2;
        }
    }

    public class p implements AlarmSnoozeDialog.a {
        public p() {
        }

        @Override // com.wear.main.closeRange.alarm.AlarmSnoozeDialog.a
        public void a(AlarmListItems alarmListItems) {
            AlarmCreateActivity.this.U4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N4(List list, boolean z) {
        V4();
    }

    public final String B4(String str, int i2) {
        Object objValueOf;
        int iIntValue = Integer.valueOf(str.substring(0, str.indexOf(SignatureImpl.INNER_SEP))).intValue() + 1;
        StringBuilder sb = new StringBuilder();
        if (iIntValue >= 10) {
            objValueOf = Integer.valueOf(iIntValue);
        } else {
            objValueOf = "0" + iIntValue;
        }
        sb.append(objValueOf);
        sb.append(str.substring(str.indexOf(SignatureImpl.INNER_SEP)));
        String string = sb.toString();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            sb2.append(i2 == 0 ? "AM" : "PM");
            return be3.d.format(simpleDateFormat.parse(sb2.toString()));
        } catch (Exception e2) {
            System.out.println("e" + e2);
            return string;
        }
    }

    public final int C4(int i2) {
        if (i2 < 12 || i2 < 13) {
            return i2;
        }
        if (i2 == 24) {
            return 0;
        }
        return i2 - 12;
    }

    public final void D4(String str) {
        Pattern patternK = xe2.L0().K(str);
        this.f.setPatternId(str);
        this.f.setNotiType(EntityAlarm.AlarmNotiType.pattern.toString());
        if (patternK != null) {
            this.e = new AlarmPattern(patternK);
        }
        I4();
    }

    public final void E4() throws ParseException {
        boolean z;
        this.f.setHaveSnoozeCount(0);
        this.f.setFrequency(SetAlarmActivity.v.get(Integer.valueOf(this.o)));
        int i2 = this.o;
        if (i2 == R.id.touch_once) {
            this.f.setDates(WearUtils.A.toJson(new String[]{this.p}));
        } else {
            this.f.setDates(WearUtils.A.toJson(SetAlarmActivity.w.get(Integer.valueOf(i2))));
        }
        if (EntityAlarm.AlarmNotiType.fromString(this.f.getNotiType()) == EntityAlarm.AlarmNotiType.pattern) {
            if (this.e != null) {
                DaoUtils.getAlarmPatternDao().addIfNotExist(this.e);
                z = true;
            }
            z = false;
        } else {
            if (EntityAlarm.AlarmNotiType.fromString(this.f.getNotiType()) == EntityAlarm.AlarmNotiType.sound) {
                if (!WearUtils.e1(this.c)) {
                    Pattern pattern = new Pattern();
                    pattern.setId(this.f.getPatternId());
                    pattern.setName(ah4.e(R.string.closeRange_sound));
                    if (WearUtils.y.u() == null || WearUtils.e1(WearUtils.y.r())) {
                        pattern.setEmail("");
                        pattern.setCreator("");
                        pattern.setAuthor("");
                    } else {
                        pattern.setEmail(WearUtils.y.r());
                        pattern.setCreator(WearUtils.y.r());
                        pattern.setAuthor(WearUtils.y.u().getUserName());
                    }
                    pattern.setTimer(this.c);
                    pattern.setToyFunc(PSOProgramService.VS_Key);
                    this.e = new AlarmPattern(pattern);
                    DaoUtils.getAlarmPatternDao().addIfNotExist(this.e);
                } else if (this.e != null) {
                }
                z = true;
            }
            z = false;
        }
        if (!z && this.f.getReceiveFlag() == 0) {
            sg3.i(this, R.string.alarm_audio_file_error);
            return;
        }
        this.f.setAlarmTitle(this.tvAlarmTitleContent.getText().toString());
        if (WearUtils.e1(this.a)) {
            this.f.setNotify(-1);
        } else {
            this.f.setNotify(this.alarmNotifySwith.isChecked() ? 1 : 0);
        }
        if (this.g) {
            this.f.setTime(this.B);
            this.f.setSendTime(this.C);
        } else {
            this.f.setTime(B4(this.B, this.h));
            this.f.setSendTime(B4(this.C, this.i));
        }
        try {
            Date date = be3.j.parse(this.p + " " + this.f.getTime().trim());
            if (be3.B(be3.I(), date, 0) && this.o == R.id.touch_once) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(5, 1);
                String str = be3.i.format(calendar.getTime());
                this.p = str;
                this.f.setDates(WearUtils.A.toJson(new String[]{str}));
            }
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        if (WearUtils.e1(this.a)) {
            addAnalyticsEventId("alarm_local", new j());
        } else {
            addAnalyticsEventId("alarm_longDistance", new k());
        }
        this.f.setIsSelected(1);
        Intent intent = new Intent();
        intent.putExtra("alarmItemId", this.f.getId());
        intent.putExtra("item", this.f);
        setResult(-1, intent);
        if (this.f.getNotify() < 0) {
            finish();
        } else {
            DaoUtils.getAlarmListDao().updateOrAdd(this.f);
            X4(this.f.getId());
        }
    }

    public final y02 F4(ViewGroup viewGroup, y02.b bVar) {
        y02.a aVar = new y02.a(this, bVar);
        aVar.W(true);
        aVar.U(this.g);
        aVar.V(this.j);
        aVar.R(true, true, false);
        aVar.S(viewGroup);
        aVar.X(R.layout.options_pickerview_custom_time, new m(this));
        aVar.T(th4.b(this, R.color.bg));
        aVar.N(false);
        aVar.Y(false);
        aVar.Y(false);
        aVar.P(th4.b(this, R.color.bg));
        aVar.Q(20);
        aVar.Z(th4.b(this, R.color.text_color_85));
        aVar.a0(th4.b(this, R.color.text_color_45));
        y02 y02Var = new y02(aVar);
        y02Var.D(this.t, this.u, this.v);
        y02Var.v(false);
        return y02Var;
    }

    public void G4(String str) {
        AlarmMessagingService.d(str, true);
    }

    public final int H4() {
        IPeopleInfo iPeopleInfo = this.k;
        return (iPeopleInfo == null || iPeopleInfo.isGroup()) ? Integer.valueOf(be3.o()).intValue() : Integer.valueOf(((User) this.k).getFriendGTMTime()).intValue();
    }

    public final void I4() {
        if (this.e == null && !WearUtils.e1(this.f.getPatternId())) {
            this.e = DaoUtils.getAlarmPatternDao().findById(this.f.getPatternId());
        }
        if (this.e != null) {
            if (EntityAlarm.AlarmNotiType.fromString(this.f.getNotiType()) == EntityAlarm.AlarmNotiType.pattern) {
                this.tvAlarmNotification.setText(this.e.getName());
                if (this.s) {
                    this.f.setDuration((int) WearUtils.K0(this.e.getTimer()));
                }
            } else {
                this.tvAlarmNotification.setText(ah4.e(R.string.closeRange_sound) + " ," + this.e.getTimer());
                if (this.s) {
                    this.f.setDuration((int) WearUtils.K0(this.e.getTimer()));
                }
            }
        } else if ("pattern".equals(this.f.getNotiType())) {
            this.tvAlarmNotification.setText(ah4.e(R.string.main_patterns));
            if (this.s && !TextUtils.isEmpty(this.f.getReveiveFilePath())) {
                this.f.setDuration(WearUtils.n0(this.f.getReveiveFilePath()) / 10);
            }
        } else if ("sound".equals(this.f.getNotiType())) {
            if (TextUtils.isEmpty(this.c)) {
                this.c = WearUtils.I0(WearUtils.n0(this.f.getReveiveFilePath()) / 10);
            }
            if (this.s) {
                this.f.setDuration((int) WearUtils.K0(this.c));
            }
            this.tvAlarmNotification.setText(ah4.e(R.string.closeRange_sound) + " ," + this.c);
        } else {
            this.tvAlarmNotification.setText(ah4.e(R.string.alarm_defind_repeat_None));
        }
        U4();
    }

    public final void J4() {
        this.g = false;
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        boolean z = this.g;
        int i2 = z ? 23 : 12;
        for (int i3 = !z ? 1 : 0; i3 <= i2; i3++) {
            if (i3 < 10) {
                this.t.add("0" + i3);
            } else {
                this.t.add("" + i3);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i4 = 0; i4 <= 59; i4++) {
                if (i4 < 10) {
                    arrayList.add("0" + i4);
                } else {
                    arrayList.add("" + i4);
                }
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(ah4.e(R.string.app_hourformat_12_am));
                arrayList3.add(ah4.e(R.string.app_hourformat_12_pm));
                arrayList2.add(arrayList3);
            }
            this.u.add(arrayList);
            this.v.add(arrayList2);
        }
    }

    public final void K4() {
        Object objValueOf;
        Object objValueOf2;
        Object objValueOf3;
        Object objValueOf4;
        String string;
        this.y = F4(this.createAlarmActionOneLayout, new n());
        this.w = Integer.valueOf(be3.q.format(this.d.getTime())).intValue();
        int iIntValue = Integer.valueOf(be3.r.format(this.d.getTime())).intValue();
        this.h = 0;
        if (!this.g) {
            this.h = L4(this.w) ? 1 : 0;
            int iC4 = C4(this.w) - 1;
            this.w = iC4;
            if (iC4 < 0) {
                this.w = 11;
            }
        }
        this.y.E(this.w, iIntValue, this.h);
        StringBuilder sb = new StringBuilder();
        int i2 = this.w;
        if (i2 >= 10) {
            objValueOf = Integer.valueOf(i2);
        } else {
            objValueOf = "0" + this.w;
        }
        sb.append(objValueOf);
        sb.append(SignatureImpl.INNER_SEP);
        if (iIntValue >= 10) {
            objValueOf2 = Integer.valueOf(iIntValue);
        } else {
            objValueOf2 = "0" + iIntValue;
        }
        sb.append(objValueOf2);
        this.B = sb.toString();
        this.l = Integer.valueOf(be3.o()).intValue();
        TextView textView = this.tvMyGtmTime;
        String strE = ah4.e(R.string.alarm_list_gtm);
        Object[] objArr = new Object[1];
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.l >= 0 ? "+" : "");
        sb2.append(this.l);
        objArr[0] = sb2.toString();
        textView.setText(String.format(strE, objArr));
        this.z = F4(this.createAlarmPartnerTimepickerView, new o());
        this.m = -13;
        Calendar calendar = Calendar.getInstance();
        if (WearUtils.e1(this.a)) {
            calendar.setTime(this.d.getTime());
        } else {
            int iH4 = H4();
            this.m = iH4;
            calendar.setTime(be3.p(iH4, this.d.getTime()));
        }
        this.x = Integer.valueOf(be3.q.format(calendar.getTime())).intValue();
        int iIntValue2 = Integer.valueOf(be3.r.format(calendar.getTime())).intValue();
        this.i = 0;
        if (!this.g) {
            this.i = L4(this.x) ? 1 : 0;
            int iC42 = C4(this.x) - 1;
            this.x = iC42;
            if (iC42 < 0) {
                this.x = 11;
            }
        }
        this.z.E(this.x, iIntValue2, this.i);
        StringBuilder sb3 = new StringBuilder();
        int i3 = this.x;
        if (i3 >= 10) {
            objValueOf3 = Integer.valueOf(i3);
        } else {
            objValueOf3 = "0" + this.x;
        }
        sb3.append(objValueOf3);
        sb3.append(SignatureImpl.INNER_SEP);
        if (iIntValue2 >= 10) {
            objValueOf4 = Integer.valueOf(iIntValue2);
        } else {
            objValueOf4 = "0" + iIntValue2;
        }
        sb3.append(objValueOf4);
        this.C = sb3.toString();
        TextView textView2 = this.tvPatternGtmTime;
        String strE2 = ah4.e(R.string.alarm_list_gtm);
        Object[] objArr2 = new Object[1];
        if (this.m == -13) {
            string = be3.o();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.m < 0 ? "" : "+");
            sb4.append(this.m);
            string = sb4.toString();
        }
        objArr2[0] = string;
        textView2.setText(String.format(strE2, objArr2));
    }

    public final boolean L4(int i2) {
        return i2 >= 12 && (i2 < 13 || i2 != 24);
    }

    public final int O4() {
        return this.g ? 24 : 12;
    }

    public final void P4() {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.RECORD_AUDIO");
        q61VarM.j(new u51() { // from class: dc.v02
            @Override // dc.u51
            public /* synthetic */ void a(List list, boolean z) {
                t51.a(this, list, z);
            }

            @Override // dc.u51
            public final void b(List list, boolean z) {
                this.a.N4(list, z);
            }
        });
    }

    public void Q4(String str) {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        if (WearUtils.e1(alarmListItemsFindById.getPatternId())) {
            return;
        }
        AlarmPattern alarmPatternFindById = DaoUtils.getAlarmPatternDao().findById(alarmListItemsFindById.getPatternId());
        if (WearUtils.e1(alarmPatternFindById.getAlarmUrl())) {
            return;
        }
        G4(str);
        EntityAlarm entityAlarm = new EntityAlarm();
        entityAlarm.setId(alarmListItemsFindById.getId());
        entityAlarm.setType(EntityAlarm.AlarmOPTType.pattern.toString());
        entityAlarm.setNotify(alarmListItemsFindById.getNotify());
        entityAlarm.setName(alarmListItemsFindById.getAlarmTitle());
        entityAlarm.setVersion(alarmListItemsFindById.getVersion());
        entityAlarm.setNotiType(alarmListItemsFindById.getNotiType());
        entityAlarm.setSoundurl(alarmListItemsFindById.getSoundurl());
        entityAlarm.setMsgId(pj3.b());
        entityAlarm.setPattern(alarmListItemsFindById, alarmPatternFindById.getAlarmUrl());
        entityAlarm.getPattern().setTime(alarmListItemsFindById.getTime());
        if (this.k.isGroup()) {
            zb2.O().H0(this.k.getUserJid(), entityAlarm, true, false, null);
        } else {
            zb2.O().E0(WearUtils.i0(this.a), entityAlarm, alarmListItemsFindById.getSendTime());
        }
        alarmListItemsFindById.setIsSelected(1);
        DaoUtils.getAlarmListDao().updateOrAdd(alarmListItemsFindById);
        User userV = WearUtils.y.v(this.a);
        if ((userV == null || (userV != null && !userV.isOnline())) && userV != null && !userV.isDeleteByFriend() && !userV.isDateIng() && !WearUtils.x.i.D(WearUtils.i0(userV.getId()), true)) {
            String strE = ah4.e(R.string.chat_alarm_offline);
            Object[] objArr = new Object[1];
            objArr[0] = userV == null ? "" : userV.getUserName();
            sg3.k(this, String.format(strE, objArr));
        }
        setResult(-1, new Intent());
        finish();
    }

    public final void R4() {
        AlarmDurationDialog alarmDurationDialog = new AlarmDurationDialog(this, this.f);
        alarmDurationDialog.show();
        alarmDurationDialog.c(new a());
    }

    public final void S4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_toy_pattern);
        bo3Var.show();
        bo3Var.d(R.id.touch_record, new b());
        bo3Var.d(R.id.touch_selects, new c());
        ((TextView) bo3Var.a(R.id.touch_selects)).setText(ah4.e(R.string.message_notification_type_pattern));
        bo3Var.a(R.id.touch_record).setVisibility(8);
        bo3Var.a(R.id.touch_audio).setVisibility(0);
        bo3Var.d(R.id.touch_audio, new d());
        bo3Var.d(R.id.touch_cancel, null);
    }

    public final void T4() {
        AlarmSnoozeDialog alarmSnoozeDialog = new AlarmSnoozeDialog(this, this.f);
        alarmSnoozeDialog.show();
        alarmSnoozeDialog.b(new p());
    }

    public final void U4() {
        String str;
        if (this.f.getDuration() > 0) {
            this.tvAlarmDuration.setText(be3.k(this.f.getDuration()));
        } else {
            this.tvAlarmDuration.setText("");
        }
        if (this.f.getSnoozeCount() <= 0) {
            this.tvAlarmSnooze.setText(ah4.e(R.string.str_alarm_never_snooze));
            return;
        }
        String str2 = ah4.e(R.string.str_alarm_count) + SignatureImpl.INNER_SEP + this.f.getSnoozeCount();
        if (this.f.getSnoozeDuration() > 0) {
            str = str2 + "," + ah4.e(R.string.str_duration) + SignatureImpl.INNER_SEP + this.f.getSnoozeDuration() + ah4.e(R.string.str_alarm_minute);
        } else {
            str = str2 + "," + ah4.e(R.string.str_duration) + ":1" + ah4.e(R.string.str_alarm_minute);
        }
        this.tvAlarmSnooze.setText(str);
    }

    public void V4() {
        if (na2.m().t()) {
            return;
        }
        startActivityForResult(new Intent(this, (Class<?>) AlarmSoundPlayActivity.class), 1655);
    }

    public final void W4() throws ParseException {
        Date date;
        Calendar calendar = Calendar.getInstance();
        this.d = calendar;
        calendar.setTime(be3.I());
        if (WearUtils.e1(this.a)) {
            this.createAlarmPartnerTimepickerLayout.setVisibility(8);
            this.alarmNotifySwithLayout.setVisibility(8);
            this.alarmTitleSettings.setVisibility(0);
            this.alarmTitleSettings.setOnClickListener(this);
            this.llAlarmDuration.setVisibility(0);
            this.llAlarmSnooze.setVisibility(0);
        } else {
            this.alarmTitleSettings.setVisibility(0);
            this.alarmTitleSettings.setOnClickListener(this);
            this.llAlarmDuration.setVisibility(8);
            this.llAlarmSnooze.setVisibility(8);
            if (this.k.isGroup()) {
                this.createAlarmPartnerTimepickerLayout.setVisibility(8);
                this.alarmNotifySwithLayout.setVisibility(8);
            }
        }
        if (WearUtils.e1(this.b)) {
            this.d.add(12, 5);
            AlarmListItems alarmListItems = new AlarmListItems();
            this.f = alarmListItems;
            alarmListItems.setId(WearUtils.E());
            this.f.setIsSelected(1);
            this.f.setFriendEmail(this.a);
            this.f.setOwnerEmail(WearUtils.y.r());
            this.f.setPatternId(null);
            this.f.setSoundurl(null);
            this.f.setTime(be3.d.format(this.d.getTime()));
            this.f.setNotify(-1);
            this.f.setVersion(1);
            this.f.setAlarmTitle("");
            this.o = R.id.touch_once;
            this.f.setFrequency(SetAlarmActivity.v.get(Integer.valueOf(R.id.touch_once)));
        } else {
            AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(this.b);
            this.f = alarmListItemsFindById;
            try {
                String[] strArr = WearUtils.e1(alarmListItemsFindById.getDates()) ? null : (String[]) WearUtils.A.fromJson(this.f.getDates(), String[].class);
                if (strArr == null || WearUtils.e1(this.f.getTime()) || !WearUtils.Z0(strArr[0])) {
                    date = be3.j.parse(be3.i.format(this.d.getTime()) + " " + this.f.getTime().trim());
                    if (strArr != null && SetAlarmActivity.F4(this.f.getFrequency()) == R.id.touch_costomer_week) {
                        SetAlarmActivity.w.put(Integer.valueOf(R.id.touch_costomer_week), strArr);
                    }
                } else {
                    date = be3.j.parse(strArr[0].trim() + " " + this.f.getTime().trim());
                }
                this.d.set(1, Integer.valueOf(be3.n.format(date)).intValue());
                this.d.set(2, Integer.valueOf(be3.o.format(date)).intValue() - 1);
                this.d.set(5, Integer.valueOf(be3.p.format(date)).intValue());
                this.d.set(11, Integer.valueOf(be3.q.format(date)).intValue());
                this.d.set(12, Integer.valueOf(be3.r.format(date)).intValue());
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            this.o = SetAlarmActivity.F4(this.f.getFrequency());
        }
        this.s = false;
        I4();
        J4();
        this.tvAlarmRepeat.setText(SetAlarmActivity.K4(this.f.getFrequency(), this.f.getDates()));
        this.p = be3.i.format(this.d.getTime());
        String alarmTitle = this.f.getAlarmTitle();
        if (WearUtils.e1(alarmTitle)) {
            alarmTitle = ah4.e(R.string.message_notification_type_alarm);
        }
        this.tvAlarmTitleContent.setText(alarmTitle);
        this.alarmMessageNotification.setOnClickListener(this);
        this.alarmMessageRepeat.setOnClickListener(this);
        this.llAlarmDuration.setOnClickListener(this);
        this.llAlarmSnooze.setOnClickListener(this);
        this.alarmNotifySwith.setChecked(this.f.getNotify() > 0);
        this.s = true;
        U4();
    }

    public void X4(String str) {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        AlarmPattern alarmPatternFindById = DaoUtils.getAlarmPatternDao().findById(alarmListItemsFindById.getPatternId());
        showLoadingProgress();
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/pattern", WearUtils.x0(alarmListItemsFindById.getPatternId()), new HashMap(), new f(alarmPatternFindById, alarmListItemsFindById, str));
    }

    public final void Y4(String str) {
        AlarmListItems alarmListItemsFindById = DaoUtils.getAlarmListDao().findById(str);
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/audio", new File(alarmListItemsFindById.getSoundFileath()), new HashMap(), new g(alarmListItemsFindById, str));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 22) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("choose_patterns");
                if (WearUtils.e1(stringExtra) || xe2.L0().K(stringExtra) == null) {
                    return;
                }
                D4(stringExtra);
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
                D4(stringExtra2);
                return;
            }
            return;
        }
        if (i2 == 153) {
            if (intent != null) {
                this.o = R.id.touch_costomer_week;
                String[] stringArrayExtra = intent.getStringArrayExtra("dates");
                if (stringArrayExtra != null) {
                    SetAlarmActivity.w.put(Integer.valueOf(R.id.touch_costomer_week), stringArrayExtra);
                }
                this.tvAlarmRepeat.setText(SetAlarmActivity.K4(SetAlarmActivity.v.get(Integer.valueOf(this.o)), WearUtils.A.toJson(SetAlarmActivity.w.get(Integer.valueOf(this.o)))));
                return;
            }
            return;
        }
        if (i2 == 1088) {
            if (i3 == -1) {
                boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
                intent.getIntArrayExtra("grant_results");
                if (booleanExtra) {
                    V4();
                    return;
                } else {
                    new kn3((Context) this, ah4.e(R.string.app_open_must_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new e()).show();
                    return;
                }
            }
            return;
        }
        if (i2 != 1655) {
            if (i2 == 4198 && i3 == -1 && intent != null && intent.getStringExtra(MessageBundle.TITLE_ENTRY) != null) {
                this.tvAlarmTitleContent.setText(intent.getStringExtra(MessageBundle.TITLE_ENTRY));
                return;
            }
            return;
        }
        if (intent != null) {
            String stringExtra3 = intent.getStringExtra("alarm_pattern_id");
            String stringExtra4 = intent.getStringExtra("alarm_sound_path");
            this.c = intent.getStringExtra("alarm_item_times");
            this.f.setPatternId(stringExtra3);
            this.f.setSoundurl(stringExtra4);
            this.f.setSoundFileath(stringExtra4);
            this.f.setNotiType(EntityAlarm.AlarmNotiType.sound.toString());
            DaoUtils.getAlarmListDao().updateOrAdd(this.f);
            this.e = DaoUtils.getAlarmPatternDao().findById(this.f.getPatternId());
            I4();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alarm_message_notification /* 2131362051 */:
                S4();
                break;
            case R.id.alarm_message_repeat /* 2131362052 */:
                if (this.o != R.id.touch_costomer_week) {
                    pj3.o(this, AlarmCustomerWeekActivity.class, 153);
                    break;
                } else {
                    Intent intent = new Intent(this, (Class<?>) AlarmCustomerWeekActivity.class);
                    intent.putExtra("dates", SetAlarmActivity.w.get(Integer.valueOf(R.id.touch_costomer_week)));
                    startActivityForResult(intent, 153);
                    break;
                }
            case R.id.alarm_title_settings /* 2131362063 */:
                pj3.q(this, EditAlarmNameActivity.class, 4198, MessageBundle.TITLE_ENTRY, this.tvAlarmTitleContent.getText().toString());
                break;
            case R.id.ll_alarm_duration /* 2131363428 */:
                R4();
                break;
            case R.id.ll_alarm_snooze /* 2131363430 */:
                T4();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws ParseException {
        String strE;
        super.onCreate(bundle);
        setContentView(R.layout.activity_alarm_create);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("userId");
        this.a = stringExtra;
        String str = WearUtils.e1(stringExtra) ? "" : this.a;
        this.a = str;
        this.k = WearUtils.y.s(str);
        this.b = intent.getStringExtra("alarm_item_id");
        ah4.e(R.string.common_save);
        if (TextUtils.isEmpty(this.a)) {
            strE = ah4.e(R.string.common_save);
            this.tvSend.setBackgroundResource(R.color.transparent);
            this.tvSend.setTextColor(th4.b(this, R.color.text_color_85));
            this.tabLine.setVisibility(0);
        } else {
            strE = ah4.e(R.string.common_send);
            this.tvSend.setBackgroundResource(R.drawable.new_ui_round_red_button);
            this.tvSend.setTextColor(ContextCompat.getColor(this, R.color.white));
            if (this.k == null) {
                finish();
                return;
            }
            this.tabLine.setVisibility(8);
        }
        this.tvSend.setText(strE);
        this.ivBack.setOnClickListener(new h());
        this.tvSend.setOnClickListener(new i());
        be3.J();
        W4();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        EventBus.getDefault().unregister(this);
        dismissLoadingProgress();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        finish();
        return true;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.n) {
            showLoadingProgress();
        }
        this.q.postDelayed(new l(), 800L);
    }
}
