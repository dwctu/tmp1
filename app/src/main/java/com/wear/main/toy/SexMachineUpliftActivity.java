package com.wear.main.toy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.b40;
import dc.cs3;
import dc.ms1;
import dc.pc1;
import dc.sg3;
import dc.ye3;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class SexMachineUpliftActivity extends BaseActivity {
    public static String e = "toy_address";
    public pc1 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public Toy b;
    public boolean c;
    public boolean d = true;

    @BindView(R.id.switchButton)
    public SwitchView switchButton;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (SexMachineUpliftActivity.this.b.isConnected()) {
                ms1.o(SexMachineUpliftActivity.this.b.getAddress(), SexMachineUpliftActivity.this.c);
                ms1.m(SexMachineUpliftActivity.this.b.getAddress());
                return;
            }
            SexMachineUpliftActivity sexMachineUpliftActivity = SexMachineUpliftActivity.this;
            sexMachineUpliftActivity.w4(sexMachineUpliftActivity.c, false);
            SexMachineUpliftActivity.this.switchButton.setChecked(!r3.c);
            cs3.j(SexMachineUpliftActivity.this, ah4.e(R.string.set_gradual_speed_up_failed)).show();
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SexMachineUpliftActivity.this.c = z;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sex_machine_uplift);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MyApplication myApplication = (MyApplication) getApplication();
        this.application = myApplication;
        this.a = myApplication.G();
        this.actionbar.setYesAction(ah4.e(R.string.common_save), new a());
        this.b = this.a.Q(getIntent().getStringExtra(e));
        this.switchButton.setOnCheckedChangeListener(new b());
        ms1.m(this.b.getAddress());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(b40 b40Var) {
        String str = "onMessageEvent: 查询抬升状态：" + b40Var.b;
        if (this.d) {
            this.switchButton.setChecked(b40Var.b == 1);
            this.d = false;
            return;
        }
        if (TextUtils.equals(this.b.getAddress(), b40Var.a)) {
            boolean z = b40Var.b == 1;
            if (this.c != z) {
                w4(z, false);
                this.switchButton.setChecked(!this.c);
                cs3.j(this, ah4.e(R.string.set_gradual_speed_up_failed)).show();
            } else {
                w4(z, true);
                sg3.l(ah4.e(R.string.comman_saved_successfully));
                finish();
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void w4(boolean z, boolean z2) {
        HashMap map = new HashMap();
        map.put("type", Integer.valueOf(z ? 1 : 2));
        map.put("result", Integer.valueOf(z2 ? 1 : 2));
        map.put("toy_mac", this.b.getDeviceId());
        ye3.d("M0050", WearUtils.A.toJson(map));
    }
}
