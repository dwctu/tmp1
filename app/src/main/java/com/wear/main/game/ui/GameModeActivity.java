package com.wear.main.game.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.SetLanInfoEvent;
import com.wear.bean.Toy;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.toy.ToyActivity;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.fs3;
import dc.gs3;
import dc.h32;
import dc.pc1;
import dc.pj3;
import dc.qf3;
import dc.t32;
import dc.th4;
import dc.xc1;
import dc.y12;
import dc.ye3;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class GameModeActivity extends BaseActivity {
    public String a;

    @BindView(R.id.cl_ip_layout)
    public ConstraintLayout clIpLayout;

    @BindView(R.id.iv_back)
    public ImageView ivBack;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;

    @BindView(R.id.tv_game_name)
    public TextView mTvGameName;

    @BindView(R.id.main_title_bar)
    public RelativeLayout mainTitleBar;

    @BindView(R.id.ll_game_name)
    public LinearLayout platformContainer;

    @BindView(R.id.rl_enter_toy_ctrl)
    public RelativeLayout rlEnterToyCtrl;

    @BindView(R.id.rl_toy_1)
    public AppCompatTextView rlToy1;

    @BindView(R.id.rl_toy_2)
    public AppCompatTextView rlToy2;

    @BindView(R.id.tv_connect)
    public TextView tvConnect;

    @BindView(R.id.tv_connect_red)
    public TextView tvConnectRed;

    @BindView(R.id.tv_connect_toy)
    public TextView tvConnectToy;

    @BindView(R.id.tv_connect_wifi)
    public TextView tvConnectWifi;

    @BindView(R.id.tv_http_port_content)
    public TextView tvHttpPortContent;

    @BindView(R.id.tv_id)
    public TextView tvId;

    @BindView(R.id.tv_ip_content)
    public TextView tvIpContent;

    @BindView(R.id.tv_manage_now)
    public TextView tvManageTow;

    @BindView(R.id.tv_notoy)
    public TextView tvNotoy;

    @BindView(R.id.tv_ssl_port_content)
    public TextView tvSslPortContent;

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public class a implements h32.e {

        /* renamed from: com.wear.main.game.ui.GameModeActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0100a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0100a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                GameModeActivity.this.B4();
                GameModeActivity.this.mTvGameName.setText(this.a);
            }
        }

        public a() {
        }

        @Override // dc.h32.e
        public void a(String str) {
            GameModeActivity gameModeActivity = GameModeActivity.this;
            gameModeActivity.a = str;
            gameModeActivity.runOnMainThread(new RunnableC0100a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4(View view) {
        pj3.f(this, ToyCtrlGameModeActivity.class);
    }

    public void A4() {
    }

    public final void B4() {
        pc1 pc1Var = pc1.a;
        boolean z = !pc1Var.P().isEmpty();
        int i = 8;
        this.tvNotoy.setVisibility(z ? 8 : 0);
        this.tvConnectToy.setVisibility(z ? 8 : 0);
        this.tvManageTow.setVisibility(z ? 0 : 8);
        this.clIpLayout.setVisibility(0);
        this.tvConnectWifi.setVisibility(z ? 0 : 8);
        this.rlEnterToyCtrl.setVisibility(0);
        LinearLayout linearLayout = this.platformContainer;
        if (pc1Var.P().size() > 0 && !TextUtils.isEmpty(this.a)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
    }

    @OnClick({R.id.tv_connect_toy, R.id.tv_manage_now, R.id.tv_exit, R.id.rl_enter_toy_ctrl})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.rl_enter_toy_ctrl /* 2131364265 */:
                z4(3);
                int iO = t32.o();
                String strU4 = u4();
                if (iO != 0) {
                    if (iO != 1) {
                        if (iO != -1) {
                            new gs3(this, 2, pc1.a.P().size() > 1 ? String.format(ah4.e(R.string.game_mode_update_dfu_dialog_title11), strU4) : String.format(ah4.e(R.string.game_mode_update_dfu_dialog_title1), strU4)).show();
                            break;
                        } else {
                            new fs3(this, ah4.e(R.string.game_model_toast_content)).show();
                            break;
                        }
                    } else {
                        new gs3(this, 1, String.format(ah4.e(R.string.game_mode_update_dfu_dialog_title2), strU4)).show();
                        break;
                    }
                } else {
                    pj3.f(this, ToyCtrlGameModeActivity.class);
                    break;
                }
            case R.id.tv_connect_toy /* 2131364988 */:
                pj3.f(this, ToyActivity.class);
                z4(1);
                break;
            case R.id.tv_exit /* 2131365080 */:
                h32.i().F(0);
                finish();
                pc1.a.u0();
                break;
            case R.id.tv_manage_now /* 2131365172 */:
                z4(2);
                pj3.f(this, ToyActivity.class);
                break;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_game_mode);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        w4();
        t4();
        h32.i().F(1);
        h32.i().A(new a());
        this.rlToy1.setVisibility(8);
        this.rlToy2.setVisibility(8);
        this.ivNotToy.setVisibility(8);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(xc1 xc1Var) {
        B4();
        A4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        A4();
        B4();
    }

    public final void t4() {
        if (MusicControl.h0().O()) {
            MusicControl.h0().S();
        }
        if (qf3.a) {
            qf3.u(0);
            qf3.C();
        }
        y12.c.a().t();
    }

    public String u4() {
        ArrayList arrayList = new ArrayList(pc1.a.P());
        String str = "";
        for (int i = 0; i < arrayList.size(); i++) {
            str = i == arrayList.size() - 1 ? str + ((Toy) arrayList.get(i)).getName() + " " + ((Toy) arrayList.get(i)).getGenerationVersion() : str + ((Toy) arrayList.get(i)).getName() + " " + ((Toy) arrayList.get(i)).getGenerationVersion() + ",";
        }
        return str.toString();
    }

    public final void v4() {
        this.mainTitleBar.setBackgroundColor(th4.b(WearUtils.x, R.color.bg_24));
        this.tvTitle.setText(ah4.e(R.string.game_mode));
        A4();
    }

    public final void w4() {
        v4();
        String strX = ye3.x();
        this.tvId.setText("ID:" + strX.substring(strX.length() - 6));
        if (WearUtils.B) {
            this.tvId.setOnClickListener(new View.OnClickListener() { // from class: dc.u32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.y4(view);
                }
            });
        }
        B4();
    }

    public void z4(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 1) {
            str = "game_mode_connect_now_click";
            str2 = "game_mode_connect_now";
        } else if (i == 2) {
            str = "game_mode_manage_toy_click";
            str2 = "game_mode_manage_toy";
        } else {
            if (i != 3) {
                str4 = "";
                str3 = str4;
                ye3.j("game mode", str4, "click", str3, "button", "", "", -1L);
            }
            str = "game_mode_control_third_party_click";
            str2 = "game_mode_control_third_party";
        }
        str3 = str2;
        str4 = str;
        ye3.j("game mode", str4, "click", str3, "button", "", "", -1L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(SetLanInfoEvent setLanInfoEvent) {
        this.tvIpContent.setText(setLanInfoEvent.getLocalIp());
        this.tvHttpPortContent.setText("34567");
        this.tvSslPortContent.setText("34568");
    }
}
