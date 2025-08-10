package com.wear.main.closeRange.localMusic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.localmusic.PlayListGroupAdapter;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.event.MusicNotificationEvent;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldRadioButton;
import com.wear.widget.recycler.AutoRVAdapter;
import com.wear.widget.recycler.RVHolder;
import com.wear.widget.recycler.SwipeRecyclerView;
import com.wear.widget.recycler.footerView.SimpleFooterView;
import dc.ah4;
import dc.ho1;
import dc.k12;
import dc.kn3;
import dc.nf3;
import dc.nv1;
import dc.pj3;
import dc.sg3;
import dc.ue3;
import java.lang.reflect.InvocationTargetException;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class SearchPlayListActivity extends BaseActivity implements View.OnClickListener {
    public PlayListGroupAdapter a;

    @BindView(R.id.all_order)
    public LinearLayout allOrder;
    public ho1 b;

    @BindView(R.id.clear_histroy_lv)
    public TextView clear_histroy_lv;
    public Unbinder d;

    @BindView(R.id.dot_albums)
    public View dot_albums;

    @BindView(R.id.dot_artists)
    public View dot_artists;

    @BindView(R.id.dot_playlist)
    public View dot_playlist;

    @BindView(R.id.dot_songs)
    public View dot_songs;

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
    public MusicControl.f c = new f();
    public AutoRVAdapter.c e = new g();
    public AutoRVAdapter.d f = new h();

    public class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 1 || !SearchPlayListActivity.this.v4()) {
                return false;
            }
            SearchPlayListActivity.this.b.a(SearchPlayListActivity.this.search_edit_text.getText().toString());
            SearchPlayListActivity.this.search_histroy_layout.setVisibility(8);
            SearchPlayListActivity.this.w4();
            return false;
        }
    }

    public class b extends nv1 {
        public b() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SearchPlayListActivity.this.search_clean_bnt.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchPlayListActivity.this.b.b();
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchPlayListActivity searchPlayListActivity = SearchPlayListActivity.this;
            searchPlayListActivity.search_edit_text.setText(searchPlayListActivity.b.getItem(i).a());
            SearchPlayListActivity searchPlayListActivity2 = SearchPlayListActivity.this;
            searchPlayListActivity2.search_edit_text.setSelection(searchPlayListActivity2.b.getItem(i).a().length());
            SearchPlayListActivity.this.search_histroy_layout.setVisibility(8);
            SearchPlayListActivity.this.w4();
        }
    }

    public class e implements SwipeRecyclerView.d {
        public e() {
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void a() {
            SearchPlayListActivity.this.w4();
        }

        @Override // com.wear.widget.recycler.SwipeRecyclerView.d
        public void onRefresh() {
            SearchPlayListActivity.this.w4();
        }
    }

    public class f implements MusicControl.f {
        public f() {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void a(int i) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void b(boolean z) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void c(int i) {
            PlayListGroupAdapter playListGroupAdapter = SearchPlayListActivity.this.a;
            if (playListGroupAdapter != null) {
                playListGroupAdapter.notifyDataSetChanged();
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

    public class g implements AutoRVAdapter.c {

        public class a implements nf3.d {
            public final /* synthetic */ MusicPlaylist a;

            public a(MusicPlaylist musicPlaylist) {
                this.a = musicPlaylist;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) {
                SearchPlayListActivity.this.x4(this.a);
            }
        }

        public g() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.c
        public void a(int i, RVHolder rVHolder) {
            MusicPlaylist musicPlaylistV = SearchPlayListActivity.this.a.v(i);
            if (musicPlaylistV != null) {
                if (WearUtils.e1(musicPlaylistV.getTracksUrl())) {
                    SearchPlayListActivity.this.x4(musicPlaylistV);
                } else {
                    MusicControl.h0().m(musicPlaylistV, musicPlaylistV.getTracksUrl(), new a(musicPlaylistV));
                }
            }
        }
    }

    public class h implements AutoRVAdapter.d {

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
                SearchPlayListActivity.this.a.w(this.a);
            }
        }

        public h() {
        }

        @Override // com.wear.widget.recycler.AutoRVAdapter.d
        public void a(int i, RVHolder rVHolder) {
            if (!WearUtils.e1(SearchPlayListActivity.this.a.v(i).getTracksUrl())) {
                sg3.i(SearchPlayListActivity.this, R.string.remove_music_item_not_local);
                return;
            }
            kn3 kn3Var = new kn3((Context) SearchPlayListActivity.this, String.format(ah4.e(R.string.delete_music_playlist), SearchPlayListActivity.this.a.v(i).getName()), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new a(i));
            kn3Var.show();
            kn3Var.r();
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        MusicPlaylist musicPlaylist;
        super.onActivityResult(i, i2, intent);
        if (i != 24 || intent == null || (musicPlaylist = (MusicPlaylist) intent.getSerializableExtra("new_playlist_item")) == null) {
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
        int id = view.getId();
        if (id == R.id.music_search_playlists) {
            w4();
            return;
        }
        if (id != R.id.search_clean_bnt) {
            if (id != R.id.tv_cancel) {
                return;
            }
            finish();
        } else {
            this.search_edit_text.setText("");
            this.search_histroy_layout.setVisibility(0);
            this.ll_result.setVisibility(8);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_search);
        this.d = ButterKnife.bind(this);
        this.search_clean_bnt.setOnClickListener(this);
        this.tv_cancel.setOnClickListener(this);
        this.search_edit_text.setOnKeyListener(new a());
        this.search_edit_text.addTextChangedListener(new b());
        this.b = new ho1(this);
        this.clear_histroy_lv.setOnClickListener(new c());
        this.search_histroy_lv.setAdapter((ListAdapter) this.b);
        this.search_histroy_lv.setOnItemClickListener(new d());
        this.allOrder.setVisibility(8);
        this.musicSearchPlaylists.setOnClickListener(this);
        this.recyclerView.getSwipeRefreshLayout().setColorSchemeColors(getResources().getColor(R.color.color_accent));
        this.recyclerView.getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setFooterView(new SimpleFooterView(this));
        this.recyclerView.setLoadMoreEnable(false);
        PlayListGroupAdapter playListGroupAdapter = new PlayListGroupAdapter(this, k12.m, 0);
        this.a = playListGroupAdapter;
        this.recyclerView.u(playListGroupAdapter);
        this.recyclerView.setAdapterSimple(this.a);
        this.recyclerView.setEmptyView(this.musicListEmpty);
        this.recyclerView.setOnLoadListener(new e());
        k12.m.d(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.c);
        EventBus.getDefault().register(this);
        MusicControl.h0().r = false;
        MusicControl.h0().P();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MusicNotificationEvent musicNotificationEvent) {
        w4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        k12.m.j(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.c);
    }

    public final boolean v4() {
        if (!WearUtils.e1(this.search_edit_text.getText().toString())) {
            return true;
        }
        sg3.l(ah4.e(R.string.music_search_value_null));
        return false;
    }

    public void w4() {
        if (v4()) {
            ue3.a(this.search_edit_text, this);
            this.a.x(MusicControl.h0().z());
            PlayListGroupAdapter playListGroupAdapter = this.a;
            playListGroupAdapter.u(this.f);
            playListGroupAdapter.t(this.e);
            playListGroupAdapter.s(this.search_edit_text.getText().toString());
            this.recyclerView.setAdapterSimple(playListGroupAdapter);
            this.recyclerView.s();
            this.recyclerView.setRefreshing(false);
            this.ll_result.setVisibility(0);
            if (playListGroupAdapter.getItemCount() > 0) {
                this.musicListEmpty.setVisibility(8);
                this.recyclerView.setVisibility(0);
            } else {
                this.musicListEmpty.setVisibility(0);
                this.recyclerView.setVisibility(8);
            }
        }
    }

    public final void x4(MusicPlaylist musicPlaylist) {
        if (musicPlaylist.getItemsList().size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putString(MessageBundle.TITLE_ENTRY, ah4.e(R.string.music_tab_playlist));
            bundle.putSerializable("playListItem", musicPlaylist);
            pj3.g(this, PlaylistDetailsActivity.class, bundle);
        }
    }
}
