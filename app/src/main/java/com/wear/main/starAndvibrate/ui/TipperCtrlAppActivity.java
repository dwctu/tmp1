package com.wear.main.starAndvibrate.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.toy.StarControlAdapter;
import com.wear.bean.Toy;
import com.wear.bean.socketio.starAndvibrate.response.TipperCtrlChangeStatusRespone;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.cg3;
import dc.cs3;
import dc.eg2;
import dc.ig2;
import dc.is3;
import dc.sz1;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class TipperCtrlAppActivity extends BaseActivity implements eg2 {
    public ig2 a = ig2.n();
    public ArrayList<Toy> b = new ArrayList<>();
    public StarControlAdapter c;
    public is3 d;

    @BindView(R.id.rv_toys)
    public RecyclerView rvToys;

    @BindView(R.id.tv_pf)
    public TextView tvPf;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_times_up)
    public TextView tvTimesUp;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    public class a implements is3.d {
        public a() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            sz1.d().o();
            TipperCtrlAppActivity.this.a.l(true);
            TipperCtrlAppActivity.this.d.dismiss();
        }
    }

    @Override // dc.eg2
    public void B(int i) {
        this.tvTime.setText(WearUtils.v0(i));
        boolean z = i <= 0;
        this.tvTime.setVisibility(z ? 8 : 0);
        this.rvToys.setVisibility(z ? 8 : 0);
        this.tvTimesUp.setVisibility(z ? 0 : 8);
        if (z) {
            this.tvTip.setText(String.format(ah4.e(R.string.notification_takecontrol_timesup), this.a.o().getModelName()));
        }
    }

    @Override // dc.eg2
    public void D(boolean z) {
        if (z) {
            this.tvTip.setText(String.format(ah4.e(R.string.takecontrol_running), ig2.n().o().getModelName()));
            this.tvTip.setTextColor(ContextCompat.getColor(this.application, R.color.white));
        } else {
            this.tvTip.setText(getString(R.string.vibe_network_error));
            this.tvTip.setTextColor(ContextCompat.getColor(this.application, R.color.text_color_red));
        }
    }

    @Override // dc.eg2
    public void R0(TipperCtrlChangeStatusRespone tipperCtrlChangeStatusRespone) {
        this.tvPf.setText(this.a.o().getPf());
        this.tvTip.setText(String.format(ah4.e(R.string.takecontrol_running), this.a.o().getModelName()));
    }

    @Override // dc.eg2
    public void b() {
        finish();
    }

    @Override // dc.eg2
    public void e2(int i) {
        this.tvTime.setVisibility(8);
        if (i == 1) {
            this.tvTip.setText(ah4.e(R.string.notification_takecontrol_end));
        } else if (i == 2) {
            this.tvTip.setText(ah4.e(R.string.takecontrol_disable));
        }
    }

    @Override // dc.eg2
    public void notifyDataSetChanged() {
        this.c.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @OnClick({R.id.tv_stop})
    public void onClick() {
        if (!this.a.i()) {
            finish();
            return;
        }
        if (this.d == null) {
            is3.b bVar = new is3.b(this);
            bVar.w(R.string.takecontrol_exitconfirm);
            bVar.p(getString(R.string.notification_takecontrol_reconnect));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.o(ah4.e(R.string.common_confirm));
            bVar.d(new a());
            this.d = cs3.h(bVar);
        }
        this.d.show();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tipper_control);
        ButterKnife.bind(this);
        this.tvTime.setVisibility(8);
        this.tvTimesUp.setVisibility(8);
        StarControlAdapter starControlAdapter = new StarControlAdapter(this.b, R.layout.item_star_control);
        this.c = starControlAdapter;
        cg3.d(this.rvToys, starControlAdapter);
        t4();
        this.a.h(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.G(this);
        this.d = null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        t4();
    }

    @Override // dc.eg2
    public void start() {
    }

    public final void t4() {
        if (!this.a.i()) {
            finish();
            return;
        }
        this.tvPf.setText(this.a.o().getPf());
        this.tvTip.setText(String.format(ah4.e(R.string.takecontrol_running), this.a.o().getModelName()));
        this.tvTip.setTextColor(ContextCompat.getColor(this.application, R.color.white));
        this.b.clear();
        this.b.addAll(this.a.p());
        notifyDataSetChanged();
    }
}
