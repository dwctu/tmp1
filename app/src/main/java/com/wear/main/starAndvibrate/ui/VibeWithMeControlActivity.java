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
import com.wear.bean.response.VibeWithMeBean;
import com.wear.util.WearUtils;
import dc.cg2;
import dc.cg3;
import dc.fg2;
import dc.sg3;
import dc.sz1;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class VibeWithMeControlActivity extends BaseActivity implements cg2 {
    public fg2 a = fg2.j();
    public ArrayList<Toy> b = new ArrayList<>();
    public StarControlAdapter c;
    public VibeWithMeBean d;

    @BindView(R.id.rv_toys)
    public RecyclerView rvToys;

    @BindView(R.id.tv_pf)
    public TextView tvPf;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_tip)
    public TextView tvTip;

    @Override // dc.cg2
    public void D(boolean z) {
        if (!z) {
            this.tvTip.setText(getString(R.string.vibe_network_error));
            this.tvTip.setTextColor(ContextCompat.getColor(this.application, R.color.text_color_red));
            return;
        }
        VibeWithMeBean vibeWithMeBean = this.d;
        if (vibeWithMeBean == null || WearUtils.e1(vibeWithMeBean.getModelName())) {
            this.tvTip.setText(getString(R.string.vibe_running));
        } else {
            this.tvTip.setText(String.format(getString(R.string.vibe_running_1), this.d.getModelName()));
        }
        this.tvTip.setTextColor(ContextCompat.getColor(this.application, R.color.white));
    }

    @Override // dc.cg2
    public void b() {
        finish();
    }

    @Override // dc.cg2
    public void end() {
        sg3.h(R.string.vibe_end_notification);
    }

    @Override // dc.cg2
    public void notifyDataSetChanged() {
        this.c.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @OnClick({R.id.tv_stop})
    public void onClick() {
        sz1.d().o();
        this.a.i();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_star_control);
        ButterKnife.bind(this);
        this.tvTime.setVisibility(8);
        StarControlAdapter starControlAdapter = new StarControlAdapter(this.b, R.layout.item_star_control);
        this.c = starControlAdapter;
        cg3.d(this.rvToys, starControlAdapter);
        s4();
        this.a.e(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.a.n(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        s4();
    }

    public final void s4() {
        if (!this.a.f()) {
            finish();
            return;
        }
        this.tvPf.setText(getString(R.string.vibe_title));
        this.tvTip.setText(getString(R.string.vibe_running));
        this.tvTip.setTextColor(ContextCompat.getColor(this.application, R.color.white));
        this.b.clear();
        this.b.addAll(this.a.k());
        notifyDataSetChanged();
        VibeWithMeBean vibeWithMeBean = this.a.k;
        if (vibeWithMeBean != null) {
            w1(vibeWithMeBean);
        }
    }

    @Override // dc.cg2
    public void w1(VibeWithMeBean vibeWithMeBean) {
        this.d = vibeWithMeBean;
        this.tvPf.setText(vibeWithMeBean.getPf());
        if (WearUtils.e1(vibeWithMeBean.getModelName())) {
            this.tvTip.setText(getString(R.string.vibe_running));
        } else {
            this.tvTip.setText(String.format(getString(R.string.vibe_running_1), vibeWithMeBean.getModelName()));
        }
    }
}
