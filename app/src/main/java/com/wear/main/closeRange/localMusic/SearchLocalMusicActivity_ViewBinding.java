package com.wear.main.closeRange.localMusic;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.recycler.SwipeRecyclerView;

/* loaded from: classes3.dex */
public class SearchLocalMusicActivity_ViewBinding implements Unbinder {
    public SearchLocalMusicActivity a;

    @UiThread
    public SearchLocalMusicActivity_ViewBinding(SearchLocalMusicActivity searchLocalMusicActivity, View view) {
        this.a = searchLocalMusicActivity;
        searchLocalMusicActivity.ll_result = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_result, "field 'll_result'", LinearLayout.class);
        searchLocalMusicActivity.musicPlayLayerPlaceholder = Utils.findRequiredView(view, R.id.music_play_layer_placeholder, "field 'musicPlayLayerPlaceholder'");
        searchLocalMusicActivity.musicSearchTracks = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_tracks, "field 'musicSearchTracks'", MediumBoldRadioButton.class);
        searchLocalMusicActivity.musicSearchArtists = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_artists, "field 'musicSearchArtists'", MediumBoldRadioButton.class);
        searchLocalMusicActivity.musicSearchAlbums = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_albums, "field 'musicSearchAlbums'", MediumBoldRadioButton.class);
        searchLocalMusicActivity.musicSearchPlaylists = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_playlists, "field 'musicSearchPlaylists'", MediumBoldRadioButton.class);
        searchLocalMusicActivity.allOrder = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.all_order, "field 'allOrder'", LinearLayout.class);
        searchLocalMusicActivity.dot_songs = Utils.findRequiredView(view, R.id.dot_songs, "field 'dot_songs'");
        searchLocalMusicActivity.dot_artists = Utils.findRequiredView(view, R.id.dot_artists, "field 'dot_artists'");
        searchLocalMusicActivity.dot_albums = Utils.findRequiredView(view, R.id.dot_albums, "field 'dot_albums'");
        searchLocalMusicActivity.dot_playlist = Utils.findRequiredView(view, R.id.dot_playlist, "field 'dot_playlist'");
        searchLocalMusicActivity.recyclerView = (SwipeRecyclerView) Utils.findRequiredViewAsType(view, R.id.swipeRecyclerView, "field 'recyclerView'", SwipeRecyclerView.class);
        searchLocalMusicActivity.musicListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_list_empty, "field 'musicListEmpty'", LinearLayout.class);
        searchLocalMusicActivity.musicListLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_list_layout, "field 'musicListLayout'", LinearLayout.class);
        searchLocalMusicActivity.search_histroy_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.search_histroy_layout, "field 'search_histroy_layout'", LinearLayout.class);
        searchLocalMusicActivity.search_histroy_lv = (ListView) Utils.findRequiredViewAsType(view, R.id.search_histroy_lv, "field 'search_histroy_lv'", ListView.class);
        searchLocalMusicActivity.clear_histroy_lv = (TextView) Utils.findRequiredViewAsType(view, R.id.clear_histroy_lv, "field 'clear_histroy_lv'", TextView.class);
        searchLocalMusicActivity.search_clean_bnt = (ImageView) Utils.findRequiredViewAsType(view, R.id.search_clean_bnt, "field 'search_clean_bnt'", ImageView.class);
        searchLocalMusicActivity.search_edit_text = (EditText) Utils.findRequiredViewAsType(view, R.id.search_edit_text, "field 'search_edit_text'", EditText.class);
        searchLocalMusicActivity.tv_cancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tv_cancel'", TextView.class);
        searchLocalMusicActivity.mFlSoundRecord = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_sound_record, "field 'mFlSoundRecord'", FrameLayout.class);
        searchLocalMusicActivity.rlIconMusicPanelRecord = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_icon_music_panel_record, "field 'rlIconMusicPanelRecord'", RelativeLayout.class);
        searchLocalMusicActivity.bibIconMusicPanelRecord = Utils.findRequiredView(view, R.id.bib_icon_music_panel_record, "field 'bibIconMusicPanelRecord'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchLocalMusicActivity searchLocalMusicActivity = this.a;
        if (searchLocalMusicActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchLocalMusicActivity.ll_result = null;
        searchLocalMusicActivity.musicPlayLayerPlaceholder = null;
        searchLocalMusicActivity.musicSearchTracks = null;
        searchLocalMusicActivity.musicSearchArtists = null;
        searchLocalMusicActivity.musicSearchAlbums = null;
        searchLocalMusicActivity.musicSearchPlaylists = null;
        searchLocalMusicActivity.allOrder = null;
        searchLocalMusicActivity.dot_songs = null;
        searchLocalMusicActivity.dot_artists = null;
        searchLocalMusicActivity.dot_albums = null;
        searchLocalMusicActivity.dot_playlist = null;
        searchLocalMusicActivity.recyclerView = null;
        searchLocalMusicActivity.musicListEmpty = null;
        searchLocalMusicActivity.musicListLayout = null;
        searchLocalMusicActivity.search_histroy_layout = null;
        searchLocalMusicActivity.search_histroy_lv = null;
        searchLocalMusicActivity.clear_histroy_lv = null;
        searchLocalMusicActivity.search_clean_bnt = null;
        searchLocalMusicActivity.search_edit_text = null;
        searchLocalMusicActivity.tv_cancel = null;
        searchLocalMusicActivity.mFlSoundRecord = null;
        searchLocalMusicActivity.rlIconMusicPanelRecord = null;
        searchLocalMusicActivity.bibIconMusicPanelRecord = null;
    }
}
