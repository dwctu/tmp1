package com.wear.ui.home.music.fragment;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.recycler.SwipeRecyclerView;

/* loaded from: classes3.dex */
public class MusicPlayListFragment_ViewBinding implements Unbinder {
    public MusicPlayListFragment a;

    @UiThread
    public MusicPlayListFragment_ViewBinding(MusicPlayListFragment musicPlayListFragment, View view) {
        this.a = musicPlayListFragment;
        musicPlayListFragment.recyclerView = (SwipeRecyclerView) Utils.findRequiredViewAsType(view, R.id.swipeRecyclerView, "field 'recyclerView'", SwipeRecyclerView.class);
        musicPlayListFragment.musicListEmpty = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.music_list_empty, "field 'musicListEmpty'", NestedScrollView.class);
        musicPlayListFragment.mLlMusicLocal = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_music_local, "field 'mLlMusicLocal'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicPlayListFragment musicPlayListFragment = this.a;
        if (musicPlayListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicPlayListFragment.recyclerView = null;
        musicPlayListFragment.musicListEmpty = null;
        musicPlayListFragment.mLlMusicLocal = null;
    }
}
