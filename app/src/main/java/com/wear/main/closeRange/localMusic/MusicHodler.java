package com.wear.main.closeRange.localMusic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class MusicHodler {

    @BindView(R.id.iv_play_or_pause)
    public ImageView ivPlayOrPause;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_name)
    public TextView tvUserName;

    public MusicHodler(View view) {
        ButterKnife.bind(this, view);
    }

    public ImageView a() {
        return this.ivPlayOrPause;
    }

    public TextView b() {
        return this.tvTime;
    }

    public TextView c() {
        return this.tvUserName;
    }
}
