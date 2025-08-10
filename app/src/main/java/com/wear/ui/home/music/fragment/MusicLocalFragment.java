package com.wear.ui.home.music.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.adapter.localmusic.MusicNewAdapter;
import com.wear.adapter.localmusic.PlayListGroupAdapter;
import com.wear.main.BaseFragment;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.ui.home.music.NewMusicActivity;
import com.wear.util.MyApplication;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;
import com.wear.widget.recycler.AutoRVAdapter;
import com.wear.widget.recycler.RVHolder;
import com.wear.widget.recycler.SwipeRecyclerView;
import dc.eg3;
import dc.f12;
import dc.k12;
import dc.q61;
import dc.u51;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes3.dex */
public class MusicLocalFragment extends BaseFragment {
    public MusicNewAdapter k;
    public PlayListGroupAdapter l;
    public Unbinder m;

    @BindView(R.id.iv_has_permission1)
    public ImageView mIvHasPermission1;

    @BindView(R.id.iv_has_permission2)
    public ImageView mIvHasPermission2;

    @BindView(R.id.ll_music_local)
    public LinearLayout mLlMusicLocal;

    @BindView(R.id.ll_start_page)
    public LinearLayout mLlStartPage;

    @BindView(R.id.tv_set_up_now)
    public TextView mTvSetUpNow;

    @BindView(R.id.music_list_empty)
    public NestedScrollView music_list_empty;
    public NewMusicActivity n;

    @BindView(R.id.nestedscrollview)
    public NestedScrollView nestedscrollview;
    public int q;

    @BindView(R.id.swipeRecyclerView)
    public SwipeRecyclerView recyclerView;
    public boolean o = true;
    public Handler p = new Handler();
    public boolean r = true;
    public AutoRVAdapter.c s = new a();

