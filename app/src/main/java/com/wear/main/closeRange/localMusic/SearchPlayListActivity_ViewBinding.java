package com.wear.main.closeRange.localMusic;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.recycler.SwipeRecyclerView;

/* loaded from: classes3.dex */
public class SearchPlayListActivity_ViewBinding implements Unbinder {
    public SearchPlayListActivity a;

    @UiThread
    public SearchPlayListActivity_ViewBinding(SearchPlayListActivity searchPlayListActivity, View view) {
        this.a = searchPlayListActivity;
        searchPlayListActivity.ll_result = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_result, "field 'll_result'", LinearLayout.class);
        searchPlayListActivity.musicPlayLayerPlaceholder = Utils.findRequiredView(view, R.id.music_play_layer_placeholder, "field 'musicPlayLayerPlaceholder'");
        searchPlayListActivity.musicSearchTracks = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_tracks, "field 'musicSearchTracks'", MediumBoldRadioButton.class);
        searchPlayListActivity.musicSearchArtists = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_artists, "field 'musicSearchArtists'", MediumBoldRadioButton.class);
        searchPlayListActivity.musicSearchAlbums = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_albums, "field 'musicSearchAlbums'", MediumBoldRadioButton.class);
        searchPlayListActivity.musicSearchPlaylists = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_playlists, "field 'musicSearchPlaylists'", MediumBoldRadioButton.class);
        searchPlayListActivity.allOrder = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.all_order, "field 'allOrder'", LinearLayout.class);
        searchPlayListActivity.dot_songs = Utils.findRequiredView(view, R.id.dot_songs, "field 'dot_songs'");
        searchPlayListActivity.dot_artists = Utils.findRequiredView(view, R.id.dot_artists, "field 'dot_artists'");
        searchPlayListActivity.dot_albums = Utils.findRequiredView(view, R.id.dot_albums, "field 'dot_albums'");
        searchPlayListActivity.dot_playlist = Utils.findRequiredView(view, R.id.dot_playlist, "field 'dot_playlist'");
        searchPlayListActivity.recyclerView = (SwipeRecyclerView) Utils.findRequiredViewAsType(view, R.id.swipeRecyclerView, "field 'recyclerView'", SwipeRecyclerView.class);
        searchPlayListActivity.musicListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_list_empty, "field 'musicListEmpty'", LinearLayout.class);
        searchPlayListActivity.musicListLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_list_layout, "field 'musicListLayout'", LinearLayout.class);
        searchPlayListActivity.search_histroy_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.search_histroy_layout, "field 'search_histroy_layout'", LinearLayout.class);
        searchPlayListActivity.search_histroy_lv = (ListView) Utils.findRequiredViewAsType(view, R.id.search_histroy_lv, "field 'search_histroy_lv'", ListView.class);
        searchPlayListActivity.clear_histroy_lv = (TextView) Utils.findRequiredViewAsType(view, R.id.clear_histroy_lv, "field 'clear_histroy_lv'", TextView.class);
        searchPlayListActivity.search_clean_bnt = (ImageView) Utils.findRequiredViewAsType(view, R.id.search_clean_bnt, "field 'search_clean_bnt'", ImageView.class);
        searchPlayListActivity.search_edit_text = (EditText) Utils.findRequiredViewAsType(view, R.id.search_edit_text, "field 'search_edit_text'", EditText.class);
        searchPlayListActivity.tv_cancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tv_cancel'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchPlayListActivity searchPlayListActivity = this.a;
        if (searchPlayListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchPlayListActivity.ll_result = null;
        searchPlayListActivity.musicPlayLayerPlaceholder = null;
        searchPlayListActivity.musicSearchTracks = null;
        searchPlayListActivity.musicSearchArtists = null;
        searchPlayListActivity.musicSearchAlbums = null;
        searchPlayListActivity.musicSearchPlaylists = null;
        searchPlayListActivity.allOrder = null;
        searchPlayListActivity.dot_songs = null;
        searchPlayListActivity.dot_artists = null;
        searchPlayListActivity.dot_albums = null;
        searchPlayListActivity.dot_playlist = null;
        searchPlayListActivity.recyclerView = null;
        searchPlayListActivity.musicListEmpty = null;
        searchPlayListActivity.musicListLayout = null;
        searchPlayListActivity.search_histroy_layout = null;
        searchPlayListActivity.search_histroy_lv = null;
        searchPlayListActivity.clear_histroy_lv = null;
        searchPlayListActivity.search_clean_bnt = null;
        searchPlayListActivity.search_edit_text = null;
        searchPlayListActivity.tv_cancel = null;
    }
}
