package com.wear.main.longDistance;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.BrowserOpenDPEvent;
import com.wear.bean.socketio.display.DisplayPannelIfoBean;
import com.wear.bean.socketio.display.ExitControlModelBean;
import com.wear.bean.socketio.display.ToyInfoBean;
import dc.ah4;
import dc.cs3;
import dc.is3;
import dc.pb2;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class DisplayPannelAcriviry extends BaseActivity implements pb2.f {

    @BindView(R.id.browser_wait_ll)
    public LinearLayout browserWaitLl;

    @BindView(R.id.iv_top_bg)
    public ImageView ivTopBg;

    @BindView(R.id.iv_top_icon)
    public ImageView ivTopIcon;

    @BindView(R.id.ll_progress)
    public LinearLayout llProgress;

    @BindView(R.id.proBar)
    public ProgressBar proBar;

    @BindView(R.id.tv_go_room_tip)
    public TextView tvGoRoomTip;

    @BindView(R.id.tv_pf)
    public TextView tvPf;

    @BindView(R.id.tv_progress)
    public TextView tvProgress;

    @BindView(R.id.tv_stop)
    public TextView tvStop;

    @BindView(R.id.tv_toy_status)
    public TextView tvToyStatus;

    @BindView(R.id.tv_wait_reconnect_tip)
    public TextView tvWaitReconnectTip;

    @BindView(R.id.v_center)
    public View vCenter;

    @BindView(R.id.wait_close)
    public ImageView waitClose;

    public class a implements is3.d {
        public a() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            pb2.m().x(new ExitControlModelBean());
            pb2.m().k();
            DisplayPannelAcriviry.this.g1();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                if (!this.a) {
                    DisplayPannelAcriviry.this.tvWaitReconnectTip.setVisibility(8);
                    return;
                }
                DisplayPannelAcriviry.this.tvWaitReconnectTip.setVisibility(0);
                if (pb2.q == 1) {
                    DisplayPannelAcriviry.this.tvWaitReconnectTip.setText(ah4.e(R.string.display_browser_panel_sync_not_stable));
                } else {
                    DisplayPannelAcriviry.this.tvWaitReconnectTip.setText(ah4.e(R.string.display_panel_sync_not_stable));
                }
            }
        }
    }

    public class c implements View.OnClickListener {
        public c(DisplayPannelAcriviry displayPannelAcriviry) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DisplayPannelAcriviry.this.g1();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ CharSequence a;

        public e(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                DisplayPannelAcriviry.this.tvGoRoomTip.setText(this.a);
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ DisplayPannelIfoBean a;
        public final /* synthetic */ ToyInfoBean b;

        public f(DisplayPannelIfoBean displayPannelIfoBean, ToyInfoBean toyInfoBean) {
            this.a = displayPannelIfoBean;
            this.b = toyInfoBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                DisplayPannelAcriviry.this.tvPf.setText(this.a.getPf());
                DisplayPannelAcriviry.this.tvWaitReconnectTip.setVisibility(8);
                DisplayPannelAcriviry.this.llProgress.setVisibility(8);
                DisplayPannelAcriviry.this.tvToyStatus.setVisibility(8);
                if (TextUtils.isEmpty(this.b.getToyType())) {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.nav_unknown_1);
                } else {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.nav_unknown_1);
                }
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ DisplayPannelIfoBean a;

        public g(DisplayPannelIfoBean displayPannelIfoBean) {
            this.a = displayPannelIfoBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                DisplayPannelAcriviry.this.tvPf.setText(this.a.getPf());
                DisplayPannelAcriviry.this.tvWaitReconnectTip.setVisibility(8);
                DisplayPannelAcriviry.this.llProgress.setVisibility(0);
                DisplayPannelAcriviry.this.tvToyStatus.setVisibility(0);
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ CharSequence c;

        public h(int i, int i2, CharSequence charSequence) {
            this.a = i;
            this.b = i2;
            this.c = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                DisplayPannelAcriviry.this.proBar.setMax(this.a);
                DisplayPannelAcriviry.this.proBar.setProgress(this.b);
                DisplayPannelAcriviry.this.tvProgress.setText(this.c);
                DisplayPannelAcriviry.this.llProgress.setVisibility(0);
            }
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ ToyInfoBean a;

        public i(ToyInfoBean toyInfoBean) {
            this.a = toyInfoBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                DisplayPannelAcriviry.this.parentHandler.removeCallbacksAndMessages(null);
                String version = this.a.getVersion();
                if (this.a.isConnect()) {
                    DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_panel_sync_on));
                    DisplayPannelAcriviry displayPannelAcriviry = DisplayPannelAcriviry.this;
                    displayPannelAcriviry.tvGoRoomTip.setTextColor(ContextCompat.getColor(displayPannelAcriviry.application, R.color.white));
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.a.getName());
                    sb.append(TextUtils.isEmpty(this.a.getVersion()) ? "" : this.a.getVersion());
                    DisplayPannelAcriviry.this.tvToyStatus.setText(String.format(ah4.e(R.string.display_panel_toy_connected), sb.toString()));
                    DisplayPannelAcriviry displayPannelAcriviry2 = DisplayPannelAcriviry.this;
                    displayPannelAcriviry2.tvToyStatus.setTextColor(ContextCompat.getColor(displayPannelAcriviry2.application, R.color.white));
                } else {
                    if (pb2.q == 1) {
                        DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_browser_panel_toy_disconnect_title));
                    } else {
                        DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_panel_toy_disconnect_title));
                    }
                    DisplayPannelAcriviry displayPannelAcriviry3 = DisplayPannelAcriviry.this;
                    displayPannelAcriviry3.tvGoRoomTip.setTextColor(ContextCompat.getColor(displayPannelAcriviry3.application, R.color.white));
                    DisplayPannelAcriviry.this.tvToyStatus.setText(ah4.e(R.string.display_panel_toy_reconnecting));
                    DisplayPannelAcriviry displayPannelAcriviry4 = DisplayPannelAcriviry.this;
                    displayPannelAcriviry4.tvToyStatus.setTextColor(ContextCompat.getColor(displayPannelAcriviry4.application, R.color.text_color_red));
                }
                if (TextUtils.isEmpty(version)) {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.nav_unknown_1);
                } else {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.nav_unknown_1);
                }
            }
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ String a;

        public j(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                DisplayPannelAcriviry.this.parentHandler.removeCallbacksAndMessages(null);
                if (pb2.q == 1) {
                    DisplayPannelAcriviry.this.tvToyStatus.setText(ah4.e(R.string.display_browser_panel_slider_controlling));
                } else {
                    DisplayPannelAcriviry.this.tvToyStatus.setText(ah4.e(R.string.display_panel_mouse_controlling));
                }
                DisplayPannelAcriviry displayPannelAcriviry = DisplayPannelAcriviry.this;
                displayPannelAcriviry.tvToyStatus.setTextColor(ContextCompat.getColor(displayPannelAcriviry, R.color.white));
                if (pb2.q == 1) {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.slide_control_click);
                } else {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.mirrorlife_toy_mouse);
                }
                DisplayPannelAcriviry displayPannelAcriviry2 = DisplayPannelAcriviry.this;
                displayPannelAcriviry2.tvGoRoomTip.setTextColor(ContextCompat.getColor(displayPannelAcriviry2.application, R.color.white));
                if (pb2.q == 1) {
                    DisplayPannelAcriviry.this.tvGoRoomTip.setText(String.format(ah4.e(R.string.display_browser_panel_slider_panel), this.a));
                } else {
                    DisplayPannelAcriviry.this.tvGoRoomTip.setText(String.format(ah4.e(R.string.display_panel_mouse_panel), this.a));
                }
            }
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ DisplayPannelIfoBean a;
        public final /* synthetic */ ToyInfoBean b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DisplayPannelAcriviry.this.parentHandler.removeCallbacksAndMessages(null);
                StringBuilder sb = new StringBuilder();
                sb.append(k.this.b.getName());
                sb.append(TextUtils.isEmpty(k.this.b.getVersion()) ? "" : k.this.b.getVersion());
                DisplayPannelAcriviry.this.tvToyStatus.setText(String.format(ah4.e(R.string.display_panel_toy_connected), sb.toString()));
                DisplayPannelAcriviry displayPannelAcriviry = DisplayPannelAcriviry.this;
                displayPannelAcriviry.tvToyStatus.setTextColor(ContextCompat.getColor(displayPannelAcriviry.application, R.color.white));
            }
        }

        public k(DisplayPannelIfoBean displayPannelIfoBean, ToyInfoBean toyInfoBean) {
            this.a = displayPannelIfoBean;
            this.b = toyInfoBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DisplayPannelAcriviry.this.F4()) {
                if (!this.a.isTwoWay()) {
                    if (pb2.q == 1) {
                        DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_browser_panel_slider_controlling));
                    } else {
                        DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_panel_mouse_controlling));
                    }
                    DisplayPannelAcriviry displayPannelAcriviry = DisplayPannelAcriviry.this;
                    displayPannelAcriviry.tvGoRoomTip.setTextColor(ContextCompat.getColor(displayPannelAcriviry.application, R.color.white));
                    if (pb2.q == 1) {
                        DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.slide_control_click);
                        return;
                    } else {
                        DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.mirrorlife_toy_mouse);
                        return;
                    }
                }
                if (this.b.isConnect()) {
                    DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_panel_sync_on));
                    DisplayPannelAcriviry displayPannelAcriviry2 = DisplayPannelAcriviry.this;
                    displayPannelAcriviry2.tvGoRoomTip.setTextColor(ContextCompat.getColor(displayPannelAcriviry2.application, R.color.white));
                    DisplayPannelAcriviry.this.tvToyStatus.setText(ah4.e(R.string.display_panel_toy_reconnected));
                    DisplayPannelAcriviry displayPannelAcriviry3 = DisplayPannelAcriviry.this;
                    displayPannelAcriviry3.tvToyStatus.setTextColor(ContextCompat.getColor(displayPannelAcriviry3.application, R.color.pattern_saved_normal));
                    DisplayPannelAcriviry.this.parentHandler.postDelayed(new a(), 3000L);
                } else {
                    DisplayPannelAcriviry.this.parentHandler.removeCallbacksAndMessages(null);
                    if (pb2.q == 1) {
                        DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_browser_panel_toy_disconnect_title));
                    } else {
                        DisplayPannelAcriviry.this.tvGoRoomTip.setText(ah4.e(R.string.display_panel_toy_disconnect_title));
                    }
                    DisplayPannelAcriviry displayPannelAcriviry4 = DisplayPannelAcriviry.this;
                    displayPannelAcriviry4.tvGoRoomTip.setTextColor(ContextCompat.getColor(displayPannelAcriviry4.application, R.color.white));
                    DisplayPannelAcriviry.this.tvToyStatus.setText(ah4.e(R.string.display_panel_toy_reconnecting));
                    DisplayPannelAcriviry displayPannelAcriviry5 = DisplayPannelAcriviry.this;
                    displayPannelAcriviry5.tvToyStatus.setTextColor(ContextCompat.getColor(displayPannelAcriviry5.application, R.color.text_color_red));
                }
                if (TextUtils.isEmpty(this.b.getVersion())) {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.nav_unknown_1);
                } else {
                    DisplayPannelAcriviry.this.ivTopIcon.setImageResource(R.drawable.nav_unknown_1);
                }
            }
        }
    }

    @Override // dc.pb2.f
    public void E1(DisplayPannelIfoBean displayPannelIfoBean, ToyInfoBean toyInfoBean) {
        runOnMainThread(new f(displayPannelIfoBean, toyInfoBean));
    }

    public final void E4() {
        pb2.m().y(this);
        pb2.m().o();
    }

    public final boolean F4() {
        return (isFinishing() || isDestroyed()) ? false : true;
    }

    @Override // dc.pb2.f
    public void a4(CharSequence charSequence) {
        runOnMainThread(new e(charSequence));
    }

    @Override // dc.pb2.f
    public void b4(boolean z) {
        runOnMainThread(new b(z));
    }

    @Override // dc.pb2.f
    public void c4(ToyInfoBean toyInfoBean, DisplayPannelIfoBean displayPannelIfoBean) {
        runOnMainThread(new k(displayPannelIfoBean, toyInfoBean));
    }

    @Override // dc.pb2.f
    public void d3(ToyInfoBean toyInfoBean) {
        runOnMainThread(new i(toyInfoBean));
    }

    @Override // dc.pb2.f
    public void g1() {
        finish();
    }

    @Override // dc.pb2.f
    public void i2(DisplayPannelIfoBean displayPannelIfoBean) {
        runOnMainThread(new g(displayPannelIfoBean));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_display_pannel);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        if (pb2.q != 1 || pb2.m().e) {
            this.browserWaitLl.setVisibility(8);
        } else {
            this.browserWaitLl.setVisibility(0);
        }
        this.browserWaitLl.setOnClickListener(new c(this));
        this.waitClose.setOnClickListener(new d());
        E4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        pb2.m().w(this);
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BrowserOpenDPEvent browserOpenDPEvent) {
        if (this.browserWaitLl.getVisibility() == 0) {
            this.browserWaitLl.setVisibility(8);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        E4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        E4();
    }

    @OnClick({R.id.tv_stop})
    public void onViewClicked() {
        a aVar = new a();
        if (pb2.m().s()) {
            aVar.doConfirm();
        } else {
            cs3.c(this, pb2.q == 1 ? ah4.e(R.string.display_browser_panel_stop_sync_inquiry) : ah4.e(R.string.display_panel_stop_sync_inquiry), ah4.e(R.string.common_stop), ah4.e(R.string.common_cancel), aVar).show();
        }
    }

    @Override // dc.pb2.f
    public void q2() {
        if (pb2.q == 1) {
            this.browserWaitLl.setVisibility(0);
        } else {
            finish();
        }
    }

    @Override // dc.pb2.f
    public void q3(String str) {
        runOnMainThread(new j(str));
    }

    @Override // dc.pb2.f
    public void t0(int i2, int i3, CharSequence charSequence) {
        runOnMainThread(new h(i3, i2, charSequence));
    }
}
