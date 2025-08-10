package com.wear.ui.longDistance.video;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.lovense.wear.R;
import com.wear.ui.longDistance.video.player.MyVideoView;
import com.wear.widget.llong.GesLayout;

/* loaded from: classes4.dex */
public class VideoPlayerActivity_ViewBinding implements Unbinder {
    public VideoPlayerActivity a;

    @UiThread
    public VideoPlayerActivity_ViewBinding(VideoPlayerActivity videoPlayerActivity, View view) {
        this.a = videoPlayerActivity;
        videoPlayerActivity.gesLayout = (GesLayout) Utils.findRequiredViewAsType(view, R.id.ac_video_ges_layout, "field 'gesLayout'", GesLayout.class);
        videoPlayerActivity.rlVideo = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ac_video_root_layout, "field 'rlVideo'", RelativeLayout.class);
        videoPlayerActivity.mVideoView = (MyVideoView) Utils.findRequiredViewAsType(view, R.id.player, "field 'mVideoView'", MyVideoView.class);
        videoPlayerActivity.pic_big_view = (SubsamplingScaleImageView) Utils.findRequiredViewAsType(view, R.id.pic_big_view, "field 'pic_big_view'", SubsamplingScaleImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoPlayerActivity videoPlayerActivity = this.a;
        if (videoPlayerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        videoPlayerActivity.gesLayout = null;
        videoPlayerActivity.rlVideo = null;
        videoPlayerActivity.mVideoView = null;
        videoPlayerActivity.pic_big_view = null;
    }
}
