package com.wear.main.toy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.vending.expansion.downloader.Constants;
import com.lovense.wear.R;
import com.spotify.sdk.android.player.Config;
import com.wear.BaseActivity;
import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyStrength;
import com.wear.bean.event.UpdateToyStrengthEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.toy.newtoy.seekbar.SignSeekBar;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.seekbar.RangeSeekBar;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.ak2;
import dc.cs3;
import dc.dk2;
import dc.ek2;
import dc.fk2;
import dc.is3;
import dc.mp1;
import dc.nn2;
import dc.pc1;
import dc.pp2;
import dc.rq1;
import dc.th4;
import dc.vl2;
import dc.vr3;
import dc.vu1;
import dc.xs3;
import dc.ye3;
import dc.z12;
import dc.zt3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class ToyStrengthActivity extends BaseActivity<vl2> implements pp2 {
    public nn2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.air_control)
    public SignSeekBar airControl;
    public String b;
    public Toy c;
    public String d;

    @BindView(R.id.depth_control)
    public SignSeekBar depthControl;
    public ToyStrength e;
    public StrengthBean f;

    @BindView(R.id.fingering_control)
    public SignSeekBar fingeringControl;

    @BindView(R.id.iv_air)
    public ImageView ivAir;

    @BindView(R.id.iv_depth)
    public ImageView ivDepth;

    @BindView(R.id.iv_fingering)
    public ImageView ivFingering;

    @BindView(R.id.iv_rotate)
    public ImageView ivRotate;

    @BindView(R.id.iv_speed)
    public ImageView ivThrustSpeed;

    @BindView(R.id.iv_thrusting)
    public ImageView ivThrusting;

    @BindView(R.id.iv_vibration)
    public ImageView ivVibration;

    @BindView(R.id.iv_vibration_1)
    public ImageView ivVibration1;

    @BindView(R.id.iv_vibration_2)
    public ImageView ivVibration2;

    @BindView(R.id.iv_vibration_3)
    public ImageView ivVibration3;

    @BindView(R.id.ll_air)
    public LinearLayout llAir;

    @BindView(R.id.ll_stroke)
    public LinearLayout llControl;

    @BindView(R.id.ll_depth)
    public LinearLayout llDepth;

    @BindView(R.id.ll_fingering)
    public LinearLayout llFingering;

    @BindView(R.id.ll_rotate)
    public LinearLayout llRotate;

    @BindView(R.id.ll_speed)
    public LinearLayout llSpeed;

    @BindView(R.id.ll_thrusting)
    public LinearLayout llThrusting;

    @BindView(R.id.ll_vibration)
    public LinearLayout llVibration;

    @BindView(R.id.ll_vibration_1)
    public LinearLayout llVibration1;

    @BindView(R.id.ll_vibration_2)
    public LinearLayout llVibration2;

    @BindView(R.id.ll_vibration_3)
    public LinearLayout llVibration3;

    @BindView(R.id.rotate_control)
    public SignSeekBar rotateControl;

    @BindView(R.id.speed_control)
    public RangeSeekBar speedControl;

    @BindView(R.id.stroke_seekbar)
    public RangeSeekBar strokeControl;

    @BindView(R.id.thrusting_control)
    public SignSeekBar thrustingControl;

    @BindView(R.id.tv_air)
    public TextView tvAir;

    @BindView(R.id.tv_depth)
    public TextView tvDepth;

    @BindView(R.id.tv_fingering)
    public TextView tvFingering;

    @BindView(R.id.tv_rotate)
    public TextView tvRotate;

    @BindView(R.id.tv_thrust_speed)
    public TextView tvThrustSpeed;

    @BindView(R.id.tv_thrusting)
    public TextView tvThrusting;

    @BindView(R.id.tv_tips)
    public TextView tvTips;

    @BindView(R.id.tv_vibration)
    public TextView tvVibration;

    @BindView(R.id.tv_vibration_1)
    public TextView tvVibration1;

    @BindView(R.id.tv_vibration_2)
    public TextView tvVibration2;

    @BindView(R.id.tv_vibration_3)
    public TextView tvVibration3;

    @BindView(R.id.vibration_control)
    public SignSeekBar vibrationControl;

    @BindView(R.id.vibration_control_1)
    public SignSeekBar vibrationControl1;

    @BindView(R.id.vibration_control_2)
    public SignSeekBar vibrationControl2;

    @BindView(R.id.vibration_control_3)
    public SignSeekBar vibrationControl3;
    public final Map<String, String> g = new HashMap();
    public String h = "";
    public int i = 0;
    public long j = 0;

    public class a implements xs3 {
        public a() {
        }

        @Override // dc.xs3
        public void a(RangeSeekBar rangeSeekBar, float f, float f2, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.T4(f != 0.0f, toyStrengthActivity.tvThrustSpeed, toyStrengthActivity.ivThrustSpeed);
            if (z) {
                ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
                toyStrengthActivity2.S4(toyStrengthActivity2.c, "t", (int) f);
                return;
            }
            ToyStrengthActivity toyStrengthActivity3 = ToyStrengthActivity.this;
            toyStrengthActivity3.S4(toyStrengthActivity3.c, "t", 0);
            Map map = ToyStrengthActivity.this.g;
            StringBuilder sb = new StringBuilder();
            sb.append("-0_");
            int i = (int) f;
            sb.append(i);
            map.put("thrusting", sb.toString());
            ToyStrengthActivity.this.f.getData().setT(Integer.valueOf(i));
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }

        @Override // dc.xs3
        public void b(RangeSeekBar rangeSeekBar, boolean z) {
        }

        @Override // dc.xs3
        public void c(RangeSeekBar rangeSeekBar, boolean z) {
        }
    }

    public class b implements xs3 {
        public b() {
        }

        @Override // dc.xs3
        public void a(RangeSeekBar rangeSeekBar, float f, float f2, boolean z) {
            if (z) {
                return;
            }
            StrengthBean.Data data = ToyStrengthActivity.this.f.getData();
            int i = (int) f;
            data.setStrokeMin(Integer.valueOf(i));
            int i2 = (int) f2;
            data.setStrokeMax(Integer.valueOf(i2));
            String str = fk2.a.c(ToyStrengthActivity.this.c.getAddress()) == ek2.POSITION ? "pos_range" : "stroke_range";
            ToyStrengthActivity.this.g.put(str, i + Config.IN_FIELD_SEPARATOR + i2);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }

        @Override // dc.xs3
        public void b(RangeSeekBar rangeSeekBar, boolean z) {
        }

        @Override // dc.xs3
        public void c(RangeSeekBar rangeSeekBar, boolean z) {
        }
    }

    public class c implements SignSeekBar.f {
        public c() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setV(Integer.valueOf(i));
            if (ToyStrengthActivity.this.c.isF01Toy()) {
                ToyStrengthActivity.this.g.put("thrusting", "0_" + i);
                ToyStrengthActivity.this.f.getData().setT(Integer.valueOf(i));
            } else if (ToyStrengthActivity.this.c.isQ01Toy()) {
                ToyStrengthActivity.this.g.put(Toy.TOY_FEATURE_TENERA, "0_" + i);
                ToyStrengthActivity.this.f.getData().setS(Integer.valueOf(i));
            } else {
                ToyStrengthActivity.this.g.put("vibrate", "0_" + i);
            }
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, PSOProgramService.VS_Key, 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, PSOProgramService.VS_Key, i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivVibration, toyStrengthActivity2.tvVibration);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class d implements SignSeekBar.f {
        public d() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setV1(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("vibrate1", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "v1", 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "v1", i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivVibration1, toyStrengthActivity2.tvVibration1);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class e implements SignSeekBar.f {
        public e() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setV2(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("vibrate2", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "v2", 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "v2", i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivVibration2, toyStrengthActivity2.tvVibration2);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class f implements SignSeekBar.f {
        public f() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setV3(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("vibrate3", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "v3", 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "v3", i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivVibration3, toyStrengthActivity2.tvVibration3);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class g implements SignSeekBar.f {
        public g() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setR(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("rotate", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, StreamManagement.AckRequest.ELEMENT, 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, StreamManagement.AckRequest.ELEMENT, i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivRotate, toyStrengthActivity2.tvRotate);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class h implements SignSeekBar.f {
        public h() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setP(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("contract", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "p", 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "p", i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivAir, toyStrengthActivity2.tvAir);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class i implements SignSeekBar.f {
        public i() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setT(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("thrusting", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "t", 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "t", i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivThrusting, toyStrengthActivity2.tvThrusting);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class j implements SignSeekBar.f {
        public j() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setF(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("fingering", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "f", 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, "f", i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivFingering, toyStrengthActivity2.tvFingering);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    public class k implements SignSeekBar.f {
        public k() {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity.this.f.getData().setD(Integer.valueOf(i));
            ToyStrengthActivity.this.g.put("depth", "0_" + i);
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, 0);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(SignSeekBar signSeekBar, int i, float f, boolean z) {
            ToyStrengthActivity toyStrengthActivity = ToyStrengthActivity.this;
            toyStrengthActivity.S4(toyStrengthActivity.c, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, i);
            ToyStrengthActivity toyStrengthActivity2 = ToyStrengthActivity.this;
            toyStrengthActivity2.T4(i != 0, toyStrengthActivity2.ivDepth, toyStrengthActivity2.tvDepth);
            ToyStrengthActivity.this.actionbar.getYesBtn().setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N4(View view) {
        if (this.actionbar.getYesBtn().isEnabled()) {
            cs3.d(this, ah4.e(R.string.notification_doesnt_save_setting), ah4.e(R.string.common_save), ah4.e(R.string.discard_button), new is3.d() { // from class: dc.pi2
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.L4();
                }
            }, new is3.c() { // from class: dc.jg2
                @Override // dc.is3.c
                public final void doCancel() {
                    this.a.finish();
                }
            }).show();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P4(View view) {
        K4();
    }

    public final void A4() {
        this.llRotate.setVisibility(0);
        ak2 configBuilder = this.rotateControl.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getRotateStrength()) && WearUtils.q1(this.e.getRotateStrength())) {
            this.f.getData().setR(Integer.valueOf(this.e.getRotateStrength()));
            this.rotateControl.setProgress(Integer.parseInt(this.e.getRotateStrength()));
        } else {
            this.f.getData().setR(100);
            this.rotateControl.setProgress(100.0f);
        }
        this.rotateControl.setOnProgressChangedListener(new g());
    }

    public final void B4() {
        this.llSpeed.setVisibility(0);
        this.speedControl.getLeftSeekBar().K(th4.b(this, R.color.item_pattern_toy_name_2));
        this.speedControl.getRightSeekBar().K(th4.b(this, R.color.item_pattern_toy_name_2));
        this.speedControl.setProgressDefaultColor(th4.b(this, R.color.report_edittext_box_stroke_color));
        this.speedControl.setOnRangeChangedListener(new a());
        this.speedControl.setProgress(WearUtils.n1(this.e.getThrustingStrength()) ? Integer.parseInt(r0) : 100);
        this.speedControl.setIndicatorTextDecimalFormat("0");
        this.speedControl.setIndicatorTextStringFormat("%s%%");
    }

    public final void C4(ek2 ek2Var) {
        this.llControl.setVisibility(0);
        this.strokeControl.getLeftSeekBar().K(th4.b(this, R.color.item_pattern_toy_name_2));
        this.strokeControl.getRightSeekBar().K(th4.b(this, R.color.item_pattern_toy_name_2));
        this.strokeControl.setProgressDefaultColor(th4.b(this, R.color.report_edittext_box_stroke_color));
        this.strokeControl.setOnRangeChangedListener(new b());
        this.strokeControl.setProgress(this.e.getStrokeMin() != null ? this.e.getStrokeMin().intValue() : 0, this.e.getStrokeMax() != null ? this.e.getStrokeMax().intValue() : 100);
        this.strokeControl.setIndicatorTextDecimalFormat("0");
    }

    public final void D4() {
        if (this.c.isF01Toy()) {
            return;
        }
        this.llThrusting.setVisibility(0);
        ak2 configBuilder = this.thrustingControl.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getThrustingStrength()) && WearUtils.q1(this.e.getThrustingStrength())) {
            this.f.getData().setT(Integer.valueOf(this.e.getThrustingStrength()));
            this.thrustingControl.setProgress(Integer.parseInt(this.e.getThrustingStrength()));
        } else {
            this.f.getData().setT(100);
            this.thrustingControl.setProgress(100.0f);
        }
        this.thrustingControl.setOnProgressChangedListener(new i());
    }

    public final void E4() {
        this.llVibration.setVisibility(0);
        ak2 configBuilder = this.vibrationControl.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (WearUtils.e1(this.e.getVibrationStrength()) || !WearUtils.q1(this.e.getVibrationStrength())) {
            this.f.getData().setV(100);
            this.vibrationControl.setProgress(100.0f);
        } else {
            this.f.getData().setV(Integer.valueOf(this.e.getVibrationStrength()));
            this.vibrationControl.setProgress(Integer.parseInt(this.e.getVibrationStrength()));
        }
        if (this.c.isF01Toy()) {
            this.ivVibration.setImageResource(R.drawable.selector_icon_fun_t);
            this.tvVibration.setText(ah4.e(R.string.toy_function_thrust_speed));
        } else if (this.c.isQ01Toy()) {
            if (!WearUtils.e1(this.e.getSuctionStrength()) && WearUtils.q1(this.e.getSuctionStrength())) {
                this.f.getData().setS(Integer.valueOf(this.e.getSuctionStrength()));
                this.vibrationControl.setProgress(Integer.parseInt(this.e.getSuctionStrength()));
            }
            this.ivVibration.setImageResource(R.drawable.selector_icon_fun_s);
            this.tvVibration.setText(ah4.e(R.string.function_suction));
        } else {
            this.ivVibration.setImageResource(R.drawable.selector_icon_fun_v);
            this.tvVibration.setText(ah4.e(R.string.toy_control_type1));
        }
        this.vibrationControl.setOnProgressChangedListener(new c());
    }

    public final void F4() {
        this.llVibration1.setVisibility(0);
        ak2 configBuilder = this.vibrationControl1.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getVibration1Strength()) && WearUtils.q1(this.e.getVibration1Strength())) {
            this.f.getData().setV1(Integer.valueOf(this.e.getVibration1Strength()));
            this.vibrationControl1.setProgress(Integer.parseInt(this.e.getVibration1Strength()));
        } else {
            this.f.getData().setV1(100);
            this.vibrationControl1.setProgress(100.0f);
        }
        this.vibrationControl1.setOnProgressChangedListener(new d());
    }

    public final void G4() {
        this.llVibration2.setVisibility(0);
        this.llVibration.setVisibility(8);
        ak2 configBuilder = this.vibrationControl2.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getVibration2Strength()) && WearUtils.q1(this.e.getVibration2Strength())) {
            this.f.getData().setV2(Integer.valueOf(this.e.getVibration2Strength()));
            this.vibrationControl2.setProgress(Integer.parseInt(this.e.getVibration2Strength()));
        } else {
            this.f.getData().setV2(100);
            this.vibrationControl2.setProgress(100.0f);
        }
        this.vibrationControl2.setOnProgressChangedListener(new e());
    }

    public final void H4() {
        this.llVibration3.setVisibility(0);
        this.llVibration.setVisibility(8);
        ak2 configBuilder = this.vibrationControl3.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getVibration3Strength()) && WearUtils.q1(this.e.getVibration3Strength())) {
            this.f.getData().setV3(Integer.valueOf(this.e.getVibration3Strength()));
            this.vibrationControl3.setProgress(Integer.parseInt(this.e.getVibration3Strength()));
        } else {
            this.f.getData().setV3(100);
            this.vibrationControl3.setProgress(100.0f);
        }
        this.vibrationControl3.setOnProgressChangedListener(new f());
    }

    public final void I4() {
        this.actionbar.setBackAction(new MyActionBar.f() { // from class: dc.qi2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.N4(view);
            }
        });
        this.actionbar.getYesBtn().setTextColor(th4.c(this, R.color.text_toy_strength_save));
        this.actionbar.setYesAction(R.string.common_save, new MyActionBar.f() { // from class: dc.ri2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.P4(view);
            }
        });
        this.actionbar.getYesBtn().setEnabled(false);
    }

    public final void J4() {
        StrengthBean strengthBean;
        String andUpdateDeviceId = this.c.getAndUpdateDeviceId();
        this.d = andUpdateDeviceId;
        StrengthBean strengthBeanD = vu1.d(andUpdateDeviceId);
        this.f = new StrengthBean(this.d);
        if (strengthBeanD != null) {
            StrengthBean.Data data = strengthBeanD.getData();
            if (data != null) {
                strengthBean = strengthBeanD;
                this.f.setData(new StrengthBean.Data(data.getP(), data.getR(), data.getV2(), data.getV3(), data.getV1(), data.getV(), data.getT(), data.getS(), data.getF(), data.getD(), data.getPos(), data.getStrokeMin(), data.getStrokeMax()));
            } else {
                strengthBean = strengthBeanD;
                this.f.setData(new StrengthBean.Data());
            }
        } else {
            strengthBean = strengthBeanD;
        }
        ToyStrength toyStrengthFindToyStrength = DaoUtils.getToyStrengthDao().findToyStrength(zt3.k, this.d);
        this.e = toyStrengthFindToyStrength;
        if (toyStrengthFindToyStrength == null) {
            this.e = new ToyStrength(zt3.k, this.d);
        }
        if (strengthBean != null) {
            StrengthBean.Data data2 = this.f.getData();
            this.e.setStrength(data2.getV(), data2.getV1(), data2.getV2(), data2.getV3(), data2.getR(), data2.getP(), data2.getS(), data2.getT(), data2.getF(), data2.getD(), data2.getStrokeMin(), data2.getStrokeMax());
        }
        Q4();
        I4();
        U4();
    }

    public final void Q4() {
        if (this.c.isBAToy()) {
            ek2 ek2VarC = fk2.a.c(this.b);
            ek2 ek2Var = ek2.SPEED;
            if (ek2VarC != ek2Var) {
                C4(ek2.POSITION);
                return;
            } else {
                B4();
                C4(ek2Var);
                return;
            }
        }
        for (String str : Toy.getToyFunction(this.c.getType()).split(",")) {
            str.hashCode();
            switch (str) {
                case "d":
                    x4();
                    break;
                case "f":
                    y4();
                    break;
                case "p":
                    z4();
                    break;
                case "r":
                    A4();
                    break;
                case "t":
                    D4();
                    break;
                case "v":
                    E4();
                    break;
                case "v1":
                    F4();
                    break;
                case "v2":
                    G4();
                    break;
                case "v3":
                    H4();
                    break;
            }
        }
    }

    public final void R4() {
        StrengthBean.Data data = this.f.getData();
        if (this.e == null) {
            this.e = new ToyStrength(zt3.k, this.d);
        }
        if (this.f.getData().getV() != null) {
            this.e.setVibrationStrength(this.f.getData().getV() + "");
        }
        if (this.f.getData().getV1() != null) {
            this.e.setVibration1Strength(this.f.getData().getV1() + "");
        }
        if (this.f.getData().getV2() != null) {
            this.e.setVibration2Strength(this.f.getData().getV2() + "");
        }
        if (this.f.getData().getV3() != null) {
            this.e.setVibration3Strength(this.f.getData().getV3() + "");
        }
        if (this.f.getData().getR() != null) {
            this.e.setRotateStrength(this.f.getData().getR() + "");
        }
        if (this.f.getData().getP() != null) {
            this.e.setAirStrength(this.f.getData().getP() + "");
        }
        if (this.f.getData().getS() != null) {
            this.e.setSuctionStrength(this.f.getData().getS() + "");
        }
        if (this.f.getData().getT() != null) {
            this.e.setThrustingStrength(this.f.getData().getT() + "");
        }
        if (this.f.getData().getF() != null) {
            this.e.setFingeringStrength(this.f.getData().getF() + "");
        }
        if (this.f.getData().getD() != null) {
            this.e.setDepthStrength(this.f.getData().getD() + "");
        }
        boolean z = false;
        boolean z2 = true;
        if (data.getStrokeMin() != null) {
            this.e.setStrokeMin(data.getStrokeMin());
            z = true;
        }
        if (data.getStrokeMax() != null) {
            this.e.setStrokeMax(data.getStrokeMax());
        } else {
            z2 = z;
        }
        vu1.f(this.d, this.f);
        DaoUtils.getToyStrengthDao().updateOrAdd(this.e);
        if (z2) {
            dk2.a.j(this.c, data.getStrokeMin().intValue(), data.getStrokeMax().intValue());
        }
        EventBus.getDefault().post(new UpdateToyStrengthEvent(this.c));
    }

    public final void S4(Toy toy, String str, int i2) {
        if (z12.a()) {
            return;
        }
        if (TextUtils.equals(this.h, str) && this.i == i2) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.j >= 100 || i2 == 0) {
            this.j = jCurrentTimeMillis;
            this.h = str;
            this.i = i2;
            if (mp1.h()) {
                rq1.d.n(toy.getAddress(), str, String.valueOf(i2), new ToyControlBuilder(true, false, false, ToyControlBuilder.a.SPEED));
            } else {
                pc1.a.n0(toy, new String[]{str}, new String[]{String.valueOf(i2)}, true, false, false);
            }
        }
    }

    public final void T4(boolean z, View... viewArr) {
        for (View view : viewArr) {
            view.setEnabled(z);
        }
    }

    public final void U4() {
        if (!this.c.isBAToy()) {
        }
    }

    /* renamed from: V4, reason: merged with bridge method [inline-methods] */
    public final void L4() {
        ArrayList arrayList = new ArrayList(this.g.size());
        for (Map.Entry<String, String> entry : this.g.entrySet()) {
            arrayList.add(entry.getKey() + Constants.FILENAME_SEQUENCE_SEPARATOR + entry.getValue());
        }
        ye3.k("toys", "toy_strength_save_click", "click", "toy_strength_save", "button", WearUtils.A.toJson(arrayList), "", -1L, this.b);
        String jSONString = JSON.toJSONString(this.f);
        if (!MyApplication.O) {
            R4();
            finish();
        } else {
            vr3 vr3Var = this.progressDialog;
            if (vr3Var != null) {
                vr3Var.show();
            }
            this.a.h(false, jSONString);
        }
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.q(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_strength);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MyApplication myApplication = (MyApplication) getApplication();
        this.application = myApplication;
        pc1 pc1VarG = myApplication.G();
        String stringExtra = getIntent().getStringExtra("strength_toy_address_Id");
        this.b = stringExtra;
        Toy toyQ = pc1VarG.Q(stringExtra);
        this.c = toyQ;
        if (toyQ == null) {
            finish();
        } else {
            J4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Toy toy = this.c;
        if (toy != null) {
            pc1 pc1Var = pc1.a;
            if (!pc1Var.a(toy.getAddress()) || z12.a()) {
                return;
            }
            pc1Var.v0(this.c.getAddress());
        }
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        super.showErrorMsg(str, z);
        vr3 vr3Var = this.progressDialog;
        if (vr3Var == null || !vr3Var.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    @Override // dc.pp2
    public void w3(boolean z, BaseResponseBean baseResponseBean) {
        vr3 vr3Var = this.progressDialog;
        if (vr3Var != null && vr3Var.isShowing()) {
            this.progressDialog.dismiss();
        }
        R4();
        finish();
    }

    public final void x4() {
        this.llDepth.setVisibility(0);
        ak2 configBuilder = this.depthControl.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getDepthStrength()) && WearUtils.q1(this.e.getDepthStrength())) {
            this.f.getData().setD(Integer.valueOf(this.e.getDepthStrength()));
            this.depthControl.setProgress(Integer.parseInt(this.e.getDepthStrength()));
        } else {
            this.f.getData().setD(100);
            this.depthControl.setProgress(100.0f);
        }
        this.depthControl.setOnProgressChangedListener(new k());
    }

    public final void y4() {
        this.llFingering.setVisibility(0);
        ak2 configBuilder = this.fingeringControl.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getFingeringStrength()) && WearUtils.q1(this.e.getFingeringStrength())) {
            this.f.getData().setF(Integer.valueOf(this.e.getFingeringStrength()));
            this.fingeringControl.setProgress(Integer.parseInt(this.e.getFingeringStrength()));
        } else {
            this.f.getData().setF(100);
            this.fingeringControl.setProgress(100.0f);
        }
        this.fingeringControl.setOnProgressChangedListener(new j());
    }

    public final void z4() {
        this.llAir.setVisibility(0);
        ak2 configBuilder = this.airControl.getConfigBuilder();
        configBuilder.c(th4.b(this, R.color.item_pattern_toy_name_2));
        configBuilder.f(th4.b(this, R.color.seekbar_default_bg));
        configBuilder.a();
        if (!WearUtils.e1(this.e.getAirStrength()) && WearUtils.q1(this.e.getAirStrength())) {
            this.f.getData().setP(Integer.valueOf(this.e.getAirStrength()));
            this.airControl.setProgress(Integer.parseInt(this.e.getAirStrength()));
        } else {
            this.f.getData().setP(100);
            this.airControl.setProgress(100.0f);
        }
        this.airControl.setOnProgressChangedListener(new h());
    }
}
