package com.wear.main.account;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class HomepageSettingsActivity_ViewBinding implements Unbinder {
    public HomepageSettingsActivity a;

    @UiThread
    public HomepageSettingsActivity_ViewBinding(HomepageSettingsActivity homepageSettingsActivity, View view) {
        this.a = homepageSettingsActivity;
        homepageSettingsActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_rcv, "field 'recyclerView'", RecyclerView.class);
        homepageSettingsActivity.ivPatternContent = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_pattern_content, "field 'ivPatternContent'", ImageView.class);
        homepageSettingsActivity.ivPatternContentSel = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_pattern_content_select, "field 'ivPatternContentSel'", ImageView.class);
        homepageSettingsActivity.ivPatternPure = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_pattern_pure, "field 'ivPatternPure'", ImageView.class);
        homepageSettingsActivity.ivPatternPureSel = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_pattern_pure_select, "field 'ivPatternPureSel'", ImageView.class);
        homepageSettingsActivity.ivMusicContent = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_music_content, "field 'ivMusicContent'", ImageView.class);
        homepageSettingsActivity.ivMusicContentSel = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_music_content_select, "field 'ivMusicContentSel'", ImageView.class);
        homepageSettingsActivity.ivMusicPure = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_music_pure, "field 'ivMusicPure'", ImageView.class);
        homepageSettingsActivity.ivMusicPureSel = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_homepage_settings_music_pure_select, "field 'ivMusicPureSel'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HomepageSettingsActivity homepageSettingsActivity = this.a;
        if (homepageSettingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        homepageSettingsActivity.recyclerView = null;
        homepageSettingsActivity.ivPatternContent = null;
        homepageSettingsActivity.ivPatternContentSel = null;
        homepageSettingsActivity.ivPatternPure = null;
        homepageSettingsActivity.ivPatternPureSel = null;
        homepageSettingsActivity.ivMusicContent = null;
        homepageSettingsActivity.ivMusicContentSel = null;
        homepageSettingsActivity.ivMusicPure = null;
        homepageSettingsActivity.ivMusicPureSel = null;
    }
}
