package com.wear.main.toy.pin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.ExoPlayer;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.dao.DaoUtils;
import com.wear.main.account.UserGuidesActivity;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.dialog.ToyPinOnDialog;
import dc.ah4;
import dc.as1;
import dc.b20;
import dc.cs3;
import dc.is3;
import dc.qg3;
import dc.sg3;
import dc.ud3;
import dc.xb1;
import dc.ye3;
import dc.z10;
import dc.zr1;
import java.util.HashMap;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class ToyPinSettingActivity extends BaseActivity {
    public static String c = "gp";
    public static String d = "sf";
    public static String e = "so";
    public static String f = "sc";
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public Toy b;

    @BindView(R.id.change_pin)
    public TextView changePin;

    @BindView(R.id.disable_pin)
    public TextView disablePin;

    @BindView(R.id.enable_pin)
    public TextView enablePin;

    @BindView(R.id.ll_security_pin)
    public LinearLayout llSecurityPin;

    @BindView(R.id.ll_set_pin_success)
    public LinearLayout llSetPinSuccess;

    @BindView(R.id.set_success_ok)
    public TextView setSuccessOk;

    @BindView(R.id.tv_pin_success)
    public TextView tvPinSuccess;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ToyPinSettingActivity.this.startActivity(new Intent(ToyPinSettingActivity.this, (Class<?>) UserGuidesActivity.class));
        }
    }

    public class b implements View.OnClickListener {

        public class a implements ToyPinOnDialog.c {
            public a() {
            }

            @Override // com.wear.widget.dialog.ToyPinOnDialog.c
            public void doConfirm() {
                if (!ToyPinSettingActivity.this.b.isConnected()) {
                    sg3.h(R.string.toy_settings_no_toy_toast);
                    return;
                }
                Intent intent = new Intent(ToyPinSettingActivity.this, (Class<?>) ToyPinSetCodeActivity.class);
                intent.putExtra("toyAddress", ToyPinSettingActivity.this.b.getAddress());
                intent.putExtra("type", 0);
                ToyPinSettingActivity.this.startActivity(intent);
                ToyPinSettingActivity.this.finish();
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ye3.k("toys", "security_pin_setting_click", "click", "security_pin_setting", "", StreamManagement.Enable.ELEMENT, "", -1L, ToyPinSettingActivity.this.b.getAddress());
            is3.b bVar = new is3.b(ToyPinSettingActivity.this);
            bVar.k(R.layout.dialog_security_enable);
            bVar.q(ah4.e(R.string.pin_enale_tip_title));
            bVar.p(ah4.e(R.string.pin_enale_tip_des));
            ToyPinOnDialog toyPinOnDialog = (ToyPinOnDialog) cs3.i(bVar, ToyPinOnDialog.class);
            toyPinOnDialog.setConfirmListener(new a());
            toyPinOnDialog.show();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ye3.k("toys", "security_pin_setting_click", "click", "security_pin_setting", "", "disable", "", -1L, ToyPinSettingActivity.this.b.getAddress());
            if (!ToyPinSettingActivity.this.b.isConnected()) {
                sg3.h(R.string.toy_settings_no_toy_toast);
                return;
            }
            ToyPinSettingActivity.this.showDialog();
            zr1.c(ToyPinSettingActivity.this.b, false);
            HashMap map = new HashMap();
            map.put("mac", ToyPinSettingActivity.this.b.getAddress().toUpperCase().replace(SignatureImpl.INNER_SEP, ""));
            map.put("type", ToyPinSettingActivity.this.b.getType());
            ye3.d("C0012", WearUtils.A.toJson(map));
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ToyPinSettingActivity.this.b.isConnected()) {
                sg3.h(R.string.toy_settings_no_toy_toast);
                return;
            }
            Intent intent = new Intent(ToyPinSettingActivity.this, (Class<?>) ToyPinSetCodeActivity.class);
            intent.putExtra("toyAddress", ToyPinSettingActivity.this.b.getAddress());
            intent.putExtra("type", 1);
            ToyPinSettingActivity.this.startActivity(intent);
            ToyPinSettingActivity.this.finish();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinSettingActivity.this.startActivity(new Intent(ToyPinSettingActivity.this, (Class<?>) NewToyActivity.class));
            ToyPinSettingActivity.this.finish();
        }
    }

    public class f implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ud3.c(null, ToyPinSettingActivity.this.b.getAddress());
                DaoUtils.getToyPinStatusDao().delToyPinStatus(ToyPinSettingActivity.this.b.getAddress());
                ToyPinSettingActivity toyPinSettingActivity = ToyPinSettingActivity.this;
                qg3.e(toyPinSettingActivity, toyPinSettingActivity.b.getAddress());
                ToyPinSettingActivity.this.dissDialog();
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            as1.a(ToyPinSettingActivity.this.b.getAddress());
            ToyPinSettingActivity.this.b.setPinStatus("0");
            ToyPinSettingActivity.this.b.setUuid(xb1.a(ToyPinSettingActivity.this.b.getUuid()));
            DaoUtils.getToyDao().updateOrAdd(ToyPinSettingActivity.this.b);
            ToyPinSettingActivity.this.llSecurityPin.setVisibility(8);
            ToyPinSettingActivity.this.llSetPinSuccess.setVisibility(0);
            ToyPinSettingActivity.this.b.setIsSelect(0);
            new Handler().postDelayed(new a(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_pin_setting);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.actionbar.setYesAction("Tip", new a());
        this.a = getIntent().getStringExtra("toyAddress");
        Toy toyQ = WearUtils.x.G().Q(this.a);
        this.b = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        WearUtils.x.G();
        if (this.b.isConnected()) {
            zr1.a(this.b.getAddress());
        }
        if (xb1.b(this.b.getUuid(), this.b.getAddress())) {
            this.enablePin.setVisibility(0);
            this.disablePin.setVisibility(8);
            this.changePin.setVisibility(8);
        } else {
            this.enablePin.setVisibility(8);
            this.disablePin.setVisibility(0);
            this.changePin.setVisibility(0);
        }
        this.enablePin.setOnClickListener(new b());
        this.disablePin.setOnClickListener(new c());
        this.changePin.setOnClickListener(new d());
        this.llSecurityPin.setVisibility(0);
        this.llSetPinSuccess.setVisibility(8);
        this.setSuccessOk.setOnClickListener(new e());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(z10 z10Var) {
        if (this.b.getAddress().equals(z10Var.getA())) {
            if (z10Var.getB() == -1) {
                this.b.setPinStatus("-1");
                return;
            }
            if (z10Var.getB() == 1) {
                this.b.setPinStatus("1");
                this.enablePin.setVisibility(8);
                this.disablePin.setVisibility(0);
                this.changePin.setVisibility(0);
                return;
            }
            this.b.setPinStatus("0");
            this.enablePin.setVisibility(0);
            this.disablePin.setVisibility(8);
            this.changePin.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(b20 b20Var) {
        if (this.b.getAddress().equals(b20Var.getA())) {
            if (b20Var.getB() == 0) {
                new Handler().postDelayed(new f(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            }
            return;
        }
        dissDialog();
    }
}
