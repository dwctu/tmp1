package com.wear.ui.home.music.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.adapter.localmusic.MusicNewAdapter;
import com.wear.adapter.localmusic.PlayListGroupAdapter;
import com.wear.bean.HomeMusicBean;
import com.wear.dao.DaoUtils;
import com.wear.main.BaseFragment;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.closeRange.spotifyMusic.StreamMusicLoginActivity;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.util.MyApplication;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import com.wear.widget.recycler.AutoRVAdapter;
import com.wear.widget.recycler.RVHolder;
import com.wear.widget.recycler.SwipeRecyclerView;
import dc.k12;
import dc.l12;
import dc.pj3;
import dc.sg3;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class MusicSpotifyFragment extends BaseFragment implements View.OnClickListener {
    public Unbinder k;
    public MusicNewAdapter l;

    @BindView(R.id.ll_login_spotify)
    public View ll_login_spotify;
    public PlayListGroupAdapter m;

    @BindView(R.id.music_list_empty)
    public NestedScrollView music_list_empty;
    public NewMusicActivity n;
    public Handler o = new Handler();
    public int p = R.id.music_song_list;
    public AutoRVAdapter.c q = new b();

    @BindView(R.id.swipeRecyclerView)
    public SwipeRecyclerView recyclerView;

    @BindView(R.id.spotify_premium_supported)
    public View spotifyPremiumSupported;

    @BindView(R.id.spotify_music_layout)
    public View spotify_music_layout;

    public class a implements SwipeRecyclerView.d {
        public a() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void a() {
            if (k12.m != null) {
                MusicControl.h0().w(false, false, false);
            }
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void onRefresh() {
            if (k12.m != null) {
                MusicControl.h0().w(true, true, false);
            }
            MusicSpotifyFragment.this.recyclerView.p();
        }
    }

    public class b implements AutoRVAdapter.c {
        public b() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.c
        public void a(int i, RVHolder rVHolder) throws IllegalStateException {
            PlayListGroupAdapter playListGroupAdapter;
            if (MusicSpotifyFragment.this.p == R.id.music_song_list) {
                MusicControl.h0().F(null, MusicControl.h0().e.i);
                MusicControl.h0().s0(i);
            } else {
                if ((MusicSpotifyFragment.this.p != R.id.music_artist_list && MusicSpotifyFragment.this.p != R.id.music_album_list) || (playListGroupAdapter = MusicSpotifyFragment.this.m) == null || playListGroupAdapter.v(i) == null || MusicSpotifyFragment.this.m.v(i).getItemsList() == null) {
                    return;
                }
                MusicSpotifyFragment.this.n.J4(MusicSpotifyFragment.this.m.v(i));
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MusicSpotifyFragment.this.spotifyPremiumSupported.setVisibility(8);
        }
    }

    public class d implements Runnable {

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k12.m == null || MusicControl.h0().e == null) {
                    return;
                }
                MusicControl.h0().e.n(MusicSpotifyFragment.this.n);
                MusicControl.h0().e.G();
                l12.m(1, "");
                MusicSpotifyFragment.this.ll_login_spotify.performClick();
                MusicSpotifyFragment.this.spotifyPremiumSupported.setVisibility(8);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MusicSpotifyFragment.this.spotifyPremiumSupported.setVisibility(0);
            MusicSpotifyFragment.this.spotifyPremiumSupported.setOnClickListener(new a());
            if (MusicControl.h0().e.O()) {
                return;
            }
            MusicSpotifyFragment.this.spotifyPremiumSupported.setVisibility(8);
        }
    }

    public final boolean a0() {
        boolean z = true;
        if (!MusicControl.h0().e.O() || !MusicControl.h0().e.u()) {
            z = false;
            if (this.spotifyPremiumSupported != null) {
                this.o.post(new d());
            }
        } else if (this.spotifyPremiumSupported != null) {
            this.o.post(new c());
        }
        return z;
    }

    public void b0(int i) {
        this.p = i;
        if (i == R.id.music_artist_list) {
            this.m.x(MusicControl.h0().e.j);
        } else if (i == R.id.music_song_list) {
            this.l.w(MusicControl.h0().e.i);
        } else if (i == R.id.music_album_list) {
            this.m.x(MusicControl.h0().e.k);
        }
        this.recyclerView.s();
        this.recyclerView.p();
    }

    public void c0() {
        if (k12.m == null || !a0()) {
            return;
        }
        if (DaoUtils.getMusicSpotifyDao().countOf() <= 0) {
            MusicControl.h0().w(true, true, true);
        } else {
            MusicControl.h0().w(true, false, true);
        }
    }

    public void d0() {
        MusicNewAdapter musicNewAdapter = this.l;
        if (musicNewAdapter != null) {
            musicNewAdapter.w(null);
        }
        PlayListGroupAdapter playListGroupAdapter = this.m;
        if (playListGroupAdapter != null) {
            playListGroupAdapter.x(null);
        }
        e0();
        View view = this.spotify_music_layout;
        if (view != null) {
            view.setVisibility(0);
        }
        SwipeRecyclerView swipeRecyclerView = this.recyclerView;
        if (swipeRecyclerView != null) {
            swipeRecyclerView.setVisibility(8);
        }
        NestedScrollView nestedScrollView = this.music_list_empty;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(8);
        }
    }

    public void e0() {
        SwipeRecyclerView swipeRecyclerView = this.recyclerView;
        if (swipeRecyclerView != null) {
            swipeRecyclerView.s();
        }
        MusicNewAdapter musicNewAdapter = this.l;
        if (musicNewAdapter != null) {
            musicNewAdapter.notifyDataSetChanged();
        }
    }

    public void f0() {
        MusicNewAdapter musicNewAdapter = this.l;
        if (musicNewAdapter != null) {
            musicNewAdapter.notifyDataSetChanged();
        }
    }

    public void g0(int i) {
        SwipeRecyclerView swipeRecyclerView = this.recyclerView;
        if (swipeRecyclerView != null) {
            int i2 = this.n.d;
            if (i2 != -1) {
                swipeRecyclerView.t(i2);
            }
            if (i >= 0) {
                this.recyclerView.t(i);
            }
            this.recyclerView.s();
        }
    }

    public void h0(int i) {
        AutoRVAdapter autoRVAdapter;
        this.p = i;
        if (i == R.id.music_artist_list) {
            this.m.x(MusicControl.h0().e.j);
            autoRVAdapter = this.m;
        } else if (i == R.id.music_album_list) {
            this.m.x(MusicControl.h0().e.k);
            autoRVAdapter = this.m;
        } else {
            this.l.w(MusicControl.h0().e.i);
            autoRVAdapter = this.l;
        }
        autoRVAdapter.u(null);
        autoRVAdapter.t(this.q);
        this.recyclerView.setAdapterSimple(autoRVAdapter);
        this.recyclerView.s();
        this.recyclerView.p();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void homeMusic(HomeMusicBean homeMusicBean) {
        if (homeMusicBean != null && (homeMusicBean.getType() == 6 || homeMusicBean.getType() == 12)) {
            MusicControl.h0().e.i = DaoUtils.getMusicSpotifyDao().findAllMusic();
            this.l.w(MusicControl.h0().e.i);
            j0(MusicControl.h0().e.i.size(), false);
            return;
        }
        if (homeMusicBean == null || homeMusicBean.getType() != 9) {
            return;
        }
        MusicControl.h0().e.i = DaoUtils.getMusicSpotifyDao().findAllMusic();
        this.l.w(MusicControl.h0().e.i);
        j0(MusicControl.h0().e.i.size(), false);
    }

    public void i0(int i) {
        this.p = i;
    }

    public void j0(int i, boolean z) {
        if (i < 1) {
            this.recyclerView.setVisibility(8);
            this.spotify_music_layout.setVisibility(8);
            this.music_list_empty.setVisibility(8);
            if (!k12.n) {
                sg3.i(getActivity(), R.string.pattern_music_empty);
            }
        } else {
            this.spotify_music_layout.setVisibility(8);
            this.music_list_empty.setVisibility(8);
            this.recyclerView.setVisibility(0);
        }
        this.recyclerView.setLoadMoreEnable(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.ll_login_spotify) {
            return;
        }
        pj3.o(getActivity(), StreamMusicLoginActivity.class, 33);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.n = (NewMusicActivity) getActivity();
        M((MyApplication) getActivity().getApplication());
        EventBus.getDefault().register(this);
        View viewInflate = layoutInflater.inflate(R.layout.fragment_music_spotify, (ViewGroup) null);
        this.k = ButterKnife.bind(this, viewInflate);
        this.ll_login_spotify.setOnClickListener(this);
        this.recyclerView.getSwipeRefreshLayout().setColorSchemeColors(getResources().getColor(R.color.pink));
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(getActivity());
        recyclerViewNoBugLinearLayoutManager.setOrientation(1);
        this.recyclerView.getRecyclerView().setLayoutManager(recyclerViewNoBugLinearLayoutManager);
        this.recyclerView.setLoadMoreEnable(true);
        MusicNewAdapter musicNewAdapter = new MusicNewAdapter(this.n, true);
        this.l = musicNewAdapter;
        this.recyclerView.u(musicNewAdapter);
        this.recyclerView.setAdapterSimple(this.l);
        this.recyclerView.setOnLoadListener(new a());
        PlayListGroupAdapter playListGroupAdapter = new PlayListGroupAdapter(getActivity(), k12.m, 0);
        this.m = playListGroupAdapter;
        this.recyclerView.u(playListGroupAdapter);
        this.l.w(null);
        this.m.x(null);
        e0();
        if (MainActivity.d0) {
            this.recyclerView.setVisibility(0);
            this.music_list_empty.setVisibility(8);
            this.spotifyPremiumSupported.setVisibility(8);
            this.spotify_music_layout.setVisibility(8);
            h0(this.p);
            if (MusicControl.h0().e.i.size() == 0 && MusicControl.h0().e.j.size() == 0 && MusicControl.h0().e.k.size() == 0) {
                MusicControl.h0().w(true, false, false);
            }
        } else {
            this.recyclerView.setVisibility(8);
            this.music_list_empty.setVisibility(8);
            this.spotifyPremiumSupported.setVisibility(8);
            this.spotify_music_layout.setVisibility(0);
            if (MusicControl.h0().e.O()) {
                MusicControl.h0().e.u();
            }
        }
        a0();
        return viewInflate;
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
