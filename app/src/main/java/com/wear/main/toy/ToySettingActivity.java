package com.wear.main.toy;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Setting;
import com.wear.bean.Toy;
import com.wear.bean.ToyLedBean;
import com.wear.bean.ToyType;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.main.toy.newtoy.MyToyAdapter;
import com.wear.main.toy.pin.ToyPinSettingActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import com.wear.widget.roundwidget.SkinRoundView;
import dc.ah4;
import dc.ce3;
import dc.db2;
import dc.ek2;
import dc.fk2;
import dc.fq1;
import dc.h32;
import dc.hs3;
import dc.jr1;
import dc.kc0;
import dc.ke3;
import dc.kn3;
import dc.lp1;
import dc.me0;
import dc.me3;
import dc.na2;
import dc.og3;
import dc.pc1;
import dc.pj3;
import dc.re3;
import dc.rp1;
import dc.rq1;
import dc.sg3;
import dc.sr1;
import dc.vg3;
import dc.vl2;
import dc.vr1;
import dc.wc1;
import dc.wi2;
import dc.xb1;
import dc.xc1;
import dc.ye3;
import dc.zt3;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* loaded from: classes3.dex */
public class ToySettingActivity extends BaseActivity<vl2> implements hs3.b {
    public static String k = "dly";
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public LinkedHashMap<Integer, ToyLedBean> b = new a();
    public pc1 c = null;
    public Toy d;

    @BindView(R.id.delete_toy)
    public TextView deleteToy;
    public hs3 e;
    public MyApplication f;
    public Setting g;
    public ToyType h;
    public boolean i;

    @BindView(R.id.iv_depth_control)
    public ImageView ivDepthControl;

    @BindView(R.id.iv_fun_red_dot)
    public View ivFunRedDot;

    @BindView(R.id.iv_pin_control)
    public ImageView ivPinControl;

    @BindView(R.id.iv_pin_control_status)
    public ImageView ivPinControlStatus;

    @BindView(R.id.v_threshold_top)
    public ImageView ivThreshold;
    public boolean j;

    @BindView(R.id.ll_setting_led_layout)
    public LinearLayout llSettingLedLayout;

    @BindView(R.id.ll_setting_toy_reconnect)
    public LinearLayout llSettingToyReconnect;

    @BindView(R.id.rl_depth_control)
    public RelativeLayout rlDepthControl;

    @BindView(R.id.rl_led_color)
    public RelativeLayout rlLedColor;

    @BindView(R.id.rl_pin_control)
    public RelativeLayout rlPinControl;

    @BindView(R.id.rl_toy_upload)
    public RelativeLayout rlToyUpload;

    @BindView(R.id.round_view_setting_tip)
    public SkinRoundView roundViewSettingTip;

    @BindView(R.id.setting_auto_swith)
    public SwitchView settingAutoSwith;

    @BindView(R.id.setting_function)
    public ConstraintLayout settingFunction;

    @BindView(R.id.setting_led_switch)
    public SwitchView settingLedSwitch;

    @BindView(R.id.setting_led_title)
    public TextView settingLedTitle;

    @BindView(R.id.setting_name)
    public RelativeLayout settingName;

    @BindView(R.id.setting_program)
    public RelativeLayout settingProgram;

    @BindView(R.id.setting_program_title)
    public TextView settingProgramTitle;

    @BindView(R.id.setting_run_lastLevel)
    public SwitchView settingRunLastLevel;

    @BindView(R.id.setting_serial_num)
    public RelativeLayout settingSerialNum;

    @BindView(R.id.setting_sex_machine_uplift)
    public RelativeLayout settingSexMachineUplift;

    @BindView(R.id.setting_sex_machine_uplift_title)
    public TextView settingSexMachineUpliftTitle;

    @BindView(R.id.setting_strength)
    public RelativeLayout settingStrength;

    @BindView(R.id.setting_strength_title)
    public TextView settingStrengthTitle;

