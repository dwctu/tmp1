package com.wear.ui.home.pattern.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class PatternHodler {

    @BindView(R.id.iv_play_or_pause)
    public ImageView ivPlayOrPause;

    @BindView(R.id.iv_under_preview)
    public ImageView iv_under_preview;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_name)
    public TextView tvUserName;

    public PatternHodler(View view) {
        ButterKnife.bind(this, view);
    }
}
