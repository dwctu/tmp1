package com.wear.ui.home.music;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class NewMusicActivity_ViewBinding implements Unbinder {
    public NewMusicActivity a;

    @UiThread
    public NewMusicActivity_ViewBinding(NewMusicActivity newMusicActivity, View view) {
        this.a = newMusicActivity;
        newMusicActivity.loadingLayer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.loading_layer, "field 'loadingLayer'", LinearLayout.class);
        newMusicActivity.mFlSoundRecord = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_sound_record, "field 'mFlSoundRecord'", FrameLayout.class);
        newMusicActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        newMusicActivity.local_music = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.local_music, "field 'local_music'", MediumBoldRadioButton.class);
        newMusicActivity.playlist_music = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.playlist_music, "field 'playlist_music'", MediumBoldRadioButton.class);
        newMusicActivity.stream_music = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.stream_music, "field 'stream_music'", MediumBoldRadioButton.class);
        newMusicActivity.music_app = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_app, "field 'music_app'", MediumBoldRadioButton.class);
        newMusicActivity.music_list_layout = Utils.findRequiredView(view, R.id.music_list_layout, "field 'music_list_layout'");
        newMusicActivity.music_type_layout = Utils.findRequiredView(view, R.id.music_type_layout, "field 'music_type_layout'");
        newMusicActivity.music_create_layout_bottom_line = Utils.findRequiredView(view, R.id.music_create_layout_bottom_line, "field 'music_create_layout_bottom_line'");
        newMusicActivity.music_artist_list = (RadioButton) Utils.findRequiredViewAsType(view, R.id.music_artist_list, "field 'music_artist_list'", RadioButton.class);
        newMusicActivity.music_song_list = (RadioButton) Utils.findRequiredViewAsType(view, R.id.music_song_list, "field 'music_song_list'", RadioButton.class);
        newMusicActivity.music_album_list = (RadioButton) Utils.findRequiredViewAsType(view, R.id.music_album_list, "field 'music_album_list'", RadioButton.class);
        newMusicActivity.iv_music_search = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_music_search, "field 'iv_music_search'", ImageView.class);
        newMusicActivity.music_create_layout = Utils.findRequiredView(view, R.id.music_create_layout, "field 'music_create_layout'");
        newMusicActivity.rlIconMusicPanelRecord = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_icon_music_panel_record, "field 'rlIconMusicPanelRecord'", RelativeLayout.class);
        newMusicActivity.bibIconMusicPanelRecord = Utils.findRequiredView(view, R.id.bib_icon_music_panel_record, "field 'bibIconMusicPanelRecord'");
        newMusicActivity.ivPermission = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_permission, "field 'ivPermission'", ImageView.class);
        newMusicActivity.llPermission = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_permission, "field 'llPermission'", LinearLayout.class);
        newMusicActivity.localRedDot = Utils.findRequiredView(view, R.id.local_red_dot, "field 'localRedDot'");
        newMusicActivity.streamRedDot = Utils.findRequiredView(view, R.id.stream_red_dot, "field 'streamRedDot'");
        newMusicActivity.playlistRedDot = Utils.findRequiredView(view, R.id.playlist_red_dot, "field 'playlistRedDot'");
        newMusicActivity.mVAppListMusicRedDot = Utils.findRequiredView(view, R.id.app_list_music, "field 'mVAppListMusicRedDot'");
        newMusicActivity.ivSearch = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_search, "field 'ivSearch'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        NewMusicActivity newMusicActivity = this.a;
        if (newMusicActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newMusicActivity.loadingLayer = null;
        newMusicActivity.mFlSoundRecord = null;
        newMusicActivity.actionbar = null;
        newMusicActivity.local_music = null;
        newMusicActivity.playlist_music = null;
        newMusicActivity.stream_music = null;
        newMusicActivity.music_app = null;
        newMusicActivity.music_list_layout = null;
        newMusicActivity.music_type_layout = null;
        newMusicActivity.music_create_layout_bottom_line = null;
        newMusicActivity.music_artist_list = null;
        newMusicActivity.music_song_list = null;
        newMusicActivity.music_album_list = null;
        newMusicActivity.iv_music_search = null;
        newMusicActivity.music_create_layout = null;
        newMusicActivity.rlIconMusicPanelRecord = null;
        newMusicActivity.bibIconMusicPanelRecord = null;
        newMusicActivity.ivPermission = null;
        newMusicActivity.llPermission = null;
        newMusicActivity.localRedDot = null;
        newMusicActivity.streamRedDot = null;
        newMusicActivity.playlistRedDot = null;
        newMusicActivity.mVAppListMusicRedDot = null;
        newMusicActivity.ivSearch = null;
    }
}
