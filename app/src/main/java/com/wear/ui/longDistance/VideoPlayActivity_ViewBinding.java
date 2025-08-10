package com.wear.ui.longDistance;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class VideoPlayActivity_ViewBinding implements Unbinder {
    public VideoPlayActivity a;

    @UiThread
    public VideoPlayActivity_ViewBinding(VideoPlayActivity videoPlayActivity, View view) {
        this.a = videoPlayActivity;
        videoPlayActivity.rlVideo = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ac_video_rl_video, "field 'rlVideo'", RelativeLayout.class);
        videoPlayActivity.ivCover = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_video_cover, "field 'ivCover'", ImageView.class);
        videoPlayActivity.rlBtn = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ac_video_rl_btn, "field 'rlBtn'", RelativeLayout.class);
        videoPlayActivity.ivCenterPlay = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_video_center_play, "field 'ivCenterPlay'", ImageView.class);
        videoPlayActivity.ivPlay = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_video_play, "field 'ivPlay'", ImageView.class);
        videoPlayActivity.tvCurTime = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_video_cur_time, "field 'tvCurTime'", TextView.class);
        videoPlayActivity.tvTotalTime = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_video_total_time, "field 'tvTotalTime'", TextView.class);
        videoPlayActivity.seekBar = (SeekBar) Utils.findRequiredViewAsType(view, R.id.ac_video_seekbar, "field 'seekBar'", SeekBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoPlayActivity videoPlayActivity = this.a;
        if (videoPlayActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        videoPlayActivity.rlVideo = null;
        videoPlayActivity.ivCover = null;
        videoPlayActivity.rlBtn = null;
        videoPlayActivity.ivCenterPlay = null;
        videoPlayActivity.ivPlay = null;
        videoPlayActivity.tvCurTime = null;
        videoPlayActivity.tvTotalTime = null;
        videoPlayActivity.seekBar = null;
    }
}
