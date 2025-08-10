package com.wear.main.closeRange.localMusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.localmusic.LocalMusicSearchAdapter;
import com.wear.adapter.localmusic.PlayListGroupAdapter;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.event.MusicNotificationEvent;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.recycler.AutoRVAdapter;
import com.wear.widget.recycler.RVHolder;
import com.wear.widget.recycler.SwipeRecyclerView;
import com.wear.widget.recycler.footerView.SimpleFooterView;
import dc.ah4;
import dc.f12;
import dc.ho1;
import dc.k12;
import dc.kn3;
import dc.na2;
import dc.nf3;
import dc.nv1;
import dc.pj3;
import dc.se3;
import dc.sg3;
import dc.ue3;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class SearchLocalMusicActivity extends BaseActivity implements View.OnClickListener {
    public LocalMusicSearchAdapter a;

    @BindView(R.id.all_order)
    public LinearLayout allOrder;
    public PlayListGroupAdapter b;

    @BindView(R.id.bib_icon_music_panel_record)
    public View bibIconMusicPanelRecord;

    @BindView(R.id.clear_histroy_lv)
    public TextView clear_histroy_lv;
    public ho1 d;

    @BindView(R.id.dot_albums)
    public View dot_albums;

    @BindView(R.id.dot_artists)
    public View dot_artists;

    @BindView(R.id.dot_playlist)
    public View dot_playlist;

    @BindView(R.id.dot_songs)
    public View dot_songs;
    public Unbinder h;

    @BindView(R.id.ll_result)
    public LinearLayout ll_result;

    @BindView(R.id.fl_sound_record)
    public FrameLayout mFlSoundRecord;

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
    public int c = -1;
    public int e = -1;
    public int f = -1;
    public MusicControl.f g = new i();
    public long i = 0;
    public AutoRVAdapter.c j = new a();
    public AutoRVAdapter.d k = new b();

    public class a implements AutoRVAdapter.c {

        /* renamed from: com.wear.main.closeRange.localMusic.SearchLocalMusicActivity$a$a, reason: collision with other inner class name */
        public class C0097a implements nf3.d {
            public final /* synthetic */ MusicPlaylist a;

            public C0097a(MusicPlaylist musicPlaylist) {
                this.a = musicPlaylist;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) {
                SearchLocalMusicActivity.this.C4(this.a);
            }
        }

        public a() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.c
        public void a(int i, RVHolder rVHolder) throws IllegalStateException {
            MusicPlaylist musicPlaylistV;
            if (SearchLocalMusicActivity.this.c != R.id.music_search_tracks) {
                if (SearchLocalMusicActivity.this.c == R.id.music_search_artists || SearchLocalMusicActivity.this.c == R.id.music_search_albums) {
                    SearchLocalMusicActivity searchLocalMusicActivity = SearchLocalMusicActivity.this;
                    searchLocalMusicActivity.C4(searchLocalMusicActivity.b.v(i));
                    return;
                } else {
                    if (SearchLocalMusicActivity.this.c != R.id.music_search_playlists || (musicPlaylistV = SearchLocalMusicActivity.this.b.v(i)) == null) {
                        return;
                    }
                    if (WearUtils.e1(musicPlaylistV.getTracksUrl())) {
                        SearchLocalMusicActivity.this.C4(musicPlaylistV);
                        return;
                    } else {
                        MusicControl.h0().m(musicPlaylistV, musicPlaylistV.getTracksUrl(), new C0097a(musicPlaylistV));
                        return;
                    }
                }
            }
            MusicControl.h0().F(null, MusicControl.h0().d.h);
            Music music = (Music) SearchLocalMusicActivity.this.a.getItem(i);
            if (music != null) {
                int i2 = 0;
                Iterator<Music> it = MusicControl.h0().d.h.iterator();
                while (it.hasNext() && it.next().getSongId() != music.getSongId()) {
                    i2++;
                }
                SearchLocalMusicActivity searchLocalMusicActivity2 = SearchLocalMusicActivity.this;
                searchLocalMusicActivity2.e = searchLocalMusicActivity2.f;
                SearchLocalMusicActivity.this.f = i;
                MusicControl.h0().s0(i2);
                SearchLocalMusicActivity.this.B4();
            }
        }
    }

    public class b implements AutoRVAdapter.d {

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
                SearchLocalMusicActivity.this.b.w(this.a);
            }
        }

        public b() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.d
        public void a(int i, RVHolder rVHolder) {
            if (!WearUtils.e1(SearchLocalMusicActivity.this.b.v(i).getTracksUrl())) {
                sg3.i(SearchLocalMusicActivity.this, R.string.remove_music_item_not_local);
                return;
            }
            kn3 kn3Var = new kn3((Context) SearchLocalMusicActivity.this, String.format(ah4.e(R.string.delete_music_playlist), SearchLocalMusicActivity.this.b.v(i).getName()), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new a(i));
            kn3Var.show();
            kn3Var.r();
        }
    }

    public class c implements View.OnKeyListener {
        public c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 1 || !SearchLocalMusicActivity.this.A4()) {
                return false;
            }
            SearchLocalMusicActivity.this.d.a(SearchLocalMusicActivity.this.search_edit_text.getText().toString());
            SearchLocalMusicActivity.this.search_histroy_layout.setVisibility(8);
            SearchLocalMusicActivity.this.B4();
            return false;
        }
    }

    public class d extends nv1 {
        public d() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SearchLocalMusicActivity.this.search_clean_bnt.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        }
    }

    public class e implements AdapterView.OnItemClickListener {
        public e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchLocalMusicActivity searchLocalMusicActivity = SearchLocalMusicActivity.this;
            searchLocalMusicActivity.search_edit_text.setText(searchLocalMusicActivity.d.getItem(i).a());
            SearchLocalMusicActivity searchLocalMusicActivity2 = SearchLocalMusicActivity.this;
            searchLocalMusicActivity2.search_edit_text.setSelection(searchLocalMusicActivity2.d.getItem(i).a().length());
            SearchLocalMusicActivity.this.search_histroy_layout.setVisibility(8);
            SearchLocalMusicActivity.this.B4();
        }
    }

    public class f implements SwipeRecyclerView.d {
        public f() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void a() {
            SearchLocalMusicActivity.this.B4();
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void onRefresh() {
            SearchLocalMusicActivity.this.B4();
        }
    }

    public class g implements AutoRVAdapter.c {
        public g(SearchLocalMusicActivity searchLocalMusicActivity) {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.c
        public void a(int i, RVHolder rVHolder) {
        }
    }

    public class h extends TimerTask {
        public h(SearchLocalMusicActivity searchLocalMusicActivity) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (MusicControl.h0().d != null) {
                MusicControl.h0().d.h();
            }
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
            SearchLocalMusicActivity searchLocalMusicActivity = SearchLocalMusicActivity.this;
            if (searchLocalMusicActivity.a != null) {
                if (searchLocalMusicActivity.e >= 0) {
                    SearchLocalMusicActivity searchLocalMusicActivity2 = SearchLocalMusicActivity.this;
                    searchLocalMusicActivity2.a.notifyItemChanged(searchLocalMusicActivity2.e);
                }
                if (SearchLocalMusicActivity.this.f >= 0) {
                    SearchLocalMusicActivity searchLocalMusicActivity3 = SearchLocalMusicActivity.this;
                    searchLocalMusicActivity3.a.notifyItemChanged(searchLocalMusicActivity3.f);
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
            SearchLocalMusicActivity.this.rlIconMusicPanelRecord.setEnabled(true);
            SearchLocalMusicActivity.this.bibIconMusicPanelRecord.setEnabled(true);
            if (MusicControl.h0().f == null) {
                return;
            }
            pj3.f(SearchLocalMusicActivity.this, MusicRecordActivity.class);
        }
    }

    public final boolean A4() {
        if (!WearUtils.e1(this.search_edit_text.getText().toString())) {
            return true;
        }
        sg3.l(ah4.e(R.string.music_search_value_null));
        return false;
    }

    public void B4() {
        AutoRVAdapter autoRVAdapter;
        if (A4()) {
            ue3.a(this.search_edit_text, this);
            this.dot_songs.setVisibility(8);
            this.dot_artists.setVisibility(8);
            this.dot_albums.setVisibility(8);
            this.dot_playlist.setVisibility(8);
            this.musicSearchTracks.setChecked(false);
            this.musicSearchArtists.setChecked(false);
            this.musicSearchAlbums.setChecked(false);
            this.musicSearchPlaylists.setChecked(false);
            AutoRVAdapter autoRVAdapter2 = null;
            switch (this.c) {
                case R.id.music_search_albums /* 2131363858 */:
                    this.b.x(MusicControl.h0().d.f);
                    autoRVAdapter = this.b;
                    autoRVAdapter.u(null);
                    this.dot_albums.setVisibility(0);
                    this.musicSearchAlbums.setChecked(true);
                    autoRVAdapter2 = autoRVAdapter;
                    break;
                case R.id.music_search_artists /* 2131363859 */:
                    this.b.x(MusicControl.h0().d.e);
                    autoRVAdapter = this.b;
                    autoRVAdapter.u(null);
                    this.dot_artists.setVisibility(0);
                    this.musicSearchArtists.setChecked(true);
                    autoRVAdapter2 = autoRVAdapter;
                    break;
                case R.id.music_search_playlists /* 2131363860 */:
                    this.b.x(MusicControl.h0().z());
                    autoRVAdapter2 = this.b;
                    autoRVAdapter2.u(this.k);
                    this.dot_playlist.setVisibility(0);
                    this.musicSearchPlaylists.setChecked(true);
                    break;
                case R.id.music_search_tracks /* 2131363861 */:
                    this.a.w(MusicControl.h0().d.h);
                    autoRVAdapter = this.a;
                    autoRVAdapter.u(null);
                    this.dot_songs.setVisibility(0);
                    this.musicSearchTracks.setChecked(true);
                    autoRVAdapter2 = autoRVAdapter;
                    break;
            }
            autoRVAdapter2.t(this.j);
            autoRVAdapter2.s(this.search_edit_text.getText().toString());
            this.recyclerView.setAdapterSimple(autoRVAdapter2);
            this.recyclerView.s();
            this.recyclerView.setRefreshing(false);
            this.ll_result.setVisibility(0);
            if (autoRVAdapter2.getItemCount() > 0) {
                this.musicListEmpty.setVisibility(8);
                this.recyclerView.setVisibility(0);
            } else {
                this.musicListEmpty.setVisibility(0);
                this.recyclerView.setVisibility(8);
            }
        }
    }

    public final void C4(MusicPlaylist musicPlaylist) {
        if (musicPlaylist.getItemsList().size() > 0) {
            Bundle bundle = new Bundle();
            String strE = ah4.e(R.string.music_tab_playlist);
            switch (this.c) {
                case R.id.music_search_albums /* 2131363858 */:
                    strE = ah4.e(R.string.music_album_list);
                    break;
                case R.id.music_search_artists /* 2131363859 */:
                    strE = ah4.e(R.string.music_artist_list);
                    break;
            }
            bundle.putString(MessageBundle.TITLE_ENTRY, strE);
            bundle.putSerializable("playListItem", musicPlaylist);
            pj3.g(this, PlaylistDetailsActivity.class, bundle);
        }
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
        if (this.c == view.getId()) {
            return;
        }
        switch (view.getId()) {
            case R.id.bib_icon_music_panel_record /* 2131362142 */:
            case R.id.fl_sound_record /* 2131362781 */:
            case R.id.rl_icon_music_panel_record /* 2131364276 */:
                if (System.currentTimeMillis() - this.i < 500) {
                    return;
                }
                this.i = System.currentTimeMillis();
                if (!se3.c(this) && MusicControl.h0().f.getMusicType() == 1) {
                    sg3.e(this, R.string.music_record_net_connect_error_tip);
                    return;
                } else if (!na2.m().i()) {
                    if (MusicControl.h0().f.getMusicType() != 2) {
                        MusicControl.h0().B0();
                    }
                    new Handler().postDelayed(new j(), MusicControl.h0().f.getMusicType() == 0 ? 0L : 500L);
                    break;
                } else {
                    na2.m().t();
                    return;
                }
            case R.id.clear_histroy_lv /* 2131362392 */:
                this.d.b();
                return;
            case R.id.music_search_albums /* 2131363858 */:
                this.c = R.id.music_search_albums;
                break;
            case R.id.music_search_artists /* 2131363859 */:
                this.c = R.id.music_search_artists;
                break;
            case R.id.music_search_playlists /* 2131363860 */:
                this.c = R.id.music_search_playlists;
                break;
            case R.id.music_search_tracks /* 2131363861 */:
                this.c = R.id.music_search_tracks;
                break;
            case R.id.search_clean_bnt /* 2131364444 */:
                this.search_edit_text.setText("");
                this.search_histroy_layout.setVisibility(0);
                this.ll_result.setVisibility(8);
                return;
            case R.id.tv_cancel /* 2131364956 */:
                finish();
                return;
        }
        B4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_search);
        this.h = ButterKnife.bind(this);
        this.search_clean_bnt.setOnClickListener(this);
        this.tv_cancel.setOnClickListener(this);
        this.search_edit_text.setOnKeyListener(new c());
        this.search_edit_text.addTextChangedListener(new d());
        ho1 ho1Var = new ho1(this);
        this.d = ho1Var;
        this.search_histroy_lv.setAdapter((ListAdapter) ho1Var);
        this.search_histroy_lv.setOnItemClickListener(new e());
        this.clear_histroy_lv.setOnClickListener(this);
        this.musicSearchTracks.setOnClickListener(this);
        this.musicSearchArtists.setOnClickListener(this);
        this.musicSearchAlbums.setOnClickListener(this);
        this.musicSearchPlaylists.setOnClickListener(this);
        int intExtra = getIntent().getIntExtra("currentMusicTypeId", -1);
        this.c = R.id.music_search_tracks;
        if (intExtra != -1) {
            if (intExtra == R.id.music_album_list) {
                this.musicSearchAlbums.performClick();
            } else if (intExtra == R.id.music_artist_list) {
                this.musicSearchArtists.performClick();
            } else if (intExtra == R.id.music_song_list) {
                this.musicSearchTracks.performClick();
            }
        }
        this.recyclerView.getSwipeRefreshLayout().setColorSchemeColors(getResources().getColor(R.color.color_accent));
        this.recyclerView.getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setFooterView(new SimpleFooterView(this));
        this.recyclerView.setLoadMoreEnable(false);
        k12.m.d(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.g);
        MusicControl.h0().F0();
        this.a = new LocalMusicSearchAdapter(this);
        PlayListGroupAdapter playListGroupAdapter = new PlayListGroupAdapter(this, k12.m, 0);
        this.b = playListGroupAdapter;
        this.recyclerView.u(playListGroupAdapter);
        this.recyclerView.u(this.a);
        this.recyclerView.setAdapterSimple(this.a);
        this.recyclerView.setEmptyView(this.musicListEmpty);
        this.recyclerView.setOnLoadListener(new f());
        this.a.t(new g(this));
        this.mFlSoundRecord.setOnClickListener(this);
        this.bibIconMusicPanelRecord.setOnClickListener(this);
        this.rlIconMusicPanelRecord.setOnClickListener(this);
        f12 f12Var = MusicControl.h0().d;
        MusicControl.h0().d.h();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.h.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 24 && i2 != 25) {
            return super.onKeyDown(i2, keyEvent);
        }
        new Timer().schedule(new h(this), 100L);
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MusicNotificationEvent musicNotificationEvent) {
        B4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        k12.m.j(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.g);
    }
}