    public class a implements AutoRVAdapter.c {
        public a() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.c
        public void a(int i, RVHolder rVHolder) throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (MusicLocalFragment.this.q != R.id.music_song_list) {
                if (MusicLocalFragment.this.q == R.id.music_artist_list || MusicLocalFragment.this.q == R.id.music_album_list) {
                    MusicLocalFragment.this.n.J4(MusicLocalFragment.this.l.v(i));
                    return;
                }
                return;
            }
            eg3.j(MusicLocalFragment.this.requireContext(), "isNeedHighlight", true);
            MusicLocalFragment.this.r = true;
            MusicLocalFragment.this.k.x(true);
            MusicControl.h0().F(null, MusicControl.h0().d.h);
            MusicControl.h0().s0(i);
            MusicLocalFragment.this.n.findViewById(R.id.music_control_bar).setVisibility(0);
        }
    }

    public class b implements SwipeRecyclerView.d {

        public class a implements f12.d {

            /* renamed from: com.wear.ui.home.music.fragment.MusicLocalFragment$b$a$a, reason: collision with other inner class name */
            public class RunnableC0146a implements Runnable {
                public RunnableC0146a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    MusicNewAdapter musicNewAdapter = MusicLocalFragment.this.k;
                    if (musicNewAdapter != null) {
                        musicNewAdapter.notifyDataSetChanged();
                    }
                    SwipeRecyclerView swipeRecyclerView = MusicLocalFragment.this.recyclerView;
                    if (swipeRecyclerView != null) {
                        swipeRecyclerView.p();
                    }
                }
            }

            public a() {
            }

            @Override // dc.f12.d
            public void a() {
                MusicLocalFragment.this.p.post(new RunnableC0146a());
            }
        }

        public b() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void a() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void onRefresh() {
            MusicControl.h0().D(new a());
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String[] strArr = {"android.permission.READ_MEDIA_AUDIO", "android.permission.RECORD_AUDIO"};
            if (q61.f(MusicLocalFragment.this.getContext(), strArr)) {
                return;
            }
            MusicLocalFragment.this.l0(strArr);
        }
    }

    public class d implements u51 {
        public d() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            if (z && MusicLocalFragment.this.o) {
                MusicLocalFragment.this.g0();
            }
            MusicLocalFragment.this.o = z;
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            MusicLocalFragment.this.h0();
        }
    }

    public class e implements f12.d {
        public e(MusicLocalFragment musicLocalFragment) {
        }

        @Override // dc.f12.d
        public void a() {
        }
    }

    public final void g0() {
        if (this.n == null) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.n.getPackageName(), null));
        startActivity(intent);
    }

    public void h0() {
        String[] strArr = {"android.permission.READ_MEDIA_AUDIO", "android.permission.RECORD_AUDIO"};
        if (q61.f(getContext(), strArr)) {
            this.mLlStartPage.setVisibility(8);
            this.nestedscrollview.setVisibility(8);
            this.mLlMusicLocal.setVisibility(0);
            p0(MusicControl.h0().d.h.size());
            m0();
            return;
        }
        this.mLlStartPage.setVisibility(0);
        this.nestedscrollview.setVisibility(0);
        this.mLlMusicLocal.setVisibility(8);
        this.mIvHasPermission1.setVisibility(q61.f(getContext(), strArr[0]) ? 0 : 8);
        this.mIvHasPermission2.setVisibility(q61.f(getContext(), strArr[1]) ? 0 : 8);
    }

    public void i0() {
        MusicNewAdapter musicNewAdapter = this.k;
        if (musicNewAdapter != null) {
            musicNewAdapter.notifyDataSetChanged();
        }
    }

    public void j0(int i) {
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

    public void k0(int i) {
        AutoRVAdapter autoRVAdapter;
        this.q = i;
        if (i == R.id.music_artist_list) {
            this.l.x(MusicControl.h0().d.e);
            autoRVAdapter = this.l;
        } else if (i == R.id.music_album_list) {
            this.l.x(MusicControl.h0().d.f);
            autoRVAdapter = this.l;
        } else {
            for (int i2 = 0; i2 < MusicControl.h0().d.h.size(); i2++) {
                MusicControl.h0().d.h.get(i2).setFuncType(2);
            }
            this.k.w(MusicControl.h0().d.h);
            autoRVAdapter = this.k;
        }
        autoRVAdapter.u(null);
        autoRVAdapter.t(this.s);
        this.recyclerView.setAdapterSimple(autoRVAdapter);
        this.recyclerView.s();
        this.recyclerView.p();
    }

    public final void l0(String... strArr) {
        q61 q61VarN = q61.n(this);
        q61VarN.h(strArr);
        q61VarN.j(new d());
    }

    public void m0() {
        MusicControl.h0().d.a();
        MusicControl.h0().e.a();
        MusicControl.h0().D(new e(this));
        if (MusicControl.h0().f == null) {
            MusicControl.h0().F(null, MusicControl.h0().d.h);
        }
    }

    public void n0(int i) {
        this.q = i;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.n = (NewMusicActivity) getActivity();
        M((MyApplication) getActivity().getApplication());
        View viewInflate = layoutInflater.inflate(R.layout.fragment_music_local, (ViewGroup) null);
        this.m = ButterKnife.bind(this, viewInflate);
        this.r = eg3.d(requireContext(), "isNeedHighlight", false);
        this.recyclerView.getSwipeRefreshLayout().setColorSchemeColors(getResources().getColor(R.color.pink));
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(getActivity());
        recyclerViewNoBugLinearLayoutManager.setOrientation(1);
        this.recyclerView.getRecyclerView().setLayoutManager(recyclerViewNoBugLinearLayoutManager);
        this.recyclerView.setLoadMoreEnable(false);
        MusicNewAdapter musicNewAdapter = new MusicNewAdapter(this.n, this.r);
        this.k = musicNewAdapter;
        this.recyclerView.u(musicNewAdapter);
        this.recyclerView.setAdapterSimple(this.k);
        this.recyclerView.setOnLoadListener(new b());
        PlayListGroupAdapter playListGroupAdapter = new PlayListGroupAdapter(getActivity(), k12.m, 0);
        this.l = playListGroupAdapter;
        this.recyclerView.u(playListGroupAdapter);
        if (this.q <= 0) {
            k0(R.id.music_song_list);
        }
        this.mTvSetUpNow.setOnClickListener(new c());
        h0();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        h0();
    }

    public void p0(int i) {
        SwipeRecyclerView swipeRecyclerView = this.recyclerView;
        if (swipeRecyclerView != null) {
            if (i < 1) {
                swipeRecyclerView.setVisibility(8);
            } else {
                swipeRecyclerView.setVisibility(0);
            }
        }
    }
}
