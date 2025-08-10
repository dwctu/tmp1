package com.wear.main.closeRange.localMusic;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.wear.widget.MyActionBar;
import com.yydcdut.sdlv.SlideAndDragListView;

/* loaded from: classes3.dex */
public class PlaylistDetailsActivity_ViewBinding implements Unbinder {
    public PlaylistDetailsActivity a;

    @UiThread
    public PlaylistDetailsActivity_ViewBinding(PlaylistDetailsActivity playlistDetailsActivity, View view) {
        this.a = playlistDetailsActivity;
        playlistDetailsActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        playlistDetailsActivity.music_list = (SlideAndDragListView) Utils.findRequiredViewAsType(view, R.id.music_list, "field 'music_list'", SlideAndDragListView.class);
        playlistDetailsActivity.swipeRefreshLayout = (SwipyRefreshLayout) Utils.findRequiredViewAsType(view, R.id.swipe_refresh, "field 'swipeRefreshLayout'", SwipyRefreshLayout.class);
        playlistDetailsActivity.mFlSoundRecord = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_sound_record, "field 'mFlSoundRecord'", FrameLayout.class);
        playlistDetailsActivity.music_list_empty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_list_empty, "field 'music_list_empty'", LinearLayout.class);
        playlistDetailsActivity.music_list_empty_no = (TextView) Utils.findRequiredViewAsType(view, R.id.music_list_empty_no, "field 'music_list_empty_no'", TextView.class);
        playlistDetailsActivity.music_list_empty_no_tip = (TextView) Utils.findRequiredViewAsType(view, R.id.music_list_empty_no_tip, "field 'music_list_empty_no_tip'", TextView.class);
        playlistDetailsActivity.music_playlist_item_cover = (ImageView) Utils.findRequiredViewAsType(view, R.id.music_playlist_item_cover, "field 'music_playlist_item_cover'", ImageView.class);
        playlistDetailsActivity.music_playlist_item_name = (TextView) Utils.findRequiredViewAsType(view, R.id.music_playlist_item_name, "field 'music_playlist_item_name'", TextView.class);
        playlistDetailsActivity.music_playlist_item_create_time = (TextView) Utils.findRequiredViewAsType(view, R.id.music_playlist_item_create_time, "field 'music_playlist_item_create_time'", TextView.class);
        playlistDetailsActivity.music_playlist_item_songs = (TextView) Utils.findRequiredViewAsType(view, R.id.music_playlist_item_songs, "field 'music_playlist_item_songs'", TextView.class);
        playlistDetailsActivity.music_playall = Utils.findRequiredView(view, R.id.music_playall, "field 'music_playall'");
        playlistDetailsActivity.vi_music_sort = Utils.findRequiredView(view, R.id.vi_music_sort, "field 'vi_music_sort'");
        playlistDetailsActivity.pbMusicLoading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_music_loading, "field 'pbMusicLoading'", ProgressBar.class);
        playlistDetailsActivity.ivMusicPlayStatus = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_music_play_status, "field 'ivMusicPlayStatus'", ImageView.class);
        playlistDetailsActivity.rlIconMusicPanelRecord = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_icon_music_panel_record, "field 'rlIconMusicPanelRecord'", RelativeLayout.class);
        playlistDetailsActivity.bibIconMusicPanelRecord = Utils.findRequiredView(view, R.id.bib_icon_music_panel_record, "field 'bibIconMusicPanelRecord'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PlaylistDetailsActivity playlistDetailsActivity = this.a;
        if (playlistDetailsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        playlistDetailsActivity.actionbar = null;
        playlistDetailsActivity.music_list = null;
        playlistDetailsActivity.swipeRefreshLayout = null;
        playlistDetailsActivity.mFlSoundRecord = null;
        playlistDetailsActivity.music_list_empty = null;
        playlistDetailsActivity.music_list_empty_no = null;
        playlistDetailsActivity.music_list_empty_no_tip = null;
        playlistDetailsActivity.music_playlist_item_cover = null;
        playlistDetailsActivity.music_playlist_item_name = null;
        playlistDetailsActivity.music_playlist_item_create_time = null;
        playlistDetailsActivity.music_playlist_item_songs = null;
        playlistDetailsActivity.music_playall = null;
        playlistDetailsActivity.vi_music_sort = null;
        playlistDetailsActivity.pbMusicLoading = null;
        playlistDetailsActivity.ivMusicPlayStatus = null;
        playlistDetailsActivity.rlIconMusicPanelRecord = null;
        playlistDetailsActivity.bibIconMusicPanelRecord = null;
    }
}