    @BindView(R.id.setting_threshold)
    public RelativeLayout settingThreshold;

    @BindView(R.id.setting_threshold_title)
    public TextView settingThresholdTitle;

    @BindView(R.id.sex_machine_new_feature_dot)
    public ImageView sexMachineNewFeatureDot;

    @BindView(R.id.toy_reName)
    public TextView toyReName;

    @BindView(R.id.toy_up_to_date)
    public TextView toyUpToDate;

    @BindView(R.id.toy_update)
    public TextView toyUpdate;

    @BindView(R.id.tv_curr_mode)
    public TextView tvCurrMode;

    @BindView(R.id.tv_depth_control)
    public TextView tvDepthControl;

    @BindView(R.id.tv_depth_control_status)
    public TextView tvDepthControlStatus;

    @BindView(R.id.tv_led_color)
    public TextView tvLedColor;

    @BindView(R.id.tv_led_color_left)
    public TextView tvLedColorLeft;

    @BindView(R.id.tv_pin_control)
    public TextView tvPinControl;

    @BindView(R.id.tv_pin_control_status)
    public TextView tvPinControlStatus;

    @BindView(R.id.tv_toy_disconnect_show)
    public TextView tvToyDisconnectShow;

    @BindView(R.id.tv_toy_firmware)
    public TextView tvToyFirmware;

    @BindView(R.id.tv_toy_last_leven)
    public TextView tvToyLastLeven;

    @BindView(R.id.tv_toy_turn_off)
    public TextView tvToyTurnOff;

    @BindView(R.id.v_auto_swith)
    public View vAutoSwith;

    @BindView(R.id.v_depth_control_top)
    public ImageView vDepthControlTop;

    @BindView(R.id.v_led_color)
    public View vLedColor;

    @BindView(R.id.v_led_color_top)
    public ImageView vLedColorTop;

    @BindView(R.id.v_led_switch)
    public View vLedSwitch;

    @BindView(R.id.v_pin_control_top)
    public ImageView vPinControlTop;

    @BindView(R.id.v_run_lastLevel)
    public View vRunLastLevel;

    @BindView(R.id.v_setting_function_top)
    public ImageView vSettingFunctionTop;

    @BindView(R.id.v_setting_program_top)
    public ImageView vSettingProgramTop;

    public class a extends LinkedHashMap<Integer, ToyLedBean> {
        public a() {
            put(7, new ToyLedBean(ah4.e(R.string.multicolor), 0, 7));
            put(5, new ToyLedBean(ah4.e(R.string.pink), -47689, 5));
            put(1, new ToyLedBean(ah4.e(R.string.red), -319688, 1));
            put(3, new ToyLedBean(ah4.e(R.string.blue), -15718401, 3));
            put(2, new ToyLedBean(ah4.e(R.string.green), -14555341, 2));
            put(4, new ToyLedBean(ah4.e(R.string.yellow), -596698, 4));
            put(6, new ToyLedBean(ah4.e(R.string.turquoise), -12524053, 6));
        }
    }

    public class b implements kn3.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public class a extends HashMap<String, String> {
            public final /* synthetic */ String val$finalDeviceType;

