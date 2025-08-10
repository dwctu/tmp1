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
import com.wear.widget.recycler.SwipeRecyclerView;

/* loaded from: classes3.dex */
public class MusicLocalFragment_ViewBinding implements Unbinder {
    public MusicLocalFragment a;

    @UiThread
    public MusicLocalFragment_ViewBinding(MusicLocalFragment musicLocalFragment, View view) {
        this.a = musicLocalFragment;
        musicLocalFragment.recyclerView = (SwipeRecyclerView) Utils.findRequiredViewAsType(view, R.id.swipeRecyclerView, "field 'recyclerView'", SwipeRecyclerView.class);
        musicLocalFragment.music_list_empty = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.music_list_empty, "field 'music_list_empty'", NestedScrollView.class);
        musicLocalFragment.mLlMusicLocal = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_music_local, "field 'mLlMusicLocal'", LinearLayout.class);
        musicLocalFragment.mLlStartPage = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_start_page, "field 'mLlStartPage'", LinearLayout.class);
        musicLocalFragment.nestedscrollview = (NestedScrollView) Utils.findRequiredViewAsType(view, R.id.nestedscrollview, "field 'nestedscrollview'", NestedScrollView.class);
        musicLocalFragment.mIvHasPermission1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_has_permission1, "field 'mIvHasPermission1'", ImageView.class);
        musicLocalFragment.mIvHasPermission2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_has_permission2, "field 'mIvHasPermission2'", ImageView.class);
        musicLocalFragment.mTvSetUpNow = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_set_up_now, "field 'mTvSetUpNow'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicLocalFragment musicLocalFragment = this.a;
        if (musicLocalFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicLocalFragment.recyclerView = null;
        musicLocalFragment.music_list_empty = null;
        musicLocalFragment.mLlMusicLocal = null;
        musicLocalFragment.mLlStartPage = null;
        musicLocalFragment.nestedscrollview = null;
        musicLocalFragment.mIvHasPermission1 = null;
        musicLocalFragment.mIvHasPermission2 = null;
        musicLocalFragment.mTvSetUpNow = null;
    }
}
