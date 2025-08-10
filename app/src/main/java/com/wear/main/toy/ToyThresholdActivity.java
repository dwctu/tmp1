package com.wear.main.toy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.widget.MyActionBar;
import com.wear.widget.llong.StrengthControlViewL;
import dc.ah4;
import dc.c40;
import dc.cs3;
import dc.d40;
import dc.is3;
import dc.ms1;
import dc.pc1;
import dc.vr3;
import dc.ye3;
import java.math.BigDecimal;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToyThresholdActivity extends BaseActivity {
    public static final String i = ToyThresholdActivity.class.getName();
    public pc1 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public Toy c;
    public int d = 0;
    public int e = 0;
    public int f = 2;
    public int g;
    public int h;

    @BindView(R.id.threshold_control)
    public StrengthControlViewL thresholdControl;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ToyThresholdActivity.this.onBackPressed();
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            vr3 vr3Var = ToyThresholdActivity.this.progressDialog;
            if (vr3Var != null) {
                vr3Var.show();
            }
            ToyThresholdActivity.this.A4();
        }
    }

    public class c implements StrengthControlViewL.d {
        public c() {
        }

        @Override // com.wear.widget.llong.StrengthControlViewL.d
        public void e(int i) {
        }

        @Override // com.wear.widget.llong.StrengthControlViewL.d
        public void setDeth(int i) {
            ToyThresholdActivity.this.h = i;
            ToyThresholdActivity.this.actionbar.getYesBtn().setEnabled(ToyThresholdActivity.this.h != ToyThresholdActivity.this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x4() {
        vr3 vr3Var = this.progressDialog;
        if (vr3Var != null) {
            vr3Var.show();
        }
        A4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z4() {
        finish();
    }

    public final void A4() {
        int i2;
        float fFloatValue;
        float f;
        float fFloatValue2;
        float f2;
        if (this.c.isConnected()) {
            this.e = 0;
            this.d = 0;
            for (int i3 = 1; i3 <= this.f; i3++) {
                float f3 = 1200.0f;
                if (i3 == 1) {
                    if (this.c.isMiniXMachine()) {
                        f3 = 500.0f;
                        fFloatValue2 = new BigDecimal(this.h).floatValue();
                        f2 = 7.0f;
                    } else if (this.c.getToyVersion() >= 50) {
                        fFloatValue2 = new BigDecimal(this.h).floatValue();
                        f2 = 14.0f;
                    } else {
                        fFloatValue = new BigDecimal(this.h).floatValue() / 100.0f;
                        f = 20.0f;
                        i2 = (int) ((fFloatValue * f) + f);
                    }
                    i2 = (int) ((fFloatValue2 * f2) + f3);
                } else if (i3 == 2) {
                    if (this.c.isMiniXMachine()) {
                        f3 = 2600.0f;
                        fFloatValue2 = new BigDecimal(this.h).floatValue();
                        f2 = 19.0f;
                    } else if (this.c.getToyVersion() >= 50) {
                        fFloatValue2 = new BigDecimal(this.h).floatValue();
                        f2 = 18.0f;
                    } else {
                        fFloatValue = new BigDecimal(this.h).floatValue() / 100.0f;
                        f = 25.0f;
                        i2 = (int) ((fFloatValue * f) + f);
                    }
                    i2 = (int) ((fFloatValue2 * f2) + f3);
                } else {
                    i2 = 0;
                }
                String str = "setToyThreshold:SetBkV:" + i3 + SignatureImpl.INNER_SEP + i2 + ",F01th;";
                ye3.d("S0003", "setToyThreshold:SetBkV:" + i3 + SignatureImpl.INNER_SEP + i2 + ",F01th;");
                ms1.p(this.c.getAddress(), i3, i2);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.actionbar.getYesBtn().isEnabled()) {
            cs3.d(this, ah4.e(R.string.notification_doesnt_save_setting), ah4.e(R.string.common_save), ah4.e(R.string.discard_button), new is3.d() { // from class: dc.ti2
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.x4();
                }
            }, new is3.c() { // from class: dc.si2
                @Override // dc.is3.c
                public final void doCancel() {
                    this.a.z4();
                }
            }).show();
        } else {
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_threshold);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MyApplication myApplication = (MyApplication) getApplication();
        this.application = myApplication;
        this.a = myApplication.G();
        String stringExtra = getIntent().getStringExtra("threshold_toy_address_Id");
        this.b = stringExtra;
        this.c = this.a.Q(stringExtra);
        this.actionbar.setBackAction(new a());
        this.actionbar.setYesAction(R.string.common_save, new b());
        this.actionbar.getYesBtn().setEnabled(false);
        this.thresholdControl.setStepSize(10);
        this.thresholdControl.setShowTipAlways(true);
        this.thresholdControl.setListener(new c());
        ms1.n(this.c.getAddress(), 1);
        String strE = ah4.e(R.string.Resistence_tip);
        if (strE.startsWith("*")) {
            strE = strE.substring(1);
        }
        this.tvTip.setText(strE);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(c40 c40Var) {
        Toy toy = this.c;
        if (toy == null || !TextUtils.equals(toy.getAddress(), c40Var.a)) {
            return;
        }
        int i2 = c40Var.b;
        int i3 = c40Var.c;
        String str = "getToyThresholdEvent:x:" + i2 + ",y:" + i3;
        ye3.d("S0003", "getToyThresholdEvent:GetBkV:" + i2 + SignatureImpl.INNER_SEP + i3 + ",F01th;");
        if (i2 == 1) {
            if (this.c.isMiniXMachine()) {
                this.g = i3 >= 500 ? (i3 - 500) / 7 : 0;
            } else if (this.c.getToyVersion() >= 50) {
                this.g = i3 >= 1200 ? (i3 - 1200) / 14 : 0;
            } else {
                this.g = i3 >= 20 ? ((i3 - 20) * 100) / 20 : 0;
            }
        } else if (i2 == 2) {
            if (this.c.isMiniXMachine()) {
                this.g = i3 >= 2600 ? (i3 - 2600) / 19 : 0;
            } else if (this.c.getToyVersion() >= 50) {
                this.g = i3 >= 1200 ? (i3 - 1200) / 18 : 0;
            } else {
                this.g = i3 >= 25 ? ((i3 - 25) * 100) / 25 : 0;
            }
        }
        this.thresholdControl.setViewLocation(this.g);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(d40 d40Var) {
        Toy toy = this.c;
        if (toy == null || !TextUtils.equals(toy.getAddress(), d40Var.a)) {
            return;
        }
        int i2 = this.d + 1;
        this.d = i2;
        this.e += d40Var.b;
        if (i2 == this.f) {
            vr3 vr3Var = this.progressDialog;
            if (vr3Var != null && vr3Var.isShowing()) {
                this.progressDialog.dismiss();
            }
            if (this.e == this.f) {
                finish();
            }
        }
    }
}
