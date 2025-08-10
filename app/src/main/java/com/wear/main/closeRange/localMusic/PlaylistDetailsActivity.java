package com.wear.main.closeRange.localMusic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.wear.BaseActivity;
import com.wear.bean.Music;
import com.wear.bean.MusicCover;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.MusicPlaylistItems;
import com.wear.dao.DaoUtils;
import com.wear.dao.MusicDao;
import com.wear.dao.MusicPlaylistDao;
import com.wear.main.closeRange.MusicRecordActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.toy.ToyActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.ah4;
import dc.cf3;
import dc.gg3;
import dc.ik1;
import dc.k12;
import dc.kn3;
import dc.na2;
import dc.nf3;
import dc.pj3;
import dc.se3;
import dc.sg3;
import dc.sz1;
import dc.tz1;
import dc.yu3;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class PlaylistDetailsActivity extends BaseActivity implements View.OnClickListener, tz1 {
    public ik1 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public MusicPlaylist b;

    @BindView(R.id.bib_icon_music_panel_record)
    public View bibIconMusicPanelRecord;
    public boolean c;
    public View.OnClickListener e;
    public Unbinder g;

    @BindView(R.id.iv_music_play_status)
    public ImageView ivMusicPlayStatus;

    @BindView(R.id.fl_sound_record)
    public FrameLayout mFlSoundRecord;

    @BindView(R.id.music_list)
    public SlideAndDragListView music_list;

    @BindView(R.id.music_list_empty)
    public LinearLayout music_list_empty;

    @BindView(R.id.music_list_empty_no)
    public TextView music_list_empty_no;

    @BindView(R.id.music_list_empty_no_tip)
    public TextView music_list_empty_no_tip;

    @BindView(R.id.music_playall)
    public View music_playall;

    @BindView(R.id.music_playlist_item_cover)
    public ImageView music_playlist_item_cover;

    @BindView(R.id.music_playlist_item_create_time)
    public TextView music_playlist_item_create_time;

    @BindView(R.id.music_playlist_item_name)
    public TextView music_playlist_item_name;

    @BindView(R.id.music_playlist_item_songs)
    public TextView music_playlist_item_songs;

    @BindView(R.id.pb_music_loading)
    public ProgressBar pbMusicLoading;

    @BindView(R.id.rl_icon_music_panel_record)
    public RelativeLayout rlIconMusicPanelRecord;

    @BindView(R.id.swipe_refresh)
    public SwipyRefreshLayout swipeRefreshLayout;

    @BindView(R.id.vi_music_sort)
    public View vi_music_sort;
    public boolean d = false;
    public MusicControl.f f = new a();

    public class a implements MusicControl.f {
        public a() {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void a(int i) {
            PlaylistDetailsActivity.this.a.b = i;
            c(-1);
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void b(boolean z) {
            if (PlaylistDetailsActivity.this.isFinishing() || PlaylistDetailsActivity.this.isDestroyed()) {
                return;
            }
            if (!z) {
                PlaylistDetailsActivity.this.ivMusicPlayStatus.setVisibility(4);
                PlaylistDetailsActivity.this.pbMusicLoading.setVisibility(0);
                PlaylistDetailsActivity.this.music_playall.setOnClickListener(null);
            } else {
                PlaylistDetailsActivity.this.ivMusicPlayStatus.setVisibility(0);
                PlaylistDetailsActivity.this.pbMusicLoading.setVisibility(4);
                PlaylistDetailsActivity playlistDetailsActivity = PlaylistDetailsActivity.this;
                playlistDetailsActivity.music_playall.setOnClickListener(playlistDetailsActivity.e);
            }
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void c(int i) {
            PlaylistDetailsActivity.this.notifyDataSetChanged();
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void d(int i) {
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void e(boolean z) {
            ImageView imageView = PlaylistDetailsActivity.this.ivMusicPlayStatus;
            if (imageView != null) {
                if (z) {
                    imageView.setBackgroundResource(R.drawable.music_minibar_play_new);
                } else {
                    imageView.setBackgroundResource(R.drawable.music_minibar_pause_new);
                }
            }
            if (k12.m != null) {
                MusicControl.h0().A0(z);
            }
        }

        @Override // com.wear.main.closeRange.music.MusicControl.f
        public void f(int i, int i2, boolean z) {
        }
    }

    public class b implements kn3.d {
        public final /* synthetic */ int a;

        public class a implements nf3.d {
            public final /* synthetic */ MusicPlaylistItems a;
            public final /* synthetic */ Music b;

            /* renamed from: com.wear.main.closeRange.localMusic.PlaylistDetailsActivity$b$a$a, reason: collision with other inner class name */
            public class RunnableC0096a implements Runnable {
                public RunnableC0096a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    PlaylistDetailsActivity playlistDetailsActivity = PlaylistDetailsActivity.this;
                    playlistDetailsActivity.w4(playlistDetailsActivity.b, aVar.a);
                    sg3.l(String.format(ah4.e(R.string.remove_music_item_success), a.this.b.getTitle()));
                }
            }

            public a(MusicPlaylistItems musicPlaylistItems, Music music) {
                this.a = musicPlaylistItems;
                this.b = music;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) {
                PlaylistDetailsActivity.this.runOnUiThread(new RunnableC0096a());
            }
        }

        public b(int i) {
            this.a = i;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            PlaylistDetailsActivity.this.d = false;
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            PlaylistDetailsActivity.this.d = false;
            if (!MyApplication.Z && (!(WearUtils.e1(PlaylistDetailsActivity.this.b.getTracksUrl()) || MusicControl.h0().h(PlaylistDetailsActivity.this.b.getTracksUrl())) || WearUtils.e1(PlaylistDetailsActivity.this.b.getEmail()))) {
                sg3.l(ah4.e(R.string.remove_music_item_not_owner));
                return;
            }
            if (this.a >= PlaylistDetailsActivity.this.b.getMusics().size()) {
                return;
            }
            Music music = PlaylistDetailsActivity.this.b.getMusics().get(this.a);
            PlaylistDetailsActivity.this.b.getMusics().remove(music);
            MusicPlaylistItems musicPlaylistItems = PlaylistDetailsActivity.this.b.getItemsList().get(this.a);
            PlaylistDetailsActivity.this.b.getItemsList().remove(musicPlaylistItems);
            if (PlaylistDetailsActivity.this.b.getId().equals("-1")) {
                if (music.getMergerType() == 0) {
                    music.setIsFavorite(false);
                    DaoUtils.getMusicDao().update((MusicDao) music);
                    if (MusicControl.h0().d.d.get(music.getId()) != null) {
                        MusicControl.h0().d.d.get(music.getId()).setIsFavorite(false);
                    }
                } else {
                    MusicControl.h0().B(PlaylistDetailsActivity.this.b.getId(), music);
                }
                MusicPlaylist musicPlaylist = PlaylistDetailsActivity.this.b;
                musicPlaylist.setCover(cf3.i(WearUtils.x, musicPlaylist));
                MusicControl.h0().L0(PlaylistDetailsActivity.this.b);
                PlaylistDetailsActivity.this.S4();
            } else if (music.getMergerType() != 0) {
                MusicControl.h0().B(PlaylistDetailsActivity.this.b.getId(), music);
            } else {
                if (music.getMusicType() != 0) {
                    MusicControl.h0().C(PlaylistDetailsActivity.this.b.getId(), music.getData(), new a(musicPlaylistItems, music));
                    return;
                }
                DaoUtils.getMusicPlaylistItemsDao().delT(musicPlaylistItems);
            }
            PlaylistDetailsActivity playlistDetailsActivity = PlaylistDetailsActivity.this;
            playlistDetailsActivity.w4(playlistDetailsActivity.b, musicPlaylistItems);
            sg3.l(String.format(ah4.e(R.string.remove_music_item_success), music.getTitle()));
        }
    }

    public class c implements ImageLoadingListener {
        public c(PlaylistDetailsActivity playlistDetailsActivity) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ((ImageView) view).setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            if (view != null) {
                ((ImageView) view).setImageResource(R.drawable.musci_playlist_cover);
            }
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class d extends TimerTask {
        public d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (MusicControl.h0().d == null || !MusicControl.h0().d.h()) {
                return;
            }
            PlaylistDetailsActivity.this.y4();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public e(PlaylistDetailsActivity playlistDetailsActivity, int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a <= this.b) {
                k12.m.L.setVisibility(0);
            } else {
                k12.m.L.setVisibility(8);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlaylistDetailsActivity.this.rlIconMusicPanelRecord.setEnabled(true);
            PlaylistDetailsActivity.this.bibIconMusicPanelRecord.setEnabled(true);
            if (MusicControl.h0().f == null) {
                return;
            }
            pj3.f(PlaylistDetailsActivity.this, MusicRecordActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G4(View view) {
        pj3.f(this, ToyActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I4(AdapterView adapterView, View view, int i, long j) throws IllegalStateException {
        if (this.d) {
            return;
        }
        this.a.b = i;
        MusicControl.h0().F(this.b.getId(), this.b.getMusics());
        MusicControl.h0().s0(i);
        MusicControl.h0().E = this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean K4(AdapterView adapterView, View view, int i, long j) {
        P4(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M4(View view) throws IllegalStateException {
        if (this.d) {
            return;
        }
        if (MusicControl.h0().E != null && TextUtils.equals(MusicControl.h0().E.getId(), this.b.getId())) {
            MusicControl.h0().q0();
            return;
        }
        if (this.b.getItemsList() == null || this.b.getItemsList().size() <= 0) {
            return;
        }
        this.a.b = 0;
        MusicControl.h0().F(this.b.getId(), this.b.getMusics());
        MusicControl.h0().s0(0);
        MusicControl.h0().E = this.b;
        gg3.l(this.music_list, 0);
    }

    public final void A4() {
        this.music_list.setMenu(new yu3(false, 0));
        this.music_list.setEmptyView(this.music_list_empty);
        ik1 ik1Var = new ik1(this);
        this.a = ik1Var;
        ik1Var.d(this.b.getMusics());
        this.music_list.setAdapter((ListAdapter) this.a);
        this.music_list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: dc.d12
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) throws IllegalStateException {
                this.a.I4(adapterView, view, i, j);
            }
        });
        this.music_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: dc.b12
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                return this.a.K4(adapterView, view, i, j);
            }
        });
    }

    public final void B4(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        if (this.b.getCreated() != null) {
            this.music_playlist_item_create_time.setText(simpleDateFormat.format(this.b.getCreated()));
            return;
        }
        Date created = null;
        for (Music music : this.b.getMusics()) {
            if (music.getCreated() != null) {
                created = (created == null || music.getCreated().compareTo(created) <= 0) ? music.getCreated() : music.getCreated();
            }
        }
        if (created != null) {
            this.music_playlist_item_create_time.setText(simpleDateFormat.format(created));
        } else {
            this.music_playlist_item_create_time.setText(str);
        }
    }

    public final void C4() {
        this.vi_music_sort.setOnClickListener(this);
        if (WearUtils.e1(this.b.getTracksUrl()) && this.c) {
            this.vi_music_sort.setVisibility(0);
        } else {
            this.vi_music_sort.setVisibility(4);
        }
    }

    public final void D4() {
        this.swipeRefreshLayout.setEnabled(false);
        this.swipeRefreshLayout.setOnRefreshListener(null);
    }

    public final void E4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String stringExtra = getIntent().getStringExtra(MessageBundle.TITLE_ENTRY);
        z4(stringExtra);
        this.rlIconMusicPanelRecord.setVisibility(0);
        this.music_playlist_item_name.setText(this.b.getName() == null ? ah4.e(R.string.common_unknown) : this.b.getName());
        TextView textView = this.music_playlist_item_songs;
        String strE = ah4.e(R.string.music_play_all_songs);
        Object[] objArr = new Object[1];
        objArr[0] = this.b.getItemsList() == null ? "0" : Integer.valueOf(this.b.getItemsList().size());
        textView.setText(String.format(strE, objArr));
        A4();
        x4();
        C4();
        D4();
        B4(stringExtra);
        k12.m.d(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.f);
    }

    public final void N4() {
        if (this.b != null) {
            for (int i = 0; i < this.b.getItemsList().size(); i++) {
                MusicPlaylistItems musicPlaylistItems = this.b.getItemsList().get(i);
                if (musicPlaylistItems != null) {
                    musicPlaylistItems.getMusic().setFuncType(3);
                }
            }
        }
    }

    public final void O4() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: dc.e12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalStateException {
                this.a.M4(view);
            }
        };
        this.e = onClickListener;
        this.music_playall.setOnClickListener(onClickListener);
        this.bibIconMusicPanelRecord.setOnClickListener(this);
        this.rlIconMusicPanelRecord.setOnClickListener(this);
        this.mFlSoundRecord.setOnClickListener(this);
    }

    public final void P4(int i) {
        this.d = true;
        kn3 kn3Var = new kn3((Context) this, String.format(ah4.e(R.string.remove_music_item), this.a.getItem(i).getTitle()), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), false, (kn3.d) new b(i));
        kn3Var.show();
        kn3Var.r();
    }

    public final void Q4() {
        if (this.b.getItemsList().size() > 1) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("playListItem", this.b);
            pj3.g(this, SoreMusicPlaylistsActivity.class, bundle);
        }
    }

    public void R4() {
        if (k12.m != null) {
            MusicControl.h0().J0();
        }
    }

    public final void S4() {
        x4();
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    public void notifyDataSetChanged() {
        SlideAndDragListView slideAndDragListView = this.music_list;
        if (slideAndDragListView == null || slideAndDragListView.getAdapter() == null) {
            return;
        }
        this.a.notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        MusicPlaylist musicPlaylist;
        super.onActivityResult(i, i2, intent);
        if (i != 24 || intent == null || (musicPlaylist = (MusicPlaylist) intent.getSerializableExtra("new_playlist_item")) == null) {
            return;
        }
        MusicControl.h0().d.g.add(musicPlaylist);
        MusicControl.h0().d(musicPlaylist, 1);
        musicPlaylist.setCover(cf3.i(this, musicPlaylist));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.d = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bib_icon_music_panel_record /* 2131362142 */:
            case R.id.fl_sound_record /* 2131362781 */:
            case R.id.rl_icon_music_panel_record /* 2131364276 */:
                if (!se3.c(this) && MusicControl.h0().f.getMusicType() == 1) {
                    sg3.e(this, R.string.net_connect_error_tip);
                    break;
                } else if (!na2.m().i()) {
                    this.rlIconMusicPanelRecord.setEnabled(false);
                    this.bibIconMusicPanelRecord.setEnabled(false);
                    if (MusicControl.h0().f != null && MusicControl.h0().f.getMusicType() != 2) {
                        MusicControl.h0().B0();
                    }
                    if (MusicControl.h0().f != null) {
                        new Handler().postDelayed(new f(), MusicControl.h0().f.getMusicType() == 1 ? 500L : 0L);
                        break;
                    }
                } else {
                    na2.m().t();
                    break;
                }
                break;
            case R.id.music_like /* 2131363828 */:
                ImageView imageView = (ImageView) view;
                if (MusicControl.h0().f.isFavorite()) {
                    imageView.setImageResource(R.drawable.like_it);
                } else {
                    imageView.setImageResource(R.drawable.liked);
                }
                MusicControl.h0().f.setIsFavorite(!MusicControl.h0().f.isFavorite());
                DaoUtils.getMusicDao().update((MusicDao) MusicControl.h0().f);
                break;
            case R.id.vi_music_sort /* 2131365575 */:
                Q4();
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_playlist);
        this.g = ButterKnife.bind(this);
        Intent intent = getIntent();
        this.b = (MusicPlaylist) intent.getSerializableExtra("playListItem");
        this.c = intent.getBooleanExtra("isFromPlayList", false);
        N4();
        E4();
        O4();
        EventBus.getDefault().register(this);
        sz1.d().n(this);
        MusicControl.h0().r = false;
        MusicControl.h0().P();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.actionbar.s();
        this.g.unbind();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 24 && i != 25) {
            return super.onKeyDown(i, keyEvent);
        }
        new Timer().schedule(new d(), 100L);
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MusicCover musicCover) {
        for (MusicPlaylist musicPlaylist : MusicControl.h0().d.g) {
            if (musicPlaylist.getId().equals(musicCover.getPlayListId())) {
                this.b.setCover(musicPlaylist.getCover());
            }
        }
        S4();
        notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws IllegalStateException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        k12.m.j(this, findViewById(R.id.music_control_bar), findViewById(R.id.music_play_layer_placeholder), this.f);
        MusicPlaylist musicPlaylistF = MusicControl.h0().f(this.b.getId());
        if (musicPlaylistF != null) {
            this.b = musicPlaylistF;
            this.a.d(musicPlaylistF.getMusics());
            notifyDataSetChanged();
        }
        if (MusicControl.h0().s != 0) {
            MusicControl.h0().E0();
            MusicControl.h0().d.a();
            MusicControl.h0().e.a();
        }
        if (MusicControl.h0().O()) {
            k12.m.s(false);
        } else {
            k12.m.s(true);
        }
        if (MusicControl.h0().f == null) {
            findViewById(R.id.music_control_bar).setVisibility(8);
        } else if (MusicControl.h0().f.getMusicType() == 2) {
            findViewById(R.id.music_control_bar).setVisibility(0);
            MusicControl.h0().F0();
        } else {
            findViewById(R.id.music_control_bar).setVisibility(0);
            MusicControl.h0().H0();
        }
        MusicControl.h0().d.h();
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.tz1
    public void stop(int i) {
        R4();
    }

    public final void w4(MusicPlaylist musicPlaylist, MusicPlaylistItems musicPlaylistItems) {
        String imageUrl;
        musicPlaylist.setTotal(musicPlaylist.getMusics().size());
        if (musicPlaylist.getMusics().size() == 1) {
            Music music = musicPlaylist.getMusics().get(0);
            if (music.getMusicType() == 0) {
                imageUrl = "content://media/external/audio/albumart/" + music.getAlbumId();
            } else {
                imageUrl = music.getImageUrl();
            }
            musicPlaylist.setCover(imageUrl);
        }
        DaoUtils.getMusicPlaylistDao().update((MusicPlaylistDao) musicPlaylist);
        this.a.d(musicPlaylist.getMusics());
        this.a.notifyDataSetChanged();
        MusicPlaylist musicPlaylist2 = this.b;
        musicPlaylist2.setCover(cf3.i(this, musicPlaylist2));
        S4();
        EventBus.getDefault().post(musicPlaylistItems);
    }

    public final void x4() {
        String cover = this.b.getCover();
        if (WearUtils.e1(cover)) {
            return;
        }
        ImageLoader.getInstance().displayImage(cover, this.music_playlist_item_cover, new c(this));
    }

    public void y4() {
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        audioManager.getStreamMaxVolume(3);
        runOnMainThread(new e(this, audioManager.getStreamVolume(3), Build.VERSION.SDK_INT >= 28 ? audioManager.getStreamMinVolume(3) : 0));
    }

    public final void z4(String str) {
        if (!WearUtils.e1(str)) {
            this.actionbar.setTitle(str.substring(0, 1).toUpperCase() + str.substring(1));
        }
        this.actionbar.setToysAction(new MyActionBar.f() { // from class: dc.c12
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.G4(view);
            }
        }, false, this);
        this.actionbar.n();
    }
}
