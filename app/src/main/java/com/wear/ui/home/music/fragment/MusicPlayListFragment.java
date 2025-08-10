package com.wear.ui.home.music.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.adapter.localmusic.PlayListGroupNewAdapter;
import com.wear.bean.MusicPlaylist;
import com.wear.main.BaseFragment;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import com.wear.widget.recycler.AutoRVAdapter;
import com.wear.widget.recycler.RVHolder;
import com.wear.widget.recycler.SwipeRecyclerView;
import dc.ah4;
import dc.k12;
import dc.kn3;
import dc.na2;
import dc.nf3;
import dc.sg3;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class MusicPlayListFragment extends BaseFragment {
    public Unbinder k;
    public PlayListGroupNewAdapter l;
    public NewMusicActivity m;

    @BindView(R.id.ll_music_local)
    public LinearLayout mLlMusicLocal;

    @BindView(R.id.music_list_empty)
    public NestedScrollView musicListEmpty;
    public AutoRVAdapter.c n = new c();
    public AutoRVAdapter.d o = new d();

    @BindView(R.id.swipeRecyclerView)
    public SwipeRecyclerView recyclerView;

    public class a implements nf3.d {

        /* renamed from: com.wear.ui.home.music.fragment.MusicPlayListFragment$a$a, reason: collision with other inner class name */
        public class RunnableC0147a implements Runnable {
            public RunnableC0147a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MusicPlayListFragment.this.X();
            }
        }

        public a() {
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            ((NewMusicActivity) MusicPlayListFragment.this.getActivity()).runOnMainThread(new RunnableC0147a());
        }
    }

    public class b implements SwipeRecyclerView.d {
        public b() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void a() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void onRefresh() {
            if (MusicControl.h0().e.t()) {
                MusicControl.h0().r(null, null, true);
            } else {
                MusicPlayListFragment.this.X();
            }
        }
    }

    public class c implements AutoRVAdapter.c {

        public class a implements nf3.d {
            public final /* synthetic */ MusicPlaylist a;

            public a(MusicPlaylist musicPlaylist) {
                this.a = musicPlaylist;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) {
                if (MusicPlayListFragment.this.m != null) {
                    MusicPlayListFragment.this.m.J4(this.a);
                }
            }
        }

        public c() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.c
        public void a(int i, RVHolder rVHolder) {
            if (na2.m().i()) {
                na2.m().t();
                return;
            }
            MusicPlaylist musicPlaylistV = MusicPlayListFragment.this.l.v(i);
            if (musicPlaylistV != null) {
                if (!WearUtils.e1(musicPlaylistV.getTracksUrl())) {
                    MusicControl.h0().m(musicPlaylistV, musicPlaylistV.getTracksUrl(), new a(musicPlaylistV));
                } else if (MusicPlayListFragment.this.m != null) {
                    MusicPlayListFragment.this.m.J4(musicPlaylistV);
                }
            }
        }
    }

    public class d implements AutoRVAdapter.d {

        public class a implements kn3.d {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                MusicPlayListFragment.this.l.w(this.a);
            }
        }

        public d() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.d
        public void a(int i, RVHolder rVHolder) {
            MusicPlaylist musicPlaylistV = MusicPlayListFragment.this.l.v(i);
            if (i == 0 && musicPlaylistV.getName().equals(ah4.e(R.string.music_my_favorite))) {
                return;
            }
            if (!WearUtils.e1(musicPlaylistV.getTracksUrl())) {
                sg3.i(MusicPlayListFragment.this.getActivity(), R.string.remove_music_item_not_local);
                return;
            }
            kn3 kn3Var = new kn3((Context) MusicPlayListFragment.this.getActivity(), String.format(ah4.e(R.string.delete_music_playlist), MusicPlayListFragment.this.l.v(i).getName()), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new a(i));
            kn3Var.show();
            kn3Var.r();
        }
    }

    public void X() {
        this.l.x(MusicControl.h0().z());
        this.recyclerView.s();
        this.recyclerView.p();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.m = (NewMusicActivity) getActivity();
        M((MyApplication) getActivity().getApplication());
        View viewInflate = layoutInflater.inflate(R.layout.fragment_music_play_list, (ViewGroup) null);
        this.k = ButterKnife.bind(this, viewInflate);
        this.recyclerView.getSwipeRefreshLayout().setColorSchemeColors(getResources().getColor(R.color.pink));
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(getActivity());
        recyclerViewNoBugLinearLayoutManager.setOrientation(1);
        this.recyclerView.getRecyclerView().setLayoutManager(recyclerViewNoBugLinearLayoutManager);
        this.recyclerView.setLoadMoreEnable(false);
        PlayListGroupNewAdapter playListGroupNewAdapter = new PlayListGroupNewAdapter(this.m, k12.m, 0);
        this.l = playListGroupNewAdapter;
        this.recyclerView.u(playListGroupNewAdapter);
        this.recyclerView.setAdapterSimple(this.l);
        this.l.t(this.n);
        this.l.u(this.o);
        X();
        if (MusicControl.h0().e.t()) {
            MusicControl.h0().r(null, new a(), true);
        }
        this.recyclerView.setOnLoadListener(new b());
        this.musicListEmpty.setVisibility(8);
        this.mLlMusicLocal.setVisibility(0);
        if (MusicControl.h0().d != null) {
            MusicControl.h0().d.f();
            X();
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        HashMap<String, String> map = new HashMap<>();
        PlayListGroupNewAdapter playListGroupNewAdapter = this.l;
        if (playListGroupNewAdapter != null && playListGroupNewAdapter.a != null) {
            map.put("count", "" + this.l.a.size());
        }
        t("music_playlist", map);
    }
}
