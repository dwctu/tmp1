package com.wear.main.closeRange.spotifyMusic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.streammusic.StreamMusicSearchAdapter;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.SearchSpotifyAbstract;
import com.wear.bean.SearchSpotifyAlbums;
import com.wear.bean.SearchSpotifyArtists;
import com.wear.bean.SearchSpotifyPlaylists;
import com.wear.bean.SearchSpotifyTracks;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.localMusic.PlaylistDetailsActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import com.wear.widget.BaseImageButton;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.recycler.AutoRVAdapter;
import com.wear.widget.recycler.RVHolder;
import com.wear.widget.recycler.SwipeRecyclerView;
import com.wear.widget.recycler.footerView.SimpleFooterView;
import dc.ah4;
import dc.ho1;
import dc.k12;
import dc.na2;
import dc.nf3;
import dc.nv1;
import dc.pj3;
import dc.se3;
import dc.sg3;
import dc.ue3;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class SearchStreamMusicActivity extends BaseActivity implements View.OnClickListener {
    public StreamMusicSearchAdapter a;

    @BindView(R.id.all_order)
    public LinearLayout allOrder;

    @BindView(R.id.bib_icon_music_panel_record)
    public BaseImageButton bibIconMusicPanelRecord;
    public SearchSpotifyAbstract c;

    @BindView(R.id.clear_histroy_lv)
    public TextView clear_histroy_lv;

    @BindView(R.id.dot_albums)
    public View dot_albums;

    @BindView(R.id.dot_artists)
    public View dot_artists;

    @BindView(R.id.dot_playlist)
    public View dot_playlist;

    @BindView(R.id.dot_songs)
    public View dot_songs;
    public ho1 h;

    @BindView(R.id.ll_result)
    public LinearLayout ll_result;

    @BindView(R.id.music_list_empty)
    public LinearLayout musicListEmpty;

    @BindView(R.id.music_list_layout)
    public LinearLayout musicListLayout;

    @BindView(R.id.music_play_layer_placeholder)
    public View musicPlayLayerPlaceholder;

    @BindView(R.id.music_search_albums)
    public MediumBoldRadioButton musicSearchAlbums;

    @BindView(R.id.music_search_artists)
    public MediumBoldRadioButton musicSearchArtists;

    @BindView(R.id.music_search_playlists)
    public MediumBoldRadioButton musicSearchPlaylists;

    @BindView(R.id.music_search_tracks)
    public MediumBoldRadioButton musicSearchTracks;

    @BindView(R.id.swipeRecyclerView)
    public SwipeRecyclerView recyclerView;

    @BindView(R.id.rl_icon_music_panel_record)
    public RelativeLayout rlIconMusicPanelRecord;

    @BindView(R.id.search_clean_bnt)
    public ImageView search_clean_bnt;

    @BindView(R.id.search_edit_text)
    public EditText search_edit_text;

    @BindView(R.id.search_histroy_layout)
    public LinearLayout search_histroy_layout;

    @BindView(R.id.search_histroy_lv)
    public ListView search_histroy_lv;

    @BindView(R.id.tv_cancel)
    public TextView tv_cancel;
    public int b = -1;
    public SearchSpotifyAbstract d = new SearchSpotifyTracks();
    public SearchSpotifyAbstract e = new SearchSpotifyArtists();
    public SearchSpotifyAbstract f = new SearchSpotifyAlbums();
    public SearchSpotifyAbstract g = new SearchSpotifyPlaylists();
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public MusicControl.f l = new i();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchStreamMusicActivity.this.rlIconMusicPanelRecord.setEnabled(true);
            SearchStreamMusicActivity.this.bibIconMusicPanelRecord.setEnabled(true);
            if (MusicControl.h0().f == null) {
                return;
            }
            pj3.f(SearchStreamMusicActivity.this, MusicRecordActivity.class);
        }
    }

    public class b implements View.OnKeyListener {
        public b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 1 || !SearchStreamMusicActivity.this.C4()) {
                return false;
            }
            SearchStreamMusicActivity.this.h.a(SearchStreamMusicActivity.this.search_edit_text.getText().toString());
            SearchStreamMusicActivity.this.search_histroy_layout.setVisibility(8);
            SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
            searchStreamMusicActivity.D4(true, searchStreamMusicActivity.search_edit_text.getText().toString());
            return false;
        }
    }

    public class c extends nv1 {
        public c() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SearchStreamMusicActivity.this.search_clean_bnt.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchStreamMusicActivity.this.h.b();
        }
    }

    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
            searchStreamMusicActivity.search_edit_text.setText(searchStreamMusicActivity.h.getItem(i).a());
            SearchStreamMusicActivity searchStreamMusicActivity2 = SearchStreamMusicActivity.this;
            searchStreamMusicActivity2.search_edit_text.setSelection(searchStreamMusicActivity2.h.getItem(i).a().length());
            SearchStreamMusicActivity.this.search_histroy_layout.setVisibility(8);
            SearchStreamMusicActivity searchStreamMusicActivity3 = SearchStreamMusicActivity.this;
            searchStreamMusicActivity3.D4(true, searchStreamMusicActivity3.search_edit_text.getText().toString());
        }
    }

    public class f implements SwipeRecyclerView.d {
        public f() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void a() {
            SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
            searchStreamMusicActivity.D4(false, searchStreamMusicActivity.search_edit_text.getText().toString());
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void onRefresh() {
            SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
            searchStreamMusicActivity.D4(true, searchStreamMusicActivity.search_edit_text.getText().toString());
        }
    }

    public class g implements AutoRVAdapter.c {

        public class a implements nf3.d {
            public final /* synthetic */ MusicPlaylist a;

            /* renamed from: com.wear.main.closeRange.spotifyMusic.SearchStreamMusicActivity$g$a$a, reason: collision with other inner class name */
            public class RunnableC0098a implements Runnable {
                public final /* synthetic */ String a;

                public RunnableC0098a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    MusicControl.h0().e();
                    if (WearUtils.e1(this.a) || !this.a.equals("true")) {
                        return;
                    }
                    a aVar = a.this;
                    SearchStreamMusicActivity.this.E4(aVar.a);
                }
            }

            public a(MusicPlaylist musicPlaylist) {
                this.a = musicPlaylist;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) {
                SearchStreamMusicActivity.this.runOnUiThread(new RunnableC0098a(str));
            }
        }

        public g() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.c
        public void a(int i, RVHolder rVHolder) throws IllegalStateException {
            if (SearchStreamMusicActivity.this.c.isGroupItem()) {
                MusicPlaylist musicPlaylist = SearchStreamMusicActivity.this.c.getMusicPlaylist(i);
                MusicControl.h0().H();
                MusicControl.h0().u(SearchStreamMusicActivity.this.c, musicPlaylist, musicPlaylist.getTracksUrl(), new a(musicPlaylist));
                return;
            }
            Music musicV = SearchStreamMusicActivity.this.a.v(i);
            ArrayList arrayList = new ArrayList();
            arrayList.add(musicV);
            MusicControl.h0().F(null, arrayList);
            MusicControl.h0().s0(0);
            MusicControl.h0().f = musicV;
            if (SearchStreamMusicActivity.this.i != -1) {
                SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
                searchStreamMusicActivity.a.notifyItemChanged(searchStreamMusicActivity.i);
            }
            SearchStreamMusicActivity searchStreamMusicActivity2 = SearchStreamMusicActivity.this;
            searchStreamMusicActivity2.j = Integer.valueOf(searchStreamMusicActivity2.i).intValue();
            SearchStreamMusicActivity.this.k = i;
            SearchStreamMusicActivity.this.a.notifyItemChanged(i);
            SearchStreamMusicActivity.this.i = i;
        }
    }

    public class h implements nf3.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                MusicControl.h0().e();
                SearchSpotifyAbstract searchSpotifyAbstract = null;
                try {
                    switch (SearchStreamMusicActivity.this.b) {
                        case R.id.music_search_albums /* 2131363858 */:
                            searchSpotifyAbstract = (SearchSpotifyAbstract) new Gson().fromJson(this.a, SearchSpotifyAlbums.class);
                            break;
                        case R.id.music_search_artists /* 2131363859 */:
                            searchSpotifyAbstract = (SearchSpotifyAbstract) new Gson().fromJson(this.a, SearchSpotifyArtists.class);
                            break;
                        case R.id.music_search_playlists /* 2131363860 */:
                            searchSpotifyAbstract = (SearchSpotifyAbstract) new Gson().fromJson(this.a, SearchSpotifyPlaylists.class);
                            break;
                        case R.id.music_search_tracks /* 2131363861 */:
                            searchSpotifyAbstract = (SearchSpotifyAbstract) new Gson().fromJson(this.a, SearchSpotifyTracks.class);
                            break;
                    }
                    if (searchSpotifyAbstract != null) {
                        h hVar = h.this;
                        SearchStreamMusicActivity.this.c.appendItems(!hVar.a, searchSpotifyAbstract);
                        SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
                        searchStreamMusicActivity.a.s(searchStreamMusicActivity.b == R.id.music_search_tracks ? h.this.b : "");
                        SearchStreamMusicActivity searchStreamMusicActivity2 = SearchStreamMusicActivity.this;
                        searchStreamMusicActivity2.a.x(searchStreamMusicActivity2.c);
                        SearchStreamMusicActivity.this.a.notifyDataSetChanged();
                    } else {
                        sg3.i(SearchStreamMusicActivity.this, R.string.common_serverError);
                    }
                } catch (Exception unused) {
                    sg3.i(SearchStreamMusicActivity.this, R.string.common_serverError);
                }
                SearchStreamMusicActivity searchStreamMusicActivity3 = SearchStreamMusicActivity.this;
                SwipeRecyclerView swipeRecyclerView = searchStreamMusicActivity3.recyclerView;
                if (swipeRecyclerView == null) {
                    searchStreamMusicActivity3.finish();
                    return;
                }
                swipeRecyclerView.w();
                SearchStreamMusicActivity.this.recyclerView.p();
                if (WearUtils.e1(SearchStreamMusicActivity.this.c.nextUrl())) {
                    SearchStreamMusicActivity.this.recyclerView.setLoadMoreEnable(false);
                } else {
                    SearchStreamMusicActivity.this.recyclerView.setLoadMoreEnable(true);
                }
                SearchStreamMusicActivity.this.recyclerView.setRefreshing(false);
                SearchStreamMusicActivity.this.ll_result.setVisibility(0);
                if (SearchStreamMusicActivity.this.c.getList() == null || SearchStreamMusicActivity.this.c.getList().size() <= 0) {
                    SearchStreamMusicActivity.this.musicListEmpty.setVisibility(0);
                    SearchStreamMusicActivity.this.recyclerView.setVisibility(8);
                } else {
                    SearchStreamMusicActivity.this.musicListEmpty.setVisibility(8);
                    SearchStreamMusicActivity.this.recyclerView.setVisibility(0);
                }
            }
        }

        public h(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // dc.nf3.d
        public void onRequestComplete(String str) {
            SearchStreamMusicActivity.this.runOnUiThread(new a(str));
        }
    }

    public class i implements MusicControl.f {
        public i() {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void a(int i) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void b(boolean z) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void c(int i) {
            SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
            if (searchStreamMusicActivity.a != null) {
                if (searchStreamMusicActivity.j >= 0) {
                    SearchStreamMusicActivity searchStreamMusicActivity2 = SearchStreamMusicActivity.this;
                    searchStreamMusicActivity2.a.notifyItemChanged(searchStreamMusicActivity2.j);
                }
                if (SearchStreamMusicActivity.this.k >= 0) {
                    SearchStreamMusicActivity searchStreamMusicActivity3 = SearchStreamMusicActivity.this;
                    searchStreamMusicActivity3.a.notifyItemChanged(searchStreamMusicActivity3.k);
                }
            }
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void d(int i) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void e(boolean z) {
            if (k12.m != null) {
                MusicControl.h0().A0(z);
            }
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void f(int i, int i2, boolean z) {
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchStreamMusicActivity searchStreamMusicActivity = SearchStreamMusicActivity.this;
            ue3.a(searchStreamMusicActivity.search_edit_text, searchStreamMusicActivity);
        }
    }

    public final boolean C4() {
        if (!WearUtils.e1(this.search_edit_text.getText().toString())) {
            return true;
        }
        sg3.l(ah4.e(R.string.music_search_value_null));
        return false;
    }

    public void D4(boolean z, String str) {
        this.i = -1;
        if (C4()) {
            ue3.a(this.search_edit_text, this);
            MusicControl.h0().H();
            F4();
            String strSearchType = this.c.searchType();
            if (WearUtils.e1(str) || WearUtils.e1(strSearchType)) {
                return;
            }
            MusicControl.h0().E(z ? null : this.c.nextUrl(), str, strSearchType, new h(z, str));
        }
    }

    public final void E4(MusicPlaylist musicPlaylist) {
        if (musicPlaylist.getItemsList().size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putString(MessageBundle.TITLE_ENTRY, this.c.searchType());
            bundle.putSerializable("playListItem", musicPlaylist);
            pj3.g(this, PlaylistDetailsActivity.class, bundle);
        }
    }

    public final void F4() {
        this.dot_songs.setVisibility(this.b == R.id.music_search_tracks ? 0 : 8);
        this.dot_artists.setVisibility(this.b == R.id.music_search_artists ? 0 : 8);
        this.dot_albums.setVisibility(this.b == R.id.music_search_albums ? 0 : 8);
        this.dot_playlist.setVisibility(this.b == R.id.music_search_playlists ? 0 : 8);
        this.musicSearchTracks.setChecked(this.b == R.id.music_search_tracks);
        this.musicSearchArtists.setChecked(this.b == R.id.music_search_artists);
        this.musicSearchAlbums.setChecked(this.b == R.id.music_search_albums);
        this.musicSearchPlaylists.setChecked(this.b == R.id.music_search_playlists);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        MusicPlaylist musicPlaylist;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 24 || intent == null || (musicPlaylist = (MusicPlaylist) intent.getSerializableExtra("new_playlist_item")) == null) {
            return;
        }
        MusicControl.h0().d.g.add(1, musicPlaylist);
        EventBus.getDefault().post(musicPlaylist);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b == view.getId()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.search_clean_bnt) {
            this.search_edit_text.setText("");
            this.search_histroy_layout.setVisibility(0);
            this.ll_result.setVisibility(8);
            return;
        }
        if (id == R.id.tv_cancel) {
            finish();
            return;
        }
        switch (id) {
            case R.id.music_search_albums /* 2131363858 */:
                this.b = R.id.music_search_albums;
                this.c = this.f;
                break;
            case R.id.music_search_artists /* 2131363859 */:
                this.b = R.id.music_search_artists;
                this.c = this.e;
                break;
            case R.id.music_search_playlists /* 2131363860 */:
                this.b = R.id.music_search_playlists;
                this.c = this.g;
                break;
            case R.id.music_search_tracks /* 2131363861 */:
                this.b = R.id.music_search_tracks;
                this.c = this.d;
                break;
        }
        if (WearUtils.e1(this.c.nextUrl())) {
            this.recyclerView.setLoadMoreEnable(false);
        } else {
            this.recyclerView.setLoadMoreEnable(true);
        }
        D4(true, this.search_edit_text.getText().toString());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_search);
        ButterKnife.bind(this);
        this.search_clean_bnt.setOnClickListener(this);
        this.tv_cancel.setOnClickListener(this);
        this.search_edit_text.setOnKeyListener(new b());
        this.search_edit_text.addTextChangedListener(new c());
        this.h = new ho1(this);
        this.clear_histroy_lv.setOnClickListener(new d());
        this.search_histroy_lv.setAdapter((ListAdapter) this.h);
        this.search_histroy_lv.setOnItemClickListener(new e());
        k12.m = k12.m;
        this.musicSearchTracks.setOnClickListener(this);
        this.musicSearchArtists.setOnClickListener(this);
        this.musicSearchAlbums.setOnClickListener(this);
        this.musicSearchPlaylists.setOnClickListener(this);
        this.b = R.id.music_search_tracks;
        this.c = this.d;
        this.recyclerView.getSwipeRefreshLayout().setColorSchemeColors(getResources().getColor(R.color.pink));
        this.recyclerView.getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setFooterView(new SimpleFooterView(this));
        this.recyclerView.setLoadMoreEnable(false);
        StreamMusicSearchAdapter streamMusicSearchAdapter = new StreamMusicSearchAdapter(this, k12.m, this.c);
        this.a = streamMusicSearchAdapter;
        this.recyclerView.u(streamMusicSearchAdapter);
        this.recyclerView.setAdapterSimple(this.a);
        this.recyclerView.setOnLoadListener(new f());
        this.a.t(new g());
        k12.m.d(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.l);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        k12.m.j(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.l);
        new Handler().postDelayed(new j(), 100L);
    }

    @OnClick({R.id.bib_icon_music_panel_record, R.id.rl_icon_music_panel_record})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.bib_icon_music_panel_record || id == R.id.rl_icon_music_panel_record) {
            if (!se3.c(this) && MusicControl.h0().f.getMusicType() == 1) {
                sg3.e(this, R.string.music_record_net_connect_error_tip);
                return;
            }
            if (na2.m().i()) {
                na2.m().t();
                return;
            }
            this.rlIconMusicPanelRecord.setEnabled(false);
            this.bibIconMusicPanelRecord.setEnabled(false);
            MusicControl.h0().B0();
            new Handler().postDelayed(new a(), MusicControl.h0().f.getMusicType() == 1 ? 500L : 0L);
        }
    }
}
