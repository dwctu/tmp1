package com.wear.main.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.game.ToyCtrlGameAdapter;
import com.wear.bean.SetLanInfoEvent;
import com.wear.bean.Toy;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.toy.ToyActivity;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.h32;
import dc.pc1;
import dc.pj3;
import dc.qf3;
import dc.t32;
import dc.th4;
import dc.wr3;
import dc.xc1;
import dc.y12;
import dc.ye3;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class ToyCtrlGameModeActivity extends BaseActivity {
    public wr3 a;
    public ToyCtrlGameAdapter b;

    @BindView(R.id.iv_back)
    public ImageView ivBack;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;

    @BindView(R.id.main_title_bar)
    public RelativeLayout mainTitleBar;

    @BindView(R.id.rl_toy_1)
    public AppCompatTextView rlToy1;

    @BindView(R.id.rl_toy_2)
    public AppCompatTextView rlToy2;

    @BindView(R.id.rv_game_connected)
    public RecyclerView rvGameConnected;

    @BindView(R.id.tv_http_port_content)
    public TextView tvHttpPortContent;

    @BindView(R.id.tv_http_port_title)
    public TextView tvHttpPortTitle;

    @BindView(R.id.tv_id)
    public TextView tvId;

    @BindView(R.id.tv_ip_content)
    public TextView tvIpContent;

    @BindView(R.id.tv_ip_title)
    public TextView tvIpTitle;

    @BindView(R.id.tv_ssl_port_content)
    public TextView tvSslPortContent;

    @BindView(R.id.tv_ssl_port_title)
    public TextView tvSslPortTitle;

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public class a implements wr3.a {
        public a() {
        }

        @Override // dc.wr3.a
        public void a() {
            pj3.f(ToyCtrlGameModeActivity.this, ToyActivity.class);
            ToyCtrlGameModeActivity.this.a.dismiss();
        }

        @Override // dc.wr3.a
        public void onCancel() {
            ToyCtrlGameModeActivity.this.a.dismiss();
        }
    }

    public final void A4() {
        if (this.a == null) {
            wr3 wr3Var = new wr3(this, R.style.MaterialDialogSheet);
            this.a = wr3Var;
            wr3Var.e(new a());
            this.a.f(getString(R.string.game_model_bottom_dialog_content));
            this.a.g(getString(R.string.connect_now));
        }
        if (this.a.isShowing()) {
            return;
        }
        this.a.show();
    }

    public final void B4() {
        this.b.n(t32.j().h());
        this.rvGameConnected.setVisibility(this.b.getItemCount() == 0 ? 8 : 0);
        if (t32.j().h().size() > 0) {
            x4(2);
        }
    }

    @OnClick({R.id.iv_back, R.id.rl_toy_1, R.id.rl_toy_2, R.id.iv_not_toy, R.id.tv_exit})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back /* 2131363096 */:
            case R.id.tv_exit /* 2131365080 */:
                s4();
                finish();
                break;
            case R.id.iv_not_toy /* 2131363221 */:
            case R.id.rl_toy_1 /* 2131364313 */:
            case R.id.rl_toy_2 /* 2131364314 */:
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
        setContentView(R.layout.activity_toy_ctrl_game_mode);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        w4();
        t4();
        h32.i().z();
        t32.j().f();
        x4(1);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s4();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(xc1 xc1Var) {
        int iB = xc1Var.b();
        if (iB == -1 || iB == 1) {
            z4();
            y4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        z4();
    }

    public final void s4() {
        t32.j().u();
        EventBus.getDefault().unregister(this);
        u4();
        this.a = null;
    }

    public final void t4() {
        if (MusicControl.h0().O()) {
            MusicControl.h0().S();
        }
        y12.c.a().t();
        if (qf3.a) {
            qf3.u(0);
            qf3.C();
        }
    }

    public final void u4() {
        wr3 wr3Var = this.a;
        if (wr3Var == null || !wr3Var.isShowing()) {
            return;
        }
        this.a.dismiss();
    }

    public final void v4() {
        this.mainTitleBar.setBackgroundColor(th4.b(WearUtils.x, R.color.bg_24));
        this.tvTitle.setText(ah4.e(R.string.game_mode));
        this.ivBack.setVisibility(0);
        z4();
    }

    public final void w4() {
        v4();
        String strX = ye3.x();
        this.tvId.setText("ID:" + strX.substring(strX.length() - 6));
        ToyCtrlGameAdapter toyCtrlGameAdapter = new ToyCtrlGameAdapter();
        this.b = toyCtrlGameAdapter;
        this.rvGameConnected.setAdapter(toyCtrlGameAdapter);
        this.rvGameConnected.setLayoutManager(new LinearLayoutManager(this));
        B4();
    }

    public void x4(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 1) {
            str = "game_mode_control_third_party_exposure";
            str2 = "exposure";
            str3 = "";
        } else {
            if (i == 2) {
                String strI = t32.j().i();
                str4 = t32.j().h().get(0).a;
                str = "game_mode_control_third_party_success";
                str3 = strI;
                str2 = "connect";
                ye3.j("game mode", str, str2, str3, "", str4, "", -1L);
            }
            str = "";
            str2 = str;
            str3 = str2;
        }
        str4 = str3;
        ye3.j("game mode", str, str2, str3, "", str4, "", -1L);
    }

    public final void y4() {
        if (t32.n()) {
            u4();
        } else {
            A4();
        }
    }

    public void z4() {
        ArrayList<Toy> arrayListO = pc1.a.o();
        int i = 0;
        for (int i2 = 0; i2 < arrayListO.size() && i < 2; i2++) {
            Toy toy = arrayListO.get(i2);
            if (toy != null && toy.isConnected()) {
                if (i == 0) {
                    this.rlToy1.setBackgroundResource(Toy.getToyIconLinkedId(toy.getType(), i2, true));
                    this.rlToy1.setText(toy.getName());
                } else {
                    this.rlToy2.setBackgroundResource(Toy.getToyIconLinkedId(toy.getType(), i2, true));
                    this.rlToy2.setText(toy.getName());
                }
                i++;
            }
        }
        if (i == 0) {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.ivNotToy.setVisibility(0);
        } else if (i != 1) {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(0);
            this.ivNotToy.setVisibility(8);
        } else {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(8);
            this.ivNotToy.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(ToyCtrlGameEvent toyCtrlGameEvent) {
        if (toyCtrlGameEvent.type == 20) {
            B4();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(SetLanInfoEvent setLanInfoEvent) {
        this.tvIpContent.setText(setLanInfoEvent.getLocalIp());
        this.tvHttpPortContent.setText("34567");
        this.tvSslPortContent.setText("34568");
    }
}
