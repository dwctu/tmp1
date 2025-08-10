package com.wear.main.ninja;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.main.ninja.view.SlidingFinishLayout;

/* loaded from: classes3.dex */
public class NinjaLockActivity_ViewBinding implements Unbinder {
    public NinjaLockActivity a;

    @UiThread
    public NinjaLockActivity_ViewBinding(NinjaLockActivity ninjaLockActivity, View view) {
        this.a = ninjaLockActivity;
        ninjaLockActivity.tvLockTime = (TextView) Utils.findRequiredViewAsType(view, R.id.lock_time, "field 'tvLockTime'", TextView.class);
        ninjaLockActivity.tvLockDate = (TextView) Utils.findRequiredViewAsType(view, R.id.lock_date, "field 'tvLockDate'", TextView.class);
        ninjaLockActivity.ivAudio = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_audio, "field 'ivAudio'", ImageView.class);
        ninjaLockActivity.ivAudioIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_audio_icon, "field 'ivAudioIcon'", ImageView.class);
        ninjaLockActivity.iv_under_preview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_under_preview, "field 'iv_under_preview'", ImageView.class);
        ninjaLockActivity.tvAudioName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_audio_name, "field 'tvAudioName'", TextView.class);
        ninjaLockActivity.tvAudio = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_audio, "field 'tvAudio'", TextView.class);
        ninjaLockActivity.rlAudioEffect = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_audio_effect, "field 'rlAudioEffect'", RelativeLayout.class);
        ninjaLockActivity.btnCustomPrev = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_custom_prev, "field 'btnCustomPrev'", ImageView.class);
        ninjaLockActivity.btnCustomPlay = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_custom_play, "field 'btnCustomPlay'", ImageView.class);
        ninjaLockActivity.btnCustomNext = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_custom_next, "field 'btnCustomNext'", ImageView.class);
        ninjaLockActivity.btnCustomLoop = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_custom_loop, "field 'btnCustomLoop'", ImageView.class);
        ninjaLockActivity.llCustomButton = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_custom_button, "field 'llCustomButton'", LinearLayout.class);
        ninjaLockActivity.vLockRoot = (SlidingFinishLayout) Utils.findRequiredViewAsType(view, R.id.lock_root, "field 'vLockRoot'", SlidingFinishLayout.class);
        ninjaLockActivity.music_loading_1 = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.music_loading_1, "field 'music_loading_1'", ProgressBar.class);
        ninjaLockActivity.musicSeek = (SeekBar) Utils.findRequiredViewAsType(view, R.id.music_seek, "field 'musicSeek'", SeekBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NinjaLockActivity ninjaLockActivity = this.a;
        if (ninjaLockActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        ninjaLockActivity.tvLockTime = null;
        ninjaLockActivity.tvLockDate = null;
        ninjaLockActivity.ivAudio = null;
        ninjaLockActivity.ivAudioIcon = null;
        ninjaLockActivity.iv_under_preview = null;
        ninjaLockActivity.tvAudioName = null;
        ninjaLockActivity.tvAudio = null;
        ninjaLockActivity.rlAudioEffect = null;
        ninjaLockActivity.btnCustomPrev = null;
        ninjaLockActivity.btnCustomPlay = null;
        ninjaLockActivity.btnCustomNext = null;
        ninjaLockActivity.btnCustomLoop = null;
        ninjaLockActivity.llCustomButton = null;
        ninjaLockActivity.vLockRoot = null;
        ninjaLockActivity.music_loading_1 = null;
        ninjaLockActivity.musicSeek = null;
    }
}
