package com.wear.ui.home.music.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.recycler.SwipeRecyclerView;

/* loaded from: classes3.dex */
public class MusicSpotifyFragment_ViewBinding implements Unbinder {
    public MusicSpotifyFragment a;

    @UiThread
    public MusicSpotifyFragment_ViewBinding(MusicSpotifyFragment musicSpotifyFragment, View view) {
        this.a = musicSpotifyFragment;
        musicSpotifyFragment.recyclerView = (SwipeRecyclerView) Utils.findRequiredViewAsType(view, R.id.swipeRecyclerView, "field 'recyclerView'", SwipeRecyclerView.class);
        musicSpotifyFragment.music_list_empty = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.music_list_empty, "field 'music_list_empty'", NestedScrollView.class);
        musicSpotifyFragment.spotifyPremiumSupported = Utils.findRequiredView(view, R.id.spotify_premium_supported, "field 'spotifyPremiumSupported'");
        musicSpotifyFragment.ll_login_spotify = Utils.findRequiredView(view, R.id.ll_login_spotify, "field 'll_login_spotify'");
        musicSpotifyFragment.spotify_music_layout = Utils.findRequiredView(view, R.id.spotify_music_layout, "field 'spotify_music_layout'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicSpotifyFragment musicSpotifyFragment = this.a;
        if (musicSpotifyFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicSpotifyFragment.recyclerView = null;
        musicSpotifyFragment.music_list_empty = null;
        musicSpotifyFragment.spotifyPremiumSupported = null;
        musicSpotifyFragment.ll_login_spotify = null;
        musicSpotifyFragment.spotify_music_layout = null;
    }
}
