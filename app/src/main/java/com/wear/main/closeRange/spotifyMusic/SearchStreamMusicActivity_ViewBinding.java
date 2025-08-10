package com.wear.main.closeRange.spotifyMusic;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.BaseImageButton;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.recycler.SwipeRecyclerView;

/* loaded from: classes3.dex */
public class SearchStreamMusicActivity_ViewBinding implements Unbinder {
    public SearchStreamMusicActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ SearchStreamMusicActivity a;

        public a(SearchStreamMusicActivity_ViewBinding searchStreamMusicActivity_ViewBinding, SearchStreamMusicActivity searchStreamMusicActivity) {
            this.a = searchStreamMusicActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ SearchStreamMusicActivity a;

        public b(SearchStreamMusicActivity_ViewBinding searchStreamMusicActivity_ViewBinding, SearchStreamMusicActivity searchStreamMusicActivity) {
            this.a = searchStreamMusicActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public SearchStreamMusicActivity_ViewBinding(SearchStreamMusicActivity searchStreamMusicActivity, View view) {
        this.a = searchStreamMusicActivity;
        searchStreamMusicActivity.ll_result = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_result, "field 'll_result'", LinearLayout.class);
        searchStreamMusicActivity.musicPlayLayerPlaceholder = Utils.findRequiredView(view, R.id.music_play_layer_placeholder, "field 'musicPlayLayerPlaceholder'");
        searchStreamMusicActivity.musicSearchTracks = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_tracks, "field 'musicSearchTracks'", MediumBoldRadioButton.class);
        searchStreamMusicActivity.musicSearchArtists = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_artists, "field 'musicSearchArtists'", MediumBoldRadioButton.class);
        searchStreamMusicActivity.musicSearchAlbums = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_albums, "field 'musicSearchAlbums'", MediumBoldRadioButton.class);
        searchStreamMusicActivity.musicSearchPlaylists = (MediumBoldRadioButton) Utils.findRequiredViewAsType(view, R.id.music_search_playlists, "field 'musicSearchPlaylists'", MediumBoldRadioButton.class);
        searchStreamMusicActivity.allOrder = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.all_order, "field 'allOrder'", LinearLayout.class);
        searchStreamMusicActivity.dot_songs = Utils.findRequiredView(view, R.id.dot_songs, "field 'dot_songs'");
        searchStreamMusicActivity.dot_artists = Utils.findRequiredView(view, R.id.dot_artists, "field 'dot_artists'");
        searchStreamMusicActivity.dot_albums = Utils.findRequiredView(view, R.id.dot_albums, "field 'dot_albums'");
        searchStreamMusicActivity.dot_playlist = Utils.findRequiredView(view, R.id.dot_playlist, "field 'dot_playlist'");
        searchStreamMusicActivity.recyclerView = (SwipeRecyclerView) Utils.findRequiredViewAsType(view, R.id.swipeRecyclerView, "field 'recyclerView'", SwipeRecyclerView.class);
        searchStreamMusicActivity.musicListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_list_empty, "field 'musicListEmpty'", LinearLayout.class);
        searchStreamMusicActivity.musicListLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.music_list_layout, "field 'musicListLayout'", LinearLayout.class);
        searchStreamMusicActivity.search_histroy_layout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.search_histroy_layout, "field 'search_histroy_layout'", LinearLayout.class);
        searchStreamMusicActivity.search_histroy_lv = (ListView) Utils.findRequiredViewAsType(view, R.id.search_histroy_lv, "field 'search_histroy_lv'", ListView.class);
        searchStreamMusicActivity.clear_histroy_lv = (TextView) Utils.findRequiredViewAsType(view, R.id.clear_histroy_lv, "field 'clear_histroy_lv'", TextView.class);
        searchStreamMusicActivity.search_clean_bnt = (ImageView) Utils.findRequiredViewAsType(view, R.id.search_clean_bnt, "field 'search_clean_bnt'", ImageView.class);
        searchStreamMusicActivity.search_edit_text = (EditText) Utils.findRequiredViewAsType(view, R.id.search_edit_text, "field 'search_edit_text'", EditText.class);
        searchStreamMusicActivity.tv_cancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tv_cancel'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.bib_icon_music_panel_record, "field 'bibIconMusicPanelRecord' and method 'onViewClicked'");
        searchStreamMusicActivity.bibIconMusicPanelRecord = (BaseImageButton) Utils.castView(viewFindRequiredView, R.id.bib_icon_music_panel_record, "field 'bibIconMusicPanelRecord'", BaseImageButton.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, searchStreamMusicActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_icon_music_panel_record, "field 'rlIconMusicPanelRecord' and method 'onViewClicked'");
        searchStreamMusicActivity.rlIconMusicPanelRecord = (RelativeLayout) Utils.castView(viewFindRequiredView2, R.id.rl_icon_music_panel_record, "field 'rlIconMusicPanelRecord'", RelativeLayout.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, searchStreamMusicActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchStreamMusicActivity searchStreamMusicActivity = this.a;
        if (searchStreamMusicActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        searchStreamMusicActivity.ll_result = null;
        searchStreamMusicActivity.musicPlayLayerPlaceholder = null;
        searchStreamMusicActivity.musicSearchTracks = null;
        searchStreamMusicActivity.musicSearchArtists = null;
        searchStreamMusicActivity.musicSearchAlbums = null;
        searchStreamMusicActivity.musicSearchPlaylists = null;
        searchStreamMusicActivity.allOrder = null;
        searchStreamMusicActivity.dot_songs = null;
        searchStreamMusicActivity.dot_artists = null;
        searchStreamMusicActivity.dot_albums = null;
        searchStreamMusicActivity.dot_playlist = null;
        searchStreamMusicActivity.recyclerView = null;
        searchStreamMusicActivity.musicListEmpty = null;
        searchStreamMusicActivity.musicListLayout = null;
        searchStreamMusicActivity.search_histroy_layout = null;
        searchStreamMusicActivity.search_histroy_lv = null;
        searchStreamMusicActivity.clear_histroy_lv = null;
        searchStreamMusicActivity.search_clean_bnt = null;
        searchStreamMusicActivity.search_edit_text = null;
        searchStreamMusicActivity.tv_cancel = null;
        searchStreamMusicActivity.bibIconMusicPanelRecord = null;
        searchStreamMusicActivity.rlIconMusicPanelRecord = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
