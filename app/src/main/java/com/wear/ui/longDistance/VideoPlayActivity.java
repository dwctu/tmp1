package com.wear.ui.longDistance;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;

/* loaded from: classes3.dex */
public class VideoPlayActivity extends BaseActivity {

    @BindView(R.id.ac_video_center_play)
    public ImageView ivCenterPlay;

    @BindView(R.id.ac_video_cover)
    public ImageView ivCover;

    @BindView(R.id.ac_video_play)
    public ImageView ivPlay;

    @BindView(R.id.ac_video_rl_btn)
    public RelativeLayout rlBtn;

    @BindView(R.id.ac_video_rl_video)
    public RelativeLayout rlVideo;

    @BindView(R.id.ac_video_seekbar)
    public SeekBar seekBar;

    @BindView(R.id.ac_video_cur_time)
    public TextView tvCurTime;

    @BindView(R.id.ac_video_total_time)
    public TextView tvTotalTime;

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_play);
        ButterKnife.bind(this);
    }
}
