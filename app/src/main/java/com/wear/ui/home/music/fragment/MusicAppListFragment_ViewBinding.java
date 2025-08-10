package com.wear.ui.home.music.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class MusicAppListFragment_ViewBinding implements Unbinder {
    public MusicAppListFragment a;

    @UiThread
    public MusicAppListFragment_ViewBinding(MusicAppListFragment musicAppListFragment, View view) {
        this.a = musicAppListFragment;
        musicAppListFragment.mIvMusicImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_music_image, "field 'mIvMusicImage'", ImageView.class);
        musicAppListFragment.mTvMusicHow = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_music_how, "field 'mTvMusicHow'", TextView.class);
        musicAppListFragment.mTvMusicName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_music_name, "field 'mTvMusicName'", TextView.class);
        musicAppListFragment.mTvMusicSouc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_music_souc, "field 'mTvMusicSouc'", TextView.class);
        musicAppListFragment.mTvStepOne = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_step_one, "field 'mTvStepOne'", TextView.class);
        musicAppListFragment.mTvStepTwo = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_step_two, "field 'mTvStepTwo'", TextView.class);
        musicAppListFragment.mTvStepThree = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_step_three, "field 'mTvStepThree'", TextView.class);
        musicAppListFragment.musicAppname1 = (TextView) Utils.findRequiredViewAsType(view, R.id.music_appname_1, "field 'musicAppname1'", TextView.class);
        musicAppListFragment.musicAppnameMrore = (TextView) Utils.findRequiredViewAsType(view, R.id.music_appname_more, "field 'musicAppnameMrore'", TextView.class);
        musicAppListFragment.musicApplogo1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.music_applogo_1, "field 'musicApplogo1'", ImageView.class);
        musicAppListFragment.mLlAppName = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_app_name, "field 'mLlAppName'", LinearLayout.class);
        musicAppListFragment.mLlApplogoVibrate = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_applogo_vibrate, "field 'mLlApplogoVibrate'", LinearLayout.class);
        musicAppListFragment.mLlMusicAppName1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_music_appname_1, "field 'mLlMusicAppName1'", LinearLayout.class);
        musicAppListFragment.mLlMusicAppNameMore = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_app_name_more, "field 'mLlMusicAppNameMore'", LinearLayout.class);
        musicAppListFragment.musicApplogoVibrate = (ImageView) Utils.findRequiredViewAsType(view, R.id.music_applogo_vibrate, "field 'musicApplogoVibrate'", ImageView.class);
        musicAppListFragment.mLlStartPage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_start_page, "field 'mLlStartPage'", LinearLayout.class);
        musicAppListFragment.mIvHasPermission1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_has_permission1, "field 'mIvHasPermission1'", ImageView.class);
        musicAppListFragment.mIvHasPermission2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_has_permission2, "field 'mIvHasPermission2'", ImageView.class);
        musicAppListFragment.mTvSetUpNow = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_set_up_now, "field 'mTvSetUpNow'", TextView.class);
        musicAppListFragment.mTvAlreadyOpened = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_already_opened, "field 'mTvAlreadyOpened'", TextView.class);
        musicAppListFragment.mNestedScrollviewMusic = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.nestedscrollview_music, "field 'mNestedScrollviewMusic'", NestedScrollView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicAppListFragment musicAppListFragment = this.a;
        if (musicAppListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicAppListFragment.mIvMusicImage = null;
        musicAppListFragment.mTvMusicHow = null;
        musicAppListFragment.mTvMusicName = null;
        musicAppListFragment.mTvMusicSouc = null;
        musicAppListFragment.mTvStepOne = null;
        musicAppListFragment.mTvStepTwo = null;
        musicAppListFragment.mTvStepThree = null;
        musicAppListFragment.musicAppname1 = null;
        musicAppListFragment.musicAppnameMrore = null;
        musicAppListFragment.musicApplogo1 = null;
        musicAppListFragment.mLlAppName = null;
        musicAppListFragment.mLlApplogoVibrate = null;
        musicAppListFragment.mLlMusicAppName1 = null;
        musicAppListFragment.mLlMusicAppNameMore = null;
        musicAppListFragment.musicApplogoVibrate = null;
        musicAppListFragment.mLlStartPage = null;
        musicAppListFragment.mIvHasPermission1 = null;
        musicAppListFragment.mIvHasPermission2 = null;
        musicAppListFragment.mTvSetUpNow = null;
        musicAppListFragment.mTvAlreadyOpened = null;
        musicAppListFragment.mNestedScrollviewMusic = null;
    }
}