            public a(String str) {
                this.val$finalDeviceType = str;
                put("count", "" + ToySettingActivity.this.c.o().size());
                put("type", str);
            }
        }

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            ToySettingActivity.this.c.resetBleParams();
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            rq1.d.r(this.a);
            Toy toyQ = ToySettingActivity.this.f.G().Q(this.a);
            if (toyQ == null) {
                return;
            }
            ToySettingActivity.this.f.G().E(toyQ);
            toyQ.setDisConnectType(1);
            toyQ.setRealDeviceType(false);
            toyQ.setIsLongRange(0);
            ToySettingActivity.this.f.G().a0(toyQ.getAddress(), true);
            vg3.b().a(new Runnable() { // from class: dc.vh2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
            ToySettingActivity.this.c.p0(true);
            re3.u(toyQ);
            rp1.h(toyQ);
            ToySettingActivity.this.addAnalyticsEventId("toy_remove", new a(toyQ.getDeviceType()));
            db2.A().P();
            h32.i().z();
            wi2.e().f("ToySettingActivity.delToy()-->toyId:" + this.a + ", toyName:" + this.b);
            me3.g();
            ToySettingActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N4(View view) {
        C4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P4(View view) {
        G4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R4(View view) {
        F4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T4(View view) {
        w4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V4(View view) {
        z4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X4(View view) {
        x4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z4(View view) {
        v4(this.d.getAddress(), this.d.getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b5(View view) {
        y4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d5(View view) {
        D4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f5(View view) {
        B4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h5(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        H4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j5(View view) {
        I4(this.settingLedSwitch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l5(View view) {
        I4(this.settingRunLastLevel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n5(CompoundButton compoundButton, boolean z) {
        E4(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p5(View view) {
        I4(this.settingAutoSwith);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r5(CompoundButton compoundButton, boolean z) {
        A4(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t5(CompoundButton compoundButton, boolean z) {
        ye3.k("toys", "enable_led_click", "click", "enable_led", "button", z ? "open" : Close.ELEMENT, "", -1L, this.d.getAddress());
        this.h.setAutoLightOn(Boolean.valueOf(z));
        DaoUtils.getToyTypeDao().update(this.h);
        if (this.d.getType().equals("domi")) {
            sr1.d(this.d.getAddress(), z);
        } else {
            sr1.e(this.d.getAddress(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v5(CompoundButton compoundButton, boolean z) {
        ye3.k("toys", "enable_led_click", "click", "enable_led", "button", z ? "open" : Close.ELEMENT, "", -1L, this.d.getAddress());
        Toy toy = this.d;
        if (toy == null || !this.c.a(toy.getAddress())) {
            return;
        }
        this.c.Q(this.d.getAddress()).setLed(z ? 1 : 0);
        sr1.e(this.d.getAddress(), z);
        this.d.setLedSetting(Integer.valueOf(z ? 1 : 0));
        DaoUtils.getToyDao().updateLedSetting(this.d.getAddress(), z ? 1 : 0);
    }

    public final void A4(boolean z) {
        ye3.k("toys", "stop_vibrating_click", "click", "stop_vibrating", "button", z ? "open" : Close.ELEMENT, "", -1L, this.d.getAddress());
        this.g.setAutoSwithOff(this.a, Boolean.valueOf(z));
        fq1.d(this.d.getAddress(), z, this.g.getAutoLastLevel(this.d.getAddress()).booleanValue());
        DaoUtils.getSettingDao().update((SettingDao) this.g);
    }

    public final void A5(boolean z) {
        this.settingLedSwitch.setEnabled(z);
    }

    public final void B4() {
        if (!this.d.isConnected()) {
            sg3.h(R.string.toy_settings_no_toy_toast);
        } else {
            pj3.j(this, ToyFunctionActivity.class, "toy_function_address_Id", this.d.getAddress());
            me0.k(MyToyAdapter.D.a(), true);
        }
    }

    public final void B5() {
        if (ke3.b("new_feature", "toy_strength_setting", false)) {
            this.roundViewSettingTip.setVisibility(0);
        } else {
            this.roundViewSettingTip.setVisibility(8);
        }
    }

    public final void C4() {
        ye3.k("toys", "toy_name_click", "click", "toy_name", "", "", "", -1L, this.d.getAddress());
        if (!this.d.supportChangeName() || this.d.isConnected()) {
            pj3.j(this, EditToyNameActivity.class, "program_toy_address_Id", this.d.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    public final void C5() {
        if (!this.d.getType().equals("domi") && !this.d.getType().equals("gemini")) {
            this.settingLedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.ci2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.a.v5(compoundButton, z);
                }
            });
            return;
        }
        this.llSettingLedLayout.setVisibility(0);
        this.settingLedTitle.setText(ah4.e(R.string.programs_domi_lights));
        ToyType toyTypeFindToyType = DaoUtils.getToyTypeDao().findToyType(this.d.getAddress());
        this.h = toyTypeFindToyType;
        if (toyTypeFindToyType == null) {
            ToyType toyType = new ToyType();
            this.h = toyType;
            toyType.setAutoLightOn(Boolean.TRUE);
            this.h.setAddress(this.d.getAddress());
            this.h.setType(this.d.getType());
        }
        this.settingLedSwitch.setEnabled(true);
        this.settingLedSwitch.setChecked(WearUtils.x1(this.h.getAutoLightOn()));
        this.settingLedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.ki2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.t5(compoundButton, z);
            }
        });
        if (!this.i && !this.j) {
            this.rlLedColor.setVisibility(8);
            this.vLedColorTop.setVisibility(8);
            return;
        }
        this.rlLedColor.setVisibility(0);
        this.vLedColorTop.setVisibility(0);
        this.d.setaColor(this.h.getaColor());
        y5();
        if (this.c.a(this.d.getAddress())) {
            this.rlLedColor.setEnabled(true);
            if (this.i) {
                vr1.c(this.d.getAddress());
            } else {
                vr1.d(this.d.getAddress());
            }
        }
    }

    public final void D4() {
        if (!this.d.isConnected()) {
            sg3.h(R.string.toy_settings_no_toy_toast);
        } else {
            if (na2.m().t()) {
                return;
            }
            addAnalyticsEventId("toy_program", null);
            pj3.j(this, ToyProgramActivity.class, "program_toy_address_Id", this.d.getAddress());
        }
    }

    public final void D5() {
        hs3 hs3Var = new hs3(this, R.layout.view_led_color);
        this.e = hs3Var;
        hs3Var.a(this.b, this.d, this, this);
        this.e.show();
    }

    public final void E4(boolean z) {
        ye3.k("toys", "go_to_last_level_click", "click", "go_to_last_level", "button", z ? "open" : Close.ELEMENT, "", -1L, this.d.getAddress());
        this.g.setAutoLastLevel(this.a, Boolean.valueOf(z));
        fq1.d(this.d.getAddress(), this.g.getAutoSwithOff(this.d.getAddress()).booleanValue(), z);
        DaoUtils.getSettingDao().update((SettingDao) this.g);
    }

    public final void F4() {
        if (!this.d.isConnected()) {
            sg3.l(ah4.e(R.string.lan_api_connect_toy_first));
            return;
        }
        ye3.k("toys", "serial_number_click", "click", "serial_number", "", "", "", -1L, this.d.getAddress());
        Bundle bundle = new Bundle();
        bundle.putString("seria_number", this.d.getDeviceId());
        pj3.g(this, SerialNumberActivity.class, bundle);
    }

    public final void G4() {
        if (!this.d.isConnected()) {
            sg3.l(ah4.e(R.string.lan_api_connect_toy_first));
            return;
        }
        HashMap map = new HashMap();
        map.put("toy_mac", this.d.getDeviceId());
        ye3.d("M0049", WearUtils.A.toJson(map));
        pj3.j(this, SexMachineUpliftActivity.class, SexMachineUpliftActivity.e, this.d.getAddress());
    }

    public final void H4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ye3.k("toys", "toy_strength_click", "click", "toy_strength", "", "", "", -1L, this.d.getAddress());
        if (!this.d.isConnected()) {
            sg3.h(R.string.toy_settings_no_toy_toast);
            return;
        }
        pj3.j(this, ToyStrengthActivity.class, "strength_toy_address_Id", this.d.getAddress());
        ke3.c("toy_strength_setting");
        B5();
    }

    public final void I4(SwitchView switchView) {
        if (this.d.isConnected()) {
            switchView.setChecked(!switchView.isChecked());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    public final void J4() {
        this.actionbar.setBackAction(new MyActionBar.f() { // from class: dc.mi2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.L4(view);
            }
        });
        this.settingName.setOnClickListener(new View.OnClickListener() { // from class: dc.bi2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.N4(view);
            }
        });
        this.settingProgram.setOnClickListener(new View.OnClickListener() { // from class: dc.ii2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.d5(view);
            }
        });
        this.settingFunction.setOnClickListener(new View.OnClickListener() { // from class: dc.yh2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f5(view);
            }
        });
        this.settingStrength.setOnClickListener(new View.OnClickListener() { // from class: dc.fi2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.a.h5(view);
            }
        });
        this.vLedSwitch.setOnClickListener(new View.OnClickListener() { // from class: dc.ei2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.j5(view);
            }
        });
        this.vRunLastLevel.setOnClickListener(new View.OnClickListener() { // from class: dc.di2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.l5(view);
            }
        });
        this.settingRunLastLevel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.oi2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.n5(compoundButton, z);
            }
        });
        this.vAutoSwith.setOnClickListener(new View.OnClickListener() { // from class: dc.ni2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.p5(view);
            }
        });
        this.settingAutoSwith.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: dc.gi2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.a.r5(compoundButton, z);
            }
        });
        this.settingSexMachineUplift.setOnClickListener(new View.OnClickListener() { // from class: dc.wh2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.P4(view);
            }
        });
        this.settingSerialNum.setOnClickListener(new View.OnClickListener() { // from class: dc.li2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R4(view);
            }
        });
        if (this.d.isSetThresholdEnable()) {
            this.ivThreshold.setVisibility(0);
            this.settingThreshold.setVisibility(0);
            this.settingThreshold.setOnClickListener(new View.OnClickListener() { // from class: dc.ji2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.T4(view);
                }
            });
        }
        if (lp1.a.c(this.d)) {
            this.toyUpdate.setVisibility(0);
            this.toyUpToDate.setVisibility(8);
            this.rlToyUpload.setOnClickListener(new View.OnClickListener() { // from class: dc.hi2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.V4(view);
                }
            });
        } else {
            this.toyUpdate.setVisibility(8);
            this.toyUpToDate.setVisibility(0);
        }
        this.rlDepthControl.setOnClickListener(new View.OnClickListener() { // from class: dc.ai2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.X4(view);
            }
        });
        this.deleteToy.setOnClickListener(new View.OnClickListener() { // from class: dc.xh2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Z4(view);
            }
        });
        this.rlPinControl.setOnClickListener(new View.OnClickListener() { // from class: dc.zh2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b5(view);
            }
        });
    }

    @Override // dc.hs3.b
    public void k0(ToyLedBean toyLedBean) {
        this.d.setaColor(toyLedBean.getColorNumber());
        ToyType toyType = this.h;
        if (toyType != null) {
            toyType.setaColor(toyLedBean.getColorNumber());
            DaoUtils.getToyTypeDao().update(this.h);
        }
        hs3 hs3Var = this.e;
        if (hs3Var != null) {
            hs3Var.dismiss();
        }
        if (this.i) {
            vr1.g(this.d.getAddress(), toyLedBean.getColorNumber());
        } else if (this.j) {
            vr1.h(this.d.getAddress(), toyLedBean.getColorNumber());
        }
        y5();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.toy_setting);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MyApplication myApplication = (MyApplication) getApplication();
        this.f = myApplication;
        this.c = myApplication.G();
        String stringExtra = getIntent().getStringExtra("toy_address_Id");
        this.a = stringExtra;
        Toy toyQ = this.c.Q(stringExtra);
        this.d = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        String str = "toy:" + this.d.getShowName() + " deviceType:" + this.d.getDeviceType() + " isOTA: " + kc0.k(this.a);
        if (this.d.getType().equals("domi")) {
            this.i = this.d.isSupportLEDColor(false);
        } else if (this.d.getType().equals("gemini")) {
            this.j = this.d.isSupportLEDColor(true);
        }
        if (this.d.isBAToy()) {
            this.settingFunction.setVisibility(0);
            this.vSettingFunctionTop.setVisibility(0);
        } else {
            this.settingFunction.setVisibility(8);
            this.vSettingFunctionTop.setVisibility(8);
        }
        Setting settingS = this.f.S();
        this.g = settingS;
        if (settingS == null) {
            finish();
            return;
        }
        this.settingAutoSwith.setChecked(WearUtils.x1(settingS.getAutoSwithOff(this.a)));
        this.settingRunLastLevel.setChecked(WearUtils.x1(this.g.getAutoLastLevel(this.a)));
        this.actionbar.setTitle(this.d.getName());
        if (this.d.hasProgramToy()) {
            this.settingProgram.setVisibility(0);
            this.vSettingProgramTop.setVisibility(0);
        } else {
            this.settingProgram.setVisibility(8);
            this.vSettingProgramTop.setVisibility(8);
        }
        this.llSettingLedLayout.setVisibility(0);
        this.llSettingToyReconnect.setVisibility(this.d.isF01Toy() ? 8 : 0);
        if (this.d.isConnected()) {
            this.tvToyDisconnectShow.setVisibility(8);
        } else {
            this.tvToyDisconnectShow.setVisibility(0);
        }
        z5(this.d.getLed() > -1);
        this.rlLedColor.setEnabled(false);
        this.rlDepthControl.setVisibility(8);
        this.vDepthControlTop.setVisibility(8);
        C5();
        if (this.d.isSupportDepthMode() && this.d.getType().equals("mission")) {
            this.rlDepthControl.setVisibility(0);
            this.vDepthControlTop.setVisibility(0);
            if (this.c.a(this.d.getAddress())) {
                jr1.c(this.d.getAddress());
                jr1.d(this.d.getAddress());
                x5(true);
            } else {
                x5(false);
            }
        }
        w5(this.c.a(this.d.getAddress()));
        u4();
        if (this.d.isSetGradualSpeedUpEnable()) {
            this.settingSexMachineUpliftTitle.setText(ah4.e(R.string.gradual_speed_up));
            this.settingSexMachineUplift.setVisibility(0);
            if (ke3.a("new_feature", "sex_machine_uplift")) {
                this.sexMachineNewFeatureDot.setVisibility(0);
            } else {
                this.sexMachineNewFeatureDot.setVisibility(8);
            }
        } else {
            this.settingSexMachineUplift.setVisibility(8);
        }
        if (this.d.isConnected()) {
            B5();
        }
        J4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (this.d.getAddress().equals(xc1Var.a())) {
            this.rlLedColor.setEnabled(false);
            if (xc1Var.b() == 1) {
                x5(true);
                z5(false);
                if (this.d.getType().equals("domi")) {
                    A5(true);
                    this.rlLedColor.setEnabled(true);
                    vr1.c(this.d.getAddress());
                } else if (this.d.getType().equals("gemini")) {
                    A5(true);
                    this.rlLedColor.setEnabled(true);
                    vr1.d(this.d.getAddress());
                }
                this.tvToyDisconnectShow.setVisibility(8);
            } else if (xc1Var.b() == -1) {
                z5(false);
                x5(false);
                this.tvToyDisconnectShow.setVisibility(0);
            }
            w5(this.c.a(this.d.getAddress()));
            if (!this.d.isSuppportPinCode()) {
                this.vPinControlTop.setVisibility(8);
                this.rlPinControl.setVisibility(8);
                return;
            }
            this.vPinControlTop.setVisibility(0);
            this.rlPinControl.setVisibility(0);
            if (xb1.b(this.d.getUuid(), this.d.getAddress())) {
                this.ivPinControlStatus.setImageResource(R.drawable.secure_light);
                this.tvPinControlStatus.setTextColor(getResources().getColor(R.color.text_color_25));
                this.tvPinControlStatus.setText(ah4.e(R.string.depth_control_off));
            } else {
                this.ivPinControlStatus.setImageResource(R.drawable.secure_dark);
                this.tvPinControlStatus.setTextColor(getResources().getColor(R.color.text_color_b45_wo));
                this.tvPinControlStatus.setText(ah4.e(R.string.depth_control_on));
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.toyReName.setText(WearUtils.e1(this.d.getDefineRename()) ? "" : this.d.getDefineRename());
        if (this.d.getMissionSolo() == 1) {
            this.tvDepthControlStatus.setText(ah4.e(R.string.depth_control_on));
        } else {
            this.tvDepthControlStatus.setText(ah4.e(R.string.depth_control_off));
        }
        u4();
        if (this.d.isBAToy()) {
            this.settingFunction.setVisibility(0);
            this.ivFunRedDot.setVisibility(me0.a(MyToyAdapter.D.a(), false) ? 8 : 0);
        } else {
            this.settingFunction.setVisibility(8);
        }
        if (fk2.a.c(this.a) == ek2.POSITION) {
            this.tvCurrMode.setText(ah4.e(R.string.function_pos));
        } else {
            this.tvCurrMode.setText(ah4.e(R.string.toy_function_thrust_speed));
        }
    }

    @OnClick({R.id.rl_led_color})
    public void onViewClicked() {
        D5();
    }

    public final void u4() {
        if (!this.d.isSuppportPinCode() || !og3.a(9)) {
            this.vPinControlTop.setVisibility(8);
            this.rlPinControl.setVisibility(8);
            return;
        }
        this.vPinControlTop.setVisibility(0);
        this.rlPinControl.setVisibility(0);
        if (xb1.b(this.d.getUuid(), this.d.getAddress())) {
            this.ivPinControlStatus.setImageResource(R.drawable.secure_light);
            this.tvPinControlStatus.setTextColor(getResources().getColor(R.color.text_color_25));
            this.tvPinControlStatus.setText(ah4.e(R.string.depth_control_off));
        } else {
            this.ivPinControlStatus.setImageResource(R.drawable.secure_dark);
            this.tvPinControlStatus.setTextColor(getResources().getColor(R.color.text_color_b45_wo));
            this.tvPinControlStatus.setText(ah4.e(R.string.depth_control_on));
        }
    }

    public void v4(String str, String str2) {
        kn3 kn3Var = new kn3((Context) this, String.format(String.valueOf(ah4.e(R.string.common_dialog_delete)), str2), ah4.e(R.string.common_delete), ah4.e(R.string.common_cancel), true, (kn3.d) new b(str, str2));
        kn3Var.show();
        kn3Var.p();
    }

    public final void w4() {
        if (!this.d.isConnected()) {
            sg3.h(R.string.toy_settings_no_toy_toast);
        } else {
            if (na2.m().t()) {
                return;
            }
            pj3.j(this, ToyThresholdActivity.class, "threshold_toy_address_Id", this.d.getAddress());
        }
    }

    public final void w5(boolean z) {
        if (z) {
            this.settingRunLastLevel.setEnabled(true);
            this.settingAutoSwith.setEnabled(true);
            this.settingLedSwitch.setEnabled(true);
            this.rlLedColor.setEnabled(true);
            return;
        }
        this.settingRunLastLevel.setEnabled(false);
        this.settingAutoSwith.setEnabled(false);
        this.settingLedSwitch.setEnabled(false);
        this.rlLedColor.setEnabled(false);
        this.vLedColor.setVisibility(4);
        this.tvLedColor.setVisibility(4);
    }

    public final void x4() {
        if (!this.d.isConnected()) {
            sg3.h(R.string.toy_settings_no_toy_toast);
        } else {
            if (na2.m().t()) {
                return;
            }
            pj3.j(this, ToyDepthControlActivity.class, "toy_address", this.d.getAddress());
        }
    }

    public final void x5(boolean z) {
        this.rlDepthControl.setEnabled(z);
        if (z) {
            this.tvDepthControlStatus.setTextColor(getResources().getColor(R.color.text_primary_light));
            this.tvDepthControl.setTextColor(getResources().getColor(R.color.text_primary_light));
        } else {
            this.tvDepthControlStatus.setTextColor(getResources().getColor(R.color.text_secondary_light));
            this.tvDepthControl.setTextColor(getResources().getColor(R.color.text_secondary_light));
        }
    }

    public final void y4() {
        ye3.k("toys", "security_pin_click", "click", "security_pin", "", "", "", -1L, this.d.getAddress());
        if (WearUtils.e1(zt3.k)) {
            sg3.h(R.string.toy_strength_not_login);
        } else if (this.d.isConnected()) {
            pj3.j(this, ToyPinSettingActivity.class, "toyAddress", this.d.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    public final void y5() {
        try {
            ToyLedBean toyLedBean = this.b.get(Integer.valueOf(this.d.getaColor()));
            if (toyLedBean == null) {
                return;
            }
            this.tvLedColor.setText(toyLedBean.getName());
            if (this.d.getaColor() == 7) {
                this.vLedColor.setBackgroundResource(R.drawable.color_bg);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(toyLedBean.getColor());
                gradientDrawable.setCornerRadius(ce3.a(this, 5.0f));
                gradientDrawable.setShape(0);
                this.vLedColor.setBackground(gradientDrawable);
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public final void z4() {
        if (this.d.isConnected()) {
            lp1.a.e(this, this.d.getAddress());
        } else {
            sg3.h(R.string.toy_settings_no_toy_toast);
        }
    }

    public final void z5(boolean z) {
        if (z) {
            this.settingLedSwitch.setEnabled(true);
            if (this.d.getLed() == 0) {
                this.settingLedSwitch.setChecked(false);
                return;
            } else {
                if (this.d.getLed() == 1) {
                    this.settingLedSwitch.setChecked(true);
                    return;
                }
                return;
            }
        }
        this.settingLedSwitch.setEnabled(false);
        if (this.d.isCanWearoy() && this.c.a(this.d.getAddress())) {
            this.settingLedSwitch.setEnabled(true);
            this.settingLedSwitch.setChecked(this.d.getLedSetting().intValue() > 0);
            if (this.c.a(this.d.getAddress())) {
                this.c.Q(this.d.getAddress()).setLed(this.d.getLedSetting().intValue() > 0 ? 1 : 0);
                sr1.e(this.d.getAddress(), this.d.getLedSetting().intValue() > 0);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(wc1 wc1Var) {
        String strB = wc1Var.b();
        if (!this.a.equals(wc1Var.a()) || WearUtils.e1(strB)) {
            return;
        }
        if (strB.startsWith("Light:")) {
            z5(this.d.getLed() > -1);
            return;
        }
        if (strB.startsWith("GetAColor:")) {
            if (this.i) {
                this.rlLedColor.setVisibility(0);
                this.vLedColorTop.setVisibility(0);
                y5();
                this.vLedColor.setVisibility(0);
                this.tvLedColor.setVisibility(0);
                return;
            }
            this.rlLedColor.setVisibility(8);
            this.vLedColorTop.setVisibility(8);
            return;
        }
        if (strB.startsWith("GetColor")) {
            if (this.j) {
                this.rlLedColor.setVisibility(0);
                this.vLedColorTop.setVisibility(0);
                y5();
                this.vLedColor.setVisibility(0);
                this.tvLedColor.setVisibility(0);
                return;
            }
            this.rlLedColor.setVisibility(8);
            this.vLedColorTop.setVisibility(8);
            return;
        }
        if (strB.startsWith("Solo:")) {
            if (this.d.getMissionSolo() == 1) {
                this.tvDepthControlStatus.setText(ah4.e(R.string.depth_control_on));
            } else {
                this.tvDepthControlStatus.setText(ah4.e(R.string.depth_control_off));
            }
        }
    }
}
