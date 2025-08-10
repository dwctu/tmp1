package com.wear.main.starAndvibrate.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.ExoPlayer;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.toy.StarControlAdapter;
import com.wear.bean.Toy;
import com.wear.bean.socketio.starAndvibrate.response.SyncVibeActivityInfoTcResponse;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.cg3;
import dc.dg2;
import dc.hg2;
import dc.pc1;
import dc.sz1;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StarControlActivity extends BaseActivity implements dg2 {
    public SyncVibeActivityInfoTcResponse b;
    public StarControlAdapter d;

    @BindView(R.id.rv_toys)
    public RecyclerView rvToys;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_tip)
    public TextView tvTip;
    public hg2 a = hg2.m();
    public ArrayList<Toy> c = new ArrayList<>();

    public class a implements Runnable {
        public a(StarControlActivity starControlActivity) {
        }

        @Override // java.lang.Runnable
        public void run() {
            pc1.a.u0();
        }
    }

    @Override // dc.dg2
    public void B(int i) {
        this.tvTime.setText(WearUtils.v0(i));
        this.tvTime.setVisibility(0);
    }

    @Override // dc.dg2
    public void b() {
        finish();
    }

    @Override // dc.dg2
    public void end() {
        this.tvTip.setText(ah4.e(R.string.lush3_campaign_ended));
        this.tvTime.setVisibility(8);
        this.parentHandler.postDelayed(new a(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // dc.dg2
    public void notifyDataSetChanged() {
        this.d.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @OnClick({R.id.tv_stop})
    public void onClick() {
        sz1.d().o();
        this.a.k();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_star_control);
        ButterKnife.bind(this);
        StarControlAdapter starControlAdapter = new StarControlAdapter(this.c, R.layout.item_star_control);
        this.d = starControlAdapter;
        cg3.d(this.rvToys, starControlAdapter);
        s4();
        this.a.g(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.t(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        s4();
    }

    public final void s4() {
        this.b = this.a.l();
        if (!this.a.h() || this.b == null) {
            finish();
            return;
        }
        if (this.a.q()) {
            this.tvTip.setText(ah4.e(R.string.lush3_campaign_running));
        } else {
            this.tvTip.setText(ah4.e(R.string.lush3_campaign_waiting));
        }
        this.c.clear();
        this.c.addAll(this.a.n());
        notifyDataSetChanged();
    }

    @Override // dc.dg2
    public void start() {
        this.tvTip.setText(ah4.e(R.string.lush3_campaign_running));
    }
}
