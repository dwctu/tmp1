package com.wear.main.toy;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.bean.ToySelectEvent;
import com.wear.main.toy.dfu.DfuService;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.TextOverlayImageView;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.bf3;
import dc.dq1;
import dc.ff3;
import dc.hf3;
import dc.kn3;
import dc.pc1;
import dc.q61;
import dc.rq1;
import dc.sg3;
import dc.sp1;
import dc.t51;
import dc.tb1;
import dc.th4;
import dc.tn2;
import dc.u51;
import dc.vc1;
import dc.wc1;
import dc.xe3;
import dc.yb1;
import dc.zb1;
import dc.zi2;
import dc.zn2;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import no.nordicsemi.android.dfu.DfuBaseService;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToyDfuActivity extends BaseActivity implements yb1.k {
    public MyApplication a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public String c;
    public String d;
    public Toy g;
    public File h;
    public int i;

    @BindView(R.id.iv_dfu_toy_battery)
    public TextOverlayImageView iv_dfu_toy_battery;
    public BluetoothDevice k;

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
    public boolean s;

    @BindView(R.id.toy_up_case_name)
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
    public Handler e = new Handler(Looper.getMainLooper());
    public pc1 f = null;
    public boolean j = false;
    public String l = "";
    public String m = "";
    public boolean n = false;
    public boolean o = false;
    public int p = 100;
    public int q = 100;
    public final DfuProgressListener t = new o();
    public int u = 0;

    public class a implements zn2<String> {
        public a(ToyDfuActivity toyDfuActivity) {
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

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyDfuActivity.this.progressbarUploading.setVisibility(0);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyDfuActivity.this.E4();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyDfuActivity.this.progressbarUploading.setVisibility(0);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ToyDfuActivity.this.progressbarUploading.getVisibility() == 8) {
                ToyDfuActivity.this.progressbarUploading.setVisibility(0);
            }
            ToyDfuActivity.this.progressbarUploading.setIndeterminate(false);
            int i = ((int) (this.a * 0.9d)) + 10;
            ToyDfuActivity.this.progressbarUploading.setProgress(i);
            ToyDfuActivity.this.P4();
            if (this.a % 10 == 0) {
                xe3.a("dfuSdk", "SDK onProgressChanged " + this.a);
            }
            ToyDfuActivity.this.uploadingTitle.setText(ah4.f(R.string.dfu_uploading_percentage, Integer.valueOf(i)));
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyDfuActivity.this.R4();
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public g(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 133) {
                ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_toy_disconnect, "onError:#" + this.a + "#" + this.b + "#" + this.c);
                return;
            }
            ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_third_party_error, "onError:#" + this.a + "#" + this.b + "#" + this.c);
        }
    }

    public class h implements u51 {
        public h(ToyDfuActivity toyDfuActivity) {
        }

        @Override // dc.u51
        public /* synthetic */ void a(List list, boolean z) {
            t51.a(this, list, z);
        }

        @Override // dc.u51
        public void b(@NonNull List<String> list, boolean z) {
        }
    }

    public class i implements kn3.d {
        public i(ToyDfuActivity toyDfuActivity) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sp1.a(ToyDfuActivity.this.g.getLogToyType());
            xe3.a("dfuSdk", "点击升级按钮！");
            ToyDfuActivity.this.Y4(true);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyDfuActivity.this.finish();
        }
    }

    public class l extends ff3 {
        public l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(BluetoothDevice bluetoothDevice) throws NumberFormatException {
            if (bluetoothDevice == null) {
                ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_no_toy, "toy disconnect");
                return;
            }
            ToyDfuActivity toyDfuActivity = ToyDfuActivity.this;
            toyDfuActivity.k = bluetoothDevice;
            toyDfuActivity.onUploadClicked(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            zi2.h(ToyDfuActivity.this, new zi2.c() { // from class: dc.ih2
                @Override // dc.zi2.c
                public final void a(BluetoothDevice bluetoothDevice) throws NumberFormatException {
                    this.a.f(bluetoothDevice);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void j() throws NumberFormatException {
            xe3.a("dfuSdk", "下载地址：" + ToyDfuActivity.this.l);
            ToyDfuActivity.this.dismissLoadingProgress();
            String str = ToyDfuActivity.this.i == 0 ? "(?i)ZIP" : "(?i)HEX|BIN";
            ToyDfuActivity toyDfuActivity = ToyDfuActivity.this;
            toyDfuActivity.j = MimeTypeMap.getFileExtensionFromUrl(toyDfuActivity.h.getAbsolutePath()).matches(str);
            boolean z = ToyDfuActivity.this.j;
            sp1.e(ToyDfuActivity.this.l);
            if (!ToyDfuActivity.this.F4()) {
                ToyDfuActivity.this.Q4(R.string.system_bluetooth_off, "isBLEEnabled=" + ToyDfuActivity.this.F4());
                return;
            }
            if (!z) {
                ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_sever_error, str + "#" + ToyDfuActivity.this.j + "#");
                return;
            }
            if (!yb1.A) {
                ToyDfuActivity toyDfuActivity2 = ToyDfuActivity.this;
                if (!bf3.b(toyDfuActivity2.m, toyDfuActivity2.h)) {
                    File file = ToyDfuActivity.this.h;
                    String strA = file != null ? bf3.a(file) : "";
                    ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_sever_error, ToyDfuActivity.this.l + "#" + ToyDfuActivity.this.m + "#" + strA);
                    return;
                }
            }
            ToyDfuActivity.this.S4(R.string.firmwar_upgrading_title_reboot, R.string.firmwar_upgrading_subtitle_reboot, true);
            ToyDfuActivity.this.progressbarUploading.setIndeterminate(false);
            ToyDfuActivity.this.uploadingTitle.setText(ah4.f(R.string.dfu_uploading_percentage, 10));
            ToyDfuActivity.this.progressbarUploading.setProgress(10);
            HashMap map = new HashMap();
            map.put("dfuUrl", ToyDfuActivity.this.l);
            map.put("isSilicon", Boolean.valueOf(ToyDfuActivity.this.s));
            sp1.f(WearUtils.A.toJson(map));
            ToyDfuActivity toyDfuActivity3 = ToyDfuActivity.this;
            if (toyDfuActivity3.s) {
                toyDfuActivity3.onUploadClicked(null);
            } else {
                toyDfuActivity3.f.e(toyDfuActivity3.g.getAddress(), "DFU;");
                ToyDfuActivity.this.e.postDelayed(new Runnable() { // from class: dc.fh2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.h();
                    }
                }, 2500L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void l(Object obj) {
            ToyDfuActivity.this.dismissLoadingProgress();
            ToyDfuActivity toyDfuActivity = ToyDfuActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append("Get Server Dfu File error :");
            sb.append(obj != null ? obj.toString() : "");
            sb.append(" dfuUrl=");
            sb.append(ToyDfuActivity.this.l);
            toyDfuActivity.Q4(R.string.firmwar_upgrading_subtitle_sever_error, sb.toString());
        }

        @Override // dc.ff3
        public void b(boolean z, final Object obj) {
            if (!z) {
                ToyDfuActivity.this.e.post(new Runnable() { // from class: dc.gh2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l(obj);
                    }
                });
                return;
            }
            ToyDfuActivity toyDfuActivity = ToyDfuActivity.this;
            toyDfuActivity.h = (File) obj;
            toyDfuActivity.e.post(new Runnable() { // from class: dc.hh2
                @Override // java.lang.Runnable
                public final void run() throws NumberFormatException {
                    this.a.j();
                }
            });
        }
    }

    public class m extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void b(BluetoothDevice bluetoothDevice) {
                File file;
                if (bluetoothDevice == null) {
                    ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_no_toy, "toy disconnect");
                    return;
                }
                ToyDfuActivity toyDfuActivity = ToyDfuActivity.this;
                toyDfuActivity.k = bluetoothDevice;
                String absolutePath = (yb1.A || (file = toyDfuActivity.h) == null) ? "" : file.getAbsolutePath();
                yb1 yb1VarE = yb1.E();
                MyApplication myApplication = ToyDfuActivity.this.a;
                ToyDfuActivity toyDfuActivity2 = ToyDfuActivity.this;
                yb1VarE.F(myApplication, toyDfuActivity2.k, absolutePath, toyDfuActivity2);
            }

            @Override // java.lang.Runnable
            public void run() {
                zi2.h(ToyDfuActivity.this, new zi2.c() { // from class: dc.jh2
                    @Override // dc.zi2.c
                    public final void a(BluetoothDevice bluetoothDevice) {
                        this.a.b(bluetoothDevice);
                    }
                });
            }
        }

        public m() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ToyDfuActivity.this.runOnUiThread(new a());
        }
    }

    public class n implements kn3.d {
        public n(ToyDfuActivity toyDfuActivity) {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
        }
    }

    public class o extends DfuProgressListenerAdapter {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ToyDfuActivity.this.R4();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ToyDfuActivity.this.Q4(R.string.dfu_file_status_invalid, "on Dfu Aborted");
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ String c;

            public c(int i, int i2, String str) {
                this.a = i;
                this.b = i2;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a == 133) {
                    ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_toy_disconnect, "onError:#" + this.a + "#" + this.b + "#" + this.c);
                    return;
                }
                ToyDfuActivity.this.Q4(R.string.firmwar_upgrading_subtitle_third_party_error, "onError:#" + this.a + "#" + this.b + "#" + this.c);
            }
        }

        public o() {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnecting(String str) {
            ToyDfuActivity.this.progressbarUploading.setVisibility(0);
            xe3.a("dfuSdk", "SDK onDeviceConnecting！");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnecting(String str) {
            ToyDfuActivity.this.E4();
            xe3.a("dfuSdk", "SDK onDeviceDisconnecting！");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuAborted(String str) {
            new Handler().postDelayed(new b(), 200L);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuCompleted(String str) {
            new Handler().postDelayed(new a(), 200L);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarting(String str) {
            ToyDfuActivity.this.progressbarUploading.setVisibility(0);
            xe3.a("dfuSdk", "SDK onDfuProcessStarting！");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onEnablingDfuMode(String str) {
            xe3.a("dfuSdk", "SDK onEnablingDfuMode！");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onError(String str, int i, int i2, String str2) {
            new Handler().postDelayed(new c(i, i2, str2), 200L);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onFirmwareValidating(String str) {
            ToyDfuActivity.this.E4();
            xe3.a("dfuSdk", "SDK onFirmwareValidating！");
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onProgressChanged(String str, int i, float f, float f2, int i2, int i3) {
            if (ToyDfuActivity.this.progressbarUploading.getVisibility() == 8) {
                ToyDfuActivity.this.progressbarUploading.setVisibility(0);
            }
            ToyDfuActivity.this.progressbarUploading.setIndeterminate(false);
            int i4 = ((int) (i * 0.9d)) + 10;
            ToyDfuActivity.this.progressbarUploading.setProgress(i4);
            if (i % 10 == 0) {
                xe3.a("dfuSdk", "SDK onProgressChanged " + i);
            }
            ToyDfuActivity.this.uploadingTitle.setText(ah4.f(R.string.dfu_uploading_percentage, Integer.valueOf(i4)));
            ToyDfuActivity.this.P4();
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyDfuActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K4(View view) {
        if (!this.n) {
            rq1.d.r(this.b);
            finish();
        } else {
            kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.toy_update_exit_notice), ah4.e(R.string.common_ok), false, false, (kn3.d) new i(this));
            kn3Var.show();
            kn3Var.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M4(View view) {
        sp1.a(this.g.getLogToyType());
        xe3.a("dfuSdk", "点击升级按钮！");
        Y4(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O4(View view) {
        finish();
    }

    @Override // dc.yb1.k
    public void A1(int i2, int i3, String str) {
        runOnMainThread(new g(i2, i3, str));
    }

    @Override // dc.yb1.k
    public void C3() {
        runOnMainThread(new f());
    }

    public final void E4() {
        ((NotificationManager) getSystemService("notification")).cancel(DfuBaseService.NOTIFICATION_ID);
    }

    public final boolean F4() {
        BluetoothAdapter adapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        return adapter != null && adapter.isEnabled();
    }

    public final void G4() {
        if (getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return;
        }
        V4(R.string.no_ble);
    }

    public final boolean H4() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (DfuService.class.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public boolean I4() {
        return this.n;
    }

    @Override // dc.yb1.k
    public void J1(int i2) {
        runOnMainThread(new e(i2));
    }

    @Override // dc.yb1.k
    public void L1() {
        runOnMainThread(new c());
        xe3.a("dfuSdk", "SDK onDeviceDisconnecting！");
    }

    public final void P4() {
        this.toy_dfu_icon.setImageResource(this.g.getDfuIcon(false));
        this.toy_upgrade_fail.setVisibility(8);
        S4(R.string.firmwar_upgrading_title_start, R.string.firmwar_upgrading_subtitle_start, false);
        this.updateBtn.setVisibility(8);
        this.uploadingTitle.setVisibility(0);
    }

    public final void Q4(int i2, String str) {
        sp1.c(str);
        xe3.a("dfuSdk", "升级失败！" + str);
        this.toy_dfu_icon.setImageResource(this.g.getDfuIcon(true));
        this.toy_upgrade_fail.setVisibility(0);
        this.toyUpdateNotice.setText(i2);
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.text_color_85));
        this.updateBtn.setText(ah4.e(R.string.common_ok));
        this.updateBtn.setVisibility(0);
        this.updateBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.lh2
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
        this.n = false;
        this.e.removeCallbacksAndMessages(null);
        E4();
    }

    public final void R4() {
        sp1.d(this.l);
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
        this.f.Q(this.b).setVersion(10);
        if (this.s) {
            this.tvUpdateTipTake.setVisibility(0);
        }
        this.n = false;
        this.e.removeCallbacksAndMessages(null);
        File file = this.h;
        if (file != null) {
            file.delete();
            this.h = null;
        }
        this.g.setUpdateDfu(null);
        this.updateBtn.setOnClickListener(new p());
        HashMap map = new HashMap();
        map.put(PSOProgramService.VS_Key, this.g.getDeviceType());
        tn2.x(WearUtils.x).t("/app/toy/dfu/upgraded", map, new a(this));
        E4();
    }

    public final void S4(int i2, int i3, boolean z) {
        this.tvUpgradeStatus.setVisibility(0);
        this.tvUpgradeStatus.setTextColor(th4.b(this, R.color.text_color_85));
        this.tvUpgradeStatus.setText(i2);
        this.toyUpdateNotice.setText(i3);
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.text_color_85));
        this.tvUpdateTip.setVisibility((z && TextUtils.equals(this.g.getType(), "dolce")) ? 0 : 8);
    }

    public final void T4(int i2) {
        this.lowBattery.setVisibility(0);
        this.toyUpdateNotice.setText(ah4.e(i2));
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.orgy_background_color));
        this.updateBtn.setVisibility(8);
    }

    public final void U4() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 0);
    }

    @Override // dc.yb1.k
    public void V3() {
        runOnMainThread(new d());
        xe3.a("dfuSdk", "SDK onDfuProcessStarting！");
    }

    public final void V4(int i2) {
        sg3.h(i2);
    }

    public final void W4() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
        intent.putExtra(DfuBaseService.EXTRA_ACTION, 0);
        localBroadcastManager.sendBroadcast(intent);
    }

    public final void X4() {
        File file;
        BluetoothDevice bluetoothDeviceR = this.f.r(this.b);
        this.k = bluetoothDeviceR;
        if (bluetoothDeviceR != null) {
            yb1.E().F(this.a, this.k, (yb1.A || (file = this.h) == null) ? "" : file.getAbsolutePath(), this);
        } else {
            EventBus.getDefault().post(new ToySelectEvent(this.g.getAddress(), !this.g.isSelect()));
            new Timer().schedule(new m(), 2500L);
        }
    }

    public final void Y4(boolean z) {
        if (this.n) {
            return;
        }
        if (!yb1.A) {
            Toy toy = this.g;
            if (toy == null || toy.getUpdateDfu() == null || !this.g.getUpdateDfu().isHasUpdate()) {
                Q4(R.string.dfu_toy_status_invalid, "DfuBean empty");
                return;
            } else if (WearUtils.e1(this.g.getUpdateDfu().getUrl())) {
                Q4(R.string.dfu_toy_status_invalid, "url empty");
                return;
            }
        }
        if (!hf3.d(this)) {
            sg3.h(R.string.firmwar_upgrading_subtitle_network_error);
            return;
        }
        if (!this.g.isConnected()) {
            sg3.h(R.string.toy_not_found);
            return;
        }
        if (!z) {
            int i2 = this.q;
            if (i2 > 0 && i2 < 10 && this.p > 10) {
                T4(R.string.firmwar_toy_low_battery);
                return;
            }
            if (i2 > 10 && this.p < 10) {
                T4(R.string.firmwar_phone_low_battery);
                return;
            } else if (i2 > 0 && i2 < 10 && this.p < 10) {
                T4(R.string.firmwar_toy_and_phone_low_battery);
                return;
            }
        }
        this.o = true;
        this.n = true;
        this.ll_dfu_toy_battery.setVisibility(8);
        this.lowBattery.setVisibility(8);
        this.updateBtn.setVisibility(8);
        this.uploadingTitle.setVisibility(0);
        this.uploadingTitle.setText(ah4.e(R.string.dfu_status_uploading_title));
        this.progressbarUploading.setIndeterminate(true);
        this.progressbarUploading.setVisibility(0);
        S4(R.string.firmwar_upgrading_title_download, R.string.firmwar_upgrading_subtitle_download, false);
        if (yb1.A && this.g.isEI01Toy()) {
            this.l = "https://test2.lovense.com/UploadFiles/dfu/20210728172646_S33_v128_210422.zip";
            this.m = "";
        } else {
            this.l = this.g.getUpdateDfu().getUrl();
            this.m = this.g.getUpdateDfu().getMd5();
        }
        sp1.b(this.l);
        showLoadingProgress();
        WearUtils.D0(false, this.l, new l());
    }

    @Override // dc.yb1.k
    public void d2() {
        runOnMainThread(new b());
        xe3.a("dfuSdk", "SDK onDeviceConnecting！");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.n) {
            rq1.d.r(this.b);
            finish();
        } else {
            kn3 kn3Var = new kn3((Context) this, ah4.e(R.string.toy_update_exit_notice), ah4.e(R.string.common_ok), false, false, (kn3.d) new n(this));
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
        MyApplication myApplication = (MyApplication) getApplication();
        this.a = myApplication;
        this.f = myApplication.G();
        this.b = getIntent().getStringExtra("dfu_toy_address_Id");
        this.s = getIntent().getBooleanExtra("isS43", false);
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.BLUETOOTH_SCAN");
        q61VarM.j(new h(this));
        this.actionbar.setTitle(ah4.e(R.string.toy_update_title));
        this.actionbar.setBackAction(new MyActionBar.f() { // from class: dc.kh2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.K4(view);
            }
        });
        Toy toyQ = this.f.Q(this.b);
        this.g = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        this.s = tb1.d().i(this.g);
        this.c = this.g.getType();
        this.d = this.g.getToyTypeKey();
        this.i = 0;
        this.q = this.g.getBattery();
        if (this.g.isF01Toy()) {
            this.ll_dfu_toy_battery.setVisibility(8);
        } else {
            this.ll_dfu_toy_battery.setVisibility(0);
            this.g.updateMyToyBattery(this, this.iv_dfu_toy_battery);
            this.tv_dfu_toy_battery.setText(this.q + "%");
            if (this.q <= 0) {
                dq1.a(this.b);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            int intProperty = ((BatteryManager) getSystemService("batterymanager")).getIntProperty(4);
            String str = "onCreate: " + intProperty;
            if (intProperty > 0) {
                this.p = intProperty;
            }
        }
        DfuServiceListenerHelper.registerProgressListener(this, this.t);
        this.toy_dfu_icon.setImageResource(this.g.getDfuIcon(false));
        this.toyName.setText(this.g.getUpCaseName());
        this.toy_upgrade_fail.setVisibility(8);
        this.lowBattery.setVisibility(8);
        this.toyUpdateNotice.setText(ah4.e(R.string.toy_update_notice));
        this.toyUpdateNotice.setTextColor(th4.b(this, R.color.text_color_85));
        this.updateBtn.setText(ah4.e(R.string.toy_update_bnt));
        this.updateBtn.setVisibility(0);
        this.uploadingTitle.setVisibility(8);
        this.progressbarUploading.setVisibility(8);
        this.lowBatteryUpdateBtn.setOnClickListener(new j());
        this.lowBatteryOk.setOnClickListener(new k());
        this.updateBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.mh2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.M4(view);
            }
        });
        G4();
        if (F4()) {
            return;
        }
        U4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        File file = this.h;
        if (file != null) {
            file.delete();
            this.h = null;
        }
        DfuServiceListenerHelper.unregisterProgressListener(this, this.t);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(wc1 wc1Var) {
        wc1Var.b();
        this.b.equals(wc1Var.a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onOTAProgressChanged(zb1 zb1Var) {
        if (zb1Var.b() == 1) {
            int iA = zb1Var.a();
            if (this.progressbarUploading.getVisibility() == 8) {
                this.progressbarUploading.setVisibility(0);
            }
            this.progressbarUploading.setIndeterminate(false);
            int i2 = ((int) (iA * 0.9d)) + 10;
            this.uploadingTitle.setText(ah4.f(R.string.dfu_uploading_percentage, Integer.valueOf(i2)));
            this.progressbarUploading.setProgress(i2);
            P4();
            if (iA % 10 == 0) {
                xe3.a("dfuSdk", "SDK onProgressChanged " + iA);
            }
        }
    }

    public void onUploadClicked(View view) throws NumberFormatException {
        if (H4()) {
            W4();
            return;
        }
        if (!this.j) {
            Q4(R.string.dfu_file_status_invalid, "File MIME type error");
            return;
        }
        if (this.s) {
            S4(R.string.firmwar_upgrading_title_start, R.string.firmwar_upgrading_subtitle_start, false);
            X4();
            return;
        }
        boolean z = Build.VERSION.SDK_INT < 23;
        int i2 = 12;
        try {
            i2 = Integer.parseInt(String.valueOf(12));
        } catch (NumberFormatException unused) {
        }
        DfuServiceInitiator unsafeExperimentalButtonlessServiceInSecureDfuEnabled = new DfuServiceInitiator(this.k.getAddress()).setDeviceName(this.k.getName()).setKeepBond(false).setForceDfu(false).setPacketsReceiptNotificationsEnabled(z).setPacketsReceiptNotificationsValue(i2).setPrepareDataObjectDelay(400L).setDisableNotification(!q61.f(this, "android.permission.NOTIFICATION_SERVICE")).setForeground(false).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true);
        File file = this.h;
        if (file == null) {
            Q4(R.string.dfu_file_status_invalid, "file empty");
            return;
        }
        if (this.i == 0) {
            unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setZip(Uri.fromFile(file), this.h.getPath());
        }
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.start(this, DfuService.class);
        xe3.a("dfuSdk", "SDK 升级开始！");
        S4(R.string.firmwar_upgrading_title_start, R.string.firmwar_upgrading_subtitle_start, false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(vc1 vc1Var) {
        if (vc1Var == null || this.g.isF01Toy()) {
            return;
        }
        this.u++;
        if (!vc1Var.a().equals(this.b) || this.g == null || this.o || this.q == 9) {
            return;
        }
        int iB = vc1Var.b();
        this.q = iB;
        if (iB > 0) {
            this.ll_dfu_toy_battery.setVisibility(0);
            this.g.updateMyToyBattery(this, this.iv_dfu_toy_battery);
            this.tv_dfu_toy_battery.setText(this.q + "%");
            return;
        }
        if (this.u > 10) {
            this.ll_dfu_toy_battery.setVisibility(0);
            this.g.updateMyToyBattery(this, this.iv_dfu_toy_battery);
            this.tv_dfu_toy_battery.setText(this.q + "%");
            return;
        }
        dq1.a(this.b);
    }
}
