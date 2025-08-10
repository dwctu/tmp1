package com.wear.component.dxtoy.toy.update;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.component.dxbluetooth.lib.bean.BleSearchDeviceBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.vending.expansion.downloader.Constants;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.main.toy.dfu.DfuService;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.TextOverlayImageView;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.dq1;
import dc.hf3;
import dc.kc0;
import dc.kn3;
import dc.oc0;
import dc.pc1;
import dc.rc0;
import dc.rq1;
import dc.se0;
import dc.sg3;
import dc.sp1;
import dc.th4;
import dc.tn2;
import dc.vc1;
import dc.xe3;
import dc.yb1;
import dc.zn2;
import java.util.HashMap;
import java.util.Iterator;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToyUpgradeActivity extends BaseActivity {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public Toy c;
    public boolean i;

    @BindView(R.id.iv_dfu_toy_battery)
    public TextOverlayImageView iv_dfu_toy_battery;

    @BindView(R.id.ll_dfu_toy_battery)
    public LinearLayout ll_dfu_toy_battery;

    @BindView(R.id.low_battery)
    public LinearLayout lowBattery;

    @BindView(R.id.low_battery_ok)
    public Button lowBatteryOk;

    @BindView(R.id.low_battery_update_btn)
    public Button lowBatteryUpdateBtn;

    @BindView(R.id.progressbar_uploading)
    public ProgressBar progressbarUploading;

    @BindView(R.id.toy_name)
    public TextView toyName;

    @BindView(R.id.toy_update_notice)
    public TextView toyUpdateNotice;

    @BindView(R.id.toy_dfu_icon)
    public ImageView toy_dfu_icon;

    @BindView(R.id.toy_upgrade_fail)
    public ImageView toy_upgrade_fail;

    @BindView(R.id.tv_update_tip)
    public TextView tvUpdateTip;

    @BindView(R.id.toy_update_tip_take)
    public TextView tvUpdateTipTake;

    @BindView(R.id.tv_upgrade_status)
    public TextView tvUpgradeStatus;

    @BindView(R.id.tv_dfu_toy_battery)
    public TextView tv_dfu_toy_battery;

    @BindView(R.id.update_btn)
    public Button updateBtn;

    @BindView(R.id.uploading_title)
    public TextView uploadingTitle;
    public pc1 b = null;
    public String d = "";
    public boolean e = false;
    public boolean f = false;
    public int g = 100;
    public int h = 100;
    public int j = 0;
    public boolean k = false;
    public final oc0 l = new g();

    public class a implements kn3.d {
        public a(ToyUpgradeActivity toyUpgradeActivity) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sp1.a(ToyUpgradeActivity.this.c.getLogToyType());
            xe3.a("dfuSdk", "点击升级按钮！");
            ToyUpgradeActivity.this.X4(true);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyUpgradeActivity.this.finish();
        }
    }

    public class d implements kn3.d {
        public d(ToyUpgradeActivity toyUpgradeActivity) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyUpgradeActivity.this.finish();
        }
    }

    public class f implements zn2<String> {
        public f(ToyUpgradeActivity toyUpgradeActivity) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            WearUtils.e1(str);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class g implements oc0 {
        public g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void e() {
            ToyUpgradeActivity.this.E4();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void g() {
            ToyUpgradeActivity.this.showLoadingProgress();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(boolean z, String str) {
            if (z) {
                ToyUpgradeActivity.this.Z4();
            } else if (ToyUpgradeActivity.this.k) {
                ToyUpgradeActivity.this.Y4(str);
            } else {
                ToyUpgradeActivity.this.D4(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void k(int i) {
            ToyUpgradeActivity.this.C4(i);
        }

        @Override // dc.oc0
        public void a(final boolean z, @Nullable final String str) {
            se0.f(new Runnable() { // from class: dc.ft1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(z, str);
                }
            });
        }

        @Override // dc.oc0
        public void b(int i) {
            if (i < 100) {
                se0.f(new Runnable() { // from class: dc.dt1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g();
                    }
                });
            } else {
                ToyUpgradeActivity.this.k = true;
                se0.f(new Runnable() { // from class: dc.et1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e();
                    }
                });
            }
        }

        @Override // dc.oc0
        public void c(final int i) {
            se0.f(new Runnable() { // from class: dc.ct1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K4(View view) {
        if (!this.e) {
            rq1.d.r(this.a);
            finish();
        } else {
            kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.toy_update_exit_notice), ah4.e(R.string.common_ok), false, false, (kn3.d) new a(this));
            kn3Var.show();
            kn3Var.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M4(View view) {
        sp1.a(this.c.getLogToyType());
        xe3.a("dfuSdk", "点击升级按钮！");
        X4(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O4(View view) {
        finish();
    }

    public final void B4() {
        ((NotificationManager) getSystemService("notification")).cancel(DfuBaseService.NOTIFICATION_ID);
    }

    public final void C4(int i) {
        if (this.progressbarUploading.getVisibility() == 8) {
            this.progressbarUploading.setVisibility(0);
        }
        this.progressbarUploading.setIndeterminate(false);
        int i2 = ((int) (i * 0.9d)) + 10;
        this.progressbarUploading.setProgress(i2);
        this.uploadingTitle.setText(ah4.f(R.string.dfu_uploading_percentage, Integer.valueOf(i2)));
        P4();
    }

    public final void D4(String str) {
        dismissLoadingProgress();
        if (TextUtils.isEmpty(str)) {
            str = "download file fail";
        }
        Q4(R.string.firmwar_upgrading_subtitle_sever_error, str);
        if (I4()) {
            W4();
        }
    }

    public final void E4() {
        dismissLoadingProgress();
        sp1.e(this.d);
        S4(R.string.firmwar_upgrading_title_reboot, R.string.firmwar_upgrading_subtitle_reboot, true);
        this.progressbarUploading.setIndeterminate(false);
        this.uploadingTitle.setText(ah4.f(R.string.dfu_uploading_percentage, 10));
        this.progressbarUploading.setProgress(10);
        HashMap map = new HashMap();
        map.put("dfuUrl", this.d);
        map.put("isSilicon", Boolean.valueOf(this.i));
        sp1.f(WearUtils.A.toJson(map));
        S4(R.string.firmwar_upgrading_title_start, R.string.firmwar_upgrading_subtitle_start, false);
    }

    public final int F4(boolean z) {
        return z ? R.drawable.content_icon_gray : R.drawable.nav_unknown_1;
    }

    public final boolean G4() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        return adapter != null && adapter.isEnabled();
    }

    public final void H4() {
        if (getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return;
        }
        V4(R.string.no_ble);
    }

    public final boolean I4() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (DfuService.class.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public final void P4() {
        this.toy_dfu_icon.setImageResource(this.c.getDfuIcon(false));
        this.toy_upgrade_fail.setVisibility(8);
        S4(R.string.firmwar_upgrading_title_start, R.string.firmwar_upgrading_subtitle_start, false);
        this.updateBtn.setVisibility(8);
        this.uploadingTitle.setVisibility(0);
    }

    public final void Q4(int i, String str) {
        sp1.c(str);
        xe3.a("dfuSdk", "升级失败！" + str);
        this.toy_dfu_icon.setImageResource(F4(true));
        this.toy_upgrade_fail.setVisibility(0);
        this.toyUpdateNotice.setText(i);
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.text_color_85));
        this.updateBtn.setText(ah4.e(R.string.common_ok));
        this.updateBtn.setVisibility(0);
        this.updateBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.gt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.O4(view);
            }
        });
        this.tvUpgradeStatus.setVisibility(0);
        this.tvUpgradeStatus.setTextColor(th4.b(this, R.color.orgy_background_color));
        this.tvUpgradeStatus.setText(ah4.e(R.string.firmwar_upgrading_title_failed));
        this.tvUpdateTip.setVisibility(8);
        this.progressbarUploading.setIndeterminate(false);
        this.progressbarUploading.setVisibility(8);
        this.uploadingTitle.setVisibility(8);
        this.e = false;
        B4();
    }

    public final void R4() {
        sp1.d(this.d);
        xe3.a("dfuSdk", "SDK 升级成功！");
        this.updateBtn.setText(ah4.e(R.string.common_ok));
        this.updateBtn.setVisibility(0);
        this.tvUpgradeStatus.setVisibility(0);
        this.tvUpgradeStatus.setText(ah4.e(R.string.firmwar_upgrading_title_success));
        this.tvUpdateTip.setVisibility(8);
        this.progressbarUploading.setIndeterminate(false);
        this.progressbarUploading.setVisibility(8);
        this.uploadingTitle.setVisibility(8);
        this.toyUpdateNotice.setText(ah4.e(R.string.firmwar_upgrading_subtitle_success));
        this.b.Q(this.a).setVersion(10);
        if (this.i) {
            this.tvUpdateTipTake.setVisibility(0);
        }
        this.e = false;
        this.c.setUpdateDfu(null);
        this.updateBtn.setOnClickListener(new e());
        HashMap map = new HashMap();
        map.put(PSOProgramService.VS_Key, this.c.getDeviceType());
        tn2.x(WearUtils.x).t("/app/toy/dfu/upgraded", map, new f(this));
        B4();
    }

    public final void S4(int i, int i2, boolean z) {
        this.tvUpgradeStatus.setVisibility(0);
        this.tvUpgradeStatus.setTextColor(th4.b(this, R.color.text_color_85));
        this.tvUpgradeStatus.setText(i);
        this.toyUpdateNotice.setText(i2);
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.text_color_85));
        this.tvUpdateTip.setVisibility((z && TextUtils.equals(this.c.getType(), "dolce")) ? 0 : 8);
    }

    public final void T4(int i) {
        this.lowBattery.setVisibility(0);
        this.toyUpdateNotice.setText(ah4.e(i));
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.orgy_background_color));
        this.updateBtn.setVisibility(8);
    }

    public final void U4() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 0);
    }

    public final void V4(int i) {
        sg3.h(i);
    }

    public final void W4() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
        intent.putExtra(DfuBaseService.EXTRA_ACTION, 0);
        localBroadcastManager.sendBroadcast(intent);
    }

    public final void X4(boolean z) {
        if (this.e) {
            return;
        }
        if (!yb1.A) {
            Toy toy = this.c;
            if (toy == null || toy.getUpdateDfu() == null || !this.c.getUpdateDfu().isHasUpdate()) {
                Q4(R.string.dfu_toy_status_invalid, "DfuBean empty");
                return;
            } else if (WearUtils.e1(this.c.getUpdateDfu().getUrl())) {
                Q4(R.string.dfu_toy_status_invalid, "url empty");
                return;
            }
        }
        if (!hf3.d(this)) {
            sg3.h(R.string.firmwar_upgrading_subtitle_network_error);
            return;
        }
        if (!this.c.isConnected()) {
            sg3.h(R.string.toy_not_found);
            return;
        }
        if (!z) {
            int i = this.h;
            if (i > 0 && i < 10 && this.g > 10) {
                T4(R.string.firmwar_toy_low_battery);
                return;
            }
            if (i > 10 && this.g < 10) {
                T4(R.string.firmwar_phone_low_battery);
                return;
            } else if (i > 0 && i < 10 && this.g < 10) {
                T4(R.string.firmwar_toy_and_phone_low_battery);
                return;
            }
        }
        this.f = true;
        this.e = true;
        this.ll_dfu_toy_battery.setVisibility(8);
        this.lowBattery.setVisibility(8);
        this.updateBtn.setVisibility(8);
        this.uploadingTitle.setVisibility(0);
        this.uploadingTitle.setText(ah4.e(R.string.dfu_status_uploading_title));
        this.progressbarUploading.setIndeterminate(true);
        this.progressbarUploading.setVisibility(0);
        S4(R.string.firmwar_upgrading_title_download, R.string.firmwar_upgrading_subtitle_download, false);
        String url = this.c.getUpdateDfu().getUrl();
        this.d = url;
        sp1.b(url);
        kc0.n(this.a, this.l);
    }

    public final void Y4(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Upgrade firmware fail";
        }
        Q4(R.string.firmwar_upgrading_subtitle_third_party_error, str);
    }

    public final void Z4() {
        R4();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.e) {
            rq1.d.r(this.a);
            finish();
        } else {
            kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.toy_update_exit_notice), ah4.e(R.string.common_ok), false, false, (kn3.d) new d(this));
            kn3Var.show();
            kn3Var.n();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_dfu);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.b = WearUtils.x.G();
        this.a = getIntent().getStringExtra("dfu_toy_address_Id");
        this.actionbar.setTitle(ah4.e(R.string.toy_update_title));
        this.actionbar.setBackAction(new MyActionBar.f() { // from class: dc.it1
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.K4(view);
            }
        });
        Toy toyQ = this.b.Q(this.a);
        this.c = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        this.i = kc0.k(this.a);
        this.h = this.c.getBattery();
        if (this.c.isF01Toy()) {
            this.ll_dfu_toy_battery.setVisibility(8);
        } else {
            this.ll_dfu_toy_battery.setVisibility(0);
            this.c.updateMyToyBattery(this, this.iv_dfu_toy_battery);
            this.tv_dfu_toy_battery.setText(this.h + "%");
            if (this.h <= 0) {
                dq1.a(this.a);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            int intProperty = ((BatteryManager) getSystemService("batterymanager")).getIntProperty(4);
            String str = "onCreate: " + intProperty;
            if (intProperty > 0) {
                this.g = intProperty;
            }
        }
        this.toy_dfu_icon.setImageResource(F4(false));
        this.toyName.setText(this.c.getName());
        this.toy_upgrade_fail.setVisibility(8);
        this.lowBattery.setVisibility(8);
        this.toyUpdateNotice.setText(ah4.e(R.string.toy_update_notice));
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.text_color_85));
        this.updateBtn.setText(ah4.e(R.string.toy_update_bnt));
        this.updateBtn.setVisibility(0);
        this.uploadingTitle.setVisibility(8);
        this.progressbarUploading.setVisibility(8);
        this.lowBatteryUpdateBtn.setOnClickListener(new b());
        this.lowBatteryOk.setOnClickListener(new c());
        this.updateBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.ht1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.M4(view);
            }
        });
        H4();
        if (G4()) {
            return;
        }
        U4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(rc0 rc0Var) {
        BleSearchDeviceBean bleSearchDeviceBean;
        if (!TextUtils.isEmpty(rc0Var.getA()) && (bleSearchDeviceBean = rc0Var.a().get(rc0Var.getA())) != null) {
            sp1.g(bleSearchDeviceBean.getName() + Constants.FILENAME_SEQUENCE_SEPARATOR + rc0Var.getA());
        }
        sp1.h("扫描结果:" + rc0Var.a().size() + ", deviceName:" + rc0Var.b());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        Toy toy;
        if (vc1Var == null || this.f || (toy = this.c) == null || toy.isF01Toy() || this.h == 9) {
            return;
        }
        this.j++;
        if (vc1Var.a().equals(this.a)) {
            int iB = vc1Var.b();
            this.h = iB;
            if (iB > 0) {
                this.ll_dfu_toy_battery.setVisibility(0);
                this.c.updateMyToyBattery(this, this.iv_dfu_toy_battery);
                this.tv_dfu_toy_battery.setText(this.h + "%");
                return;
            }
            if (this.j > 10) {
                this.ll_dfu_toy_battery.setVisibility(0);
                this.c.updateMyToyBattery(this, this.iv_dfu_toy_battery);
                this.tv_dfu_toy_battery.setText(this.h + "%");
                return;
            }
            dq1.a(this.a);
        }
    }
}
