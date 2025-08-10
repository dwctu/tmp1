package com.wear.main.toy;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.DepthControlView;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.ch3;
import dc.cs3;
import dc.db2;
import dc.is3;
import dc.jr1;
import dc.na2;
import dc.pc1;
import dc.rq1;
import dc.wc1;
import dc.xc1;
import dc.xe3;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToyDepthControlActivity extends BaseActivity implements DepthControlView.b {
    public MyApplication a;
    public String b;
    public pc1 c = null;
    public Toy d;

    @BindView(R.id.dcv_control)
    public DepthControlView dcvControl;
    public Dialog e;

    @BindView(R.id.sb_depth_control)
    public SwitchView sbDepthControl;

    @BindView(R.id.tv_depth_control)
    public TextView tvDepthControl;

    public class a implements is3.d {
        public a() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            ToyDepthControlActivity.this.finish();
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ToyDepthControlActivity toyDepthControlActivity = ToyDepthControlActivity.this;
            if (!toyDepthControlActivity.c.a(toyDepthControlActivity.b)) {
                ToyDepthControlActivity.this.sbDepthControl.setCheckedImmediatelyNoEvent(!z);
                return;
            }
            if (z) {
                ToyDepthControlActivity.this.d.setMissionSolo(1);
                xe3.a("DepthControl", "设置：SetSolo:1;");
                jr1.j(ToyDepthControlActivity.this.b, true);
            } else {
                ToyDepthControlActivity.this.d.setMissionSolo(0);
                xe3.a("DepthControl", "设置：SetSolo:0;");
                jr1.j(ToyDepthControlActivity.this.b, false);
            }
        }
    }

    @Override // com.wear.widget.DepthControlView.b
    public void G3(int i, int i2) {
        xe3.a("DepthControl", "setDeth:" + i + "  " + i2);
        if (this.c.a(this.d.getAddress())) {
            rq1.d.t(this.d.getAddress(), 0);
            jr1.k(this.d.getAddress(), i, i2);
            this.d.getMissionTchLvl()[i - 1] = i2;
        }
    }

    @Override // com.wear.widget.DepthControlView.b
    public void e(int i) {
        if (this.c.a(this.d.getAddress())) {
            rq1.d.t(this.d.getAddress(), i);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_depth_control);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MyApplication myApplication = (MyApplication) getApplication();
        this.a = myApplication;
        this.c = myApplication.G();
        String stringExtra = getIntent().getStringExtra("toy_address");
        this.b = stringExtra;
        this.d = this.c.Q(stringExtra);
        is3.b bVar = new is3.b(this);
        bVar.p(ah4.e(R.string.toy_program_disconnected));
        bVar.o(ah4.e(R.string.common_back));
        bVar.k(R.layout.dialog_default_ok);
        bVar.d(new a());
        this.e = cs3.i(bVar, is3.class);
        Toy toy = this.d;
        if (toy == null) {
            finish();
            return;
        }
        this.sbDepthControl.setCheckedImmediatelyNoEvent(toy.getMissionSolo() == 1);
        this.sbDepthControl.setOnCheckedChangeListener(new b());
        this.dcvControl.setListener(this);
        s4(this.c.a(this.b));
        t4(this.d.getMissionTchLvl());
        if (this.c.a(this.b)) {
            return;
        }
        this.e.show();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c.a(this.d.getAddress())) {
            boolean z = true;
            if (ch3.n().u() != null && (db2.A().G() || na2.m().i())) {
                z = false;
            }
            if (z) {
                rq1.d.t(this.d.getAddress(), 0);
            } else {
                xe3.a("DepthControl", "有控制状态，不发SetCtlPan:0;指令，其中control：" + db2.A().G());
            }
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        if (this.d.getAddress().equals(xc1Var.a())) {
            if (xc1Var.b() == 1) {
                s4(true);
                xe3.a("DepthControl", "SetCtlPan:1;");
                jr1.i(this.b, true);
                this.e.dismiss();
                return;
            }
            if (xc1Var.b() == -1) {
                s4(false);
                this.e.show();
            }
        }
    }

    public final void s4(boolean z) {
        if (z) {
            this.tvDepthControl.setTextColor(getResources().getColor(R.color.text_primary_light));
            this.sbDepthControl.setEnabled(true);
            this.dcvControl.setEnabled(true);
        } else {
            this.tvDepthControl.setTextColor(getResources().getColor(R.color.text_secondary_light));
            this.sbDepthControl.setEnabled(false);
            this.dcvControl.setEnabled(false);
        }
    }

    public final void t4(int[] iArr) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        this.dcvControl.setViewLocation(iArr);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(wc1 wc1Var) {
        if (this.b.equals(wc1Var.a())) {
            String strB = wc1Var.b();
            if (WearUtils.e1(strB)) {
                return;
            }
            if (strB.startsWith("Solo:")) {
                this.sbDepthControl.setCheckedImmediatelyNoEvent(this.d.getMissionSolo() == 1);
            } else if (strB.startsWith("TchLvl:")) {
                this.dcvControl.setViewLocation(this.d.getMissionTchLvl());
            }
        }
    }
}
